<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/app.js"></script>

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
			href="${pageContext.request.contextPath}/feeDetail/studentFeeInformation"><spring:message
					code="Fee.StudentFeeDetails" text="" /></a></li>
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
						<spring:message code="user.manage.StudentFeeDetails" text="" />
					</div>
					<a href="javascript:printDiv('printableArea');"><i class="fa fa-print"></i> Print</a>
					<div class="actions">
						<a data-toggle="collapse" data-target="#addform"
							class="btn btn-danger btn-sm"> <spring:message
								code="page.add" text="" /> <i class="fa fa-plus"></i>
						</a>
					</div>
				</div>
				<!-- Start Message panel -->
				<c:if test="${message!=null}">
					<div class="alert alert-info fade in">
						<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
						<strong class="alert_font">${message}</strong>
					</div>
				</c:if>								
				<c:if test="${error!=null}">
					<div class="alert alert-info fade in">
						<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
						<strong  style="color: red" >${error}</strong>
					</div>
				</c:if>
				<!-- End Message panel -->
				
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
								<form:form class="form-horizontal" name="studentFeeForm"
									commandName="studentFeeDetail"
									action="${pageContext.request.contextPath}/feeDetail/saveStudentFeeInformation"
									method="post" enctype="multipart/form-data">
									<form:hidden path="id" />
									<form:hidden path="adminId.id" />
									<form:hidden path="schoolId.id" />
									<form:hidden path="studentId.id" /> 
									<form:hidden path="installmentNumber" /> 
									<form:hidden path="installmentMonth" /> 
										<form:hidden path="installmentAmount" /> 
											<form:hidden path="startSession" /> 
									${studentName} 
									<div class="form-body">
										<div class="row" style="color: red" id="errors"></div>
										<div class="row">
											<div class="col-md-5  col-md-offset-1">
												<div class="form-group">
													<label class="control-label col-md-4"> <spring:message
															code="StudentFeeDetail.student_id" text="" /><span
														class="astrek" style="color: red"> * </span></label>
													<div class="col-md-8">
														<form:input id="studentId" path="sequenceStudentId"
															class="form-control" type="text" required="required"
															onchange="javaScript:getFormFillout();" />
														<span class="help-block"></span>
													</div>
												</div>
											</div>
											<div class="col-md-5">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message
															code="StudentFeeDetail.student_name" text="" /><span
														class="astrek" style="color: red"> * </span></label>
													<div class="col-md-8">
														<form:input id="studentName" path="studentId.firstName"
															class="form-control" type="text" readonly="true" />
														<span class="help-block"></span>
													</div>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-5 col-md-offset-1">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message
															code="StudentFeeDetail.class" text="" /></label>
													<div class="col-md-8">
														<form:input id="className" path="studentId.className"
															class="form-control" type="text" readonly="true" />
														<span class="help-block"></span>
													</div>
												</div>
											</div>
											<div class="col-md-5">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message
															code="StudentFeeDetail.section" text="" /><span
														class="astrek" style="color: red"> * </span></label>
													<div class="col-md-8">
														<form:input id="classSection"
															path="studentId.classSection" class="form-control"
															type="text" readonly="true" />
														<span class="help-block"></span>
													</div>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-5 col-md-offset-1">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message
															code="StudentFeeDetail.total_fee" text="" /><span
														class="astrek" style="color: red"> * </span></label>
													<div class="col-md-8">
														<form:input id="totalFee" path="totalFee" readonly="true"
															class="form-control" type="text" required="required" />
														<span class="help-block"></span>
													</div>
												</div>
											</div>
											<div class="col-md-5">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message
															code="StudentFeeDetail.concession" text="" /><span
														class="astrek" style="color: red"> * </span></label>
													<div class="col-md-8">
														<form:input id="concession" path="concession" onchange="javaScript:getTypeConcession();"
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
															code="StudentFeeDetail.typeConcession" text="" /> </label>
													<div class="col-md-8">
														<form:select path="typeConcession" id="typeConcession"
															required="required"
															onchange="javaScript:getFormCalculation();"
															class="form-control">
															<form:option value="0"
																label="--------------- Select------------------" />
															<form:option value="1" label="Monthly" />
															<form:option value="2" label="Quarterly" />
															<form:option value="3" label="Halfyearly" />
															<form:option value="4" label="Annually" />
														</form:select>
													</div>
												</div>

											</div>
											<div class="col-md-5">

												<div class="form-group">
													<label class="control-label col-md-4"><spring:message
															code="StudentFeeDetail.reasonConcession" text="" /><span
														class="astrek" style="color: red"> * </span></label>
													<div class="col-md-8">
														<form:input id="reasonConcession" path="reasonConcession"
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
															code="StudentFeeDetail.paid_by_student" text="" /></label>
													<div class="col-md-8">
														<form:input id="paidByStudent" path="paidByStudent"
															readonly="true" class="form-control" type="text" />
														<span class="help-block"></span>
													</div>
												</div>
											</div>
											<div class="col-md-5">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message
															code="StudentFeeDetail.remaining_fee" text="" /> </label>
													<div class="col-md-8">
														<form:input id="remainingFee" path="remainingFee"
															readonly="true" class="form-control" type="text" />
														<span class="help-block"></span>
													</div>
												</div>
											</div>
										</div>

										<div class="row">
											<div class="col-md-5 col-md-offset-1">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message
															code="StudentFeeDetail.PaidFee" text="" /><span
														class="astrek" style="color: red"> * </span></label>
													<div class="col-md-8">
														<form:input id="PaidFee" path="paidFee"
															class="form-control" readonly="true" type="text"
															required="required" />
														<span class="help-block"></span>
													</div>
												</div>
											</div>
											<div class="col-md-5">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message
															code="StudentFeeDetail.duration" text="" /> </label>
													<div class="col-md-8">
														<form:select path="duration" id="duration"
															required="required" onchange="javaScript:getFormCycle();"
															class="form-control">
															<form:option value="0"
																label="--------------- Select------------------" />
															<form:option value="12" label="Monthly" />
															<form:option value="4" label="Quarterly" />
															<form:option value="2" label="Halfyearly" />
															<form:option value="1" label="Annually" />
														</form:select>

													</div>
												</div>
											</div>
										</div>





										<div class="row margin-top-10">
											<div class="col-md-5 col-md-offset-1">
												<div class="row">
													<div class="col-md-offset-4 col-md-9">
														<button type="submit" onclick="javaScript:getFormCycle();"
															class="btn btn-sm btn-success">
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
					
					<c:if test="${!empty listStudentEditFeeDetails}">
						<div id="printableArea">
							<table id="sample_3"
								
									class="table table-bordered table-striped table-condensed ">
						<thead class="bg-light-green">
									<tr>
										<th><spring:message code="page.table.slno" text="" /></th>

										<th><spring:message code="studentFeeStudent.StudentId"
												text="" /></th>
										<th><spring:message code="studentFeeStudent.TotalFee"
												text="" /></th>

										<th><spring:message code="studentFeeStudent.Concession"
												text="" /></th>
										<th><spring:message
												code="studentFeeStudent.StudentPayFee" text="" /></th>
										<th><spring:message code="studentFeeStudent.RemainingFee"
												text="" /></th>
										<th><spring:message code="studentFeeStudent.PaymentCycle"
												text="" /></th>
										<th><spring:message code="page.table.action" text="" /></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${listStudentEditFeeDetails}"
										var="studentFeeDetail" varStatus="status">
										<tr>
											<td>${status.count}</td>

											<td>${studentFeeDetail.sequenceStudentId}</td>
											<td>${studentFeeDetail.totalFee}</td>
											<td>${studentFeeDetail.concession}</td>
											<td>${studentFeeDetail.paidByStudent}</td>
											<td>${studentFeeDetail.remainingFee}</td>
											<td>${studentFeeDetail.duration}</td>
											<td class="display-flex"><a href="javascript:;"
									data-target="#view-modal" data-toggle="model"
							data-original-title="View"
									class="tooltips btn btn-success btn-xs"> <i
										class="fa fa-eye"></i>
								</a> <a
												href="${pageContext.request.contextPath}/student/editRegistration/${studentFeeDetail.id}"
												data-original-title="Edit"
												class="tooltips btn btn-success btn-xs"> <i
													class="fa fa-pencil"></i>
											</a> <c:if test="${admissionFormModel.enabled}">
													<a
														href="${pageContext.request.contextPath}/student/enableDisableRegistration/${studentFeeDetail.id}/false"
														data-original-title="Click to Disable"
														class="tooltips btn btn-danger btn-xs"><i
														class="fa fa-toggle-off" aria-hidden="true"></i> <spring:message
															code="page.table.disable" text="" /></a>
												</c:if> <c:if test="${!admissionFormModel.enabled}">
													<a
														href="${pageContext.request.contextPath}/student/enableDisableRegistration/${studentFeeDetail.id}/true"
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
						</div>
					</c:if>
				</div>
			</div>
			<!-- END SAMPLE TABLE PORTLET-->

		</div>
	</div>
	<!-- END PAGE CONTENT INNER -->
</div>

<%@ include file="/WEB-INF/jsp/common/bottom.jsp"%>


<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>

<script type="text/javascript">
	function getFormFillout() {
		var URL = "/OnlineExam/feeDetail/getStudentFeesData/";
		var id = document.getElementById('studentId').value;
		//alert(id+"@"+studentId);
		URL = URL + id;
		window.location = URL;
		$('#studentId').val(id);
	}

	
	function getTypeConcession() {
		//var URL = "/OnlineExam/feeDetail/getStudentFeesData/";
		//var id = "0";
		//alert(id+"@"+studentId);
		//URL = URL + id;
		//window.location = URL;
		$('#typeConcession').val("0");
	}
	function getFormCycle() {
		var duration = document.getElementById('duration').value;
		var studentId = document.getElementById('studentId').value
		//alert(duration);
		if (duration == 0) {
			if(studentId == null || studentId == "" )
				{
				document.getElementById('errors').innerHTML = "*Please enter Fee Payment Cycle*and  *Please enter StudentId*";
			
				}
			else{
			document.getElementById('errors').innerHTML = "*Please enter Fee Payment Cycle*";
			}
			return false;
		} else {
			if(studentId == null || studentId == "" )
			{
			document.getElementById('errors').innerHTML = "*Please enter StudentId*";
		
			}
		else{
			document.getElementById('errors').innerHTML = "";
		}
		}
	}

	function getFormCalculation() {
		var URL = "/OnlineExam/feeDetail/getStudentFeeCalculation/";
		var studentId = document.getElementById('studentId').value;
		var typeConcession = document.getElementById('typeConcession').value;
		var concession = document.getElementById('concession').value;
		if (concession == null || concession == "") {
			//alert("Please enter Concession");
			document.getElementById('errors').innerHTML = "*Please enter concession*";
			$('#typeConcession').val("0");
			return false;

		} else if (studentId == null || studentId == "") {
			document.getElementById('errors').innerHTML = "*Please enter studentId*";

			return false;

		} else if (typeConcession == null || typeConcession == "") {
			document.getElementById('errors').innerHTML = "*Please enter Type of Concession*";
			return false;

		}
		if ((studentId != null || studentId != "")
				&& (typeConcession != null || typeConcession != "")
				&& (concession != null || concession != "")) {
			id = studentId + "@" + typeConcession + "@" + concession;
			//alert(id);
			URL = URL + id;
			window.location = URL;
		}

		var remainingFee = document.getElementById('remainingFee').value;

		//alert("abc"+remainingFee);

		$('#studentId').val(studentId);
	}
</script>



