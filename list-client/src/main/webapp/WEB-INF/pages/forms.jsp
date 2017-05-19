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


    <form class="form-horizontal custom-form">
        <div class="form-group">
            <input type="text" class="form-control input-lg" placeholder="Большой">
        </div>
        <div class="form-group">
            <select class="form-control input-lg">
                <option>Средний - 1</option>
                <option>Средний - 2</option>
            </select>
        </div>
        <div class="form-group">
            <select class="form-control input-lg">
                <option>Маленький - 1</option>
                <option>Маленький - 2</option>
            </select>
        </div>
    </form>
</div>
</body>














