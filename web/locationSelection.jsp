<%-- 
    Document   : locationSelection
    Created on : 08-Feb-2023, 11:27:25 pm
    Author     : RITWIK SHAW
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Location Selection Page</title>
        <link rel="canonical" href="https://getbootstrap.com/docs/5.3/examples/product/">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="https://getbootstrap.com/docs/5.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="css/menu_css.css" rel="stylesheet">
        <link rel="stylesheet"< href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
        <!-- Custom styles for this template -->
        <link href="css/product.css" rel="stylesheet">
    </head>


    <body class="text-center">
        <main class="form-signin w-80 m-auto text-center">

            <table class="table table-bordered table-striped text-center ">
                <form action="" method="get" class="form-horizontal">
                    <tr>
                        <td>
                            <div class=" form-floating">

                                <select name="country" class="form-select" id="country">
                                    <option value="">Select Country: </option> 
                                    <option value=""> Country1 </option> 
                                </select>
                                <label for="floatingInput">Country</label>
                            </div>
                        </td>
                        <td>
                            <div class="form-control col-sm">
                                <button type="submit" class="form-control btn-sm w-25 btn-info m-2">SUBMIT</button>
                            </div>
                        </td>
                    </tr>
                </form>

                <form action="" method="get" class="form-horizontal">
                    <tr>
                        <td>
                            <div class=" form-floating">

                                <select name="state" class="form-select" id="state">
                                    <option value="">Select State </option> 
                                    <option value=""> State1 </option> 
                                </select>
                                <label for="floatingInput">State</label>
                            </div>
                        </td>
                        <td>
                            <div class="form-control col-sm">
                                <button type="submit" class="form-control btn-sm w-25 btn-info m-2">SUBMIT</button>
                            </div>
                        </td>
                    </tr>
                </form>

                <form action="" method="get" class="form-horizontal">
                    <tr>
                        <td>
                            <div class="form-floating">

                                <select name="district" class="form-select" id="district">
                                    <option value="">Select District: </option> 
                                    <option value=""> District1 </option> 
                                </select>
                                <label for="floatingInput">District</label>
                            </div>
                        </td>
                        <td>
                            <div class="form-control col-sm">
                                <button type="submit" class="form-control btn-sm w-25 btn-info m-2 ">SUBMIT</button>
                            </div>
                        </td>
                    </tr>
                </form>
            </table>

        </main>

    </body>
</html>
