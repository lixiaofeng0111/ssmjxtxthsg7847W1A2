<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
  <section id="clients" class="wow fadeInUp partner"  style="padding-top:10px">
      <div class="container">
      </div>
    </section>
	
    <section id="call-to-action" class="wow fadeInUp">
      <div class="container">
        <div class="row">
          <div class="col-lg-9 text-center text-lg-left">
            <h3 class="cta-title">家校通系统</h3>
            <p class="cta-text">
            	<span style="color:#f8f9fa">校园新闻&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            	问卷调查&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;校园公告&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            	考试安排&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;在线留言</span>
            </p>
          </div>
          <div class="col-lg-3 cta-btn-container text-center">
            <a class="cta-btn align-middle" href="#contact">家校通系统</a>
          </div>
        </div>
       <div style="padding-left:300px;color:#f8f9fa">@copyright:郑州轻工业大学-软件学院-软件测试（16-01）仁川龙</div>

      </div>
    </section>
	  <script src="qtimages/lib/jquery/jquery.min.js"></script>
  <script src="qtimages/lib/jquery/jquery-migrate.min.js"></script>
  <script src="qtimages/lib/bootstrap/js/bootstrap.min.js"></script>
  <script src="qtimages/lib/easing/easing.min.js"></script>
  <script src="qtimages/lib/superfish/hoverIntent.js"></script>
  <script src="qtimages/lib/superfish/superfish.min.js"></script>
  <script src="qtimages/lib/wow/wow.min.js"></script>
  <script src="qtimages/lib/owlcarousel/owl.carousel.min.js"></script>
  <script src="qtimages/lib/magnific-popup/magnific-popup.min.js"></script>
  <script src="qtimages/lib/sticky/sticky.js"></script>
  <script src="qtimages/js/main.js"></script>
  <script src="./qtimages/js/jquery.SuperSlide.2.1.1.js"></script>
  <script>
    $(".fullSlide").slide({
      titCell: ".hd ul",
      mainCell: ".bd ul",
      effect: "fold",
      autoPlay: true,
      autoPage: true,
      trigger: "click"
    });
  </script>