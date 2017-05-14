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
        GroupSchedule groupSchedule = null;
        try {
            groupSchedule = scheduleService.select(group, 1);
        } catch (ServiceException e) {
            //TODO log this...
        }
        session.setAttribute("lessons", groupSchedule.getCalendarLessons());
        session.setAttribute("students", groupSchedule.getStudentMarks());
        session.setAttribute("currentPage", "schedule");
        model.setViewName("schedule");
        return model;
    }
}
