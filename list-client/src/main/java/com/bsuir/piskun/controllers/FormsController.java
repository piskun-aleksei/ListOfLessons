package com.bsuir.piskun.controllers;

import com.bsuir.piskun.beans.Lesson;
import com.bsuir.piskun.beans.Room;
import com.bsuir.piskun.beans.Student;
import com.bsuir.piskun.beans.Teacher;
import com.bsuir.piskun.constants.LessonType;
import com.bsuir.piskun.exceptions.ServiceException;
import com.bsuir.piskun.services.AuthorizationService;
import com.bsuir.piskun.services.GroupService;
import com.bsuir.piskun.services.LessonService;
import com.bsuir.piskun.services.RoomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import util.DecodeHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
public class FormsController {

    Logger logger = LoggerFactory.getLogger(FormsController.class);

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
            HttpSession session = request.getSession();
            String lessonName = DecodeHelper.decode(request.getParameter("lessonName"));
            String lessonType = request.getParameter("lessonType");
            Lesson lesson = new Lesson();
            lesson.setLessonName(lessonName);
            lesson.setLessonType(LessonType.getLessonTypeByValue(lessonType));
            lessonService.insert(lesson);
            session.setAttribute("currentPage", "formLesson");
            model.setViewName("formLesson");
        } catch (ServiceException | UnsupportedEncodingException e) {
            logger.error("Exception", e);
        }
        return model;
    }

    @RequestMapping(value = "/formsSchedule", method = RequestMethod.GET)
    public ModelAndView getFormsSchedule(HttpServletRequest request) {
        ModelAndView model = new ModelAndView();
        HttpSession session = request.getSession();

        List<Lesson> lessonList = null;
        List<Teacher> teacherList = null;
        List<Room> roomList = null;
        try {
            lessonList = lessonService.select();
            teacherList = authorizationService.selectTeachers();
            roomList = roomService.select();
        } catch (ServiceException e) {
            logger.error("Service exception", e);
        }
        session.setAttribute("lessonList", lessonList);
        session.setAttribute("teacherList", teacherList);
        session.setAttribute("roomList", roomList);
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

    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public ModelAndView addFormsStudent(HttpServletRequest request) {
        ModelAndView model = new ModelAndView();
        try {
            HttpSession session = request.getSession();
            String cardNumber = DecodeHelper.decode(request.getParameter("studentCard"));
            String name = DecodeHelper.decode(request.getParameter("studentName"));
            String surname = DecodeHelper.decode(request.getParameter("studentSurname"));
            String group = DecodeHelper.decode(request.getParameter("studentGroup"));
            Student student = new Student();
            student.setStudentCardNumber(cardNumber);
            student.setStudentName(name);
            student.setStudentSurname(surname);
            authorizationService.insertStudent(student, group);
            session.setAttribute("currentPage", "formStudent");
            model.setViewName("formStudent");
        } catch (ServiceException | UnsupportedEncodingException e) {
            logger.error("Exception", e);
        }

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

    @RequestMapping(value = "/addRoom", method = RequestMethod.POST)
    public ModelAndView addFormsRoom(HttpServletRequest request) {
        ModelAndView model = new ModelAndView();
        try {

            HttpSession session = request.getSession();
            String roomNumber = DecodeHelper.decode(request.getParameter("roomNumber"));
            Room room = new Room();
            room.setRoomNumber(roomNumber);
            roomService.insert(room);
            session.setAttribute("currentPage", "formRoom");
            model.setViewName("formRoom");
        } catch (ServiceException | UnsupportedEncodingException e) {
            logger.error("Exception", e);
        }
        return model;
    }

}
