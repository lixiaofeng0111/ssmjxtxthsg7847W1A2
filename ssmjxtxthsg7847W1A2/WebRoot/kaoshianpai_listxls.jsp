<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="kaoshianpaihsgb" scope="page" class="com.bean.KaoshianpaiBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=kaoshianpai.xls");
%>
<html>
  <head>
    <title>考试安排</title>
  </head>

  <body >
 <%
			String sql="select * from kaoshianpai  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center' bgcolor='#ebf0f7'>场次</td>    <td align='center' bgcolor='#ebf0f7'>课程名称</td>    <td align='center' bgcolor='#ebf0f7'>教室号</td>    <td align='center' bgcolor='#ebf0f7'>考试时间</td>    <td align='center' bgcolor='#ebf0f7'>考试时段</td>    <td align='center' bgcolor='#ebf0f7'>说明</td>    <td align='center' bgcolor='#ebf0f7'>发布人</td>    
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=kaoshianpaihsgb.getAllKaoshianpai(9);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.changci}</td>    <td>${u.kechengmingcheng}</td>    <td>${u.jiaoshihao}</td>    <td>${u.kaoshishijian}</td>    <td>${u.kaoshishiduan}</td>    <td>${u.shuoming}</td>    <td>${u.faburen}</td>    
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

