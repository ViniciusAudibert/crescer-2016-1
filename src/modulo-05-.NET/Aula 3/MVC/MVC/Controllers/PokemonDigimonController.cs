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
            ViewBag.CSS = Request.QueryString["nome"];            
            
            return View();
        }
    }
}