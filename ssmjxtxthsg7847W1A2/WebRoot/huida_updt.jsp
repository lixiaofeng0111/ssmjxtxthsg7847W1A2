<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>


<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>
<script type="text/javascript" src="js/popup.js"></script>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<TITLE>修改回答</TITLE>
	    
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   
       
	</head>
<%
  String id="";
 
   %>
<script language="javascript">

function gows()
{
	document.location.href="huida_add.jsp?id=<%=id%>";
}
function hsgxia2shxurxu(nstr,nwbk)
{
	if (eval("form1."+nwbk).value.indexOf(nstr)>=0)
	{
		eval("form1."+nwbk).value=eval("form1."+nwbk).value.replace(nstr+"；", "");
	}
	else
	{
		eval("form1."+nwbk).value=eval("form1."+nwbk).value+nstr+"；";
	}
}
</script>
	<body>
			<form action="updateHuida.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="30" colspan="2" background="images/table_header.gif">修改回答<input type="hidden" name="id" value="${huida.id}" /></td>
						</tr>
						<tr ><td width="200">编号：</td><td><input name='bianhao' type='text' id='bianhao' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr>		<tr ><td width="200">问题1：</td><td><input name='wenti1' type='text' id='wenti1' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr>		<tr ><td width="200">问题2：</td><td><input name='wenti2' type='text' id='wenti2' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr>		<tr ><td width="200">问题3：</td><td><input name='wenti3' type='text' id='wenti3' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr>		<tr ><td width="200">问题4：</td><td><input name='wenti4' type='text' id='wenti4' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr>		<tr ><td width="200">回答1：</td><td><input name='huida1' type='text' id='huida1' value='' onblur='' class="form-control" /></td></tr>		<tr ><td width="200">回答2：</td><td><input name='huida2' type='text' id='huida2' value='' onblur='' class="form-control" /></td></tr>		<tr ><td width="200">回答3：</td><td><input name='huida3' type='text' id='huida3' value='' onblur='' class="form-control" /></td></tr>		<tr ><td width="200">回答4：</td><td><input name='huida4' type='text' id='huida4' value='' onblur='' class="form-control" /></td></tr>		<tr 0><td width="200">用户名：</td><td><input name='yonghuming' type='text' id='yonghuming' onblur='' class="form-control" value='<%=(String)request.getSession().getAttribute("username")%>' readonly="readonly" /></td></tr><script language="javascript">document.form1.yonghuming.value='<%=connDbBean.readzd("jiachangxinxi","yonghuming","yonghuming",(String)request.getSession().getAttribute("username"))%>';document.form1.yonghuming.setAttribute("readOnly",'true');</script>		<tr 1><td width="200">姓名：</td><td><input name='xingming' type='text' id='xingming' value='' onblur='' class="form-control" /></td></tr><script language="javascript">document.form1.xingming.value='<%=connDbBean.readzd("jiachangxinxi","xingming","yonghuming",(String)request.getSession().getAttribute("username"))%>';document.form1.xingming.setAttribute("readOnly",'true');</script>		
		
						<tr align='center'   height="22">
						    <td width="25%" height="45"  align="right">&nbsp;						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();" class="btn btn-info btn-small" />
						       <input type="reset" value="重置" class="btn btn-info btn-small" />&nbsp;
						    </td>
						</tr>
						<script language="javascript">document.form1.bianhao.value='${huida.bianhao}';</script>	<script language="javascript">document.form1.wenti1.value='${huida.wenti1}';</script>	<script language="javascript">document.form1.wenti2.value='${huida.wenti2}';</script>	<script language="javascript">document.form1.wenti3.value='${huida.wenti3}';</script>	<script language="javascript">document.form1.wenti4.value='${huida.wenti4}';</script>	<script language="javascript">document.form1.huida1.value='${huida.huida1}';</script>	<script language="javascript">document.form1.huida2.value='${huida.huida2}';</script>	<script language="javascript">document.form1.huida3.value='${huida.huida3}';</script>	<script language="javascript">document.form1.huida4.value='${huida.huida4}';</script>	<script language="javascript">document.form1.yonghuming.value='${huida.yonghuming}';</script>	<script language="javascript">document.form1.xingming.value='${huida.xingming}';</script>	
					 </table>
			</form>
   </body>
</html>






