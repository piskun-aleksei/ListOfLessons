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

<jsp:include page="./common/header.jsp" />

<table id="datatable" class="table table-striped table-bordered" cellspacing="0" width="100%">
    <thead>
    <tr>
        <th>Name</th>
        <th>Position</th>
        <th>Office</th>
        <th>Age</th>
        <th>Start date</th>
        <th>Salary</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    </thead>

    <tfoot>
    <tr>
        <th>Name</th>
        <th>Position</th>
        <th>Office</th>
        <th>Age</th>
        <th>Start date</th>
        <th>Salary</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    </tfoot>

    <tbody>
    <tr>
        <td>Tiger Nixon</td>
        <td>System Architect</td>
        <td>Edinburgh</td>
        <td>61</td>
        <td>2011/04/25</td>
        <td>$320,800</td>
        <td>
            <p data-placement="top" data-toggle="tooltip" title="Edit">
                <button class="btn btn-primary btn-xs" data-title="Edit" data-toggle="modal" data-target="#edit"><span
                        class="glyphicon glyphicon-pencil"></span></button>
            </p>
        </td>
        <td>
            <p data-placement="top" data-toggle="tooltip" title="Delete">
                <button class="btn btn-danger btn-xs" data-title="Delete" data-toggle="modal" data-target="#delete">
                    <span class="glyphicon glyphicon-trash"></span></button>
            </p>
        </td>
    </tr>

    <tr>
        <td>Tiger Nixon</td>
        <td>System Architect</td>
        <td>Edinburgh</td>
        <td>61</td>
        <td>2011/04/25</td>
        <td>$320,800</td>
        <td>
            <p data-placement="top" data-toggle="tooltip" title="Edit">
                <button class="btn btn-primary btn-xs" data-title="Edit" data-toggle="modal" data-target="#edit"><span
                        class="glyphicon glyphicon-pencil"></span></button>
            </p>
        </td>
        <td>
            <p data-placement="top" data-toggle="tooltip" title="Delete">
                <button class="btn btn-danger btn-xs" data-title="Delete" data-toggle="modal" data-target="#delete">
                    <span class="glyphicon glyphicon-trash"></span></button>
            </p>
        </td>
    </tr>
    <tr>
        <td>Tiger Nixon</td>
        <td>System Architect</td>
        <td>Edinburgh</td>
        <td>61</td>
        <td>2011/04/25</td>
        <td>$320,800</td>
        <td>
            <p data-placement="top" data-toggle="tooltip" title="Edit">
                <button class="btn btn-primary btn-xs" data-title="Edit" data-toggle="modal" data-target="#edit"><span
                        class="glyphicon glyphicon-pencil"></span></button>
            </p>
        </td>
        <td>
            <p data-placement="top" data-toggle="tooltip" title="Delete">
                <button class="btn btn-danger btn-xs" data-title="Delete" data-toggle="modal" data-target="#delete">
                    <span class="glyphicon glyphicon-trash"></span></button>
            </p>
        </td>
    </tr>
    <tr>
        <td>Tiger Nixon</td>
        <td>System Architect</td>
        <td>Edinburgh</td>
        <td>61</td>
        <td>2011/04/25</td>
        <td>$320,800</td>
        <td>
            <p data-placement="top" data-toggle="tooltip" title="Edit">
                <button class="btn btn-primary btn-xs" data-title="Edit" data-toggle="modal" data-target="#edit"><span
                        class="glyphicon glyphicon-pencil"></span></button>
            </p>
        </td>
        <td>
            <p data-placement="top" data-toggle="tooltip" title="Delete">
                <button class="btn btn-danger btn-xs" data-title="Delete" data-toggle="modal" data-target="#delete">
                    <span class="glyphicon glyphicon-trash"></span></button>
            </p>
        </td>
    </tr>
    </tbody>
</table>
</body>
</html>