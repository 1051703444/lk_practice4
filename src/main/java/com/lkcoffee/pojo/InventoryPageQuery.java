package com.lkcoffee.pojo;

import lombok.Data;

/**
 * @author 陈志雄
 * @version V1.0
 * @Description
 * @Package com.lkcoffee.pojo.dto
 * @date 2024/5/20 10:51
 */
@Data
public class InventoryPageQuery {

    //页码
    private int page;

    //每页显示记录数
    private int pageSize;

}
