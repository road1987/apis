package com.apis.business.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.apis.business.service.EnterpriseService;
import com.apis.business.service.impl.EnterpriseServiceImpl;


@Controller
public class EnterpriseAction {
	EnterpriseService service  = new EnterpriseServiceImpl();
	
	@RequestMapping("/enterprise/list")
    public ModelAndView list(HttpServletRequest req, HttpServletResponse resp) throws Exception {  
       ModelAndView mv = new ModelAndView();  
       
       mv.addObject("enterpriseList" , service.getList());
       mv.addObject("message", "Hello World!");  
       mv.setViewName("enterprise/list");  

       return mv;  
    }


    @RequestMapping("enterprise/delete/{contactId}")
    public String deleteContact(@PathVariable("contactId")
    int contactId) {
 
    	service.deleteById(contactId);
 
        return "redirect:/enterprise/list";
    }
}
