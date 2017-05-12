package com.ldu.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ldu.pojo.Catelog;
import com.ldu.pojo.Goods;
import com.ldu.service.GoodsService;

@Controller
@RequestMapping(value = "/goods")
public class GoodsController {

	@Autowired
	private GoodsService goodsService;

	/**
	 * 首页显示商品，每一类商品查询6件，根据最新上架排序 key的命名为catelogGoods1、catelogGoods2....
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/homeGoods")
	public ModelAndView homeGoods() throws Exception {
		List<Goods> goods = null;

		ModelAndView modelAndView = new ModelAndView();
		int catelogSize = 7;
		for (int i = 1; i < catelogSize; i++) {
			goods = goodsService.getGoodsByCatelogOrderByDate(i);
			String key = "catelog" + "Goods" + i;
			modelAndView.addObject(key, goods);
		}
		modelAndView.setViewName("goods/homeGoods");
		return modelAndView;
	}

	/**
	 * 查询该类商品
	 * 
	 * @param catelog
	 *            要求该参数不为空
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/catelogGoods")
	public ModelAndView catelogGoods(
			@RequestParam(value = "catelog", required = true) Catelog catelog)
			throws Exception {
		List<Goods> goods = goodsService.getGoodsByCatelog(catelog);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("goods", goods);
		modelAndView.setViewName("goods/homeGoods");
		return modelAndView;
	}

	/**
	 * 修改商品信息
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/editGoods")
	public ModelAndView editGoods(Integer id) throws Exception {

		Goods goods = goodsService.getGoodsByPrimaryKey(id);
		ModelAndView modelAndView = new ModelAndView();

		// 讲商品信息添加到model
		modelAndView.addObject("goods", goods);

		modelAndView.setViewName("goods/editGoods");

		return null;
	}

	/**
	 * 提交商品更改信息
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/editGoodsSubmit")
	public String editGoodsSubmit(Integer id, Goods goods) throws Exception {
		goodsService.updateGoodsByPrimaryKeyWithBLOBs(id, goods);
		return "goods/homeGoods";
	}

	/**
	 * 商品下架
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/offGoods")
	public ModelAndView offGoods() throws Exception {

		return null;
	}

	/**
	 * 管理员删除商品
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteGoods")
	public ModelAndView deleteGoods() throws Exception {

		return null;
	}

	/**
	 * 发布商品
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/publishGoods")
	public String publishGoods() throws Exception {
		return "goods/publishGoodsSubmit";
	}

	/**
	 * 提交发布的商品信息
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("publishGoodsSubmit")
	public String publishGoodsSubmit(HttpSession session, Goods goods)
			throws Exception {
		Integer userId = (Integer) session.getAttribute("userId");
		goods.setId(userId);
		goodsService.addGood(goods);
		return "goods/publishGoodsSubmit";
	}
}
