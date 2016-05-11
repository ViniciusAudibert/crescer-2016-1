using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace MVC.Controllers
{
    public class PokemonDigimonController : Controller
    {
        public ActionResult Index()
        {
            var request = Request.QueryString["nome"];
            if (request != null)
                ViewBag.CSS = request;
            else
            {
                ViewBag.CSS = "ViniciusAudibert";
            }
            return View();
        }
    }
}