package com.lkcoffee.mapper;

import com.github.pagehelper.Page;
import com.lkcoffee.pojo.Product;
import com.lkcoffee.pojo.ProductPageQuery;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author 陈志雄
 * @version V1.0
 * @Description
 * @Package com.lkcoffee.mapper
 * @date 2024/5/20 1:29
 */
@Mapper
public interface ProductMapper {
    /**
     * 通过Id对产品进行查询
     * @param id
     * @author create by ChenZhixiong on
     */
    @Select("select * from product where product_id = #{id}")
    Product getByProductId(Long id);

    /**
     * 添加产品
     * @param
     * @author create by ChenZhixiong on
     */
    @Insert("insert into product (product_id,name,price,is_active) values(#{productId},#{name},#{price},#{isActive})")
    void save(Product product);

    /**
     * 修改商品
     * @param product
     * @author create by ChenZhixiong on
     */

    void update(Product product);

    Page<Product> pageQuery(ProductPageQuery productPageQuery);

    @Delete("delete from product where product_id=#{id}")
    void deleteById(Long id);
}
