<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="page-content">
	<!-- BEGIN VIEW MODAL-->
	<div class="modal fade" id="view-modal" tabindex="-1" role="dialog"
		aria-labelledby="addressModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true"></button>
					<h4 class="modal-title">Question Paper Set</h4>
				</div>
				<div class="modal-body">

					<div class="form-group clearfix">
						<label for="" class="col-md-3 control-label">Level Name</label>
						<div class="col-md-4">Xth</div>
					</div>
					<div class="form-group clearfix">
						<label for="" class="col-md-3 control-label">Total No. of
							Questions</label>
						<div class="col-md-4">40</div>
					</div>
					<div class="form-group clearfix">
						<div class="col-md-8">
							<table class="table table-bordered">
								<thead class="bg-light-green">
									<tr>
										<th>S.NO.</th>
										<th>Subject</th>
										<th>No. of Questions</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>1</td>
										<td>Hindi</td>
										<td><input type="number" class="form-control"></td>
									</tr>
									<tr>
										<td>1</td>
										<td>Hindi</td>
										<td><input type="number" class="form-control"></td>
									</tr>
									<tr>
										<td>1</td>
										<td>Hindi</td>
										<td><input type="number" class="form-control"></td>
									</tr>
									<tr>
										<td>1</td>
										<td>Hindi</td>
										<td><input type="number" class="form-control"></td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-sm btn-default"
						data-dismiss="modal">Close</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->


	<ul
		class="page-breadcrumb breadcrumb breadcrumb-arrow breadcrumb-arrow">
		<li><a href="index.html"><spring:message code="page.home" text="" /></a></li>
		<li><a href="${pageContext.request.contextPath}/classSchedule/classTimeTable"><spring:message code="ClassSchedule.classTimeTable" text="" /></a></li>
	</ul>
	<!-- END PAGE BREADCRUMB -->

	<!-- BEGIN PAGE CONTENT INNER -->
	<div class="row margin-top-10">
		<div class="col-md-12">
			<!-- BEGIN SAMPLE TABLE PORTLET-->
			<div class="portlet box lightblue">
				<div class="portlet-title">
					<div class="caption">
						<i class="fa fa-cogs"></i><spring:message code="user.manage.classSchedule" text="" />
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
								<form:form class="form-horizontal" commandName="classSchedule"
									action="${pageContext.request.contextPath}/classSchedule/classTimeTable"
									method="post" enctype="multipart/form-data">								
									<form:hidden path="id"/>
									<div class="form-body">
									
										<div class="row">
											<div class="col-md-5  col-md-offset-1">
												<div class="form-group">
													<label class="control-label col-md-4"> <spring:message code="ClassSchedule.period" text="" /><span
														class="astrek" style="color: red"> * </span></label>
													<div class="col-md-8">
														<form:input id="period"   path="period"
															class="form-control" type="text" required="required" />
														<span class="help-block"></span>
													</div>
												</div>
											</div>
										</div>
											<div class="col-md-5">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message code="ClassSchedule.time" text="" /></label>
													<div class="col-md-8">
														<form:input id="time" path="time"
															class="form-control" type="text" required="required" />
														<span class="help-block"></span>
													</div>
												</div>
											</div>
										</div>
										
										
										 <div class="row">
											<div class="col-md-5 col-md-offset-1">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message code="ClassSchedule.class" text="" /></label>
													<div class="col-md-8">
														<form:input id="className" path="className"
															class="form-control" type="text" />
														<span class="help-block"></span>
													</div>
												</div>
											</div>
											<div class="col-md-5">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message code="ClassSchedule.section" text="" /></label>
													<div class="col-md-8">
														<form:input id="section" path="section"
															class="form-control" type="text" required="required" />
														<span class="help-block"></span>
													</div>
												</div>
											</div>
										</div>
										
										
										<div class="row">
											<div class="col-md-5 col-md-offset-1">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message code="ClassSchedule.monday_subject" text="" /></label>
													<div class="col-md-8">
														<form:input id="mondaySubject" path="mondaySubject"
															class="form-control" type="text" required="required" />
														<span class="help-block"></span>
													</div>
												</div>
											</div>
											<div class="col-md-5">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message code="ClassSchedule.monday_teacher" text="" /></label>
													<div class="col-md-8">
														<form:input id="mondaySubject" path="mondayTeacher"
															class="form-control" type="text" required="required" />
														<span class="help-block"></span>
													</div>
												</div>
											</div>
										</div>
										
										<div class="row">
											<div class="col-md-5 col-md-offset-1">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message code="ClassSchedule.tuesday_subject" text="" /></label>
													<div class="col-md-8">
													<form:input id="tuesdaySubject" path="tuesdaySubject"
															class="form-control" type="text" />
														<span class="help-block"></span>
											
													</div>
												</div>
											</div>
											<div class="col-md-5">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message code="ClassSchedule.tuesday_teacher" text="" /></label>
													<div class="col-md-8">
														<form:input id="tuesdayTeacher" path="tuesdayTeacher"
															class="form-control" type="text" />
														<span class="help-block"></span>
													</div>
												</div>
											</div>
										</div>
										
										<div class="row">
											<div class="col-md-5 col-md-offset-1">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message code="ClassSchedule.wednesday_subject" text="" /></label>
													<div class="col-md-8">
														<form:input id="wednesdaySubject" path="wednesdaySubject" class="form-control"
															type="text" />
														<span class="help-block"></span>
													</div>
												</div>
											</div>
											<div class="col-md-5">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message code="ClassSchedule.wednesday_teacher" text="" /> </label>
													<div class="col-md-8">
														<form:input id="wednesdayTeacher" path="wednesdayTeacher"
															class="form-control" type="text" />
														<span class="help-block"></span>
													</div>
												</div>
											</div>
										</div>
										
											<div class="row">
											<div class="col-md-5 col-md-offset-1">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message code="ClassSchedule.thursday_subject" text="" /></label>
													<div class="col-md-8">
														<form:input id="thursdaySubject" path="thursdaySubject" class="form-control"
															type="text" />
														<span class="help-block"></span>
													</div>
												</div>
											</div>
											<div class="col-md-5">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message code="ClassSchedule.thursday_teacher" text="" /> </label>
													<div class="col-md-8">
														<form:input id="thursdayTeacher" path="thursdayTeacher" class="form-control"
															type="text" />
														<span class="help-block"></span>
													</div>
												</div>
											</div>
										</div>
										
										
										<div class="row">
											<div class="col-md-5 col-md-offset-1">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message code="ClassSchedule.friday_subject" text="" /></label>
													<div class="col-md-8">
														<form:input id="fridaySubject" path="fridaySubject"
															class="form-control" type="text" />
														<span class="help-block"></span>
													</div>
												</div>
											</div>
											<div class="col-md-5">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message code="ClassSchedule.friday_teacher" text="" /> </label>
													<div class="col-md-8">
														<form:input id="fridayTeacher" path="fridayTeacher" class="form-control"
															type="text" />
														<span class="help-block"></span>
													</div>
												</div>
											</div>
										</div>
										
										
										<div class="row">
											<div class="col-md-5 col-md-offset-1">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message code="ClassSchedule.saturday_subject" text="" /></label>
													<div class="col-md-8">
														<form:input id="saturdaySubject" path="saturdaySubject"
															class="form-control" type="text" />
														<span class="help-block"></span>
													</div>
												</div>
											</div>
											<div class="col-md-5">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message code="ClassSchedule.saturday_teacher" text="" /> </label>
													<div class="col-md-8">
														<form:input id="saturdayTeacher" path="saturdayTeacher" class="form-control"
															type="text" />
														<span class="help-block"></span>
													</div>
												</div>
											</div>
										</div>
										
										<div class="row">
											<div class="col-md-5 col-md-offset-1">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message code="ClassSchedule.sunday_subject" text="" /></label>
													<div class="col-md-8">
														<form:input id="sundaySubject" path="sundaySubject"
															class="form-control" type="text" />
														<span class="help-block"></span>
													</div>
												</div>
											</div>
											<div class="col-md-5">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message code="ClassSchedule.sunday_teacher" text="" /> </label>
													<div class="col-md-8">
														<form:input id="sundayTeacher" path="sundayTeacher" class="form-control"
															type="text" />
														<span class="help-block"></span>
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
											src="${pageContext.request.contextPath}/user/readUserDisplayImage/${user.id}"
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
											href="${pageContext.request.contextPath}/user/editUser/${user.id}"
											data-original-title="Edit"
											class="tooltips btn btn-success btn-xs"> <i
												class="fa fa-pencil"></i>
										</a> <c:if test="${user.enabled}">
												<a
													href="${pageContext.request.contextPath}/user/enableDisableAdmin/${user.id}/false"
													data-original-title="Click to Enable"
													class="tooltips btn btn-danger btn-xs"><i
													class="fa fa-toggle-off" aria-hidden="true"></i><spring:message code="page.table.enable" text="" /></a>
											</c:if> <c:if test="${!user.enabled}">
												<a
													href="${pageContext.request.contextPath}/user/enableDisableAdmin/${user.id}/true"
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