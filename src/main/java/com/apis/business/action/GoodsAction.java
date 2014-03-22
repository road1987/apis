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
import com.apis.business.service.GoodsService;
import com.apis.business.service.impl.GoodsServiceImpl;


@Controller
public class GoodsAction {
	GoodsService service  = new GoodsServiceImpl();
	
	@RequestMapping("/goods/list")
    public ModelAndView list(HttpServletRequest req, HttpServletResponse resp) throws Exception {  
		
       ModelAndView mv = new ModelAndView();  
       mv.addObject("goodsList" , service.getList());
       mv.setViewName("goods/list");  
       return mv;  
    }

    @RequestMapping("goods/delete/{goodsId}")
    public String delete(@PathVariable("goodsId") int goodsId) {
 
    	service.deleteById(goodsId);
 
        return "redirect:/goods/list";
    }
    
    @RequestMapping(value = "goods/add", method = RequestMethod.GET)
    public ModelAndView addForm() {
    	ModelAndView mv = new ModelAndView();  
    	mv.setViewName("goods/add");
        return mv;
    }
    
    @RequestMapping(value = "goods/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("goods")
	Goods goods, BindingResult result) {
    	
    	service.save(goods);
 
        return "redirect:/goods/list";
    }
    
    @RequestMapping(value = "goods/update/{goodsId}", method = RequestMethod.GET)
    public ModelAndView updateForm(@PathVariable("goodsId") int goodsId) {
    	
        ModelAndView mv = new ModelAndView();  
        mv.addObject("goods" , service.getById(goodsId));
        mv.setViewName("goods/update");
        return mv;
    }
    
    @RequestMapping(value = "goods/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("goods")
	Goods goods, BindingResult result) {
    	
    	service.update(goods);
        return "redirect:/goods/list";
    }
}
