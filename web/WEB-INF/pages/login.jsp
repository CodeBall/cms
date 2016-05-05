<%--
  Created by IntelliJ IDEA.
  User: xqq
  Date: 16-5-4
  Time: 上午9:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>cms</title>
  <link rel="stylesheet" type="text/css" href="../../css/bootstrap.min.css"/>
  <link rel="stylesheet" type="text/css" href="../../css/login.css"/>
</head>
<body class="back">
<div class="login_s">
  <div class="title">
    <h1 class="title_h1">Sign in to cms</h1>
  </div>
  <div class="login_form">
    <!--这里还没有写向哪里提交数据-->
    <form action="" method="post">
      <div class="form-group">
        <label for="InputEmail">Email address</label>
        <input type="email" class="form-control" id="InputEmail" name="email" placeholder="Email">
      </div>
      <div class="form-group form_pass">
        <label for="InputPassword">Password
          <a class="forget_pass" href="#">Forgot password?</a>
        </label>
        <input type="password" class="form-control" id="InputPassword" name="password" placeholder="Password">
      </div>
      <button type="submit" class="btn btn-success btn-lg btn-block">Sign In</button>
    </form>
  </div>
</div>
</body>
</html>
