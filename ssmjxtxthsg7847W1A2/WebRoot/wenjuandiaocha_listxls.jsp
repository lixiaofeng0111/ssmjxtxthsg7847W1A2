<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="wenjuandiaochahsgb" scope="page" class="com.bean.WenjuandiaochaBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=wenjuandiaocha.xls");
%>
<html>
  <head>
    <title>问卷调查</title>
  </head>

  <body >
 <%
			String sql="select * from wenjuandiaocha  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center' bgcolor='#ebf0f7'>编号</td>    <td align='center' bgcolor='#ebf0f7'>问题1</td>    <td align='center' bgcolor='#ebf0f7'>问题2</td>    <td align='center' bgcolor='#ebf0f7'>问题3</td>    <td align='center' bgcolor='#ebf0f7'>问题4</td>    <td align='center' bgcolor='#ebf0f7'>发布人</td>    
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=wenjuandiaochahsgb.getAllWenjuandiaocha(8);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.bianhao}</td>    <td>${u.wenti1}</td>    <td>${u.wenti2}</td>    <td>${u.wenti3}</td>    <td>${u.wenti4}</td>    <td>${u.faburen}</td>    
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

