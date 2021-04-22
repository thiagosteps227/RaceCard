//Thiago dos Passos A00279945

var rootURL = "http://localhost:8080/RaceCard/rest/horses";

var findAll= function () {
	console.log('findAll');
	$.ajax({
		type: 'GET',
		url: rootURL,
		dataType: "json", 
		success: renderList
	});
};

var findById= function(id) {
	console.log('findById: ' + id);
	$.ajax({
		type: 'GET',
		url: rootURL + '/' + id,
		dataType: "json",
		success: function(data){
			$('#details').show();
			currentHorse = data
			renderDetails(currentHorse);
		}
	});
};

var findByName= function(horseName) {
	console.log('findByName: ' + horseName);
	$.ajax({
		type: 'GET',
		url: rootURL + '/search/' + horseName,
		dataType: "json",
		success: function(data, textStatus, jqXHR){
			$('#details').show();
			if (data === null || data === undefined){
				alert("No data Found")
			} else {
				currentHorse = data
				renderDetails(currentHorse);
			}
		}
	});
};

function renderList(horse) {
	$.each(horse, function(index, horse){
		$('#raceCard').append('<li><a id="'+horse.id+'" href="#">'+horse.name+'</a></li>' );
	});	
}

function renderDetails(horse) {
	$('#details').empty();
	$('#details').append('<h1 id="name">'+horse.name+'</h1><table id="table"><thead><tr><th>Entry</th><th>Colors</th><th>Trainer</th><th>Breeder</th><th>Jockey</th><th>Betting</th><tr><tr><td>'+horse.id+'</td><td><img src="images/'+horse.picture+'"></td><td>'+horse.trainer+'</td><td>'+horse.breeder+'</td><td>'+horse.jockey+'</td><td>'+horse.betting+'</td></tr>')
}

$(document).ready(function(){
	$('#searchKey').val("");
		findAll();
		
		//show the div with horse details
		$(document).on("click", '#raceCard a', function(){
			findById(this.id);
	 });
		
		//find the horse by name
		$(document).on("click", '#btnSearch', function(){
			var horseName = $('#searchKey').val();
			findByName(horseName);
		})
		
});