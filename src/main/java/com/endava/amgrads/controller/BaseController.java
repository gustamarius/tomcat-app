package com.endava.amgrads.controller;

import com.endava.amgrads.model.User;
import com.endava.amgrads.service.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class BaseController {



    @Autowired
    private GeneralService generalService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String addStudent (ModelMap model) {

        String date = generalService.getDate();
        String localIP = generalService.getIP();
        // Spring uses InternalResourceViewResolver and return back index.jsp

        model.addAttribute("data",date);
        model.addAttribute("localIP",localIP);

        return "index";
    }



}
