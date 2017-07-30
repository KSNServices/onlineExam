<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
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
		<li><a href="country-master.html"><spring:message code="payment.plan" text="" /></a></li>
	</ul>
	<!-- END PAGE BREADCRUMB -->

	<!-- BEGIN PAGE CONTENT INNER -->
	<div class="row margin-top-10">
		<div class="col-md-12">
			<!-- BEGIN SAMPLE TABLE PORTLET-->
			<div class="portlet box lightblue">
				<div class="portlet-title">
					<div class="caption">
						<i class="fa fa-cogs"></i><spring:message code="payment.plan" text="" />
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
								<form:form class="form-horizontal" commandName="paymentPlan"
									action="${pageContext.request.contextPath}/paymentPlan/savePaymentPlan"
									method="post">
									<form:hidden path="id" />
									<form:hidden path="adminId.id" />
									<form:hidden path="schoolId.id" />
									<div class="form-body">
										<div class="row">
											<div class="col-md-8 col-md-offset-1">

												<div class="col-md-12">
													<div class="form-group">
														<label class="control-label col-md-4"><spring:message code="payment.plan.name" text="" /><span class="mandatory">* </span>
														</label>
														<div class="col-md-6">
															<form:input cssClass="form-control"
																path="paymentPlanName"
																title="Enter the Payment Plan Name" maxlength="25"
																size="55" placeholder="Payment Plan Name" />
															<span class="help-block"></span>
															<form:errors path="paymentPlanName" cssClass="error" />
														</div>
													</div>
												</div>
												<div class="col-md-12">
													<div class="form-group">
														<label class="control-label col-md-4"><spring:message code="payment.plan.mode" text="" /><span class="mandatory">* </span>
														</label>
														<div class="col-md-6">
															<form:select path="paymentPlanMode" required="required"
																class="form-control">
																<form:option value="" label="--- Select Plan Mode---" />
																<form:options title="Select Plan Mode"
																	items="${paymentPlanModeList}" itemValue="name"
																	itemLabel="name" />
															</form:select>
															<span class="help-block"></span>
														</div>
													</div>
												</div>
												<div class="col-md-12">
													<div class="form-group">
														<label class="control-label col-md-4"><spring:message code="payment.plan.validity" text="" /></label>
														<div class="col-md-6">
															<form:input cssClass="form-control" path="validity"
																title="Enter the validity" maxlength="25" size="55"
																placeholder="Validity" />
															<span class="help-block"></span>
															<form:errors path="validity" cssClass="error" />
														</div>
													</div>
												</div>
												<div class="col-md-12">
													<div class="form-group">
														<label class="control-label col-md-4"><spring:message code="page.description" text="" /></label>
														<div class="col-md-6">
															<form:textarea cssClass="form-control" path="planDescription"
																title="Enter Description" placeholder="Description"
																cols="70" rows="5" />
															<br> <span class="help-block"></span>
															<form:errors path="planDescription" cssClass="error" />
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
					<c:if test="${!empty paymentPlanList}">
						<table id="sample_3"
							class="table table-bordered table-striped table-condensed">
							<thead class="bg-light-green">
								<tr>
									<th width="10%"><spring:message code="page.table.slno" text="" /></th>
									<th width="20%"><spring:message code="payment.plan.name" text="" /></th>
									<th width="20%"><spring:message code="payment.plan.mode" text="" /></th>
									<th width="20%"><spring:message code="payment.plan.validity" text="" /></th>
									<th width="30%"><spring:message code="page.table.action" text="" /></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${paymentPlanList}" var="paymentPlan"
									varStatus="status">
									<tr>
										<td>${status.count}</td>
										<td>${paymentPlan.paymentPlanName}</td>
										<td>${paymentPlan.paymentPlanMode}</td>
										<td>${paymentPlan.validity}</td>
										<td class="display-flex"><a
											href="${pageContext.request.contextPath}/paymentPlan/editState/${paymentPlan.id}"
											data-original-title="Edit"
											class="tooltips btn btn-success btn-xs"> <i
												class="fa fa-pencil"></i>
										</a> <c:if test="${paymentPlan.enabled}">
												<a
													href="${pageContext.request.contextPath}/paymentPlan/enableDisablePaymentPlan/${paymentPlan.id}/false"
													data-original-title="Click to Enable"
													class="tooltips btn btn-danger btn-xs"><spring:message code="page.table.enable" text="" />
													PLAN</a>
											</c:if> <c:if test="${!paymentPlan.enabled}">
												<a
													href="${pageContext.request.contextPath}/paymentPlan/enableDisablePaymentPlan/${paymentPlan.id}/true"
													data-original-title="Click to Disable"
													class="tooltips btn btn-success btn-xs"><spring:message code="page.table.disable" text="" />
													PLAN</a>
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