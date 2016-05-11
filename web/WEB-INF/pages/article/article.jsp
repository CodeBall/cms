<%--
  Created by IntelliJ IDEA.
  User: xqq
  Date: 16-5-11
  Time: 下午1:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../Common/head.jsp" flush="true"></jsp:include>
<div class="article">
    <div class="left">
      <div style="background-color: white">
        <div class="title">
          <h3>${title}</h3>
        </div>
        <div>
          <p style="color: #CFCFCF">作者:&nbsp;${auther}&nbsp;&nbsp;/时间:&nbsp;${time}&nbsp;&nbsp;/类别:&nbsp;${cate}</p>
          <br>
        </div>
        <div class="content">
          ${content}
        </div>
      </div>
    </div>
</div>
<jsp:include page="../Common/foot.jsp" flush="true"></jsp:include>