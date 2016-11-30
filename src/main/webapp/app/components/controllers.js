/*
 * Place your global Controllers in this file
 */

angular.module('myApp.controllers', []).
  controller('AppCtrl', ['userService', 'teamFactory', function (userService, teamService, teamFactory) {
    var self = this;
    
    self.user = userService;
    self.myTeams = teamService.teamList;
  }]);