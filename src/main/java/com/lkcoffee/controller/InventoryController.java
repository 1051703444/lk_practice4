package com.lkcoffee.controller;

import com.lkcoffee.pojo.Inventory;
import com.lkcoffee.pojo.InventoryPageQuery;
import com.lkcoffee.pojo.InventoryVO;
import com.lkcoffee.result.PageResult;
import com.lkcoffee.result.Result;
import com.lkcoffee.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 陈志雄
 * @version V1.0
 * @Description
 * @Package com.lkcoffee.controller
 * @date 2024/5/20 3:51
 */
@RestController
@RequestMapping("/inventory")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;
    @PostMapping
    public Result save(@RequestBody Inventory inventory){
        inventoryService.save(inventory);
        return Result.success();
    }
    @GetMapping("/{id}")
    public Result<InventoryVO> getById(@PathVariable Long id){
        InventoryVO inventoryVO = inventoryService.getById(id);
        return Result.success(inventoryVO);
    }

    @GetMapping("/page")
    public Result<PageResult> pageQuery(@RequestBody InventoryPageQuery inventoryPageQuery){
        PageResult pageResult = inventoryService.pageQuery(inventoryPageQuery);
        return Result.success(pageResult);
    }
    @PutMapping
    public Result update(@RequestBody Inventory inventory){
        inventoryService.update(inventory);
        return Result.success();
    }
    @DeleteMapping
    public Result deleteById(Long id){
        inventoryService.deleteById(id);
        return Result.success();
    }



}
