<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/jsp/common/header.jsp"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html lang="en">
<!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
<meta charset="utf-8" />
<title>KSN Service</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1.0" name="viewport" />
<meta http-equiv="Content-type" content="text/html; charset=utf-8">
<meta content="" name="description" />
<meta content="" name="author" />
<!-- BEGIN GLOBAL MANDATORY STYLES -->
<link
	href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all"
	rel="stylesheet" type="text/css" />
<link
	href="${pageContext.request.contextPath}/js/plugins/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css" />
<link
	href="${pageContext.request.contextPath}/js/plugins/simple-line-icons/simple-line-icons.min.css"
	rel="stylesheet" type="text/css" />
<link
	href="${pageContext.request.contextPath}/js/plugins/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link
	href="${pageContext.request.contextPath}/js/plugins/uniform/css/uniform.default.css"
	rel="stylesheet" type="text/css" />
<!-- END GLOBAL MANDATORY STYLES -->
<!-- BEGIN PAGE LEVEL STYLES -->
<link
	href="${pageContext.request.contextPath}/js/pages/css/login-soft.css"
	rel="stylesheet" type="text/css" />
<!-- END PAGE LEVEL SCRIPTS -->
<!-- BEGIN THEME STYLES -->
<link href="${pageContext.request.contextPath}/css/components-md.css"
	id="style_components" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/plugins-md.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/layout/layout.css"
	rel="stylesheet" type="text/css" />
<link id="style_color"
	href="${pageContext.request.contextPath}/css/layout/themes/default.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/layout/custom.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/js/plugins/bootstrap-fileinput/bootstrap-fileinput.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/js/pages/css/profile.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/js/pages/css/tasks.css" rel="stylesheet" type="text/css"/>
<!-- END THEME STYLES -->
<link rel="shortcut icon" href="favicon.ico" />
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="page-md login">
	<!-- BEGIN LOGO -->
	<div class="logo">
		<a href="index.html"> <img src="images/layout/logo-ksn.png" alt="" />
		</a>
	</div>
	<!-- END LOGO -->
	<!-- BEGIN SIDEBAR TOGGLER BUTTON -->
	<div class="menu-toggler sidebar-toggler"></div>
	<!-- END SIDEBAR TOGGLER BUTTON -->
	<!-- BEGIN LOGIN -->
	<div class="content">
		<!-- BEGIN LOGIN FORM -->
		<form class="login-form"
			action="<c:url value='${pageContext.request.contextPath}/j_spring_security_check'/>"
			method="post">
			<h3 class="form-title"><spring:message code="Login.title" text="" /></h3>
			<div class="alert alert-danger display-hide">
				<button class="close" data-close="alert"></button>
				<span><spring:message code="Login.header" text="" /></span>
			</div>
			<c:if test="${loginError!=null && loginError!=''}">
				<div class="alert alert-danger">
					<button class="close" data-close="alert"></button>
					<span><strong>${loginError}</strong></span>
				</div>
			</c:if>
			<div class="form-group">
				<!--ie8, ie9 does not support html5 placeholder, so we just show field title for that-->
				<label class="control-label visible-ie8 visible-ie9"><spring:message code="Login.Username" text="" /></label>
				<div class="input-icon">
					<i class="fa fa-envelope"></i> <input
						class="form-control placeholder-no-fix" type="text"
						autocomplete="off" placeholder="Email" name="j_username" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label visible-ie8 visible-ie9"><spring:message code="Login.Password" text="" /></label>
				<div class="input-icon">
					<i class="fa fa-lock"></i> <input
						class="form-control placeholder-no-fix" type="password"
						autocomplete="off" placeholder="Password" name="j_password" />
				</div>
			</div>
			<div class="form-actions">
				<label class="checkbox"><input type="checkbox"
					name="remember" value="1" /><spring:message code="Login.Remember.me" text="" /></label>
				<button type="submit" class="btn blue pull-right">
					<spring:message code="Login.login" text="" /><i class="m-icon-swapright m-icon-white"></i>
				</button>
			</div>
		</form>
		<!-- END LOGIN FORM -->
	</div>
	<!-- END LOGIN -->
	<!-- BEGIN COPYRIGHT -->
	<div class="copyright">2016-17 &copy; KSN Serices. All Right reserved.</div>
	<!-- END COPYRIGHT -->
	<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
	<!-- BEGIN CORE PLUGINS -->
	<!--[if lt IE 9]>
<script src="assets/js/plugins/respond.min.js"></script>
<script src="assets/js/plugins/excanvas.min.js"></script> 
<![endif]-->
	<script
		src="${pageContext.request.contextPath}/js/plugins/jquery.min.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/js/plugins/jquery-migrate.min.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/js/plugins/bootstrap/js/bootstrap.min.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/js/plugins/jquery.blockui.min.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/js/plugins/uniform/jquery.uniform.min.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/js/plugins/jquery.cokie.min.js"
		type="text/javascript"></script>
	<!-- END CORE PLUGINS -->
	<!-- BEGIN PAGE LEVEL PLUGINS -->
	<script
		src="${pageContext.request.contextPath}/js/plugins/jquery-validation/js/jquery.validate.min.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/js/plugins/backstretch/jquery.backstretch.min.js"
		type="text/javascript"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/plugins/select2/select2.min.js"></script>
	<!-- END PAGE LEVEL PLUGINS -->
	<!-- BEGIN PAGE LEVEL SCRIPTS -->
	<script src="${pageContext.request.contextPath}/js/metronic.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/js/layout.js"
		type="text/javascript"></script>
	<!-- END PAGE LEVEL SCRIPTS -->
	<script>
		jQuery(document)
				.ready(
						function() {
							Metronic.init(); // init metronic core components
							Layout.init(); // init current layout

							// init background slide images
							$
									.backstretch(
											[
													"images/banners/1.jpg",
													"images/banners/12718740.jpg",
													"images/banners/best-school-supplies-1280x800.jpg",
													"images/banners/school-kids-wallpaper-1024x682.jpg",
													"images/banners/PO6cjaY.jpg",
													"images/banners/depositphotos_18996933-stock-photo-back-to-school-blackboard-with.jpg" ],
											{
												fade : 1000,
												duration : 8000
											});
						});
	</script>
	<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>