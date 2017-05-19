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

    @RequestMapping(value = "/formsLesson", method = RequestMethod.GET)
    public ModelAndView getFormsLesson(HttpServletRequest request) {
        ModelAndView model = new ModelAndView();
        HttpSession session = request.getSession();

        session.setAttribute("currentPage", "formLesson");
        model.setViewName("formLesson");
        return model;
    }

    @RequestMapping(value = "/formsSchedule", method = RequestMethod.GET)
    public ModelAndView getFormsSchedule(HttpServletRequest request) {
        ModelAndView model = new ModelAndView();
        HttpSession session = request.getSession();

        session.setAttribute("currentPage", "formSchedule");
        model.setViewName("formSchedule");
        return model;
    }

    @RequestMapping(value = "/formsStudent", method = RequestMethod.GET)
    public ModelAndView getFormsStudent(HttpServletRequest request) {
        ModelAndView model = new ModelAndView();
        HttpSession session = request.getSession();

        session.setAttribute("currentPage", "formStudent");
        model.setViewName("formStudent");
        return model;
    }

    @RequestMapping(value = "/formsRoom", method = RequestMethod.GET)
    public ModelAndView getFormsRoom(HttpServletRequest request) {
        ModelAndView model = new ModelAndView();
        HttpSession session = request.getSession();

        session.setAttribute("currentPage", "formRoom");
        model.setViewName("formRoom");
        return model;
    }
}
