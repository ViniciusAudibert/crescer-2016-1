using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LojaNinja.Dominio
{
    public class Usuario
    {
        public Usuario()
        {

        }

        public Usuario(string Email,string Senha,string Nome, IList<Permissao> Permissoes = null)
        {
            this.Email = Email;
            this.Senha = Senha;
            this.Nome = Nome;
            this.Permissoes = Permissoes;
        }

        public int ID { get; set; }
        public string Email { get; set; }
        public string Senha { get; set; }
        public string Nome { get; set; }
        public IList<Permissao> Permissoes { get; set; }
    }
}
