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
using PagedList;

namespace CdZ.MVC.Controllers
{
    [CdZAutorizador]
    public class CavaleiroController : Controller
    {
        private ICavaleiroRepositorio _cavaleiros = ServicoInjecaoDeDependecia.CriarCavaleiroRepositorio();

        [HttpGet]
        public ActionResult Index()
        {
            return View("Listagem");
        }

        [HttpGet]
        public ActionResult List(int? page)
        {
            int pageSize = 2;
            int pageNumber = (page ?? 1);
            return PartialView("_ListagemCaveleiros", _cavaleiros.Todos().FromModel().ToPagedList(pageNumber, pageSize));
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

        [HttpGet]
        public ViewResult Editar(int id)
        {
            var cavaleiroViewModel = new CavaleiroViewModel();
            cavaleiroViewModel.CavaleiroParaViewModel(_cavaleiros.Buscar(id));
            return View("cadastrar", cavaleiroViewModel);
        }

        [HttpGet]
        public ViewResult Cadastrar()
        {
            return View();
        }

        private JsonResult NoContentJsonVazio()
        {
            Response.StatusCode = (int)HttpStatusCode.NoContent;
            return Json(new { });
        }
    }
}
