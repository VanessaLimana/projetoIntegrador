(function ($) {
    $('#cpf').mask('000.000.000-00', {reverse: true});

    $('#rendaMensal').maskMoney({
        prefix:'R$ ',
        allowNegative: true,
        thousands:'.',
        decimal:',',
        affixesStay: false
    });

    $.validator.setDefaults({
        highlight: function(element) {
            $(element).closest(".form-group").addClass("has-error");
        },
        unhighlight: function(element) {
            $(element).closest(".form-group").removeClass("has-error");
        },
        errorElement: "span",
        errorClass: "help-block",
        errorPlacement: function(error, element) {
            if(element.parent(".input-group").length) {
                error.insertAfter(element.parent());
            } else {
                error.insertAfter(element);
            }
        }
    });

    $("#form").validate({
        errorElement: "span",
        errorClass: "text-danger",
        submitHandler: function(form) {
            form.submit();
        }
    });
})(jQuery);