package com.ldu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.ldu.dao.GoodsMapper;
import com.ldu.pojo.Catelog;
import com.ldu.pojo.Goods;
import com.ldu.service.GoodService;
/**
 * 对商品的操作类（增删改查）
 * @ClassName 	GoodServiceImpl
 * @author 		逯其鲁
 * @date		2017-5-9下午9:22:24
 */
public class GoodServiceImpl implements GoodService {
	
	@Resource
	private GoodsMapper goodsMapper;
	
	@Override
	public void addGood(Goods goods) {
		goodsMapper.insert(goods);
	}

	@Override
	public Goods getGoodsByPrimaryKey(Integer id) {
		Goods goods = this.goodsMapper.selectByPrimaryKey(id);
		return goods;
	}

	@Override
	public void updateGoods(Goods goods) {
		this.goodsMapper.updateByPrimaryKey(goods);
	}

	@Override
	public void deleteGoodsByPrimaryKey(Integer id) {
		this.goodsMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<Goods> getAllGoods() {
		List<Goods> goods = this.goodsMapper.selectAllGoods();
		return goods;
	}

	@Override
	public List<Goods> getGoodsByCatelog(Catelog catelog) {
		List<Goods> goods = this.getGoodsByCatelog(catelog);
		return goods;
	}
	
}
