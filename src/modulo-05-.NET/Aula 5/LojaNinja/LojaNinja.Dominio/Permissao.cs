using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LojaNinja.Dominio
{
    public class Permissao
    {
        public Permissao()
        {

        }

        public int ID { get; set; }
        public string Permissoes { get; set; }
        public IList<Usuario> Usuarios { get; set; }

    }
}
