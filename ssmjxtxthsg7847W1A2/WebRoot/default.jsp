<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.util.db"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*"%>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db" />
<!DOCTYPE html>
<html lang="en">

<head>
<title>家校通系统</title>
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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>

<body id="body">
	<jsp:include page="qttop.jsp"></jsp:include>
	<jsp:include page="bht.jsp"></jsp:include>
	<main id="main">
		<section>
			<div id="news" class="mt-20 wow fadeInUp">
				<div class="container">
					<div>
						<div class="section-header">
							<h2>◇◆ 校园新闻 ◆◇</h2>
						</div>
						<div class="row">
							<div class="col-md-7">
								<div class="row">
									<div class="col-md-4">
										<img src="./qtimages/images/news/2.png" alt="" width="163px"
											height="200">
									</div>
									<div class="col-md-7">
										<ul class="news-list">
											<%
												int xwi = 0;
											%>
											<c:forEach items="${syxinwentongzhi1}" var="a">
												<%
													xwi++;
												if (xwi <= 8) {
												%>
												<li style="width:330px"><a href="xwtzDetail.do?id=${a.id}">>
														${fn:substring(a.biaoti, 0, 30)}</a></li>
												<%
													}
												%>
											</c:forEach>
										</ul>
									</div>
								</div>
							</div>
							<div class="col-md-5">
							<div class="row">
									<div class="col-md-1" style="margin-left: -97px;">
										<img  src="./qtimages/images/news/gushi.png" alt="" width="163px"
											height="200">
									</div>
									<div class="col-md-4" style="width:100px">
										<ul class="news-list" style="padding-left:180px">
											<%
												int gushi = 0;
											%>
											<c:forEach items="${xiaoyuangushi}" var="b">
												<%
												gushi++;
												if (gushi <= 8) {
												%>
												<li style="width:330px"><a href="xwtzDetail.do?id=${b.id}">
														>${fn:substring(b.biaoti, 0, 30)}</a></li>
												<%
													}
												%>
											</c:forEach>
										</ul>
									</div>
							</div>
							</div>
						</div>
					</div>
					<div></div>
				</div>
			</div>
		</section>
		<jsp:include page="qtdown.jsp"></jsp:include>
	</main>
</body>
</html>