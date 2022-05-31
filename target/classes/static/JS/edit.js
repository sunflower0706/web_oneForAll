const gioitinh = document.querySelector(".gioiTinh");
const success = document.querySelector("#success");

function submitForm(event){
    if (document.getElementById('signupPass').value !== document.getElementById('confirmPass').value){
        event.preventDefault();
    }
}

function addGioiTinh() {
    gioitinh.value = document.querySelector("input[name='gender']:checked").value === "Nam";
}

function checkChangeInfo(){
    if (success.innerHTML !== ""){
        if (success.innerHTML === "true"){
            window.alert("ĐÃ CẬP NHẬT THÔNG TIN");
        }else {
            window.alert("CẬP NHẬT THÔNG TIN THẤT BẠI!!!! \n VUI LÒNG KIỂM TRA LẠI MẬT KHẨU")
        }
        success.remove();
        if ( window.history.replaceState ) {
            window.history.replaceState( null, null, window.location.href );
        }
    }
}
