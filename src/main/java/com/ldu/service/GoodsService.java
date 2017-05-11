package com.ldu.service;

import java.util.List;

import com.ldu.pojo.Catelog;
import com.ldu.pojo.Goods;

public interface GoodsService {
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
	public void updateGoodsByPrimaryKeyWithBLOBs(int id ,Goods goods);
	
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
	
	/**
	 * 根据时间排序获取商品，进行分页
	 * @param firstResult 从第几个结果开始
	 * @param maxResults  获取多少结果
	 * @return
	 */
	public List<Goods> getGoodsByDate(int page,int maxResults);
	
}
