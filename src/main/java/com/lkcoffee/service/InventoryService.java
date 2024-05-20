package com.lkcoffee.service;

import com.lkcoffee.pojo.Inventory;
import com.lkcoffee.pojo.InventoryPageQuery;
import com.lkcoffee.pojo.InventoryVO;
import com.lkcoffee.result.PageResult;

/**
 * @author 陈志雄
 * @version V1.0
 * @Description
 * @Package com.lkcoffee.service
 * @date 2024/5/20 9:41
 */
public interface InventoryService {
    void save(Inventory inventory);

    InventoryVO getById(Long id);

    PageResult pageQuery(InventoryPageQuery inventoryPageQuery);

    void update(Inventory inventory);

    void deleteById(Long id);
}
