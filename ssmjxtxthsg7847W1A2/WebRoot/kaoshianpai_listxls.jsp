<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="kaoshianpaihsgb" scope="page" class="com.bean.KaoshianpaiBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=kaoshianpai.xls");
%>
<html>
  <head>
    <title>���԰���</title>
  </head>

  <body >
 <%
			String sql="select * from kaoshianpai  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">���</td>
    <td align='center' bgcolor='#ebf0f7'>����</td>    <td align='center' bgcolor='#ebf0f7'>�γ�����</td>    <td align='center' bgcolor='#ebf0f7'>���Һ�</td>    <td align='center' bgcolor='#ebf0f7'>����ʱ��</td>    <td align='center' bgcolor='#ebf0f7'>����ʱ��</td>    <td align='center' bgcolor='#ebf0f7'>˵��</td>    <td align='center' bgcolor='#ebf0f7'>������</td>    
	
    <td width="120" align="center" bgcolor="CCFFFF">���ʱ��</td>
    
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

