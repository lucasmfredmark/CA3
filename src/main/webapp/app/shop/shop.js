'use strict';

angular.module('myApp.shop', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/shop', {
    templateUrl: 'app/shop/shop.html',
    controller: 'ShopCtrl',
    controllerAs : 'shop'
  });
}])

.controller('ShopCtrl', ['pokemonFactory', function(pokemonFactory) {
  var self = this;
  
  self.pokemonList = [];
  
  self.getAllPokemonPrices = function() {
      pokemonFactory.getAllPokemonPrices().then(function(response) {
          self.pokemonList = response.data;
      });
  };
}]);