<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="quxiaoguanxihsgb" scope="page" class="com.bean.QuxiaoguanxiBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=quxiaoguanxi.xls");
%>
<html>
  <head>
    <title>ȡ����ϵ</title>
  </head>

  <body >
 <%
			String sql="select * from quxiaoguanxi  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">���</td>
    <td align='center' bgcolor='#ebf0f7'>�û���</td>    <td  width='40' align='center' bgcolor='#ebf0f7'>�Ա�</td>    <td align='center' bgcolor='#ebf0f7'>�绰</td>    <td align='center' bgcolor='#ebf0f7'>���֤</td>    <td align='center' bgcolor='#ebf0f7'>ѧ��</td>    <td align='center' bgcolor='#ebf0f7'>ѧ������</td>    <td align='center' bgcolor='#ebf0f7'>ѧ����ϵ</td>    <td align='center' bgcolor='#ebf0f7'>ȡ��ԭ��</td>    <td  width='80' align='center' bgcolor='#ebf0f7'>�Ƿ����</td>
	
    <td width="120" align="center" bgcolor="CCFFFF">���ʱ��</td>
    
  </tr>
   <%		
				List pagelist3=quxiaoguanxihsgb.getAllQuxiaoguanxi(11);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.yonghuming}</td>    <td align='center' bgcolor='#ebf0f7'>${u.xingbie}</td>    <td>${u.dianhua}</td>    <td>${u.shenfenzheng}</td>    <td>${u.xuehao}</td>    <td>${u.xueshengxingming}</td>    <td>${u.xueshengguanxi}</td>    <td>${u.quxiaoyuanyin}</td>    <td align='center'>${u.issh} <input type="button" value="���" onclick="javascript:location.href='sh.jsp?id=${u.id}&yuan=${u.issh}&tablename=quxiaoguanxi'"/></td>
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

