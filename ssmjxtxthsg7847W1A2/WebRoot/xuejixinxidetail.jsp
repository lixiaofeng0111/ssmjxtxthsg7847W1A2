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
<title>学籍信息</title>

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
<script language=javascript src='js/popup.js'></script>
<script language=javascript> 
function hsgpinglun(nbiao,nid){ 
popheight=450;
pop('hsgpinglun.jsp?biao='+nbiao+'&id='+nid,'在线评论',550,250) ;
}
</script> 
<%
	String id=request.getParameter("id");
	
     %>
<body id="body">
<jsp:include page="qttop.jsp"></jsp:include>
<jsp:include page="bht.jsp"></jsp:include>
  <main id="main">
   

	
    <section id="services" class="wow fadeInUp">
      <div class="container">
	   <div class="section-header">
            <h2>◇◆ 学籍信息 ◆◇</h2>
          </div>
        <div class="row">
         
		   
   <table width="100%" border="0" align="center" cellpadding="3" cellspacing="1" bordercolor="#00FFFF" style="border-collapse:collapse"  class="newsline">  
      <tr>
		 <td width='11%' height=44>学号：</td><td width='39%'>${xuejixinxi.xuehao}</td><td  rowspan=12 align=center><a href=${xuejixinxi.zhaopian} target=_blank><img src=${xuejixinxi.zhaopian}  width=228 height=215 border=0></a></td></tr><tr>         <td width='11%' height=44>姓名：</td><td width='39%'>${xuejixinxi.xingming}</td></tr><tr>         <td width='11%' height=44>性别：</td><td width='39%'>${xuejixinxi.xingbie}</td></tr><tr>                  <td width='11%' height=44>民族：</td><td width='39%'>${xuejixinxi.minzu}</td></tr><tr>         <td width='11%' height=44>籍贯：</td><td width='39%'>${xuejixinxi.jiguan}</td></tr><tr>         <td width='11%' height=44>身份证：</td><td width='39%'>******</td></tr><tr>         <td width='11%' height=44>入学时间：</td><td width='39%'>${xuejixinxi.ruxueshijian}</td></tr><tr>         <td width='11%' height=44>专业：</td><td width='39%'>${xuejixinxi.zhuanye}</td></tr><tr>         <td width='11%' height=44>院校：</td><td width='39%'>${xuejixinxi.yuanxiao}</td></tr><tr>         <td width='11%' height=44>层次：</td><td width='39%'>${xuejixinxi.cengci}</td></tr><tr>         <td width='11%' height=44>学籍状态：</td><td width='39%'>${xuejixinxi.xuejizhuangtai}</td></tr><tr>                  <td width='11%' height=44>工号：</td><td width='39%'>${xuejixinxi.gonghao}</td></tr><tr>         <td width='11%' height=100  >备注：</td><td width='39%' colspan=2 height=100 >${xuejixinxi.gonghao}</td></tr><tr><td colspan=3 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" /> <!--jixaaxnnxiu--></td></tr>
    
  </table>
						  
        </div>
      </div>
    </section>
	
	<jsp:include page="qtdown.jsp"></jsp:include>
  </main>
  
</body> 
</html>
