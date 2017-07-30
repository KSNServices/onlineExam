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
		<li><a href="${pageContext.request.contextPath}/classSectionValue/showClassSection"><spring:message code="class.section" text="" /></a></li>
	</ul>
	<!-- END PAGE BREADCRUMB -->

	<!-- BEGIN PAGE CONTENT INNER -->
	<div class="row margin-top-10">
		<div class="col-md-12">
			<!-- BEGIN SAMPLE TABLE PORTLET-->
			<div class="portlet box lightblue">
				<div class="portlet-title">
					<div class="caption">
						<i class="icon-map"></i><spring:message code="class.section" text="" />
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
								<form:form class="form-horizontal" commandName="classSection"
									action="${pageContext.request.contextPath}/classSectionValue/saveClassSection"
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
														<label class="control-label col-md-4"><spring:message code="Class.NameValue" text="" /><span
															class="mandatory">* </span> </label>
														<div class="col-md-6">
															
															
															
															<form:select cssClass="form-control" path="classPresent" required="required"  id="classPresent" onchange="javaScript:getDetails();"
															class="help-block">
															<form:option value="0"
																label="--------------- Select------------------" />
															
															
															
															
															
															
															<c:forEach items="${classNameList}" var="className" varStatus="status">
									
																	<form:option value="${className.classPresent}"/>
														</c:forEach>
															
															</form:select>
															
															
														</div>
													</div>
												</div>
												<div class="col-md-12">
													<div class="form-group">
														<label class="control-label col-md-4"><spring:message
																code="class.NameSection" text="" /></label>
														<div class="col-md-6">
															<form:input class="form-control date-picker"  
																path="classSectionValue" id="classSectionValue" title="Enter the Class Details" onchange="javaScript:getSection();" 
																placeholder="class Section" />
															<span class="help-block"></span>
															
														</div>
													</div>
												</div>
												<div class="col-md-12">
													<div class="form-group">
														<label class="control-label col-md-4"><spring:message
																code="class.count" text="" /></label>
														<div class="col-md-6">
															<form:input class="form-control date-picker" id="strength" onchange="javaScript:getCount();" 
																path="strength"  title="Enter the end Date"
																placeholder="Class Count" />
															<span class="help-block"></span>
															<form:errors path="strength" cssClass="error" />
														</div>
													</div>
												</div>
												<div class="col-md-12">
													<div class="form-group">
														<label class="control-label col-md-4"><spring:message
																code="page.description" text="" /></label>
														<div class="col-md-6">
															<form:textarea cssClass="form-control"
																path="sectionDescription" title="Enter Description"
																placeholder="Description" cols="70" rows="5" />
															<br> <span class="help-block"></span>
															<form:errors path="sectionDescription" cssClass="error" />
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
					<c:if test="${!empty listClassSection}">
						<table id="sample_3"
							class="table table-bordered table-striped table-condensed">
							<thead class="bg-light-green">
								<tr>
									<th width="10%"><spring:message code="page.table.slno" text="" /></th>
									<th width="20%"><spring:message code="Class.NameValue" text="" /></th>
									<th width="20%"><spring:message code="class.NameSection" text="" /></th>
									
									<th width="20%"><spring:message code="class.count" text="" /></th>
									<th width="30%"><spring:message code="page.table.action" text="" /></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${listClassSection}" var="classSection"
									varStatus="status">
									<tr>
										<td>${status.count}</td>
										<td>${classSection.classPresent}</td>
												<td>${classSection.classSectionValue}</td>
													<td>${classSection.strength}</td>
										<td class="display-flex"><a
											href="${pageContext.request.contextPath}/classSectionValue/editClassSection/${classSection.id}"
											data-original-title="Edit"
											class="tooltips btn btn-success btn-xs"> <i
												class="fa fa-pencil"></i>
										</a> </td>
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


function getSection(){

	var classPresent = document.getElementById('classPresent').value;
	var classSection = document.getElementById('classSectionValue').value;
	alert(classSection.toUpperCase());
if(classPresent == 0 )
	{
	document.getElementById('errors').innerHTML = "*Please enter Class*";
	return false;
	}
else
$('#classSectionValue').val(classSection.toUpperCase());
}


function getCount(){
	//alert("message")
	//var URL = "/OnlineExam/classSectionValue/getClassSectionsList/";
	var classPresent = document.getElementById('classPresent').value;
	var classSection = document.getElementById('classSectionValue').value;
	//alert(classSection);
if(classPresent == null )
	{
	document.getElementById('errors').innerHTML = "*Please enter Class*";
	return false;
	}
 else if (classSection == null)
	{
	document.getElementById('errors').innerHTML = "*Please enter Class Section*";
	return false
	} 
else
	{
	$('#classSectionValue').val(classSection.toUpperCase());
	}
}

	
function getDetails(){
	//alert("message")
	var URL = "/OnlineExam/classSectionValue/getClassSectionsList/";
	var section = document.getElementById('classPresent').value;
	//alert(section)
if(section != null )
	{
	id =section;
	//alert(id);
	URL = URL+id;
    window.location=URL;
    //alert(URL)
	}
}

</script>




<%@ include file="/WEB-INF/jsp/common/bottom.jsp"%>