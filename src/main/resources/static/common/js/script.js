$(function(){
  $(".error-pass, .error-email").hide();
  $(".overlay").hide();
  $(".confirmation").hide();
})

function checkEmail(email) {
  var emailReg = /^[0-9a-zA-Z]+$/;
  return emailReg.test(email);
}


function validateForm() {
  var countErrors = 0;
  var emailInput = $("input[type=email]");
  var passInput = $("input[type=password]");
  
  if(!checkEmail($(emailInput).val())) {
    $(".error-email").fadeIn();
    $(".email-msg").html("请输入正确的账号");
    $(emailInput).addClass("warning");
    countErrors++;
  } else{
  	$(emailInput).removeClass("warning");
  	var form = document.getElementById('loginForm');
  	form.submit()
  }

 else {
    $(passInput).removeClass("warning");
  }

  setTimeout(function showErrorMsg() {
    $(".error-email, .error-pass").fadeOut();
  }, 2000)

  if(countErrors === 0) {
    $(".overlay").show();
    $(".confirmation").show();
  }
}


/*注册*/
