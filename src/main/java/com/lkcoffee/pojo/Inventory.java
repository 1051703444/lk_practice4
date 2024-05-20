package com.lkcoffee.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 陈志雄
 * @version V1.0
 * @Description
 * @Package com.lkcoffee.model
 * @date 2024/5/11 15:25
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Inventory {
    private Integer inventoryId;
    private Integer quantity;
    private Long productId;
}
