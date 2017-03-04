app.directive('userLeagues', function(){
	return {
		restrict: 'E',
		scope: {
			leagues: '=',
			username: '='
		},
		templateUrl: '/javascripts/directives/userLeagues.html'
}});
