<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

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
			href="${pageContext.request.contextPath}/studentForm/studentDetail"><spring:message
					code="Student.StudentDetail" text="" /></a></li>
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
						<spring:message code="user.manage.studentForm" text="" />
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
								<form:form class="form-horizontal" commandName="student" 
									action="${pageContext.request.contextPath}/studentForm/saveStudentDetail"
									method="post" enctype="multipart/form-data">
									<form:hidden path="id" />
									<form:hidden path="adminId.id" />
									<form:hidden path="schoolId.id" />
									<input type="hidden" name="admissionID" value="${admissionID}"/>
									<div class="form-body">
									<div class="row" style="color: red" id="errors"></div>
										<div class="row">
											<div class="col-md-5  col-md-offset-1">
												<div class="form-group">
													<label class="control-label col-md-4"> <spring:message
															code="Student.student_id" text="" /><span class="astrek"
														style="color: red"> * </span></label>
													<div class="col-md-8">
														<form:input id="studentId" path="studentId"
															class="form-control" type="text" readonly="true"/>
														<span class="help-block"></span>
													</div>
												</div>
											</div>
											<div class="col-md-5">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message
															code="Student.first.name" text="" /><span class="astrek"
														style="color: red"> * </span></label>
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
													<label class="control-label col-md-4"><spring:message
															code="Student.middle.name" text="" /></label>
													<div class="col-md-8">
														<form:input id="middleName" path="middleName"
															class="form-control" type="text" />
														<span class="help-block"></span>
													</div>
												</div>
											</div>
											<div class="col-md-5">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message
															code="Student.last.name" text="" /><span class="astrek"
														style="color: red"> * </span></label>
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
													<label class="control-label col-md-4"><spring:message
															code="Student.class" text="" /><span class="astrek"
														style="color: red"> * </span></label>
													<div class="col-md-8">
														<form:select id="className" required="required"    path="className" class="form-control">
															<form:option value="None"
																label="--------------- Select------------------" />
															<c:forEach items="${classNameList}" var="className" varStatus="status">
									
																	<form:option value="${className.classPresent}" />
														</c:forEach>

														</form:select>
															
														<span class="help-block"></span>
													</div>
												</div>
											</div>
											<div class="col-md-5">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message
															code="Student.class.section" text="" /><span
														class="astrek" style="color: red"> * </span></label>
													<div class="col-md-8">
														<form:select id="classSection" path="classSection" required="required"
															class="form-control">
															<form:option value="None"
																label="--------------- Select------------------" />
													 <c:forEach items="${classSectionList}" var="classSection" varStatus="status">
									
																	<form:option value="${classSection.classSectionValue}"/>
														</c:forEach>  >


														</form:select>
															
														<span class="help-block"></span>
													</div>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-5 col-md-offset-1">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message
															code="Student.dob" text="" />
																<span class="astrek" style="color: red"> * </span></label>
													<div class="col-md-8">
														<form:input id="dob" path="dob" class="form-control"
															type="date" required="required" />
														<span class="help-block"></span>
													</div>
												</div>
											</div>
											<div class="col-md-5">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message
															code="Student.gender" text="" /> </label>
													<div class="col-md-8">
														<form:select path="gender" required="required"
															class="form-control">
															<form:option value="0"
																label="--------------- Select------------------" />
															<form:option value="1" label="Male" />
															<form:option value="2" label="Female" />


														</form:select>

													</div>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-5 col-md-offset-1">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message
															code="Student.mobile_no" text="" /><span class="astrek"
														style="color: red"> * </span></label>
													<div class="col-md-8">
														<form:input id="mobileNumber" path="mobileNumber"
															class="form-control" type="number" />
														<span class="help-block"></span>

													</div>
												</div>
											</div>
											<div class="col-md-5">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message
															code="Student.father.name" text="" />
															<span class="astrek" style="color: red"> * </span></label>
													<div class="col-md-8">
														<form:input id="fatherName" path="fatherName"
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
															code="Student.father.occupation" text="" /></label>
													<div class="col-md-8">
														<form:input id="fatherOccupation" path="fatherOccupation"
															class="form-control" type="text" />
														<span class="help-block"></span>
													</div>
												</div>
											</div>
											<div class="col-md-5">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message
															code="Student.mother.name" text="" />
															<span class="astrek" style="color: red"> * </span> </label>
													<div class="col-md-8">
														<form:input id="motherName" path="motherName"
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
															code="Student.mother.occupation" text="" /></label>
													<div class="col-md-8">
														<form:input id="motherOccupation" path="motherOccupation"
															class="form-control" type="text" />
														<span class="help-block"></span>
													</div>
												</div>
											</div>
											<div class="col-md-5">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message
															code="Student.address" text="" />
															<span class="astrek" style="color: red"> * </span> </label>
													<div class="col-md-8">
														<form:input id="address" path="address"
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
															code="Student.aadhar_no" text="" /></label>
													<div class="col-md-8">
														<form:input id="aadharNumber" path="aadharNumber"
															class="form-control" type="number" />
														<span class="help-block"></span>
													</div>
												</div>
											</div>
											<div class="col-md-5">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message
															code="Student.religion" text="" /> </label>
													<div class="col-md-8">
														<form:input id="religion" path="religion"
															class="form-control" type="text" />
														<span class="help-block"></span>
													</div>
												</div>
											</div>
										</div>


										<div class="row">
											<div class="col-md-5 col-md-offset-1">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message
															code="Student.category" text="" /></label>
													<div class="col-md-8">
														<form:input id="category" path="category"
															class="form-control" type="text" />
														<span class="help-block"></span>
													</div>
												</div>
											</div>
											<div class="col-md-5">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message
															code="Student.email_id" text="" /> </label>
													<div class="col-md-8">
														<form:input id="emailId" path="emailId"
															class="form-control" type="email" />
														<span class="help-block"></span>
													</div>
												</div>
											</div>
										</div>

										<div class="row">
											<div class="col-md-5 col-md-offset-1">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message
															code="Student.previous.class.percentage" text="" /></label>
													<div class="col-md-8">
														<form:input id="previousClassPercentage"
															path="previousClassPercentage" class="form-control"
															type="text" />
														<span class="help-block"></span>
													</div>
												</div>
											</div>
											<div class="col-md-5">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message
															code="Student.blood.group" text="" /> </label>
													<div class="col-md-8">
														<form:input id="bloodGroup" path="bloodGroup"
															class="form-control" type="text" />
														<span class="help-block"></span>
													</div>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-md-5 col-md-offset-1">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message code="user.image" text="" /></label>
													<div class="col-md-8">
														<input type="file" name="userpic" id="userpic"
															class="form-control"> <span class="help-block"></span>
													</div>
												</div>
											</div>
											<div class="col-md-5">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message code="user.image" text="" /></label>
													<div class="col-md-8">
														<img
															src="${pageContext.request.contextPath}/student/readAdmissionStudentDisplayImage/${admissionID}"
															class="img-responsive" alt="">
													</div>
												</div>
											</div>
										</div>											

										<div class="row margin-top-10">
											<div class="col-md-5 col-md-offset-1">
												<div class="row">
													<div class="col-md-offset-4 col-md-9">
														<input type="submit" value="Submit" onclick="javaScript:checkValidation();">
														
													</div>
												</div>
											</div>

										</div>
									</div>
								</form:form>
							</div>
						</div>
					</div>
					<c:if test="${!empty listStudent}">
						<table id="sample_3"
							class="table table-bordered table-striped table-condensed flip-content">
							<thead class="flip-content">
								<tr>
									<th><spring:message code="page.table.slno" text="" /></th>
									<th><spring:message code="user.image" text="" /></th>
									<th><spring:message code="Student.student_id" text="" /></th>
									<th><spring:message code="Student.first.name" text="" /></th>
									<th><spring:message code="Student.email_id" text="" /></th>
									<th><spring:message code="Student.mobile_no" text="" /></th>
									<th><spring:message code="Student.gender" text="" /></th>
									<th><spring:message code="Student.dob" text="" /></th>
									<th><spring:message code="page.table.action" text="" /></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${listStudent}" var="student"
									varStatus="status">
									<tr>
										<td>${status.count}</td>
										<td><img alt=""
											src="${pageContext.request.contextPath}/studentForm/readStudentDisplayImage/${student.id}"
											width="30" height="40" /></td>
											<td>${student.studentId}</td>
										<td>${student.firstName}${student.middleName}${student.lastName}</td>
										
										<td>${student.emailId}</td>
										<td>${student.mobileNumber}</td>
										<td>${student.gender}</td>
										<td><fmt:formatDate pattern="yyyy-MM-dd"
												value="${student.dob}" /></td>
										<td class="display-flex"><a href="javascript:;"
											data-original-title="View"
											class="tooltips btn btn-success btn-xs"> <i
												class="fa fa-eye"></i>
										</a> <a
											href="${pageContext.request.contextPath}/studentForm/editStudent/${student.id}"
											data-original-title="Edit"
											class="tooltips btn btn-success btn-xs"> <i
												class="fa fa-pencil"></i>
										</a> <c:if test="${student.enabled}">
												<a
													href="${pageContext.request.contextPath}/studentForm/enableDisableStudent/${student.id}/false"
													data-original-title="Click to Disable"
													class="tooltips btn btn-danger btn-xs"><i
													class="fa fa-toggle-off" aria-hidden="true"></i>
												<spring:message code="page.table.disable" text="" /></a>
											</c:if> <c:if test="${!student.enabled}">
												<a
													href="${pageContext.request.contextPath}/studentForm/enableDisableStudent/${student.id}/true"
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
	function checkValidation(){
	/* 	alert('hi'); */
		var phoneNo = document.getElementById("mobileNumber");
		if(!isNaN(phoneNo)){
			alert('Plaese enter a numeric value.');
			return false;
		}
		if(phoneNo.value.length<10){
			alert("Enter 10 digit mobile number.");
			phoneNo.focus();
			return false;
		}
		return true;
	}
	
	
	/* 
	$(document).ready(function() {

		var list = ${list};
		$.each(list, function( index, value ) {
			alert( index + ": " + value );
		});

	});
	 */
	
	
	/* function getclassSectionList(){
		//alert("message")
		var URL = "/OnlineExam/studentForm/getclassSectionList/";
		var className = document.getElementById('className').value;
		alert(className);
		//var classSection =${classSectionList};
		//console.log(classSection);
		if(className != 0 )
		{
		id =className;
		
		URL = URL+id;
	    window.location=URL;
	     //alert(URL)
		} 
	
   } */
	 
	   $(document).ready(function () {
        $("#classSection").prop("disabled", true);
        $("#className").change(function () {
            if ($("#className").val() != "Please select") {
                var options = {};
                var URL = "/OnlineExam/studentForm/getclassSectionList/";
        		var className = document.getElementById('className').value;
        		alert(className);
        		//var classSection =${classSectionList};
        		//console.log(classSection);
        		
        		id =className;
        		
        		URL = URL+id;
        		options.url=URL;
        		options.type = "Get";
                options.url = "/OnlineExam/studentForm/getclassSectionList/"+id;
                
                options.contentType = "application/json";
                options.success = function (response) {
                	console.log(JSON.stringify(response));
                   /*  $("#state").empty();
                    for (var i = 0; i < states.length; i++) {
                        $("#state").append("<option>" + states[i] + "</option>");
                    }
                    $("#state").prop("disabled", false); */
                };
                options.error = function () { alert("Error retrieving states!"); };
                $.ajax(options);
            }
            else {
                $("#state").empty();
                $("#state").prop("disabled", true);
            }
        });
    }); 
	
	
 </script>
		
		<%-- 
		//alert(classSection[index].value);
		//var paramOne =<c:out value="${classSectionList}"/>
		//alert(paramOne);
		/* forEach (ClassSection      in id)
		{
			alert(classSection.classSectionValue[id]);
		}
		// */
	/* 	//alert(section)
	if(className != 0 )
		{
		id =className;
		classSectionValue
		URL = URL+id;
	    window.location=URL;
	    //alert(URL)
		} */ --%>
	

<%@ include file="/WEB-INF/jsp/common/bottom.jsp"%>