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

    <form class="form-horizontal custom-form" action="addLesson">
        <div class="form-group">
            <input type="text" class="form-control" placeholder="Название занятия">
        </div>
        <div class="form-group">
            <select class="form-control">
                <option>Lab</option>
                <option>Pract</option>
            </select>
        </div>

         <button type="button" onclick="parentNode.submit();" id="formButton" class="btn btn-success button-schedule">
                Add
         </button>

         <input type="hidden" name="cmd" value="addLesson"/>
    </form>

</div>
</body>














