<%--
  Created by IntelliJ IDEA.
  User: xqq
  Date: 16-5-7
  Time: 下午2:06
  Content:用户列表页
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% HttpSession s = request.getSession();%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="net.yanzl">
    <!--<link rel="icon" href="../../favicon.ico">-->

    <title>cms</title>

    <!-- Bootstrap core CSS -->
    <link href="../../css/bootstrap.min.css" rel="stylesheet" type="text/css">

    <!-- Custom styles for this template -->
    <link href="../../css/index.css" rel="stylesheet" type="text/css">
</head>

<body>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">The cms</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <!--这里填写登陆人的人名-->
                <li><a href="#">你好,<%=s.getAttribute("userName")%></a></li>
                <li><a href="#"></a></li>
                <li><a href="#"></a></li>
                <li><a href="/logout">退出</a></li>
            </ul>
            <form class="navbar-form navbar-right">
                <input type="text" class="form-control" placeholder="Search...">
            </form>
        </div>
    </div>
</nav>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li class="active"><a href="#">用户管理 <span class="sr-only">(current)</span></a></li>
                <li><a href="/user/1/10">
                    <span class="glyphicon glyphicon-star" aria-hidden="true"></span> 所有用户
                </a></li>
                <li><a href="/user/add/">
                    <span class="glyphicon glyphicon-star" aria-hidden="true"></span> 添加用户
                </a></li>
                <li><a href="#">
                    <span class="glyphicon glyphicon-star" aria-hidden="true"></span> 我的个人资料
                </a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li class="active"><a href="#">文章管理 <span class="sr-only">(current)</span></a></li>
                <li><a href="">
                    <span class="glyphicon glyphicon-star" aria-hidden="true"></span> 所有文章
                </a></li>
                <li><a href="">
                    <span class="glyphicon glyphicon-star" aria-hidden="true"></span> 写文章
                </a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li class="active"><a href="#">分类管理 <span class="sr-only">(current)</span></a></li>
                <li><a href="">
                    <span class="glyphicon glyphicon-star" aria-hidden="true"></span> 所有分类
                </a></li>
                <li><a href="">
                    <span class="glyphicon glyphicon-star" aria-hidden="true"></span> 添加分类
                </a></li>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <div style="margin: 0;padding: 0;width: 330px;height: 50px; margin-left: 30%">
                <h1 style="text-align: center">添加用户</h1>
            </div>
            <div style="width: 330px;height: 350px;padding: 30px 20px;border: 1px solid #D1D1D1;border-radius: 5px;margin-left: 30%">
                <form action="/user/addOne" method="post">
                    <div class="form-group">
                        <label for="InputUsername">Username</label>
                        <input type="text" class="form-control" id="InputUsername" name="username" placeholder="Username">
                    </div>
                    <div class="form-group">
                        <label for="InputEmail">Email</label>
                        <input type="email" class="form-control" id="InputEmail" name="email" placeholder="Email">
                    </div>
                    <div class="form-group form_pass">
                        <label for="InputPassword">Password</label>
                        <input type="password" class="form-control" id="InputPassword" name="password" placeholder="Password">
                    </div>
                    <button type="submit" class="btn btn-success btn-lg btn-block">添加</button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>

