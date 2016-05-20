$(function(){
  var $formArtista = $('#form-artista');
  $formArtista.submit(function(e){
    var formDataArtista = new FormData($formArtista[0]).get('artista');
    var id = procurarArtista(formDataArtista);
    carregarTodasImagens(id,formDataArtista);
    return e.preventDefault();
  })
})

function procurarArtista(artista) {
  var urlArtista = 'https://api.spotify.com/v1/search?q=' + artista.replaceAll(" ", "%20") + '&type=artist';
  var id;
  $.get({url:urlArtista}).then(
    function onSuccess(e){
      id = e.artists.items[0].id;
    },
    function onError(e){
      id = '';
    })
  return id;
}

function carregarTodasImagens(id,artista){
  $('#content').empty();
  $('#content').append($('<ul>').attr('id','img-albuns'));

  if(id === '1uNFoZAHBGtllmzznpCI3s' && gerarNumeroComProbabilidade() === 1){
    id = 'Douchebag';
  }

  var urlImage = 'https://api.spotify.com/v1/artists/' + id + '/albums?limit=50';
  $.ajax({url:urlImage})
    .then(
      function onSuccess(e){
        var $imgAlbunsList = $('#img-albuns');
        e.items.forEach(function(item){
          item.images.forEach(function(element){
            $imgAlbunsList.append($('<li>').append($('<img>').attr('src',element.url)));
          })
        })
      },
      function onError(e){
        errorMessage(artista,e.status)
      })
    }

    function gerarNumeroComProbabilidade() {
      var numerosProbabilidade = [1, 1, 1, 1, 1, 1, 1, 1, 2, 2];
      var index = Math.floor(Math.random() * numerosProbabilidade.length);
      return numerosProbabilidade[index];
    }

    function errorMessage(artista,erro){
      var mensagem = 'Caro usuário, devido a um erro ' + erro + ', não foi possível pesquisar por ' + artista;
      alert(mensagem);
    }
