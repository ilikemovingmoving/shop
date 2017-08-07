package com.taotao.portal.controller;

import com.taotao.portal.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController{

    @Autowired
    private AdService adService;

   /* @RequestMapping("/index")
    public String index(){
        return "index";
    }*/


    @RequestMapping("/index")
    public String showIndex(Model model) throws Exception {
        String adResult = adService.getAdItemList();
        model.addAttribute("ad1", adResult);
        return "index";
    }

}
