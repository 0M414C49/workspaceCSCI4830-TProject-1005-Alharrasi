/**
 * 
 */

var table;

function removeEmployee(id) {
	fetch('/webproject-T1-Alharrasi/RemoveEmployee?id=' + id);
	
	table.ajax.reload();
}

function addHour()
{
	fetch('/webproject-T1-Alharrasi/Attend');
}

function editEmployee(id) {
	
	fetch('/webproject-T1-Alharrasi/GetEditEmployee?id=' + id)
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
	table.ajax.reload();
}

function fetchEmployees(){
	$(document).ready(function() {
		
		$("#my-button").click(function() {
	        $("#myTable").ajax.reload();
	    });
		table = $('#myTable').DataTable(
				{
					
			        "ajax": "/webproject-T1-Alharrasi/GetEmployee"
			        
				}
		);
	});
}
	