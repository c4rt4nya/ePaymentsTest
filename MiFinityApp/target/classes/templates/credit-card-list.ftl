<div class="generic-container">
	<div class="panel panel-default">
		<!-- Default panel contents -->
		<div class="panel-heading"><span class="lead">Search credit cards</span></div>
   		<div class="alert alert-success" role="alert" ng-if="ctrl.successMessage">{{ctrl.successMessage}}</div>
        <div class="alert alert-danger" role="alert" ng-if="ctrl.errorMessage">{{ctrl.errorMessage}}</div>
		<form ng-submit="ctrl.searchCreditCard()" name="myForm" class="form-horizontal">
		<div class="row">
			<div class="col-md-12">
				</br>
				<label class="col-md-2 floatLeft" for="pass">Credit card number</label>
				<div class="col-md-2">
					<input type="text" ng-model="ctrl.creditCard.cardNumber" id="uname" class="username form-control input-sm" placeholder="Enter the number" required¡"/>
				</div>
				<div class="form-actions ">
					<input type="submit"  value="Search" class="btn btn-primary btn-sm">
				</div>
			</div>
		</div>
		</form>
		<div class="panel-body">
			<div class="table-responsive">
		        <table class="table table-hover">
		            <thead>
		            <tr>
		                <th>Card number</th>
		                <th>Expiry date</th>
		            </tr>
		            </thead>
		            <tbody>
		            <tr ng-repeat="creditCard in ctrl.creditCardList">
		                <td>{{creditCard.cardNumber}}</td>
		                <td>{{creditCard.expiryDate | date:'yy-MM'}}</td>
		            </tr>
		            </tbody>
		        </table>		
			</div>
		</div>
        <div class="row">
            <div class="form-actions floatRight">
            		<button type="button" ng-click="ctrl.redirectToCreditCardPage()" class="btn btn-primary btn-sm">Add card page</button>
					<button type="button" ng-click="ctrl.redirectToLogin()" ng-show="!ctrl.isLogged()" class="btn btn-primary btn-sm">Login page</button>
					<button type="button" ng-click="ctrl.doLogout()" ng-show="ctrl.isLogged()" class="btn btn-primary btn-sm">Logout</button>	
            </div>
        </div>
        </br>
	</div>
</div>