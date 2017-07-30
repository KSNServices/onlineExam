<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

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
		<li><a href="index.html"><spring:message code="page.home"
					text="" /></a></li>
		<li><a
			href="${pageContext.request.contextPath}/teacher/teacherDetail"><spring:message
					code="user.manage.teacher" text="" /></a></li>
	</ul>
	<!-- END PAGE BREADCRUMB -->

	<!-- BEGIN PAGE CONTENT INNER -->
	<div class="row margin-top-10">
		<div class="col-md-12">
			<!-- BEGIN SAMPLE TABLE PORTLET-->
			<div class="portlet box lightblue">
				<div class="portlet-title">
					<div class="caption">
						<i class="fa fa-cogs"></i>
						<spring:message code="user.manage.teacher" text="" />
					</div>
					<div class="actions">
						<a data-toggle="collapse" data-target="#addform"
							class="btn btn-danger btn-sm"> <spring:message
								code="page.add" text="" /> <i class="fa fa-plus"></i>
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
								<form:form class="form-horizontal" commandName="teacher" 
									action="${pageContext.request.contextPath}/teacher/saveTeacherDetail"
									method="post" enctype="multipart/form-data">
									<form:hidden path="id" />
									<form:hidden path="adminId.id" />
									<form:hidden path="schoolId.id" />
					
									<div class="form-body">
										<div class="row">
											<div class="col-md-5  col-md-offset-1">
												<div class="form-group">
													<label class="control-label col-md-4"> <spring:message
															code="Teacher.teacher_id" text="" /><span class="astrek"
														style="color: red"> * </span></label>
													<div class="col-md-8">
														<form:input id="teacherId" path="teacherId"
															class="form-control" type="text" required="required" readonly="true" />
														<span class="help-block"></span>
													</div>
												</div>
											</div>
											<div class="col-md-5">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message
															code="Teacher.teacher_name" text="" /><span
														class="astrek" style="color: red"> * </span></label>
													<div class="col-md-8">
														<form:input id="teacherName" path="teacherName"
															class="form-control" type="text" required="required" />
														<span class="help-block"></span>
													</div>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-5 col-md-offset-1">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message
															code="Teacher.class_alloted" text="" /></label>
													<div class="col-md-8">
														<form:input id="classAlloted" path="classAlloted"
															class="form-control" type="text" />
														<span class="help-block"></span>
													</div>
												</div>
											</div>
											<div class="col-md-5">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message
															code="Teacher.mobile_number" text="" /><span
														class="astrek" style="color: red"> * </span></label>
													<div class="col-md-8">
														<form:input id="mobileNumber" path="mobileNumber"
															class="form-control" type="number" required="required" />
														<span class="help-block"></span>
													</div>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-5 col-md-offset-1">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message
															code="Teacher.aadhar_no" text="" /><span class="astrek"
														style="color: red"> * </span></label>
													<div class="col-md-8">
														<form:input id="aadharNumber" path="aadharNumber"
															class="form-control" type="number"  />
														<span class="help-block"></span>
													</div>
												</div>
											</div>
											<div class="col-md-5">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message
															code="Teacher.subject_preference" text="" /><span
														class="astrek" style="color: red"> * </span></label>
													<div class="col-md-8">
														<form:input id="subjectPreference"
															path="subjectPreference" class="form-control" type="text"
															required="required" />
														<span class="help-block"></span>
													</div>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-5 col-md-offset-1">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message
															code="Teacher.category" text="" /></label>
													<div class="col-md-8">
														<form:input id="category" path="category"
															class="form-control" type="text" />
														<span class="help-block"></span>
													</div>
												</div>
											</div>
											<div class="col-md-5">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message
															code="Teacher.gender" text="" /> </label>
													<div class="col-md-8">
														<form:select path="gender" required="required"
															class="form-control">
															<form:option value="None"
																label="--------------- Select------------------" />
															<form:option value="Male" label="Male" />
															<form:option value="Female" label="Female" />


														</form:select>

													</div>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-5 col-md-offset-1">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message
															code="Teacher.email_id" text="" /><span class="astrek"
														style="color: red"> * </span></label>
													<div class="col-md-8">
														<form:input id="emailId" path="emailId"
															class="form-control" type="email" />
														<span class="help-block"></span>

													</div>
												</div>
											</div>
											<div class="col-md-5">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message
															code="Teacher.address" text="" /></label>
													<div class="col-md-8">
														<form:input id="address" path="address"
															class="form-control" type="text" />
														<span class="help-block"></span>
													</div>
												</div>
											</div>
										</div>

										<div class="row">
											<div class="col-md-5 col-md-offset-1">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message
															code="Teacher.dob" text="" /></label>
													<div class="col-md-8">
														<form:input id="dob" path="dob" class="form-control"
															type="date" />
														<span class="help-block"></span>
													</div>
												</div>
											</div>
											<div class="col-md-5">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message
															code="Teacher.max_qualification" text="" /> </label>
													<div class="col-md-8">
														<form:input id="maximumQualification"
															path="maximumQualification" class="form-control"
															type="text" />
														<span class="help-block"></span>
													</div>
												</div>
											</div>
										</div>

	<div class="row">
											<div class="col-md-5 col-md-offset-1">
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
														<button type="submit" class="btn btn-sm btn-success">
															<spring:message code="page.submit" text="" />
														</button>
													</div>
												</div>
											</div>

										</div>

									
									</div>
								</form:form>
							</div>
						</div>
					</div>
					<c:if test="${!empty listTeacher}">
						<table id="sample_3"
							class="table table-bordered table-striped table-condensed flip-content">
							<thead class="flip-content">
								<tr>
									<th><spring:message code="page.table.slno" text="" /></th>
									<th><spring:message code="user.image" text="" /></th>
									<th><spring:message code="Teacher.teacher_id" text="" /></th>
									<th><spring:message code="Teacher.teacher_name" text="" /></th>
									<th><spring:message code="Teacher.email_id" text="" /></th>
									<th><spring:message code="Teacher.mobile_number" text="" /></th>
									<th><spring:message code="Teacher.gender" text="" /></th>
									<th><spring:message code="Teacher.dob" text="" /></th>
									<th><spring:message code="page.table.action" text="" /></th>
									</tr>
							</thead>
							<tbody>
								<c:forEach items="${listTeacher}" var="teacher"
									varStatus="status">
									<tr>
									<td>${status.count}</td>
										<td><img alt=""
											src="${pageContext.request.contextPath}/teacher/readTeacherDisplayImage/${teacher.id}"
											width="30" height="40" /></td>
										<td>${teacher.teacherName}</td>
										<td>${teacher.teacherId}</td>
										<td>${teacher.emailId}</td>
										<td>${teacher.mobileNumber}</td>
										<td>${teacher.gender}</td>
										<td>${teacher.dob}</td>
										<td class="display-flex"><a href="javascript:;"
											data-original-title="View"
											class="tooltips btn btn-success btn-xs"> <i
												class="fa fa-eye"></i>
										</a> <a
											href="${pageContext.request.contextPath}/teacher/editTeacher/${teacher.id}"
											data-original-title="Edit"
											class="tooltips btn btn-success btn-xs"> <i
												class="fa fa-pencil"></i>
										</a> <c:if test="${Teacher.enabled}">
												<a
													href="${pageContext.request.contextPath}/teacher/enableDisableTeacher/${teacher.id}/false"
													data-original-title="Click to Disable"
													class="tooltips btn btn-danger btn-xs"><i
													class="fa fa-toggle-off" aria-hidden="true"></i>
												<spring:message code="page.table.disable" text="" /></a>
											</c:if> <c:if test="${!Teacher.enabled}">
												<a
													href="${pageContext.request.contextPath}/teacher/enableDisableTeacher/${teacher.id}/true"
													data-original-title="Click to Enable"
													class="tooltips btn btn-success btn-xs"> <i
													class="fa fa-toggle-off" aria-hidden="true"></i> <spring:message
														code="page.table.enable" text="" />

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

<script type="text/javascript">
	
</script>

<%@ include file="/WEB-INF/jsp/common/bottom.jsp"%>