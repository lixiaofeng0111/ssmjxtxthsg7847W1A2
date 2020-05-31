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
		<TITLE>添加考试安排</TITLE>
	    
 	<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">    
	</head>
<%
  String id="";
   %>

<script language="javascript">

function gows()
{
	document.location.href="kaoshianpai_add.jsp?id=<%=id%>";
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
			<form action="addKaoshianpai.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="30" colspan="2" background="images/table_header.gif">添加考试安排</td>
						</tr>
						<tr ><td width="200">场次：</td><td><input name='changci' type='text' id='changci' value='' onblur='hsgcheck()' class="form-control" />&nbsp;*<label id='clabelchangci' style='margin-top:16px;' /></td></tr>		<tr ><td width="200">课程名称：</td><td><input name='kechengmingcheng' type='text' id='kechengmingcheng' value='' onblur='checkform()' class="form-control" />&nbsp;*<label id='clabelkechengmingcheng' style='margin-top:16px;' /></td></tr>		<tr ><td width="200">教室号：</td><td><input name='jiaoshihao' type='text' id='jiaoshihao' value='' onblur='' class="form-control" /></td></tr>		<tr ><td width="200">考试时间：</td><td><select name='kaoshishijian' id='kaoshishijian' class="form-control"><option value="周一">周一</option><option value="周二">周二</option><option value="周三">周三</option><option value="周四">周四</option><option value="周五">周五</option><option value="周六">周六</option><option value="周日">周日</option></select>&nbsp;*<label id='clabelkaoshishijian' style='margin-top:16px;' /></td></tr>		<tr ><td width="200">考试时段：</td><td><select name='kaoshishiduan' id='kaoshishiduan' class="form-control"><option value="上午">上午</option><option value="下午">下午</option></select>&nbsp;*<label id='clabelkaoshishiduan' style='margin-top:16px;' /></td></tr>		<tr ><td width="200">说明：</td><td><input name='shuoming' type='text' id='shuoming' value='' onblur='' size='50' class="form-control" style="width:600px;" /></td></tr>		<tr ><td width="200">发布人：</td><td><input name='faburen' type='text' id='faburen' onblur='' class="form-control" value='<%=(String)request.getSession().getAttribute("username")%>' readonly="readonly" /></td></tr>		
		
						<tr align='center'   height="22">
						    <td height="45"  align="right">&nbsp;						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();" class="btn btn-info btn-small"/>
						       <input type="reset" value="重置" name="Submit2" class="btn btn-info btn-small"/>&nbsp;
						    </td>
						</tr>
					 </table>
			</form>
   </body>
</html>




<script language=javascript >  
function hsgcheck() {
		var changci = $("#changci").val();
		if(changci==""||(changci.length<3||changci.length>12)){
			 $("#clabelchangci").html("<font color=red>场次不能为空且长度在3～12位之间！</font>");
			 $("input[id=changci]").focus();
			 $("#querenzhuce").attr("disabled","disabled");
			 return false;
		} 
		else
		{
			$("#clabelchangci").html("");
			$.ajax({
				url : "quchongKaoshianpai.do",
				type : "post",
				data : "changci=" + changci,
				dataType : "json",
				success:function(result){
				if(result.info=="ng"){
					$("#clabelchangci").html("<font color=red>场次已存在，请更换！</font>");
					$("input[id=changci]").focus();
					$("#querenzhuce").attr("disabled","disabled");
					return false;
				}
				else
				{
					$("#querenzhuce").removeAttr("disabled");
				}
				},
				error:function(){
					$("#clabelchangci").html("系统异常，请检查错误！");
					$("input[id=changci]").focus();
					$("#querenzhuce").attr("disabled","disabled");
					return false;
				}
			});
		}
	}
</script>


<script language=javascript >  
 
 function checkform(){  
 
	var changciobj = document.getElementById("changci"); if(changciobj.value==""){document.getElementById("clabelchangci").innerHTML="&nbsp;&nbsp;<font color=red>请输入场次</font>";return false;}else{document.getElementById("clabelchangci").innerHTML="  "; } 	var kechengmingchengobj = document.getElementById("kechengmingcheng"); if(kechengmingchengobj.value==""){document.getElementById("clabelkechengmingcheng").innerHTML="&nbsp;&nbsp;<font color=red>请输入课程名称</font>";return false;}else{document.getElementById("clabelkechengmingcheng").innerHTML="  "; } 	var kaoshishijianobj = document.getElementById("kaoshishijian"); if(kaoshishijianobj.value==""){document.getElementById("clabelkaoshishijian").innerHTML="&nbsp;&nbsp;<font color=red>请输入考试时间</font>";return false;}else{document.getElementById("clabelkaoshishijian").innerHTML="  "; } 	var kaoshishiduanobj = document.getElementById("kaoshishiduan"); if(kaoshishiduanobj.value==""){document.getElementById("clabelkaoshishiduan").innerHTML="&nbsp;&nbsp;<font color=red>请输入考试时段</font>";return false;}else{document.getElementById("clabelkaoshishiduan").innerHTML="  "; } 	


return true;   
}   
popheight=450;
</script>  
<script src="images/hsgcommon/jq.js"></script>
<script src="images/hsgcommon/common.js"></script>
<script src="images/hsgcommon/bootbox.js"></script>