// Exercicio 1 - Daisy Game
function daisyGame(n){
  if(n%2 === 0){
    return 'Love me not';
  }
  return 'Love me';
};

// Exercicio 2 - Maior texto
function maiorTexto(array){
  if(array.constructor === Array){
    var maior = '';
    for(var i in array){
      if(array[i].length > maior.length)
      maior = array[i];
    }
    return maior;
  }
  return 'Não é um array';
};

// Exercicio 3 - Instrutor querido
function imprime(array,fn){
  if(array.constructor === Array && fn.constructor === Function){
    for(var i in array){
      fn(array[i]);
    }
  }
}

// Exercicio 4 - Soma diferentona
function adicionar(numero1) {
  return function(numero2) {
    return numero1 + numero2;
  }
};

// Exercicio 5  - Fibona
function fiboSum(n){
  var a,b,resultado,sum;
  a = 0;
  b = 1;
  resultado = b;
  sum = 0;
  for(var i=1; i<=n; i++){
    sum += resultado;
    resultado = a+b;
    a=b;
    b=resultado;
  }
  return sum;
};

// Exercicio 6 - Quero café
function queroCafe(mascada,precos){
  var precosValidos = [];
  for (var i = 0; i < precos.length; i++) {
    if (precos[i] <= mascada) precosValidos.push(precos[i]);
  }
  return precosValidos.sort().toString();

// Exercicio 7 - Vários tipos
function contarPorTipo (objeto, tipo) {

  // inspirado em http://stackoverflow.com/a/13467007/5194966
  function getType(v) {
    return v === null ? 'null' : typeof v !== 'undefined' && v.constructor === Array ? 'array' : typeof v;
  }

  var count = 0;
  for (var campo in objeto) {
    if (getType(objeto[campo]) === tipo) count++;
  }

  return count;
}

// Exercicio 8 - Reflexões
var gohan = 'gohan', goku = 'Goku';
function revelarSaiyaman() {
  console.log(gohan);
  goku = 'Son Goku';
  var gohan = 'Son ' + gohan;
  return gohan;
}
console.log(revelarSaiyaman()); // O resultado é Son undefined porque no momento que digita var variavelX seu valor é undefined, logo var gohan = 'Son' gohan, gohan tem valor de undefined.
console.log(goku); // O resultado é Son Goku pois goku está sendo sobreescrito com essa string.
