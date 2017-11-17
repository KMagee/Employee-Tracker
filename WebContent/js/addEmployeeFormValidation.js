
//start with only first name enabled
document.getElementById('lastName').disabled = "disabled";
document.getElementById('email').disabled = "disabled";
document.getElementById('department').disabled = "disabled";
document.getElementById('saveBtn').disabled = "disabled";


//declare  flags
let firstNameFlag = false
let lastNameFlag = false
let emailFlag = false
let departmentFlag=false



//validate first name, if not null, and 
//username must be a between 3 and 20 alhpabetic characters
validateFirstName = ()=>{

var letters = /^[A-Za-z]+$/;  
    	
if(!firstName.value.match(letters) 
		|| firstName.value.lenghth===0 
		||firstName.value.length < 3 
		|| firstName.value.length > 20 ){
  // show the error message
	msgUsernameError.setAttribute('class', 'showError')
	firstNameFlag=false
	validateForm()
	
} else {
	
	firstNameFlag=true
	validateForm()
  // hide the error message
	msgUsernameError.setAttribute('class', 'hideError')
	document.getElementById('lastName').disabled = false;
	document.getElementById("lastName").focus();
	
}
}

firstName.addEventListener('blur', validateFirstName)



//validate last name

//lastNameError id
//lastName

validateLastName = () => {
	var letters = /^[A-Za-z]+$/;
	
	//only alphabetic characters, not null, between 3 and 20 chars
	
	if(!lastName.value.match(letters) || 
			lastName.value.length===0 || 
			lastName.value.length < 3 || 
			lastName.value.length > 20){
		
		//show the error message in the span
		
		msgLastNameError.setAttribute('class', 'showError')	
					
		lastNameFlag=false
		validateForm()
		
	} else {
		
		lastNameFlag=true
		validateForm()
		  // hide the error message and move to the next field
		msgLastNameError.setAttribute('class', 'hideError');
		document.getElementById('email').disabled = false;
		document.getElementById("email").focus();
		
			
	}

}


//create lastName listener
lastName.addEventListener('blur', validateLastName)



//validate email address
// email must end @avaya.com
//can contain only alphanumeric chars

validateEmail = () => {
	
	var validEmail = /^[a-zA-Z0-9_.]+@avaya.com$/;
	
	if (!email.value.match(validEmail) ||
		email.value===" "){
		
		msgEmailError.setAttribute('class', 'showError')
		emailFlag=false
		validateForm()
		
	} else {
		
		emailFlag=true
		validateForm()
		msgEmailError.setAttribute('class', 'hideError')
		document.getElementById('department').disabled = false
		document.getElementById('department').focus()
		
	}
	
}

//create eventlistener for email

email.addEventListener('blur', validateEmail)


validateDepartment = () =>{
	
	if(department.value === "SelectOption"){
		//print error
		
		msgDepartmentError.setAttribute('class', 'showError')
		departmentFlag=false
		validateForm()
		
	} else {
		departmentFlag=true
		validateForm()
		msgDepartmentError.setAttribute('class', 'hideError')
		document.getElementById('saveBtn').focus()
	}
	
}

department.addEventListener('blur', validateDepartment)


validateForm = () =>{
	
	if (firstNameFlag == true && lastNameFlag == true && emailFlag == true && departmentFlag==true ){
		
		document.getElementById('saveBtn').disabled = false;
	} else {
		document.getElementById('saveBtn').disabled =  "disabled";
		
	}	
}




