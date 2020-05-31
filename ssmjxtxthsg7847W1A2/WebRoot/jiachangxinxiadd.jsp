<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*"%>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db" />

<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"
	charset="gb2312"></script>
<script type="text/javascript" src="js/popup.js"></script>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
<!DOCTYPE html>
<html lang="en">
<head>
<title>家长信息</title>

<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="Author" name="WebThemez">
<link href="qtimages/images/apple-touch-icon.png" rel="apple-touch-icon">
<link href="qtimages/lib/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<link href="qtimages/lib/animate/animate.min.css" rel="stylesheet">
<link href="qtimages/lib/ionicons/css/ionicons.min.css" rel="stylesheet">
<link href="qtimages/lib/owlcarousel/assets/owl.carousel.min.css"
	rel="stylesheet">
<link href="qtimages/lib/magnific-popup/magnific-popup.css"
	rel="stylesheet">
<link href="qtimages/lib/ionicons/css/ionicons.min.css" rel="stylesheet">
<link href="qtimages/lib/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="qtimages/css/style.css" rel="stylesheet">
<link rel="stylesheet" href="qtimages/css/custom.css">
</head>
<%
	String id = "";
%>



<script language=javascript>  
function hsgcheck() {
		var yonghuming = $("#yonghuming").val();
		if(yonghuming==""||(yonghuming.length<3||yonghuming.length>12)){
			 $("#clabelyonghuming").html("<font color=red>用户名不能为空且长度在3～12位之间！</font>");
			 $("input[id=yonghuming]").focus();
			 $("#querenzhuce").attr("disabled","disabled");
			 return false;
		} 
		else
		{
			$("#clabelyonghuming").html("");
			$.ajax({
				url : "quchongJiachangxinxi.do",
				type : "post",
				data : "yonghuming=" + yonghuming,
				dataType : "json",
				success:function(result){
				if(result.info=="ng"){
					$("#clabelyonghuming").html("<font color=red>用户名已存在，请更换！</font>");
					$("input[id=yonghuming]").focus();
					$("#querenzhuce").attr("disabled","disabled");
					return false;
				}
				else
				{
					$("#querenzhuce").removeAttr("disabled");
				}
				},
				error:function(){
					$("#clabelyonghuming").html("系统异常，请检查错误！");
					$("input[id=yonghuming]").focus();
					$("#querenzhuce").attr("disabled","disabled");
					return false;
				}
			});
		}
	}
</script>
<script language="javascript">
function checkform()
{
	var yonghumingobj = document.getElementById("yonghuming"); if(yonghumingobj.value==""){document.getElementById("clabelyonghuming").innerHTML="&nbsp;&nbsp;<font color=red>请输入用户名</font>";return false;}else{document.getElementById("clabelyonghuming").innerHTML="  "; } 	var mimaobj = document.getElementById("mima"); if(mimaobj.value==""){document.getElementById("clabelmima").innerHTML="&nbsp;&nbsp;<font color=red>请输入密码</font>";return false;}else{document.getElementById("clabelmima").innerHTML="  "; } 	var shenfenzhengobj = document.getElementById("shenfenzheng"); if(shenfenzhengobj.value!=""){ if(/^\d{15}$|^\d{18}$|^\d{17}[xX]$/.test(shenfenzhengobj.value)){document.getElementById("clabelshenfenzheng").innerHTML=""; }else{document.getElementById("clabelshenfenzheng").innerHTML="&nbsp;&nbsp;<font color=red>必需身份证格式</font>"; return false;}}      
}
function gow()
{
	document.location.href="jiachangxinxiadd.jsp?id=<%=id%>
	";
	}
</script>


<body id="body">
	<jsp:include page="qttop.jsp"></jsp:include>
	<jsp:include page="bht.jsp"></jsp:include>
	<main id="main">



	<section id="services" class="wow fadeInUp">
		<div class="container">
			<div class="section-header">
				<h2>◇◆ 家长信息 ◆◇</h2>
			</div>
			<div class="row">

				<link rel="stylesheet" href="images/hsgcommon/divqt.css"
					type="text/css">
				<link rel="stylesheet" href="images/hsgcommon/commonqt.css"
					type="text/css">
				<script src="images/hsgcommon/common.js"></script>
				<script src="images/hsgcommon/bootbox.js"></script>
				<%
					
				%>



				<table width="100%" border="1" align="center" cellpadding="3"
					cellspacing="1" bordercolor="#CCCCCC"
					style="border-collapse: collapse" class="newsline">
					<form action="addJiachangxinxi.do" name="form1" method="post">
						<tr>
							<td width="200">用户名：</td>
							<td><input name='yonghuming' type='text' id='yonghuming'
								value='' onblur='hsgcheck()' class="form-control" />&nbsp;*<label
								id='clabelyonghuming' style='margin-top: 16px;' /></td>
						</tr>
						<tr>
							<td width="200">密码：</td>
							<td><input name='mima' type='text' id='mima' value=''
								onblur='checkform()' class="form-control" />&nbsp;*<label
								id='clabelmima' style='margin-top: 16px;' /></td>
						</tr>
						<tr>
							<td width="200">姓名：</td>
							<td><input name='xingming' type='text' id='xingming'
								value='' onblur='' class="form-control" /></td>
						</tr>
						<tr>
							<td width="200">性别：</td>
							<td><select name='xingbie' id='xingbie' class="form-control"><option
										value="男">男</option>
									<option value="女">女</option></select></td>
						</tr>
						<tr>
							<td width="200">电话：</td>
							<td><input name='dianhua' type='text' id='dianhua' value=''
								onblur='' class="form-control" /></td>
						</tr>
						<tr>
							<td width="200">身份证：</td>
							<td><input name='shenfenzheng' type='text' id='shenfenzheng'
								value='' onblur='checkform()' class="form-control" />&nbsp;<label
								id='clabelshenfenzheng' style='margin-top: 16px;' />必需身份证格式</td>
						</tr>


						<tr align='center' height="22">
							<td width="25%" align="right">&nbsp;</td>
							<td width="75%" align="left"><input type="submit"
								name="querenzhuce" id="querenzhuce" value="提交"
								onClick="return checkform();" /> <input type="reset" value="重置" />&nbsp;
							</td>
						</tr>
					</form>
				</table>

				<script language="javascript">
					popheight = 450;
				</script>

			</div>
		</div>
	</section>

	<jsp:include page="qtdown.jsp"></jsp:include> </main>

</body>
</html>
