<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<!-- BEGIN CONTENT -->
<div class="page-content-wrapper">
	<div class="page-content">
		<!-- BEGIN PAGE CONTENT INNER -->
		<div class="row margin-top-10">
			<div class="col-md-12">
				<!-- BEGIN PROFILE SIDEBAR -->
				<div class="profile-sidebar" style="width: 250px;">
					<!-- PORTLET MAIN -->
					<div class="portlet light profile-sidebar-portlet">
						<!-- SIDEBAR USERPIC -->
						<div class="profile-userpic">
							<img
								src="${pageContext.request.contextPath}/images/layout/avatar-img.png"
								class="img-responsive" alt="">
						</div>
						<!-- END SIDEBAR USERPIC -->
						<!-- SIDEBAR USER TITLE -->
						<div class="profile-usertitle">
							<div class="profile-usertitle-name">Ramesh</div>
							<div class="profile-usertitle-job">Super Admin</div>
						</div>
						<!-- END SIDEBAR USER TITLE -->

						<!-- SIDEBAR MENU -->
						<div class="profile-usermenu">
							<ul class="nav">
								<li><a
									href="${pageContext.request.contextPath}/user/profile"> <i
										class="icon-user"></i> Profile
								</a></li>
								<li><a
									href="${pageContext.request.contextPath}/user/notification">
										<i class="icon-settings"></i> Notification
								</a></li>
								<li class="active"><a
									href="${pageContext.request.contextPath}/showChangePassword">
										<i class="icon-key"></i> Change Password
								</a></li>
							</ul>
						</div>
						<!-- END MENU -->
					</div>
					<!-- END PORTLET MAIN -->

				</div>
				<!-- END BEGIN PROFILE SIDEBAR -->
				<!-- BEGIN PROFILE CONTENT -->

				<div class="profile-content">
					<div class="row">
						<div class="col-md-12">
							<div class="portlet light">
								<div class="portlet-title tabbable-line">
									<div class="caption caption-md">
										<i class="icon-globe theme-font hide"></i> <span
											class="caption-subject font-blue-madison bold uppercase">Change
											Password</span>
									</div>
								</div>
								<c:if test="${message!=null}">
									<div class="alert alert-info fade in">
										<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
										<strong class="alert_font">${message}</strong>
									</div>
								</c:if>
								<div class="portlet-body">
									<div class="tab-content">
										<!-- CHANGE PASSWORD TAB -->
										<div class="tab-pane active in" id="tab_1_3">
											<form:form method="post"
												action="${pageContext.request.contextPath}/saveChangePassword"
												commandName="changePassword">
												
												<div class="form-group">
													<label class="control-label">Current Password<span
													class="astrek" style="color: red"> * </span></label> 
													<form:input id="oldPassword" path="oldPassword"
														class="form-control" type="password" required="required" />
												</div>
												<div class="form-group">
													<label class="control-label">New Password<span
													class="astrek" style="color: red"> * </span></label> 
													<form:input id="newpass" path="newPassword"
														class="form-control" type="password" required="required" />
												</div>
												<div class="form-group">
													<label class="control-label">Re-type New Password<span
													class="astrek" style="color: red"> * </span></label> 
													<form:input id="verpass" path="verifyNewPassword"
														class="form-control" type="password" required="required" />
												</div>
												<div class="margin-top-10">
													<input type="submit" class="btn btn-sm green-haze"
														value="Save" onClick="javascript:submitform();"/>
													<a href="${pageContext.request.contextPath}/auth/showChangePassword"
														class="btn btn-sm btn-default"> Cancel </a>
												</div>
											</form:form>
										</div>
										<!-- END CHANGE PASSWORD TAB -->

									</div>
								</div>
							</div>
						</div>

					</div>

				</div>
				<!-- END PROFILE CONTENT -->
			</div>
		</div>
		<!-- END PAGE CONTENT INNER -->
	</div>
</div>
<!-- END CONTENT -->

<%@ include file="/WEB-INF/jsp/common/bottom.jsp"%>