<%-- 
    Document   : addemployee
    Created on : 27-Jan-2023, 12:03:35 pm
    Author     : RITWIK SHAW
--%>


<%@page import="com.exavalu.services.RoleService"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.exavalu.services.DepartmentService"%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        
        <title>Add Employee</title>
        <link rel="canonical" href="https://getbootstrap.com/docs/5.3/examples/product/">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="https://getbootstrap.com/docs/5.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="css/menu_css.css" rel="stylesheet">
        <link rel="stylesheet"< href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
        <!-- Custom styles for this template -->
        <link href="css/product.css" rel="stylesheet">
        <link href="css/signin_1.css" rel="stylesheet">
    </head>

    <body >

        
        <%--<jsp:include page="menu.jsp"></jsp:include>--%>
        
        <% if (request.getAttribute("ErrorMsg") != null) {%>
        <div class="alert alert-danger alert-dismissible text-center fade show" >
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                    <%=request.getAttribute("ErrorMsg")%>
        </div>
        <% }%>


        <main class="form-signin w-100 m-auto text-center">

            <form action="Add"  method="Post">
                
                <div class="mt-2 form-floating">
                    <input type="text" class="form-control" id="floatingInput" placeholder="first name" name="firstName" required pattern="[A-Za-z]{1,10}" title="Name must be in range a-z and A-Z" >
                    <label for="floatingInput">First Name</label>
                </div>
                
                <div class="mt-2 form-floating">
                    <input type="text" class="form-control" id="floatingInput" placeholder="last name" name="lastName" required pattern="[A-Za-z]{1,10}" title="Name must be in range a-z and A-Z" >
                    <label for="floatingInput">Last Name</label>
                </div>
                
                <div class="mt-2 form-floating">
                    <input type="text" class="form-control" id="floatingInput" placeholder="address" name="address" required  >
                    <label for="floatingInput">Address</label>
                </div>
                
                <div class="mt-2 form-floating">
                    <input type="text" class="form-control" id="floatingInput" placeholder="phone" name="phoneNumber" required pattern="[0-9]{10,10}" title="10 digit phone number required" >
                    <label for="floatingInput">Phone</label>
                </div>
                
               <div class="form-floating">
                    <select name="gender" class="form-select" id="gender" required>
                        <option value="">Select Gender</option>
                        <option value="male">Male</option>  
                        <option value="female">Female</option>
                        
                    </select>
                    <label for="floatingInput">Gender</label>
                </div>

                <div class="mt-2 form-floating">
                    
                    <select name="departmentId" class="form-select" id="departmentId" required >
                        <option value="">Select a Department :</option>
                        <c:forEach var="dept" items="${DeptList}">
                        <option value=${dept.getDepartmentId()}>${dept.getDepartmentName()}</option>
                        </c:forEach>
                    </select>
                    <label for="floatingPassword">Select Department</label>
                </div>

                <div class="mt-2 form-floating">
                    
                    <select name="roleId" class="form-select" id="roleId" required>
                        <option value="">Select a Role :</option>
                        <c:forEach var="role" items="${RoleList}">
                        <option value=${role.getRoleId()}> ${role.getRoleName()}  </option>
                        </c:forEach>
                    </select> 
                    <label for="floatingPassword">Select Role</label>
                </div>


                <div class="mt-2 form-floating">
                    <input type="text" class="form-control" id="floatingInput" placeholder="basicSalary" name="basicSalary" required pattern="[0-9]+([,\.][0-9]+)?" title="Enter salary in digits">
                    <label for="floatingInput">Basic Salary</label>
                </div>
                    
                <div class="mt-2 form-floating">
                    <input type="text" class="form-control" id="floatingInput" placeholder="carAllowance" name="carAllowance" required pattern="[0-9]+([,\.][0-9]+)?" title="Enter car allowance in digits">
                    <label for="floatingInput">Car Allowance</label>
                </div>
                    
                 <div class="mt-2 form-floating">
                    <input type="text" class="form-control" id="floatingInput" placeholder="dearnessAllowance" name="dearnessAllowance" required pattern="[0-9]+([,\.][0-9]+)?" title="Enter dearness allowance in digits">
                    <label for="floatingInput">Dearness Allowance</label>
                </div>

                <button class="w-100 btn btn-lg btn-primary mt-2" type="submit">Save</button>
                <a href="employeeDetails.jsp">
                    <button type="button" class="mt-2 w-100 btn btn-lg btn-warning">Cancel</button>
                </a>

            </form>
        </main>

    </body>
</html>
