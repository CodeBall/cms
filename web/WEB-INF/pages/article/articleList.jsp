<%--
  Created by IntelliJ IDEA.
  User: xqq
  Date: 16-5-9
  Time: 下午5:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../Common/head.jsp" flush="true"></jsp:include>
<div style="width: 100%;height: 100px;text-align: center;"><h1>文章列表</h1></div>
<div>
  <table class="table table-hover">
    <tr>
      <th>标题</th>
      <th>作者</th>
      <th>分类目录</th>
      <th>日期</th>
      <th>状态</th>
      <th>编辑</th>
      <th>删除</th>
    </tr>
    <%--循环输出用户数据,使用jstl,需要下载jar包--%>
    <c:forEach items="${posts}" var="pord" varStatus="status">
      <tr>
        <td><a href="/article/get/${pord.id}">${pord.title}</a></td>
        <td>${pord.author}</td>
        <td>${pord.cate}</td>
        <td>${pord.time}</td>
        <td><c:if test="${pord.del == 0}">草稿</c:if><c:if test="${pord.del == 1}">已发表</c:if></td>
        <td><a href="/article/update/${pord.id}">
          <button class="btn btn-success">编辑</button>
        </a></td>
        <td><a href="/article/delete/${pord.id}">
          <button class="btn btn-success">删除</button>
        </a></td>
      </tr>
    </c:forEach>
  </table>
  <nav style="float: left">
    <ul class="pagination">
      <li><a href="/article/${page-1}/10" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
      <li class="active"><a href="#">${page} <span class="sr-only">(current)</span></a></li>
      <li><a href="/article/${page+1}/10">${page+1} <span class="sr-only">(current)</span></a></li>
      <li><a href="/article/${page+2}/10">${page+2} <span class="sr-only">(current)</span></a></li>
      <li><a href="/article/${page+3}/10">${page+3} <span class="sr-only">(current)</span></a></li>
      <li><a href="/article/${page+4}/10">${page+4} <span class="sr-only">(current)</span></a></li>
      <li><a href="/article/${page+1}/10" aria-label="Previous"><span aria-hidden="true">&raquo;</span></a></li>
    </ul>
  </nav>
</div>
<jsp:include page="../Common/foot.jsp" flush="true"></jsp:include>