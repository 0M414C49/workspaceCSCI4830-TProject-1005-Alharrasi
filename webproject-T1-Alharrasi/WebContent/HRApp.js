/**
 * 
 */



function fetchEmployees() {
	fetch('/webproject-T1-Alharrasi/GetEmployee')
	.then(
			function(response) {
				return response
						.text()
						.then(
								function(text) {
									document
											.getElementById("add_to_me").innerHTML = text;
								});
			});
}

function fetchEmployees2(){
	document.getElementById("add_to_me").innerHTML = "clicked";
}
	