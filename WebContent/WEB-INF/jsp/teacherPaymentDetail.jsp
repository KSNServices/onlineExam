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
		<li><a href="${pageContext.request.contextPath}/teacherPayment/teacherPayementInformation"><spring:message code="Teacher.TeacherPaymentDetails" text="" /></a></li>
	</ul>
	<!-- END PAGE BREADCRUMB -->

	<!-- BEGIN PAGE CONTENT INNER -->
	<div class="row margin-top-10">
		<div class="col-md-12">
			<!-- BEGIN SAMPLE TABLE PORTLET-->
			<div class="portlet box lightblue">
				<div class="portlet-title">
					<div class="caption">
						<i class="fa fa-cogs"></i><spring:message code="Teacher.TeacherPaymentDetails" text="" />
					</div>
					<div class="actions">
						<a data-toggle="collapse" data-target="#addform"
							class="btn btn-danger btn-sm"> <spring:message code="page.add" text="" /> <i class="fa fa-plus"></i>
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
								<form:form class="form-horizontal" commandName="teacherPaymentDetail"
								action="${pageContext.request.contextPath}/teacherPayment/saveTeacherPaymentInformation"
									method="post" enctype="multipart/form-data">
									<form:hidden path="id" />
									<form:hidden path="adminId.id" />
									<form:hidden path="schoolId.id" />
									<form:hidden path="teacherId.id" /> 
							 
							
										<form:hidden path="duration" /> 
							<form:hidden path="installmentNumber" /> 
								<form:hidden path="paidSalary" /> 
									<form:hidden path="remainingSalary" /> 
									<form:hidden path="totalSalary" /> 
									<form:hidden path="startSession" />
									
									<div class="form-body">
										<div class="row" style="color: red" id="errors"></div>
										<div class="row">
											<div class="col-md-5  col-md-offset-1">
												<div class="form-group">
													<label class="control-label col-md-4"> <spring:message
															code="TeacherSalaryDetail.teacher_id" text="" /><span
														class="astrek" style="color: red"> * </span></label>
													<div class="col-md-8">
														<form:input id="teacherId" path="sequenceTeacherId"
															class="form-control" type="text" required="required"
															onchange="javaScript:getFormFillout();" />
														<span class="help-block"></span>
													</div>
												</div>
											</div>
											<div class="col-md-5">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message
															code="TeacherSalaryDetail.teacher_name" text="" /><span
														class="astrek" style="color: red"> * </span></label>
													<div class="col-md-8">
														<form:input id="teacherName" path="teacherId.teacherName"
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
															code="teacherSalaryDetail.teacher_grade" text="" /> </label>
													<div class="col-md-8">
													<form:input id="teacherGrade" path="teacherGrade"
															class="form-control" type="text" readonly="true" />
														<span class="help-block"></span>
													</div>
												</div>
												
											</div>
											<div class="col-md-5">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message
															code="teacherSalaryDetail.Salary_Month" text="" /><span
														class="astrek" style="color: red"> * </span></label>
													<div class="col-md-8">
														<form:input id="installmentMonth" path="installmentMonth"  readonly="true"
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
															code="TeacherSalaryDetail.additionalsalary" text="" /> </label>
													<div class="col-md-8">
														<form:input id="additionalAmount" path="additionalAmount"  readonly="true"
															class="form-control" type="text" required="required" />
														<span class="help-block"></span>
															</div>
												</div>

											</div>
											<div class="col-md-5">

												<div class="form-group">
													<label class="control-label col-md-4"><spring:message
															code="TeacherSalaryDetail.TotalAmountOfMonth" text="" /><span
														class="astrek" style="color: red"> * </span></label>
													<div class="col-md-8">
														<form:input id="TotalAmountMonth" path="TotalAmountMonth" readonly="true"
															class="form-control" type="text" required="required"  />
														<span class="help-block"></span>
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
					<c:if test="${!empty listTeacherFeeDetails}">
						<div id="printableArea">
							<table id="sample_3"
								
									class="table table-bordered table-striped table-condensed ">
						<thead class="bg-light-green">
									<tr>
										<th><spring:message code="page.table.slno" text="" /></th>

										<th><spring:message code="TeacherSalaryDetail.teacher_id"
												text="" /></th>
										

										<th><spring:message code="teacherSalaryDetail.teacher_grade"
												text="" /></th>
										<th><spring:message
												code="teacherSalaryDetail.total_salary" text="" /></th>
										<th><spring:message code="TeacherSalaryDetail.paid_Salary"
												text="" /></th>
										<th><spring:message code="TeacherSalaryDetail.remaining_Salary"
												text="" /></th>
										<th><spring:message code="page.table.action" text="" /></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${listTeacherFeeDetails}"
										var="teacherPaymentDetail" varStatus="status">
										<tr>
											<td>${status.count}</td>

											<td>${teacherPaymentDetail.sequenceTeacherId}</td>
										
											<td>${teacherPaymentDetail.teacherGrade}</td>
											<td>${teacherPaymentDetail.totalSalary}</td>
											<td>${teacherPaymentDetail.paidSalary}</td>
											<td>${teacherPaymentDetail.remainingSalary}</td>
											<td class="display-flex"><a href="javascript:;"
									data-target="#view-modal" data-toggle="model"
							data-original-title="View"
									class="tooltips btn btn-success btn-xs"> <i
										class="fa fa-eye"></i>
								</a> <a
												href="${pageContext.request.contextPath}/student/editRegistration/${teacherPaymentDetail.id}"
												data-original-title="Edit"
												class="tooltips btn btn-success btn-xs"> <i
													class="fa fa-pencil"></i>
											</a> <c:if test="${admissionFormModel.enabled}">
													<a
														href="${pageContext.request.contextPath}/student/enableDisableRegistration/${teacherPaymentDetail.id}/false"
														data-original-title="Click to Disable"
														class="tooltips btn btn-danger btn-xs"><i
														class="fa fa-toggle-off" aria-hidden="true"></i> <spring:message
															code="page.table.disable" text="" /></a>
												</c:if> <c:if test="${!admissionFormModel.enabled}">
													<a
														href="${pageContext.request.contextPath}/student/enableDisableRegistration/${teacherPaymentDetail.id}/true"
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


<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>

<script type="text/javascript">
function getFormFillout() {
	//alert("hi");
	var URL = "/OnlineExam/teacherPayment/getTeacherPaymentValue/";
	var id = document.getElementById('teacherId').value;

	
	var sum = id ;
	URL = URL + sum;
	window.location = URL;
	
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
	/* 	var duration = document.getElementById('duration').value;
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
		} */
	}

	function getFormCalculation() {
		/* var URL = "/OnlineExam/feeDetail/getStudentFeeCalculation/";
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

		$('#studentId').val(studentId); */
	}

</script>




<%@ include file="/WEB-INF/jsp/common/bottom.jsp"%>