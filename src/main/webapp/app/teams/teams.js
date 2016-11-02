'use strict';

angular.module('myApp.teams', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/teams', {
    templateUrl: 'app/teams/teams.html',
    controller: 'TeamCtrl',
    controllerAs : 'team'
  });
}])

.controller('TeamCtrl', [function() {
  
}]);