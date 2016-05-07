<%--
  Created by IntelliJ IDEA.
  User: xqq
  Date: 16-5-5
  Time: 下午5:57
  Content:注册页面,也是根访问页
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
  <script type="text/javascript">
    function addUser() {
      var form = document.forms[0];
      form.action = "${pageContext.request.contextPath}/user/add";
      form.method = "post";
      form.submit();
    }
  </script>
</head>
<body class="bodys">
<div class="sign_in">
  <a href="/login" class="btn btn-success" role="button">Sign in</a>
</div>
<div class="sign_up">
  <div class="title">
    <h1 class="title_h1">Sign up</h1>
  </div>
  <!--这里是提交注册的表单-->
  <form action="/user/add" method="post">
    <p style="color: red">${status}</p>
    <div class="form-group">
      <input type="text" class="form-control" id="username" name="username" placeholder="Username">
    </div>
    <div class="form-group">
      <input type="email" class="form-control" id="email" name="email" placeholder="Email">
    </div>
    <div class="form-group">
      <!--<label for="inputPassword">Password</label>-->
      <input type="password" class="form-control" id="password" name="password" placeholder="Password">
    </div>
    <button type="submit" class="btn btn-success btn-lg btn-block" onclick="addUser()">Sign Up</button>
  </form>
</div>
</body>
</html>
