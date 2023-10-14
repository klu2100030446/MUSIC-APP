function register()
{
	var password = document.getElementById("t3").value;
        var rePassword = document.getElementById("t4").value;

        if (password !== rePassword) {
            alert("Passwords do not match. Please re-enter the password.");
        } else {
            callApi("POST",url,data,getResponse);
        }
 
 var url="http://localhost:8089/reunionlab/register";
 var data=JSON.stringify({
  "id":t1.value,
        "name":t2.value,
  "contactno":t3.value,
  "amount":t4.value,
  "status":d1.options[d1.selectedIndex].value
 });
 
}
function update(){
	url="http://localhost:8089/reunionlab/update/"+t1.value+"/"+t4.value;
	callApi("PUT",url,"",getResponse);
}
function deleteData(){
	url="http://localhost:8089/reunionlab/delete/"+t1.value;
	callApi("DELETE",url,"",getResponse);
}
function view(){
	var url ="http://localhost:8089/reunionlab/read";
	callApi("GET",url,"",getResponseTable);
}
function getResponseTable(res){
	var data = JSON.parse(res);
	var table = `<table border="1">
	             <tr>
	                <th>StudentId</th>
	                <th>StudentName</th>
	                <th>StudentContactNo</th>
	                <th>Amout paid/th>
	                <th>Paymentstatus</th>
	             </tr>`;
	for(var x in data){
		table+=	`<tr>
		         <td>` +data[x].id + `</td>
		         <td>` +data[x].name + `</td>
		         <td>` +data[x].contactno + `</td>
		         <td>` +data[x].amount + `</td>
		         <td>` +data[x].status + `</td>
		         
		
		         </tr>`
	}        
	table+=`</table>`;
	viewdata.innerHTML=table;     
}


function getResponse(res)
{
 l1.innerText=res;
 
}
function callApi(METHOD,URL,DATA,SUCCESS)
{
 var xhttp=new XMLHttpRequest();
 xhttp.open(METHOD,URL,true)
 xhttp.setRequestHeader('Content-Type','application/json');
 xhttp.onreadystatechange=function()
 {
  if(this.readyState == 4)
  {
   if(this.status == 200)
    SUCCESS(this.responseText);
   else
    alert("404: Service unavailable"); 
   
  }
  
 };
 xhttp.send(DATA);
 
}