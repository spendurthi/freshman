var borderColor_error = '#F00';
var borderColor_noError = '#7F9DB9';
$(document).ready(function () {	
	
	$('.loginActions').click(function(e){
		var $formId = $(this).parents('form');
		removEerrMsg();
		if(validateForm($formId,e)== true){
			return true;
		}else{			
			e.preventDefault();
		}
	});
	
});

function validateForm(formObject,eventObject){
	var $formObject = $(formObject);
	var rtnValue = formValidations($formObject);
	if (rtnValue){
		return true;
	}else{
		eventObject.preventDefault();
	}
}
function formValidations($formObject) {
	var errMsg = new Array();    
    var rtnValid = true;
    if (itemValidations($formObject, errMsg) == false) {
    	rtnValid = false;
   	}
    if (rtnValid == false) {
        showErrMsg(null, errMsg);        
    }
    if(rtnValid == true){
		removEerrMsg();
	}
    return rtnValid;
}
function itemValidations($formObject, errMsg) {
    var rtnValid = true;
    $($formObject).find(':input:not(button)').each(function () {
        $this = $(this);    
        inputValid = fieldValidations(this, errMsg);
        if (inputValid == false) {
        	rtnValid = false;
         }       
    });    
    return rtnValid;
}

function fieldValidations(input, errMsg){

	$input = $(input);
	var rtnValue = true;
	var inputVal = '';
	var fieldType = '';
	var eleId;
    var classVal = $input.attr('class');
    var isValid=true;
    
    if ($input.is(':text')) {    	
    	inputVal = $input.val();
    	eleId = input.id;
    	fieldType = 'TEXT';
    }
    if ($input.is(':password')) {
    	inputVal = $input.val();
    	eleId = input.id;
    	fieldType = 'TEXT';
    }
    if ($input.is(':radio')) {
    	var radioEle = $("input[name=" + input.name + "]");
    	$.each(radioEle,function(){
    		if(this.checked == true)
    			inputVal = this.value;
    	});
  	
        var eleName = $input.attr('name');
        $tableEle = $('#'+eleName);
        eleId = eleName;
        classVal = $tableEle.attr('class');
        fieldType = 'RADIO';
    }
    if ($input.is(':checkbox')) {
    	var checkBoxEle = $("input[name=" + input.name + "]");
    	if(checkBoxEle[0]!=null && checkBoxEle[0].checked == true)
    		inputVal = 'Y';
        eleId = input.id;
        fieldType = 'CHECKBOX';
    }     
    if ($input.is('select')){
    	inputVal = $(input).prop("selectedIndex");
    	eleId = input.id;
    	fieldType = 'SELECT';
    }
    if ($input.is('textarea')){
    	inputVal = $input.val();
    	eleId = input.id;
    	fieldType = 'TEXTAREA';
    }
    
    if(classVal!=null && classVal!=''){
        var classNames = classVal.split(" ");
        $.each(classNames, function(){
        	if(this == 'required'){
        		if(inputVal == ''){
        			isValid = false;
        			addErrorMessage(eleId," is required.",errMsg);
        		}
        	} 
        });
    	
    }
    if (!isValid){
    	return false;
    }
    return rtnValue;
}

function addErrorMessage(eleId,errMsg,errorMessages){
	  var label = $("label[for="+eleId+"]");
	  label = $(label).html();
	  if(label!=null ){
      	label = trimValue(label);
		  	var lastChar = label.substring(label.length-1,label.length);
      	if(lastChar == ':' || lastChar == '?' || lastChar == '.'){
      		label = label.substring(0,label.length-1);
      	}
    }
	  if(label==null){
  	  label = eleId;
    }
	  var errMsg = "<label for="+eleId+" style='color:RED'>" + label + errMsg + "</label>";
      if(inArray(errMsg,errorMessages)<0){
      	errorMessages[errorMessages.length] = errMsg;
      	changeStylerOfField(eleId);
      }      
}
function trimValue(value) {
	return $.trim(value);
}
function showErrMsg(obj, errorMessages) {	
	if (errorMessages.length > 0) {        
		
		var errorDiv = '<div id="errorDivValues">';
        errorDiv += '<ul class="failColor">';
        for (var i = 0; i < errorMessages.length; i++) {
            errorDiv += '<li>' + errorMessages[i] + '</li>';
        }
        errorDiv += '</ul>';        
        errorDiv += '</div>'; 
        if (obj==null){
        	$("#errorDiv").after(errorDiv);
        }else{
        	$(obj).after(errorDiv);
        }
    }
}
custIndexOf = Array.prototype.indexOf;
function inArray( elem, array, i ) {
	
	var len;

	if ( array ) {
		if ( custIndexOf ) {
			return custIndexOf.call( array, elem, i );
		}

		len = array.length;
		i = i ? i < 0 ? Math.max( 0, len + i ) : i : 0;

		for ( ; i < len; i++ ) {
			// Skip accessing in sparse arrays
			if (typeof elem === 'string'){
				if (array[ i ] === elem){
					return i;
				}
			}else
			if ( i in array && array[ i ] === elem ) {
				return i;
			}
		}
	}

	return -1;
}
function changeStylerOfField(eleId){
	var fieldType = returnTypeOfElement(eleId);
	
	if(fieldType == 'RADIO'){ 
		$radios = $(':radio[name='+eleId+']');
		$.each($radios,function(){
			//this.css('border-color',borderColor_error);
			//TODO : add error border to radio
		});
	}else if(fieldType == 'TEXT'){
		$divId = $("#"+eleId);
		$divId.css('border-color',borderColor_error);
	}else if(fieldType == 'CHECKBOX'){
		$divId1 = $("#"+eleId);
		$divId1.addClass('error');
	}else if(fieldType == 'SELECT'){
		$divId = $("#"+eleId);
		$divId.css('border-color',borderColor_error);
	}
}
function returnTypeOfElement(elementId){
	$input = $(":input[name=" + elementId + "]");
	
	var fieldType ='';
	if ($input.is(':hidden')) {
    	fieldType = 'HIDDEN';
    }
	if ($input.is(':text')) {
    	fieldType = 'TEXT';
    }
	
    if ($input.is(':password')) {
    	
    	fieldType = 'TEXT';
    }
    if ($input.is(':radio')) {
    	
        fieldType = 'RADIO';
    }
    if ($input.is(':checkbox')) {
    	
        fieldType = 'CHECKBOX';
    }     
    if ($input.is('select')){
    	
    	fieldType = 'SELECT';
    }   
    if ($input.is('textarea')){
    	fieldType = 'TEXTAREA';
    }
    return fieldType;
}
function removEerrMsg() {
	$('#errorDivValues').remove();
	$('#errorDiv').empty();	
}
function contextRootName(){
	
    var protocol = window.location.protocol;
	var host = window.location.host;
	var root = window.location.pathname.split("/");
	var appRoot = "";
	if(root.length > 2) {
		appRoot = root[1];
	}
    
    return appRoot;
}
