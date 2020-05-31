﻿<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>

<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>
<script type="text/javascript" src="js/popup.js"></script>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
<!DOCTYPE html>
<html lang="en">
<head>
<title>考试安排</title>

  <meta content="width=device-width, initial-scale=1.0" name="viewport">
  <meta content="Author" name="WebThemez">
  <link href="qtimages/images/apple-touch-icon.png" rel="apple-touch-icon">
  <link href="qtimages/lib/font-awesome/css/font-awesome.min.css" rel="stylesheet">
  <link href="qtimages/lib/animate/animate.min.css" rel="stylesheet">
  <link href="qtimages/lib/ionicons/css/ionicons.min.css" rel="stylesheet">
  <link href="qtimages/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
  <link href="qtimages/lib/magnific-popup/magnific-popup.css" rel="stylesheet">
  <link href="qtimages/lib/ionicons/css/ionicons.min.css" rel="stylesheet">
  <link href="qtimages/lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="qtimages/css/style.css" rel="stylesheet">
  <link rel="stylesheet" href="qtimages/css/custom.css">
</head>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>

<%

%>

<body id="body">
<jsp:include page="qttop.jsp"></jsp:include>
<jsp:include page="bht.jsp"></jsp:include>
  <main id="main">
   

	
    <section id="services" class="wow fadeInUp">
      <div class="container">
	   <div class="section-header">
            <h2>◇◆ 考试安排 ◆◇</h2>
          </div>
        <div class="row">
         
		   <link rel="stylesheet" href="images/hsgcommon/divqt.css" type="text/css">    
<form action="ksapList.do" name="myform" method="post" style="width:100%">
									查询   场次：<input name="changci" type="text" id="changci" class="form-control2" />  课程名称：<input name="kechengmingcheng" type="text" id="kechengmingcheng" class="form-control2" />  教室号：<input name="jiaoshihao" type="text" id="jiaoshihao" class="form-control2" /> 考试时间：<select name='kaoshishijian' id='kaoshishijian' class="form-control2"><option value="">所有</option><option value="周一">周一</option><option value="周二">周二</option><option value="周三">周三</option><option value="周四">周四</option><option value="周五">周五</option><option value="周六">周六</option><option value="周日">周日</option></select> 考试时段：<select name='kaoshishiduan' id='kaoshishiduan' class="form-control2"><option value="">所有</option><option value="上午">上午</option><option value="下午">下午</option></select>
									<input type="submit" value="查询" /> 
								</form>	

	
<br />
<table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#ebf0f7">
                          <tr>
                            <td align="center" bgcolor="#ebf0f7" width="30px">序号</td>
                            <td bgcolor='#ebf0f7'>场次</td>    <td bgcolor='#ebf0f7'>课程名称</td>    <td bgcolor='#ebf0f7'>教室号</td>    <td bgcolor='#ebf0f7'>考试时间</td>    <td bgcolor='#ebf0f7'>考试时段</td>    <td bgcolor='#ebf0f7'>说明</td>    <td bgcolor='#ebf0f7'>发布人</td>    
                            <td align="center" bgcolor="#ebf0f7" width="150px"> 添加时间 </td>
                            <td align="center" bgcolor="#ebf0f7" width="50px"> 操作 </td>
                          </tr>
                          <%
					int i=0;
				%>
                          <c:forEach items="${list}" var="u">
                            <%
					i++;
				%>
                            <tr align="center" bgcolor="#FFFFFF">
                              <td align="center"><%=i%></td>
                             <td>${u.changci}</td>    <td>${u.kechengmingcheng}</td>    <td>${u.jiaoshihao}</td>    <td>${u.kaoshishijian}</td>    <td>${u.kaoshishiduan}</td>    <td>${u.shuoming}</td>    <td>${u.faburen}</td>    
                              <td align="center"> ${u.addtime} </td>
                              <td align="center"><a href="ksapDetail.do?id=${u.id}">详细</a></td>
                            </tr>
                          </c:forEach>
                        </table>
<br>

<p align="center"> <c:if test="${sessionScope.p==1 }">
		 <c:if test="${page.page>1}">
              <a href="ksapList.do?page=1" >首页</a>
             <a href="ksapList.do?page=${page.page-1 }"> 上一页</a>             </c:if>
    	     <c:if test="${page.page<page.totalPage}">
			<a href="ksapList.do?page=${page.page+1 }">下一页</a>
			<a href="ksapList.do?page=${page.totalPage }">末页</a>		    </c:if>		
	</c:if>
	</p>




						  
        </div>
      </div>
    </section>
	
	<jsp:include page="qtdown.jsp"></jsp:include>
  </main>
  
</body> 
</html>
