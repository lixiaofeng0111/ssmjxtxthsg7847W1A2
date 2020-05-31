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
	<TITLE>学籍信息查询</TITLE>
	<link rel="stylesheet" href="images/hsgcommon/common.css" type="text/css">
	<link rel="stylesheet" href="images/hsgcommon/div.css" type="text/css">
	</head>
	<body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr valign="top">
				<td>
					<table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">
						<tr align="left" bgcolor="#F2FDFF">
							<td height="30" colspan="17" background="images/table_header.gif">学籍信息列表</td>
						</tr>
					</table>
				</td>
			</tr>
			
			<tr valign="top">
			  <td bgcolor="#FFFFFF">
			  <table width="100%" border="1" align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">
						
					<tr align="right" bgcolor="#ebf0f7">
					  <td colspan="21">
					  <table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" >
						<tr align="left" >
							<td colspan="17">
								<form action="xuejixinxiList.do" name="myform" method="post">
									查询   学号：<input name="xuehao" type="text" id="xuehao" class="form-control2" />  姓名：<input name="xingming" type="text" id="xingming" class="form-control2" /> 性别：<select name='xingbie' id='xingbie' class="form-control2"><option value="">所有</option><option value="男">男</option><option value="女">女</option></select>  籍贯：<input name="jiguan" type="text" id="jiguan" class="form-control2" />  入学时间：<input name="ruxueshijian1" type="text" id="ruxueshijian1"  value='' onClick="WdatePicker({'dateFmt':'yyyy-MM-dd'})" class="form-control2" />-<input name="ruxueshijian2" type="text" id="ruxueshijian2"  value='' onClick="WdatePicker({'dateFmt':'yyyy-MM-dd'})" class="form-control2" /> 层次：<select name='cengci' id='cengci' class="form-control2"><option value="">所有</option><option value="专科">专科</option><option value="本科">本科</option><option value="硕士">硕士</option><option value="博士">博士</option></select> 学籍状态：<select name='xuejizhuangtai' id='xuejizhuangtai' class="form-control2"><option value="">所有</option><option value="在校">在校</option><option value="毕业">毕业</option><option value="结业">结业</option></select>
									<input type="submit" value="查询" class="btn btn-info btn-small" />
								</form>								</td>
						</tr></table>
					  </td>
			    </tr>
					
						<tr align="center">
						<td style="padding-left:0px; padding-right:0px;"><table width="100%" border="1" align="center" cellpadding="4" cellspacing="1" bgcolor="#ebf0f7">
                          <tr>
                            <td align="center" bgcolor="#ebf0f7" width="30px" height="30">序号</td>
                            <td align='center' bgcolor='#ebf0f7'>学号</td>    <td align='center' bgcolor='#ebf0f7'>姓名</td>    <td  width='40' align='center' bgcolor='#ebf0f7'>性别</td>    <td  width='90' align='center' bgcolor='#ebf0f7'>照片</td>    <td align='center' bgcolor='#ebf0f7'>民族</td>    <td align='center' bgcolor='#ebf0f7'>籍贯</td>    <td align='center' bgcolor='#ebf0f7'>身份证</td>    <td  width='65' align='center' bgcolor='#ebf0f7'>入学时间</td>    <td align='center' bgcolor='#ebf0f7'>专业</td>    <td align='center' bgcolor='#ebf0f7'>院校</td>    <td align='center' bgcolor='#ebf0f7'>层次</td>    <td align='center' bgcolor='#ebf0f7'>学籍状态</td>        <td align='center' bgcolor='#ebf0f7'>工号</td>    
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
                             <td>${u.xuehao}</td>    <td>${u.xingming}</td>    <td align='center' bgcolor='#ebf0f7'>${u.xingbie}</td>    <td width='90' align='center' bgcolor='#ebf0f7'><a href='${u.zhaopian}' target='_blank'><img src='${u.zhaopian}' width=88 height=99 border=0 /></a></td>    <td>${u.minzu}</td>    <td>${u.jiguan}</td>    <td>${u.shenfenzheng}</td>    <td>${u.ruxueshijian}</td>    <td>${u.zhuanye}</td>    <td>${u.yuanxiao}</td>    <td>${u.cengci}</td>    <td>${u.xuejizhuangtai}</td>        <td>${u.gonghao}</td>    
                              <td align="center"> ${u.addtime } </td>
                              <td align="center"><a class="btn btn-info btn-small" href="doUpdateXuejixinxi.do?id=${u.id }">编辑</a>  <a class="btn btn-info btn-small" href="deleteXuejixinxi.do?id=${u.id }"
										onclick="{if(confirm('确定要删除吗?')){return true;}return false;}">删除</a> <a class="btn btn-info btn-small" href="xjxxDetail.do?id=${u.id}" target="_blank">详细</a></td>
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
              <a href="xuejixinxiList.do?page=1" >首页</a>
             <a href="xuejixinxiList.do?page=${page.page-1 }"> 上一页</a>             </c:if>
    	     <c:if test="${page.page<page.totalPage}">
			<a href="xuejixinxiList.do?page=${page.page+1 }">下一页</a>
			<a href="xuejixinxiList.do?page=${page.totalPage }">末页</a>		    </c:if>		
	</c:if>
	</p>
			
			
			
			
			
	</body>
</html>
