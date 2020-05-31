<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>考试安排详细</title>
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   

  </head>

  <body >

  考试安排详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>场次：</td><td width='39%'>${kaoshianpai.changci}</td>     <td width='11%'>课程名称：</td><td width='39%'>${kaoshianpai.kechengmingcheng}</td></tr><tr>     <td width='11%'>教室号：</td><td width='39%'>${kaoshianpai.jiaoshihao}</td>     <td width='11%'>考试时间：</td><td width='39%'>${kaoshianpai.kaoshishijian}</td></tr><tr>     <td width='11%'>考试时段：</td><td width='39%'>${kaoshianpai.kaoshishiduan}</td>     <td width='11%'>说明：</td><td width='39%'>${kaoshianpai.shuoming}</td></tr><tr>     <td width='11%'>发布人：</td><td width='39%'>${kaoshianpai.faburen}</td>     <td>&nbsp;</td><td>&nbsp;</td></tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;</td></tr>
    
  </table>

  </body>
</html>

