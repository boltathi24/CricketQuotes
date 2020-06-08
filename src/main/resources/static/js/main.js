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


  var xhr = new XMLHttpRequest();
     var result=null;
var url = "http://127.0.0.1:8002/getQuotesByPlayer";
xhr.open("POST", url, true);
var data = JSON.stringify({"playerName": playerToSearch});

xhr.setRequestHeader("Content-Type", "application/json");

xhr.onload=function()
{
result=xhr.responseText;
console.log(result);
var obj = JSON.parse(result);
document.getElementById("playerImage").src = "data:image/png;base64," + obj.imageDataValue;
document.getElementById("playerRunsTxt").value =  obj.runScored;
document.getElementById("playerAgeTxt").value =  obj.playerAge;
document.getElementById("playerNameBy").value =  obj.playerName;
document.getElementById("playerNameTxt").value =  obj.playerName;

var quotes = obj.quoteContent;
console.log(quotes);
var htmlContent="";
console.log(quotes.length);
for(var i=0;i<quotes.length;i++)
{
	htmlContent=htmlContent+"<li class=\"quotes quoteFont \" >"+quotes[i]+"</li>";


}
console.log(htmlContent)
document.getElementById("quotesList").innerHTML = htmlContent;




};     



xhr.send(data);

}
