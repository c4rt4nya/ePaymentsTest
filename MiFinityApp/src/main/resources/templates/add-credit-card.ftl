<div class="generic-container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Add a credit card</span></div>
		<div class="panel-body">
	        <div class="formcontainer">
	            <div class="alert alert-success" role="alert" ng-if="ctrl.successMessage">{{ctrl.successMessage}}</div>
	            <div class="alert alert-danger" role="alert" ng-if="ctrl.errorMessage">{{ctrl.errorMessage}}</div>
	            <form ng-submit="ctrl.addCreditCard()" name="myForm" class="form-horizontal">
	                <input type="hidden" ng-model="ctrl.creditCard.id" />
	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="number">Number</label>
	                        <div class="col-md-7">
	                            <input type="number" ng-model="ctrl.creditCard.cardNumber" id="number" class="username form-control input-sm" placeholder="Enter the number" required ng-maxlength="16" ng-minlength="14"/>
	                        </div>
	                    </div>
	                </div>
	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="pass">Expiry date</label>
	                        <div class="col-md-7">
		                        <input type="month" ng-model="ctrl.creditCard.expiryDate" required />
	                        </div>
	                    </div>
	                </div>
	
	                <div class="row">
	                    <div class="form-actions floatRight">
	                        <input type="submit"  value="Add" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid || myForm.$pristine">
							<button type="button" ng-click="ctrl.redirectToLogin()" ng-show="!ctrl.isLogged()" class="btn btn-primary btn-sm">Login page</button>
							<button type="button" ng-click="ctrl.redirectToList()" ng-show="ctrl.isLogged()" class="btn btn-primary btn-sm">Search page</button>
							<button type="button" ng-click="ctrl.doLogout()" ng-show="ctrl.isLogged()" class="btn btn-primary btn-sm">Logout</button>
	                    </div>
	                </div>
	            </form>
    	    </div>
		</div>	
    </div>
</div>