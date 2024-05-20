package com.lkcoffee.controller;

import com.lkcoffee.pojo.Product;
import com.lkcoffee.pojo.ProductPageQuery;
import com.lkcoffee.result.PageResult;
import com.lkcoffee.result.Result;
import com.lkcoffee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 陈志雄
 * @version V1.0
 * @Description
 * @Package com.lkcoffee.controller
 * @date 2024/5/20 1:28
 */
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;


    @GetMapping("/{id}")
    public Result<Product> getById(@PathVariable Long id){
        Product product = productService.getById(id);
        return Result.success(product);
    }

    @PostMapping
    public Result save(@RequestBody Product product){
        productService.save(product);
        return Result.success();
    }
    /**
     * 修改商品状态
     * @param
     * @author create by ChenZhixiong on
     */
    @PutMapping("{status}")
    public Result setActive(@PathVariable Long status,Long id){
        productService.setActive(status,id);
        return Result.success();
    }
    @GetMapping("/page")
    public Result<PageResult> page(ProductPageQuery productPageQuery){
        PageResult page = productService.pageQuery(productPageQuery);
        return Result.success(page);
    }
    @PutMapping
    public Result update(@RequestBody Product product){
        productService.update(product);
        return  Result.success();
    }
}
