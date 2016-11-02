'use strict';

angular.module('myApp.index', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/', {
    templateUrl: 'app/index/index.html',
    controller: 'IndexCtrl',
    controllerAs : 'index'
  });
}])

.controller('IndexCtrl', [function() {
  
}]);