using LojaNinja.Dominio;
using LojaNinja.MVC.Models;
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

        public ActionResult Manter(int? id)
        {
            if (id.HasValue)
            {
                var pedido = repositorio.ObterPedidoPorId(id.Value);

                var model = new PedidoModel()
                //{
                //    Id = pedido.Id,
                //    DataEntrega = pedido.DataEntregaDesejada,
                //    NomeCliente = pedido.NomeCliente,
                //    //...
                //}
                ;

                return View("Manter", model);
            }
            else
            {
                return View("Manter");
            }
        }

        public ActionResult Salvar(PedidoModel model)
        {
            if (ModelState.IsValid)
            {
                try
                {
                    var pedido = new Pedido(model.DataEntrega, model.NomeProduto, model.Valor, model.TipoPagamento, model.NomeCliente, model.Cidade, model.Estado);
                    repositorio.IncluirPedido(pedido);

                    ViewBag.MensagemSucesso = "Pedido salvo com sucesso!";
                    return View("Detalhes", pedido);
                }
                catch (ArgumentException ex)
                {
                    ModelState.AddModelError("", ex.Message);
                }
            }

            return View("Cadastro");
        }

        public ActionResult Detalhes(int id)
        {
            var pedido = repositorio.ObterPedidoPorId(id);

            return View(pedido);
        }

        public ActionResult Listagem(string cliente, string produto)
        {
            ViewBag.cliente = Request.QueryString["cliente"];
            ViewBag.produto = Request.QueryString["produto"];
            var pedidos = repositorio.ObterPedidos();

            return View(pedidos);
        }

        public ActionResult Excluir(int id)
        {
            repositorio.ExcluirPedido(id);

            TempData["alerta"] = "";
            return RedirectToAction("Listagem");
        }
    }
}