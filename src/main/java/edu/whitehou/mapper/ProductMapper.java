package edu.whitehou.mapper;

import edu.whitehou.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * @author : white.hou
 * @description :
 * @date: 2018/11/25_15:22
 */
@Repository
public interface ProductMapper {
    /**
     *列表展示所有商品
     * @return
     */
    Collection<Product> findAllProduct();

    /**
     * 修改商品时列表回显
     * @param id
     * @return
     */
    Product findProductById(Integer id);

    /**
     * 新增商品
     * @param product
     * @return
     */
    void addProduct(Product product);

    /**
     * 修改商品
     * @param product
     * @return
     */
    void updateProduct(Product product);

    /**
     * 删除商品
     * @param id
     * @return
     */
    void deleteProduct(Integer id);
}
