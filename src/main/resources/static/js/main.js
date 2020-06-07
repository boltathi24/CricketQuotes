function searchPlayer()
{
var playerToSearch=document.getElementById("playerToSearch").value;
console.log(playerToSearch);
var defaultElemnt=document.getElementById("defaultHeader");
defaultElemnt.classList.add("hide");

var imgSection=document.getElementById("playerImageSection");
imgSection.classList.remove("hide");

var playerDetails=document.getElementById("playerDetails");
playerDetails.classList.remove("hide");


  /* var xhr = new XMLHttpRequest();
     var result=null;
var url = "http://192.168.143.252:8002/triggerAutomation";
xhr.open("POST", url, true);
var data = JSON.stringify({"env": env, "suite": suite,"preLocalStatus":pre});

xhr.setRequestHeader("Content-Type", "application/json");

xhr.onload=function()
{
result=xhr.responseText;
alert(result);
};     



xhr.send(data);
*/
}
