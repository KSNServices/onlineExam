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
		<li><a href="country-master.html"><spring:message code="menu.city" text="" /></a></li>
	</ul>
	<!-- END PAGE BREADCRUMB -->

	<!-- BEGIN PAGE CONTENT INNER -->
	<div class="row margin-top-10">
		<div class="col-md-12">
			<!-- BEGIN SAMPLE TABLE PORTLET-->
			<div class="portlet box lightblue">
				<div class="portlet-title">
					<div class="caption">
						<i class="fa fa-cogs"></i><spring:message code="menu.city" text="" />
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
								<form:form class="form-horizontal" commandName="city"
									action="${pageContext.request.contextPath}/global/saveCity"
									method="post">
									<form:hidden path="id" />
									<form:hidden path="adminId.id" />
									<form:hidden path="schoolId.id" />
									<div class="form-body">
										<div class="row">
											<div class="col-md-8 col-md-offset-1">
												<div class="col-md-12">
													<div class="form-group">
													
														<label class="control-label col-md-4"><spring:message code="country.CountryName" text="" /><span class="mandatory">* </span></label>
														<div class="col-md-6">
															<form:select path="state.country.id" required="required"
																class="form-control"  onchange="javascript:changevalue();">
																<form:option value="" label="--- Select Country---"/>
																<form:options title="Select Country" items="${countryList}"
																	itemValue="id" itemLabel="countryName"/>
															</form:select>
															<span class="help-block"></span>
														</div>
													</div>
												</div>
												<div class="col-md-12">
													<div class="form-group">
														<label class="control-label col-md-4"><spring:message code="state.name" text="" /><span class="mandatory">* </span></label>
														<div class="col-md-6">
															<form:select path="state.id" required="required"
																class="form-control">
																<form:option value="" label="--- Select State---" />
																<form:options title="Select state" items="${stateList}"
																	itemValue="id" itemLabel="stateName" />
															</form:select>
															
															<span class="help-block"></span>
														</div>
													</div>
												</div>
												<div class="col-md-12">
													<div class="form-group">
														<label class="control-label col-md-4"><spring:message code="city.name" text="" /><span class="mandatory">* </span></label>
														<div class="col-md-6">
															<form:input cssClass="form-control" path="cityName"
																title="Enter the City Name" maxlength="25" size="55"
																placeholder="City Name" />
															<span class="help-block"></span>
															<form:errors path="cityName" cssClass="error" />
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
					<c:if test="${!empty cityList}">
					<table id="sample_3"
						class="table table-bordered table-striped table-condensed">
						<thead class="bg-light-green">
							<tr>
								<th width="10%"><spring:message code="page.table.slno" text="" /></th>
								<th width="20%"><spring:message code="city.name" text="" /></th>
								<th width="20%"><spring:message code="state.name" text="" /></th>
								<th width="20%"><spring:message code="page.description" text="" /></th>
								<th width="30%"><spring:message code="page.table.action" text="" /></th>
							</tr>
						</thead>
						
							<tbody>
								<c:forEach items="${cityList}" var="city"
									varStatus="status">
									<tr>
										<td>${status.count}</td>
										<td>${city.cityName}</td>
										<td>${city.state.stateName}</td>
										<td>${city.description}</td>										
										<td class="display-flex">
										<a
											href="${pageContext.request.contextPath}/global/editCity/${city.id}"
											data-original-title="Edit"
											class="tooltips btn btn-success btn-xs"> <i
												class="fa fa-pencil"></i>
										</a> 
										<c:if test="${city.enabled}">
											<a href="${pageContext.request.contextPath}/global/enableDisableCity/${city.id}/false" data-original-title="Click to Enable"
												class="tooltips btn btn-danger btn-xs"><spring:message code="page.table.enable" text="" /></a>
										</c:if>
										<c:if test="${!city.enabled}">
											<a href="${pageContext.request.contextPath}/global/enableDisableCity/${city.id}/true" data-original-title="Click to Disable"
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
<script type="text/javascript">
function changevalue( list)
{
	
   var abc = list;
	   //document.getElementById("countryName");
	alert(list);
}
</script>