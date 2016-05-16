using LojaNinja.Dominio;
using LojaNinja.MVC.Models.Login;
using LojaNinja.MVC.Services;
using LojaNinja.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace LojaNinja.MVC.Controllers
{
    public class LoginController : Controller
    {
        private UsuarioServico usuarioServico;

        public LoginController()
        {
            usuarioServico = new UsuarioServico(
                    new UsuarioRepositorioADO()
                );
        }

        [HttpGet]
        public ActionResult Index()
        {
            if (!ServicoDeSessao.EstaLogado)
            {
                return View();
            }
            return RedirectToAction("Listagem","Pedido");
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Entrar(LoginViewModel loginViewModel)
        {
            if (ModelState.IsValid)
            {
                Usuario usuarioEncontrado =
                    usuarioServico.BuscarUsuarioPorAutenticacao(
                            loginViewModel.Email, loginViewModel.Senha
                        );

                if (usuarioEncontrado != null)
                {
                    var usuarioLogadoModel = new UsuarioLogadoModel(usuarioEncontrado);
                    ServicoDeSessao.CriarSessao(usuarioLogadoModel);
                    return RedirectToAction("Listagem","Pedido");
                }
                else
                {
                    ModelState.AddModelError("INVALID_USER", "Usuário ou senha inválido.");
                }
            }

            return View("Index");
        }

        public ActionResult CadastroUsuario()
        {
            return View();
        }
    }
}