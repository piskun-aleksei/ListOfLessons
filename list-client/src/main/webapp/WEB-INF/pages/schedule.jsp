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
        <th>18/06/2017</th>
        <th>19/06/2017</th>
        <th>20/06/2017</th>
    </tr>
    </thead>

    <tbody>
    <tr>
        <td>Пискун Алексей</td>
        <td>
            <span class="mark-span">8</span>
            <c:if test="${currentRank == 3}">
                <button class="btn btn-primary btn-xs mark-button" data-title="Edit" data-toggle="modal"
                        data-target="#edit">
                    <span class="glyphicon glyphicon-pencil"></span>
                </button>
            </c:if>
        </td>
        <td>
            <span class="mark-span"></span>
            <c:if test="${currentRank == 3}">
                <button class="btn btn-primary btn-xs mark-button" data-title="Edit" data-toggle="modal"
                        data-target="#edit">
                    <span class="glyphicon glyphicon-pencil"></span>
                </button>
            </c:if>
        </td>
        <td>
            <span class="mark-span">9</span>
            <c:if test="${currentRank == 3}">
                <button class="btn btn-primary btn-xs mark-button" data-title="Edit" data-toggle="modal"
                        data-target="#edit">
                    <span class="glyphicon glyphicon-pencil"></span>
                </button>
            </c:if>
        </td>
    </tr>
    <tr>
        <td>Евгений Шилов</td>
        <td>
            <span class="mark-span"></span>
            <c:if test="${currentRank == 3}">
                <button class="btn btn-primary btn-xs mark-button" data-title="Edit" data-toggle="modal"
                        data-target="#edit">
                    <span class="glyphicon glyphicon-pencil"></span>
                </button>
            </c:if>
        </td>
        <td>
            <span class="mark-span"></span>
            <c:if test="${currentRank == 3}">
                <button class="btn btn-primary btn-xs mark-button" data-title="Edit" data-toggle="modal"
                        data-target="#edit">
                    <span class="glyphicon glyphicon-pencil"></span>
                </button>
            </c:if>
        </td>
        <td>
            <span class="mark-span">9</span>
            <c:if test="${currentRank == 3}">
                <button class="btn btn-primary btn-xs mark-button" data-title="Edit" data-toggle="modal"
                        data-target="#edit">
                    <span class="glyphicon glyphicon-pencil"></span>
                </button>
            </c:if>
        </td>
    </tr>
    <tr>
        <td>Станислав Маковский</td>
        <td>
            <span class="mark-span">5</span>
            <c:if test="${currentRank == 3}">
                <button class="btn btn-primary btn-xs mark-button" data-title="Edit" data-toggle="modal"
                        data-target="#edit">
                    <span class="glyphicon glyphicon-pencil"></span>
                </button>
            </c:if>
        </td>
        <td>
            <span class="mark-span">2</span>
            <c:if test="${currentRank == 3}">
                <button class="btn btn-primary btn-xs mark-button" data-title="Edit" data-toggle="modal"
                        data-target="#edit">
                    <span class="glyphicon glyphicon-pencil"></span>
                </button>
            </c:if>
        </td>
        <td>
            <span class="mark-span">7</span>
            <c:if test="${currentRank == 3}">
                <button class="btn btn-primary btn-xs mark-button" data-title="Edit" data-toggle="modal"
                        data-target="#edit">
                    <span class="glyphicon glyphicon-pencil"></span>
                </button>
            </c:if>
        </td>
    </tr>
    <tr>
        <td>Марук Евгений</td>
        <td>
            <span class="mark-span">6</span>
            <c:if test="${currentRank == 3}">
                <button class="btn btn-primary btn-xs mark-button" data-title="Edit" data-toggle="modal"
                        data-target="#edit">
                    <span class="glyphicon glyphicon-pencil"></span>
                </button>
            </c:if>
        </td>
        <td>
            <span class="mark-span"></span>
            <c:if test="${currentRank == 3}">
                <button class="btn btn-primary btn-xs mark-button" data-title="Edit" data-toggle="modal"
                        data-target="#edit">
                    <span class="glyphicon glyphicon-pencil"></span>
                </button>
            </c:if>
        </td>
        <td>
            <span class="mark-span">10</span>
            <c:if test="${currentRank == 3}">
                <button class="btn btn-primary btn-xs mark-button" data-title="Edit" data-toggle="modal"
                        data-target="#edit">
                    <span class="glyphicon glyphicon-pencil"></span>
                </button>
            </c:if>
        </td>
    </tr>
    </tbody>
</table>
</body>
</html>