<%@page import="com.exavalu.models.Employee"%>
<%@page import="com.exavalu.models.Role"%>
<%@page import="com.exavalu.models.Department"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%--<%@page import="com.exavalu.entities.Employee"%>--%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<!doctype html>
<html lang="en">
    <head>        
        <title>Search Page</title>
        <link rel="canonical" href="https://getbootstrap.com/docs/5.3/examples/product/">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="https://getbootstrap.com/docs/5.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="css/menu_css.css" rel="stylesheet">
        <link rel="stylesheet"< href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
        <!-- Custom styles for this template -->
        <link href="css/product.css" rel="stylesheet">


    </head>


    <body class="text-center">

        

        <jsp:include page="menu.jsp"></jsp:include>

            <main class="form-signin w-80 m-auto text-center">
                <!--POST METHOD TO HIDE USER DATA-->
                <!--            <table class="table table-bordered table-striped text-center ">-->
                <form action="Search" method="get" class="form-horizontal"> 
                    <table class="table table-bordered table-striped text-center ">
                        <tr>
                            <th>First Name </th>
                            <th>Last Name</th>
                            <th>Gender</th>
                            <th>Department</th>
                            <th>Role</th>
                        </tr>

                        <tr>
                            <td>
                                <div class="mt-2 form-floating">
                                    <input type="text" class="form-control" id="floatingPassword" placeholder="Email Address" name="firstName">
                                    <label for="floatingPassword">Enter First Name</label>
                                </div>
                            </td>

                            <td>
                                <div class="mt-2 form-floating">
                                    <input type="text" class="form-control" id="floatingPassword" placeholder="Password" name="lastName">
                                    <label for="floatingPassword">Enter Last Name</label>
                                </div>
                            </td>

                            <td>
                                <div class="mt-2 form-floating">
                                    <input type="text" class="form-control" id="floatingPassword" placeholder="First Name" name="gender">
                                    <label for="floatingPassword">Enter Gender</label>
                                </div>
                            </td>

                            <td>
                                <div class="mt-2 form-floating">

                                    <select name="departmentId" class="form-select" id="departmentId">
                                        <option value="">Select Department </option>
                                    <c:forEach var="dept" items="${DeptList}">
                                        <option value=${dept.getDepartmentId()} >${dept.getDepartmentName()}  </option>
                                    </c:forEach>

                                </select>
                                <label for="floatingPassword">Select Department</label>
                            </div>
                        </td>

                        <td>
                            <div class="mt-2 form-floating">
                                <select name="roleId" class="form-select" id="roleId">
                                    <option value="">Select Role </option>
                                    <c:forEach var="rol" items="${RoleList}">
                                        <option value=${rol.getRoleId()} >${rol.getRoleName()}  </option>
                                    </c:forEach>
                                </select>
                                <label for="floatingPassword">Select Role</label>
                            </div>
                        </td>

                    </tr>

                </table> 
                <div class="form-control col-sm">
                    <button type="submit" class="form-control btn w-25 btn-info mb-2">SEARCH</button>
                </div>
            </form>





            <c:if test="${empList1 != null}" >
                <div class="row justify-content-center">
                    <div class="col-auto">
                        <table class="table table-bordered table-striped text-center " id="example">
                            <thead>
                                <tr>
                                    <th>Employee Id  </th>
                                    <th>First Name </th>
                                    <th>Last Name</th>
                                    <th>Phone</th>
                                    <th>Address</th>
                                    <th>Gender</th>
                                    <th>Department</th>
                                    <th>Role</th>
                                    <th>Basic Salary</th>
                                    <th>Car Allowance</th>
                                    <th>Dearness Allowance</th>
                                    <th>Action</th>
                                </tr>
                            </thead>

                            <tbody>

                                <c:forEach items="${empList1}" var="emp">

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
                                        <td class="text-center">
                                            <a href=doEdit?employeeId=${emp.getEmployeeId()} class=" text-decoration-none">
                                                <button class="w-20 btn btn-sm btn-info text-center"><i class="bi bi-pencil-square"></i></button>
                                            </a>
                                            <a href=Delete?employeeId=${emp.getEmployeeId()} class=" text-decoration-none">
                                                <button class="w-20 btn btn-sm btn-danger text-center"><i class="bi bi-trash"></i></button>
                                            </a>
                                        </td>
                                    </tr>

                                </c:forEach>



                            </tbody>
                        </table>
                    </div>
                </div>
            </c:if>

        </main>
    </body>
</html>