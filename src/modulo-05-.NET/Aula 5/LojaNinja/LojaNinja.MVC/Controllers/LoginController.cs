using LojaNinja.Dominio;
using LojaNinja.MVC.Models.Login;
using LojaNinja.MVC.Services;
using LojaNinja.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;
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
            return RedirectToAction("Listagem", "Pedido");
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
                    return RedirectToAction("Listagem", "Pedido");
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

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Cadastrar(CadastroUsuarioModel cadastroUsuarioModel)
        {
            if (ModelState.IsValid)
            {
                bool usuarioExistente = usuarioServico.BuscarUsuarioPorEmail(cadastroUsuarioModel.Email);

                if (!usuarioExistente)
                    if (ValidacaoSenha(cadastroUsuarioModel.Senha))
                    { 
                        usuarioServico.CadastrarUsuario(
                            new Usuario(cadastroUsuarioModel.Email,
                                        cadastroUsuarioModel.Senha,
                                        cadastroUsuarioModel.Nome
                            )
                        );
                        TempData["Cadastro"] = "Cadastrado com sucesso!";
                        return RedirectToAction("Index", "Login");
                    }
                    else
                    {
                        ModelState.AddModelError("INVALID_USER", "A senha deve ter pelo menos 8 caracteres uma letra minuscula, uma maiuscula e um numero");
                        return View("CadastroUsuario");
                    }
                else
                {
                    ModelState.AddModelError("INVALID_USER", "Esse email já foi usado");
                    return View("CadastroUsuario");
                }
            }

            return View("Index");
        }

        public ActionResult Logout()
        {
            Session.Abandon();
            return RedirectToAction("Index");
        }

        private bool ValidacaoSenha(string senha)
        {
            var regex = new Regex(@"^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,}$");
            return regex.IsMatch(senha);
        }
    }
}