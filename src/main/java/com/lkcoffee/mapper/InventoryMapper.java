package com.lkcoffee.mapper;

import com.github.pagehelper.Page;
import com.lkcoffee.pojo.Inventory;
import com.lkcoffee.pojo.Product;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author 陈志雄
 * @version V1.0
 * @Description
 * @Package com.lkcoffee.mapper
 * @date 2024/5/20 9:41
 */
@Mapper
public interface InventoryMapper {
    @Insert("insert into inventory (inventory_id,quantity,product_id) values(#{inventoryId},#{quantity},#{productId})")
    public void save(Inventory inventory);

    @Select("select * from inventory where inventory_id=#{id}")
    Inventory getById(Long id);

    @Select("select * from inventory")
    Page<Inventory> pageQuery();

    void update(Inventory inventory);

    @Delete("delete from inventory where inventory_id=#{id}")
    void deleteById(Long id);
}
