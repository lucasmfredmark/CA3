/*
 * Place your global Controllers in this file
 */

angular.module('myApp.controllers', []).

  controller('AppCtrl', ['userService', function (userService) {
    var self = this;
    
    self.user = userService;
          //console.log($scope.isAuthenticated);
    //var self = this;
    
    //self.myTeams = [];
    
    /*if ($scope.isAuthenticated) {
        self.getTeamsByUsername = function(username) {
            teamFactory.getTeamsByUsername(username).then(function(teams) {
                self.myTeams = teams;
            }, function() {
                console.log('Couldn\'t get teams for user ' + username);
            });
        };
        
        self.getTeamsByUsername("Lucas");
    }*/
  }]);