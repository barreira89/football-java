var app = angular.module('Football', ['ui.bootstrap', 'ngRoute', 'ui.router']);
app.constant('USER_ROLES',{
  all: '*',
  admin: 'admin',
  user: 'user'
});
app.config(['$stateProvider', '$urlRouterProvider', 'USER_ROLES', function($stateProvider, $urlRouterProvider, USER_ROLES){
  $stateProvider
    .state('pickem', {
        url: '/',
        controller: 'MainController',
        templateUrl: '/views/pickem.html',
  	    controllerAs: 'mctrl',
        data: {authorizedRoles: [USER_ROLES.all]}
      })
  	.state('login', {
  	    url: '/login',
  	    templateUrl: '/views/login.html',
  	    controller: 'LoginController',
  	    data: {
  	        authorizedRoles: [USER_ROLES.all]
  	    }
  	})
  	.state('login.register', {
      url: '/register',
  		controller: 'LoginController',
  		templateUrl: '/views/register.html',
      data: {authorizedRoles: [USER_ROLES.all]}
  	})
  	.state('users', {
  		url:'/users',
      controller: 'UserController',
  		templateUrl: '/views/userlist.html',
      data: {authorizedRoles: [USER_ROLES.all]}
  	})
  	.state('admin', {
      url: '/admin',
  		controller: 'AdminController',
  		templateUrl: '/views/admin.html',
      data: {
        authorizedRoles: [USER_ROLES.all]
      }
  	})
  	.state('leagues', {
      url: '/leagues',
  		controller: 'LeagueController',
  		templateUrl: '/views/leagues.html',
      data: {authorizedRoles: [USER_ROLES.all]}
  	})
    .state('profile', {
      url: '/profile',
      controller: 'ProfileController',
      templateUrl: '/views/profilemain.html',
      data: {authorizedRoles: [USER_ROLES.all]}
  	})
    .state('profile.user', {
      url: '/user',
      contoller: 'ProfileController',
      templateUrl: '/views/userprof.html',
      data: {authorizedRoles: [USER_ROLES.all]}
    })
    .state('profile.leagues', {
          url: '/leagues',
          contoller: 'ProfileController',
          templateUrl: '/views/profleagues.html',
          data: {authorizedRoles: [USER_ROLES.all]}
    })
    .state('profile.picks', {
          url: '/picks',
          contoller: 'ProfileController',
          template: '  <user-stats userModel="userModel"> </user-stats> '+
            '<my-picks userpicks="userPicksByWeek"></my-picks>',
          data: {authorizedRoles: [USER_ROLES.all]}
    })
    $urlRouterProvider.otherwise('/');
}])
app.constant('AUTH_EVENTS', {
  loginSuccess: 'auth-login-success',
  loginFailed: 'auth-login-failed',
  logoutSuccess: 'auth-logout-success',
  sessionTimeout: 'auth-session-timeout',
  notAuthenticated: 'auth-not-authenticated',
  notAuthorized: 'auth-not-authorized'
});
app.run(function ($rootScope, AUTH_EVENTS, USER_ROLES, auth){
  $rootScope.$on('$stateChangeStart', function (event, next){
    var authorizedRoles = next.data && next.data.authorizedRoles || USER_ROLES.all  ;
      if(!auth.isAuthorized(authorizedRoles)){
        event.preventDefault();
      };
  })
})
