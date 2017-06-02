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
<div class="container">
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
                <td value="${student.studentId}"><c:out value="${student.studentName}"/> <c:out value="${student.studentSurname}"/></td>
                <c:forEach var="mark" items="${student.marks}" varStatus="status">
                    <td value="${mark.key}">
                        <span class="mark-span"><c:out value="${mark.value}"/></span>
                        <c:if test="${currentRank == 3 && teacherId != null && teacherId == scheduleTeacherId}">
                            <button type="button" class="btn btn-primary btn-xs mark-button" data-title="Edit" data-toggle="modal"
                                    data-target="#myModal" role="dialog" onclick="getValues(this);">
                                <span class="glyphicon glyphicon-pencil"></span>
                            </button>
                        </c:if>
                    </td>
                </c:forEach>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>


    <!-- Modal -->
    <div id="myModal" class="modal fade" role="dialog">
      <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
        <form class="form-horizontal custom-form" method="post" action="changeMark">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal">&times;</button>
            <h4 class="modal-title">Изменить оценку</h4>
          </div>
          <div class="modal-body">
            <input type="text" id="studentMark" class="form-control" name="studentMark" placeholder="Оценка">
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-default" id="addMarkButton" onclick="parentNode.parentNode.submit();">Сохранить</button>
            <button type="button" class="btn btn-default" data-dismiss="modal">Закрыть</button>
          </div>

            <input type="hidden" id="studentId" name="studentId"/>
            <input type="hidden" id="scheduleId" name="scheduleId"/>
            <input type="hidden" name="cmd" value="changeMark"/>
          </form>
        </div>

      </div>
    </div>
</body>
</html>
