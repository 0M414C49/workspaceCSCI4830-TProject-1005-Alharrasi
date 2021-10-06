/**
 * 
 */



function fetchEmployees() {
	fetch('/webproject-T1-Alharrasi/Demo')
	.then(
			function(response) {
				return response
						.text()
						.then(
								function(text) {
									document
											.getElementById("add_to_me").innerHTML = "<h1>"
											+ text + "</h1>";
								});
			});
}

function fetchEmployees2(){
	document.getElementById("add_to_me").innerHTML = "clicked";
}
	