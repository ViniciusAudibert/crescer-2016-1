using MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace MVC.Controllers
{
    public class StreetFighterController : Controller
    {
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult FichaTecnica()
        {
            return View(SobreMimModels());
        }

        public ActionResult Sobre()
        {
            return View(SobreMimModels());
        }

        SobreMimModel SobreMimModels()
        {
                return new SobreMimModel()
                {
                    PrimeiraAparicao = "Crescer",
                    Nascimento = new DateTime(1996,11,12),
                    Altura = 1.82,
                    Peso = 80,
                    Medidas = "B198, C120, Q172",
                    TipoSanguineo = 'O',
                    HabilidadesEspeciais = "Programar",
                    Gosta = "Series,Ficção e Animes",
                    Desgosta = "Spiders",
                    EstiloDeLuta = "Mental",
                    Origem = "Brasil",
                    FalaDeVitoria = "Ver você em ação é uma piada!",
                    SSF2Nickname = "A selvagem criança da natureza",
                    SFA3Nickname = "A animal pessoa amazônica",
                    SF4Nickname = "Guerreiro da selva",
                    SFA3Stage = "Ramificação do Rio Madeira - pantano, Brasil",
                    SF2Stage = "Bacia do rio Amazonas (Brasil).",
                    GolpesEspeciais = "Hello World"
                };
        }
    }
}