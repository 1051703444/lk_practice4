package com.lkcoffee.pojo;

import lombok.Data;

/**
 * @author 陈志雄
 * @version V1.0
 * @Description
 * @Package com.lkcoffee.pojo
 * @date 2024/5/20 3:10
 */
@Data
public class ProductPageQuery {
    //商品名称
    private String name;

    //页码
    private int page;

    //每页显示记录数
    private int pageSize;

}
