let UIWelcome = function () {

    submit: function(event) {
        function objectifyForm(formArray) {
            var returnArray = {};
            for (var i = 0; i < formArray.length; i++){
                returnArray[formArray[i]['name']] = formArray[i]['value'];
            }
            return returnArray;
        }

        let form = objectifyForm($(this).serializeArray());
        var formJson = JSON.stringify(form);

        console.log(formJson);

        event.preventDefault();
    },

    initForm: function() {
        $("#form-user-register").submit(UIWelcome.submit);
    },

    init: function() {
        this.initForm();
    }
    
};