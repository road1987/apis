package com.apis.business.dao;
import com.apis.business.dao.impl.*;
import com.apis.business.entity.Enterprise;

public class enterpriseDaoTest {
	
	public static void main(String[] args){
		Enterprise e = new Enterprise();
		e.setId(1);
		e.setName("apis company");
		e.setDescription("this is a company founded by hongchun.li");
		
		
		EnterpriseDaoImpl dao = new EnterpriseDaoImpl();
		//dao.save(e);
		
		try {
			dao.deleteById(1111111);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println(e1.getMessage());
		}
	}
}
