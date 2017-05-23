<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<html>
<head>
    <title>Group</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
</head>

<body>
<div class="container">
    <jsp:include page="./common/header.jsp"/>

    <div class="jumbotron">
        <h1 class="display-3">Журнал занятий</h1>
        <p class="lead">
            Добро пожаловать в электронную систему по учету успеваемости и посещаемости студентов.
        </p>


        <c:if test="${currentLogin == null}">
            <p class="lead">
                Пожалуйста, войдите в систему, чтобы иметь доступ к полному спектру возможностей.
            </p>
            <form class="form" role="form" method="get" action="loginPage">
                <a class="btn btn-lg btn-success" href="javascript:;" onclick="parentNode.submit();">Войти в систему</a>
                <input type="hidden" name="cmd" value="loginPage"/>
            </form>
        </c:if>
    </div>
</div>
</body>
</html>