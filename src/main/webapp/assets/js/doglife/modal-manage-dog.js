let UIModalDog = {

    saveOrUpdate: function() {
        $("#btn-submit-dog").trigger("click");
    },

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
        
        event.preventDefault();
    },

    initForm: function() {
        $("#manage-dog-form").submit(UIModalDog.submit);
    },

    openModal: function() {
        $("#modal-manage-dogs").modal();
    },

    init: function() {
        this.initForm();
    }
};