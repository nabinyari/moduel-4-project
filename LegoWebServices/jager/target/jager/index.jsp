<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Add new prey</title>
<script>
function sendData(){
	//Create a new Javascript object
	var prey=new Object();
	prey.breed=document.getElementById("breed").value;
	prey.weight=document.getElementById("weight").value;
	
	var jsonPrey=JSON.stringify(prey);
	var xhttp = new XMLHttpRequest();
	
	xhttp.onreadystatechange = function() {
	  if (this.readyState == 4 && this.status == 200) {
	   document.getElementById("responseView").innerHTML = this.responseText;
	   var returned=JSON.parse(this.responseText);
	   document.getElementById("inparts").innerHTML="ID="+returned.id+" Breed="+returned.breed+" Weight="+returned.weight;
	  }
	};
	
	xhttp.open("POST","./rest/hunterservice/addprey",true);
	xhttp.setRequestHeader("Content-type","application/json");
	xhttp.send(jsonPrey);
}
</script>
</head>

<body>
<h2>Fill in - this form uses AJAX</h2>
<form action="#" method='post' onsubmit='return false;'>
Breed: <input id='breed' type='text' name='breed' value='' placeholder='New prey breed'><br>
Weight: <input id='weight' type='text' name='weight' value='' placeholder='Weight in kilos'><br>
<input type='button' name='ok' value='Send' onclick='sendData();'><br>
</form>
<p id='responseView'>The response will be shown here!
</p>
<p id='inparts'>The response in parts will be shown here!
</p>
<h2>Fill in - this form uses FormParameters</h2>
<form action="./rest/hunterservice/addprey" method='post'>
Breed: <input id='breed' type='text' name='breed' value='' placeholder='New prey breed'><br>
Weight: <input id='weight' type='text' name='weight' value='' placeholder='Weight in kilos'><br>
<input type='submit' name='ok' value='Send'><br>
</form>
</body>
</html>