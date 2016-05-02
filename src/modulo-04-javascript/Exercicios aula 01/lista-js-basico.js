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
function adicionar(a){ return a;} // Incompleto

adicionar(1)+(3);

// Exercicio 5  - Fibona
function fiboSum(n){
  function fibonacci(fib){
    if (fib <= 1) return fib;
    else return fib(fib-1) + fib(fib-2);
  }
  for(int i=1; i<=n; i++){

  }
}
