<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Add new speed</title>
<script>
function sendData(){
	//Create a new Javascript object
	var robot=new Object();
	robot.speed=document.getElementById("speed").value;
	
	var jsonRobot=JSON.stringify(robot);
	var xhttp = new XMLHttpRequest();
	
	xhttp.onreadystatechange = function() {
	  if (this.readyState == 4 && this.status == 200) {
	   document.getElementById("responseView").innerHTML = this.responseText;
	   console.log("Raw response:", this.responseText);
	   var returned=JSON.parse(this.responseText);
	   document.getElementById("inparts").innerHTML="ID="+returned.id+" speed="+returned.speed;

	  }
	};
	
	xhttp.open("POST","./rest/robotservice/addrobot",true);
	xhttp.setRequestHeader("Content-type","application/json");
	xhttp.send(jsonRobot);
}
</script>
</head>

<body>
<h2>Fill in - this form uses AJAX</h2>
<form action="#" method='post' onsubmit='return false;'>
Speed: <input id='speed' type='text' name='speed' value='' placeholder='New speed'><br>
<input type='button' name='ok' value='Send' onclick='sendData();'><br>
</form>
<p id='responseView'>The response will be shown here!
</p>
<p id='inparts'>The response in parts will be shown here!
</p>
</body>
</html>