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
								<li class="active"><a
									href="${pageContext.request.contextPath}/user/notification">
										<i class="icon-settings"></i> Notification
								</a></li>
								<li><a
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
							<!-- BEGIN PORTLET -->
							<div class="portlet light">
								<div class="portlet-title">
									<div class="caption caption-md">
										<i class="icon-bar-chart theme-font hide"></i> <span
											class="caption-subject font-blue-madison bold uppercase">Notifications</span>
										<span class="caption-helper">45 pending</span>
									</div>
									<div class="inputs">
										<div class="portlet-input input-inline input-small ">
											<div class="input-icon right">
												<i class="icon-magnifier"></i> <input type="text"
													class="form-control form-control-solid"
													placeholder="search...">
											</div>
										</div>
									</div>
								</div>
								<div class="portlet-body">
									<div class="scroller" style="height: 305px;"
										data-always-visible="1" data-rail-visible1="0"
										data-handle-color="#D7DCE2">
										<div class="general-item-list">
											<div class="item">
												<div class="item-head">
													<div class="item-details">
														<img class="item-pic" src="assets/img/layout/avatar4.jpg">
														<a href="" class="item-name primary-link">Nick Larson</a>
														<span class="item-label">3 hrs ago</span>
													</div>
													<span class="item-status"><span
														class="badge badge-empty badge-success"></span> Open</span>
												</div>
												<div class="item-body">Lorem ipsum dolor sit amet,
													consectetuer adipiscing elit, sed diam nonummy nibh euismod
													tincidunt ut laoreet dolore magna aliquam erat volutpat.</div>
											</div>
											<div class="item">
												<div class="item-head">
													<div class="item-details">
														<img class="item-pic" src="assets/img/layout/avatar3.jpg">
														<a href="" class="item-name primary-link">Mark</a> <span
															class="item-label">5 hrs ago</span>
													</div>
													<span class="item-status"><span
														class="badge badge-empty badge-warning"></span> Pending</span>
												</div>
												<div class="item-body">Lorem ipsum dolor sit amet,
													consectetuer adipiscing elit, sed diam nonummy nibh euismod
													tincidunt ut laoreet dolore magna aliquam erat volutpat
													tincidunt ut laoreet.</div>
											</div>
											<div class="item">
												<div class="item-head">
													<div class="item-details">
														<img class="item-pic" src="assets/img/layout/avatar6.jpg">
														<a href="" class="item-name primary-link">Nick Larson</a>
														<span class="item-label">8 hrs ago</span>
													</div>
													<span class="item-status"><span
														class="badge badge-empty badge-primary"></span> Closed</span>
												</div>
												<div class="item-body">Lorem ipsum dolor sit amet,
													consectetuer adipiscing elit, sed diam nonummy nibh.</div>
											</div>
											<div class="item">
												<div class="item-head">
													<div class="item-details">
														<img class="item-pic" src="assets/img/layout/avatar7.jpg">
														<a href="" class="item-name primary-link">Nick Larson</a>
														<span class="item-label">12 hrs ago</span>
													</div>
													<span class="item-status"><span
														class="badge badge-empty badge-danger"></span> Pending</span>
												</div>
												<div class="item-body">Consectetuer adipiscing elit
													Lorem ipsum dolor sit amet, consectetuer adipiscing elit,
													sed diam nonummy nibh euismod tincidunt ut laoreet dolore
													magna aliquam erat volutpat.</div>
											</div>
											<div class="item">
												<div class="item-head">
													<div class="item-details">
														<img class="item-pic" src="assets/img/layout/avatar9.jpg">
														<a href="" class="item-name primary-link">Richard
															Stone</a> <span class="item-label">2 days ago</span>
													</div>
													<span class="item-status"><span
														class="badge badge-empty badge-danger"></span> Open</span>
												</div>
												<div class="item-body">Lorem ipsum dolor sit amet,
													consectetuer adipiscing elit, ut laoreet dolore magna
													aliquam erat volutpat.</div>
											</div>
											<div class="item">
												<div class="item-head">
													<div class="item-details">
														<img class="item-pic" src="assets/img/layout/avatar8.jpg">
														<a href="" class="item-name primary-link">Dan</a> <span
															class="item-label">3 days ago</span>
													</div>
													<span class="item-status"><span
														class="badge badge-empty badge-warning"></span> Pending</span>
												</div>
												<div class="item-body">Lorem ipsum dolor sit amet, sed
													diam nonummy nibh euismod tincidunt ut laoreet dolore magna
													aliquam erat volutpat.</div>
											</div>
											<div class="item">
												<div class="item-head">
													<div class="item-details">
														<img class="item-pic" src="assets/img/layout/avatar2.jpg">
														<a href="" class="item-name primary-link">Larry</a> <span
															class="item-label">4 hrs ago</span>
													</div>
													<span class="item-status"><span
														class="badge badge-empty badge-success"></span> Open</span>
												</div>
												<div class="item-body">Lorem ipsum dolor sit amet,
													consectetuer adipiscing elit, sed diam nonummy nibh euismod
													tincidunt ut laoreet dolore magna aliquam erat volutpat.</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<!-- END PORTLET -->
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