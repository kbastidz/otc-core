package org.rec.mso.core.configuration.config;

import org.rec.mso.core.configuration.filter.JwtAuthenticationFilter;
import org.rec.mso.core.utils.enums.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class HttpSecurityConfig {
    @Autowired
    private JwtAuthenticationFilter authenticationFilter;
    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class)
                //.cors(AbstractHttpConfigurer::disable)
                .cors(Customizer.withDefaults())
                .authorizeHttpRequests(getAuthorizationManagerRequestMatcherRegistryCustomizer());
        return http.build();

    }

    private static Customizer<AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry> getAuthorizationManagerRequestMatcherRegistryCustomizer() {
        return (api) -> {
            // Permitir acceso público a las rutas de Swagger
            api.requestMatchers(
                    "/v3/api-docs/**",
                    "/swagger-ui/**",
                    "/swagger-ui.html"
            ).permitAll();

            // public
            api.requestMatchers(HttpMethod.GET, "/product/list").permitAll();
            api.requestMatchers(HttpMethod.GET, "/product/{id}").permitAll();
            api.requestMatchers(HttpMethod.POST, "/api/v1/OTC/authentication/login").permitAll();
            api.requestMatchers(HttpMethod.POST, "/api/v1/OTC/authentication/sign").permitAll();

            api.requestMatchers(HttpMethod.GET, "/api/v1/personuser/consultPerson").permitAll();
            api.requestMatchers(HttpMethod.GET, "/api/v1/personuser/consultPersonId/{id}").permitAll();
            api.requestMatchers(HttpMethod.POST, "/api/v1/personuser/registerUser").permitAll();
            api.requestMatchers(HttpMethod.PUT, "/api/v1/personuser/updateUser").permitAll();
            api.requestMatchers("/error").permitAll();
            // Private
            api.requestMatchers(HttpMethod.POST, "/product/add/").hasAnyAuthority(Permission.SAVE_ONE_PRODUCT.name());
            api.requestMatchers(HttpMethod.PUT, "/product/update/{id}/").hasAnyAuthority(Permission.SAVE_ONE_PRODUCT.name());
            api.requestMatchers(HttpMethod.DELETE, "/product/{id}/").hasAnyAuthority(Permission.SAVE_ONE_PRODUCT.name());

            //api.requestMatchers(HttpMethod.POST, "/api/v1/personuser/registerUser").hasAnyAuthority(Permission.SAVE_ONE_PRODUCT.name());
            //api.requestMatchers(HttpMethod.PUT, "/api/v1/personuser/updateUser").hasAnyAuthority(Permission.SAVE_ONE_PRODUCT.name());

            api.anyRequest().authenticated();
        };
    }

}
