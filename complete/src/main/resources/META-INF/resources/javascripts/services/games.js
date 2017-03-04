app.factory('games', ['$http', function($http) {
 var gameServices = {};
 const APIPREFIX = '/api';

gameServices.getGames = function (){
	 return $http({
		 method: 'GET',
		 url: APIPREFIX + '/games'
	 })
 }

gameServices.getGameById = function (gameId){
	return $http({
		method: 'GET',
		url: APIPREFIX + '/games/' + gameId
	})
}
gameServices.getWeekList = function (){
	return $http({
		method: 'GET',
		url: APIPREFIX + '/games/weeklists'
	})

}

gameServices.getGamesByWeek = function (weekNumber, season) {
  var seasonQuery = addSeasonQuery(season);
	return $http({
			method: 'GET',
			url: APIPREFIX + '/games' + '?weekNumber=' + parseInt(weekNumber) + seasonQuery
	})
}

gameServices.getGamesByTeam = function (team){
	return $http({
		method: 'GET',
		url: APIPREFIX + '/games' + '?team=' + team
	})
}

gameServices.updateGamesByWeek = function (week, gameData) {
	return $http({
		method : 'PUT',
		url : APIPREFIX + '/games' + '?weekNumber=' + parseInt(week),
		data : gameData
	})
}
gameServices.updateGame = function (gameId, data){
	return $http({
		method: 'PUT',
		url: APIPREFIX + '/game/' + gameId,
		data: data
	})
}

 return gameServices;

function addSeasonQuery(season){
  var seasonQuery = '';
  if(season){
    seasonQuery = '&season=' + season;
  }
  return seasonQuery;
}

}]);
