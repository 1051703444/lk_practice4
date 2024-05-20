package com.lkcoffee.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 陈志雄
 * @version V1.0
 * @Description
 * @Package com.lkcoffee.pojo.vo
 * @date 2024/5/20 10:37
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InventoryVO {
    private Integer inventoryId;
    private Integer quantity;
    private Product product;
}
