package edu.whitehou.service.service;

import edu.whitehou.entity.Product;
import org.springframework.stereotype.Service;

import java.util.Collection;


public interface ProductService {
    /**
     * 查询所有商品
     * @return
     */
    Collection<Product> findAllProduct();

    /**
     * 根据id查询 商品
     */
    Product findProductById(Integer id);

    /**
     *新增商品
     */
    void addProduct(Product product);

    /**
     * 修改商品信息
     * @param product
     */
    void updateProduct(Product product);

    /**
     * 删除商品
     */
    void deleteProduct(Integer id);
}
