package com.bsuir.piskun.controllers;

import com.bsuir.piskun.beans.Lesson;
import com.bsuir.piskun.beans.User;
import com.bsuir.piskun.exceptions.ServiceException;
import com.bsuir.piskun.services.AuthorizationService;
import com.bsuir.piskun.services.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private AuthorizationService authorizationService;

    @Autowired
    private LessonService lessonService;

    @RequestMapping(value = {"/", "/public**"}, method = RequestMethod.GET)
    public ModelAndView requestPublic(HttpServletRequest request) {
        ModelAndView model = new ModelAndView();
        HttpSession session = request.getSession();
        List<Lesson> lessonList = null;
        try {
            lessonList = lessonService.select();
        } catch (ServiceException e) {
            //TODO log this
        }
        session.setAttribute("lessonList", lessonList);
        session.setAttribute("currentPage", "login");
        session.setAttribute("currentRank", 0);
        model.setViewName("login");
        return model;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(HttpServletRequest request) {
        ModelAndView model = new ModelAndView();
        try {
            HttpSession session = request.getSession();
            User user = authorizationService.select(request.getParameter("login"), request.getParameter("password"));
            if (user != null) {
                session.setAttribute("currentLogin", user.getLogin());
                session.setAttribute("currentRank", user.getRank());
            }
            model.setViewName((String) session.getAttribute("currentPage"));
        } catch (ServiceException e) {
            //TODO.. Something
        }
        return model;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout(HttpServletRequest request) {
        ModelAndView model = new ModelAndView();
        HttpSession session = request.getSession();
        session.setAttribute("currentLogin", null);
        session.setAttribute("currentRank", 0);
        model.setViewName((String) session.getAttribute("currentPage"));
        return model;
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView home(HttpServletRequest request) {
        ModelAndView model = new ModelAndView();
        HttpSession session = request.getSession();
        session.setAttribute("currentPage", "login");
        model.setViewName("login");
        return model;
    }
}
