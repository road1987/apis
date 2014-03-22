package com.apis.business.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.apis.business.entity.Goods;
import com.apis.business.entity.GoodsType;
import com.apis.business.service.GoodsService;
import com.apis.business.service.GoodsTypeService;
import com.apis.business.service.impl.GoodsServiceImpl;
import com.apis.business.service.impl.GoodsTypeServiceImpl;


@Controller
public class GoodsTypeAction {
	GoodsTypeService service  = new GoodsTypeServiceImpl();
	
	@RequestMapping("/goodstype/list")
    public ModelAndView list(HttpServletRequest req, HttpServletResponse resp) throws Exception {  
		
       ModelAndView mv = new ModelAndView();  
       mv.addObject("goodsTypeList" , service.getList());
       mv.setViewName("goodstype/list");  
       return mv;  
    }

    @RequestMapping("goodstype/delete/{goodsTypeId}")
    public String delete(@PathVariable("goodsTypeId") int goodsTypeId) {
 
    	service.deleteById(goodsTypeId);
 
        return "redirect:/goodstype/list";
    }
    
    @RequestMapping(value = "goodstype/add", method = RequestMethod.GET)
    public ModelAndView addForm() {
    	ModelAndView mv = new ModelAndView();  
    	mv.setViewName("goodstype/add");
        return mv;
    }
    
    @RequestMapping(value = "goodstype/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("goodsType")
	GoodsType goodsType, BindingResult result) {
    	
    	service.save(goodsType);
 
        return "redirect:/goodstype/list";
    }
    
    @RequestMapping(value = "goodstype/update/{goodsTypeId}", method = RequestMethod.GET)
    public ModelAndView updateForm(@PathVariable("goodsTypeId") int goodsTypeId) {
    	
        ModelAndView mv = new ModelAndView();  
        mv.addObject("goodsType" , service.getById(goodsTypeId));
        mv.setViewName("goodstype/update");
        return mv;
    }
    
    @RequestMapping(value = "goodstype/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("goodsType")
	GoodsType goodsType, BindingResult result) {
    	
    	service.update(goodsType);
        return "redirect:/goodstype/list";
    }
}
