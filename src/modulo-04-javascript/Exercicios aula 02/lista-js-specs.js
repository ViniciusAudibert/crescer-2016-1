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

describe('Ex 3. obterMesesComMaisAniversarios!', function() {
  it('Retorna um array com os meses que possuem mais aniversiariantes', function() {
    expect(obterMesesComMaisAniversarios()).toEqual(['março','maio','novembro']);
  })
})

describe('Ex 4. obterAlturaMedia!', function() {
  it('Retorna a altura media em metros dos cavaleiros', function() {
    expect(obterAlturaMedia()).toEqual(1.86);
  })
})

describe('Ex 5. obterAlturaMediana!', function() {
  it('Retorna a altura mediana em metros dos cavaleiros', function() {
    expect(obterAlturaMediana()).toEqual(1.85);
  })
})

describe('Ex 6. obterPesoMedio!', function() {
  it('Retorna o peso medio em kg apenas de cavaleiros com o atributo pesoLb', function() {
    expect(obterPesoMedio()).toEqual(84.27);
  })
})

describe('Ex 7. obterIMC!', function() {
  it('Retorna um array com todos os IMCs dos cavaleiros com o pesoLb registrado', function() {
    expect(obterIMC()).toEqual([22.64, 29.48, 24.62, 24.22, 24.84, 20.53, 24.54, 24.31, 23.99, 22.45, 21.5]);
  })
})

describe('Ex 8. obterSobrepeso!', function() {
  it('Retorna os cavaleiros com o indice IMC acima do peso', function() {
    expect(obterSobrepeso()[0].nome).toEqual('Aldebaran');
  })
})
