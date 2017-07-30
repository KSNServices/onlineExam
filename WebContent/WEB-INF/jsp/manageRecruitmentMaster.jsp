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
		<li><a
			href="${pageContext.request.contextPath}/rm/manageRecruitment"><spring:message code="menu.RecruitmentMaster" text="" /></a></li>
	</ul>
	<!-- END PAGE BREADCRUMB -->

	<!-- BEGIN PAGE CONTENT INNER -->
	<div class="row margin-top-10">
		<div class="col-md-12">
			<!-- BEGIN SAMPLE TABLE PORTLET-->
			<div class="portlet box lightblue">
				<div class="portlet-title">
					<div class="caption">
						<i class="fa fa-cogs"></i><spring:message code="menu.RecruitmentMaster" text="" />
					</div>
					<div class="actions">
						<a data-toggle="collapse" data-target="#addform"
							class="btn btn-danger btn-sm"><spring:message code="page.add" text="" /><i class="fa fa-plus"></i>
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
								<form:form class="form-horizontal" commandName="recruitmentMaster"
									action="${pageContext.request.contextPath}/rm/saveRM"
									method="post">
									<form:hidden path="id" />
									<form:hidden path="adminId.id" />
									<form:hidden path="schoolId.id" />
									<div class="form-body">
										<div class="row">
											<div class="col-md-8 col-md-offset-1">
												<div class="col-md-12">
													<div class="form-group">
														<label class="control-label col-md-4"><spring:message code="recruitment.name" text="" /><span class="mandatory">* </span></label>
														<div class="col-md-6">
															<form:input cssClass="form-control" path="name"
																title="Enter the Name" maxlength="25" size="55"
																placeholder="Recruitment Name" />
															<span class="help-block"></span>
															<form:errors path="name" cssClass="error" />
														</div>
													</div>
												</div>
												<div class="col-md-12">
													<div class="form-group">
														<label class="control-label col-md-4"><spring:message code="academic.year" text="" /><span class="mandatory">* </span></label>
														<div class="col-md-6">
															<form:select path="academicYear.id" required="required"
																class="form-control">
																<form:option value="" label="--- Select Academic Year---" />
																<form:options title="Select Academic Year" items="${academicYearList}"
																	itemValue="id" itemLabel="yearCode" />
															</form:select>
															<span class="help-block"></span>
														</div>
													</div>
												</div>
												<div class="col-md-12">
													<div class="form-group">
														<label class="control-label col-md-4"><spring:message code="page.description" text="" /></label>
														<div class="col-md-6">
															<form:textarea cssClass="form-control" path="description"
																title="Enter Description" placeholder="Description"
																cols="70" rows="5" />
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
														<button type="submit" class="btn btn-sm btn-success"><spring:message code="page.submit" text="" /></button>
													</div>
												</div>
											</div>
										</div>
									</div>
								</form:form>
							</div>
						</div>
					</div>
					<c:if test="${!empty rmList}">
					<table id="sample_3"
						class="table table-bordered table-striped table-condensed">
						<thead class="bg-light-green">
							<tr>
								<th width="10%"><spring:message code="page.table.slno" text="" /></th>
								<th width="20%"><spring:message code="recruitment.name" text="" /></th>
								<th width="20%"><spring:message code="academic.year" text="" /></th>
								<th width="20%"><spring:message code="page.description" text="" /></th>
								<th width="30%"><spring:message code="page.table.action" text="" /></th>
							</tr>
						</thead>						
							<tbody>
								<c:forEach items="${rmList}" var="rm"
									varStatus="status">
									<tr>
										<td>${status.count}</td>
										<td>${rm.name}</td>
										<td>${rm.academicYear.yearCode}</td>
										<td>${rm.description}</td>										
										<td class="display-flex">
										<a
											href="${pageContext.request.contextPath}/rm/editRM/${rm.id}"
											data-original-title="Edit"
											class="tooltips btn btn-success btn-xs"> <i
												class="fa fa-pencil"></i>
										</a> 
										<c:if test="${rm.enabled}">
											<a href="${pageContext.request.contextPath}/rm/enableDisableRM/${rm.id}/false" data-original-title="Click to Enable"
												class="tooltips btn btn-danger btn-xs"><spring:message code="page.table.enable" text="" /></a>
										</c:if>
										<c:if test="${!rm.enabled}">
											<a href="${pageContext.request.contextPath}/rm/enableDisableRM/${rm.id}/true" data-original-title="Click to Disable"
												class="tooltips btn btn-success btn-xs"><spring:message code="page.table.disable" text="" /></a>
										</c:if>
										</td>
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