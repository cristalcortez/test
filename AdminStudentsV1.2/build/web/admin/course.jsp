<%-- 
    Document   : person
    Created on : Oct 21, 2017, 11:01:56 AM
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
                        <li class="${active == 'marks' ? 'active' : ''}"><a href="/AdminStudentsV1.2/Mark">Marks</a></li>
                    </ul>
                </div><!--/col-sm-3-->
                <!---->
                <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                    <!---->
                    <h1>course</h1>
                    <div class="row placeholders"></div>
                    <!---->
                    <c:set var="buttonName" value=""/>
                    <c:set var="methodName" value=""/>
                        <c:choose>
                        <c:when test="${action == 'edit'}">
                            <c:set var="buttonName" value="Update"/>
                            <c:set var="methodName" value="get"/>
                        </c:when>
                        <c:otherwise>
                            <c:set var="buttonName" value="Save"/>
                            <c:set var="methodName" value="post"/>
                        </c:otherwise>
                    </c:choose>

                    <form action="Course" method="<c:out value="${methodName}"/>">
                        <c:choose>
                            <c:when test="${action == 'edit'}">
                                <label>ID</label>
                                <input type="text" name="course_id" value="<c:out value="${course.course_id}"/>" readonly>
                                <br>
                            </c:when>
                        </c:choose>
                        <label>Course Name</label>
                        <input type="text" name="course_name" value="<c:out value="${course.course_name}"/>">  
                        <br>
                        <input type="hidden" name="action" id="action" value="<c:out value="${buttonName}"/>">
                        <input class="btn" id="button4" type="submit" name="button4" value="<c:out value="${buttonName}"/>">
                    </form>
                </div><!--/col-sm-9-->
            </div><!--/row-->
        </div><!--/container-fluid-->
    </body>
</html>