package com.apis.business.service.impl;

import com.apis.business.dao.impl.GoodsDaoImpl;
import com.apis.business.entity.Goods;
import com.apis.business.service.GoodsService;
import com.apis.common.service.impl.BaseServiceImpl;

public class GoodsServiceImpl extends BaseServiceImpl<Goods> implements GoodsService<Goods> {
	
	public GoodsServiceImpl(){
		this.setDao(new GoodsDaoImpl());
	}
	
}
