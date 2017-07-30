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
		<li><a href="${pageContext.request.contextPath}/className/showClassName"><spring:message code="class.Name" text="" /></a></li>
	</ul>
	<!-- END PAGE BREADCRUMB -->

	<!-- BEGIN PAGE CONTENT INNER -->
	<div class="row margin-top-10">
		<div class="col-md-12">
			<!-- BEGIN SAMPLE TABLE PORTLET-->
			<div class="portlet box lightblue">
				<div class="portlet-title">
					<div class="caption">
						<i class="icon-map"></i><spring:message code="class.Name" text="" />
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
								<form:form class="form-horizontal" commandName="className"
									action="${pageContext.request.contextPath}/className/saveClassName"
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
															<form:input cssClass="form-control" path="classPresent"  id="classPresent" onchange="javaScript:getDetails();"
																title="Enter the class" placeholder="Class" />
															<span class="help-block"></span>
															<form:errors path="classPresent" cssClass="error" />
														</div>
													</div>
												</div>
												<div class="col-md-12">
													<div class="form-group">
														<label class="control-label col-md-4"><spring:message
																code="class.Namedescription" text="" /></label>
														<div class="col-md-6">
															<form:input class="form-control date-picker" 
															id="classNameValue"	path="classNameValue" title="Enter the Class Details"  onchange="javaScript:getClassName();"
																placeholder="class Name" />
															<span class="help-block"></span>
														
														</div>
													</div>
												</div>
												<div class="col-md-12">
													<div class="form-group">
														<label class="control-label col-md-4"><spring:message
																code="class.count" text="" /></label>
														<div class="col-md-6">
															<form:input class="form-control date-picker" 
																path="strength" title="Enter the end Date"
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
																path="Classdescription" title="Enter Description"
																placeholder="Description" cols="70" rows="5" />
															<br> <span class="help-block"></span>
															<form:errors path="Classdescription" cssClass="error" />
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
					<c:if test="${!empty classNameList}">
						<table id="sample_3"
							class="table table-bordered table-striped table-condensed">
							<thead class="bg-light-green">
								<tr>
									<th width="10%"><spring:message code="page.table.slno" text="" /></th>
									<th width="20%"><spring:message code="Class.NameValue" text="" /></th>
									<th width="20%"><spring:message code="class.Namedescription" text="" /></th>
									<th width="20%"><spring:message code="class.count" text="" /></th>
									<th width="30%"><spring:message code="page.table.action" text="" /></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${classNameList}" var="className"
									varStatus="status">
									<tr>
										<td>${status.count}</td>
										<td>${className.classPresent}</td>
												<td>${className.classNameValue}</td>
													<td>${className.strength}</td>
										<td class="display-flex"><a
											href="${pageContext.request.contextPath}/className/editClassName/${className.id}"
											data-original-title="Edit"
											class="tooltips btn btn-success btn-xs"> <i
												class="fa fa-pencil"></i>
										</a> <c:if test="${className.enabled}">
												<a
													href="${pageContext.request.contextPath}/className/editClassName/${className.id}/false"
													data-original-title="Click to Enable"
													class="tooltips btn btn-danger btn-xs"><spring:message code="page.table.enable" text="" /></a>
											</c:if> <c:if test="${!className.enabled}">
												<a
													href="${pageContext.request.contextPath}/className/editClassName/${className.id}/true"
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
	
	var classNameValue = document.getElementById('classNameValue').value;
	//alert(className);
	if (classNameValue == null)
		{
		document.getElementById('errors').innerHTML = "*Please enter Class Name*";
		}
	else{
		$('#classNameValue').val(classNameValue.toUpperCase());
	}
	
	

}
	
function getDetails(){
	
	var className = document.getElementById('classPresent').value;
	
	if (className == null)
		{
		document.getElementById('errors').innerHTML = "*Please enter Class*";
		return false;
		}
	else{
		$('#classPresent').val(className.toUpperCase());
	}
	
	

}

</script>


<%@ include file="/WEB-INF/jsp/common/bottom.jsp"%>