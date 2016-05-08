<%--
  Created by IntelliJ IDEA.
  User: xqq
  Date: 16-5-7
  Time: 下午2:06
  Content:用户列表页
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../Common/head.jsp" flush="true"></jsp:include>

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
              <td><a href="/user/update/${pord.id}">
                <button class="btn btn-success">修改</button>
              </a></td>
              <td><a href="/user/delete/${pord.id}">
                <button class="btn btn-success">删除</button>
              </a></td>
            </tr>
          </c:forEach>
        </table>
        <nav style="float: left">
          <ul class="pagination">
            <li><a href="/user/${page-1}/10" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
            <li class="active"><a href="#">${page} <span class="sr-only">(current)</span></a></li>
            <li><a href="/user/${page+1}/10">${page+1} <span class="sr-only">(current)</span></a></li>
            <li><a href="/user/${page+2}/10">${page+2} <span class="sr-only">(current)</span></a></li>
            <li><a href="/user/${page+3}/10">${page+3} <span class="sr-only">(current)</span></a></li>
            <li><a href="/user/${page+4}/10">${page+4} <span class="sr-only">(current)</span></a></li>
            <li><a href="/user/${page+1}/10" aria-label="Previous"><span aria-hidden="true">&raquo;</span></a></li>
          </ul>
        </nav>
      </div>
    <jsp:include page="../Common/foot.jsp" flush="true"></jsp:include>

