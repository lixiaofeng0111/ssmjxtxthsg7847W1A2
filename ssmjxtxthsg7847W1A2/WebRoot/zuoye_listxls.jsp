<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="zuoyehsgb" scope="page" class="com.bean.ZuoyeBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=zuoye.xls");
%>
<html>
  <head>
    <title>作业</title>
  </head>

  <body >
 <%
			String sql="select * from zuoye  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center' bgcolor='#ebf0f7'>作业编号</td>    <td align='center' bgcolor='#ebf0f7'>作业名称</td>    <td align='center' bgcolor='#ebf0f7'>作业类型</td>        <td  width='90' align='center' bgcolor='#ebf0f7'>附件</td>    <td  width='65' align='center' bgcolor='#ebf0f7'>要求时间</td>    <td align='center' bgcolor='#ebf0f7'>课程</td>    <td align='center' bgcolor='#ebf0f7'>发布人</td>    
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=zuoyehsgb.getAllZuoye(10);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.zuoyebianhao}</td>    <td>${u.zuoyemingcheng}</td>    <td>${u.zuoyeleixing}</td>        <td width='90' align='center' bgcolor='#ebf0f7'><a class="btn btn-info btn-small" href='${u.fujian}' target='_blank'>下载</a></td>    <td>${u.yaoqiushijian}</td>    <td>${u.kecheng}</td>    <td>${u.faburen}</td>    
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

