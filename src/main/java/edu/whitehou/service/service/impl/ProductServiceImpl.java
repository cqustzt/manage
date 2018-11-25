package edu.whitehou.service.service.impl;

import edu.whitehou.entity.Product;
import edu.whitehou.mapper.ProductMapper;
import edu.whitehou.service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productMapper;

    @Override
    public Collection<Product> findAllProduct() {
        return productMapper.findAllProduct();
    }

    @Override
    public Product findProductById(Integer id) {
        return productMapper.findProductById(id);
    }

    @Override
    public void addProduct(Product product) {
        productMapper.addProduct(product);
    }

    @Override
    public void updateProduct(Product product) {
        productMapper.updateProduct(product);
    }

    @Override
    public void deleteProduct(Integer id) {
        productMapper.deleteProduct(id);
    }

}
