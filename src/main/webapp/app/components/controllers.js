/*
 * Place your global Controllers in this file
 */

angular.module('myApp.controllers', []).
  controller('AppCtrl', ['teamFactory', function (teamFactory) {
    var self = this;
    
    self.title = 'MyPokéTrainer';
    /*self.getTeamsByUsername = function(username) {
        teamFactory.getTeamsByUsername(username).then(function(teams) {
            self.myTeams = teams;
            console.log(self.myTeams);
        }, function() {
            console.log('Error in getTeamsByUsername()');
        });
    };
    
    self.getTeamsByUsername("Lucas");*/
  }]);