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
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>

<%
if(request.getSession().getAttribute("username")==null)
{
	out.print("<script>alert('对不起,请您先登录!');location.href='index.do';</script>");
	return;
}
%>

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
<form action="hdList.do" name="myform" method="post" style="width:100%">
									查询   编号：<input name="bianhao" type="text" id="bianhao" class="form-control2" />  问题1：<input name="wenti1" type="text" id="wenti1" class="form-control2" />
									<input type="submit" value="查询" /> 
								</form>	

	
<br />
<table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#ebf0f7">
                          <tr>
                            <td align="center" bgcolor="#ebf0f7" width="30px">序号</td>
                            <td bgcolor='#ebf0f7'>编号</td>    <td bgcolor='#ebf0f7'>问题1</td>    <td bgcolor='#ebf0f7'>问题2</td>    <td bgcolor='#ebf0f7'>问题3</td>    <td bgcolor='#ebf0f7'>问题4</td>    <td bgcolor='#ebf0f7'>回答1</td>    <td bgcolor='#ebf0f7'>回答2</td>    <td bgcolor='#ebf0f7'>回答3</td>    <td bgcolor='#ebf0f7'>回答4</td>    <td bgcolor='#ebf0f7'>用户名</td>    <td bgcolor='#ebf0f7'>姓名</td>    
                            <td align="center" bgcolor="#ebf0f7" width="150px"> 添加时间 </td>
                            <td align="center" bgcolor="#ebf0f7" width="50px"> 操作 </td>
                          </tr>
                          <%
					int i=0;
				%>
                          <c:forEach items="${list}" var="u">
                            <%
					i++;
				%>
                            <tr align="center" bgcolor="#FFFFFF">
                              <td align="center"><%=i%></td>
                             <td>${u.bianhao}</td>    <td>${u.wenti1}</td>    <td>${u.wenti2}</td>    <td>${u.wenti3}</td>    <td>${u.wenti4}</td>    <td>${u.huida1}</td>    <td>${u.huida2}</td>    <td>${u.huida3}</td>    <td>${u.huida4}</td>    <td>${u.yonghuming}</td>    <td>${u.xingming}</td>    
                              <td align="center"> ${u.addtime} </td>
                              <td align="center"><a href="hdDetail.do?id=${u.id}">详细</a></td>
                            </tr>
                          </c:forEach>
                        </table>
<br>

<p align="center"> <c:if test="${sessionScope.p==1 }">
		 <c:if test="${page.page>1}">
              <a href="hdList.do?page=1" >首页</a>
             <a href="hdList.do?page=${page.page-1 }"> 上一页</a>             </c:if>
    	     <c:if test="${page.page<page.totalPage}">
			<a href="hdList.do?page=${page.page+1 }">下一页</a>
			<a href="hdList.do?page=${page.totalPage }">末页</a>		    </c:if>		
	</c:if>
	</p>




						  
        </div>
      </div>
    </section>
	
	<jsp:include page="qtdown.jsp"></jsp:include>
  </main>
  
</body> 
</html>
