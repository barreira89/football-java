app.factory('logos', ['$http', function($http) {
 var logos = {};
 var logoLookUp;

function getLogoList (){
   return $http({
     method: 'GET',
     url: '/api/logos'
   })
 }

getLogoList().success(function (data){
  logoLookUp = createLogoLookUp(data);
})
//get logo location by team name

//check to see if logo list is loaded -- return
logos.getLogoByTeamname = function(teamName) {
    if (!logoLookUp) {
        getLogoList().success(function(data) {
            logoLookUp = createLogoLookUp(data);
            return logoLookUp[teamName];
        })
    } else {
        return logoLookUp[teamName];
    }
}

function createLogoLookUp(logoArray) {
    return logoArray.reduce((prev, current) => {
        prev[current.team] = removePublic(current.logo);
        return prev;
    }, {});
}

 return logos;
}]);

//Hack
function removePublic (url) {
  return url.replace('public/', '')
}
