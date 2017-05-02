package com.bsuir.piskun.controllers;

import com.bsuir.piskun.beans.User;
import com.bsuir.piskun.exceptions.ServiceException;
import com.bsuir.piskun.services.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private AuthorizationService authorizationService;

    @RequestMapping(value = {"/", "/public**"}, method = RequestMethod.GET)
    public ModelAndView requestPublic() {
        ModelAndView model = new ModelAndView();
        model.setViewName("login");
        return model;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(HttpServletRequest request) {
        ModelAndView model = new ModelAndView();
        try {
            HttpSession session = request.getSession();
            User user = authorizationService.select(request.getParameter("login"), request.getParameter("password"));
            session.setAttribute("login", user.getLogin());
            model.setViewName("login");
        } catch (ServiceException e) {
            //TODO.. Something
        }
        return model;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout(HttpServletRequest request) {
        ModelAndView model = new ModelAndView();
        HttpSession session = request.getSession();
        session.setAttribute("login", null);
        model.setViewName("login");
        return model;
    }
}
