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

    <spring:url value="/resources/js/tables.js" var="tablesjs"/>
    <script src="${tablesjs}"></script>

    <link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Roboto'>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-default navbar-inverse" role="navigation">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <span class="navbar-brand" href="#">
                <c:if test="${login != null}">
                    Login is: ${login}
                </c:if>
                <c:if test="${login == null}">
                    You are not logged in
                </c:if>
            </span>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">Link</a></li>
                <li><a href="#">Link</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li>
                            <form class="form" role="form" method="get" action="schedule">
                                <a href="javascript:;" onclick="parentNode.submit();">Show schedule</a>
                                <input type="hidden" name="cmd" value="schedule"/>
                            </form>
                        </li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                        <li class="divider"></li>
                        <li><a href="#">Separated link</a></li>
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
                <c:if test="${login == null}">
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
                                            <div class="form-group">
                                                <label class="sr-only">Login</label>
                                                <input type="text" class="form-control" id="login" name="login"
                                                       placeholder="Login" required>
                                            </div>
                                            <div class="form-group">
                                                <label class="sr-only">Password</label>
                                                <input type="password" class="form-control" id="password"
                                                       name="password"
                                                       placeholder="Password" required>
                                                <div class="help-block text-right"><a href="">Forget the password ?</a>
                                                </div>
                                            </div>
                                            <div class="form-group">
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
                <c:if test="${login != null}">
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