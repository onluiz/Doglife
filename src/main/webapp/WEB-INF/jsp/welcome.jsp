<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="User login page" />
    <meta name="author" content="">
    <title>Doglife</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value='assets/vendor/bootstrap/css/bootstrap.min.css'/>" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="<c:url value='assets/vendor/font-awesome/css/font-awesome.min.css'/>" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<c:url value='assets/css/sb-admin.css'/>" rel="stylesheet">

    <!-- Doglife styles -->
    <link href="<c:url value='assets/css/doglife/dashboard.css'/>" rel="stylesheet">
</head>
<body>
<div class="container-fluid">

    <!-- Icon Cards -->
    <div class="row top-buffer">
        <div class="col-xl-3 col-sm-6 mb-3"></div>
        <div class="col-xl-3 col-sm-6 mb-3">
            <div class="card text-white bg-warning o-hidden h-100">
                <div class="card-body">
                    <div class="card-body-icon">
                        <i class="fa fa-fw fa-list"></i>
                    </div>
                    <div class="mr-5">
                        <h2>Login</h2>
                        <form name='f' action='<c:url value="j_spring_security_check"/>' method='POST'>
                            <div class="form-group">
                                <label for="j_username">usuário:</label>
                                <input type="text" class="form-control" id="j_username" placeholder="entre com o usuário" name="j_username" required>
                            </div>
                            <div class="form-group">
                                <label for="j_password">Senha:</label>
                                <input type="password" class="form-control" id="j_password" placeholder="entre com sua senha" name="j_password" required>
                            </div>
                            <button type="submit" class="btn btn-default" id="btn-login-submit">acessar</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-xl-3 col-sm-6 mb-3">
            <div class="card text-white bg-success o-hidden h-100">
                <div class="card-body">
                    <div class="card-body-icon">
                        <i class="fa fa-fw fa-shopping-cart"></i>
                    </div>
                    <div class="mr-5">
                        <h2>Cadastro</h2>
                        <form id="form-user-register" action='<c:url value="/users"/>' method='POST'>
                            <div class="form-group">
                                <label for="j_username">usuário:</label>
                                <input type="text" class="form-control" id="username" placeholder="entre com o usuário" name="username" required>
                            </div>
                            <div class="form-group">
                                <label for="j_password">Senha:</label>
                                <input type="password" class="form-control" id="password" placeholder="entre com sua senha" name="password" required>
                            </div>
                            <button type="submit" class="btn btn-default" id="btn-cadastro-submit">cadastrar</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-xl-3 col-sm-6 mb-3">
        </div>
    </div>
</div>
<script src="<c:url value='/assets/js/doglife/welcome.js'/>"></script>
<script>
    UIWelcome.init();
</script>
</body>
</html>
