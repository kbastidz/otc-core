package org.rec.mso.core.service.impl;

import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
import org.rec.mso.core.exeptions.InvalidProductExeptions;
import org.rec.mso.core.exeptions.NotFoundProductExeptions;
import org.rec.mso.core.entity.models.Product;
import org.rec.mso.core.repository.IProductRepository;
import org.rec.mso.core.service.ProductService;
import org.rec.mso.core.utils.Message;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Log4j2
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private IProductRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<Product> getAllProduct() {
        log.info(" LISTADO DE PRODUCTO ");
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Product getProduct(@NonNull Long id) {
        log.info(" PRODUCTO ");
        return repository.findById(id).orElseThrow(() -> new NotFoundProductExeptions(Message.NOT_FOUND_PRODUCT, HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND));
    }

    @Transactional
    @Override
    public Product saveProduct(Product body) {
      Optional<Product> productId = repository.findByName(body.getName());
      if(productId.isPresent()){
          throw new InvalidProductExeptions(Message.PRODUCT_ALREADY_EXISTS,HttpStatus.CONFLICT.value(),HttpStatus.CONFLICT);
      }
        log.info("SAVE");
        return repository.save(body);
    }
    @Transactional
    @Override
    public Product updateProduct(@NonNull Long id, @NonNull Product body) {
        Product product = repository.findById(id).orElseThrow(( ) -> new NotFoundProductExeptions(Message.NOT_FOUND_PRODUCT, HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND));
        BeanUtils.copyProperties(body, product, "id", "createAt");
        Product updateProduct = product;
        return repository.save(updateProduct);
    }

    @Transactional
    @Override
    public void deleteProduct(@NonNull Long id) {
        Objects.requireNonNull(id, "Product body must not be null");
        Product product = repository.findById(id).orElseThrow(() -> new NotFoundProductExeptions(Message.NOT_FOUND_PRODUCT, HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND));
        repository.delete(product);

    }
}
