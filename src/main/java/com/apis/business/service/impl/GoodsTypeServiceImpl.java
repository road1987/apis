package com.apis.business.service.impl;

import com.apis.business.dao.impl.GoodsTypeDaoImpl;
import com.apis.business.entity.GoodsType;
import com.apis.business.service.GoodsTypeService;
import com.apis.common.service.impl.BaseServiceImpl;

public class GoodsTypeServiceImpl extends BaseServiceImpl<GoodsType> implements GoodsTypeService<GoodsType> {
	
	public GoodsTypeServiceImpl(){
		this.setDao(new GoodsTypeDaoImpl());
	}
	
}
