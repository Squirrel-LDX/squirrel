package com.ldu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ldu.dao.GoodsMapper;
import com.ldu.pojo.Catelog;
import com.ldu.pojo.Goods;
import com.ldu.service.GoodsService;
/**
 * 对商品的操作类（增删改查）
 * @ClassName 	GoodServiceImpl
 * @author 		逯其鲁
 * @date		2017-5-9下午9:22:24
 */

@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {
	
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
		List<Goods> goods = goodsMapper.selectByCatelog(catelog.getId());
		return goods;
	}

	@Override
	public void updateGoodsByPrimaryKeyWithBLOBs(int id,Goods goods) {
		goods.setId(id);
		this.goodsMapper.updateByPrimaryKeyWithBLOBs(goods);
	}

	@Override
	public List<Goods> getGoodsByCatelogOrderByDate(Integer catelogId) {
		
		List<Goods> goods = goodsMapper.selectByCatelogOrderByDate(catelogId);
		return goods;
	}
	
}
