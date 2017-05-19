package com.bsuir.piskun.controllers;

import com.bsuir.piskun.services.AuthorizationService;
import com.bsuir.piskun.services.GroupService;
import com.bsuir.piskun.services.LessonService;
import com.bsuir.piskun.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class FormsController {

    @Autowired
    private AuthorizationService authorizationService;

    @Autowired
    private LessonService lessonService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private GroupService groupService;

    @RequestMapping(value = "/forms", method = RequestMethod.GET)
    public ModelAndView getForms(HttpServletRequest request) {
        ModelAndView model = new ModelAndView();
        HttpSession session = request.getSession();

        session.setAttribute("currentPage", "forms");
        model.setViewName("forms");
        return model;
    }
}
