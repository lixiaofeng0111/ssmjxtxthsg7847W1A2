<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="xueshengguanxishenqinghsgb" scope="page" class="com.bean.XueshengguanxishenqingBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=xueshengguanxishenqing.xls");
%>
<html>
  <head>
    <title>学生关系申请</title>
  </head>

  <body >
 <%
			String sql="select * from xueshengguanxishenqing  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center' bgcolor='#ebf0f7'>用户名</td>    <td align='center' bgcolor='#ebf0f7'>姓名</td>    <td  width='40' align='center' bgcolor='#ebf0f7'>性别</td>    <td align='center' bgcolor='#ebf0f7'>电话</td>    <td align='center' bgcolor='#ebf0f7'>身份证</td>    <td align='center' bgcolor='#ebf0f7'>学号</td>    <td align='center' bgcolor='#ebf0f7'>学生姓名</td>    <td align='center' bgcolor='#ebf0f7'>学生关系</td>    <td  width='80' align='center' bgcolor='#ebf0f7'>是否审核</td>
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=xueshengguanxishenqinghsgb.getAllXueshengguanxishenqing(11);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.yonghuming}</td>    <td>${u.xingming}</td>    <td align='center' bgcolor='#ebf0f7'>${u.xingbie}</td>    <td>${u.dianhua}</td>    <td>${u.shenfenzheng}</td>    <td>${u.xuehao}</td>    <td>${u.xueshengxingming}</td>    <td>${u.xueshengguanxi}</td>    <td align='center'>${u.issh} <input type="button" value="审核" onclick="javascript:location.href='sh.jsp?id=${u.id}&yuan=${u.issh}&tablename=xueshengguanxishenqing'"/></td>
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

