angular.module('myApp.security', [])
        .controller('AppLoginCtrl', function ($scope, $rootScope, $http, $window, $location, $uibModal, jwtHelper, userService, teamService) {

          $rootScope.$on('logOutEvent', function () {
            $scope.logout();
          });

          $scope.$on("NotAuthenticatedEvent", function (event, res) {
            $scope.$emit("logOutEvent");
            
            if (typeof res.data.error !== "undefined" && res.data.error.message) {
              if (res.data.error.message.indexOf("No authorization header") === 0) {
                //Provide a friendly message
                $scope.openErrorModal("You are not authenticated to perform this operation. Please login");
              }
              else {
                $scope.openErrorModal(res.data.error.message);
              }
            }
            else {
              //You should never get here - format your error messages as suggested by the seed (backend)
              $scope.openErrorModal("You are not authenticated");
            }

          });

          $scope.$on("NotAuthorizedEvent", function (event, res) {
            if (typeof res.data.error !== "undefined" && res.data.error.message) {
              $scope.openErrorModal(res.data.error.message);
            }
            else {
              $scope.openErrorModal("You are not authorized to perform the requested operation");
            }
          });

          $scope.$on("HttpErrorEvent", function (event, res) {
            if (typeof res.data.error !== "undefined" && res.data.error.message) {
              $scope.openErrorModal(res.data.error.message);
            }
            else {
              $scope.openErrorModal("Unknown error during http request");
            }
          });

          clearUserDetails(userService);

          $scope.login = function () {
            $http.post('api/login', $scope.user)
                    .success(function (data) {
                      $window.sessionStorage.id_token = data.token;
                      initializeFromToken($scope, $window.sessionStorage.id_token, jwtHelper, userService);
                      teamService.getTeamsByUsername(userService.getUsername());
                      $location.path("#/");
                    })
                    .error(function (data) {
                      delete $window.sessionStorage.id_token;
                      clearUserDetails(userService);
                    });
          };

          $rootScope.logout = function () {
            clearUserDetails(userService);
            delete $window.sessionStorage.id_token;
            $location.path("#/");
          };

          $rootScope.openErrorModal = function (text) {
            var modalInstance = $uibModal.open({
              animation: true,
              templateUrl: 'errorModal.html',
              controller: function ($scope, $uibModalInstance) {
                $scope.error = text;
                $scope.ok = function () {
                  $uibModalInstance.close();
                };
              },
              size: 'sm'
            });
          };

          //This sets the login data from session store if user pressed F5 (You are still logged in)
          var init = function () {
            var token = $window.sessionStorage.id_token;
            if (token) {
              initializeFromToken($scope, $window.sessionStorage.id_token, jwtHelper, userService);
            }
          };
          init();// and fire it after definition
        })
        .factory('AuthInterceptor', function ($rootScope, $q) {
          return {
            responseError: function (response) {
              var name = "";
              switch (response.status) {
                case 401:
                  name = "NotAuthenticatedEvent";
                  break;
                case 403:
                  name = "NotAuthorizedEvent";
                  break;
                default :
                  name = "HttpErrorEvent";
              }
              $rootScope.$broadcast(name, response);
              return $q.reject(response);
            }
          };
        })
        .config(function Config($httpProvider, jwtInterceptorProvider) {
          jwtInterceptorProvider.tokenGetter = function () {
            return sessionStorage.getItem('id_token');
          };
          $httpProvider.interceptors.push('jwtInterceptor');
        });



function initializeFromToken($scope, token, jwtHelper, userService) {
  var tokenPayload = jwtHelper.decodeToken(token);
  
  userService.setIsAuthenticated(true);
  userService.setUsername(tokenPayload.username);
  userService.setIsAdmin(false);
  userService.setIsUser(false);
  
  tokenPayload.roles.forEach(function (role) {
    if (role === "Admin") {
      userService.setIsAdmin(true);
    }
    if (role === "User") {
      userService.setIsUser(true);
    }
  });
}

function clearUserDetails(userService) {
  userService.setIsAuthenticated(false);
  userService.setUsername('');
  userService.setIsAdmin(false);
  userService.setIsUser(false);
}