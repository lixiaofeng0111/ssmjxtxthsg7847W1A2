<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>学籍信息详细</title>
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   

  </head>

  <body >

  学籍信息详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%' height=44>学号：</td><td width='39%'>${xuejixinxi.xuehao}</td><td  rowspan=12 align=center><a href=${xuejixinxi.zhaopian} target=_blank><img src=${xuejixinxi.zhaopian} width=228 height=215 border=0></a></td></tr><tr><td width='11%' height=44>姓名：</td><td width='39%'>${xuejixinxi.xingming}</td></tr><tr><td width='11%' height=44>性别：</td><td width='39%'>${xuejixinxi.xingbie}</td></tr><tr><td width='11%' height=44>民族：</td><td width='39%'>${xuejixinxi.minzu}</td></tr><tr><td width='11%' height=44>籍贯：</td><td width='39%'>${xuejixinxi.jiguan}</td></tr><tr><td width='11%' height=44>身份证：</td><td width='39%'>${xuejixinxi.shenfenzheng}</td></tr><tr><td width='11%' height=44>入学时间：</td><td width='39%'>${xuejixinxi.ruxueshijian}</td></tr><tr><td width='11%' height=44>专业：</td><td width='39%'>${xuejixinxi.zhuanye}</td></tr><tr><td width='11%' height=44>院校：</td><td width='39%'>${xuejixinxi.yuanxiao}</td></tr><tr><td width='11%' height=44>层次：</td><td width='39%'>${xuejixinxi.cengci}</td></tr><tr><td width='11%' height=44>学籍状态：</td><td width='39%'>${xuejixinxi.xuejizhuangtai}</td></tr><tr><td width='11%' height=44>工号：</td><td width='39%'>${xuejixinxi.gonghao}</td></tr><tr><td width='11%' height=100  >备注：</td><td width='39%' colspan=2 height=100 >${xuejixinxi.beizhu}</td></tr><tr><td colspan=3 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;</td></tr>
    
  </table>

  </body>
</html>

