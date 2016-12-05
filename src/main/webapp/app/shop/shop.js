'use strict';

angular.module('myApp.shop', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/shop', {
    templateUrl: 'app/shop/shop.html',
    controller: 'ShopCtrl',
    controllerAs : 'shop'
  });
}])

.controller('ShopCtrl', [function() {
  
}]);