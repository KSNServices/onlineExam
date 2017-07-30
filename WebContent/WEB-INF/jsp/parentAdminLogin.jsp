<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="page-content">
	<!-- BEGIN PAGE HEAD -->
	<div class="page-head">
		<!-- BEGIN PAGE TITLE -->
		<!-- <div class="page-title">
			<h1>Country</h1>
		</div> -->
		<!-- END PAGE TITLE -->
	</div>
	<!-- END PAGE HEAD -->
	<!-- BEGIN PAGE BREADCRUMB -->
	<ul
		class="page-breadcrumb breadcrumb breadcrumb-arrow breadcrumb-arrow">
		<li><a href="index.html"><spring:message code="page.home" text="" /></a></li>
		<li><a href="${pageContext.request.contextPath}/parentUser/parentAdminLogin"><spring:message code="user.parent.admin" text="" /></a></li>
	</ul>
	<!-- END PAGE BREADCRUMB -->

	<!-- BEGIN PAGE CONTENT INNER -->
	<div class="row margin-top-10">
		<div class="col-md-12">
			<!-- BEGIN SAMPLE TABLE PORTLET-->
			<div class="portlet box lightblue">
				<div class="portlet-title">
					<div class="caption">
						<i class="fa fa-cogs"></i><spring:message code="user.parent.admin" text="" />
					</div>
					<div class="actions">
						<a data-toggle="collapse" data-target="#addform"
							class="btn btn-danger btn-sm"> <spring:message code="page.add" text="" /> <i class="fa fa-plus"></i>
						</a>
					</div>
				</div>
				<div class="portlet-body flip-scroll">
					<%
						String style = "collapse";
					%>
					<c:if test="${showDiv}">
						<%
							style = "";
						%>
					</c:if>
					<div id="addform" class="<%=style%>">
						<div class="portlet box">
							<div class="portlet-body form">
								<form:form class="form-horizontal" commandName="user"
									action="${pageContext.request.contextPath}/parentUser/saveParentAdmin"
									method="post" enctype="multipart/form-data">
									<form:hidden path="id" />
									
									<form:hidden path="password" />
									<form:hidden path="enabled" />
									<form:hidden path="authority" />
									<div class="form-body">
										<div class="row">
											<div class="col-md-5 col-md-offset-1">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message code="user.name" text="" /><span
														class="astrek" style="color: red"> * </span></label>
													<div class="col-md-8">
														<form:input id="userName" path="userName"
															class="form-control" type="text" required="required" />
														<span class="help-block"></span>
													</div>
												</div>
											</div>
											<div class="col-md-5">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message code="user.first.name" text="" /><span
														class="astrek" style="color: red"> * </span></label>
													<div class="col-md-8">
														<form:input id="firstName" path="firstName"
															class="form-control" type="text" required="required" />
														<span class="help-block"></span>
													</div>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-5 col-md-offset-1">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message code="user.middle.name" text="" /></label>
													<div class="col-md-8">
														<form:input id="middleName" path="middleName"
															class="form-control" type="text" />
														<span class="help-block"></span>
													</div>
												</div>
											</div>
											<div class="col-md-5">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message code="user.last.name" text="" /><span
														class="astrek" style="color: red"> * </span></label>
													<div class="col-md-8">
														<form:input id="lastName" path="lastName"
															class="form-control" type="text" required="required" />
														<span class="help-block"></span>
													</div>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-5 col-md-offset-1">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message code="applicant.mobile.number" text="" /><span
														class="astrek" style="color: red"> * </span></label>
													<div class="col-md-8">
														<form:input id="mobileNumber" path="mobileNumber"
															class="form-control" type="text" required="required" />
														<span class="help-block"></span>
													</div>
												</div>
											</div>
											<div class="col-md-5">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message code="applicant.email" text="" /><span
														class="astrek" style="color: red"> * </span></label>
													<div class="col-md-8">
														<form:input id="emailAddress" path="emailAddress"
															class="form-control" type="text" required="required" />
														<span class="help-block"></span>
													</div>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-5 col-md-offset-1">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message code="user.phone.number" text="" /></label>
													<div class="col-md-8">
														<form:input id="phoneNumber" path="phoneNumber"
															class="form-control" type="text" />
														<span class="help-block"></span>
													</div>
												</div>
											</div>
											<div class="col-md-5">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message code="user.fax.number" text="" /> </label>
													<div class="col-md-8">
														<form:input id="fax" path="fax" class="form-control"
															type="text" />
														<span class="help-block"></span>
													</div>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-5 col-md-offset-1">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message code="payment.plan.name" text="" /><span
														class="astrek" style="color: red"> * </span></label>
													<div class="col-md-8">
														<form:select path="paymentPlan.id" required="required"
															class="form-control">
															<form:option value="" label="--- Select payment plan---" />
															<form:options title="Select payment plan"
																items="${paymentPlanList}" itemValue="id"
																itemLabel="paymentPlanName" />
														</form:select>
													</div>
												</div>
											</div>
											<div class="col-md-5">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message code="user.image" text="" /></label>
													<div class="col-md-8">
														<input type="file" name="userpic" id="userpic"
															class="form-control"> <span class="help-block"></span>
													</div>
												</div>
											</div>
										</div>
										
										<div class="row margin-top-10">
											<div class="col-md-5 col-md-offset-1">
												<div class="row">
													<div class="col-md-offset-4 col-md-9">
														<button type="submit" class="btn btn-sm btn-success"><spring:message
																code="page.submit" text="" /></button>
													</div>
												</div>
											</div>

										</div>
									</div>
								</form:form>
							</div>
						</div>
					</div>
					<c:if test="${!empty userList}">
						<table id="sample_3"
							class="table table-bordered table-striped table-condensed flip-content">
							<thead class="flip-content">
								<tr>
									<th><spring:message code="page.table.slno" text="" /></th>
									<th><spring:message code="user.image" text="" /></th>
									<th><spring:message code="admin.name" text="" /></th>
									<th><spring:message code="user.name" text="" /></th>
									<th><spring:message code="applicant.email" text="" /></th>
									<th><spring:message code="applicant.mobile.number" text="" /></th>
									<th><spring:message code="user.phone.number" text="" /></th>
									<th><spring:message code="payment.plan.name" text="" /></th>
									<th><spring:message code="page.table.action" text="" /></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${userList}" var="user" varStatus="status">
									<tr>
										<td>${status.count}</td>
										<td><img alt=""
											src="${pageContext.request.contextPath}/parentUser/readUserDisplayImage/${user.id}"
											width="30" height="40" /></td>
										<td>${user.firstName}${user.lastName}</td>
										<td>${user.userName}</td>
										<td>${user.emailAddress}</td>
										<td>${user.mobileNumber}</td>
										<td>${user.phoneNumber}</td>
										<td>${user.paymentPlan.paymentPlanName}</td>
										<td class="display-flex"><a href="javascript:;"
											data-original-title="View"
											class="tooltips btn btn-success btn-xs"> <i
												class="fa fa-eye"></i>
										</a> <a
											href="${pageContext.request.contextPath}/parentUser/editUser/${user.id}"
											data-original-title="Edit"
											class="tooltips btn btn-success btn-xs"> <i
												class="fa fa-pencil"></i>
										</a> <c:if test="${user.enabled}">
												<a
													href="${pageContext.request.contextPath}/parentUser/enableDisableAdmin/${user.id}/false"
													data-original-title="Click to Enable"
													class="tooltips btn btn-danger btn-xs"><i
													class="fa fa-toggle-off" aria-hidden="true"></i><spring:message code="page.table.enable" text="" /></a>
											</c:if> <c:if test="${!user.enabled}">
												<a
													href="${pageContext.request.contextPath}/parentUser/enableDisableAdmin/${user.id}/true"
													data-original-title="Click to Enable"
													class="tooltips btn btn-success btn-xs"> <i
													class="fa fa-toggle-off" aria-hidden="true"></i> <spring:message code="page.table.disable" text="" />
													
												</a>
											</c:if></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</c:if>
				</div>
			</div>
			<!-- END SAMPLE TABLE PORTLET-->

		</div>
	</div>
	<!-- END PAGE CONTENT INNER -->
</div>

<%@ include file="/WEB-INF/jsp/common/bottom.jsp"%>