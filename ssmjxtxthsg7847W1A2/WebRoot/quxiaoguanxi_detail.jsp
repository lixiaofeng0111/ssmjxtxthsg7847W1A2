<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>取消关系详细</title>
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   

  </head>

  <body >

  取消关系详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>用户名：</td><td width='39%'>${quxiaoguanxi.yonghuming}</td>     <td width='11%'>性别：</td><td width='39%'>${quxiaoguanxi.xingbie}</td></tr><tr>     <td width='11%'>电话：</td><td width='39%'>${quxiaoguanxi.dianhua}</td>     <td width='11%'>身份证：</td><td width='39%'>${quxiaoguanxi.shenfenzheng}</td></tr><tr>     <td width='11%'>学号：</td><td width='39%'>${quxiaoguanxi.xuehao}</td>     <td width='11%'>学生姓名：</td><td width='39%'>${quxiaoguanxi.xueshengxingming}</td></tr><tr>     <td width='11%'>学生关系：</td><td width='39%'>${quxiaoguanxi.xueshengguanxi}</td>     <td width='11%'>取消原因：</td><td width='39%'>${quxiaoguanxi.quxiaoyuanyin}</td>     </tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;</td></tr>
    
  </table>

  </body>
</html>

