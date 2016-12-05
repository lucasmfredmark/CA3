'use strict';

angular.module('myApp.trainers', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/trainers', {
    templateUrl: 'app/trainers/trainers.html',
    controller: 'TrainerCtrl',
    controllerAs : 'trainer'
  });
}])

.controller('TrainerCtrl', [function() {
  
}]);