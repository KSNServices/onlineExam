<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<div class="page-content">

	<!-- BEGIN VIEW MODAL-->
	<div class="modal fade" id="view-modal" tabindex="-1" role="dialog"
		aria-labelledby="addressModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true"></button>
					<h4 class="modal-title">State Details</h4>
				</div>
				<div class="modal-body">

					<div class="form-group clearfix">
						<label for="" class="col-md-3 control-label">State Name</label>
						<div class="col-md-4">Uttar Pradesh</div>
					</div>
					<div class="form-group clearfix">
						<label for="" class="col-md-3 control-label">Country Name</label>
						<div class="col-md-4">India</div>
					</div>
					<div class="form-group clearfix">
						<label for="" class="col-md-3 control-label">Description</label>
						<div class="col-md-6">Some Description Goes here</div>
					</div>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn default" data-dismiss="modal">Close</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->


	<!-- BEGIN PAGE HEAD -->
	<div class="page-head">
		<!-- BEGIN PAGE TITLE -->
		<div class="page-title">
			<h1>State</h1>
		</div>
		<!-- END PAGE TITLE -->
	</div>
	<!-- END PAGE HEAD -->
	<!-- BEGIN PAGE BREADCRUMB -->
	<ul
		class="page-breadcrumb breadcrumb breadcrumb-arrow breadcrumb-arrow">
		<li><a href="index.html">Home</a> <i class="fa fa-circle"></i></li>
		<li><a href="state-master.html">State</a></li>
	</ul>
	<!-- END PAGE BREADCRUMB -->
	<!-- BEGIN PAGE CONTENT INNER -->
	<div class="row margin-top-10">
		<div class="col-md-12">
			<!-- BEGIN SAMPLE TABLE PORTLET-->
			<div class="portlet box blue">
				<div class="portlet-title">
					<div class="caption">
						<i class="fa fa-cogs"></i>State
					</div>
					<div class="actions">
						<a data-toggle="collapse" data-target="#addform"
							class="btn btn-circle red-sunglo btn-sm"> ADD <i
							class="fa fa-plus"></i>
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
											<div class="col-md-8 col-md-offset-2">
												<div class="col-md-12">
													<div class="form-group">
														<label class="control-label col-md-3">State Name</label>
														<div class="col-md-9">
															<input type="text" name="" class="form-control">
															<span class="help-block"></span>
														</div>
													</div>
												</div>
												<div class="col-md-12">
													<div class="form-group">
														<label class="control-label col-md-3">Country Name</label>
														<div class="col-md-9">
															<select name="country_name" id="country_name"
																class="form-control">
																<option value="">Select</option>
																<option value="">India</option>
																<option value="">Afghanistan</option>
															</select> <span class="help-block"></span>
														</div>
													</div>
												</div>
												<div class="col-md-12">
													<div class="form-group">
														<label class="control-label col-md-3">Description</label>
														<div class="col-md-9">
															<textarea type="text" name="" class="form-control"
																rows="5"></textarea>
															<span class="help-block"></span>
														</div>
													</div>
												</div>
											</div>

										</div>


									</div>
									<div class="form-actions">
										<div class="row">
											<div class="col-md-6 col-md-offset-3">
												<div class="row">
													<div class="col-md-offset-3 col-md-9">
														<button type="submit" class="btn green">Submit</button>
													</div>
												</div>
											</div>
											<div class="col-md-6"></div>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>

					<table
						class="table table-bordered table-striped table-condensed flip-content">
						<thead class="flip-content">
							<tr>
								<th width="20%">State Name</th>
								<th>Country Name</th>
								<th>Description</th>
								<th>Action</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>Uttar Pradesh</td>
								<td>India</td>
								<td>Some Lorem Description</td>
								<td><a href="javascript:;" data-target="#view-modal"
									data-toggle="modal" data-original-title="View"
									class="tooltips btn btn-success btn-xs"> <i
										class="fa fa-eye"></i>
								</a> <a href="state-master-edit.html" data-original-title="Edit"
									class="tooltips btn btn-success btn-xs"> <i
										class="fa fa-pencil"></i>
								</a> <a href="javascript:;" data-original-title="Click to Disable"
									class="tooltips btn btn-success btn-xs"> ENABLE </a></td>
							</tr>

							<tr>
								<td>Uttar Pradesh</td>
								<td>India</td>
								<td>Some Lorem Description</td>
								<td><a href="javascript:;" data-target="#view-modal"
									data-toggle="modal" data-original-title="View"
									class="tooltips btn btn-success btn-xs"> <i
										class="fa fa-eye"></i>
								</a> <a href="state-master-edit.html" data-original-title="Edit"
									class="tooltips btn btn-success btn-xs"> <i
										class="fa fa-pencil"></i>
								</a> <a href="javascript:;" data-original-title="Click to Enable"
									class="tooltips btn btn-danger btn-xs"> DISABLE </a></td>
							</tr>
					</table>
				</div>
			</div>
			<!-- END SAMPLE TABLE PORTLET-->

		</div>
	</div>
	<!-- END PAGE CONTENT INNER -->
</div>

<%@ include file="/WEB-INF/jsp/common/bottom.jsp"%>