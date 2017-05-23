<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<html>
<head>
    <title>Forms</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>

<body>

<div class="container">

    <jsp:include page="./common/header.jsp"/>

    <form class="form-horizontal custom-form" method="post" action="addLesson">
        <div class="form-group">
            <input type="text" name="lessonName" class="form-control" placeholder="Название занятия">
        </div>
        <div class="form-group">
            <select name="lessonType" class="form-control">
                <option>Laboratory</option>
                <option>Practical</option>
                <option>Lecture</option>
                <option>Test</option>
                <option>Exam</option>
            </select>
        </div>

         <button type="button" onclick="parentNode.submit();" id="formButton" class="btn btn-success button-schedule">
                Добавить предмет
         </button>

         <input type="hidden" name="cmd" value="addLesson"/>
    </form>

</div>
</body>














