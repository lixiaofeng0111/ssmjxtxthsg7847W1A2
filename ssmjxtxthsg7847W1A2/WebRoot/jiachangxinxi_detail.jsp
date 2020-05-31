<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>家长信息详细</title>
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   

  </head>

  <body >

  家长信息详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>用户名：</td><td width='39%'>${jiachangxinxi.yonghuming}</td>     <td width='11%'>密码：</td><td width='39%'>${jiachangxinxi.mima}</td></tr><tr>     <td width='11%'>姓名：</td><td width='39%'>${jiachangxinxi.xingming}</td>     <td width='11%'>性别：</td><td width='39%'>${jiachangxinxi.xingbie}</td></tr><tr>     <td width='11%'>电话：</td><td width='39%'>${jiachangxinxi.dianhua}</td>     <td width='11%'>身份证：</td><td width='39%'>${jiachangxinxi.shenfenzheng}</td>     </tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;</td></tr>
    
  </table>

  </body>
</html>

