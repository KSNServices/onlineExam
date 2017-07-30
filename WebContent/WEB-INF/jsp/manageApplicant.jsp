<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/app.js"></script>

<div class="page-content">
	<!-- BEGIN VIEW MODAL-->
	<div class="modal fade" id="view-modal" tabindex="-1" role="dialog"
		aria-labelledby="addressModalLabel" aria-hidden="true">

		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true"></button>
						
					<h4 class="modal-title"><spring:message code="applicant.detail" text="" /></h4>
				</div>
				<div class="modal-body">
					<div id="printableArea"> 
						<div class="form-group clearfix">
							<label for="" class="col-md-3 control-label"><spring:message code="applicant.name" text="" /></label>
							<div class="col-md-4">shashank</div>
						</div>
						<div class="form-group clearfix">
							<label for="" class="col-md-3 control-label"><spring:message code="applicant.qualification.name" text="" /></label>
							<div class="col-md-4">Xth</div>
						</div>
						<div class="form-group clearfix">
							<label for="" class="col-md-3 control-label"><spring:message code="applicant.age" text="" /></label>
							<div class="col-md-4">27</div>
						</div>
						<div class="form-group clearfix">
							<label for="" class="col-md-3 control-label"><spring:message code="menu.city" text="" /></label>
							<div class="col-md-4">Mathura</div>
						</div>
						<div class="form-group clearfix">
							<label for="" class="col-md-3 control-label"><spring:message code="applicant.mobile.number" text="" /></label>
							<div class="col-md-4">9829389918</div>
						</div>
						<div class="form-group clearfix">
							<label for="" class="col-md-3 control-label"><spring:message code="applicant.email" text="" /></label>
							<div class="col-md-4">ramesh@gmail.com</div>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-sm btn-default"
						data-dismiss="modal"><spring:message code="page.close" text="" /></button>
							<a href="javascript:printDiv('printableArea');"><i class="fa fa-print"></i> Print</a>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->


	<!-- BEGIN PAGE BREADCRUMB -->
	<ul
		class="page-breadcrumb breadcrumb breadcrumb-arrow breadcrumb-arrow">
		<li><a href="index.html"><spring:message code="page.home" text="" /></a></li>
		<li><a href="applicant-management.php"><spring:message code="applicant.management" text="" /></a></li>
	</ul>
	<!-- END PAGE BREADCRUMB -->
	<!-- BEGIN PAGE CONTENT INNER -->
	<div class="row margin-top-10">
		<div class="col-md-12">
			<!-- BEGIN SAMPLE TABLE PORTLET-->
			<div class="portlet box lightblue">
				<div class="portlet-title">
					<div class="caption">
						<i class="fa fa-cogs"></i><spring:message code="applicant.management" text="" />
					</div>
				</div>
				<div class="portlet-body flip-scroll">

					<div class="portlet box">
						<div class="portlet-body form">
							<div class="form-body">
								<div class="row">
									<div class="col-md-5 col-md-offset-1">
										<div class="form-group">
											<label class="control-label col-md-4"><spring:message code="applicant.name" text="" /></label>
											<div class="col-md-8">
												<input type="text" class="form-control"> <span
													class="help-block"></span>
											</div>
										</div>
									</div>
									<div class="col-md-5">
										<div class="form-group">
											<label class="control-label col-md-4"><spring:message code="applicant.qualification.name" text="" /></label>
											<div class="col-md-8">
												<input type="text" class="form-control"> <span
													class="help-block"></span>
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-5 col-md-offset-1">
										<div class="form-group">
											<label class="control-label col-md-4"><spring:message code="applicant.age" text="" /></label>
											<div class="col-md-8">
												<input type="text" class="form-control"> <span
													class="help-block"></span>
											</div>
										</div>
									</div>
									<div class="col-md-5">
										<div class="form-group">
											<label class="control-label col-md-4"><spring:message code="menu.city" text="" /></label>
											<div class="col-md-8">
												<input type="text" class="form-control"> <span
													class="help-block"></span>
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-5 col-md-offset-1">
										<div class="form-group">
											<label class="control-label col-md-4"><spring:message code="applicant.mobile.number" text="" /></label>
											<div class="col-md-8">
												<input type="number" class="form-control"> <span
													class="help-block"></span>
											</div>
										</div>
									</div>
									<div class="col-md-5">
										<div class="form-group">
											<label class="control-label col-md-4"><spring:message code="applicant.email" text="" /></label>
											<div class="col-md-8">
												<input type="text" class="form-control"> <span
													class="help-block"></span>
											</div>
										</div>
									</div>
								</div>

								<div class="row margin-top-10">
									<div class="col-md-5 col-md-offset-1">
										<div class="row">
											<div class="col-md-offset-4 col-md-9">
												<button type="submit" class="btn btn-sm btn-success"><spring:message
																code="page.search" text="" /></button>
											</div>
										</div>
									</div>

								</div>
							</div>
						</div>
					</div>

					<table id="sample_3"
						class="table table-bordered table-striped table-condensed ">
						<thead class="bg-light-green">
							<tr>
								<th><spring:message code="page.table.slno" text="" /></th>
								<th><spring:message code="applicant.name" text="" /></th>
								<th><spring:message code="applicant.age" text="" /></th>
								<th><spring:message code="menu.city" text="" /></th>
								<th><spring:message code="applicant.mobile.number" text="" /></th>
								<th><spring:message code="applicant.email" text="" /></th>
								<th><spring:message code="page.table.action" text="" /></th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>1</td>
								<td>Ramesh</td>
								<td>26</td>
								<td>Mathura</td>
								<td>9839282918</td>
								<td>ramesh@gmail.com</td>

								<td class="display-flex"><a href="javascript:;"
									data-target="#view-modal" data-toggle="modal"
									data-original-title="View"
									class="tooltips btn btn-success btn-xs"> <i
										class="fa fa-eye"></i>
								</a></td>
							</tr>							
						</tbody>
					</table>
				</div>
			</div>
			<!-- END SAMPLE TABLE PORTLET-->

		</div>
	</div>
	<!-- END PAGE CONTENT INNER -->
</div>

<%@ include file="/WEB-INF/jsp/common/bottom.jsp"%>