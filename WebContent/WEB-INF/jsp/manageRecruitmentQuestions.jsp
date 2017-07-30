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
			href="${pageContext.request.contextPath}/rq/manageRecruitmentQuestions"><spring:message code="recruitment.online.exam.questions" text="" />
				</a></li>
	</ul>
	<!-- END PAGE BREADCRUMB -->

	<!-- BEGIN PAGE CONTENT INNER -->
	<div class="row margin-top-10">
		<div class="col-md-12">
			<!-- BEGIN SAMPLE TABLE PORTLET-->
			<div class="portlet box lightblue">
				<div class="portlet-title">
					<div class="caption">
						<i class="fa fa-cogs"></i><spring:message code="recruitment.online.exam.questions" text="" />
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
								<form class="form-horizontal" method="post">
									<div class="form-body">
										<div class="row">
											<div class="col-md-5 col-md-offset-1">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message code="recruitment.level.name" text="" /></label>
													<div class="col-md-8">
														<select name="" id="" onchange="" class="form-control">
															<option value="">select</option>
															<option value="X">X</option>
															<option value="XI">XI</option>
															<option value="XII">XII</option>
														</select> <span class="help-block"></span>
													</div>
												</div>
											</div>
											<div class="col-md-5">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message code="recruitment.online.exam.subjects.name" text="" /></label>
													<div class="col-md-8">
														<select name="" id="" class="form-control">
															<option value="">select</option>
															<option value="Hindi">Hindi</option>
															<option value="English">English</option>
															<option value="Maths">Maths</option>
														</select> <span class="help-block"></span>
													</div>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-12">
												<table class="table table-bordered table-hover">
													<thead class="bg-light-green">
														<tr>
															<th><spring:message code="page.table.slno" text="" /></th>
															<th colspan="5"><spring:message code="recruitment.online.exam.title" text="" /></th>
														</tr>
													</thead>
													<tbody id="questions-statements">
														<tr>
															<td>1</td>
															<td colspan="5">
																<div class="form-group">
																	<label for="" class="col-md-12"><spring:message code="recruitment.online.exam.question" text="" /></label>
																	<div class="col-md-12">
																		<textarea name="" id="" cols="25" class="form-control"
																			rows="2"></textarea>
																	</div>
																</div>
																<div class="form-group">
																	<div class="col-md-12">
																		<div class="row">
																			<label for="" class="col-md-2"><spring:message code="recruitment.online.exam.question.ans.a" text="" /></label>
																			<div class="col-md-10">
																				<input type="text" name="" id=""
																					class="form-control" />
																			</div>
																		</div>
																	</div>
																</div>
																<div class="form-group">
																	<div class="col-md-12">
																		<div class="row">
																			<label for="" class="col-md-2"><spring:message code="recruitment.online.exam.question.ans.b" text="" /></label>
																			<div class="col-md-10">
																				<input type="text" name="" id=""
																					class="form-control" />
																			</div>
																		</div>
																	</div>
																</div>
																<div class="form-group">
																	<div class="col-md-12">
																		<div class="row">
																			<label for="" class="col-md-2"><spring:message code="recruitment.online.exam.question.ans.c" text="" /></label>
																			<div class="col-md-10">
																				<input type="text" name="" id=""
																					class="form-control" />
																			</div>
																		</div>
																	</div>
																</div>
																<div class="form-group">
																	<div class="col-md-12">
																		<div class="row">
																			<label for="" class="col-md-2"><spring:message code="recruitment.online.exam.question.ans.d" text="" /></label>
																			<div class="col-md-10">
																				<input type="text" name="" id=""
																					class="form-control" />
																			</div>
																		</div>
																	</div>
																</div>
															</td>
														</tr>
													</tbody>
													<tr>
														<td colspan="6" class="text-left bg-success"><a
															data-original-title="Add"
															class="btn btn-sm btn-danger tooltips"
															onclick="javaScript:addQuestionStatement(this,'questions-statements',2)"><spring:message code="page.add" text="" />
																<i class="fa fa-plus"></i>
														</a></td>
													</tr>
												</table>
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

								</form>
							</div>
						</div>
					</div>
					<c:if test="${!empty oLevelList}">
						<table id="sample_3"
							class="table table-bordered table-striped table-condensed flip-content">
							<thead class="flip-content">
								<tr>
									<th width="10%">Sl No.</th>
									<th width="30%">Level Name</th>
									<th width="30%">Description</th>
									<th width="30%">Action</th>
								</tr>
							</thead>

							<tbody>
								<c:forEach items="${oLevelList}" var="oeLevel"
									varStatus="status">
									<tr>
										<td>${status.count}</td>
										<td>${oeLevel.levelName}</td>
										<td>${oeLevel.description}</td>
										<td class="display-flex"><a
											href="${pageContext.request.contextPath}/oeLevel/editExamLevel/${oeLevel.id}"
											data-original-title="Edit"
											class="tooltips btn btn-success btn-xs"> <i
												class="fa fa-pencil"></i>
										</a> <c:if test="${country.enabled}">
												<a
													href="${pageContext.request.contextPath}/oeLevel/enableDisableLevel/${oeLevel.id}/false"
													data-original-title="Click to Enable"
													class="tooltips btn btn-danger btn-xs">ENABLE</a>
											</c:if> <c:if test="${!country.enabled}">
												<a
													href="${pageContext.request.contextPath}/oeLevel/enableDisableLevel/${oeLevel.id}/true"
													data-original-title="Click to Disable"
													class="tooltips btn btn-success btn-xs">DISABLE</a>
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