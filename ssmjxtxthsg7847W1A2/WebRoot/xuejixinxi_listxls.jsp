<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="xuejixinxihsgb" scope="page" class="com.bean.XuejixinxiBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=xuejixinxi.xls");
%>
<html>
  <head>
    <title>ѧ����Ϣ</title>
  </head>

  <body >
 <%
			String sql="select * from xuejixinxi  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">���</td>
    <td align='center' bgcolor='#ebf0f7'>ѧ��</td>    <td align='center' bgcolor='#ebf0f7'>����</td>    <td  width='40' align='center' bgcolor='#ebf0f7'>�Ա�</td>    <td  width='90' align='center' bgcolor='#ebf0f7'>��Ƭ</td>    <td align='center' bgcolor='#ebf0f7'>����</td>    <td align='center' bgcolor='#ebf0f7'>����</td>    <td align='center' bgcolor='#ebf0f7'>���֤</td>    <td  width='65' align='center' bgcolor='#ebf0f7'>��ѧʱ��</td>    <td align='center' bgcolor='#ebf0f7'>רҵ</td>    <td align='center' bgcolor='#ebf0f7'>ԺУ</td>    <td align='center' bgcolor='#ebf0f7'>���</td>    <td align='center' bgcolor='#ebf0f7'>ѧ��״̬</td>        <td align='center' bgcolor='#ebf0f7'>����</td>    
	
    <td width="120" align="center" bgcolor="CCFFFF">���ʱ��</td>
    
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

