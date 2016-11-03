/*
 * Place your global Controllers in this file
 */

angular.module('myApp.controllers', []).
  controller('AppCtrl', ['TeamFactory', function (TeamFactory) {
    var self = this;
    
    self.title = 'MyPokéTrainer';
    self.getTeams = function() {
        TeamFactory.getTeams().then(function(teams) {
            self.myTeams = teams;
            self.myTeams[0].pokemonList = [
                {
                    name: 'Din mor',
                    pokedexId: 1
                },
                {
                    name: 'Din far',
                    pokedexId: 2
                },
                {
                    name: 'Din mormor',
                    pokedexId: 3
                }
            ];
        });
    };
    
    self.getTeams();
  }]);