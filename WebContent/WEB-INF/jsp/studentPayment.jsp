<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/app.js"></script>


<div class="page-content">

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
							<!-- <a href="javascript:printDiv('printableArea');"><i class="fa fa-print"></i> Print</a> -->
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
			<h1>KSN service</h1>
		</div> 
		<!-- END PAGE TITLE -->
	</div>
	<!-- END PAGE HEAD -->
	<!-- BEGIN PAGE BREADCRUMB -->
	<ul
		class="page-breadcrumb breadcrumb breadcrumb-arrow breadcrumb-arrow">
		<li><a href="index.html"><spring:message code="page.home"
					text="" /></a></li>
		<li><a
			href="${pageContext.request.contextPath}/paymentDetail/studentPaymentInformation"><spring:message
					code="Payment.StudentPaymentDetails" text="" /></a></li>
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
						<spring:message code="Payment.StudentPaymentDetails" text="" />
					</div>
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
									action="${pageContext.request.contextPath}/paymentDetail/saveStudentPaymentInformation"
									method="post" enctype="multipart/form-data">
									<form:hidden path="id" />
									<form:hidden path="adminId.id" />
									<form:hidden path="schoolId.id" />
								    <form:hidden path="studentId.id" /> 
								    <form:hidden path="remainingFee" />
								    <form:hidden path="paidFee" />
								     <form:hidden path="totalFee" />
								      <form:hidden path="concession" />
								       <form:hidden path="typeConcession" />
								        <form:hidden path="reasonConcession" />
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
															onchange="javaScript:getFormFillout();"/>
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
															class="form-control" type="text"  readonly="true"/>
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
														<form:input id="classSection" path="studentId.classSection"
															class="form-control" type="text"  readonly="true" />
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
														<form:input id="paidByStudent" path="paidByStudent" readonly="true"
															class="form-control" type="text" />
														<span class="help-block"></span>
													</div>
												</div>
											</div>
											<div class="col-md-5">
											<div class="form-group">
													<label class="control-label col-md-4"><spring:message
															code="StudentFeeDetail.durationNumber" text="" /></label>
													<div class="col-md-8">
														<form:input  path="duration" id="duration"
															class="form-control" type="number" readonly="true"  required="required" />
														<span class="help-block"></span>
													</div>
												</div>
											
											
											</div>
										</div>
										
											<div class="row">
											<div class="col-md-5 col-md-offset-1">
												
													<div class="form-group">
													<label class="control-label col-md-4"><spring:message
															code="StudentFeeDetail.startSession" text="" /> </label>
													<div class="col-md-8">
														<form:select path="startSession" required="required" onchange="javaScript:getFormCalculation();" 
															class="form-control">
															<form:option value="0" 
																label="--------------- Select------------------" />
															<form:option value="1" label="Jan" />
															<form:option value="2" label="Feb" />
															<form:option value="3" label="Mar" />
															<form:option value="4" label="Apr" />
															<form:option value="5" label="May" />
															<form:option value="6" label="Jun" />
															<form:option value="7" label="July" />
															<form:option value="8" label="Aug" />
															<form:option value="9" label="Sept" />
															<form:option value="10" label="Oct" />
															<form:option value="11" label="Nov" />
															<form:option value="12" label="Dec" />
														</form:select>

													</div>
												</div>
												
												
												
												
											</div>
											<div class="col-md-5">
											
											<div class="form-group">
													<label class="control-label col-md-4"><spring:message
															code="StudentFeeDetail.intallment_Number" text="" /><span
														class="astrek" style="color: red"> * </span></label>
													<div class="col-md-8">
														<form:input id="installmentNumber" path="installmentNumber" class="form-control" readonly="true"
															type="number" required="required" onchange="javaScript:getFormCalculation();" />
														<span class="help-block"></span>
													</div>
												</div>
											
											
											
											
											</div>
										</div>
										
										
										
										
										<div class="row">
											<div class="col-md-5 col-md-offset-1">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message
															code="StudentFeeDetail.installmentMonth" text="" /><span
														class="astrek" style="color: red"> * </span></label>
													<div class="col-md-8">
														<form:input id="installmentMonth" path="installmentMonth" class="form-control" readonly="true"
															type="text" required="required" />
														<span class="help-block"></span>
													</div>
												</div>
											</div>
											<div class="col-md-5">
											
											<div class="form-group">
													<label class="control-label col-md-4"><spring:message
															code="StudentFeeDetail.installmentAmount" text="" /><span
														class="astrek" style="color: red"> * </span></label>
													<div class="col-md-8">
														<form:input id="installmentAmount" path="installmentAmount" class="form-control" readonly="true"
															type="text" required="required" onchange="javaScript:getFormCalculation();" />
														<span class="help-block"></span>
													</div>
												</div>
											
											
											
											
											</div>
										</div>

										





										<div class="row margin-top-10">
											<div class="col-md-5 col-md-offset-1">
												<div class="row">
													<div class="col-md-offset-4 col-md-9">
														<button type="submit" onclick="javaScript:getFormCalculationOnClick();" class="btn btn-sm btn-success">
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
						<c:if test="${!empty listStudentEditFeeDetail}">
					
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
										<th><spring:message code="StudentFeeDetail.intallment_Number"
												text="" /></th>
										<th><spring:message code="page.table.action" text="" /></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${listStudentEditFeeDetail}"
										var="studentFeeDetail" varStatus="status">
										<tr>
											<td>${status.count}</td>

											<td>${studentFeeDetail.sequenceStudentId}</td>
											<td>${studentFeeDetail.totalFee}</td>
											<td>${studentFeeDetail.concession}</td>
											<td>${studentFeeDetail.paidByStudent}</td>
											<td>${studentFeeDetail.remainingFee}</td>
											<td>${studentFeeDetail.installmentNumber}</td>
											<td class="display-flex"><a href="javascript:;"
									data-target="#view-modal" data-toggle="modal"
									data-original-title="View"
									class="tooltips btn btn-success btn-xs"> <i
										class="fa fa-eye"></i>
								</a></td>
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


<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>

<script type="text/javascript">




function getFormFillout(){
	var URL = "/OnlineExam/paymentDetail/getStudentFeesData/";
	var id = document.getElementById('studentId').value;
	//var installmentNumber = document.getElementById('installmentNumber').value;
	//alert(installmentNumber);
	URL = URL + id;
	window.location = URL;
		
		$('#studentId').val(id);
	}
	
	
	

function getFormCycle() {
	var studentId = document.getElementById('studentId').value;
	var startSession = document.getElementById('startSession').value
	//alert(duration);
	if (startSession == 0) {
		if(studentId == null || studentId == "" )
			{
			document.getElementById('errors').innerHTML = "*Please enter Start Session*and  *Please enter StudentId*";
		
			}
		else{
		document.getElementById('errors').innerHTML = "*Please enter Start Session*";
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
		//var URL = "/OnlineExam/paymentDetail/getStudentFeeCalculation/";
		
	var studentId = document.getElementById('studentId').value;
		var startSession = document.getElementById('startSession').value;
		var paidByStudent = document.getElementById('paidByStudent').value;
		var installmentNumber = document.getElementById('installmentNumber').value;
		var remainingFee = document.getElementById('remainingFee').value;
		var duration = document.getElementById('duration').value;
		var paidFee = document.getElementById('paidFee').value;
		
if(startSession != 0 && installmentNumber ==1 )
	{
	remainingFee = paidByStudent;
	}
	alert(installmentNumber);
		if (installmentNumber != 1) {
			alert(installmentNumber);
			document.getElementById('errors').innerHTML = "*Start Session can't change because it is already started*";
			return false;
		} else {

			var mon1 = "january";
			var mon2 = "february";
			var mon3 = "march";
			var mon4 = "April";
			var mon5 = "may";
			var mon6 = "june";
			var mon7 = "july";
			var mon8 = "August";
			var mon9 = "September";
			var mon10 = "October";
			var mon11 = "November";
			var mon12 = "december";

			if (startSession == 1) {

				mon1 = "january";
				mon2 = "february";
				mon3 = "march";
				mon4 = "April";
				mon5 = "may";
				mon6 = "june";
				mon7 = "july";
				mon8 = "August";
				mon9 = "September";
				mon10 = "October";
				mon11 = "November";
				mon12 = "december";
			} else if (startSession == 2) {
				mon12 = "january";
				mon1 = "february";
				mon2 = "march";
				mon3 = "April";
				mon4 = "may";
				mon5 = "june";
				mon6 = "july";
				mon7 = "August";
				mon8 = "September";
				mon9 = "October";
				mon10 = "November";
				mon11 = "december";
			} else if (startSession == 3) {
				mon11 = "january";
				mon12 = "february";
				mon1 = "march";
				mon2 = "April";
				mon3 = "may";
				mon4 = "june";
				mon5 = "july";
				mon6 = "August";
				mon7 = "September";
				mon8 = "October";
				mon9 = "November";
				mon10 = "december";
			} else if (startSession == 4) {
				mon10 = "january";
				mon11 = "february";
				mon12 = "march";
				mon1 = "April";
				mon2 = "may";
				mon3 = "june";
				mon4 = "july";
				mon5 = "August";
				mon6 = "September";
				mon7 = "October";
				mon8 = "November";
				mon9 = "december";
			} else if (startSession == 5) {
				mon9 = "january";
				mon10 = "february";
				mon11 = "march";
				mon12 = "April";
				mon1 = "may";
				mon2 = "june";
				mon3 = "july";
				mon4 = "August";
				mon5 = "September";
				mon6 = "October";
				mon7 = "November";
				mon8 = "december";
			} else if (startSession == 6) {
				mon8 = "january";
				mon9 = "february";
				mon10 = "march";
				mon11 = "April";
				mon12 = "may";
				mon1 = "june";
				mon2 = "july";
				mon3 = "August";
				mon4 = "September";
				mon5 = "October";
				mon6 = "November";
				mon7 = "december";
			} else if (startSession == 7) {
				mon7 = "january";
				mon8 = "february";
				mon9 = "march";
				mon10 = "April";
				mon11 = "may";
				mon12 = "june";
				mon1 = "july";
				mon2 = "August";
				mon3 = "September";
				mon4 = "October";
				mon5 = "November";
				mon6 = "december";
			} else if (startSession == 8) {
				mon6 = "january";
				mon7 = "february";
				mon8 = "march";
				mon9 = "April";
				mon10 = "may";
				mon11 = "june";
				mon12 = "july";
				mon1 = "August";
				mon2 = "September";
				mon3 = "October";
				mon4 = "November";
				mon5 = "december";
			} else if (startSession == 9) {
				mon5 = "january";
				mon6 = "february";
				mon7 = "march";
				mon8 = "April";
				mon9 = "may";
				mon10 = "june";
				mon11 = "july";
				mon12 = "August";
				mon1 = "September";
				mon2 = "October";
				mon3 = "November";
				mon4 = "december";
			} else if (startSession == 10) {
				mon4 = "january";
				mon5 = "february";
				mon6 = "march";
				mon7 = "April";
				mon8 = "may";
				mon9 = "june";
				mon10 = "july";
				mon11 = "August";
				mon12 = "September";
				mon1 = "October";
				mon2 = "November";
				mon3 = "december";
			} else if (startSession == 11) {
				mon3 = "january";
				mon4 = "february";
				mon5 = "march";
				mon6 = "April";
				mon7 = "may";
				mon8 = "june";
				mon9 = "july";
				mon10 = "August";
				mon11 = "September";
				mon12 = "October";
				mon1 = "November";
				mon2 = "december";
			} else if (startSession == 12) {
				mon2 = "january";
				mon3 = "february";
				mon4 = "march";
				mon5 = "April";
				mon6 = "may";
				mon7 = "june";
				mon8 = "july";
				mon9 = "August";
				mon10 = "September";
				mon11 = "October";
				mon12 = "November";
				mon1 = "december";
			}

			var rangeValue = null;
			var intall = null;
			if (startSession == 0) {
				document.getElementById('errors').innerHTML = "*Please select start session*";
				//alert("Please select start session");
				$('#installmentNumber').val("");
				return false;

			} else {
				if (duration == 4) {
					intall = paidByStudent / 4;
					//alert(remainingFee);
					if (remainingFee == paidByStudent && installmentNumber == 1)

					{
						rangeValue = mon1 + "-" + mon3;
						$('#installmentMonth').val(rangeValue);
						$('#installmentAmount').val(intall);
						$('#remainingFee').val(paidByStudent - intall);
						$('#paidFee').val(intall);

					} else if ((remainingFee == (paidByStudent - intall))
							&& installmentNumber == 2) {
						//alert(paidByStudent - intall);
						$('#installmentMonth').val(mon4 + "-" + mon6);
						$('#installmentAmount').val(intall);
						$('#remainingFee').val(paidByStudent - 2 * intall);
						$('#paidFee').val(2 * intall);
					} else if ((remainingFee == (paidByStudent - 2 * intall))
							&& installmentNumber == 3) {
						$('#installmentMonth').val(mon7 + "-" + mon9);
						$('#installmentAmount').val(intall);
						$('#remainingFee').val(paidByStudent - 3 * intall);
						$('#paidFee').val(3 * intall);
					} else if ((remainingFee == (paidByStudent - 3 * intall))
							&& installmentNumber == 4) {
						$('#installmentMonth').val(mon10 + "-" + mon12);
						$('#installmentAmount').val(intall);
						$('#remainingFee').val("0");
						$('#paidFee').val(4 * intall);
					} else if (installmentNumber < 1) {
						//alert("Please enter valid intallment number");
						document.getElementById('errors').innerHTML = "*Please enter valid intallment number*";
						return false;
					}
					else {
						document.getElementById('errors').innerHTML = "*Please pay previous payment*";
						//alert("why");

						return false;
					}

				} else if (duration == 12) {
					var intall =( paidByStudent / 12).toFixed(3);
					alert("HI")
					//$('#installmentAmount').val(intall); 
					if (remainingFee == paidByStudent && installmentNumber == 1) {
						$('#installmentMonth').val(mon1);
						$('#installmentAmount').val(intall);
						$('#remainingFee').val(paidByStudent - intall);
						$('#paidFee').val(intall);
					} else if ((remainingFee == (paidByStudent - intall))
							&& installmentNumber == 2) {
						$('#installmentMonth').val(mon2);

						$('#installmentAmount').val(intall);
						$('#remainingFee').val(paidByStudent - 2 * intall);
						$('#paidFee').val(2 * intall);

					} else if ((remainingFee == (paidByStudent - 2 * intall))
							&& installmentNumber == 3) {
						$('#installmentMonth').val(mon3);
						$('#installmentAmount').val(intall);
						$('#remainingFee').val(paidByStudent - 3 * intall);
						$('#paidFee').val(3 * intall);
					} else if ((remainingFee == (paidByStudent - 3 * intall))
							&& installmentNumber == 4) {
						$('#installmentMonth').val(mon4);
						$('#installmentAmount').val(intall);
						$('#remainingFee').val(paidByStudent - 4 * intall);
						$('#paidFee').val(4 * intall);

					} else if ((remainingFee == (paidByStudent - 4 * intall))
							&& installmentNumber == 5) {
						$('#installmentMonth').val(mon5);
						$('#installmentAmount').val(intall);
						$('#remainingFee').val(paidByStudent - 5 * intall);
						$('#paidFee').val(5 * intall);
					} else if ((remainingFee == (paidByStudent - 5 * intall))
							&& installmentNumber == 6) {
						$('#installmentMonth').val(mon6);
						$('#installmentAmount').val(intall);
						$('#remainingFee').val(paidByStudent - 6 * intall);
						$('#paidFee').val(6 * intall);
					} else if ((remainingFee == (paidByStudent - 6 * intall))
							&& installmentNumber == 7) {
						$('#installmentMonth').val(mon7);
						$('#installmentAmount').val(intall);
						$('#remainingFee').val(paidByStudent - 7 * intall);
						$('#paidFee').val(7 * intall);
					} else if ((remainingFee == (paidByStudent - 7 * intall))
							&& installmentNumber == 8) {
						$('#installmentMonth').val(mon8);
						$('#installmentAmount').val(intall);
						$('#remainingFee').val(paidByStudent - 8 * intall);
						$('#paidFee').val(8 * intall);
					} else if ((remainingFee == (paidByStudent - 8 * intall))
							&& installmentNumber == 9) {
						$('#installmentMonth').val(mon9);
						$('#installmentAmount').val(intall);
						$('#remainingFee').val(paidByStudent - 9 * intall);
						$('#paidFee').val(9 * intall);
					} else if ((remainingFee == (paidByStudent - 9 * intall))
							&& installmentNumber == 10) {
						$('#installmentMonth').val(mon10);
						$('#installmentAmount').val(intall);
						$('#remainingFee').val(paidByStudent - 10 * intall);
						$('#paidFee').val(10 * intall);
					} else if ((remainingFee == (paidByStudent - 10 * intall))
							&& installmentNumber == 11) {
						$('#installmentMonth').val(mon11);
						$('#installmentAmount').val(intall);
						$('#remainingFee').val(paidByStudent - 11 * intall);
						$('#paidFee').val(11 * intall);
					} else if ((remainingFee == (paidByStudent - 11 * intall))
							&& installmentNumber == 12) {
						$('#installmentMonth').val(mon1);
						$('#installmentAmount').val(intall);
						$('#remainingFee').val(paidByStudent - 12 * intall);
						$('#paidFee').val(12 * intall);
					} else if (installmentNumber > 12 || installmentNumber < 1) {
						document.getElementById('errors').innerHTML = "*Please enter valid intallment number*";
						return false;
					} else {
						document.getElementById('errors').innerHTML = "*Please pay previous payment*";
						return false;
					}
				} else if (duration == 2) {
					var intall = paidByStudent / 2;
					//  $('#installmentAmount').val(intall); 
					if (installmentNumber == 1) {
						$('#installmentMonth').val(mon1 + "-" + mon6);

						$('#installmentAmount').val(intall);
						$('#remainingFee').val(paidByStudent - intall);
						$('#paidFee').val(intall);
					} else if (installmentNumber == 2) {
						$('#installmentMonth').val(mon7 + "-" + mon12);

						$('#installmentAmount').val(intall);
						$('#remainingFee').val(paidByStudent - 2 * intall);
						$('#paidFee').val(2 * intall);
					} else if (installmentNumber > 2 || installmentNumber < 1) {
						document.getElementById('errors').innerHTML = "*Please enter valid intallment number*";
						return false;
					} else {
						document.getElementById('errors').innerHTML = "*Please pay previous payment*";
						return false;
					}
				} else if (duration == 1) {
					var intall = paidByStudent / 1;
					// $('#installmentAmount').val(intall); 
					$('#installmentMonth').val(mon1 + "-" + mon12);

					$('#installmentAmount').val(intall);
					$('#remainingFee').val(paidByStudent - intall);
					$('#paidFee').val(intall);
				}

			}
		}
	}

	function getFormCalculationOnClick() {
		//var URL = "/OnlineExam/paymentDetail/getStudentFeeCalculation/";
		var studentId = document.getElementById('studentId').value;
		var startSession = document.getElementById('startSession').value;
		var paidByStudent = document.getElementById('paidByStudent').value;
		var installmentNumber = document.getElementById('installmentNumber').value;
		var remainingFee = document.getElementById('remainingFee').value;
		var duration = document.getElementById('duration').value;
		var paidFee = document.getElementById('paidFee').value;

		var mon1 = "january";
		var mon2 = "february";
		var mon3 = "march";
		var mon4 = "April";
		var mon5 = "may";
		var mon6 = "june";
		var mon7 = "july";
		var mon8 = "August";
		var mon9 = "September";
		var mon10 = "October";
		var mon11 = "November";
		var mon12 = "december";

		if (startSession == 1) {

			mon1 = "january";
			mon2 = "february";
			mon3 = "march";
			mon4 = "April";
			mon5 = "may";
			mon6 = "june";
			mon7 = "july";
			mon8 = "August";
			mon9 = "September";
			mon10 = "October";
			mon11 = "November";
			mon12 = "december";
		} else if (startSession == 2) {
			mon12 = "january";
			mon1 = "february";
			mon2 = "march";
			mon3 = "April";
			mon4 = "may";
			mon5 = "june";
			mon6 = "july";
			mon7 = "August";
			mon8 = "September";
			mon9 = "October";
			mon10 = "November";
			mon11 = "december";
		} else if (startSession == 3) {
			mon11 = "january";
			mon12 = "february";
			mon1 = "march";
			mon2 = "April";
			mon3 = "may";
			mon4 = "june";
			mon5 = "july";
			mon6 = "August";
			mon7 = "September";
			mon8 = "October";
			mon9 = "November";
			mon10 = "december";
		} else if (startSession == 4) {
			mon10 = "january";
			mon11 = "february";
			mon12 = "march";
			mon1 = "April";
			mon2 = "may";
			mon3 = "june";
			mon4 = "july";
			mon5 = "August";
			mon6 = "September";
			mon7 = "October";
			mon8 = "November";
			mon9 = "december";
		} else if (startSession == 5) {
			mon9 = "january";
			mon10 = "february";
			mon11 = "march";
			mon12 = "April";
			mon1 = "may";
			mon2 = "june";
			mon3 = "july";
			mon4 = "August";
			mon5 = "September";
			mon6 = "October";
			mon7 = "November";
			mon8 = "december";
		} else if (startSession == 6) {
			mon8 = "january";
			mon9 = "february";
			mon10 = "march";
			mon11 = "April";
			mon12 = "may";
			mon1 = "june";
			mon2 = "july";
			mon3 = "August";
			mon4 = "September";
			mon5 = "October";
			mon6 = "November";
			mon7 = "december";
		} else if (startSession == 7) {
			mon7 = "january";
			mon8 = "february";
			mon9 = "march";
			mon10 = "April";
			mon11 = "may";
			mon12 = "june";
			mon1 = "july";
			mon2 = "August";
			mon3 = "September";
			mon4 = "October";
			mon5 = "November";
			mon6 = "december";
		} else if (startSession == 8) {
			mon6 = "january";
			mon7 = "february";
			mon8 = "march";
			mon9 = "April";
			mon10 = "may";
			mon11 = "june";
			mon12 = "july";
			mon1 = "August";
			mon2 = "September";
			mon3 = "October";
			mon4 = "November";
			mon5 = "december";
		} else if (startSession == 9) {
			mon5 = "january";
			mon6 = "february";
			mon7 = "march";
			mon8 = "April";
			mon9 = "may";
			mon10 = "june";
			mon11 = "july";
			mon12 = "August";
			mon1 = "September";
			mon2 = "October";
			mon3 = "November";
			mon4 = "december";
		} else if (startSession == 10) {
			mon4 = "january";
			mon5 = "february";
			mon6 = "march";
			mon7 = "April";
			mon8 = "may";
			mon9 = "june";
			mon10 = "july";
			mon11 = "August";
			mon12 = "September";
			mon1 = "October";
			mon2 = "November";
			mon3 = "december";
		} else if (startSession == 11) {
			mon3 = "january";
			mon4 = "february";
			mon5 = "march";
			mon6 = "April";
			mon7 = "may";
			mon8 = "june";
			mon9 = "july";
			mon10 = "August";
			mon11 = "September";
			mon12 = "October";
			mon1 = "November";
			mon2 = "december";
		} else if (startSession == 12) {
			mon2 = "january";
			mon3 = "february";
			mon4 = "march";
			mon5 = "April";
			mon6 = "may";
			mon7 = "june";
			mon8 = "july";
			mon9 = "August";
			mon10 = "September";
			mon11 = "October";
			mon12 = "November";
			mon1 = "december";
		}

		var rangeValue = null;
		var intall = null;
		//remainingFee = remainingFee1.toFixed(3)
		if (startSession == 0) {
			alert("Please select start session");
			$('#installmentNumber').val("");
			return false;

		} else {
			if (duration == 4) {
				intall = paidByStudent / 4;
				//alert(intall);
				if (remainingFee == paidByStudent && installmentNumber == 1)

				{
					rangeValue = mon1 + "-" + mon3;
					$('#installmentMonth').val(rangeValue);
					$('#installmentAmount').val(intall);
					$('#remainingFee').val(paidByStudent - intall);
					$('#paidFee').val(intall);

				} else if ((remainingFee == (paidByStudent - intall))
						&& installmentNumber == 2) {
					//alert(paidByStudent - intall);
					$('#installmentMonth').val(mon4 + "-" + mon6);
					$('#installmentAmount').val(intall);
					$('#remainingFee').val(paidByStudent - 2 * intall);
					$('#paidFee').val(2 * intall);
				} else if ((remainingFee == (paidByStudent - 2 * intall))
						&& installmentNumber == 3) {
					$('#installmentMonth').val(mon7 + "-" + mon9);
					$('#installmentAmount').val(intall);
					$('#remainingFee').val(paidByStudent - 3 * intall);
					$('#paidFee').val(3 * intall);
				} else if ((remainingFee == (paidByStudent - 3 * intall))
						&& installmentNumber == 4) {
					$('#installmentMonth').val(mon10 + "-" + mon12);
					$('#installmentAmount').val(intall);
					$('#remainingFee').val("0");
					$('#paidFee').val(4 * intall);
				} else if (installmentNumber > 4 || installmentNumber < 1) {
					document.getElementById('errors').innerHTML = "*Please enter valid intallment number*";

					return false;
				} else {
					document.getElementById('errors').innerHTML = "*Please pay previous payment*";

					return false;
				}

			} else if (duration == 12) {
				var intall = (paidByStudent / 12).toFixed(3);
				
				
				//alert(remainingFee +"@" + (paidByStudent - intall) );
				//$('#installmentAmount').val(intall); 
				if ( installmentNumber == 1) {
					$('#installmentMonth').val(mon1);
					$('#installmentAmount').val(intall);
					$('#remainingFee').val(paidByStudent - intall);
					$('#paidFee').val(intall);
				} else if (installmentNumber == 2) {
					$('#installmentMonth').val(mon2);

					$('#installmentAmount').val(intall);
					$('#remainingFee').val(paidByStudent - 2 * intall);
					$('#paidFee').val(2 * intall);

				} else if (installmentNumber == 3) {
					$('#installmentMonth').val(mon3);
					$('#installmentAmount').val(intall);
					$('#remainingFee').val(paidByStudent - 3 * intall);
					$('#paidFee').val(3 * intall);
				} else if ( installmentNumber == 4) {
					$('#installmentMonth').val(mon4);
					$('#installmentAmount').val(intall);
					$('#remainingFee').val(paidByStudent - 4 * intall);
					$('#paidFee').val(4 * intall);

				} else if (installmentNumber == 5) {
					$('#installmentMonth').val(mon5);
					$('#installmentAmount').val(intall);
					$('#remainingFee').val(paidByStudent - 5 * intall);
					$('#paidFee').val(5 * intall);
				} else if (installmentNumber == 6) {
					$('#installmentMonth').val(mon6);
					$('#installmentAmount').val(intall);
					$('#remainingFee').val(paidByStudent - 6 * intall);
					$('#paidFee').val(6 * intall);
				} else if ( installmentNumber == 7) {
					$('#installmentMonth').val(mon7);
					$('#installmentAmount').val(intall);
					$('#remainingFee').val(paidByStudent - 7 * intall);
					$('#paidFee').val(7 * intall);
				} else if ( installmentNumber == 8) {
					$('#installmentMonth').val(mon8);
					$('#installmentAmount').val(intall);
					$('#remainingFee').val(paidByStudent - 8 * intall);
					$('#paidFee').val(8 * intall);
				} else if ( installmentNumber == 9) {
					$('#installmentMonth').val(mon9);
					$('#installmentAmount').val(intall);
					$('#remainingFee').val(paidByStudent - 9 * intall);
					$('#paidFee').val(9 * intall);
				} else if ( installmentNumber == 10) {
					$('#installmentMonth').val(mon10);
					$('#installmentAmount').val(intall);
					$('#remainingFee').val(paidByStudent - 10 * intall);
					$('#paidFee').val(10 * intall);
				} else if (installmentNumber == 11) {
					$('#installmentMonth').val(mon11);
					$('#installmentAmount').val(intall);
					$('#remainingFee').val(paidByStudent - 11 * intall);
					$('#paidFee').val(11 * intall);
				} else if ( installmentNumber == 12) {
					$('#installmentMonth').val(mon1);
					$('#installmentAmount').val(intall);
					$('#remainingFee').val(paidByStudent - 12 * intall);
					$('#paidFee').val(12 * intall);
				} else if (installmentNumber > 12 || installmentNumber < 1) {
					document.getElementById('errors').innerHTML = "*Please enter valid intallment number*";
					return false;
				} else {
					document.getElementById('errors').innerHTML = "*Please pay previous payment*";
					return false;
				}
			} else if (duration == 2) {
				var intall = paidByStudent / 2;
				//  $('#installmentAmount').val(intall); 
				if (installmentNumber == 1) {
					$('#installmentMonth').val(mon1 + "-" + mon6);

					$('#installmentAmount').val(intall);
					$('#remainingFee').val(paidByStudent - intall);
					$('#paidFee').val(intall);
				} else if (installmentNumber == 2) {
					$('#installmentMonth').val(mon7 + "-" + mon12);

					$('#installmentAmount').val(intall);
					$('#remainingFee').val(paidByStudent - 2 * intall);
					$('#paidFee').val(2 * intall);
				} else if (installmentNumber > 2 || installmentNumber < 1) {
					document.getElementById('errors').innerHTML = "*Please enter valid intallment number*";
					return false;
				} else {
					document.getElementById('errors').innerHTML = "*Please pay previous payment*";
					return false;
				}
			} else if (duration == 1) {
				var intall = paidByStudent / 1;
				// $('#installmentAmount').val(intall); 
				$('#installmentMonth').val(mon1 + "-" + mon12);

				$('#installmentAmount').val(intall);
				$('#remainingFee').val(paidByStudent - intall);
				$('#paidFee').val(intall);
			}

		}

	}
</script>



