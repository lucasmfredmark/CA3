angular.module('myApp.funds', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/funds', {
    templateUrl: 'app/funds/funds.html',
    controller: 'FundCtrl',
    controllerAs : 'fund'
  });
}])

.controller('FundCtrl', ['userFactory', function(userFactory) {
        var self = this;
        self.selection = 0;
        self.select = function(points) {
            self.selection = points;
        };
        self.addFunds = function(points) {
            console.log("You get " + points + " points!");
            userFactory.addPoints(points);
        };
}]);