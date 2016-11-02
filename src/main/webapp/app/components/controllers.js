/*
 * Place your global Controllers in this file
 */

angular.module('myApp.controllers', []).
  controller('AppCtrl', ['TeamFactory', function (TeamFactory) {
    var self = this;
    this.title = 'MyPokéTrainer';
    this.teamCount = TeamFactory.getTeamCount();
  }]);