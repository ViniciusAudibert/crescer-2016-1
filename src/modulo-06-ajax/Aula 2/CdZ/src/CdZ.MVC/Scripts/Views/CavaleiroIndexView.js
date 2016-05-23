'use strict';

$(function () {
        //setInterval(function () {
        //    $.ajax({ url: urlCavaleiroGet, type: 'GET' }).done(function (res) {
        //        var novosCavaleiros = 0;
        //        res.data.forEach(function (cavaleiro) {
        //            if (cavaleiro.Id > lastId) {
        //                novosCavaleiros++;
        //                options.cavaleirosUi.append(
        //                        options.criarHtmlCavaleiro(cavaleiro)
        //                    );
        //                lastId = cavaleiro.Id;
        //            }
        //        })
        //        if (novosCavaleiros > 0)
        //            notificacaoNovosCavaleiros(novosCavaleiros);
        //    });
        //}, 5000);

    $('#txtDtNascimento').datepicker({
        dateFormat: 'dd/mm/yy'
    });

    var $frmNovoCavaleiro = $('#frmNovoCavaleiro');
    $frmNovoCavaleiro.submit(function (e) {

        var cavaleiro = converterFormParaCavaleiro($frmNovoCavaleiro);
        $.ajax({
            url: urlCavaleiroPost,
            type: "POST",
            data: cavaleiro
        });

        $frmNovoCavaleiro[0].reset();

        return e.preventDefault();
    });

    $('#btnAdicionarImg').click(function () {
        var $novoLi = gerarElementoLiComInputs();
        $('#new-img').append($novoLi);
    });

    $('#btnAdicionarGolpe').click(function () {
        var $novoLi = gerarElementoLiComInputsTexto();
        $('#new-golpe').append($novoLi);
    });
})

//var lastId = 0;

//function notificacaoNovosCavaleiros(quantidade) {
//    Notification.requestPermission().then(function (result) {
//        if (result === 'granted') {
//            var options = {
//                body: quantidade + (quantidade > 1 ? ' cavaleiros foram adicionados' : ' cavaleiro foi adicionado'),
//                icon: 'https://store-images.s-microsoft.com/image/apps.9373.9007199266533775.1fd0f66e-da51-4adb-bf76-6ed14c1f3ece.f3fd714a-5ef4-4ddf-b67f-22af9463c034?w=96&h=96&q=60'
//            }
//            new Notification('', options);
//        }
//    })
//};

function converterFormParaCavaleiro($form) {

    var formData = new FormData($form[0]);

    var data = $('#txtDtNascimento').datepicker('getDate');

    var novasImagens = [];
    $('#novasImagens li').each(function (i) {
        novasImagens.push({
            url: $(this).find('input[name=urlImagem]').val(),
            isThumb: $(this).find('input[name=isThumb]').is(':checked')
        });
    });

    var novosGolpes = [];
    $('#novosGolpes li').each(function (i) {
        novosGolpes.push({ texto: $(this).find('input[name=Golpes]').val() });
    });

    var nascimento = { texto: formData.get('LocalNascimento') };
    var treinamento = { texto: formData.get('LocalTreinamento') };
    //garante que o numero mandado nao tenha mais que duas casas decimais
    var peso = Math.round((parseFloat(formData.get('PesoLb')) * 2.20462262) * 100) / 100;

    return {
        nome: formData.get('Nome'),
        alturaCm: parseFloat(formData.get('AlturaCm')) * 100,
        pesoLb: peso,
        signo: formData.get('Signo'),
        tipoSanguineo: formData.get('TipoSanguineo'),
        dataNascimento: data.toISOString(),
        golpes: novosGolpes,
        localNascimento: nascimento,
        localTreinamento: treinamento,
        imagens: novasImagens      
    };
};

function gerarElementoLiComInputs() {
    return $('#golpe-form').clone();
};

function gerarElementoLiComInputsTexto() {
    return $('#img-form').clone();
};