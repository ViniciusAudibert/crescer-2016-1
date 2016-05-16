using LojaNinja.Dominio;
using LojaNinja.MVC.Filters;
using LojaNinja.MVC.Models;
using LojaNinja.MVC.Services;
using LojaNinja.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace LojaNinja.MVC.Controllers
{
    public class PedidoController : Controller
    {
        private RepositorioVendas repositorio = new RepositorioVendas();
  
        public ActionResult Cadastro()
        {
            return View();
        }

        public ActionResult Salvar(PedidoModel model)
        {
            if (ModelState.IsValid)
            {
                Pedido pedido;
                try
                {
                    pedido = new Pedido(model.DataEntrega, 
                                        model.NomeProduto, 
                                        model.Valor, 
                                        model.TipoPagamento, 
                                        model.NomeCliente, 
                                        model.Cidade, 
                                        model.Estado);
                    if (model.Id.HasValue)
                    {
                        repositorio.AtualizarPedido(pedido,model.Id);
                        return View("Detalhes", pedido);
                    }
                    else
                    {
                        repositorio.IncluirPedido(pedido);
                        return View("Detalhes", pedido);
                    }
                }
                catch (ArgumentException ex)
                {
                    ModelState.AddModelError("", ex.Message);
                    return View("Cadastro", model);
                }
            }
            else
            {
                return View("Cadastro", model);
            }
        }

        public ActionResult Detalhes(int id)
        {
            var pedido = repositorio.ObterPedidoPorId(id);
            return View(pedido);
        }

        [CWIToken]
        [HttpGet]
        public ActionResult Listagem(string cliente, string produto)
        {
            var pedidos = repositorio.ObterPedidos();
            var isClienteNull = String.IsNullOrWhiteSpace(cliente);
            var isProdutoNull = String.IsNullOrWhiteSpace(produto);

            if (isClienteNull && isProdutoNull)
            {
                return View(pedidos);
            }
            else if (isClienteNull){
                List<Pedido> produtoLista = repositorio.BuscaProduto(produto);
                return produtoLista == null ? View(pedidos) : View(produtoLista);
            }
            else if(isProdutoNull)
            {
                List<Pedido> clienteLista = repositorio.BuscaCliente(cliente);
                return clienteLista == null ? View(pedidos) : View(clienteLista);
            }
            else
            {
                var BuscaClienteEProduto = repositorio.BuscaClienteEProduto(cliente,produto);
                return BuscaClienteEProduto == null ? View(pedidos) : View(BuscaClienteEProduto);
            }
        }

        public ActionResult Excluir(int id)
        {
            repositorio.ExcluirPedido(id);
            TempData["alerta"] = "";
            return RedirectToAction("Listagem");
        }

        public ActionResult Editar(int id)
        {
            var pedido = repositorio.ObterPedidoPorId(id);
            PedidoModel pedidoModel = new PedidoModel
            {
                NomeCliente = pedido.NomeCliente,
                NomeProduto = pedido.NomeProduto,
                Id = pedido.Id,
                Cidade = pedido.Cidade,
                DataEntrega = pedido.DataEntregaDesejada,
                Estado = pedido.Estado,
                TipoPagamento = pedido.TipoPagamento,
                Valor = pedido.Valor
            };
            return View("Cadastro", pedidoModel);
        }
    }
}