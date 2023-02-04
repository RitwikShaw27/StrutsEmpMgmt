<%--<%@page import="com.exavalu.empweb.utils.JDBCConnectionManager"%>--%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%--<%@page import="com.exavalu.empweb.utils.entities.Employee"%>--%>
<%--<%@page import="com.exavalu.entities.Employee"%>--%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  



<!doctype html>
<html lang="en">
    <head>        
        <title>Employee Management Web Application</title>
        <link rel="canonical" href="https://getbootstrap.com/docs/5.3/examples/product/">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="https://getbootstrap.com/docs/5.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="css/menu_css.css" rel="stylesheet">
        <!-- Custom styles for this template -->
        <link href="css/product.css" rel="stylesheet">

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.2.0/css/bootstrap.min.css"/>

        <link rel="stylesheet" href="https://cdn.datatables.net/1.13.1/css/dataTables.bootstrap5.min.css"/>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
        <style>
            #example_wrapper{
                width: 100%;
                display: block;
                margin: auto;
            }
        </style>
    </head>


    <body>

        <jsp:include page="menu.jsp"></jsp:include>



        <!-- ADD EMPLOYEE SUCCESS MESSAGE-->
        <c:set var="msg" value="${Success}"></c:set>
        <c:if test="${msg != null}" >
            <div class="alert alert-success alert-dismissible text-center fade show">
                <strong><c:out value="${msg}"></c:out></strong>
                    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                </div>            
        </c:if> 


        <!-- DELETE EMPLOYEE SUCCESS MESSAGE-->
        <c:set var="msg2" value="${deleteSuccess}"></c:set>
        <c:if test="${msg2 != null}" >
            <div class="alert alert-success alert-dismissible text-center fade show">
                <strong><c:out value="${msg2}"></c:out></strong>
                    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                </div>            
        </c:if> 

        <!--Scriptlet-->

        <div class="row justify-content-center">
            <div class="col-auto">
                <table class="table table-bordered table-striped text-center " id="example">
                    <thead>
                        <tr class="text-bg-dark text-white">
                            <th class="text-center">Employee Id  </th>
                            <th class="text-center">First Name </th>
                            <th class="text-center">Last Name</th>
                            <th class="text-center">Phone</th>
                            <th class="text-center">Address</th>
                            <th class="text-center">Gender</th>
                            <th class="text-center">Department</th>
                            <th class="text-center">Role</th>
                            <th class="text-center">Basic Salary</th>
                            <th class="text-center">Car Allowance</th>
                            <th class="text-center">Dearness Allowance</th>
                            <th class="text-center">Action</th>                        
                        </tr>
                    </thead>

                    <tbody>

                        <!--Scriptlet-->

                        <c:forEach items="${empList}" var="emp">
                            <tr>
                                <td>${emp.getEmployeeId()}</td>
                                <td>${emp.getFirstName()}</td>
                                <td>${emp.getLastName()}</td>
                                <td>${emp.getPhoneNumber()}</td>
                                <td>${emp.getAddress()}</td>
                                <td>${emp.getGender()}</td>
                                <td>${emp.getDepartmentName()}</td>
                                <td>${emp.getRoleName()}</td>
                                <td>${emp.getBasicSalary()}</td>
                                <td>${emp.getCarAllowance()}</td>
                                <td>${emp.getDearnessAllowance()}</td>
                                <td>
                                    <a href=doEdit?employeeId=${emp.getEmployeeId()} class=" text-decoration-none">
                                        <button class="w-20 btn btn-sm btn-info text-center"><i class="bi bi-pencil-square"></i></button>
                                    </a>
                                    <a href=Delete?employeeId=${emp.getEmployeeId()} class=" text-decoration-none">
                                        <button class="w-20 btn btn-sm btn-danger text-center"><i class="bi bi-trash"></i></button>
                                    </a>
                                </td>
                            </tr>

                        </c:forEach> 

                        <!--PAGINATION LOGIC-->


                    </tbody>
                </table>
            </div>
        </div>

        <script src =  "js/bootstrap.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
        <script src="https://cdn.datatables.net/1.13.1/js/jquery.dataTables.min.js"></script>
        <script src="https://cdn.datatables.net/1.13.1/js/dataTables.bootstrap5.min.js"></script>
        <script>
            $(document).ready(function () {
                $('#example').DataTable();
            });
        </script>

    </body>
</html>