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
		<TITLE>修改取消关系</TITLE>
	    
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   
       
	</head>
<%
  String id="";
 
   %>
<script language="javascript">

function gows()
{
	document.location.href="quxiaoguanxi_add.jsp?id=<%=id%>";
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
			<form action="updateQuxiaoguanxi.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="30" colspan="2" background="images/table_header.gif">修改取消关系<input type="hidden" name="id" value="${quxiaoguanxi.id}" /></td>
						</tr>
						<tr ><td width="200">用户名：</td><td><input name='yonghuming' type='text' id='yonghuming' onblur='' class="form-control" value='<%=(String)request.getSession().getAttribute("username")%>' readonly="readonly"  readonly='readonly' /></td></tr>		<tr ><td width="200">性别：</td><td><input name='xingbie' type='text' id='xingbie' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr>		<tr ><td width="200">电话：</td><td><input name='dianhua' type='text' id='dianhua' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr>		<tr ><td width="200">身份证：</td><td><input name='shenfenzheng' type='text' id='shenfenzheng' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr>		<tr ><td width="200">学号：</td><td><input name='xuehao' type='text' id='xuehao' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr>		<tr ><td width="200">学生姓名：</td><td><input name='xueshengxingming' type='text' id='xueshengxingming' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr>		<tr ><td width="200">学生关系：</td><td><input name='xueshengguanxi' type='text' id='xueshengguanxi' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr>		<tr ><td width="200">取消原因：</td><td><input name='quxiaoyuanyin' type='text' id='quxiaoyuanyin' value='' onblur='' class="form-control" /></td></tr>		
		
						<tr align='center'   height="22">
						    <td width="25%" height="45"  align="right">&nbsp;						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();" class="btn btn-info btn-small" />
						       <input type="reset" value="重置" class="btn btn-info btn-small" />&nbsp;
						    </td>
						</tr>
						<script language="javascript">document.form1.yonghuming.value='${quxiaoguanxi.yonghuming}';</script>	<script language="javascript">document.form1.xingbie.value='${quxiaoguanxi.xingbie}';</script>	<script language="javascript">document.form1.dianhua.value='${quxiaoguanxi.dianhua}';</script>	<script language="javascript">document.form1.shenfenzheng.value='${quxiaoguanxi.shenfenzheng}';</script>	<script language="javascript">document.form1.xuehao.value='${quxiaoguanxi.xuehao}';</script>	<script language="javascript">document.form1.xueshengxingming.value='${quxiaoguanxi.xueshengxingming}';</script>	<script language="javascript">document.form1.xueshengguanxi.value='${quxiaoguanxi.xueshengguanxi}';</script>	<script language="javascript">document.form1.quxiaoyuanyin.value='${quxiaoguanxi.quxiaoyuanyin}';</script>	
					 </table>
			</form>
   </body>
</html>






