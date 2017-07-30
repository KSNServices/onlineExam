var Main = (function(){
	var addQuestionStatement = function(btn,insert_to,index){
		//some ajax goes here
		$.ajax({
			method:'GET',
			url:'add-question-paper-data.php?index='+index,
			success: function(data){
				$('#'+insert_to).append(data);
				$(btn).attr("onclick","Main.addQuestionStatement(this,'"+insert_to+"',"+(index+1)+")");
			}
		})
	}
	var addQuestionPaperSet = function(levelDropdown,update_to){
		//some ajax goes here
		$.ajax({
			method:'GET',
			url:'add-question-paper-set-data.php?level='+levelDropdown.value,
			success: function(data){
				$('#'+update_to).html('');
				$('#'+update_to).append(data);
			}
		})
	}
	var addQualificationDetail = function(btn,insert_to,index){
		//some ajax goes here
		$.ajax({
			method:'GET',
			url:'add-qualification-detail-data.php?index='+index,
			success: function(data){
				$('#'+insert_to).append(data);
				$(btn).attr("onclick","Main.addQualificationDetail(this,'"+insert_to+"',"+(index+1)+")");
			}
		});
	}
	var addAdditionalQualificationDetail = function(btn,insert_to,index){
		//some ajax goes here
		$.ajax({
			method:'GET',
			url:'add-additional-qualification-detail-data.php?index='+index,
			success: function(data){
				$('#'+insert_to).append(data);
				$(btn).attr("onclick","Main.addAdditionalQualificationDetail(this,'"+insert_to+"',"+(index+1)+")");
			}
		});
	}
	var addWorkExperienceDetail = function(btn,insert_to,index){
		//some ajax goes here
		$.ajax({
			method:'GET',
			url:'add-additional-qualification-detail-data.php?index='+index,
			success: function(data){
				$('#'+insert_to).append(data);
				$(btn).attr("onclick","Main.addAdditionalQualificationDetail(this,'"+insert_to+"',"+(index+1)+")");
			}
		});
	}
	var addWorkExperienceDetail = function(btn,insert_to,index){
		//some ajax goes here
		$.ajax({
			method:'GET',
			url:'add-work-experience-detail-data.php?index='+index,
			success: function(data){
				$('#'+insert_to).append(data);
				$(btn).attr("onclick","Main.addWorkExperienceDetail(this,'"+insert_to+"',"+(index+1)+")");
				ComponentsPickers.init();
			}
		});
	}

	return {
		addQuestionStatement: addQuestionStatement,
		addQuestionPaperSet: addQuestionPaperSet,
		addQualificationDetail: addQualificationDetail,
		addAdditionalQualificationDetail: addAdditionalQualificationDetail,
		addWorkExperienceDetail: addWorkExperienceDetail
	}
})();