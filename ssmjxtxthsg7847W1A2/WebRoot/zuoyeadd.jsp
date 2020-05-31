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
<title>作业</title>

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
		var zuoyebianhao = $("#zuoyebianhao").val();
		if(zuoyebianhao==""||(zuoyebianhao.length<3||zuoyebianhao.length>12)){
			 $("#clabelzuoyebianhao").html("<font color=red>作业编号不能为空且长度在3～12位之间！</font>");
			 $("input[id=zuoyebianhao]").focus();
			 $("#querenzhuce").attr("disabled","disabled");
			 return false;
		} 
		else
		{
			$("#clabelzuoyebianhao").html("");
			$.ajax({
				url : "quchongZuoye.do",
				type : "post",
				data : "zuoyebianhao=" + zuoyebianhao,
				dataType : "json",
				success:function(result){
				if(result.info=="ng"){
					$("#clabelzuoyebianhao").html("<font color=red>作业编号已存在，请更换！</font>");
					$("input[id=zuoyebianhao]").focus();
					$("#querenzhuce").attr("disabled","disabled");
					return false;
				}
				else
				{
					$("#querenzhuce").removeAttr("disabled");
				}
				},
				error:function(){
					$("#clabelzuoyebianhao").html("系统异常，请检查错误！");
					$("input[id=zuoyebianhao]").focus();
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
	var zuoyebianhaoobj = document.getElementById("zuoyebianhao"); if(zuoyebianhaoobj.value==""){document.getElementById("clabelzuoyebianhao").innerHTML="&nbsp;&nbsp;<font color=red>请输入作业编号</font>";return false;}else{document.getElementById("clabelzuoyebianhao").innerHTML="  "; } 	var zuoyemingchengobj = document.getElementById("zuoyemingcheng"); if(zuoyemingchengobj.value==""){document.getElementById("clabelzuoyemingcheng").innerHTML="&nbsp;&nbsp;<font color=red>请输入作业名称</font>";return false;}else{document.getElementById("clabelzuoyemingcheng").innerHTML="  "; } 	
}
function gow()
{
	document.location.href="zuoyeadd.jsp?id=<%=id%>
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
				<h2>◇◆ 作业 ◆◇</h2>
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
					<form action="addZuoye.do" name="form1" method="post">
						<tr>
							<td width="200">作业编号：</td>
							<td><input name='zuoyebianhao' type='text' id='zuoyebianhao'
								value='' onblur='hsgcheck()' class="form-control" />&nbsp;*
								<label id='clabelzuoyebianhao' style='margin-top: 16px;' /></td>
						</tr>
						<tr>
							<td width="200">作业名称：</td>
							<td><input name='zuoyemingcheng' type='text'
								id='zuoyemingcheng' value='' onblur='checkform()' size='50'
								class="form-control" style="width: 600px;" />&nbsp;*<label
								id='clabelzuoyemingcheng' style='margin-top: 16px;' /></td>
						</tr>
						<tr>
							<td width="200">作业类型：</td>
							<td><select name='zuoyeleixing' id='zuoyeleixing'
								class="form-control"><option value="课后练习">课后练习</option>
									<option value="模拟试卷">模拟试卷</option>
									<option value="例年真题">例年真题</option></select></td>
						</tr>
						<tr>
							<td width="200">内容：</td>
							<td><textarea name='neirong' cols='50' rows='5' id='neirong'
									onblur='' class="form-control"
									style="width: 600px; height: 80px;"></textarea></td>
						</tr>
						<tr>
							<td width="200">附件：</td>
							<td><input name='fujian' type='text' id='fujian' size='50' class="form-control" />
							<div style="margin-top: 16px;">
									&nbsp;<input type='button' value='上传' onClick="up('fujian')" />
								</div></td>
						</tr>
						<tr>
							<td width="200">要求时间：</td>
							<td><input name='yaoqiushijian' type='text'
								id='yaoqiushijian' value='<%=connDbBean.getdate()%>' onblur=''
								readonly='readonly'
								onClick="WdatePicker({'dateFmt':'yyyy-MM-dd'})"
								class="form-control" /></td>
						</tr>
						<tr>
							<td width="200">课程：</td>
							<td><input name='kecheng' type='text' id='kecheng' value=''
								onblur='' class="form-control" /></td>
						</tr>
						<tr>
							<td width="200">发布人：</td>
							<td><input name='faburen' type='text' id='faburen' onblur=''
								class="form-control"
								value='<%=(String) request.getSession().getAttribute("username")%>'
								readonly="readonly" /></td>
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
