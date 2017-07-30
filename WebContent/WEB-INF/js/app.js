/**
 * 
 */

// method for getting print page
function printDiv(divName) {
	var printContents = document.getElementById(divName).innerHTML;
	var originalContents = document.body.innerHTML;
	document.body.innerHTML = printContents;
	window.print();
	document.body.innerHTML = originalContents;
}

function isNumeric(expression) {
	var nums = "0123456789";
	if (expression.length==0)return(false);
		for (var n=0; n < expression.length; n++){
			if(nums.indexOf(expression.charAt(n))==-1)return(false);
		}
	return(true);
}



