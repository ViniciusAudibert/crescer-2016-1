'use strict';

describe('Ex 1. obterDoadores!', function() {
  it('Retorna os cavaleiro doadores tipo sanguineo "O"', function() {
    var array = obterDoadores();
    expect(array[0].nome).toEqual('Aiolia');
    expect(array[1].nome).toEqual('Aiolos');
    expect(array[2].nome).toEqual('Afrodite');
  });
});

describe('Ex 2. obterCavaleiroComMaisGolpes!', function() {
  it('Retorna o cavaleiro com mais golpes', function() {
    expect(obterCavaleiroComMaisGolpes().nome).toEqual('Shaka');
  })
})
