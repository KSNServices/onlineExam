<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!-- BEGIN SIDEBAR -->
<security:authorize access="isAuthenticated()">
	<div class="page-sidebar-wrapper">
		<div class="page-sidebar md-shadow-z-2-i  navbar-collapse collapse">
			<!-- BEGIN SIDEBAR MENU -->
			<ul class="page-sidebar-menu " data-keep-expanded="false"
				data-auto-scroll="true" data-slide-speed="200">
				<li class="start active "><a
					href="${pageContext.request.contextPath}/showHomePanel"> <i
						class="icon-home"></i> <span class="title"><spring:message
								code="menu.dashboard" text="" /></span>
				</a></li>
				<security:authorize access="hasRole('ROLE_SUPER_ADMIN')">
					<li><a href="javascript:;"> <i class="icon-rocket"></i> <span
							class="title"><spring:message code="menu.masters" text="" /></span>
							<span class="arrow "></span>
					</a>
						<ul class="sub-menu">
							<li><a
								href="${pageContext.request.contextPath}/global/manageCountry">
									<i class="icon-map"></i>
								<spring:message code="menu.country" text="" />
							</a></li>
							<li><a
								href="${pageContext.request.contextPath}/global/manageState">
									<i class="icon-directions"></i>
								<spring:message code="menu.state" text="" />
							</a></li>
							<li><a
								href="${pageContext.request.contextPath}/global/manageCity">
									<i class="icon-direction"></i>
								<spring:message code="menu.city" text="" />
							</a></li>
							<li><a
								href="${pageContext.request.contextPath}/paymentPlan/managePaymentPlan">
									<i class="icon-tag"></i>
								<spring:message code="menu.paymentplans" text="" />
							</a></li>
							<li><a
								href="${pageContext.request.contextPath}/categories/manageCategories">
									<i class="icon-tag"></i>
								<spring:message code="menu.categories" text="" />
							</a></li>
						</ul></li>
					<li><a
						href="${pageContext.request.contextPath}/user/manageUsers"> <i
							class="icon-user"></i> <span class="title"><spring:message
									code="menu.ManageAdmin" text="" /></span>
					</a></li>
				</security:authorize>
				<security:authorize access="hasRole('ROLE_ADMIN')">
					<li><a href="javascript:;"> <i class="icon-rocket"></i> <span
							class="title"><spring:message code="menu.masters" text="" /></span> <span class="arrow "></span>
					</a>
						<ul class="sub-menu">
							<li><a
								href="${pageContext.request.contextPath}/academicYear/manageAcademicYear">
									<i class="icon-map"></i>
								<spring:message code="menu.AcademicYear" text="" />
							</a></li>
							
							
							
						</ul></li>
						
						
						
						
						<li><a href="#"> <i class="fa fa-sitemap"></i> <span
							class="title"><spring:message code="menu.Recruitment"
									text="" /></span> <span class="arrow "></span>
					</a>
						<ul class="sub-menu">
							<li><a
								href="${pageContext.request.contextPath}/rm/manageRecruitment">
									<i class="icon-map"></i>
								<spring:message code="menu.RecruitmentMaster" text="" />
							</a></li>

							<li><a
								href="${pageContext.request.contextPath}/oeLevel/manageExamLevel">
									<i class="icon-map"></i>
								<spring:message code="menu.OnlineExamLevel" text="" />
							</a></li>
							<li><a
								href="${pageContext.request.contextPath}/oeSubject/manageExamSubject">
									<i class="icon-map"></i>
								<spring:message code="menu.OnlineExamSubjects" text="" />
							</a></li>
							<li><a
								href="${pageContext.request.contextPath}/rq/manageRecruitmentQuestions">
									<i class="icon-map"></i>
								<spring:message code="menu.OnlineExamQuestions" text="" />
							</a></li>
							<li><a
								href="${pageContext.request.contextPath}/recruitmentSets/manageExamQuestionSets">
									<i class="icon-map"></i>
								<spring:message code="menu.OnlineExamQuestionsSet" text="" />
							</a></li>
						</ul></li>
					<li><a href="#"> <i class="fa fa-users"></i> <span
							class="title"><spring:message
									code="menu.ApplicantManagement" text="" /></span> <span
							class="arrow "></span>
					</a>
						<ul class="sub-menu">
							<li><a
								href="${pageContext.request.contextPath}/applicant/manageApplicant">
									<i class="fa fa-user"></i>
								<spring:message code="menu.ManageApplicant" text="" />
							</a></li>
						</ul></li>
						<li><a
						href="${pageContext.request.contextPath}/schoolUser/schoolAdminLogin"> <i
							class="icon-user"></i> <span class="title"><spring:message
									code="menu.ManageSchoolAdmin" text="" /></span>
					</a></li>
				</security:authorize>
				
				
				
				
				
				<security:authorize access="hasRole('ROLE_SCHOOL_ADMIN')">
					<li><a href="javascript:;"> <i class="icon-rocket"></i> <span
							class="title"><spring:message code="menu.masters" text="" /></span>
							<span class="arrow "></span>
					</a>
						<ul class="sub-menu">
							<li><a
								href="${pageContext.request.contextPath}/academicYear/manageAcademicYear">
									<i class="icon-map"></i>
								<spring:message code="menu.AcademicYear" text="" />
							</a></li>
							<li><a
								href="${pageContext.request.contextPath}/className/showClassName">
									<i class="icon-map"></i>
								<spring:message code="menu.ClassName" text="" />
							</a></li>
						<li>	<a
								href="${pageContext.request.contextPath}/classSectionValue/showClassSection">
									<i class="icon-map"></i>
								<spring:message code="menu.ClassSection" text="" />
							</a>
							</li>
							<li>	<a
								href="${pageContext.request.contextPath}/teacherGrade/showTeacherGrade">
									<i class="icon-map"></i>
								<spring:message code="menu.TeacherGrade" text="" />
							</a>
							</li>
						</ul></li>
						<li><a href="javascript:;"> <i class="icon-rocket"></i> <span
							class="title"><spring:message code="menu.Schedule" text="" /></span> <span class="arrow "></span>
					</a>
						<ul class="sub-menu">
							<li><a
								href="${pageContext.request.contextPath}/classSchedule/classTimeTable">
									<i class="icon-map"></i>
								<spring:message code="menu.ClassSchedule" text="" />
							</a></li>
							<li><a
								href="${pageContext.request.contextPath}/examSchedule/examTimeTable">
									<i class="icon-map"></i>
								<spring:message code="menu.ExamSchedule" text="" />
							</a></li>
							<li><a
								href="${pageContext.request.contextPath}/staffTable/staffDetail">
									<i class="icon-map"></i>
								<spring:message code="menu.StaffTable" text="" />
							</a></li>
							
						</ul></li>
						
						
						
						
						<li><a href="javascript:;"> <i class="icon-rocket"></i> <span
							class="title"><spring:message code="menu.teacher" text="" /></span> <span class="arrow "></span>
					</a>
						<ul class="sub-menu">
							<li><a
								href="${pageContext.request.contextPath}/teacher/teacherDetail">
									<i class="icon-map"></i>
								<spring:message code="menu.teacherForm" text="" />
								
							</a></li>
							<li><a
								href="${pageContext.request.contextPath}/attendanceStudent/attendance">
									<i class="icon-map"></i>
								<spring:message code="menu.attendanceDetails" text="" />
							</a></li>
						
							
						</ul></li>
						
						
						
						<li><a href="javascript:;"> <i class="icon-rocket"></i> <span
							class="title"><spring:message code="menu.salary" text="" /></span> <span class="arrow "></span>
					</a>
						<ul class="sub-menu">
								<li><a
								href="${pageContext.request.contextPath}/salary/salaryStructure">
									<i class="icon-map"></i>
								<spring:message code="menu.SalaryStructure" text="" />
							</a></li>
							
								<li><a
								href="${pageContext.request.contextPath}/additionalSalary/additionalSalaryDetails">
									<i class="icon-map"></i>
								<spring:message code="menu.AdditionalSalaryStructure" text="" />
							</a></li>
							
							<li><a
								href="${pageContext.request.contextPath}/teacherSalary/teacherSalaryInformation">
									<i class="icon-map"></i>
								<spring:message code="menu.TeacherSalaryDetail" text="" />
							</a></li>
							<li><a
								href="${pageContext.request.contextPath}/teacherPayment/teacherPayementInformation">
									<i class="icon-map"></i>
								<spring:message code="menu.TeacherPaymentDetail" text="" />
							</a></li>
						</ul></li>
						
						
						
						
						
						
						
						
						
						
						<li><a href="javascript:;"> <i class="icon-rocket"></i> <span
							class="title"><spring:message code="menu.student" text="" /></span> <span class="arrow "></span>
					</a>
						<ul class="sub-menu">
							<li><a
								href="${pageContext.request.contextPath}/student/admissionForm">
									<i class="icon-map"></i>
								<spring:message code="menu.Admission" text="" />
							</a></li>
							<li><a
								href="${pageContext.request.contextPath}/studentForm/studentDetail">
									<i class="icon-map"></i>
								<spring:message code="menu.studentForm" text="" />
							</a></li>
						</ul></li>
						
						
					
						
						<li><a href="javascript:;"> <i class="icon-rocket"></i> <span
							class="title"><spring:message code="menu.fee" text="" /></span> <span class="arrow "></span>
					</a>
						<ul class="sub-menu">
							<li><a
								href="${pageContext.request.contextPath}/fee/feeStructure">
									<i class="icon-map"></i>
								<spring:message code="menu.feeStr1" text="" />
							</a></li>
							
							<li><a
								href="${pageContext.request.contextPath}/feeDetail/studentFeeInformation">
									<i class="icon-map"></i>
								<spring:message code="menu.feeForm" text="" />
							</a></li>
							
							<li><a
								href="${pageContext.request.contextPath}/paymentDetail/studentPaymentInformation">
									<i class="icon-map"></i>
								<spring:message code="menu.Payment" text="" />
							</a></li>
						</ul></li>
						
							
						<li><a href="javascript:;"> <i class="icon-rocket"></i> <span
							class="title"><spring:message code="menu.miscellaneous" text="" /></span> <span class="arrow "></span>
					</a>
						<ul class="sub-menu">
							<li><a
								href="${pageContext.request.contextPath}/extraActivities/extraActi">
									<i class="icon-map"></i>
								<spring:message code="menu.extraAct" text="" />
							</a></li>
							<li><a
								href="${pageContext.request.contextPath}/extraExpenditure/extraExp">
									<i class="icon-map"></i>
								<spring:message code="menu.extraExp" text="" />
							</a></li>
						</ul></li>
						
						
						
						
						
						<li><a href="#"> <i class="fa fa-sitemap"></i> <span
							class="title"><spring:message code="menu.Recruitment"
									text="" /></span> <span class="arrow "></span>
					</a>
						<ul class="sub-menu">
							<li><a
								href="${pageContext.request.contextPath}/rm/manageRecruitment">
									<i class="icon-map"></i>
								<spring:message code="menu.RecruitmentMaster" text="" />
							</a></li>

							<li><a
								href="${pageContext.request.contextPath}/oeLevel/manageExamLevel">
									<i class="icon-map"></i>
								<spring:message code="menu.OnlineExamLevel" text="" />
							</a></li>
							<li><a
								href="${pageContext.request.contextPath}/oeSubject/manageExamSubject">
									<i class="icon-map"></i>
								<spring:message code="menu.OnlineExamSubjects" text="" />
							</a></li>
							<li><a
								href="${pageContext.request.contextPath}/rq/manageRecruitmentQuestions">
									<i class="icon-map"></i>
								<spring:message code="menu.OnlineExamQuestions" text="" />
							</a></li>
							<li><a
								href="${pageContext.request.contextPath}/recruitmentSets/manageExamQuestionSets">
									<i class="icon-map"></i>
								<spring:message code="menu.OnlineExamQuestionsSet" text="" />
							</a></li>
						</ul></li>
						
						<li><a href="#"> <i class="fa fa-users"></i> <span
							class="title"><spring:message
									code="menu.ApplicantManagement" text="" /></span> <span
							class="arrow "></span>
					</a>
						<ul class="sub-menu">
							<li><a
								href="${pageContext.request.contextPath}/applicant/manageApplicant">
									<i class="fa fa-user"></i>
								<spring:message code="menu.ManageApplicant" text="" />
							</a></li>
						</ul></li>
						
					<li><a href="#"> <i class="fa fa-users"></i> <span
							class="title"><spring:message
									code="menu.ApplicantManagement" text="" /></span> <span
							class="arrow "></span>
					</a></li>
					
					
					
					
					
					
					<li><a href="#"> <i class="fa fa-sitemap"></i> <span
							class="title"><spring:message code="menu.ManaageAdmin"
									text="" /></span> <span class="arrow "></span>
					</a>
						<ul class="sub-menu">
							<li><a
								href="${pageContext.request.contextPath}/studentUser/studentAdminLogin"> <i
							class="icon-user"></i> <span class="title"><spring:message
									code="menu.ManageStudentAdmin" text="" /></span>
							</a></li>

							<li><a
								href="${pageContext.request.contextPath}/teacherUser/teacherAdminLogin"> <i
							class="icon-user"></i> <span class="title"><spring:message
									code="menu.ManageteacherAdmin" text="" /></span>
							</a></li>
							<li><a
								href="${pageContext.request.contextPath}/parentUser/parentAdminLogin"> <i
							class="icon-user"></i> <span class="title"><spring:message
									code="menu.ManageparentAdmin" text="" /></span>
							</a></li>
							
						</ul></li>
					
					
					
					
					
				
			</security:authorize>
				
				
				
				
				
				
				
				<security:authorize access="hasRole('PARENT')">
					<li><a href="javascript:;"> <i class="icon-rocket"></i> <span
							class="title"><spring:message code="menu.masters" text="" /></span>
							<span class="arrow "></span>
					</a></li>

				</security:authorize>
				<security:authorize access="hasRole('STUDENT')">
					<li><a href="javascript:;"> <i class="icon-rocket"></i> <span
							class="title"><spring:message code="menu.masters" text="" /></span>
							<span class="arrow "></span>
					</a></li>
				</security:authorize>

			</ul>
			<!-- END SIDEBAR MENU -->
		</div>
	</div>
</security:authorize>
<!-- END SIDEBAR -->