angular.module('myApp.funds', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/funds', {
    templateUrl: 'app/funds/funds.html',
    controller: 'FundCtrl',
    controllerAs : 'fund'
  });
}])

.controller('FundCtrl', [function() {
  
}]);