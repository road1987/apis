/**  
* @author hongchun.li  
* @date 2013-4-20 下午07:10:26
* @version V1.0  
*/ 
package com.apis.business.entity;

/**
 * @author hongchun.li
 *
 */
public class Enterprise {
	private Integer id;
	private String name;
	private String fax;
	private String telephone;
	private String address;
	private String description;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getFax() {
		return fax;
	}
	
	public void setFax(String fax) {
		this.fax = fax;
	}
	
	public String getTelephone() {
		return telephone;
	}
	
	
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
}
