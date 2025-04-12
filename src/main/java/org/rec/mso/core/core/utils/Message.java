package org.rec.mso.core.utils;

public record Message() {
    public static final String NOT_FOUND_PRODUCT = "product not found";
    public static final String ALREADY_EXISTS = "Lo sentimos.. El registro ya existe." ;

   public static final String SUCCESSFULLY_REMOVED = "product removed successfully";
   public static final String USERNAME_ALREADY_EXISTS = "there is already a user with this";
   public static final String JWT_EXPIRED = "static token expired";

}
