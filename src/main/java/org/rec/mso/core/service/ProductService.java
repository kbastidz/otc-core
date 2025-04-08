package org.rec.mso.core.service;

import lombok.NonNull;
import org.rec.mso.core.entity.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProduct();

    Product getProduct(@NonNull Long id);

    Product saveProduct(Product body);

    Product updateProduct(@NonNull Long id, @NonNull Product body);

    void deleteProduct(@NonNull Long id);
}
