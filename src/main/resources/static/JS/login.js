const loginText = document.querySelector(".title-text .login");
const loginForm = document.querySelector("form.login");
const loginBtn = document.querySelector("label.login");
const signupBtn = document.querySelector("label.signup");
const signupLink = document.querySelector("form .signup-link a");
const hasError = document.querySelector("#hasError");

function submitForm(event){
    if (document.getElementById('signupPass').value !== document.getElementById('confirmPass').value){
        event.preventDefault();
    }
}

function check() {
    if (document.getElementById('signupPass').value !== document.getElementById('confirmPass').value) {
        document.getElementById('message').style.color = 'red';
        document.getElementById('message').innerHTML = 'not matching';
    } else {
        document.getElementById('message').style.color = 'green';
        document.getElementById('message').innerHTML = 'matching';
    }
}

document.addEventListener("DOMContentLoaded", function (){
    if (hasError.innerHTML === 'true'){
        hasError.innerHTML = 'false';
        window.alert("SAI MẬT KHẨU HOẶC EMAIL KHÔNG TỒN TẠI");
    }
}, false)

signupBtn.onclick = (()=>{
    loginForm.style.marginLeft = "-50%";
    loginText.style.marginLeft = "-50%";
});

loginBtn.onclick = (()=>{
    loginForm.style.marginLeft = "0%";
    loginText.style.marginLeft = "0%";
});

signupLink.onclick = (()=>{
    signupBtn.click();
    return false;
});