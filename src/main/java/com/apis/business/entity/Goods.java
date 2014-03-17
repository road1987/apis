/**  
* @author hongchun.li  
* @date 2013-4-20 下午07:00:22
* @version V1.0  
*/ 
package com.apis.business.entity;


/**
 * @author hongchun.li
 *
 */
public class Goods{
	
	private Integer id;
	private String code;
	private String name;
	private float price;
	private String description;
	private GoodsType type;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}

	public void setType(GoodsType type) {
		this.type = type;
	}

	public GoodsType getType() {
		return this.type;
	}
}
