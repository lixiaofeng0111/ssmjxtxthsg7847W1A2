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
<title>��ҵ</title>

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
            <h2>��� ��ҵ ����</h2>
          </div>
        <div class="row">
         
		   
   <table width="100%" border="0" align="center" cellpadding="3" cellspacing="1" bordercolor="#00FFFF" style="border-collapse:collapse"  class="newsline">  
      <tr>
		 <td width='11%'>��ҵ��ţ�</td><td width='39%'>${zuoye.zuoyebianhao}</td>     <td width='11%'>��ҵ���ƣ�</td><td width='39%'>${zuoye.zuoyemingcheng}</td></tr><tr>     <td width='11%'>��ҵ���ͣ�</td><td width='39%'>${zuoye.zuoyeleixing}</td>     <td width='11%'>���ݣ�</td><td width='39%'>${zuoye.neirong}</td></tr><tr>     <td width='11%'>������</td><td width='39%'><a href='${zuoye.fujian}'>�������</a></td>     <td width='11%'>Ҫ��ʱ�䣺</td><td width='39%'>${zuoye.yaoqiushijian}</td></tr><tr>     <td width='11%'>�γ̣�</td><td width='39%'>${zuoye.kecheng}</td>     <td width='11%'>�����ˣ�</td><td width='39%'>${zuoye.faburen}</td>     </tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=���� onClick="javascript:history.back()" /><input type=button name=Submit52 value=��ӡ onClick="javascript:window.print()"  /> <!--jixaaxnnxiu--></td></tr>
    
  </table>
						  
        </div>
      </div>
    </section>
	
	<jsp:include page="qtdown.jsp"></jsp:include>
  </main>
  
</body> 
</html>

