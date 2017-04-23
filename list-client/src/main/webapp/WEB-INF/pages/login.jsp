<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Authorization</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

    <link type="text/css" rel="stylesheet" href="<c:url value='/resources/css/author-form.css'/>"/>
    <link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Roboto'>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>


<div class="container">
    <div class="row" style="margin-top:20px">
        <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
            <form name='loginForm' role="form"
                  action="<c:url value='/j_spring_security_check'/>" method='POST'>
                <c:if test="${not empty error}">
                    <div class="error">${error}</div>
                </c:if>
                <c:if test="${not empty msg}">
                    <div class="msg">${msg}</div>
                </c:if>

                <fieldset>
                    <h2>Please Sign In</h2>
                    <hr class="colorgraph">
                    <div class="form-group">
                        <input type="text" name="username" id="email" class="form-control input-lg" placeholder="username">
                    </div>
                    <div class="form-group">
                        <input type="password" name="password" id="password" class="form-control input-lg" placeholder="Password">
                    </div>
                    <hr class="colorgraph">
                    <div class="row">
                        <div class="col-xs-6 col-sm-6 col-md-6">
                            <input type="hidden" name="cmd" value="login">
                            <input type="hidden" name="${_csrf.parameterName}"
                                   value="${_csrf.token}"/>
                            <input type="submit" class="btn btn-lg btn-success btn-block" value="Sign In">
                        </div>
                        <div class="col-xs-6 col-sm-6 col-md-6">
                            <a href="" class="btn btn-lg btn-primary btn-block">Forgot Password?</a>
                        </div>
                    </div>
                </fieldset>
            </form>
        </div>
    </div>

</div>

</body>
</html>