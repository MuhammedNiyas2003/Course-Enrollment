function makeContainer(d){
  let con = document.querySelector(".container")
  let head = document.createElement('h1');
  con.className ="login-conatiner";
  con.innerHTML ="";
  con.appendChild(head);
  if(d.statusCode ==302){
    let data = d.data.name;
    head.textContent = `Welcome , ${data} `;
  }
}
function studenLogin(){
  
}
function verify(email, password,user) {
  let res = fetch(`http://localhost:8080/${user}?email=${email}&password=${password}`);
  res.then((resp) => {
    return resp.json();
  }).then((data) => {
    makeContainer(data);
  }).catch((error) => {
    console.error(error);
    document.getElementById("loader").innerText = "Login failed!";
  });
}

let btn = document.querySelector("#login-button");
btn.addEventListener("click", function (e) {
  e.preventDefault();
  let username = document.querySelector("#email").value;
  let password = document.querySelector("#password").value;
  let userType = document.querySelector('input[name="user"]:checked');

  // Show loading
  document.getElementById("loader").innerText = "Loading...";

  // Check if user type is selected
  if (!userType) {
    alert("Please select user type");
    document.getElementById("loader").innerText = "";
    return;
  }

  console.log(username, password, userType.value);
  verify(username, password,userType.value);
});
