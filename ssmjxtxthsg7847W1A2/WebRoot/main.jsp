﻿<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%request.setCharacterEncoding("utf-8");%>

<html>
<head>
   
    <title>家校通系统</title>
    <script language="javascript" type="text/javascript">
        function G(id) {
            return document.getElementById(id);
        }
        var status = 1;
        function switchSysBar() {
            if (1 == status) {
                status = 0;
                G("switchPoint").innerHTML = '<img src="images/left.gif" style="margin:0 2px">';
                G("frmTitle").style.display = "none";
            }
            else {
                status = 1;
                G("switchPoint").innerHTML = '<img src="images/right.gif" style="margin:0 2px">';
                G("frmTitle").style.display = "";
            }
        }
    </script>
    <link rel="stylesheet" type="text/css" href="images/houtai.css" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"></head>
<body>

    <table cellpadding="0" cellspacing="0" class="table">
        <tr>
            <td colspan="3" class="top_menu">
                <div style="font-family:宋体; color:#006633;WIDTH: 100%; FONT-WEIGHT: bold; FONT-SIZE:30px ; margin-top:5pt">
            <div >&nbsp;&nbsp;家校通系统</div>
        </div>
               
            </td>
        </tr>
        <tr>
            <td id="frmTitle" style="width: 182px;">
                <table height="100%" style="width: 182px;" cellpadding="0" cellspacing="0">
                    <tr>
                        <td style="background-color: #c9defa; padding: 3px; padding-bottom: 0">
                            <div class="lie lie2">
                                <a onClick="javascript:history.back();" style="cursor:pointer" class="shouye" target="hsgmain">返回</a> <a style="cursor:pointer"  onClick="javascript:if(confirm('确定要退出吗？')==true){parent.location.href='logout.jsp';}"
                                    class="tuichu">退出</a>
                                <div style="clear: both">
                                </div>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td valign="top" style="background: #c9defa" height="100%" name="fmtitle">
                            <iframe frameborder="0" id="frmleft" name="frmleft" scrolling="yes" src="mygo.jsp"
                                style="height: 100%; visibility: inherit; width: 182px;" allowtransparency="true">
                            </iframe>
                        </td>
                    </tr>
                </table>
            </td>
            <td valign="middle" style="width: 12px; cursor: pointer;" bgcolor="#c3daf9" onMouseOver="this.style.backgroundColor='#ddeafc';this.style.color='red'"
                onmouseout="this.style.backgroundColor='';this.style.color=''" onClick="switchSysBar()">
                <span class="navpoint" id="switchPoint" title="关闭/打开左栏">
                    <img src="images/right.gif" style="margin: 0 2px"></span>
            </td>
            <td style="width: 100%" valign="top">
                <table width="100%" cellpadding="0" cellspacing="0" style="height: 100%;">
                    <tr>
                        <td>
                            <div class="menu">
                                <div class="wenzi">
                                    <a href="sy.jsp" target="frmright" class="a1">显示桌面</a><em>|</em><a
                                        href="allusersList.action" target="frmright" class="a1">系统用户管理</a><em>|</em>
										 <%
	
	if (request.getSession().getAttribute("cx").equals("超级管理员") || request.getSession().getAttribute("cx").equals("普通管理员"))
	{
		%>
											<a  href="mod.jsp" target="hsgmain" class="a1">修改密码</a>
											<%
	}
	if(request.getSession().getAttribute("cx").equals("注册用户")  )
	{
		%>
												<a  href="yonghuzhucePre2.action" target="hsgmain" class="a1">修改密码</a>
												<%
	}
	
	%>

										
                                </div>
								
                               <div class="wenzi2">
									当前日期：<%java.util.Date date = new java.util.Date();
java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd", java.util.Locale.CHINA);

String result = format.format(date);
out.print(result);%>
                                    <a href="${pageContext.request.contextPath}/index.do" target="_parent">
                                        返回前台</a> <a href="logout.jsp" target="_parent">
                                        退出</a></div>
                               
                            </div>
                           
                           
                        </td>
                    </tr>
                    <tr>
                        <td style="height:100%" valign="top" id="tdframe">
                            <iframe frameborder="0" id="hsgmain" name="hsgmain" scrolling="auto" src="sy.jsp"
                                style="margin: 0; visibility: inherit; width: 100%; height:100%; z-index:1" onload="InitBulletin()" >
                            </iframe>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
    </form>
  
</body>
</html>
