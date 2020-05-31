<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>学生关系申请详细</title>
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   

  </head>

  <body >

  学生关系申请详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>用户名：</td><td width='39%'>${xueshengguanxishenqing.yonghuming}</td>     <td width='11%'>姓名：</td><td width='39%'>${xueshengguanxishenqing.xingming}</td></tr><tr>     <td width='11%'>性别：</td><td width='39%'>${xueshengguanxishenqing.xingbie}</td>     <td width='11%'>电话：</td><td width='39%'>${xueshengguanxishenqing.dianhua}</td></tr><tr>     <td width='11%'>身份证：</td><td width='39%'>${xueshengguanxishenqing.shenfenzheng}</td>     <td width='11%'>学号：</td><td width='39%'>${xueshengguanxishenqing.xuehao}</td></tr><tr>     <td width='11%'>学生姓名：</td><td width='39%'>${xueshengguanxishenqing.xueshengxingming}</td>     <td width='11%'>学生关系：</td><td width='39%'>${xueshengguanxishenqing.xueshengguanxi}</td>     </tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;</td></tr>
    
  </table>

  </body>
</html>

