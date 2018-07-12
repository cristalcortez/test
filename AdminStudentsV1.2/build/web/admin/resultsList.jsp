<%-- 
    Document   : resultsList
    Created on : Oct 24, 2017, 6:45:27 PM
    Author     : user
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="adminStudent" uri="/WEB-INF/tlds/custom.tld" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Student Admin System</title>
        <!-- Bootstrap core CSS -->
        <link href="admin/css/bootstrap.min.css" rel="stylesheet">
        <!-- Custom styles for this template -->
        <link href="admin/css/styles.css" rel="stylesheet">
    </head>
    <body>
        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container-fluid">
                <!---->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <p class="navbar-brand">Students Administration System</p>
                </div><!--/navbar-header-->
                <!---->
                <div id="navbar" class="navbar-collapse collapse">
                    <p class="navbar-brand navbar-right">cristalcortez</p>
                </div><!--/navbar -->
            </div><!--/container-fluid-->
        </nav><!--/navbar-->
        
        <div class="container-fluid">
            <!---->
            <div class="row">
                <!---->
                <div class="col-sm-3 col-md-2 sidebar">
                    <ul class="nav nav-sidebar">
                        <li class="${active == 'student' ? 'active' : ''}"><a href="/AdminStudentsV1.2/Student">Students</a></li>
                        <li class="${active == 'course' ? 'active' : ''}"><a href="/AdminStudentsV1.2/Course">Courses</a></li>
                        <li class="${active == 'result' ? 'active' : ''}"><a href="/AdminStudentsV1.2/Mark">Marks</a></li>
                    </ul>
                </div><!--/col-sm-3-->
                <!---->
                <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                    <!---->
                    <h1 class="page-header">List of Result</h1>
                    <div class="row placeholders"></div>
                    <!---->
                    <div class="table-responsive">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>Student ID</th>
                                    <th>Student Name</th>
                                    <th>Course ID</th>
                                    <th>Course Name</th>
                                    <th>Marks</th>
                                    <th>Semester</th>
                                    <th>----</th>
                                    <th>----</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${results}" var="result" >
                                    <tr>
                                        <td><c:out value="${result.student_id}"/></td>
                                        <td><c:out value="${result.student_name}"/></td>
                                        <td><c:out value="${result.course_id}"/></td>
                                        <td><c:out value="${result.course_name}"/></td>
                                        <td><c:out value="${result.marks}"/></td>
                                        <td><c:out value="${result.semester}"/></td>
                                        <td><a href="Mark?action=delete&student_id=<c:out value="${result.student_id}"/>&course_id=<c:out value="${result.course_id}"/>">Delete</a></td>
                                        <td><a href="Mark?action=edit&student_id=<c:out value="${result.student_id}"/>&course_id=<c:out value="${result.course_id}"/>">Edit</a></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div><!--/table-responsive-->
                    <div class="row">
                            <form action="Mark" method="post">
                                <input type="hidden" name="active" id="active" value="result">
                                <input class="btn" id="insert" type="submit" name="insert" value="Insert">
                            </form>
                            <br>
                            <p>The current date is <adminStudent:currentDate/>.</p>
                            <adminStudent:ifWeekDay><p>Live Support available at 1-800-555-2222</p></adminStudent:ifWeekDay>
                    </div><!--/row-->
                </div><!--/col-sm-9-->
            </div><!--/row-->
        </div><!--/container-fluid-->
    </body>
</html>