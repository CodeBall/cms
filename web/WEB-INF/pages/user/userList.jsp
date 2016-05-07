<%--
  Created by IntelliJ IDEA.
  User: xqq
  Date: 16-5-7
  Time: 下午2:06
  Content:用户列表页
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>--%>
<%--<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>--%>
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
      <div style="width: 100%;height: 100px;text-align: center;"><h1>用户列表</h1></div>
      <div>
        <table class="table table-hover">
          <tr>
            <th>UserId</th>
            <th>UserName</th>
            <th>Email</th>
            <th>Alter</th>
            <th>Delete</th>
          </tr>
          <%--循环输出用户数据,使用jstl,需要下载jar包--%>
          <c:forEach items="${posts}" var="pord" varStatus="status">
            <tr>
              <td>${pord.id}</td>
              <td>${pord.userName}</td>
              <td>${pord.email}</td>
              <td><a href="#">
                <button class="btn btn-success">修改</button>
              </a></td>
              <td><a href="#">
                <button class="btn btn-success">删除</button>
              </a></td>
            </tr>
          </c:forEach>
        </table>
        <nav style="float: left">
          <ul class="pagination">
            <li><a href="#" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
            <li class="active"><a href="#">${page} <span class="sr-only">(current)</span></a></li>
            <li><a href="/user/${page}+1/10">${page+1} <span class="sr-only">(current)</span></a></li>
            <li><a href="/user/${page}+2/10">${page+2} <span class="sr-only">(current)</span></a></li>
            <li><a href="/user/${page}+3/10">${page+3} <span class="sr-only">(current)</span></a></li>
            <li><a href="/user/${page}+4/10">${page+4} <span class="sr-only">(current)</span></a></li>
            <li><a href="/user/${page}+1/10" aria-label="Previous"><span aria-hidden="true">&raquo;</span></a></li>
          </ul>
        </nav>
      </div>
    </div>
  </div>
</div>
</body>
</html>

