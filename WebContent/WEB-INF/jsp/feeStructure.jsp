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
		<li><a href="${pageContext.request.contextPath}/fee/feeStructure"><spring:message code="FeeStructure.FeeStructure1" text="" /></a></li>
	</ul>
	<!-- END PAGE BREADCRUMB -->

	<!-- BEGIN PAGE CONTENT INNER -->
	<div class="row margin-top-10">
		<div class="col-md-12">
			<!-- BEGIN SAMPLE TABLE PORTLET-->
			<div class="portlet box lightblue">
				<div class="portlet-title">
					<div class="caption">
						<i class="fa fa-cogs"></i><spring:message code="user.manage.FeeStr" text="" />
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
								<form:form class="form-horizontal" commandName="feeStructure"
									action="${pageContext.request.contextPath}/fee/saveFeeStructure"
									method="post" enctype="multipart/form-data">								
									<form:hidden path="id" />
									<form:hidden path="adminId.id" />
									<form:hidden path="schoolId.id" />
									<form:hidden path="count" id="fieldCount" />
									<input type="hidden" name="feeAmountValue" id="feeAmountValue"/>
						
									<div class="form-body">
										<div class="row">
											<div class="col-md-5 col-md-offset-1">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message
															code="FeeStructure.class" text="" /></label>
													<div class="col-md-8">
														<form:select path="className" required="required" id="className"  onchange="javaScript:getclassSectionList();" 
															class="form-control">
															<form:option value="None"
																label="--------------- Select ------------------" />
															<c:forEach items="${classNameList}" var="className" varStatus="status">
									
																	<form:option value="${className.classPresent}"/>
														</c:forEach>

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
																 <c:forEach items="${classSectionList}" var="classSection" varStatus="status">
									
																	<form:option value="${classSection.classSectionValue}"/>
														</c:forEach> 


														</form:select>

													</div>
												</div>
											</div>
										</div>

										<div class="row">
											<div class="col-md-5 col-md-offset-1">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message
															code="FeeStructure.stream" text="" /><span
														class="astrek" style="color: red"> * </span></label>
													<div class="col-md-8">
														<form:input id="stream" path="stream" class="form-control"
															type="text" required="required" />
														<span class="help-block"></span>
													</div>
												</div>
											</div>
											
										</div>




										<div class="row">
											<div class="col-md-5  col-md-offset-1">
												<div class="form-group">
													<label class="control-label col-md-4"> <spring:message
															code="FeeStructure.fee_component" text="" /><span
														class="astrek" style="color: red"> * </span></label>
													<div class="col-md-8">
														<form:input id="feeComponent" path="feeComponent"
															class="form-control" type="text" required="required" />
														<span class="help-block"></span>
													</div>
												</div>
											</div>
											<div class="col-md-5">
												<div class="form-group">
													<label class="control-label col-md-4"><spring:message
															code="FeeStructure.amount" text=""  /><span
														class="astrek" style="color: red"> * </span></label>
													<div class="col-md-8">
														<form:input id="amount" path="amount" class="form-control"
															type="text" required="required"/>
														<span class="help-block"></span>
													</div>
												</div>
											</div>
										</div>
										
										
										
										<div id="addnewDiv">
											
										</div>
								
										<div class="row margin-top-10 col-md-offset-5">
											<div class="col-md-5 col-md-offset-5">
												<div class="row">
													<div class="col-md-4">
														<button type="button" class="btn btn-sm btn-primary" id="addFieldFee">
														<spring:message
																code="page.addnewFee" text="" /></button>
													</div>
													<div class="col-md-4 pull-right">
														<button type="button" class="btn btn-sm btn-primary" id="removeFieldFee">
														<spring:message
																code="page.removelastFee" text="" /></button>
													</div>
												</div>
											</div>
										
										</div>
										
										
										
										
										
										
										<div class="row margin-top-10">
											<div class="col-md-5 col-md-offset-1">
												<div class="row">
													<div class="col-md-offset-4 col-md-9">
														<button type="submit" class="btn btn-sm btn-success" id="submit" onclick="javaScript:myFunction();" >
														<spring:message
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
					<c:if test="${!empty listFeeStructure}">
						<table id="sample_3"
							class="table table-bordered table-striped table-condensed flip-content">
							<thead class="flip-content">
								<tr>
									<th><spring:message code="page.table.slno" text="" /></th>
								
									<th><spring:message code="FeeStructure.class" text="" /></th>
									<th><spring:message code="FeeStructure.class_section" text="" /></th>
									
									<th><spring:message code="FeeStructure.stream" text="" /></th>
									<th><spring:message code="FeeStructure.fee_component" text="" /></th>
									<th><spring:message code="FeeStructure.amount" text="" /></th>
									<th><spring:message code="page.table.action" text="" /></th>		
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${listFeeStructure}" var="feeStructure" varStatus="status">
									<tr>
										<td>${status.count}</td>
									
										<td>${feeStructure.className}</td>
										<td>${feeStructure.classSection}</td>
										<td>${feeStructure.stream}</td>
										<td>${feeStructure.feeComponent}</td>
										<td>${feeStructure.amount}</td>
										<td class="display-flex"><a href="javascript:;"
											data-original-title="View"
											class="tooltips btn btn-success btn-xs"> <i
												class="fa fa-eye"></i>
										</a> <a
											href="${pageContext.request.contextPath}/fee/editFeeComponent/${feeStructure.id}"
											data-original-title="Edit"
											class="tooltips btn btn-success btn-xs"> <i
												class="fa fa-pencil"></i>
										</a> 
										 <a
											href="${pageContext.request.contextPath}/fee/deleteFeeComponent/${feeStructure.id}"
											data-original-title="Delete"
											class="tooltips btn btn-success btn-xs"> <i
												class="fa fa-button"></i><spring:message code="page.table.delete" text="" />
										</a><c:if test="${feeStructure.enabled}">
												<a
													href="${pageContext.request.contextPath}/fee/enableDisableFee/${feeStructure.id}/false"
													data-original-title="Click to Disable"
													class="tooltips btn btn-danger btn-xs"><i
													class="fa fa-toggle-off" aria-hidden="true"></i><spring:message code="page.table.disable" text="" /></a>
											</c:if> <c:if test="${!feeStructure.enabled}">
												<a
													href="${pageContext.request.contextPath}/fee/enableDisableFee/${feeStructure.id}/true"
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


<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>

<script type="text/javascript">






$(function() {
  var count=1;
$('#addFieldFee').click(function(){
count++;
  var rows='<div class="row">';   
  var div1=' <div class="col-md-5  col-md-offset-1"><div class="form-group"><label class="control-label col-md-4">   Fee Component <spanclass="astrek" style="color: red"> * </span></label><div class="col-md-8"><input id="ComponentValue_'+count+'" path="feeComponent"class="form-control" type="text" required="required" /><span class="help-block"></span></div></div></div>';
  var div2=' <div class="col-md-5 "><div class="form-group"><label class="control-label col-md-4"> Amount<spanclass="astrek" style="color: red"> * </span></label><div class="col-md-6"><input id="amount_'+count+'" path="amount"class="form-control" type="text" required="required"  /><span class="help-block"></span></div></div></div>';
  
var rowEnd='</div>';
  $('#addnewDiv').append(rows,div1,div2,rowEnd);
 $('#fieldCount').val(count); 
 // alert(count);removeFieldFee
});



});
 
 
$( ".classSection" ).change(function() {
	  alert( "Handler for .change() called." );
	});
 
$(function() {
	 
	$('#removeFieldFee').click(function(){
	//alert("remove");
	 //var rows='<div class="row">';
	//  var div1=' <div class="col-md-5  col-md-offset-1"><div class="form-group"><label class="control-label col-md-4">   Fee Component <spanclass="astrek" style="color: red"> * </span></label><div class="col-md-8"><input id="ComponentValue_'+count+'" path="feeComponent"class="form-control" type="text" required="required" /><span class="help-block"></span></div></div></div>';
	//  var div2=' <div class="col-md-5 "><div class="form-group"><label class="control-label col-md-4"> Amount<spanclass="astrek" style="color: red"> * </span></label><div class="col-md-6"><input id="amount_'+count+'" path="amount"class="form-control" type="text" required="required"  /><input id="check_'+count+'" path="enable" class="form-control" type="checkbox"   /><span class="help-block"></span></div></div></div>';
	  
	//var rowEnd='</div>';
	
	
	  //$('#addnewDiv').deleteRow(rows,div1,div2,rowEnd);
	   //count--;

        $("#TextBoxDiv" + count).remove();


	    
	 $('#fieldCount').val(count); 
	 // alert(count);removeFieldFee
	});



	});
	 








function myFunction (){

	var count =document.getElementById("fieldCount").value;
	var compVal=document.getElementById("feeComponent").value;
	var amountVAl=document.getElementById("amount").value;
	
	var feeamount =compVal+"/"+amountVAl;

	for(var i = 2; i <= count; i++) 
	 {
	
		var comp=document.getElementById("ComponentValue_"+i).value;
		var amount=document.getElementById("amount_"+i).value;
	

		//alert(comp+"+"+amount+"+"+compVal+"+"+amountVAl);
		if(compVal!=null&&compVal!="")
			{
			
			if(amountVAl!=null&&amountVAl!="")
				{
				 /* $('#feeComponent').val(compVal+"/"+comp);
				  $('#amount').val(amountVAl+'/'+amount); */
				feeamount =feeamount+"#"+ comp+"/"+amount;
				}
			}
	 }
	
	
	$('#feeAmountValue').val(feeamount);
	}
	
	
	
	
function getDetails(){
	//alert("message")
	var URL = "/OnlineExam/fee/getStudentFeesList/";
	var section = document.getElementById('classSection').value;
	var className = document.getElementById('className').value;
	 $('#fieldCount').val("1"); 
if(section != null && className != null)
	{
	id =className+"@"+section;
	//alert(id);
	URL = URL+id;
    window.location=URL;
	}
}






function getclassSectionList(){

	var URL = "/OnlineExam/fee/getclassSectionList/";
	var className = document.getElementById('className').value;
	
	//alert(className);
	
	
	
if(className != 0 )
	{
	id =className;
//	classSectionValue
	URL = URL+id;
    window.location=URL;
    //alert(URL)
	} 
}

</script>




<%@ include file="/WEB-INF/jsp/common/bottom.jsp"%>