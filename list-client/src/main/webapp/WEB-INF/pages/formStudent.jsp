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

    <form class="form-horizontal custom-form" method="post" action="addStudent">
        <div class="form-group">
            <input type="text" class="form-control" name="studentCard" placeholder="Номер студенческого">
        </div>
        <div class="form-group">
            <input type="text" class="form-control" name="studentName" placeholder="Имя">
        </div>
        <div class="form-group">
            <input type="text" class="form-control" name="studentSurname" placeholder="Фамилия">
        </div>
        <div class="form-group">
            <input type="text" class="form-control" name="studentGroup" placeholder="Группа">
        </div>

        <button type="button" onclick="parentNode.submit();" id="formButton" class="btn btn-success button-schedule">
                Добавить студента
        </button>

        <input type="hidden" name="cmd" value="addStudent"/>
    </form>
</div>
</body>














