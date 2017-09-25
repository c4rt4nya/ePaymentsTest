'use strict';

angular.module('miFinityApp').factory('UserService',
    ['$localStorage', '$http', '$q', 'urls',
        function ($localStorage, $http, $q, urls) {

            var factory = {
                createUser: createUser,
                loginUser: loginUser,
                logout: logout,
        		user: {}
            };

            return factory;

            function createUser(user) {
                console.log('Creating User');
                var deferred = $q.defer();
                $http.post(urls.USER_SERVICE_API, user)
                    .then(
                        function (response) {
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                           console.error('Error while creating User : '+errResponse.data.errorMessage);
                           deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }
            
            function loginUser (user) {
                console.log('Login User');
                var deferred = $q.defer();
                $http.post(urls.USER_LOGIN_SERVICE_API, user)
                    .then(
                        function (response) {
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                           console.error('Error while login in: '+errResponse.data.errorMessage);
                           deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }
        
            function logout() {
                console.log('Logging out');
                factory.user = {};
            }

        }
    ]);