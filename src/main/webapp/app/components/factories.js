'use strict';

/* Place your global Factory-service in this file */

angular.module('myApp.factories', []).
  factory('TeamFactory', ['$http', '$q', function ($http, $q) {
    var apiUrl = 'api/team/';
    
    return {
      getTeamCount: function() {
        return 3;
      }
    };
  }]);