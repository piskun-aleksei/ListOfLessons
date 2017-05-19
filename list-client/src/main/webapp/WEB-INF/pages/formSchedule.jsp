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
            <input type="text" class="form-control" placeholder="Дата">
        </div>
        <div class="form-group">
            <input type="text" class="form-control" placeholder="Номер группы">
        </div>
        <div class="form-group">
            <select class="form-control">
                <option>Кухарчук</option>
                <option>Калабухов</option>
            </select>
        </div>
        <div class="form-group">
            <select class="form-control">
                <option>514</option>
                <option>501</option>
            </select>
        </div>
        <div class="form-group">
            <select class="form-control">
                <option>КПП</option>
                <option>КПИЯП</option>
            </select>
        </div>

        <button type="button" onclick="parentNode.submit();" id="formButton" class="btn btn-success button-schedule">
                Add
        </button>

        <input type="hidden" name="cmd" value="addSchedule"/>
    </form>
</div>
</body>














