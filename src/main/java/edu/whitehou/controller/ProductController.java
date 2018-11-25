package edu.whitehou.controller;

import edu.whitehou.entity.Product;
import edu.whitehou.entity.Root;
import edu.whitehou.service.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * 后台管理中商品的controller层
 * @author :whitehou
 */
@Controller
public class ProductController {
    @Autowired
    ProductService productService;
    @GetMapping("/products")
    public String findAllProduct(Model  model){
        Collection<Product> allProduct = productService.findAllProduct();
        model.addAttribute("products",allProduct);
        return "product/list";
    }
    /**
     * 跳转到添加页面
     * @return
     */
    @GetMapping("/product")
    public String toAddProduct(){
        return "product/add";
    }


    @PostMapping("/product")
    public String addProduct(Product product){
        try{
            productService.addProduct(product);
        }catch (Exception e){
            Logger logger=LoggerFactory.getLogger(getClass());
            logger.warn("请检查您的输入");
            e.printStackTrace();
        }
        return  "redirect:/products";
    }

    /**
     * 跳转到编辑页面，编辑添加二合一
     * @param id
     * @return
     */
    @GetMapping("/product/{id}")
    public String toEdit(@PathVariable("id") Integer id,Model model){
        Product productById = productService.findProductById(id);
        model.addAttribute("product",productById);
        return "product/add";
    }
    /**
     * 修改管理员信息
     * @param product
     * @return
     */
    @PutMapping("/product")
    public String updateRoot(Product product){
        try {
            productService.updateProduct(product);
        }catch (Exception e){
            e.printStackTrace();
        }
        return  "redirect:/products";
    }
    /**
     * 删除指定员工
     * @param id
     * @return
     */
    @DeleteMapping("/product/{id}")
    public String deleteRoot(@PathVariable("id") Integer id){
        productService.deleteProduct(id);
        return "redirect:/products";
    }

}
