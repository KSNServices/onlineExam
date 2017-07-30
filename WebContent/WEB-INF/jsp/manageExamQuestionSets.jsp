<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

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


	<!-- BEGIN PAGE BREADCRUMB -->
	<ul
		class="page-breadcrumb breadcrumb breadcrumb-arrow breadcrumb-arrow">
		<li><a href="index.php"><spring:message code="page.home" text="" /></a></li>
		<li><a href="create-question-paper-set.php"><spring:message code="recruitment.online.exam.question.set" text="" /></a></li>
	</ul>
	<!-- END PAGE BREADCRUMB -->
	<!-- BEGIN PAGE CONTENT INNER -->
	<div class="row margin-top-10">
		<div class="col-md-12">
			<!-- BEGIN SAMPLE TABLE PORTLET-->
			<div class="portlet box lightblue">
				<div class="portlet-title">
					<div class="caption">
						<i class="fa fa-cogs"></i><spring:message code="recruitment.online.exam.question.set" text="" />
					</div>
					<div class="actions">
						<a data-toggle="collapse" data-target="#addform"
							class="btn btn-danger btn-sm"> <spring:message code="page.add" text="" /> <i class="fa fa-plus"></i>
						</a>
					</div>
				</div>
				<div class="portlet-body flip-scroll">
					<div id="addform" class="collapse">
						<div class="portlet box">
							<div class="portlet-body form">
								<form class="form-horizontal" method="post">
									<div class="form-body">
										<div class="row">
											<div class="col-md-5 col-md-offset-1">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message code="recruitment.level.name" text="" /></label>
													<div class="col-md-8">
														<select name="" id=""
															onchange="Main.addQuestionPaperSet(this,'subjects-list')"
															class="form-control">
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
													<label class="control-label col-md-4"><spring:message code="recruitment.online.exam.question.noofquestions" text="" /></label>
													<div class="col-md-8">
														<input type="number" class="form-control"> <span
															class="help-block"></span>
													</div>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-6 col-md-offset-3" id="subjects-list">

											</div>
										</div>
										<div class="row margin-top-10">
											<div class="col-md-5 col-md-offset-1">
												<div class="row">
													<div class="col-md-offset-5 col-md-9">
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

					<table id="sample_3"
						class="table table-bordered table-striped table-condensed ">
						<thead class="bg-light-green">
							<tr>
								<th><spring:message code="page.table.slno" text="" /></th>
								<th><spring:message code="recruitment.level.name" text="" /></th>
								<th><spring:message code="recruitment.online.exam.question.noofquestions" text="" /></th>
								<th><spring:message code="page.table.action" text="" /></th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>1</td>
								<td>Xth</td>
								<td>50</td>

								<td class="display-flex"><a href="javascript:;"
									data-target="#view-modal" data-toggle="modal"
									data-original-title="View"
									class="tooltips btn btn-success btn-xs"> <i
										class="fa fa-eye"></i>
								</a> <a href="create-question-paper-set-edit.php"
									data-original-title="Edit"
									class="tooltips btn btn-success btn-xs"> <i
										class="fa fa-pencil"></i>
								</a> <a href="javascript:;" data-original-title="Click to Disable"
									class="tooltips btn btn-success btn-xs"> <i
										class="fa fa-toggle-on" aria-hidden="true"></i> <spring:message code="page.table.enable" text="" />
								</a> <a href="javascript:;" data-original-title="Click to Delete"
									class="tooltips btn btn-danger btn-xs"> <i
										class="fa fa-trash" aria-hidden="true"></i> <spring:message code="page.table.delete" text="" />
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
<!-- END CONTAINER -->

<%@ include file="/WEB-INF/jsp/common/bottom.jsp"%>