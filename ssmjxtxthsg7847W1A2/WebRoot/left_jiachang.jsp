<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<style media="all" type="text/css">
html {
	scrollbar-3d-light-color: #C3DAF9;
	scrollbar-face-color: #C3DAF9;
	scrollbar-highlight-color: #C3DAF9;
	scrollbar-shadow-color: #C3DAF9;
	scrollbar-arrow-color: #fff;
	scrollbar-base-color: #C3DAF9;
	scrollbar-dark-shadow-color: #C3DAF9;
	scrollbar-darkshadow-Color: #C3DAF9;
}

body, img, p, h1, h2, h3, h4, ul, dl, dt, dd {
	margin: 0px;
	border: 0px;
	padding: 0px;
}

body, h1, button, input, select, textarea, fieldset, td {
	font: 12px/1.5 microsoft yahei, sans-serif, \5b8b\4f53;
}

body {
	color: #000;
	margin: 0px;
	padding-left: 3px;
	background-color: #c9defa;
}

a:link, a:visited {
	color: #333;
	text-decoration: none;
}

a:hover, a:active {
	color: #f60;
	text-decoration: underline;
}

li {
	list-style: none;
}

h2, h3, h4, input {
	font-size: 12px;
}

.clear {
	clear: both;
	height: 0;
	line-height: 0;
	font-size: 0
}

.main h3, .main li {
	background: url(images/index_bg.png) no-repeat;
}

.main .menutitle {
	background-position: 0 -27px;
}

.main h3 {
	width: 160px;
	height: 21px;
	background-position: 0 0;
	padding-top: 6px;
	cursor: pointer
}

.main h3 div {
	background: url(images/iconall.png) no-repeat;
	padding-left: 30px;
	height: 16px;
	line-height: 16px
}

.main h3 .bt1 {
	background-position: 6px 0;
}

.main h3 .bt2 {
	background-position: 6px -21px;
}

.main h3 .bt3 {
	background-position: 6px -44px;
}

.main h3 .bt4 {
	background-position: 6px -64px;
}

.main h3 .bt5 {
	background-position: 6px -84px;
}

.main h3 .bt6 {
	background-position: 6px -102px;
}

.main h3 .bt7 {
	background-position: 6px -123px;
}

.main h3 .bt8 {
	background-position: 6px -144px;
}

.main h3 .bt9 {
	background-position: 6px -166px;
}

.main h3 .bt10 {
	background-position: 6px -188px;
}

.main h3 .bt11 {
	background-position: 6px -236px;
}

.main h3 .bt12 {
	background-position: 6px -213px;
}

.main h3 .bt13 {
	background-position: 6px 0;
}

.main h3 .bt14 {
	background-position: 6px -21px;
}

.main h3 .bt15 {
	background-position: 6px -44px;
}

.main h3 .bt16 {
	background-position: 6px -64px;
}

.main h3 .bt17 {
	background-position: 6px -84px;
}

.main h3 .bt18 {
	background-position: 6px -102px;
}

.main h3 .bt19 {
	background-position: 6px -123px;
}

.main h3 .bt20 {
	background-position: 6px -144px;
}

.main h3 .bt21 {
	background-position: 6px -166px;
}

.main h3 .bt22 {
	background-position: 6px -188px;
}

.main h3 .bt23 {
	background-position: 6px -236px;
}

.main h3 .bt24 {
	background-position: 6px -213px;
}

.main h3 .bt25 {
	background-position: 6px 0;
}

.main h3 .bt26 {
	background-position: 6px -21px;
}

.main h3 .bt27 {
	background-position: 6px -44px;
}

.main h3 .bt28 {
	background-position: 6px -64px;
}

.main h3 .bt29 {
	background-position: 6px -84px;
}

.main h3 .bt30 {
	background-position: 6px -102px;
}

.main h3 .bt31 {
	background-position: 6px -123px;
}

.main h3 .bt32 {
	background-position: 6px -144px;
}

.main h3 .bt33 {
	background-position: 6px -166px;
}

.main h3 .bt34 {
	background-position: 6px -188px;
}

.main h3 .bt35 {
	background-position: 6px -236px;
}

.main h3 .bt36 {
	background-position: 6px -213px;
}

.main ul {
	background: #ecf4ff;
	width: 160px;
	padding: 3px 0;
}

.main li {
	background-position: 6px -62px;
	padding-left: 18px;
	height: 25px;
	line-height: 25px;
	border-bottom: 1px solid #fff;
}

.main li .menustyle02, .main li .menustyle02:visited {
	color: Red;
}
</style>
</head>
<body style="margin: 0; border: 0;">
	<div class="main" id="menua">

		<h3 menuid="1" id="menu1" onclick="showsubmenu(1)" toggleGroup="on"
			class="menutitle">
			<div class="bt1">
				<span>个人资料管理</span>
			</div>
		</h3>
		<ul id="submenu1">
			<li><a href="doUpdateJiachangxinxi2.do" target="hsgmain">修改个人资料</a></li>


		</ul>
		<h3 menuid="3" id="menu3" onclick="showsubmenu(3)" toggleGroup="on"
			class="menutitle">
			<div class="bt3">
				<span>学生关系申请管理</span>
			</div>
		</h3>
		<ul id="submenu3">
			<li><a href="xueshengguanxishenqing_add.jsp" target="hsgmain">学生关系申请添加</a></li>
			<li><a href="xueshengguanxishenqingList2.do" target="hsgmain">学生关系申请查询</a></li>

		</ul>
		<h3 menuid="4" id="menu4" onclick="showsubmenu(4)" toggleGroup="on"
			class="menutitle">
			<div class="bt4">
				<span>取消关系管理</span>
			</div>
		</h3>
		<ul id="submenu4">
			<li><a href="xueshengguanxishenqingList3.do" target="hsgmain">取消关系添加</a></li>
			<li><a href="quxiaoguanxiList2.do" target="hsgmain">取消关系查询</a></li>

		</ul>
		<h3 menuid="5" id="menu5" onclick="showsubmenu(5)" toggleGroup="on"
			class="menutitle">
			<div class="bt5">
				<span>回答管理</span>
			</div>
		</h3>
		<ul id="submenu5">
			<li><a href="huidaList2.do" target="hsgmain">回答查询</a></li>

		</ul>
		<h3 menuid="15" id="menu15" onclick="showsubmenu(15)" toggleGroup="on"
			class="menutitle">
			<div class="bt15">
				<span>留言</span>
			</div>
		</h3>
		<ul id="submenu15">
			<li><a href="liuyanbanList.do" target="hsgmain">留言</a></li>
		</ul>





	</div>
	<script type="text/javascript">
		function initmenu() {
			var menu = document.getElementById("menua").getElementsByTagName(
					"h3");
			var submenu = document.getElementById("menua")
					.getElementsByTagName("ul");
			for (var i = 0; i < menu.length; i++) {
				menu[i].className = "menutitle2";
			}
			for (var i = 0; i < submenu.length; i++) {
				submenu[i].style.display = "none";
			}
		}
		function showsubmenu(index) {
			var menu = document.getElementById("menu" + index);
			var submenu = document.getElementById("submenu" + index);
			if (submenu.style.display == "") {
				menu.className = "menutitle2";
				submenu.style.display = "none";
			} else {
				menu.className = "menutitle";
				submenu.style.display = "";
			}
		}
		initmenu();
	</script>
	</form>
</body>
</html>