const btnAddDirector = document.querySelector("#addDirector")
const btnAddGenre = document.querySelector("#addGenre")
const btnAddActor = document.querySelector("#addActor")

btnAddDirector.addEventListener('click', function(event) {
    event.preventDefault();
    const cln = document.getElementsByClassName("fieldDirector")[0].cloneNode(true);
    document.getElementById("fields").insertBefore(cln,this);
    return false;
});

btnAddGenre.addEventListener('click', function(event) {
    event.preventDefault();
    const cln = document.getElementsByClassName("fieldGenre")[0].cloneNode(true);
    document.getElementById("fields").insertBefore(cln,this);
    return false;
});

btnAddActor.addEventListener('click', function(event) {
    event.preventDefault();
    const cln = document.getElementsByClassName("fieldActor")[0].cloneNode(true);
    document.getElementById("fields").insertBefore(cln,this);
    return false;
});
