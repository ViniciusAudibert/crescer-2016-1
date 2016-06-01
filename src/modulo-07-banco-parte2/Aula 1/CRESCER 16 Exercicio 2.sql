--1) Consultando cliente
--? Faça um bloco PL/SQL que receba UM parâmetro (em tempo de execução apenas): IDCliente, e então pesquise nome do cliente e cidade (caso tenha), e outras informações referente a pedidos:
--o Data da primeira compra (pedido) realizado;
--o Data da última compra realizada.
--o Valor total dos pedidos.
DECLARE
  vNome               VARCHAR2(30);
  vCidade             VARCHAR2(30);
  vDataUltimaCompra   DATE;
  vDataPrimeiraCompra DATE;
  vValorPedido        NUMERIC(12,2);
BEGIN
  SELECT CL.NOME,
    C.NOME,
    MIN(P.DATAPEDIDO),
    MAX(P.DATAPEDIDO),
    SUM(P.VALORPEDIDO)
  INTO vNome,
    vCidade,
    vDataPrimeiraCompra,
    vDataUltimaCompra,
    vValorPedido
  FROM PEDIDO P
  JOIN CLIENTE CL
  ON CL.IDCLIENTE = P.IDCLIENTE
  LEFT JOIN CIDADE C
  ON C.IDCIDADE      = CL.IDCIDADE
  WHERE CL.IDCLIENTE = :pIDCLIENTE
  GROUP BY CL.NOME,
    C.NOME;
  DBMS_OUTPUT.put_line('Cliente: ' || vNome || ' Cidade: ' || vCidade || ' Primeira compra: ' || vDataPrimeiraCompra || ' Ultima compra: ' || vDataUltimaCompra || ' Valor total: ' || vValorPedido);
END;
--2) Procedimento para inserir dados
--? Faça um bloco PL/SQL que receba DOIS parâmetros (em tempo de execução apenas): nome e uf, verifique se já existe um registro em Cidade para a combinação, caso não exista faça um INSERT na tabela de Cidade.
--o Utilize uma SEQUENCE para gerar o próximo ID válido;
--o Ignore o case sensitive na validação.
--o Se já existir a cidade+uf deve imprimir uma mensagem informando.
DECLARE
  vIDCIDADE INTEGER;
  vCidade varchar2(20); 
  vUF varchar2(2);
BEGIN

vCidade := '&_Cidade';
vUF := '&_UF';

  SELECT IDCIDADE
  INTO vIDCIDADE
  FROM CIDADE
  WHERE LOWER(NOME) = LOWER(vCIDADE)
  AND UF            = UPPER(vUF);
  
  INSERT
  INTO CIDADE
    (
      IDCIDADE,
      NOME,
      UF
    )
    VALUES
    (
      TR_SQ_CIDADE.nextval,
      vCIDADE,
      vUF
    );
EXCEPTION
  WHEN no_data_found THEN
    DBMS_OUTPUT_PUT_LINE('Essa cidade já existe');
END;