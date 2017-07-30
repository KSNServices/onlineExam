<%@ include file="/WEB-INF/jsp/common/header.jsp"%>
<link href="${pageContext.request.contextPath}/js/pages/css/lock.css"
	rel="stylesheet" type="text/css" />
<!-- BEGIN BODY -->
<body>
	<div class="page-lock">
		<div class="page-logo">
			<a class="brand" href="index.php"> <img
				src="images/layout/logo-big.png" alt="logo" />
			</a>
		</div>
		<div class="page-body">
			<div class="lock-head">Locked</div>
			<div class="lock-body">
				<div class="pull-left lock-avatar-block">
					<img src="${pageContext.request.contextPath}/user/readUserImage" class="lock-avatar">
				</div>
				<form class="lock-form pull-left" action="index.php" method="post">
					<h4>${userDetails.firstName} ${userDetails.middleName} ${userDetails.lastName}</h4>
					<div class="form-group">
						<input class="form-control placeholder-no-fix" type="password"
							autocomplete="off" placeholder="Password" name="password" />
					</div>
					<div class="form-actions">
						<button type="submit"
							class="btn btn-danger btn-sm btn-block uppercase">Login</button>
					</div>
				</form>
			</div>
			<div class="lock-bottom">
				<a href="${pageContext.request.contextPath}/logout">Not ${userDetails.firstName} ${userDetails.middleName} ${userDetails.lastName}</a>
			</div>
		</div>
		<div class="page-footer-custom">2014 &copy; Metronic. Admin
			Dashboard Template.</div>
	</div>
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
	<script src="${pageContext.request.contextPath}/js/layout.js"
		type="text/javascript"></script>
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