var patternEmail = /^(?![_])[\w\d]((?![_])[\w\d][.\-_]?){3,19}[\w\d]@([a-zA-Z]{2,5}[.]){1,2}[\w]{2,5}$/;
var patternPassword = /^(?=.*?[a-z])(?=.*?[A-Z])(?=.*?[!@#$%&*]).{8,20}$/;

var loginInput = document.getElementById('login');
var passwordInput = document.getElementById('password');

loginInput.addEventListener('change', function() {check(loginInput, patternEmail, 0)}, false);
loginInput.addEventListener('change', function() {trim(loginInput)}, false);

passwordInput.addEventListener('change', function() {check(passwordInput, patternPassword, 1)}, false);

function check(input, pattern, fieldNumber) {
  console.log(input.value);
  console.log(pattern.test(input.value));

  if (!pattern.test(input.value)) {
    input.parentElement.getElementsByClassName('error')[fieldNumber].textContent = 'Invalid Input';
    input.parentElement.getElementsByClassName('error')[fieldNumber].style.display = "block";
  } else {
    input.parentElement.getElementsByClassName('error')[fieldNumber].style.display = "none";
  };
}

function trim(input) {
  input.value = input.value.trim();
}
