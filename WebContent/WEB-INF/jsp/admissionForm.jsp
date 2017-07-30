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
		<li><a href="${pageContext.request.contextPath}/student/admissionForm"><spring:message code="Admission.AdmissionForm" text="" /></a></li>
	</ul>
	<!-- END PAGE BREADCRUMB -->

	<!-- BEGIN PAGE CONTENT INNER -->
	<div class="row margin-top-10">
		<div class="col-md-12">
			<!-- BEGIN SAMPLE TABLE PORTLET-->
			<div class="portlet box lightblue">
				<div class="portlet-title">
					<div class="caption">
						<i class="fa fa-cogs"></i><spring:message code="user.manage.student" text="" />
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
								<form:form class="form-horizontal" commandName="admissionFormModel"
									action="${pageContext.request.contextPath}/student/saveAdmissionForm"
									method="post" enctype="multipart/form-data">								
									<form:hidden path="id"/>
									<form:hidden path="adminId.id" />
									<form:hidden path="schoolId.id" />
									<div class="form-body">
									<div class="row" style="color: red" id="errors"></div>
										<div class="row">
											<div class="col-md-5  col-md-offset-1">
												<div class="form-group">
													<label class="control-label col-md-4"> <spring:message code="Admission.registration_No" text="" /><span
														class="astrek" style="color: red"> * </span></label>
													<div class="col-md-8">
														<form:input id="registrationNo"   path="registrationNo"
															class="form-control" type="text" required="required" readonly="true" />
														<span class="help-block"></span>
													</div>
												</div>
											</div>
											<div class="col-md-5">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message code="Admission.first.name" text="" /><span
														class="astrek" style="color: red"> * </span></label>
													<div class="col-md-8">
														<form:input id="firstName" path="firstName"
															class="form-control" type="text" required="required" />
														<span class="help-block"></span>
													</div>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-5 col-md-offset-1">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message code="Admission.middle.name" text="" /></label>
													<div class="col-md-8">
														<form:input id="middleName" path="middleName"
															class="form-control" type="text" />
														<span class="help-block"></span>
													</div>
												</div>
											</div>
											<div class="col-md-5">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message code="Admission.last.name" text="" /><span
														class="astrek" style="color: red"> * </span></label>
													<div class="col-md-8">
														<form:input id="lastName" path="lastName"
															class="form-control" type="text" required="required" />
														<span class="help-block"></span>
													</div>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-5 col-md-offset-1">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message code="Admission.mobile.number" text="" /><span
														class="astrek" style="color: red"> * </span></label>
													<div class="col-md-8">
														<form:input id="mobileNumber" path="mobileNumber"
															class="form-control" type="number" required="required" onchange="javaScript:validationMobileNumber();"  />
														<span class="help-block"></span>
													</div>
												</div>
											</div>
											<div class="col-md-5">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message code="Admission.email" text="" /><span
														class="astrek" style="color: red"> * </span></label>
													<div class="col-md-8">
														<form:input id="emailId" path="emailId"
															class="form-control" type="email" required="required" />
														<span class="help-block"></span>
													</div>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-5 col-md-offset-1">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message code="Admission.phone.number" text="" /></label>
													<div class="col-md-8">
														<form:input id="phoneNumber" path="phoneNumber"
															class="form-control" type="number" />
														<span class="help-block"></span>
													</div>
												</div>
											</div>
											<div class="col-md-5">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message code="Admission.aadhar.number" text="" /> </label>
													<div class="col-md-8">
														<form:input id="aadharNumber" path="aadharNumber" class="form-control" maxlength="12"
															type="number" />
														<span class="help-block"></span>
													</div>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-5 col-md-offset-1">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message code="Admission.gender" text="" /><span
														class="astrek" style="color: red"> * </span></label>
													<div class="col-md-8">
												
														<form:select path="gender" required="required"
															class="form-control">
															<form:option value="0" label="--------------- Select------------------" />
															<form:option value="Male" label="Male" />
															<form:option value="Female" label="Female" />
														
															
														</form:select>
													
														
													</div>
												</div>
											</div>
											<div class="col-md-5">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message code="Admission.image" text="" /></label>
													<div class="col-md-8">
														<input type="file" name="userpic" id="userpic"
															class="form-control"> <span class="help-block"></span>
													</div>
												</div>
											</div>
										</div>
										
										<div class="row">
											<div class="col-md-5 col-md-offset-1">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message code="Admission.fatherName" text="" />
													<span class="astrek" style="color: red"> * </span></label>
													<div class="col-md-8">
														<form:input id="fatherName" path="fatherName" 
															class="form-control" type="text" required="required" />
														<span class="help-block"></span>
													</div>
												</div>
											</div>
											<div class="col-md-5">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message code="Admission.fatherOccupation" text="" /> </label>
													<div class="col-md-8">
														<form:input id="fatherOccupation" path="fatherOccupation" class="form-control"
															type="text" />
														<span class="help-block"></span>
													</div>
												</div>
											</div>
										</div>
										
											<div class="row">
											<div class="col-md-5 col-md-offset-1">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message code="Admission.motherName" text="" />
													<span class="astrek" style="color: red"> * </span></label>
													<div class="col-md-8">
														<form:input id="motherName" path="motherName" 
															class="form-control" type="text" required="required" />
														<span class="help-block"></span>
													</div>
												</div>
											</div>
											<div class="col-md-5">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message code="Admission.motheroccupation" text="" /> </label>
													<div class="col-md-8">
														<form:input id="motherOccupation" path="motherOccupation" class="form-control"
															type="text" />
														<span class="help-block"></span>
													</div>
												</div>
											</div>
										</div>
										
										
										<div class="row">
											<div class="col-md-5 col-md-offset-1">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message code="Admission.dob" text="" />
													<span class="astrek" style="color: red"> * </span></label>
													<div class="col-md-8">
														<form:input id="dob" path="dob"
															class="form-control" type="date" required="required" />
														<span class="help-block"></span>
													</div>
												</div>
											</div>
											<div class="col-md-5">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message code="Admission.class" text="" /> </label>
													<div class="col-md-8">
															<form:select path="className" required="required"
															class="form-control">
															<form:option value="0"
																label="--------------- Select------------------" />
															
															<c:forEach items="${classNameList}" var="className" varStatus="status">
									
																	<form:option value="${className.classPresent}"/>
														</c:forEach>
															
														</form:select>
														<span class="help-block"></span>
													</div>
												</div>
											</div>
										</div>
										
										
										
										
										<div class="row">
											<div class="col-md-5 col-md-offset-1">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message code="Admission.religion" text="" /></label>
													<div class="col-md-8">
														<form:input id="religion" path="religion"
															class="form-control" type="text" />
														<span class="help-block"></span>
													</div>
												</div>
											</div>
											<div class="col-md-5">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message code="Admission.address" text="" /> 
													<span class="astrek" style="color: red"> * </span></label>
													<div class="col-md-8">
														<form:input id="address" path="address" class="form-control"
															type="text" required="required" />
														<span class="help-block"></span>
													</div>
												</div>
											</div>
										</div>
										
										
										
										
										
										<div class="row">
											<div class="col-md-5 col-md-offset-1">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message code="Admission.bloodGroup" text="" /></label>
													<div class="col-md-8">
														<form:input id="bloodGroup" path="bloodGroup"
															class="form-control" type="text" />
														<span class="help-block"></span>
													</div>
												</div>
											</div>
											<div class="col-md-5">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message code="Admission.previousClass_percentage" text="" /> </label>
													<div class="col-md-8">
														<form:input id="previousClassPercentage" path="previousclassPercentage" class="form-control"
															type="text" />
														<span class="help-block"></span>
													</div>
												</div>
											</div>
										</div>
										
										
										<div class="row margin-top-10">
											<div class="col-md-5 col-md-offset-1">
												<div class="row">
													<div class="col-md-offset-4 col-md-9">
														<input type="submit" value="Submit" onclick="javaScript:checkValidation();" code="page.submit" >
													
													</div>
												</div>
											</div>

										</div>
									</div>
								</form:form>
							</div>
						</div>
					</div>
					<c:if test="${!empty registrationList}">
						<table id="allstudent_table"
							class="table table-bordered table-striped table-condensed ">
							<thead class="flip-content">
								<tr>
									<th><spring:message code="page.table.slno" text="" /></th>
									<th><spring:message code="user.image" text="" /></th>
									<th><spring:message code="Admission.registration_No" text="" /></th>
									<th><spring:message code="Admission.first.name" text="" /></th>
									
									<th><spring:message code="Admission.email" text="" /></th>
									<th><spring:message code="Admission.mobile.number" text="" /></th>
									<th><spring:message code="Admission.gender" text="" /></th>
									<th><spring:message code="page.table.action" text="" /></th>		
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${registrationList}" var="admissionFormModel" varStatus="status">
									<tr>
										<td>${status.count}</td>
										<td><img alt=""
											src="${pageContext.request.contextPath}/student/readAdmissionStudentDisplayImage/${admissionFormModel.id}"
											width="30" height="40" /></td>
											<td>${admissionFormModel.registrationNo}</td>
										<td>${admissionFormModel.firstName} ${admissionFormModel.lastName}</td>
										
										<td>${admissionFormModel.emailId}</td>
										<td>${admissionFormModel.mobileNumber}</td>
										<td>${admissionFormModel.gender}</td>
										<td class="display-flex"><a href="javascript:;"
											data-original-title="View"
											class="tooltips btn btn-success btn-xs"> <i
												class="fa fa-eye"></i>
										</a> 
										<a
											href="${pageContext.request.contextPath}/student/editRegistration/${admissionFormModel.id}"
											data-original-title="Edit"
											class="tooltips btn btn-success btn-xs"> <i
												class="fa fa-pencil"></i>
										</a> 
										<c:if test="${admissionFormModel.enabled}">
												<a
													href="${pageContext.request.contextPath}/student/enableDisableRegistration/${admissionFormModel.id}/false"
													data-original-title="Click to Disable"
													class="tooltips btn btn-danger btn-xs"><i
													class="fa fa-toggle-off" aria-hidden="true"></i><spring:message code="page.table.disable" text="" /></a>
											<a
											href="${pageContext.request.contextPath}/student/confirmStudent/${admissionFormModel.id}"
											data-original-title="Edit"
											class="tooltips btn btn-success btn-xs"> <spring:message code="page.table.confirm" text="" />
										</a>
											</c:if> <c:if test="${!admissionFormModel.enabled}">
												<a
													href="${pageContext.request.contextPath}/student/enableDisableRegistration/${admissionFormModel.id}/true"
													data-original-title="Click to Enable"
													class="tooltips btn btn-success btn-xs"> <i
													class="fa fa-toggle-off" aria-hidden="true"></i> <spring:message code="page.table.enable" text="" />
													
												</a>
												
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
 

<script type="text/javascript">




function validationMobileNumber(){
	//alert("message")
	//var URL = "/OnlineExam/classSectionValue/getClassSectionsList/";
	var mobileNumber = document.getElementById('mobileNumber').value;

	
	   if(isNaN(mobileNumber)||mobileNumber.indexOf(" ")!=-1)
           {
		   document.getElementById('errors').innerHTML = "*Enter numeric value*";
             
              return false; 
           }
	   else if(mobileNumber.length != 10)
		   {
		   document.getElementById('errors').innerHTML = "Mobile number must be 10 digits.";
		 
		     return false; 
		   }
	
	return true;
}



$(document).ready(function(){
    $('#allstudent_table').DataTable({
        "language": {
        "lengthMenu": "Display _MENU_ records per page",
        "zeroRecords": "Nothing found - sorry",/*
        "info": "Showing page _PAGE_ of _PAGES_",*/
        "infoEmpty": "No records available",
        "infoFiltered": "(filtered from _MAX_ total records)"
        },
        "initComplete": function(settings, json) {
$('body').find('.dataTables_scrollBody').addClass("scrollbar");
},

        "scrollY": 300,         
        "scrollX": true,
         scrollCollapse: true,
        dom: '<"html5buttons"B>lTfgitp',


        buttons: [
            {extend: 'copy'},
            {extend: 'csv'},
            {extend: 'excel',title: 'student list'},
            {extend: 'pdf',title: 'student list'},

            {extend: 'print',title: 'student list',
             customize: function (win){
                    $(win.document.body).addClass('white-bg');
                    $(win.document.body).css('font-size', '10px');

                    /* $(win.document.body).find('table')
                            .addClass('compact')
                            .css('font-size', 'inherit'); */
            }
            }
        ],
         "iDisplayLength": 1000,
        "aLengthMenu": [[ 25, 50, 100,250,500,1000,2000,-1], [25, 50, 100, 250,500,1000,2000, "All"]]

    });

});   

</script>

<%@ include file="/WEB-INF/jsp/common/bottom.jsp"%>