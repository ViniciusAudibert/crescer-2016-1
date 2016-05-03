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

imprime(['Bernardo','Fabricio','Nunes'],function(imprime){
  console.log('Olá querido instrutor: ' + imprime);
});

// Exercicio 4 - Soma diferentona
var soma = 0;
function adicionar(a){ return soma += a;}

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
  if(typeof mascada === 'number' && precos.constructor === Array){
      lastFlipped = true;
      while(lastFlipped){
        lastFlipped = false;
        for(var i=0; i<precos.length-1; i++){
          if(precos[i] > precos[i+1]){
            temp = precos[i];
            precos[i] = precos[i+1];
            precos[i+1] = temp;
            lastFlipped = true;
          }
        }
      }
      var frase = '';
      for(var i=0; i<precos.length && precos[i] <= mascada; i++){
        frase += precos[i] + ',';
      }
      return frase.substring(0,frase.length-1);
  }
  else{return 'Parametro invalido';}
};

// Exercicio 7 - Vários tipos
function contarPorTipo(obj,valor){
  var arrayProperty = Object.getOwnPropertyNames(obj);
  var cont = 0;
  for(var i in arrayProperty){
    var tipo = obj[arrayProperty[i]];
    if(typeof tipo === valor || tipo + '' === valor || (tipo != null && valor === 'array' && tipo.constructor === Array)){
      cont++;
    }
  }
  return cont;
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
