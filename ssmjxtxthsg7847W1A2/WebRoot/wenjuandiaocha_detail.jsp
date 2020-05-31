<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>问卷调查详细</title>
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   

  </head>

  <body >

  问卷调查详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>编号：</td><td width='39%'>${wenjuandiaocha.bianhao}</td>     <td width='11%'>问题1：</td><td width='39%'>${wenjuandiaocha.wenti1}</td></tr><tr>     <td width='11%'>问题2：</td><td width='39%'>${wenjuandiaocha.wenti2}</td>     <td width='11%'>问题3：</td><td width='39%'>${wenjuandiaocha.wenti3}</td></tr><tr>     <td width='11%'>问题4：</td><td width='39%'>${wenjuandiaocha.wenti4}</td>     <td width='11%'>发布人：</td><td width='39%'>${wenjuandiaocha.faburen}</td>     </tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;</td></tr>
    
  </table>

  </body>
</html>

