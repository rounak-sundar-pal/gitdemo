sap.ui.define(
	["sap/ui/core/mvc/Controller",
	 "jquery.sap.global",
	 "rick/util/service",
	 "sap/m/MessageBox"],
	function(Controller, jQuery , service , MessageBox){
	return Controller.extend("rick.controller.Main",{
	    onInit: function(){
	    	var oModel = new sap.ui.model.json.JSONModel();
	    	oModel.setData({
	    		"postPayLoad":{
	    			"companyName" : "",
	    			"firstName" : "",
	    			"lastName" : "",
	    			"website" : "",
	    			"email" : "",
	    			"status" : "A",
	    			"gstNo" : ""
	    		},
	    		"vendor":{}
	    	});
			sap.ui.getCore().setModel(oModel);
	    },
	    onSave: function(){
	     	var oModel = sap.ui.getCore().getModel(oModel);	 
	     	var payLoad = oModel.getProperty("/postPayLoad");
	     	service.callService("/vendor","POST",payLoad).then(function(){
	     		MessageBox.confirm("Saved Success");
	     	}).catch(function(){
	     		MessageBox.error("post failed");
	     	});
	    },
		onLoadData: function(){
			//alert("Hello World!!");
			var that = this;
			service.callService("newVendor","GET",{}).then(function(data){
				var oTable = that.getView().byId("idTable");
				var oModel = sap.ui.getCore().getModel();
				oModel.setProperty("/vendor" , data._embedded.vendor);
				oTable.bindRows("/vendor");
			}).catch(function(){
			
			});
		}
	});

});