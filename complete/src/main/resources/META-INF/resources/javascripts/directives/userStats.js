app.directive('userStats', function(){
	return {
		restrict: 'E',
		scope: {
			usermodel: '='
		},
		templateUrl: '/javascripts/directives/userStats.html'
}});
