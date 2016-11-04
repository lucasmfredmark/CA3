
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
                
                // Module tests
                self.controllerTest = "Hello from controller";
                self.pokeApiFactoryTest = pokeApiFactory.factoryTest;
                
                //List containing the 6 IDS of the pokemon to display. Empty to start. pokemonToGet sets 6 random integers in 
                self.pokemonList = [];
                self.pokemonToGet = [Math.floor((Math.random() * 150) + 1), Math.floor((Math.random() * 150) + 1), Math.floor((Math.random() * 150) + 1), Math.floor((Math.random() * 150) + 1), Math.floor((Math.random() * 150) + 1), Math.floor((Math.random() * 150) + 1)];
                
                // Method gets a single pokemon by id. Hard coded example below
                self.getPokemonById = pokeApiFactory.getPokemonById(130).then(function (response) {
                                self.pokemon = response.data;
                            }, function (error) {
                                self.status = 'Unable to load pokemon data: ' + error.message;
                            });
                
                // for each index in array, call getPokemonById(var id) where var id = random generated integer from pokemonToGet 
                self.pokemonToGet.forEach(function(entry) {
                    //Add a pokemon to list which is a object from pokeapi
                    self.pokemonList[count] = pokeApiFactory.getPokemonById(entry).then(function (response) {
                                console.log(response.data);
                                return response.data;
                            }, function (error) {
                                return 'Unable to load pokemon data: ' + error.message;
                            });;
                    // Increases array index we add to        
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
                    return $http({
                        url: baseUrl + id,
                        skipAuthorization: true,
                        method: 'GET'
                    });
                };
                return factory;
            }]);
