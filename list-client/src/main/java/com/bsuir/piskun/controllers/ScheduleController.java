package com.bsuir.piskun.controllers;

import com.bsuir.piskun.beans.GroupSchedule;
import com.bsuir.piskun.exceptions.ServiceException;
import com.bsuir.piskun.services.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @RequestMapping(value = "/schedule", method = RequestMethod.GET)
    public ModelAndView getSchedule(HttpServletRequest request) {
        ModelAndView model = new ModelAndView();
        HttpSession session = request.getSession();
        String group = request.getParameter("userGroup");
        int lessonId = Integer.parseInt(request.getParameter("lessonId"));
        session.setAttribute("currentUserGroup", group);
        session.setAttribute("currentLessonId", new Integer(lessonId).toString());
        GroupSchedule groupSchedule = null;
        try {
            groupSchedule = scheduleService.select(group, lessonId);
        } catch (ServiceException e) {
            //TODO log this...
        }
        session.setAttribute("scheduleTeacherId", groupSchedule.getCalendarLessons().get(0).getTeacher().getTeacherId());
        session.setAttribute("lessons", groupSchedule.getCalendarLessons());
        session.setAttribute("students", groupSchedule.getStudentMarks());
        session.setAttribute("currentPage", "schedule");
        model.setViewName("schedule");
        return model;
    }

    @RequestMapping(value = "/changeMark", method = RequestMethod.POST)
    public ModelAndView changeMark(HttpServletRequest request) {
        ModelAndView model = new ModelAndView();
        HttpSession session = request.getSession();
        int mark = Integer.parseInt(request.getParameter("studentMark"));
        int scheduleId = Integer.parseInt(request.getParameter("scheduleId"));
        int studentId = Integer.parseInt(request.getParameter("studentId"));
        String group = (String)session.getAttribute("currentUserGroup");
        int lessonId = Integer.parseInt((String)session.getAttribute("currentLessonId"));
        GroupSchedule groupSchedule = null;
        try {
           scheduleService.setMark(mark, studentId, scheduleId);
           groupSchedule = scheduleService.select(group, lessonId);
        } catch (ServiceException e) {
            //TODO log this...
        }
        session.setAttribute("scheduleTeacherId", groupSchedule.getCalendarLessons().get(0).getTeacher().getTeacherId());
        session.setAttribute("lessons", groupSchedule.getCalendarLessons());
        session.setAttribute("students", groupSchedule.getStudentMarks());
        session.setAttribute("currentPage", "schedule");
        model.setViewName("schedule");
        return model;
    }
}
