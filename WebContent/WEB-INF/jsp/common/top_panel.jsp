<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!-- BEGIN HEADER -->
<div class="page-header md-shadow-z-1-i navbar navbar-fixed-top">
	<!-- BEGIN HEADER INNER -->
	<div class="page-header-inner">
		<!-- BEGIN LOGO -->
		<div class="page-logo">
			<a href="index.html"> <img src="${pageContext.request.contextPath}/images/layout/logo-ksn.png"
				alt="logo" class="logo-default" height="50" width="100"/>
			</a>
			<div class="menu-toggler sidebar-toggler">
				<!--  -->
			</div>
		</div>
		<!-- END LOGO -->
		<!-- BEGIN RESPONSIVE MENU TOGGLER -->
		<a href="javascript:;" class="menu-toggler responsive-toggler"
			data-toggle="collapse" data-target=".navbar-collapse"> </a>
		<!-- END RESPONSIVE MENU TOGGLER -->
		<!-- BEGIN PAGE ACTIONS -->
		<!-- BEGIN PAGE TOP -->
		<div class="page-top">
			<!-- BEGIN HEADER SEARCH BOX -->
			
			<!-- BEGIN TOP NAVIGATION MENU -->
			<div class="top-menu">
				<ul class="nav navbar-nav pull-right">
					<li class="separator hide"></li>
					<!-- BEGIN NOTIFICATION DROPDOWN -->
				
					<li
						class="dropdown dropdown-extended dropdown-notification dropdown-dark"
						id="header_notification_bar"><a href="javascript:;"
						class="dropdown-toggle" data-toggle="dropdown"
						data-hover="dropdown" data-close-others="true"> <i
							class="icon-bell"></i> <span class="badge badge-yellow">
						7 </span>
					</a>
						<ul class="dropdown-menu">
							<li class="external">
								<h3>
									<span class="bold">12 </span><spring:message code="header.pending.notification" text="" />
								</h3> <a href="extra_profile.html"><spring:message code="header.view.all" text="" /></a>
							</li>
							<li>
								<ul class="dropdown-menu-list scroller" style="height: 250px;"
									data-handle-color="#637283">
									<li><a href="javascript:;"> <span class="time">just
												now</span> <span class="details"> <span
												class="label label-sm label-icon label-success"> <i
													class="fa fa-plus"></i>
											</span> New user registered.
										</span>
									</a></li>
									<li><a href="javascript:;"> <span class="time">3
												mins</span> <span class="details"> <span
												class="label label-sm label-icon label-danger"> <i
													class="fa fa-bolt"></i>
											</span> Server #12 overloaded.
										</span>
									</a></li>
									<li><a href="javascript:;"> <span class="time">10
												mins</span> <span class="details"> <span
												class="label label-sm label-icon label-warning"> <i
													class="fa fa-bell-o"></i>
											</span> Server #2 not responding.
										</span>
									</a></li>
									<li><a href="javascript:;"> <span class="time">14
												hrs</span> <span class="details"> <span
												class="label label-sm label-icon label-info"> <i
													class="fa fa-bullhorn"></i>
											</span> Application error.
										</span>
									</a></li>
									<li><a href="javascript:;"> <span class="time">2
												days</span> <span class="details"> <span
												class="label label-sm label-icon label-danger"> <i
													class="fa fa-bolt"></i>
											</span> Database overloaded 68%.
										</span>
									</a></li>
									<li><a href="javascript:;"> <span class="time">3
												days</span> <span class="details"> <span
												class="label label-sm label-icon label-danger"> <i
													class="fa fa-bolt"></i>
											</span> A user IP blocked.
										</span>
									</a></li>
									<li><a href="javascript:;"> <span class="time">4
												days</span> <span class="details"> <span
												class="label label-sm label-icon label-warning"> <i
													class="fa fa-bell-o"></i>
											</span> Storage Server #4 not responding dfdfdfd.
										</span>
									</a></li>
									<li><a href="javascript:;"> <span class="time">5
												days</span> <span class="details"> <span
												class="label label-sm label-icon label-info"> <i
													class="fa fa-bullhorn"></i>
											</span> System Error.
										</span>
									</a></li>
									<li><a href="javascript:;"> <span class="time">9
												days</span> <span class="details"> <span
												class="label label-sm label-icon label-danger"> <i
													class="fa fa-bolt"></i>
											</span> Storage server failed.
										</span>
									</a></li>
								</ul>
							</li>
						</ul></li>

					<!-- BEGIN USER LOGIN DROPDOWN -->
					<!-- DOC: Apply "dropdown-dark" class after below "dropdown-extended" to change the dropdown styte -->
					<li class="dropdown dropdown-user dropdown-dark"><a
						href="javascript:;" class="dropdown-toggle" data-toggle="dropdown"
						data-hover="dropdown" data-close-others="true"> <span
							class="username username-hide-on-mobile"> ${userDetails.firstName} ${userDetails.middleName} ${userDetails.lastName}  </span> <!-- DOC: Do not remove below empty space(&nbsp;) as its purposely used -->
							<img alt="" class="img-circle" src="${pageContext.request.contextPath}/user/readUserImage" />
					</a>
						<ul class="dropdown-menu dropdown-menu-default">
							<li>
								<a href="${pageContext.request.contextPath}/user/profile">
								<i class="icon-user"></i><spring:message code="header.MyProfile" text="" /></a>
							</li>
							<li class="divider">
							</li>
							<li>
								<a href="${pageContext.request.contextPath}/locked">
								<i class="icon-lock"></i><spring:message code="header.LockScreen" text="" /></a>
							</li>
							<li>
								<a href="${pageContext.request.contextPath}/logout">
								<i class="icon-key"></i><spring:message code="header.LogOut" text="" /></a>
							</li>
						</ul></li>
					<!-- END USER LOGIN DROPDOWN -->

				</ul>
			</div>
			<!-- END TOP NAVIGATION MENU -->
		</div>
		<!-- END PAGE TOP -->
	</div>
	<!-- END HEADER INNER -->
</div>
<!-- END HEADER -->
<div class="clearfix"></div>