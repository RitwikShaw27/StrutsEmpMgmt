<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
        <meta name="generator" content="Hugo 0.104.2">
        <title>Sign in - Employee Management</title>

        <link href="css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

        <meta name="theme-color" content="#712cf9">


        <!-- Custom styles for this template -->
        <link href="css/signin.css" rel="stylesheet">

    </head>

    <script src="https://code.jquery.com/jquery-3.6.3.js" 
                        integrity="sha256-nQLuAZGRRcILA+6dMBOvcRh5Pe310sBpanc6+QBmyVM=" 
                        crossorigin="anonymous">
    </script>

    <script>

        function submitForm()
        {
//            var countryCode = document.getElementById("countryCode").value;
//              location.href="PreSignUp";
            signupForm.submit();
        }


    function fetchContent(selectedId, targetId)
                {
                $.ajax({
                    url: 'PreSignUp',
                    data: {
                        [selectedId]: $("#" + selectedId).val()
                    },
                    success: function (responseText) {
                        $("#" + targetId).html(responseText);
                    }
                });
                }

    </script>

    <body class="text-center">


        <main class="form-signin w-100 m-auto">
            <form action="PreSignUp" id="signupForm" method="Post">
                <c:set var="emp" value="${User}"></c:set>


                    <img class="mb-4" src="images/flower-logo.jpg" alt="" width="200" height="200">
                    <h1 class="h3 mb-3 fw-normal">Please provide below information</h1>

                    <div class="form-floating">
                        <input type="email" name="emailAddess" class="form-control" id="floatingInput" placeholder="name@example.com" value="${emp.getEmailAddess()}">
                    <label for="floatingInput">Email address</label>
                </div>
                <div class="form-floating">
                    <input type="password" name="password" class="form-control" id="floatingPassword" placeholder="Password" value="${emp.getPassword()}">
                    <label for="floatingPassword">Password</label>
                </div>
                <div class="form-floating">
                    <input type="text" name="firstName" class="form-control" id="firstName" placeholder="first name" value="${emp.getFirstName()}">
                    <label for="firstName">First Name</label>
                </div>
                <div class="form-floating">
                    <input type="text" name="lastName" class="form-control" id="lastName" placeholder="last name" value="${emp.getLastName()}">
                    <label for="firstName"">Last Name</label>
                </div>


                <div class="form-floating">                    
                    <select name="countryCode" class="form-select" id="countryCode" onchange="fetchContent('countryCode', 'stateCode')" required>
                        <option value="">Select a Country :</option>
                        <c:forEach items="${CountryList}" var="country" >
                            <option value=${country.getCountryCode()}<c:if test="${country.getCountryCode()==User.getCountryCode()}" > selected </c:if>> ${country.getCountryName()} 
                                </option>
                        </c:forEach>
                    </select>
                    <label for="floatingInput">Select Country</label>
                </div>

                <div class="form-floating">                    
                    <select name="stateCode" class="form-select" id="stateCode" onchange="fetchContent('stateCode', 'distCode')" required>
                        <option value="">Select a State :</option>

                    </select>
                    <label for="floatingInput">Select State</label>
                </div>

                <div class="form-floating">                    
                    <select name="distCode" class="form-select" id="distCode" required>
                        <option value="">Select a District :</option>

                    </select>
                    <label for="floatingInput">Select District</label>
                </div>

                <div class="checkbox mb-3">
                    <label>
                        <input type="checkbox" value="remember-me"> Remember me
                    </label>
                </div>
                <button class="w-100 btn btn-lg btn-primary" type="submit">Sign Up</button>
                <a href=Cancel>
                    <button type="button" class="w-100 btn btn-lg btn-warning">Cancel</button>
                </a>
                <p class="mt-5 mb-3 text-muted">&copy; 2017?2022</p>
            </form>
        </main>



    </body>
</html>
