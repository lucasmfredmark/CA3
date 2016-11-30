/*
 * Place your global Controllers in this file
 */

angular.module('myApp.controllers', []).
  controller('AppCtrl', ['userService', 'teamService', function (userService, teamService) {
    var self = this;
    
    self.user = userService;
    self.team = teamService;
  }]);