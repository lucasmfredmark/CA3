'use strict';

angular.module('myApp.docs', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/docs', {
    templateUrl: 'app/docs/docs.html',
    controller: 'DocCtrl',
    controllerAs : 'doc'
  });
}])

.controller('DocCtrl', [function() {
  
}]);