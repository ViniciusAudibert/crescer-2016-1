using CdZ.Dominio;
using CdZ.MVC.Extensions;
using CdZ.MVC.Filters;
using CdZ.MVC.Models.Cavaleiro;
using CdZ.MVC.Services;
using System.Collections;
using System.Collections.Generic;
using System.Net;
using System.Linq;
using System.Web.Mvc;
using System;
using System.Web.Script.Serialization;

namespace CdZ.MVC.Controllers
{
    [CdZAutorizador]
    public class CavaleiroController : Controller
    {
        private ICavaleiroRepositorio _cavaleiros = ServicoInjecaoDeDependecia.CriarCavaleiroRepositorio();

        [HttpGet]
        public ActionResult Index()
        {
            return View();
        }

        [HttpGet]
        public JsonResult Get()
        {
            /* Para simular erro, descomente
                var status = (int)HttpStatusCode.InternalServerError;
                throw new HttpException(status, "Ops");
            */
            //System.Threading.Thread.Sleep(3000);
            return Json(new { data = _cavaleiros.Todos().FromModel() }, JsonRequestBehavior.AllowGet);
        }

        public ActionResult CadastrarCavaleiro(CavaleiroViewModel cavaleiroForm)
        {
            IList<Golpe> golpes = cavaleiroForm.Golpes.Select(_ => new Golpe(_.Nome)).ToList();
            IList<Imagem> imagens = cavaleiroForm.Imagens.Select(_ => new Imagem(_.Url, _.IsThumb)).ToList();
            Local localNascimento = new Local(cavaleiroForm.LocalNascimento.Texto);
            Local localTreinamento = new Local(cavaleiroForm.LocalTreinamento.Texto);
            DateTime dataNascimento = StringExtensions.FromISOToDateTime(cavaleiroForm.DataNascimento);

            Cavaleiro cavaleiro = new Cavaleiro(cavaleiroForm.Nome,
                                                cavaleiroForm.AlturaCm,
                                                cavaleiroForm.PesoLb,
                                                dataNascimento,
                                                cavaleiroForm.Signo,
                                                cavaleiroForm.TipoSanguineo,
                                                localNascimento,
                                                localTreinamento,
                                                golpes,
                                                imagens);
            _cavaleiros.Adicionar(cavaleiro);
            TempData["cadastroSucesso"] = "Cavaleiro Cadastrado com sucesso!";

            return RedirectToAction("Index");
        }

        [HttpGet]
        [ActionName("GetById")]
        public JsonResult Get(int? id)
        {
            return Json(new { data = _cavaleiros.Buscar(id.Value).FromModel() }, JsonRequestBehavior.AllowGet);
        }

        [HttpPost]
        public JsonResult Post(CavaleiroViewModel cavaleiro)
        {
            //System.Threading.Thread.Sleep(3000);
            var novoId = _cavaleiros.Adicionar(cavaleiro.ToModel());
            Response.StatusCode = (int)HttpStatusCode.Created;
            return Json(new { id = novoId });
        }

        [HttpDelete]
        public JsonResult Delete(int id)
        {
            _cavaleiros.Excluir(id);
            return NoContentJsonVazio();
            // OU retornar a lista atualizada de todos cavaleiros
            // return Json(new { data = _cavaleiros.Todos() });
        }

        [HttpPut]
        public JsonResult Put(CavaleiroViewModel cavaleiro)
        {
            _cavaleiros.Atualizar(cavaleiro.ToModel());
            return NoContentJsonVazio();
        }

        private JsonResult NoContentJsonVazio()
        {
            Response.StatusCode = (int)HttpStatusCode.NoContent;
            return Json(new { });
        }
    }
}
