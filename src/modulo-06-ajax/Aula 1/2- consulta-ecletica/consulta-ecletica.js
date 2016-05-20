$(function(){
  var $formArtista = $('#form-artista');
  $formArtista.submit(function(e){
    var formData = new FormData($formArtista[0]);
    var id = procurarArtista(formData.get('artista'));
    carregarTodasImagens(id);
    return e.preventDefault();
  })
})

function procurarArtista(artista) {
  var urlArtista = 'https://api.spotify.com/v1/search?q=' + artista.replaceAll(" ", "%20") + '&type=artist';
  var id;
  $.ajax({url:urlArtista}).then(
    function(e){
      id = e.artists.items[0].id;
    },
    function onError(e){
      id = '';
    }
  )
  return id;
}

function carregarTodasImagens(id){
  $('#content').empty();
  $('#content').append($('<ul>').attr('id','img-albuns'));
  var urlImage = 'https://api.spotify.com/v1/artists/' + id + '/albums?limit=50';
  $.ajax({url:urlImage}).then(
    function onSuccess(e){
      var $imgAlbunsList = $('#img-albuns');
      e.items.forEach(function(item){
        item.images.forEach(function(element){
          $imgAlbunsList.append($('<li>').append($('<img>').attr('src',element.url)));
        })
      })
    },
    function onError(e){
      alert('Artista não encontrado')
    })
  }
