package com.ldu.dao;

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
     * 通过参数查询
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKeyWithBLOBs(Goods record);

    int updateByPrimaryKey(Goods record);
}