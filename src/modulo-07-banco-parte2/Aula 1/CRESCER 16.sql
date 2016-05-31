--1) Liste os clientes e suas respectivas cidades.
--a. IDCliente, Nome, Nome da Cidade e UF.

SELECT CL.IDCLIENTE, CL.NOME, CD.NOME AS NOMECIDADE, CD.UF FROM CLIENTE CL INNER JOIN CIDADE CD ON CD.IDCIDADE = CL.IDCidade;

--2) Liste o total de pedidos realizados no m�s de maio de 2016.
--(Dica: verifique o uso do TO_DATE para convers�o de String em Date).

SELECT COUNT(1) AS TotalPedidos FROM PEDIDO WHERE EXTRACT(MONTH FROM DATAPEDIDO) = 5 AND EXTRACT(YEAR FROM DATAPEDIDO) = 2016;

--3) Liste todos os clientes que tenham o LTDA no nome ou razao social.

SELECT * FROM CLIENTE WHERE RAZAOSOCIAL LIKE '%ltda%' OR NOME LIKE '%ltda%';

--4) Crie (insira) um novo registro na tabela de Produto, com as seguintes informa��es:
--Nome: Galocha Maragato
--Pre�o de custo: 35.67
--Pre�o de venda: 77.95
--Situa��o: A



--5) Identifique e liste os produtos que n�o tiveram nenhum pedido, considere os relacionamentos no modelo de dados, pois n�o h� relacionamento direto entre Produto e Pedido (ser� preciso relacionar PedidoItem).
--Obs.: o produto criado anteriormente dever� ser listado (apenas este)
--6) Liste todos os pedidos de um determinado cliente, considere que sempre que for executar esta consulta ser� informado o IDCliente como par�metro. Dever�o ser listados: Data do Pedido, Produto, Quantide, Valor Unit�rio, e valor total.
--Exemplo: SELECT Nome FROM Cliente WHERE IDCliente = :pIDCliente
--Neste exemplo ser� solicitado que informe o par�metro para execu��o da consulta.
--7) Fa�a uma consulta que receba um par�metro sendo o IDProduto e liste a quantidade de itens na tabela PedidoItem com este IDProduto foram vendidos no �ltimo ano (desde janeiro/2016).
--8) Utilizando de fun��es de agrupamento (aggregation function), fa�a uma consulta que liste agrupando por ano e m�s a quantidade de pedidos comprados, a quantidade de produtos distintos comprados, o valor total dos pedidos, o menor valor de um pedido, o maior valor de um pedido e valor m�dio de um pedido.
--(Dica: a fun��o TO_CHAR permite converter Dates em String considerando formatos espec�ficos).