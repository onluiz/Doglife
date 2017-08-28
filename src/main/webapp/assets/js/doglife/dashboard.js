let UIDashboard = {

    loadModalsHtml: function() {
        $("#div-modal-manage-dogs").load("modal-manage-dog.html");
    },

    init: function() {
        this.loadModalsHtml();
    }

};