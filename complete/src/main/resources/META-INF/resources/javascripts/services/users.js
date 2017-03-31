app.factory('users', ['$http', '$q', 'picks', 'leagues', function($http, $q, picks, leagues) {
    var userservices = {};
    const APIPREFIX = '/api';

    userservices.getUsers = function() {
        return $http({
            method: 'GET',
            url: APIPREFIX + '/users'
        })
    }

    userservices.getUser = function(username) {
        return $http({
            method: 'GET',
            url: APIPREFIX + '/users?username=' + username
        })
    }

    userservices.updateUser = function(userId, userData) {
        return $http({
            method: 'PUT',
            url: APIPREFIX + '/users/' + userId,
            data: userData
        })
    }

    userservices.getUserPicks = function(username, season) {
        var seasonQuery = '';
        if (season) {
            seasonQuery = '&season=' + season;
        }

        return $http({
            method: 'GET',
            url: '/api/picks/' + '?username=' + username + seasonQuery
        })
    }

    userservices.getUserModel = function(userId) {
        return $http({
            method: 'GET',
            url: APIPREFIX + '/users/' + userId
        })
    }

    userservices.getUserPickResultSummary = function(username) {
        return $http({
            method: 'GET',
            url: APIPREFIX + '/picks/summary?' + username
        })
    }

    userservices.getUserModelNew = function(userId) {
        var deferred = $q.defer();
        var userModel = {}

        $http({
                method: 'GET',
                url: APIPREFIX + '/users/' + userId
            })
            .success(function(data) {
                userModel.userDetails = data;
                $http({
                        method: 'GET',
                        url: APIPREFIX + '/picks/with?username=' + data.username
                    })
                    .success(function(pickData) {
                        userModel.userPicks = pickData;
                        userModel.userPicksByWeek = picks.groupPicksByWeek(pickData);

                        leagues.getLeaguesByUsername(data.username)
                          .success(function(leagues){
                              userModel.userLeagues = leagues;
                              deferred.resolve(userModel);
                          })
                          //League Error
                          .error(function(error){
                            deferred.reject({
                                message: "Failed"
                            });
                          })
                    })
                    //Picks Error
                    .error(function(error) {
                        deferred.reject({
                            message: "Failed"
                        });
                    })
            })
            //User Error
            .error(function(error) {
                deferred.reject({
                    message: "Failed"
                })
            })

        return deferred.promise
    }

    return userservices;
}]);
