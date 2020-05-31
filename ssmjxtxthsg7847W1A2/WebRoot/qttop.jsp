<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<section id="topbar" class="d-none d-lg-block">
	<div class="container clearfix">
		<div class="contact-info float-left">
			<span class="white">欢迎来到家校通系统!</span>
		</div>
		<div class="social-links float-right line-30">
			<%
				if ((String) request.getSession().getAttribute("username") == null
						|| (String) request.getSession().getAttribute("username") == "") {
			%>
			<a href="userlog.jsp" class="twitter">登录</a><font color="#FFFFFF">
			</font><a href="jiachangxinxiadd.jsp" class="twitter">家长注册</a> </font><a
				href="zhmm.jsp" class="twitter">找回密码</a>
			<%
				} else {
			%>
			<font color="#FFFFFF"><%=request.getSession().getAttribute("username")%>,[<%=request.getSession().getAttribute("cx")%>]&nbsp;</font>
			<a href="logout.jsp" onclick="return confirm('确定要退出？')">退出</a><a
				href="main.jsp">后台</a>
			<%
				}
			%>
		</div>
	</div>
</section>

<header id="header">
	<div class="container">
		<div id="logo" class="pull-left">
			<h1>
				<a href="index.do" class="scrollto"> <img
					src="./qtimages/images/logo.png" alt="" width="60">家校通系统
				</a>
			</h1>
		</div>
		<nav id="nav-menu-container">
		<%
				if ((String) request.getSession().getAttribute("username") == null
						|| (String) request.getSession().getAttribute("username") == "") {
			%>
			<ul class='nav-menu'>
				<li class='menu-active'><a href='index.do'>首页</a></li>
				<li><a href='wjdcList.do'>问卷调查</a></li>
				<li><a href='zyList.do'>作业</a></li>
				<li><a href='ksapList.do'>考试安排</a></li>
				<li><a href='xwtzList.do?lb=校园新闻'>校园新闻</a></li>
				<li><a href='dx_detail.jsp?lb=校园公告'>校园公告</a></li>
				</li>
				<li class='menu-has-children'><a href=''>留言</a>
					<ul>
						<li><a href='lyb.jsp'>在线留言</a></li>
						<li><a href='lybList.do'>查看留言</a></li>
					</ul></li>
				<li><a href='login.jsp'>后台管理</a></li>
			</ul>
			<%
				} else {
			%>
			<ul class='nav-menu'>
				<li class='menu-active'><a href='index.do'>首页</a></li>
				<li><a href='wjdcList.do'>问卷调查</a></li>
				<li><a href='zyList.do'>作业</a></li>
				<li><a href='ksapList.do'>考试安排</a></li>
				<li><a href='xwtzList.do?lb=校园新闻'>校园新闻</a></li>
				<li><a href='dx_detail.jsp?lb=校园公告'>校园公告</a></li>
				</li>
				<li class='menu-has-children'><a href=''>留言</a>
					<ul>
						<li><a href='lyb.jsp'>在线留言</a></li>
						<li><a href='lybList.do'>查看留言</a></li>
					</ul></li>
			</ul>
			<%
				}
			%>
			
		</nav>
	</div>
</header>