app.directive('gamePanel', ['picks', 'logos', function(picks, logos) {
    return {
        restrict: 'E',
        scope: false,
        templateUrl: '/javascripts/directives/gamePanel.html',
        link: function(scope, element, attrs){
          scope.getTeamLogo = function(teamName){
             return logos.getLogoByTeamname(teamName);
          }
        }
    }
}]);
