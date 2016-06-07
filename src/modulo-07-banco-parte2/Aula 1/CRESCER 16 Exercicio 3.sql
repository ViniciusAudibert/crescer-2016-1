--1) Consultando cliente
--? Fa�a um bloco PL/SQL que receba UM par�metro (em tempo de execu��o apenas): IDCliente, e ent�o pesquise nome do cliente e cidade (caso tenha), e outras informa��es referente a pedidos:
--o Data da primeira compra (pedido) realizado;
--o Data da �ltima compra realizada.
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
--? Fa�a um bloco PL/SQL que receba DOIS par�metros (em tempo de execu��o apenas): nome e uf, verifique se j� existe um registro em Cidade para a combina��o, caso n�o exista fa�a um INSERT na tabela de Cidade.
--o Utilize uma SEQUENCE para gerar o pr�ximo ID v�lido;
--o Ignore o case sensitive na valida��o.
--o Se j� existir a cidade+uf deve imprimir uma mensagem informando.
DECLARE
  vCidade VARCHAR2(20);
  vUF     VARCHAR2(2);
  vCount  INTEGER;
BEGIN
  vCidade := '&_Cidade';
  vUF     := '&_UF';
  SELECT COUNT(1)
  INTO vCount
  FROM CIDADE
  WHERE LOWER(NOME) = LOWER(vCIDADE)
  AND UPPER(UF)     = UPPER(vUF);
  if(vCount = 0) THEN
  INSERT
  INTO CIDADE
    (
      IDCIDADE,
      NOME,
      UF
    )
    VALUES
    (
      SQCIDADE.nextval,
      vCIDADE,
      vUF
    );
    COMMIT;
    ELSE
      DBMS_OUTPUT.PUT_LINE('Essa cidade j� existe');
    END IF;
END;