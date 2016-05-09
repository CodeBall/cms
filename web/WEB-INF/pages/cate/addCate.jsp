<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: xqq
  Date: 16-5-8
  Time: 下午8:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../Common/head.jsp" flush="true"></jsp:include>
<div style="margin: 0;padding: 0;width: 330px;height: 50px; margin-left: 30%">
  <h1 style="text-align: center">添加分类</h1>
</div>
<div style="width: 330px;height: 350px;padding: 30px 20px;border: 1px solid #D1D1D1;border-radius: 5px;margin-left: 30%">
  <form action="/cate/add" method="post">
    <div class="form-group">
      <label for="InputUsername">Catename</label>
      <input type="text" class="form-control" id="InputUsername" name="cateName" placeholder="catename">
    </div>
    <div class="form-group">
      <label for="InputEmail">Parent:</label>
      <select name="parent" id="InputEmail">
        <c:forEach items="${cate}" var="pord" varStatus="status">
          <option value="${pord.cateId}">${pord.cateName}</option>
        </c:forEach>
      </select>
    </div>
    <button type="submit" class="btn btn-success btn-lg btn-block">添加</button>
  </form>
</div>
<jsp:include page="../Common/foot.jsp" flush="true"></jsp:include>
