<%--
  Created by IntelliJ IDEA.
  User: xqq
  Date: 16-5-5
  Time: 下午5:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>cms</title>
  <link rel="stylesheet" type="text/css" href="../../css/bootstrap.min.css"/>
  <link rel="stylesheet" type="text/css" href="../../css/register.css"/>
</head>
<body class="bodys">
<div class="sign_in">
  <!--这里跳转到login.jsp页面,不回跳转-->
  <a href="" class="btn btn-success" role="button">Sign in</a>
</div>
<div class="sign_up">
  <div class="title">
    <h1 class="title_h1">Sign up</h1>
  </div>
  <!--这里是提交注册的表单-->
  <form action="" method="post">
    <div class="form-group">
      <input type="text" class="form-control" id="inputUsername" name="username" placeholder="Username">
    </div>
    <div class="form-group">
      <input type="email" class="form-control" id="inputEmail" name="email" placeholder="Email">
    </div>
    <div class="form-group">
      <!--<label for="inputPassword">Password</label>-->
      <input type="password" class="form-control" id="inputPassword" name="password" placeholder="Password">
    </div>
    <button type="submit" class="btn btn-success btn-lg btn-block">Sign Up</button>
  </form>
</div>
</body>
</html>
