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
<title>��ʦ��Ϣ</title>

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
<script language=javascript src='js/popup.js'></script>
<script language=javascript> 
function hsgpinglun(nbiao,nid){ 
popheight=450;
pop('hsgpinglun.jsp?biao='+nbiao+'&id='+nid,'��������',550,250) ;
}
</script> 
<%
	String id=request.getParameter("id");
	
     %>
<body id="body">
<jsp:include page="qttop.jsp"></jsp:include>
<jsp:include page="bht.jsp"></jsp:include>
  <main id="main">
   

	
    <section id="services" class="wow fadeInUp">
      <div class="container">
	   <div class="section-header">
            <h2>��� ��ʦ��Ϣ ����</h2>
          </div>
        <div class="row">
         
		   
   <table width="100%" border="0" align="center" cellpadding="3" cellspacing="1" bordercolor="#00FFFF" style="border-collapse:collapse"  class="newsline">  
      <tr>
		 <td width='11%' height=44>���ţ�</td><td width='39%'>${jiaoshixinxi.gonghao}</td><td  rowspan=8 align=center><a href=${jiaoshixinxi.zhaopian} target=_blank><img src=${jiaoshixinxi.zhaopian}  width=228 height=215 border=0></a></td></tr><tr>         <td width='11%' height=44>���룺</td><td width='39%'>******</td></tr><tr>         <td width='11%' height=44>������</td><td width='39%'>${jiaoshixinxi.xingming}</td></tr><tr>         <td width='11%' height=44>�Ա�</td><td width='39%'>${jiaoshixinxi.xingbie}</td></tr><tr>         <td width='11%' height=44>���֤��</td><td width='39%'>******</td></tr><tr>         <td width='11%' height=44>�绰��</td><td width='39%'>${jiaoshixinxi.dianhua}</td></tr><tr>         <td width='11%' height=44>ְ�ƣ�</td><td width='39%'>${jiaoshixinxi.zhicheng}</td></tr><tr>         <td width='11%' height=44>���᣺</td><td width='39%'>${jiaoshixinxi.jiguan}</td></tr><tr>                           <td width='11%' height=100  >��ע��</td><td width='39%' colspan=2 height=100 >${jiaoshixinxi.beizhu}</td></tr><tr><td colspan=3 align=center><input type=button name=Submit5 value=���� onClick="javascript:history.back()" /><input type=button name=Submit52 value=��ӡ onClick="javascript:window.print()" /> <!--jixaaxnnxiu--></td></tr>
    
  </table>
						  
        </div>
      </div>
    </section>
	
	<jsp:include page="qtdown.jsp"></jsp:include>
  </main>
  
</body> 
</html>

