<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>

<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>
<script type="text/javascript" src="js/popup.js"></script>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
<!DOCTYPE html>
<html lang="en">
<head>
<title>回答</title>

  <meta content="width=device-width, initial-scale=1.0" name="viewport">
  <meta content="Author" name="WebThemez">
  <link href="qtimages/images/apple-touch-icon.png" rel="apple-touch-icon">
  <link href="qtimages/lib/font-awesome/css/font-awesome.min.css" rel="stylesheet">
  <link href="qtimages/lib/animate/animate.min.css" rel="stylesheet">
  <link href="qtimages/lib/ionicons/css/ionicons.min.css" rel="stylesheet">
  <link href="qtimages/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
  <link href="qtimages/lib/magnific-popup/magnific-popup.css" rel="stylesheet">
  <link href="qtimages/lib/ionicons/css/ionicons.min.css" rel="stylesheet">
  <link href="qtimages/lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="qtimages/css/style.css" rel="stylesheet">
  <link rel="stylesheet" href="qtimages/css/custom.css">
</head>
<%
if(request.getSession().getAttribute("username")==null)
{
	out.print("<script>alert('对不起,请您先登录!');location.href='index.do';</script>");
	return;
}
  String id="";


 



   %>


	
	<script language="javascript">
function checkform()
{
	
}
function gow()
{
	document.location.href="huidaadd.jsp?id=<%=id%>";
}
</script>


<body id="body">
<jsp:include page="qttop.jsp"></jsp:include>
<jsp:include page="bht.jsp"></jsp:include>
  <main id="main">
   

	
    <section id="services" class="wow fadeInUp">
      <div class="container">
	   <div class="section-header">
            <h2>◇◆ 回答 ◆◇</h2>
          </div>
        <div class="row">
         
		   <link rel="stylesheet" href="images/hsgcommon/divqt.css" type="text/css">
<link rel="stylesheet" href="images/hsgcommon/commonqt.css" type="text/css">
<script src="images/hsgcommon/common.js"></script>
<script src="images/hsgcommon/bootbox.js"></script>
<% 





%>

  

				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CCCCCC" style="border-collapse:collapse" class="newsline">
						<form action="addHuida.do" name="form1" method="post">
						<tr ><td width="200">编号：</td><td><input name='bianhao' type='text' id='bianhao' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr><script language="javascript">document.form1.bianhao.value='<%=connDbBean.readzd("wenjuandiaocha","bianhao","id",request.getParameter("id"))%>';document.form1.bianhao.setAttribute("readOnly",'true');</script>		<tr ><td width="200">问题1：</td><td><input name='wenti1' type='text' id='wenti1' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr><script language="javascript">document.form1.wenti1.value='<%=connDbBean.readzd("wenjuandiaocha","wenti1","id",request.getParameter("id"))%>';document.form1.wenti1.setAttribute("readOnly",'true');</script>		<tr ><td width="200">问题2：</td><td><input name='wenti2' type='text' id='wenti2' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr><script language="javascript">document.form1.wenti2.value='<%=connDbBean.readzd("wenjuandiaocha","wenti2","id",request.getParameter("id"))%>';document.form1.wenti2.setAttribute("readOnly",'true');</script>		<tr ><td width="200">问题3：</td><td><input name='wenti3' type='text' id='wenti3' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr><script language="javascript">document.form1.wenti3.value='<%=connDbBean.readzd("wenjuandiaocha","wenti3","id",request.getParameter("id"))%>';document.form1.wenti3.setAttribute("readOnly",'true');</script>		<tr ><td width="200">问题4：</td><td><input name='wenti4' type='text' id='wenti4' value='' onblur='' class="form-control"  readonly='readonly' /></td></tr><script language="javascript">document.form1.wenti4.value='<%=connDbBean.readzd("wenjuandiaocha","wenti4","id",request.getParameter("id"))%>';document.form1.wenti4.setAttribute("readOnly",'true');</script>		<tr ><td width="200">回答1：</td><td><input name='huida1' type='text' id='huida1' value='' onblur='' class="form-control" /></td></tr>		<tr ><td width="200">回答2：</td><td><input name='huida2' type='text' id='huida2' value='' onblur='' class="form-control" /></td></tr>		<tr ><td width="200">回答3：</td><td><input name='huida3' type='text' id='huida3' value='' onblur='' class="form-control" /></td></tr>		<tr ><td width="200">回答4：</td><td><input name='huida4' type='text' id='huida4' value='' onblur='' class="form-control" /></td></tr>		<tr 0><td width="200">用户名：</td><td><input name='yonghuming' type='text' id='yonghuming' onblur='' class="form-control" value='<%=(String)request.getSession().getAttribute("username")%>' readonly="readonly" /></td></tr><script language="javascript">document.form1.yonghuming.value='<%=connDbBean.readzd("jiachangxinxi","yonghuming","yonghuming",(String)request.getSession().getAttribute("username"))%>';document.form1.yonghuming.setAttribute("readOnly",'true');</script>		<tr 1><td width="200">姓名：</td><td><input name='xingming' type='text' id='xingming' value='' onblur='' class="form-control" /></td></tr><script language="javascript">document.form1.xingming.value='<%=connDbBean.readzd("jiachangxinxi","xingming","yonghuming",(String)request.getSession().getAttribute("username"))%>';document.form1.xingming.setAttribute("readOnly",'true');</script>		
		
						<tr align='center'   height="22">
						    <td width="25%"  align="right">&nbsp;
						        
						    </td>
						    <td width="75%"  align="left">
						      <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();"/>
						       <input type="reset" value="重置"/>&nbsp;
						    </td>
						</tr>
						</form>
					 </table>
			
			<script language="javascript">popheight = 450;</script>
						  
        </div>
      </div>
    </section>
	
	<jsp:include page="qtdown.jsp"></jsp:include>
  </main>
  
</body> 
</html>
