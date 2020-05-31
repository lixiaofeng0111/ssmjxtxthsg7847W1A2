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
	<TITLE>作业查询</TITLE>
	<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">
	</head>
	<body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr valign="top">
				<td>
					<table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">
						<tr align="left" bgcolor="#F2FDFF">
							<td colspan="17" background="images/table_header.gif">作业列表</td>
						</tr>
					</table>
				</td>
			</tr>
			
			<tr valign="top">
			  <td bgcolor="#FFFFFF">
			  <table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">
						
					<tr align="right" bgcolor="#ebf0f7">
					  <td colspan="21">
					  <table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" >
						<tr align="left" >
							<td colspan="17">
								<form action="zuoyeList.do" name="myform" method="post">
									查询   作业编号：<input name="zuoyebianhao" type="text" id="zuoyebianhao" class="form-control2" />  作业名称：<input name="zuoyemingcheng" type="text" id="zuoyemingcheng" class="form-control2" /> 作业类型：<select name='zuoyeleixing' id='zuoyeleixing' class="form-control2"><option value="">所有</option><option value="课后练习">课后练习</option><option value="模拟试卷">模拟试卷</option><option value="例年真题">例年真题</option></select>  课程：<input name="kecheng" type="text" id="kecheng" class="form-control2" />  发布人：<input name="faburen" type="text" id="faburen" class="form-control2" />
									<input type="submit" value="查询" class="btn btn-info btn-small" />
								</form>								</td>
						</tr></table>
					  </td>
			    </tr>
					
						<tr align="center">
						<td style="padding-left:0px; padding-right:0px;"><table width="100%" border="1" align="center" cellpadding="4" cellspacing="1" bgcolor="#ebf0f7">
                          <tr>
                            <td align="center" bgcolor="#ebf0f7" width="30px">序号</td>
                            <td align='center' bgcolor='#ebf0f7'>作业编号</td>    <td align='center' bgcolor='#ebf0f7'>作业名称</td>    <td align='center' bgcolor='#ebf0f7'>作业类型</td>        <td  width='90' align='center' bgcolor='#ebf0f7'>附件</td>    <td  width='65' align='center' bgcolor='#ebf0f7'>要求时间</td>    <td align='center' bgcolor='#ebf0f7'>课程</td>    <td align='center' bgcolor='#ebf0f7'>发布人</td>    
                            <td align="center" bgcolor="#ebf0f7" width="150px"> 添加时间 </td>
                            <td align="center" bgcolor="#ebf0f7" width="150px"> 操作 </td>
                          </tr>
                          <%
					int i=0;
				%>
                          <c:forEach items="${list }" var="u">
                            <%
					i++;
				%>
                            <tr align="center" bgcolor="#FFFFFF">
                              <td align="center"><%=i%></td>
                             <td>${u.zuoyebianhao}</td>    <td>${u.zuoyemingcheng}</td>    <td>${u.zuoyeleixing}</td>        <td width='90' align='center' bgcolor='#ebf0f7'><a class="btn btn-info btn-small" href='${u.fujian}' target='_blank'>下载</a></td>    <td>${u.yaoqiushijian}</td>    <td>${u.kecheng}</td>    <td>${u.faburen}</td>    
                              <td align="center"> ${u.addtime } </td>
                              <td align="center"> <!--lianjie1--> <a class="btn btn-info btn-small" href="zyDetail.do?id=${u.id}" target="_blank">详细</a></td>
                            </tr>
                          </c:forEach>
                        </table></td>
						</tr>
					</table>
					
					
			  </td>
	  </tr>
		</table>
		
		
		
			<p align="center" class="fy"> <c:if test="${sessionScope.p==1 }">
		 <c:if test="${page.page>1}">
              <a href="zuoyeList.do?page=1" >首页</a>
             <a href="zuoyeList.do?page=${page.page-1 }"> 上一页</a>             </c:if>
    	     <c:if test="${page.page<page.totalPage}">
			<a href="zuoyeList.do?page=${page.page+1 }">下一页</a>
			<a href="zuoyeList.do?page=${page.totalPage }">末页</a>		    </c:if>		
	</c:if>
	</p>
			
			
			
			
			
	</body>
</html>

