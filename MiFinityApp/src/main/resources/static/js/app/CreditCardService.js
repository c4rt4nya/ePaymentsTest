'use strict';

angular.module('miFinityApp').factory('CreditCardService',
    ['$localStorage', '$http', '$q', 'urls',
        function ($localStorage, $http, $q, urls) {

            var factory = {
            		addCreditCard: addCreditCard,
            		searchCreditCard: searchCreditCard
            };

            return factory;

            function addCreditCard(creditCard) {
                console.log('Creating credit card');
                var deferred = $q.defer();
                $http.post(urls.CREDIT_CARD_SERVICE_API, creditCard)
                    .then(
                        function (response) {
                            deferred.resolve(response.data);
                        },
                        function (errorResponse) {
                           console.error('Error while creating User : '+errorResponse.data.errorMessage);
                           deferred.reject(errorResponse);
                        }
                    );
                return deferred.promise;
            }
            
            function searchCreditCard(creditCard, userId){
               var deferred = $q.defer();
               $http.get(urls.CREDIT_CARD_SEARCH_SERVICE_API + creditCard + '/' + userId)
                   .then(
                       function (response) {
                           console.log('Fetched successfully User with id :'+creditCard);
                           deferred.resolve(response.data);
                       },
                       function (errorResponse) {
                           console.error('Error while searching credit card with id :'+ creditCard);
                           console.error('Response: '+ errorResponse.data.toString());
                           deferred.reject(errorResponse);
                       }
                   );
               return deferred.promise;
            }

        }
    ]);