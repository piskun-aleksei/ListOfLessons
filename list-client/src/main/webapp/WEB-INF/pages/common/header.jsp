<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<html>
<head>
    <spring:url value="/resources/css/author-form.css" var="authorcss"/>
    <link href="${authorcss}" rel="stylesheet"/>

    <spring:url value="/resources/css/tables.css" var="tablescss"/>
    <link href="${tablescss}" rel="stylesheet"/>

    <link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Roboto'>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


    <spring:url value="/resources/js/tables.js" var="tablesjs"/>
    <script src="${tablesjs}"></script>

    <spring:url value="/resources/js/header.js" var="headerjs"/>
    <script src="${headerjs}"></script>


</head>
<body>
<nav class="navbar navbar-default navbar-inverse" role="navigation">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <span class="navbar-brand">
                <c:if test="${currentLogin != null}">
                    Login is: ${currentLogin}
                </c:if>
                <c:if test="${currentLogin == null}">
                    You are not logged in
                </c:if>
            </span>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Navigation<span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li>
                            <form class="form" role="form" method="get" action="schedule" id="scheduleForm">
                                <input type="text" id="userGroup" class="group-text" name="userGroup"/>
                                <select name="lessonId" class="lesson-select">
                                    <c:forEach var="lesson" items="${lessonList}" varStatus="status">
                                        <option value="${lesson.lessonId}">${lesson.lessonName}(${lesson.lessonType.value})</option>
                                    </c:forEach>
                                </select>
                                <button type="button" id="scheduleButton" class="btn btn-success button-schedule">Show schedule</button>
                                <input type="hidden" name="cmd" value="schedule"/>
                            </form>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <form class="form" role="form" method="get" action="home">
                                <a href="javascript:;" onclick="parentNode.submit();">Back to the home page</a>
                                <input type="hidden" name="cmd" value="home"/>
                            </form>
                        </li>
                    </ul>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right header-navbar">
                <c:if test="${currentLogin == null}">
                    <li><p class="navbar-text">Already have an account?</p></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><b>Login</b> <span
                                class="caret"></span></a>
                        <ul id="login-dp" class="dropdown-menu">
                            <li>
                                <div class="row">
                                    <div class="col-md-12">
                                        <form class="form" role="form" method="post" action="login"
                                              accept-charset="UTF-8"
                                              id="login-nav">
                                            <div class="form-groupNumber">
                                                <label class="sr-only">Login</label>
                                                <input type="text" class="form-control" id="login" name="login"
                                                       placeholder="Login" required>
                                            </div>
                                            <div class="form-groupNumber">
                                                <label class="sr-only">Password</label>
                                                <input type="password" class="form-control" id="password"
                                                       name="password"
                                                       placeholder="Password" required>
                                                <div class="help-block text-right"><a href="">Forget the password ?</a>
                                                </div>
                                            </div>
                                            <div class="form-groupNumber">
                                                <button type="submit" class="btn btn-primary btn-block">Sign in</button>
                                            </div>
                                            <div class="checkbox">
                                                <label>
                                                    <input type="checkbox"> keep me logged-in
                                                </label>
                                            </div>
                                            <input type="hidden" name="cmd" value="login">
                                        </form>
                                    </div>
                                    <div class="bottom text-center">
                                        New here ? <a href="#"><b>Join Us</b></a>
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </li>
                </c:if>
                <c:if test="${currentLogin != null}">
                    <li>
                        <form class="form" role="form" method="get" action="logout"
                              accept-charset="UTF-8"
                              id="logout">
                            <input type="hidden" name="cmd" value="logout">
                            <input class="btn btn-danger" type="submit" value="Logout">
                        </form>
                    </li>
                </c:if>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
</body>
</html>