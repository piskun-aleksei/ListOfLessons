<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<html>
<head>
    <title>Authorization</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
</head>

<body>

<jsp:include page="./common/header.jsp"/>

<table id="datatable" class="table table-striped table-bordered" cellspacing="0" width="100%">
    <thead>
    <tr>
        <th>Имя Студента</th>
        <c:forEach var="lesson" items="${lessons}" varStatus="status">
            <th><c:out value="${lesson.date}"/></th>
        </c:forEach>
    </tr>
    </thead>

    <tbody>
    <c:forEach var="student" items="${students}" varStatus="status">
        <tr>
            <td><c:out value="${student.studentName}"/> <c:out value="${student.studentSurname}"/></td>
            <c:forEach var="mark" items="${student.marks}" varStatus="status">
                <td>
                    <span class="mark-span"><c:out value="${mark}"/></span>
                    <c:if test="${currentRank == 3}">
                        <button class="btn btn-primary btn-xs mark-button" data-title="Edit" data-toggle="modal"
                                data-target="#edit">
                            <span class="glyphicon glyphicon-pencil"></span>
                        </button>
                    </c:if>
                </td>
            </c:forEach>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>