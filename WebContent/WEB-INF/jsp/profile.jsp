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
								src="${pageContext.request.contextPath}/user/readUserImage"
								class="img-responsive" alt="">
						</div>
						<!-- END SIDEBAR USERPIC -->
						<!-- SIDEBAR USER TITLE -->
						<div class="profile-usertitle">
							<div class="profile-usertitle-name">${userDetails.firstName} ${userDetails.lastName}</div>
							<div class="profile-usertitle-job">${userDetails.authority}</div>
						</div>
						<!-- END SIDEBAR USER TITLE -->

						<!-- SIDEBAR MENU -->
						<div class="profile-usermenu">
							<ul class="nav">
								<li class="active"><a
									href="${pageContext.request.contextPath}/user/profile"> <i
										class="icon-user"></i><spring:message code="profile" text="" /> 
								</a></li>
								<li><a
									href="${pageContext.request.contextPath}/user/notification">
										<i class="icon-settings"></i><spring:message code="notification" text="" /> 
								</a></li>
								<li><a
									href="${pageContext.request.contextPath}/showChangePassword">
										<i class="icon-key"></i><spring:message code="change.password" text="" /> 
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
											class="caption-subject font-blue-madison bold uppercase"><spring:message code="profile.account" text="" /></span>
									</div>
									<ul class="nav nav-tabs">
										<li class="active"><a href="#tab_1_1" data-toggle="tab"><spring:message code="personal.info" text="" /></a></li>
										<li><a href="#tab_1_2" data-toggle="tab"><spring:message code="user.image" text="" /></a></li>
										<li><a href="#tab_1_4" data-toggle="tab"><spring:message code="privacy.setting" text="" /></a></li>
									</ul>
								</div>
								<div class="portlet-body">
									<div class="tab-content">
										<!-- PERSONAL INFO TAB -->
										<div class="tab-pane active" id="tab_1_1">
											<form:form method="post" name="profileFrm"
												action="${pageContext.request.contextPath}/user/saveProfile"
												commandName="userdetails">
												<form:hidden path="id" />
												<form:hidden path="password" />
												<form:hidden path="enabled" />
												<form:hidden path="userImages" />
												<div class="row">
  													<div class="col-xs-12 col-sm-6 col-md-6 col-lg-6">
														<div class="form-group">
															<label class="control-label"><spring:message code="user.first.name" text="" /></label> 
															<form:input
																id="firstName" path="firstName" class="form-control" type="text"/>
														</div>
													</div>
													<div class="col-xs-12 col-sm-6 col-md-6 col-lg-6">
														<div class="form-group">
															<label class="control-label"><spring:message code="user.middle.name" text="" /></label> 
															<form:input
																id="middleName" path="middleName" class="form-control" type="text"/>
														</div>
													</div>
												</div>
												<div class="row">
  													<div class="col-xs-12 col-sm-6 col-md-6 col-lg-6">
  														<div class="form-group">
															<label class="control-label"><spring:message code="user.last.name" text="" /></label> 
															<form:input
																id="lastName" path="lastName" class="form-control" type="text"/>
														</div>
													</div>
													<div class="col-xs-12 col-sm-6 col-md-6 col-lg-6">
														<div class="form-group">
															<label class="control-label"><spring:message code="applicant.mobile.number" text="" /></label> 
															<form:input
																id="lastName" path="lastName" class="form-control" type="text" 
																placeholder="+1 646 580 DEMO (6284)"/>
														</div>  													
  													</div>
  												</div>
												<div class="row">
  													<div class="col-xs-12 col-sm-6 col-md-6 col-lg-6">
  														<div class="form-group">
															<label class="control-label"><spring:message code="applicant.email" text="" /></label> 
															<form:input
																id="emailAddress" path="emailAddress" class="form-control" type="text" 
																placeholder="email id"/>
														</div>  													
  													</div>
  													<div class="col-xs-12 col-sm-6 col-md-6 col-lg-6">
  														<div class="form-group">
															<label class="control-label"><spring:message code="interests" text="" /></label> 
															<form:input
																id="interests" path="interests" class="form-control" type="text" 
																placeholder="Design, Web etc."/>
														</div>
  													</div>
  												</div>
												<div class="row">
  													<div class="col-xs-12 col-sm-6 col-md-6 col-lg-6">
	  													<div class="form-group">
															<label class="control-label"><spring:message code="website.url" text="" /></label> 
															<form:input
																id="userWebsite" path="userWebsite" class="form-control" type="text" 
																placeholder="http://www.mywebsite.com"/>
														</div>
  													</div>  													
  												</div>
												<div class="row">
  													<div class="col-xs-12 col-sm-6 col-md-6 col-lg-6">
  														<div class="form-group">
															<label class="control-label"><spring:message code="about.me" text="" /></label>
															<form:textarea rows="2" maxlength="512"
																required="required" id="interests" path="interests" class="form-control" type="text" 
																placeholder="We are KeenThemes!!!"/>
														</div>
  													</div>
  												</div>
												
												
												<div class="margiv-top-10">
													<input type="Submit" class="btn btn-sm green-haze" value="<spring:message code="save.changes" text="" />">
													<a href="javascript:;"
														class="btn btn-sm btn-default"><spring:message code="page.close" text="" /></a>
												</div>
											</form:form>
										</div>
										<!-- END PERSONAL INFO TAB -->
										<!-- CHANGE AVATAR TAB -->
										<div class="tab-pane" id="tab_1_2">
											<!-- <p></p> -->
											<form method="post" action="${pageContext.request.contextPath}/user/uploadProfilePicture"  enctype="multipart/form-data">
												<div class="form-group">
													<div class="fileinput fileinput-new"
														data-provides="fileinput">
														<div class="fileinput-new thumbnail"
															style="width: 200px; height: 150px;">
															<img
																src="${pageContext.request.contextPath}/user/readUserImage"
																alt="" />
														</div>
														<div class="fileinput-preview fileinput-exists thumbnail"
															style="max-width: 200px; max-height: 150px;"></div>
														<div>
															<input type="file" id="image" name="image" title="Select profile picture" />															
														</div>
													</div>
													<div class="clearfix margin-top-10">
														
													</div>
												</div>
												<div class="margin-top-10">
													<input type="submit" class="btn btn-sm green-haze"
														value="<spring:message code="upload" text="" />" />
													<a href="javascript:;"
														class="btn btn-sm btn-default"> <spring:message code="page.close" text="" /> </a>
												</div>
											</form>
										</div>
										<!-- END CHANGE AVATAR TAB -->
										<!-- PRIVACY SETTINGS TAB -->
										<div class="tab-pane" id="tab_1_4">
											<form action="#">
												<table class="table table-light table-hover">
													<tr>
														<td>Anim pariatur cliche reprehenderit, enim eiusmod
															high life accusamus..</td>
														<td><label class="uniform-inline"> <input
																type="radio" name="optionsRadios1" value="option1" />
																Yes
														</label> <label class="uniform-inline"> <input
																type="radio" name="optionsRadios1" value="option2"
																checked /> No
														</label></td>
													</tr>
													<tr>
														<td>Enim eiusmod high life accusamus terry richardson
															ad squid wolf moon</td>
														<td><label class="uniform-inline"> <input
																type="checkbox" value="" /> Yes
														</label></td>
													</tr>
													<tr>
														<td>Enim eiusmod high life accusamus terry richardson
															ad squid wolf moon</td>
														<td><label class="uniform-inline"> <input
																type="checkbox" value="" /> Yes
														</label></td>
													</tr>
													<tr>
														<td>Enim eiusmod high life accusamus terry richardson
															ad squid wolf moon</td>
														<td><label class="uniform-inline"> <input
																type="checkbox" value="" /> Yes
														</label></td>
													</tr>
												</table>
												<!--end profile-settings-->
												<div class="margin-top-10">
													<a href="javascript:;" class="btn btn-sm green-haze">
														<spring:message code="save.changes" text="" /></a> <a href="javascript:;"
														class="btn btn-sm btn-default"><spring:message code="page.close" text="" /></a>
												</div>
											</form>
										</div>
										<!-- END PRIVACY SETTINGS TAB -->
									</div>
								</div>
							</div>
						</div>

					</div>

				</div>
				<!-- END PROFILE CONTENT -->


				<!-- END PROFILE CONTENT -->
			</div>
		</div>
		<!-- END PAGE CONTENT INNER -->
	</div>
</div>
<!-- END CONTENT -->

<%@ include file="/WEB-INF/jsp/common/bottom.jsp"%>