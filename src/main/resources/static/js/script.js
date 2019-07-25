document.addEventListener('DOMContentLoaded', function(){ 
	
// Create a "close" button and append it to each list item
	var myNodelist = document.getElementsByTagName("LI");
	var i;
	for (i = 0; i < myNodelist.length; i++) {
		var span = document.createElement("SPAN");
		var txt = document.createTextNode("\u00D7");
		span.className = "close";
		span.appendChild(txt);
		myNodelist[i].appendChild(span);
	}
	
// Click on a close button to remove the current list item
	
	$("#myUL").on("click", ".close", e => {
		var li = $(e.target).parent();
		deleteItem(li.attr("id"));
		li.remove();
	});
	
// Add a "checked" symbol when clicking on a list item
	var list = document.querySelector('ul');
	list.addEventListener('click', function(ev) {
		if (ev.target.tagName === 'LI') {
			ev.target.classList.toggle('checked');
		}
	}, false);
	
}, false);

// Create a new list item when clicking on the "Add" button
function newElement() {
	var li = document.createElement("li");
	var inputValue = document.getElementById("myInput").value;
	var t = document.createTextNode(inputValue);
	li.appendChild(t);
	if (inputValue === '') {
		alert("You must write something!");
	} else {
		$.when(saveItem(inputValue)).done(function(result) {

			if (result) {
				
				document.getElementById("myUL").prepend(li);
				var span = document.createElement("SPAN");
				var txt = document.createTextNode("\u00D7");
				span.className = "close";
				span.appendChild(txt);
				li.appendChild(span);
				li.setAttribute("id", result.id);
				
				for (i = 0; i < close.length; i++) {
					close[i].onclick = function() {
						var div = this.parentElement;
						div.style.display = "none";
					}
				}
			}
			
		});
		
	}
	
	document.getElementById("myInput").value = "";
}

function saveItem(itemDescription) {
	const json = `{"description": "${itemDescription}", "isDone": false}`;
	
	return $.ajax({
        url: "item",
        type: "POST",
        contentType: "application/json; charset=utf-8",
        data: json
    });
}

function deleteItem(id) {
	$.ajax({
        url: `item/${id}`,
        type: "DELETE",
        success: function(d) {
        }
    });
}