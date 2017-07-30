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
		<li><a href="${pageContext.request.contextPath}/attendanceStudent/attendance"><spring:message code="Student.Attendance" text="" /></a></li>
	</ul>
	<!-- END PAGE BREADCRUMB -->

	<!-- BEGIN PAGE CONTENT INNER -->
	<div class="row margin-top-10">
		<div class="col-md-12">
			<!-- BEGIN SAMPLE TABLE PORTLET-->
			<div class="portlet box lightblue">
				<div class="portlet-title">
					<div class="caption">
						<i class="fa fa-cogs"></i><spring:message code="user.manage.Attendance" text="" />
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
								<form:form class="form-horizontal" commandName="attendance"
									action="${pageContext.request.contextPath}/attendanceStudent/attendance"
									method="post" enctype="multipart/form-data">								
									<form:hidden path="id"/>
									<form:hidden path="adminId.id" />
									<form:hidden path="schoolId.id" />
									<div class="form-body">
											<div class="row">
											<div class="col-md-5 col-md-offset-1">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message
															code="FeeStructure.class" text="" /></label>
													<div class="col-md-8">
															<form:select path="className" required="required" id="className"
															class="form-control">
															<form:option value="None"
																label="--------------- Select ------------------" />
															<form:option value="I" label="I" />
															<form:option value="II" label="II" />
															<form:option value="III" label="III" />
															<form:option value="IV" label="IV" />
															<form:option value="V" label="V" />
															<form:option value="VI" label="VI" />
															<form:option value="VII" label="VII" />
															<form:option value="VIII" label="VIII" />
															<form:option value="IX" label="IX" />
															<form:option value="X" label="X" />
															<form:option value="XI" label="XI" />
															<form:option value="XII" label="XII" />

														</form:select>
														<span class="help-block"></span>
													</div>
												</div>
											</div>
											<div class="col-md-5">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message
															code="FeeStructure.class_section" text="" /> </label>
													<div class="col-md-8">
														<form:select path="classSection" required="required" id="classSection" onchange="javaScript:getDetails();"
															class="form-control">
															<form:option value="None"
																label="--------------- Select------------------" />
															<form:option value="A" label="A" />
															<form:option value="B" label="B" />
															<form:option value="C" label="C" />
															<form:option value="D" label="D" />
															<form:option value="E" label="E" />
															<form:option value="F" label="F" />
															<form:option value="G" label="G" />
															<form:option value="H" label="H" />
															<form:option value="I" label="I" />


														</form:select>

													</div>
												</div>
											</div>
										</div>
										
										<c:if test="${!empty listClassStudent}">
						<table id="sample_3"
							class="table table-bordered table-striped table-condensed flip-content">
							<thead class="flip-content">
								<tr>
									<th><spring:message code="page.table.slno" text="" /></th>
									
									<th><spring:message code="Attendance.StudentId"
											text="" /></th>
									<th><spring:message code="Attendance.Name" text="" /></th>

									<th><spring:message code="Attendance.Present" text="" /></th>
									<th><spring:message code="Attendance.Absent" text="" /></th>
									<th><spring:message code="Attendance.Late" text="" /></th>
									<th><spring:message code="Attendance.Leave" text="" /></th>
									
									<th><spring:message code="page.table.action" text="" /></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${listClassStudent}" var="student"
									varStatus="status">
									<tr>
										<td>${status.count}</td>
									<td>${student.studentId}</td>
										<td>${student.firstName}
											${student.lastName}</td>
										
										<td><input type="radio"  name="${student.studentId}" value="present" checked="checked" ></td>
									<td><input type="radio"  name="${student.studentId}" value="absent"></td>
									<td><input type="radio"   name="${student.studentId}" value="late"></td>
										<td><input type="radio"   name="${student.studentId}" value="leave"></td>
										<td class="display-flex"><a href="javascript:;"
											data-original-title="View"
											class="tooltips btn btn-success btn-xs"> <i
												class="fa fa-eye"></i>
										</a>  </td>
									</tr>
								</c:forEach>
							</tbody>
									<tfoot>
				                            				<tr>
				                            					<th colspan="3" id="totalStudent"><spring:message code="Attendance.TotalStudent" text="" />: ${status.count}</th>
				                            					<th id="totalPresert"><spring:message code="Attendance.TotalPresent" text="" /> : ${status.count}</th>
				                            					<th id="totalAbsent"><spring:message code="Attendance.TotalAbsent" text="" />: 0</th>
				                            					<th id="totalLAte"><spring:message code="Attendance.TotalLate" text="" /> : 0</th>
				                            					<th id="totalLeave"><spring:message code="Attendance.TotalLeave" text="" /> : 0</th>
				                            					<th>
				                            						<button class="btn btn-danger btn-xs btn-block" type="button" >Reset</button>
				                            					
				                            						<button class="btn btn-success btn-xs btn-block" type="submit">Save</button>
				                            					</th>
				                            				</tr>
				                            			</tfoot>
						</table>
					</c:if>
										
										
										
										
										
										
										
										
										
										
										
										
										
										
									<div class="row margin-top-10">
											<div class="col-md-5 col-md-offset-1">
												<div class="row">
													<div class="col-md-offset-4 col-md-9">
														<button type="submit" class="btn btn-sm btn-success">
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


	
	
function getDetails(){
	//alert("message")
	 var URL = "/OnlineExam/attendanceStudent/getStudentAttendanceList/";
	var section = document.getElementById('classSection').value;
	var className = document.getElementById('className').value;
	// $('#fieldCount').val("1"); 
if(section != null && className != null)
	{
	id =className+"@"+section;
	//alert(id);
	URL = URL+id;
    window.location=URL;
	} 
}

</script>


<%@ include file="/WEB-INF/jsp/common/bottom.jsp"%>