sap.ui.define(
    ["jquery.sap.global"],
    function (JQuery) {
        return {
            callService: function (sURL, sMethod, oPayload) {
                return new Promise(function (resolve, reject) {
                    switch (sMethod.toUpperCase()) {
                        case "GET":
                            jQuery.ajax(sURL, {
                                type: 'GET',
                                success: function (data) {
                                    resolve(data)
                                },
                                error: function (err) {
                                    reject(err)
                                }
                            });
                            break;
                        case "POST":
							jQuery.ajax(sURL, {
                                type: 'POST',
                                contentType: 'application/json',
                                data: JSON.stringify(oPayload),
                                success: function (data) {
                                    resolve(data)
                                },
                                error: function (err) {
                                    reject(err)
                                }
                            });
                            break;
                    }
                });
            }
        }
    }
);