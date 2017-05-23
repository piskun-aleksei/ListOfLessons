<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<html>
<head>
    <title>Forms</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
</head>

<body>

<div class="container">

    <jsp:include page="./common/header.jsp"/>

    <form class="form-horizontal custom-form" action="addSchedule">
        <div class="form-group">
            <input type="text" class="form-control" name="scheduleDate" placeholder="Дата">
        </div>
        <div class="form-group">
            <input type="text" class="form-control" name="scheduleGroup" placeholder="Номер группы">
        </div>
        <div class="form-group">
            <select class="form-control" name="scheduleTeacher">
                <c:forEach var="teacher" items="${teacherList}" varStatus="status">
                    <option value="${teacher.teacherId}">${teacher.teacherName} ${teacher.teacherSurname}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <select class="form-control" name="scheduleRoom">
                <c:forEach var="room" items="${roomList}" varStatus="status">
                    <option value="${room.roomId}">${room.roomNumber}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <select class="form-control" name="scheduleLesson">
                <c:forEach var="lesson" items="${lessonList}" varStatus="status">
                    <option value="${lesson.lessonId}">${lesson.lessonName}(${lesson.lessonType.value})</option>
                </c:forEach>
            </select>
        </div>

        <button type="button" onclick="parentNode.submit();" id="formButton" class="btn btn-success button-schedule">
            Добавить занятие
        </button>

        <input type="hidden" name="cmd" value="addSchedule"/>
    </form>
</div>
</body>














