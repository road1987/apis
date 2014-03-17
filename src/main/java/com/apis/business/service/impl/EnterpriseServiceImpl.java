package com.apis.business.service.impl;

import com.apis.business.dao.impl.EnterpriseDaoImpl;
import com.apis.business.entity.Enterprise;
import com.apis.business.service.EnterpriseService;
import com.apis.common.service.impl.BaseServiceImpl;

public class EnterpriseServiceImpl extends BaseServiceImpl<Enterprise> implements EnterpriseService<Enterprise> {
	
	public EnterpriseServiceImpl(){
		this.setDao(new EnterpriseDaoImpl());
	}
	
}
