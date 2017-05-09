package com.ldu.service;

import java.util.List;

import com.ldu.pojo.Catelog;
import com.ldu.pojo.Goods;

public interface GoodService {
	/**
	 * 添加商品
	 * @param goods
	 */
	public void addGood(Goods goods);
	
	/**
	 * 通过主键获取商品
	 * @param id
	 * @return
	 */
	public Goods getGoodsByPrimaryKey(Integer id);
	
	/**
	 * 更新商品信息
	 * @param goods
	 */
	public void updateGoods(Goods goods);
	
	/**
	 * 通过主键删除商品
	 * @param id
	 */
	public void deleteGoodsByPrimaryKey(Integer id);
	
	/**
	 * 获取所有商品信息
	 */
	public List<Goods> getAllGoods();
	
	/**
	 * 通过商品分类获取商品信息
	 */
	public List<Goods> getGoodsByCatelog(Catelog catelog);
}
