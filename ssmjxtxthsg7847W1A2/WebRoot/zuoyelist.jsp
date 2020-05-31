<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*"%>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db" />

<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"
	charset="gb2312"></script>
<script type="text/javascript" src="js/popup.js"></script>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
<!DOCTYPE html>
<html lang="en">
<head>
<title>作业</title>

<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="Author" name="WebThemez">
<link href="qtimages/images/apple-touch-icon.png" rel="apple-touch-icon">
<link href="qtimages/lib/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<link href="qtimages/lib/animate/animate.min.css" rel="stylesheet">
<link href="qtimages/lib/ionicons/css/ionicons.min.css" rel="stylesheet">
<link href="qtimages/lib/owlcarousel/assets/owl.carousel.min.css"
	rel="stylesheet">
<link href="qtimages/lib/magnific-popup/magnific-popup.css"
	rel="stylesheet">
<link href="qtimages/lib/ionicons/css/ionicons.min.css" rel="stylesheet">
<link href="qtimages/lib/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="qtimages/css/style.css" rel="stylesheet">
<link rel="stylesheet" href="qtimages/css/custom.css">
</head>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"
	charset="gb2312"></script>

<%
	
%>

<body id="body">
	<jsp:include page="qttop.jsp"></jsp:include>
	<jsp:include page="bht.jsp"></jsp:include>
	<main id="main">



	<section id="services" class="wow fadeInUp">
		<div class="container">
			<div class="section-header">
				<h2>◇◆ 作业 ◆◇</h2>
			</div>
			<div class="row">

				<link rel="stylesheet" href="images/hsgcommon/divqt.css"
					type="text/css">
				<form action="zyList.do" name="myform" method="post"
					style="width: 100%">
					作业编号：<input name="zuoyebianhao" type="text" id="zuoyebianhao"
						class="form-control2" /> 作业名称：<input name="zuoyemingcheng"
						type="text" id="zuoyemingcheng" class="form-control2" /> 作业类型：<select
						name='zuoyeleixing' id='zuoyeleixing' class="form-control2"><option
							value="">所有</option>
						<option value="课后练习">课后练习</option>
						<option value="模拟试卷">模拟试卷</option>
						<option value="例年真题">例年真题</option></select> 课程：<input name="kecheng"
						type="text" id="kecheng" class="form-control2" /> 发布人：<input
						name="faburen" type="text" id="faburen" class="form-control2" />
					<input type="submit" value="查询" />
				</form>


				<br />
				<table width="100%" border="0" align="center" cellpadding="4"
					cellspacing="1" bgcolor="#ebf0f7">
					<tr>
						<td align="center" bgcolor="#ebf0f7" width="30px">序号</td>
						<td bgcolor='#ebf0f7'>作业编号</td>
						<td bgcolor='#ebf0f7'>作业名称</td>
						<td bgcolor='#ebf0f7'>作业类型</td>

						<td bgcolor='#ebf0f7'>附件</td>
						<td bgcolor='#ebf0f7' width='65' align='center'>要求时间</td>
						<td bgcolor='#ebf0f7'>课程</td>
						<td bgcolor='#ebf0f7'>发布人</td>

						<td align="center" bgcolor="#ebf0f7" width="150px">添加时间</td>
						<td align="center" bgcolor="#ebf0f7" width="50px">操作</td>
					</tr>
					<%
						int i = 0;
					%>
					<c:forEach items="${list}" var="u">
						<%
							i++;
						%>
						<tr align="center" bgcolor="#FFFFFF">
							<td align="center"><%=i%></td>
							<td>${u.zuoyebianhao}</td>
							<td>${u.zuoyemingcheng}</td>
							<td>${u.zuoyeleixing}</td>

							<td><a href='${u.fujian}' target='_blank'>下载</a></td>
							<td>${u.yaoqiushijian}</td>
							<td>${u.kecheng}</td>
							<td>${u.faburen}</td>

							<td align="center">${u.addtime}</td>
							<td align="center"><a href="zyDetail.do?id=${u.id}">详细</a></td>
						</tr>
					</c:forEach>
				</table>
				<br>

				<p align="center">
					<c:if test="${sessionScope.p==1 }">
						<c:if test="${page.page>1}">
							<a href="zyList.do?page=1">首页</a>
							<a href="zyList.do?page=${page.page-1 }"> 上一页</a>
						</c:if>
						<c:if test="${page.page<page.totalPage}">
							<a href="zyList.do?page=${page.page+1 }">下一页</a>
							<a href="zyList.do?page=${page.totalPage }">末页</a>
						</c:if>
					</c:if>
				</p>





			</div>
		</div>
	</section>

	<jsp:include page="qtdown.jsp"></jsp:include> </main>

</body>
</html>
