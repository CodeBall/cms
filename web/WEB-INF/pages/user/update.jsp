<%--
  Created by IntelliJ IDEA.
  User: xqq
  Date: 16-5-8
  Time: 下午5:51
  Content:更新用户信息
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../Common/head.jsp" flush="true"></jsp:include>

<div style="margin: 0;padding: 0;width: 330px;height: 50px; margin-left: 30%">
  <h1 style="text-align: center">更新用户信息</h1>
  <h4 style="color: red;margin-left: 50px">${status}</h4>
</div>
<div style="width: 330px;height: 350px;padding: 30px 20px;border: 1px solid #D1D1D1;border-radius: 5px;margin-left: 30%">
  <form action="/user/update/${user.userId}" method="post">
    <div class="form-group">
      <label for="InputUsername">Username</label>
      <input type="text" class="form-control" id="InputUsername" name="username" placeholder="${user.userName}">
    </div>
    <div class="form-group">
      <label for="InputEmail">Email</label>
      <input type="email" class="form-control" id="InputEmail" name="email" placeholder="${user.email}">
    </div>
    <div class="form-group form_pass">
      <label for="InputPassword">Password</label>
      <input type="password" class="form-control" id="InputPassword" name="password" placeholder="Password">
    </div>
    <button type="submit" class="btn btn-success btn-lg btn-block">修改</button>
  </form>
</div>

<jsp:include page="../Common/foot.jsp" flush="true"></jsp:include>