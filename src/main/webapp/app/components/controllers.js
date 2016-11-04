/*
 * Place your global Controllers in this file
 */

angular.module('myApp.controllers', []).
  controller('AppCtrl', ['TeamFactory', function (TeamFactory) {
    var self = this;
    
    self.title = 'MyPokéTrainer';
    self.getTeams = function() {
        TeamFactory.getTeams().then(function(teams) {
            self.myTeams = teams;
            console.log(self.myTeams);
        });
    };
    
    self.getTeams();
  }]);