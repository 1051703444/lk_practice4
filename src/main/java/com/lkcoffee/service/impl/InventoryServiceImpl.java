package com.lkcoffee.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lkcoffee.exception.DeletionNotAllowedException;
import com.lkcoffee.mapper.InventoryMapper;
import com.lkcoffee.mapper.ProductMapper;
import com.lkcoffee.pojo.Inventory;
import com.lkcoffee.pojo.InventoryPageQuery;
import com.lkcoffee.pojo.Product;
import com.lkcoffee.pojo.InventoryVO;
import com.lkcoffee.result.PageResult;
import com.lkcoffee.service.InventoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 陈志雄
 * @version V1.0
 * @Description
 * @Package com.lkcoffee.service.impl
 * @date 2024/5/20 9:41
 */
@Service
public class InventoryServiceImpl implements InventoryService {
    @Autowired
    private InventoryMapper inventoryMapper;
    @Autowired
    private ProductMapper productMapper;
    @Override
    public void save(Inventory inventory) {
        inventoryMapper.save(inventory);
    }

    @Override
    public InventoryVO getById(Long id) {
        Inventory inventory = inventoryMapper.getById(id);
        InventoryVO inventoryVO = new InventoryVO();
        BeanUtils.copyProperties(inventory, inventoryVO);
        Long productId = inventory.getProductId();
        Product product = productMapper.getByProductId(productId);
        inventoryVO.setProduct(product);
        return inventoryVO;
    }

    public PageResult pageQuery(InventoryPageQuery inventoryPageQuery) {
        PageHelper.startPage(inventoryPageQuery.getPage(), inventoryPageQuery.getPageSize());

        Page<Inventory> page = inventoryMapper.pageQuery();//后续定义

        long total = page.getTotal();
        List<Inventory> records = page.getResult();

        return new PageResult(total, records);
    }

    @Override
    public void update(Inventory inventory) {
        inventoryMapper.update(inventory);
    }

    @Override
    @Transactional//事务
    public void deleteById(Long id) {
        Inventory inventory = inventoryMapper.getById(id);
        Long productId = inventory.getProductId();
        Product product = productMapper.getByProductId(productId);
        if(product ==null){
            inventoryMapper.deleteById(id);
        }else{
            if (product.getIsActive()==1){
                //商品上架中，不能删除
                throw new DeletionNotAllowedException("商品上架中，不能删除");
            }else{
                inventoryMapper.deleteById(id);
                productMapper.deleteById(productId);
            }
        }

    }
}
