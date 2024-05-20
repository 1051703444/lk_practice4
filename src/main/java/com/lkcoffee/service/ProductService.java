package com.lkcoffee.service;

import com.lkcoffee.pojo.Product;
import com.lkcoffee.pojo.ProductPageQuery;
import com.lkcoffee.result.PageResult;

/**
 * @author 陈志雄
 * @version V1.0
 * @Description
 * @Package com.lkcoffee.service
 * @date 2024/5/20 1:28
 */

public interface ProductService {

    public Product getById(Long id);

    void save(Product product);

    void setActive(Long status,Long id);



    PageResult pageQuery(ProductPageQuery productPageQuery);

    void update(Product product);
}
