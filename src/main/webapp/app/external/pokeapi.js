
'use strict';

angular.module('myApp.pokeapi', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/pokeapi', {
                    templateUrl: 'app/external/apitest.html',
                    controller: 'pokeApiCtrl',
                    controllerAs: 'pokeapi'
                });
            }])

        .controller('pokeApiCtrl', ['pokeApiFactory', function (pokeApiFactory) {
                var self = this;
                var count = 0;
                self.controllerTest = "Hello from controller";
                self.pokeApiFactoryTest = pokeApiFactory.factoryTest;
                self.pokemonList = [];
                self.pokemonToGet = [Math.floor((Math.random() * 150) + 1), Math.floor((Math.random() * 150) + 1), Math.floor((Math.random() * 150) + 1), Math.floor((Math.random() * 150) + 1), Math.floor((Math.random() * 150) + 1), Math.floor((Math.random() * 150) + 1)];
                self.getPokemonById = pokeApiFactory.getPokemonById(130).then(function (response) {
                                self.pokemon = response.data;
                            }, function (error) {
                                self.status = 'Unable to load customer data: ' + error.message;
                            });
                self.pokemonToGet.forEach(function(entry) {
//                    console.log(entry);
                    self.pokemonList[count] = pokeApiFactory.getPokemonById(entry).then(function (response) {
                                console.log(response.data);
                                return response.data;
                            }, function (error) {
                                return 'Unable to load customer data: ' + error.message;
                            });;
                    count++;
                });
                console.log(self.pokemonList);
            }])
        .factory('pokeApiFactory', ['$http', function ($http) {
                var factory = {};
                var baseUrl = "http://pokeapi.co/api/v2/pokemon/";
                factory.factoryTest = "Hello from factory";
                factory.getPokemonById = function(id) {
//                    console.log($http.get(baseUrl + id));
//                    return "Get pokemon with id: " + id + " & url: " + baseUrl;
                    return $http.get(baseUrl + id);
                };
                return factory;
            }]);
