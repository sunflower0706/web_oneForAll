function submitFormWithOldPassword(event){
    if (document.getElementById('signupPass').value !== document.getElementById('confirmPass').value
    ){
        event.preventDefault();

        alert("MẬT KHẨU MỚI KHÔNG KHỚP");
    }else if (document.getElementById('signupPass').value === document.getElementById('pass').value){
        event.preventDefault();

        alert("MẬT KHẨU MỚI TRÙNG VỚI MẬT KHẨU CŨ");
    }
}