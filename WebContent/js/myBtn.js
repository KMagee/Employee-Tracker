myBtn.addEventListener("click", function(){
   
	window.location.href='add-employee-form.jsp'; 
	return false
	
});


deleteLink.addEventListener("click", function() {
	
	if (!(confirm('Are you sure you want to delete this student?'))) 
		return false
	
	
} )

