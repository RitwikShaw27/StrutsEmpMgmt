<%@page import="com.exavalu.models.Employee"%>
<%@page import="com.exavalu.models.Role"%>
<%@page import="com.exavalu.models.Department"%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">        
        <title>Employee Management</title>      
        <!--<link href="css/bootstrap.min.css" rel="stylesheet" >-->
        <link href="https://getbootstrap.com/docs/5.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="css/menu_css.css" rel="stylesheet">
        <link href="css/product.css" rel="stylesheet">
        <link href="css/signin.css" rel="stylesheet">  
        <!-- Custom styles for this template -->    

    </head>

    <body class="text-center">

        <%--<jsp:include page="menu.jsp"></jsp:include>--%>

        <main class="form-signin w-100 m-auto">



            <form action="Update" method="Post">

                <img  src="images/flower-logo.jpg" alt="" width="200" height="200">
                <h1 class="h3 mb-3 fw-normal">Please edit employee data</h1>
                <div class="form-floating">
                    <input type="text" class="form-control" id="floatingInput" placeholder="Employee ID" name="employeeId" value=${Emp.employeeId} readonly>
                    <label for="floatingInput">Employee ID</label>
                </div>
                <div class="form-floating">
                    <input type="text" class="form-control" id="floatingInput" placeholder="first name" name="firstName" value=${Emp.getFirstName()}>
                    <label for="floatingInput">First Name</label>
                </div>
                <div class="form-floating">
                    <input type="text" class="form-control" id="floatingInput" placeholder="last name" name="lastName" value=${Emp.getLastName()}>
                    <label for="floatingInput">Last Name</label>
                </div>
                <div class="form-floating">
                    <input type="text" class="form-control" id="floatingInput" placeholder="address" name="address" value=${Emp.getAddress()}>
                    <label for="floatingInput">Address</label>
                </div>
                <div class="form-floating">
                    <input type="text" class="form-control" id="floatingInput" placeholder="phone" name="phoneNumber" value=${Emp.getPhoneNumber()}>
                    <label for="floatingInput">Phone</label>
                </div>
                <div class="form-floating">
                    <input type="text" class="form-control" id="floatingInput" placeholder="gender" name="gender" value=${Emp.getGender()}>
                    <label for="floatingInput">Gender</label>
                </div>

                <div class="form-floating">                    
                    <select name="departmentId" class="form-select" id="departmentId" >
                        <option value="0">Select a Department :</option>
                        <c:forEach items="${DeptList}" var="dept" >
                            <option value=${dept.getDepartmentId()}<c:if test="${dept.getDepartmentName().equalsIgnoreCase(Emp.getDepartmentName())}" > selected </c:if>> ${dept.getDepartmentName()} </option>
                        </c:forEach>
                    </select>
                    <label for="floatingInput">Select Department</label>
                </div>

                <div class="form-floating">
                    
                    <select name="roleId" class="form-select" id="roleId">
                        <option value="0">Select a Role :</option>
                        <c:forEach items="${RoleList}" var="role" >
                                <option value=${role.getRoleId()}<c:if test="${role.getRoleName().equalsIgnoreCase(Emp.getRoleName())}" > selected </c:if> > ${role.getRoleName()}</option>
                            </c:forEach>
                    </select>
                    <label for="floatingInput">Select Role</label>
                </div>


                <div class="form-floating">
                    <input type="text" class="form-control" id="floatingInput" placeholder="basicSalary" name="basicSalary" value=${Emp.getBasicSalary()}>
                    <label for="floatingInput">Basic Salary</label>
                </div>
                <div class="form-floating">
                    <input type="text" class="form-control" id="floatingInput" placeholder="carAllowance" name="carAllowance" value=${Emp.getCarAllowance()}>
                    <label for="floatingInput">Car Allowance</label>
                </div>



                <button class="w-100 btn btn-lg btn-primary" type="submit">Save</button>

            </form>
        </main>
    </body>
</html>