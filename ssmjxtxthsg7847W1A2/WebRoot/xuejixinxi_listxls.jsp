<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="xuejixinxihsgb" scope="page" class="com.bean.XuejixinxiBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=xuejixinxi.xls");
%>
<html>
  <head>
    <title>学籍信息</title>
  </head>

  <body >
 <%
			String sql="select * from xuejixinxi  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center' bgcolor='#ebf0f7'>学号</td>    <td align='center' bgcolor='#ebf0f7'>姓名</td>    <td  width='40' align='center' bgcolor='#ebf0f7'>性别</td>    <td  width='90' align='center' bgcolor='#ebf0f7'>照片</td>    <td align='center' bgcolor='#ebf0f7'>民族</td>    <td align='center' bgcolor='#ebf0f7'>籍贯</td>    <td align='center' bgcolor='#ebf0f7'>身份证</td>    <td  width='65' align='center' bgcolor='#ebf0f7'>入学时间</td>    <td align='center' bgcolor='#ebf0f7'>专业</td>    <td align='center' bgcolor='#ebf0f7'>院校</td>    <td align='center' bgcolor='#ebf0f7'>层次</td>    <td align='center' bgcolor='#ebf0f7'>学籍状态</td>        <td align='center' bgcolor='#ebf0f7'>工号</td>    
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=xuejixinxihsgb.getAllXuejixinxi(16);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.xuehao}</td>    <td>${u.xingming}</td>    <td align='center' bgcolor='#ebf0f7'>${u.xingbie}</td>    <td width='90' align='center' bgcolor='#ebf0f7'><a href='${u.zhaopian}' target='_blank'><img src='${u.zhaopian}' width=88 height=99 border=0 /></a></td>    <td>${u.minzu}</td>    <td>${u.jiguan}</td>    <td>${u.shenfenzheng}</td>    <td>${u.ruxueshijian}</td>    <td>${u.zhuanye}</td>    <td>${u.yuanxiao}</td>    <td>${u.cengci}</td>    <td>${u.xuejizhuangtai}</td>        <td>${u.gonghao}</td>    
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

