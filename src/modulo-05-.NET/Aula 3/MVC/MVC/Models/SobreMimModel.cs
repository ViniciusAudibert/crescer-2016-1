using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MVC.Models
{
    public class SobreMimModel
    {
        public string PrimeiraAparicao { get; set; }
        public DateTime Nascimento { get; set; }
        public double Altura { get; set; }
        public double Peso { get; set; }
        public string Medidas { get; set; }
        public char TipoSanguineo { get; set; }
        public string HabilidadesEspeciais { get; set; }
        public string Gosta { get; set; }
        public string Desgosta { get; set; }
        public string EstiloDeLuta { get; set; }
        public string Origem { get; set; }
        public string FalaDeVitoria { get; set; }
        public string SSF2Nickname { get; set; }
        public string SFA3Nickname { get; set; }
        public string SF4Nickname { get; set; }
        public string SFA3Stage { get; set; }
        public string SF2Stage { get; set; }
        public string GolpesEspeciais { get; set; }
    }
}
