<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>作业详细</title>
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   

  </head>

  <body >

  作业详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>作业编号：</td><td width='39%'>${zuoye.zuoyebianhao}</td>     <td width='11%'>作业名称：</td><td width='39%'>${zuoye.zuoyemingcheng}</td></tr><tr>     <td width='11%'>作业类型：</td><td width='39%'>${zuoye.zuoyeleixing}</td>     <td width='11%'>内容：</td><td width='39%'>${zuoye.neirong}</td></tr><tr>     <td width='11%'>附件：</td><td width='39%'><a href="${zuoye.fujian}">点此下载</a></td>     <td width='11%'>要求时间：</td><td width='39%'>${zuoye.yaoqiushijian}</td></tr><tr>     <td width='11%'>课程：</td><td width='39%'>${zuoye.kecheng}</td>     <td width='11%'>发布人：</td><td width='39%'>${zuoye.faburen}</td>     </tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;</td></tr>
    
  </table>

  </body>
</html>

