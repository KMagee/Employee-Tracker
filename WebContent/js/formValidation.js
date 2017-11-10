validateFirstName = ()=>{
    // username must be a between 3 and 12 characters
    if( firstName.value.length < 3 || firstName.value.length > 12 ){
        // show the error message
    	msgUsernameError.setAttribute('class', 'showError')
       // ussernameFlag = false
    } else {
        // hide the error message
    	msgUsernameError.setAttribute('class', 'hideError')
    //    usernameFlag = true
    }
}

firstName.addEventListener('blur', validateFirstName)
