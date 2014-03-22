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

import com.apis.business.entity.Enterprise;
import com.apis.business.service.EnterpriseService;
import com.apis.business.service.impl.EnterpriseServiceImpl;


@Controller
public class EnterpriseAction {
	EnterpriseService service  = new EnterpriseServiceImpl();
	
	@RequestMapping("/enterprise/list")
    public ModelAndView list(HttpServletRequest req, HttpServletResponse resp) throws Exception {  
		
       ModelAndView mv = new ModelAndView();  
       mv.addObject("enterpriseList" , service.getList());
       mv.setViewName("enterprise/list");  
       return mv;  
    }

    @RequestMapping("enterprise/delete/{enterpriseId}")
    public String delete(@PathVariable("enterpriseId") int enterpriseId) {
 
    	service.deleteById(enterpriseId);
 
        return "redirect:/enterprise/list";
    }
    
    
    @RequestMapping(value = "enterprise/add", method = RequestMethod.GET)
    public ModelAndView addForm(@ModelAttribute("enterprise")
	Enterprise enterprise, BindingResult result) {
    	ModelAndView mv = new ModelAndView();  
    	mv.setViewName("enterprise/add");
        return mv;
    }
    
    @RequestMapping(value = "enterprise/add", method = RequestMethod.POST)
    public String add(@ModelAttribute("enterprise")
	Enterprise enterprise, BindingResult result) {
    	
    	service.save(enterprise);
 
        return "redirect:/enterprise/list";
    }
    
    @RequestMapping(value = "enterprise/update/{enterpriseId}", method = RequestMethod.GET)
    public ModelAndView updateForm(@PathVariable("enterpriseId") int enterpriseId) {
    	
        ModelAndView mv = new ModelAndView();  
        mv.addObject("enterprise" , service.getById(enterpriseId));
        mv.setViewName("enterprise/update");  
        return mv;
    }
    
    @RequestMapping(value = "enterprise/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("enterprise")
	Enterprise enterprise, BindingResult result) {
    	
    	service.update(enterprise);
        return "redirect:/enterprise/list";
    }
}
