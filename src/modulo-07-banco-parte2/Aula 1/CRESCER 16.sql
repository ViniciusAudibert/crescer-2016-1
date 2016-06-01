--1) Liste os clientes e suas respectivas cidades.
--a. IDCliente, Nome, Nome da Cidade e UF.

SELECT CL.IDCLIENTE, CL.NOME, CD.NOME AS NOMECIDADE, CD.UF FROM CLIENTE CL INNER JOIN CIDADE CD ON CD.IDCIDADE = CL.IDCidade;

--2) Liste o total de pedidos realizados no mês de maio de 2016.
--(Dica: verifique o uso do TO_DATE para conversão de String em Date).

SELECT COUNT(1) AS TotalPedidos FROM PEDIDO WHERE EXTRACT(MONTH FROM DATAPEDIDO) = 5 AND EXTRACT(YEAR FROM DATAPEDIDO) = 2016;

--3) Liste todos os clientes que tenham o LTDA no nome ou razao social.

SELECT * FROM CLIENTE WHERE RAZAOSOCIAL LIKE '%ltda%' OR NOME LIKE '%ltda%';

--4) Crie (insira) um novo registro na tabela de Produto, com as seguintes informações:
--Nome: Galocha Maragato
--Preço de custo: 35.67
--Preço de venda: 77.95
--Situação: A

INSERT INTO PRODUTO(IDPRODUTO,NOME,DATACADASTRO,PRECOCUSTO,PRECOVENDA,SITUACAO) VALUES ((SELECT MAX(IDPRODUTO) FROM PRODUTO) + 1,'Galocha Maragato',SYSDATE,35.67,77.95,'A');

--5) Identifique e liste os produtos que não tiveram nenhum pedido, considere os relacionamentos no modelo de dados, pois não há relacionamento direto entre Produto e Pedido (será preciso relacionar PedidoItem).
--Obs.: o produto criado anteriormente deverá ser listado (apenas este)

SELECT PR.NOME FROM PRODUTO PR LEFT JOIN PEDIDOITEM PI ON PI.IDPRODUTO = null;

--6) Liste todos os pedidos de um determinado cliente, considere que sempre que for executar esta consulta será informado o IDCliente como parâmetro. Deverão ser listados: Data do Pedido, Produto, Quantide, Valor Unitário, e valor total.
--Exemplo: SELECT Nome FROM Cliente WHERE IDCliente = :pIDCliente
--Neste exemplo será solicitado que informe o parâmetro para execução da consulta.

SELECT PR.DATACADASTRO,PR.NOME,PI.QUANTIDADE,PI.PRECOUNITARIO,PI.PRECOUNITARIO * PI.QUANTIDADE AS PRECOTOTAL FROM PEDIDO P JOIN CLIENTE C ON C.IDCLIENTE = P.IDCLIENTE JOIN PEDIDOITEM PI ON PI.IDPEDIDO = P.IDPEDIDO JOIN PRODUTO PR ON PR.IDPRODUTO = PI.IDPRODUTO WHERE C.IDCLIENTE = :pIDCLIENTE; 

--7) Faça uma consulta que receba um parâmetro sendo o IDProduto e liste a quantidade de itens na tabela PedidoItem com este IDProduto foram vendidos no último ano (desde janeiro/2016).

SELECT PI.QUANTIDADE FROM PEDIDOITEM PI JOIN PRODUTO PR ON PR.IDPRODUTO = PI.IDPRODUTO JOIN PEDIDO P ON P.IDPEDIDO = PI.IDPEDIDO WHERE EXTRACT(MONTH FROM P.DATAPEDIDO) >= 1 AND EXTRACT(YEAR FROM P.DATAPEDIDO) >= 2016 AND PR.IDPRODUTO = :pIDPRODUTO;


--8) Utilizando de funções de agrupamento (aggregation function), faça uma consulta que liste agrupando por ano e mês a quantidade de pedidos comprados, a quantidade de produtos distintos comprados, o valor total dos pedidos, o menor valor de um pedido, o maior valor de um pedido e valor médio de um pedido.
--(Dica: a função TO_CHAR permite converter Dates em String considerando formatos específicos).

SELECT TO_CHAR(P.DATAPEDIDO, 'MON-YYYY') AS DATAPEDIDO, SUM(P.VALORPEDIDO) AS VALORTOTAL ,COUNT(1) AS QUANTIDADETOTOALPRODUTOS, MIN(P.VALORPEDIDO) AS MENORVALOR, MAX(P.VALORPEDIDO) AS MAIORVALOR, TO_CHAR(AVG(P.VALORPEDIDO), 'fm9999999.90') AS PRECOMEDIO FROM PEDIDO P JOIN PEDIDOITEM PI ON P.IDPEDIDO = PI.IDPEDIDO GROUP BY PI.IDPRODUTO, TO_CHAR(P.DATAPEDIDO, 'MON-YYYY');

SELECT * FROM PEDIDO;

SELECT * FROM PRODUTO;

SELECT PI.IDPRODUTO, COUNT(1) FROM PEDIDOITEM PI JOIN PRODUTO PR ON PR.IDPRODUTO = PI.IDPRODUTO GROUP BY PI.IDPRODUTO;