using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LojaNinja.Dominio
{
    public class Usuario
    {
        public Usuario(string Email,string Senha,string Nome, string[] Permissoes = null)
        {
            this.Email = Email;
            this.Senha = Senha;
            this.Nome = Nome;
            this.Permissoes = Permissoes;
        }

        public string Email { get; private set; }
        public string Senha { get; private set; }
        public string Nome { get; private set; }
        public string[] Permissoes { get; private set; }
    }
}
