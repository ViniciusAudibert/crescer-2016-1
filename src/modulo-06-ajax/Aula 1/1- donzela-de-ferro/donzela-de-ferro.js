$('#btn-todos').click(function carregarTodasImagens(){
  $('#content').empty();
  $('#content').append($('<ul>').attr('id','img-albuns'));
  $.ajax({url:"https://api.spotify.com/v1/artists/6mdiAmATAx73kdxrNrnlao/albums?limit=50"}).then(
    function onSuccess(e){
      var $imgAlbunsList = $('#img-albuns');
      e.items.forEach(function(item){
        item.images.forEach(function(element){
          $imgAlbunsList.append($('<li>').append($('<img>').attr('src',element.url)));
        })
      })
    })
  })
