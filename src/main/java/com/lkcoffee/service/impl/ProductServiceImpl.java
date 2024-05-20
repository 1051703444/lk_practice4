package com.lkcoffee.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lkcoffee.mapper.ProductMapper;
import com.lkcoffee.pojo.Product;
import com.lkcoffee.pojo.ProductPageQuery;
import com.lkcoffee.result.PageResult;
import com.lkcoffee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 陈志雄
 * @version V1.0
 * @Description
 * @Package com.lkcoffee.service.impl
 * @date 2024/5/20 1:29
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    public Product getById(Long id){
        Product product = productMapper.getByProductId(id);
        return product;
    }

    @Override
    public void save(Product product) {
        productMapper.save(product);
    }

    @Override
    public void setActive(Long status,Long id) {
        Product product = Product.builder()
                .productId(id)
                .isActive(status)
                .build();
        productMapper.update(product);
    }

    @Override
    public PageResult pageQuery(ProductPageQuery productPageQuery) {
        PageHelper.startPage(productPageQuery.getPage(), productPageQuery.getPageSize());

        Page<Product> page = productMapper.pageQuery(productPageQuery);//后续定义

        long total = page.getTotal();
        List<Product> records = page.getResult();

        return new PageResult(total, records);
    }

    @Override
    public void update(Product product) {
        productMapper.update(product);
    }
}
