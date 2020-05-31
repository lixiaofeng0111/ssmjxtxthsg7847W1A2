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
		<TITLE>修改作业</TITLE>
	    
<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">   
       
	</head>
<%
  String id="";
 
   %>
<script language="javascript">

function gows()
{
	document.location.href="zuoye_add.jsp?id=<%=id%>";
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
			<form action="updateZuoye.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="30" colspan="2" background="images/table_header.gif">修改作业<input type="hidden" name="id" value="${zuoye.id}" /></td>
						</tr>
						<tr ><td width="200">作业编号：</td><td><input name='zuoyebianhao' type='text' id='zuoyebianhao' value='' onblur='hsgcheck()' class="form-control" />&nbsp;*<label id='clabelzuoyebianhao' style='margin-top:16px;' /></td></tr>		<tr ><td width="200">作业名称：</td><td><input name='zuoyemingcheng' type='text' id='zuoyemingcheng' value='' onblur='checkform()' size='50' class="form-control" style="width:600px;" />&nbsp;*<label id='clabelzuoyemingcheng' style='margin-top:16px;' /></td></tr>		<tr ><td width="200">作业类型：</td><td><select name='zuoyeleixing' id='zuoyeleixing' class="form-control"><option value="课后练习">课后练习</option><option value="模拟试卷">模拟试卷</option><option value="例年真题">例年真题</option></select></td></tr>		<tr ><td width="200">内容：</td><td><textarea name='neirong' cols='50' rows='5' id='neirong' onblur='' class="form-control" style="width:600px; height:80px;" ></textarea></td></tr>		<tr ><td width="200">附件：</td><td><input name='fujian' type='text' id='fujian' size='50' value='' onblur=''  class="form-control" /><div style="margin-top:16px;">&nbsp;<input type='button' value='上传' onClick="up('fujian')"/></div></td></tr>		<tr ><td width="200">要求时间：</td><td><input name='yaoqiushijian' type='text' id='yaoqiushijian' value='<%=connDbBean.getdate()%>' onblur='' readonly='readonly' onClick="WdatePicker({'dateFmt':'yyyy-MM-dd'})"  class="form-control" /></td></tr>		<tr ><td width="200">课程：</td><td><input name='kecheng' type='text' id='kecheng' value='' onblur='' class="form-control" /></td></tr>		<tr ><td width="200">发布人：</td><td><input name='faburen' type='text' id='faburen' onblur='' class="form-control" value='<%=(String)request.getSession().getAttribute("username")%>' readonly="readonly" /></td></tr>		
		
						<tr align='center'   height="22">
						    <td width="25%" height="45"  align="right">&nbsp;						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();" class="btn btn-info btn-small" />
						       <input type="reset" value="重置" class="btn btn-info btn-small" />&nbsp;
						    </td>
						</tr>
						<script language="javascript">document.form1.zuoyebianhao.value='${zuoye.zuoyebianhao}';</script>	<script language="javascript">document.form1.zuoyemingcheng.value='${zuoye.zuoyemingcheng}';</script>	<script language="javascript">document.form1.zuoyeleixing.value='${zuoye.zuoyeleixing}';</script>	<script language="javascript">document.form1.neirong.value='${zuoye.neirong}';</script>	<script language="javascript">document.form1.fujian.value='${zuoye.fujian}';</script>	<script language="javascript">document.form1.yaoqiushijian.value='${zuoye.yaoqiushijian}';</script>	<script language="javascript">document.form1.kecheng.value='${zuoye.kecheng}';</script>	<script language="javascript">document.form1.faburen.value='${zuoye.faburen}';</script>	
					 </table>
			</form>
   </body>
</html>






<script language=javascript >  
 
 function checkform(){  
 
	var zuoyebianhaoobj = document.getElementById("zuoyebianhao"); if(zuoyebianhaoobj.value==""){document.getElementById("clabelzuoyebianhao").innerHTML="&nbsp;&nbsp;<font color=red>请输入作业编号</font>";return false;}else{document.getElementById("clabelzuoyebianhao").innerHTML="  "; } 	var zuoyemingchengobj = document.getElementById("zuoyemingcheng"); if(zuoyemingchengobj.value==""){document.getElementById("clabelzuoyemingcheng").innerHTML="&nbsp;&nbsp;<font color=red>请输入作业名称</font>";return false;}else{document.getElementById("clabelzuoyemingcheng").innerHTML="  "; } 	


return true;   
}   
popheight=450;
</script>  
