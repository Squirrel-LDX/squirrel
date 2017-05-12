package com.ldu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ldu.dao.GoodsMapper;
import com.ldu.pojo.Catelog;
import com.ldu.pojo.Goods;
import com.ldu.service.GoodsService;
import com.ldu.util.DateUtil;
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
	public void addGood(Integer userId , Goods goods , Integer duration) {
		String startTime = DateUtil.getNowDay();
		String endTime = DateUtil.getLastTime(startTime, duration);
		String polishTime = startTime;
		//添加上架时间，下架时间，擦亮时间
		goods.setPolishTime(polishTime);
		goods.setEndTime(endTime);
		goods.setStartTime(startTime);
		goods.setUserId(userId);
		goodsMapper.insertSelective(goods);
	}

	@Override
	public Goods getGoodsByPrimaryKey(Integer goodsId) {
		Goods goods = this.goodsMapper.selectByPrimaryKey(goodsId);
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
	public void updateGoodsByPrimaryKeyWithBLOBs(int goodsId,Goods goods) {
		goods.setId(goodsId);
		this.goodsMapper.updateByPrimaryKeyWithBLOBs(goods);
	}

	@Override
	public List<Goods> getGoodsByCatelogOrderByDate(Integer catelogId,Integer limit) {
		
		List<Goods> goods = goodsMapper.selectByCatelogOrderByDate(catelogId , limit);
		return goods;
	}
	
}
