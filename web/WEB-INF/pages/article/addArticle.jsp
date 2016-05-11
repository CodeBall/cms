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
<div class="article">
  <form action="/article/add" method="post">
    <div class="left">
      <div class="title">
        <h3>撰写新文章</h3>
        <input type="text" name="articleName" class="form-control" placeholder="在此输入标题"/>
      </div>
      <div class="content">
        <h3>撰写文章内容</h3>
        <textarea class="form-control" name="articleContent" cols="84" rows="25" wrap="hard">
        </textarea>
      </div>
    </div>
    <div class="right">
      <div class="right_top">
        <div class="right_title">
          <h4><span>发布</span></h4>
        </div>
        <hr>
        <div class="btn_caogao">
          <button type="button" class="btn btn-default">保存草稿</button>
        </div>
        <div class="style">
          状态:
          <select name="status">
            <option value="1">发表</option>
            <option value="0">草稿</option>
          </select>
        </div>
        <div class="cate">
          分类目录:
          <select name="cateId">
            <c:forEach items="${cate}" var="pord" varStatus="status">
              <option value="${pord.cateId}">${pord.cateName}</option>
            </c:forEach>
          </select>
        </div>
        <hr>
        <div class="submit_bottom">
          <div class="bottom_left">
            <a href="#">移至回收站</a>
          </div>
          <div class="bottom_right">
            <button type="submit" class="btn btn-warning">发布</button>
          </div>
        </div>
      </div>
    </div>
  </form>
</div>
<jsp:include page="../Common/foot.jsp" flush="true"></jsp:include>