'use strict';

function buscarCavaleiroPorId(id) {
    return $.ajax({ url: urlCavaleiroGetId, type: 'GET', data: { id: id } });
}

$(function () {
    $(document).on("click", ".info", function () {
        var idCavaleiro = $(this).parents('li:first').attr('data-id-cavaleiro');
        buscarCavaleiroPorId(idCavaleiro).then(
            function onSuccess(res) {
                $('#id_id').html(res.data.Id);
                $('#id_nome').html(res.data.Nome);
                $('#id_peso').html(res.data.PesoLb);
                $('#id_altura').html(res.data.AlturaCm);
                $('#id_nascimento').html(res.data.DataNascimento);
                $('#id_signo').html(res.data.Signo);
                $('#id_tipo_sanguineo').html(res.data.TipoSanguineo);
                $('#id_local_nascimento').html(res.data.LocalNascimento);
                $('#id_local_treinamento').html(res.data.LocalTreinameno);
                $('#id_golpes').html();
                $('#id_imagens').html();
                $('#info-cava').dialog({});
            },
            function onError(res) {
                alert("Erro ao buscar detalhes do cavaleiro");
            }
        );
    });
})