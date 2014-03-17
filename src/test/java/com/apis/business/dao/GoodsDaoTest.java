package com.apis.business.dao;
import com.apis.business.dao.impl.*;
import com.apis.business.entity.Enterprise;
import com.apis.business.entity.Goods;
import com.apis.business.entity.GoodsType;

public class GoodsDaoTest {
	
	public static void main(String[] args){
		Goods goods = new Goods();
		GoodsTypeDaoImpl goodsTypeDao = new GoodsTypeDaoImpl();
		GoodsType goodsType = goodsTypeDao.getById(1);
		
		goods.setId(1);
		goods.setType(goodsType);
		goods.setName("apis company");
		goods.setDescription("this is a company founded by hongchun.li");
		
		
		GoodsDaoImpl dao = new GoodsDaoImpl();
		dao.save(goods);
		
		try {
			dao.deleteById(1111111);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println(e1.getMessage());
		}
	}
}
