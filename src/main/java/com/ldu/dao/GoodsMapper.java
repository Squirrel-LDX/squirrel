package com.ldu.dao;

import java.util.List;

import com.ldu.pojo.Catelog;
import com.ldu.pojo.Goods;

public interface GoodsMapper {
	/**
	 * 通过主键删除
	 * @param id
	 * @return
	 */
    int deleteByPrimaryKey(Integer id);

    /**
     * 添加物品
     * @param record
     * @return
     */
    int insert(Goods record);

    /**
     * 
     * @param record
     * @return
     */
    int insertSelective(Goods record);

    /**
     * 通过id查询
     * @param id
     * @return
     */
    Goods selectByPrimaryKey(Integer id);

    /**
     * 通过主键更改信息
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Goods record);

    /**
     * 通过主键和blobs更改信息
     * @param record
     * @return
     */
    int updateByPrimaryKeyWithBLOBs(Goods record);

    /**
     * 通过主键更改信息
     * @param record
     * @return
     */
    int updateByPrimaryKey(Goods record);
    
    /**
     * 查询所有的商品
     * 未在xml中实现
     * @return
     */
    public List<Goods> selectAllGoods();
    
    /**
     * 根据商品分类，查询商品
     * 未在xml中实现
     * @param catelog
     * @return
     */
    public List<Goods> selectByCatelog(Catelog catelog);
}