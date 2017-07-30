<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ include file="/WEB-INF/jsp/common/top.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="page-content">
	<!-- BEGIN PAGE HEAD -->
	<div class="page-head">
		<!-- END PAGE TITLE -->
	</div>
	<!-- END PAGE HEAD -->
	<!-- BEGIN PAGE BREADCRUMB -->
	<ul
		class="page-breadcrumb breadcrumb breadcrumb-arrow breadcrumb-arrow">
		<li><a href="index.html"><spring:message code="page.home" text="" /></a></li>
		<li><a href="${pageContext.request.contextPath}/teacherGrade/showTeacherGrade"><spring:message code="TeacherGrade.Grade" text="" /></a></li>
	</ul>
	<!-- END PAGE BREADCRUMB -->

	<!-- BEGIN PAGE CONTENT INNER -->
	<div class="row margin-top-10">
		<div class="col-md-12">
			<!-- BEGIN SAMPLE TABLE PORTLET-->
			<div class="portlet box lightblue">
				<div class="portlet-title">
					<div class="caption">
						<i class="icon-map"></i><spring:message code="TeacherGrade.Grade" text="" />
					</div>
					<div class="actions">
						<a data-toggle="collapse" data-target="#addform"
							class="btn btn-danger btn-sm"><spring:message code="page.add" text="" />  <i class="fa fa-plus"></i>
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
								<form:form class="form-horizontal" commandName="teacherGrade"
									action="${pageContext.request.contextPath}/teacherGrade/saveTeacherGrade"
									method="post">
									<form:hidden path="id" />
									<form:hidden path="adminId.id" />
									<form:hidden path="schoolId.id" />
									<div class="form-body">
									<div class="row" style="color: red" id="errors"></div>
										<div class="row">
											<div class="col-md-8 col-md-offset-1">

												<div class="col-md-12">
													<div class="form-group">
														<label class="control-label col-md-4"><spring:message code="TeacherGrade.Grade" text="" /><span
															class="mandatory">* </span> </label>
														<div class="col-md-6">
															<form:input cssClass="form-control" path="teacherGradeValue"  id="teacherGradeValue" onchange="javaScript:getDetails();"
																title="Teacher Grade" placeholder="Class" />
															<span class="help-block"></span>
													
														</div>
													</div>
												</div>
												<div class="col-md-12">
													<div class="form-group">
														<label class="control-label col-md-4"><spring:message
																code="TeacherGrade.GradePay" text="" /></label>
														<div class="col-md-6">
															<form:input class="form-control date-picker" 
															id="gradePay"	path="gradePay" title="Enter the grade Pay"  onchange="javaScript:getClassName();"
																placeholder="Grade Pay" />
															<span class="help-block"></span>
														
														</div>
													</div>
												</div>
												<div class="col-md-12">
													<div class="form-group">
														<label class="control-label col-md-4"><spring:message
																code="TeacherGrade.RangeStart" text="" /></label>
														<div class="col-md-6">
															<form:input class="form-control date-picker"  
																path="salaryRangeStart" title="Enter the Start"
																placeholder="Salary Range Start" />
															<span class="help-block"></span>
															<form:errors path="salaryRangeStart" cssClass="error" />
														</div>
													</div>
												</div>
												<div class="col-md-12">
													<div class="form-group">
														<label class="control-label col-md-4"><spring:message
																code="TeacherGrade.RangeEnd" text="" /></label>
														<div class="col-md-6">
															<form:input class="form-control date-picker"  
																path="salaryRangeEnd" title="Enter the End"
																placeholder="Salary Range End" />
															<span class="help-block"></span>
															<form:errors path="salaryRangeEnd" cssClass="error" />
														</div>
													</div>
												</div>
												<div class="col-md-12">
													<div class="form-group">
														<label class="control-label col-md-4"><spring:message
																code="Teacher.description" text="" /></label>
														<div class="col-md-6">
															<form:textarea cssClass="form-control"
																path="gradedescription" title="Enter Description"
																placeholder="gradedescription" cols="70" rows="5" />
															<br> <span class="help-block"></span>
															<form:errors path="gradedescription" cssClass="error" />
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
					<c:if test="${!empty teacherGradeList}">
						<table id="sample_3"
							class="table table-bordered table-striped table-condensed">
							<thead class="bg-light-green">
								<tr>
									<th width="10%"><spring:message code="page.table.slno" text="" /></th>
									<th width="20%"><spring:message code="TeacherGrade.Grade" text="" /></th>
									<th width="20%"><spring:message code="TeacherGrade.GradePay" text="" /></th>
									<th width="20%"><spring:message code="TeacherGrade.RangeStart" text="" /></th>
									<th width="20%"><spring:message code="TeacherGrade.RangeEnd" text="" /></th>
									<th width="30%"><spring:message code="page.table.action" text="" /></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${teacherGradeList}" var="teacherGrade"
									varStatus="status">
									<tr>
										<td>${status.count}</td>
										<td>${teacherGrade.teacherGradeValue}</td>
												<td>${teacherGrade.gradePay}</td>
													<td>${teacherGrade.salaryRangeStart}</td>
													<td>${teacherGrade.salaryRangeEnd}</td>
										<td class="display-flex"><a
											href="${pageContext.request.contextPath}/teacherGrade/editTeacherGrade/${teacherGrade.id}"
											data-original-title="Edit"
											class="tooltips btn btn-success btn-xs"> <i
												class="fa fa-pencil"></i>
										</a> 
										 <a
											href="${pageContext.request.contextPath}/teacherGrade/deleteTeacherGrade/${teacherGrade.id}"
											data-original-title="Delete"
											class="tooltips btn btn-success btn-xs"> <i
												class="fa fa-button"></i><spring:message code="page.table.delete" text="" />
										</a>
										<c:if test="${teacherGrade.enabled}">
												<a
													href="${pageContext.request.contextPath}/teacherGrade/enableDisableTeacherGrade/${teacherGrade.id}/false"
													data-original-title="Click to Enable"
													class="tooltips btn btn-danger btn-xs"><spring:message code="page.table.enable" text="" /></a>
											</c:if> <c:if test="${!teacherGrade.enabled}">
												<a
													href="${pageContext.request.contextPath}/teacherGrade/enableDisableTeacherGrade/${teacherGrade.id}/true"
													data-original-title="Click to Disable"
													class="tooltips btn btn-success btn-xs"><spring:message code="page.table.disable" text="" /></a>
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



function getClassName(){
	
	var gradePay = document.getElementById('gradePay').value;
	//alert(className);
	if (gradePay == null)
		{
		document.getElementById('errors').innerHTML = "*Please enter Grade Pay*";
		}

	}
	
	


	
function getDetails(){
	
	var teacherGradeValue = document.getElementById('teacherGradeValue').value;
	
	if (teacherGradeValue == null)
		{
		document.getElementById('errors').innerHTML = "*Please enter Class*";
		return false;
		}
	else{
		$('#teacherGradeValue').val(teacherGradeValue.toUpperCase());
	}
	
	

}

</script>


<%@ include file="/WEB-INF/jsp/common/bottom.jsp"%>