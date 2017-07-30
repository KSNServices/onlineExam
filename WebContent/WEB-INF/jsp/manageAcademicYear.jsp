<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="page-content">
	<!-- BEGIN PAGE HEAD -->
	<div class="page-head">
		<!-- END PAGE TITLE -->
	</div>
	<!-- END PAGE HEAD -->
	<!-- BEGIN PAGE BREADCRUMB -->
	<ul
		class="page-breadcrumb breadcrumb breadcrumb-arrow breadcrumb-arrow">
		<li><a href="index.html"><spring:message code="page.home" text="" /></a></li>
		<li><a href="${pageContext.request.contextPath}/academicYear/manageAcademicYear"><spring:message code="academic.year" text="" /></a></li>
	</ul>
	<!-- END PAGE BREADCRUMB -->

	<!-- BEGIN PAGE CONTENT INNER -->
	<div class="row margin-top-10">
		<div class="col-md-12">
			<!-- BEGIN SAMPLE TABLE PORTLET-->
			<div class="portlet box lightblue">
				<div class="portlet-title">
					<div class="caption">
						<i class="icon-map"></i><spring:message code="academic.year" text="" />
					</div>
					<div class="actions">
						<a data-toggle="collapse" data-target="#addform"
							class="btn btn-danger btn-sm"><spring:message code="page.add" text="" />  <i class="fa fa-plus"></i>
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
								<form:form class="form-horizontal" commandName="academicYear"
									action="${pageContext.request.contextPath}/academicYear/saveAcademicYear"
									method="post">
									<form:hidden path="id" />
									<form:hidden path="adminId.id" />
									<form:hidden path="schoolId.id" />
									<div class="form-body">
										<div class="row">
											<div class="col-md-8 col-md-offset-1">

												<div class="col-md-12">
													<div class="form-group">
														<label class="control-label col-md-4"><spring:message code="academic.year.code" text="" /><span
															class="mandatory">* </span> </label>
														<div class="col-md-6">
															<form:input cssClass="form-control" path="yearCode"
																title="Enter the year code" placeholder="year code" />
															<span class="help-block"></span>
															<form:errors path="yearCode" cssClass="error" />
														</div>
													</div>
												</div>
												<div class="col-md-12">
													<div class="form-group">
														<label class="control-label col-md-4"><spring:message
																code="academic.year.StartDate" text="" /></label>
														<div class="col-md-6">
															<form:input class="form-control date-picker" 
																path="startDate" title="Enter the start Date"
																placeholder="start Date" />
															<span class="help-block"></span>
															<form:errors path="startDate" cssClass="error" />
														</div>
													</div>
												</div>
												<div class="col-md-12">
													<div class="form-group">
														<label class="control-label col-md-4"><spring:message
																code="academic.year.EndDate" text="" /></label>
														<div class="col-md-6">
															<form:input class="form-control date-picker" 
																path="endDate" title="Enter the end Date"
																placeholder="end Date" />
															<span class="help-block"></span>
															<form:errors path="endDate" cssClass="error" />
														</div>
													</div>
												</div>
												<div class="col-md-12">
													<div class="form-group">
														<label class="control-label col-md-4"><spring:message
																code="page.description" text="" /></label>
														<div class="col-md-6">
															<form:textarea cssClass="form-control"
																path="description" title="Enter Description"
																placeholder="Description" cols="70" rows="5" />
															<br> <span class="help-block"></span>
															<form:errors path="description" cssClass="error" />
														</div>
													</div>
												</div>
											</div>

										</div>
										<div class="row">
											<div class="col-md-8 col-md-offset-1">
												<div class="col-md-12">
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
					<c:if test="${!empty academicYearList}">
						<table id="sample_3"
							class="table table-bordered table-striped table-condensed">
							<thead class="bg-light-green">
								<tr>
									<th width="10%"><spring:message code="page.table.slno" text="" /></th>
									<th width="20%"><spring:message code="academic.year.code" text="" /></th>
									<th width="20%"><spring:message code="academic.year.StartDate" text="" /></th>
									<th width="20%"><spring:message code="academic.year.EndDate" text="" /></th>
									<th width="30%"><spring:message code="page.table.action" text="" /></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${academicYearList}" var="year"
									varStatus="status">
									<tr>
										<td>${status.count}</td>
										<td>${year.yearCode}</td>
										<td><fmt:formatDate pattern="yyyy-MM-dd" value="${year.startDate}" /></td>
										<td><fmt:formatDate pattern="yyyy-MM-dd" value="${year.endDate}" /></td>
										<td class="display-flex"><a
											href="${pageContext.request.contextPath}/academicYear/editAcademicYear/${year.id}"
											data-original-title="Edit"
											class="tooltips btn btn-success btn-xs"> <i
												class="fa fa-pencil"></i>
										</a> <c:if test="${paymentPlan.enabled}">
												<a
													href="${pageContext.request.contextPath}/academicYear/enableDisableAcademicYear/${year.id}/false"
													data-original-title="Click to Enable"
													class="tooltips btn btn-danger btn-xs"><spring:message code="page.table.enable" text="" /></a>
											</c:if> <c:if test="${!paymentPlan.enabled}">
												<a
													href="${pageContext.request.contextPath}/academicYear/enableDisableAcademicYear/${year.id}/true"
													data-original-title="Click to Disable"
													class="tooltips btn btn-success btn-xs"><spring:message code="page.table.disable" text="" /></a>
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