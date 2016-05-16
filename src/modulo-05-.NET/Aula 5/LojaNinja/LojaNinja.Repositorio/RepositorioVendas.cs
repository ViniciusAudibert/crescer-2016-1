﻿using LojaNinja.Dominio;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LojaNinja.Repositorio
{
    public class RepositorioVendas
    {
        private const string PATH_ARQUIVO = @"C:\Users\vinicius.audibert\Documents\crescer-2016-1\src\modulo-05-.NET\Aula 5\LojaNinja\Vendas.txt";

        private static readonly object objetoLock = new object();

        public List<Pedido> ObterPedidos()
        {
            var linhasArquivo = File.ReadAllLines(PATH_ARQUIVO, Encoding.UTF8).ToList();

            return ConverteLinhasEmPedidos(linhasArquivo);
        }

        public Pedido ObterPedidoPorId(int id)
        {
            return this.ObterPedidos().FirstOrDefault(x => x.Id == id);
        }

        public void IncluirPedido(Pedido pedido)
        {
            lock (objetoLock)
            {
                var utlimoId = 0;
                if (ObterPedidos().Count > 1)
                    utlimoId = this.ObterPedidos().Max(x => x.Id);
                var idGerado = utlimoId + 1;
                var novaLinha = ConvertePedidoEmLinhaCSV(pedido, idGerado);

                File.AppendAllText(PATH_ARQUIVO, novaLinha);

                pedido.AtualizarId(idGerado);
            }
        }

        private string ConvertePedidoEmLinhaCSV(Pedido pedido, int proximoId)
        {
            return string.Format(Environment.NewLine + "{0};{1};{2};{3};{4};{5};{6};{7};{8};{9}",
                                proximoId,
                                pedido.DataPedido.ToString("dd/MM/yyyy HH:mm"),
                                pedido.DataEntregaDesejada.ToString("dd/MM/yyyy HH:mm"),
                                pedido.NomeProduto,
                                pedido.Valor,
                                pedido.TipoPagamento,
                                pedido.NomeCliente,
                                pedido.Cidade,
                                pedido.Estado,
                                pedido.PedidoUrgente);
        }

        public void AtualizarPedido(Pedido pedido,int? id)
        {
            var pedidos = ObterPedidos();
            var cabecalho = File.ReadLines(PATH_ARQUIVO).First();
            File.WriteAllText(PATH_ARQUIVO, string.Empty);
            File.AppendAllText(PATH_ARQUIVO, cabecalho);
            foreach (var linha in pedidos)
            {
                if (linha.Id == id)
                    IncluirPedido(pedido);

                else
                    IncluirPedido(linha);
            }
        }

        public void ExcluirPedido(int id)
        {
            var linhas = ObterPedidos().Where(pedido => pedido.Id != id).ToList();
            var cabecalho = File.ReadLines(PATH_ARQUIVO).First();
            File.WriteAllText(PATH_ARQUIVO, string.Empty);
            File.AppendAllText(PATH_ARQUIVO, cabecalho);
            foreach (var linha in linhas)
            {
                IncluirPedido(linha);
            }
        }

        private List<Pedido> ConverteLinhasEmPedidos(List<string> linhasArquivo)
        {
            var listaPedidos = new List<Pedido>();

            //Remove linha do cabeçalho
            linhasArquivo.RemoveAt(0);

            foreach (var linha in linhasArquivo)
            {
                var id = Convert.ToInt32(linha.Split(';')[0]);
                var dataPedido = Convert.ToDateTime(linha.Split(';')[1]);
                var dataEntregaDesejada = Convert.ToDateTime(linha.Split(';')[2]);
                var nomeProduto = linha.Split(';')[3];
                var valorVenda = Convert.ToDecimal(linha.Split(';')[4]);
                TipoPagamento tipoPagamento;
                Enum.TryParse(linha.Split(';')[5], out tipoPagamento);
                var nomeCliente = linha.Split(';')[6];
                var cidade = linha.Split(';')[7];
                var estado = linha.Split(';')[8];
                var urgente = Convert.ToBoolean(linha.Split(';')[9]);

                var pedido = new Pedido(id, dataPedido, dataEntregaDesejada, nomeProduto, valorVenda, tipoPagamento, nomeCliente, cidade, estado, urgente);
                listaPedidos.Add(pedido);
            }

            return listaPedidos;
        }

        public List<Pedido> BuscaCliente(String cliente)
        {
            var pedidos = ObterPedidos().Where(pedido => pedido.NomeCliente.IndexOf(cliente, StringComparison.OrdinalIgnoreCase) >= 0).ToList();
            return pedidos;
        }

        public List<Pedido> BuscaProduto(String produto)
        {
            var pedidos = ObterPedidos().Where(pedido => pedido.NomeProduto.IndexOf(produto, StringComparison.OrdinalIgnoreCase) >= 0).ToList();
            return pedidos;
        }
        public List<Pedido> BuscaClienteEProduto(String cliente,String produto)
        {
            var pedidos = ObterPedidos().Where(pedido => pedido.NomeProduto.IndexOf(produto,StringComparison.OrdinalIgnoreCase) >= 0 &&
                                                         pedido.NomeCliente.IndexOf(cliente, StringComparison.OrdinalIgnoreCase) >= 0).ToList();
            return pedidos;
        }
    }
}