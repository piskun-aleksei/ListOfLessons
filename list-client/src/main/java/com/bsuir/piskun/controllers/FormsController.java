package com.bsuir.piskun.controllers;

import com.bsuir.piskun.beans.Lesson;
import com.bsuir.piskun.constants.LessonType;
import com.bsuir.piskun.exceptions.ServiceException;
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
import java.io.UnsupportedEncodingException;

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

    @RequestMapping(value = "/addLesson", method = RequestMethod.POST)
    public ModelAndView addFormsLesson(HttpServletRequest request) {
        ModelAndView model = new ModelAndView();
        try {
            request.setCharacterEncoding("windows-1251");

            HttpSession session = request.getSession();
            String lessonName = request.getParameter("lessonName");
            String lessonType = request.getParameter("lessonType");
            Lesson lesson = new Lesson();
            lesson.setLessonName(lessonName);
            lesson.setLessonType(LessonType.getLessonTypeByValue(lessonType));

            lessonService.insert(lesson);

            session.setAttribute("currentPage", "formLesson");
            model.setViewName("formLesson");
        } catch (ServiceException | UnsupportedEncodingException e) {
            //TODO log this
        }

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
