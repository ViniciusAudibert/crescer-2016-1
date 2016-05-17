using LojaNinja.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Cryptography;
using System.Text;
using System.Threading.Tasks;

namespace LojaNinja.Repositorio
{
    public class UsuarioRepositorio : IUsuarioRepositorio
    {
        private List<Usuario> usuarios = new List<Usuario>()
        {
            new Usuario("admin@admin.com", "63874adc5789a6e2e1fc51e40871dd53", "Administrador",new string[] { "ADMIN" })
        };

        public List<Usuario> ObterUsuarios()
        {
            return usuarios;
        }

        public void CadastrarUsuario(Usuario usuario)
        {
            usuarios.Add(usuario);
        }

        public Usuario BuscarUsuarioPorAutenticacao(string email, string senha)
        { 
            return usuarios.FirstOrDefault(c => c.Email.Equals(email) && c.Senha.Equals(senha));
        }

        public void CadastrarUsuario(string email, string senha, string nome, string[] permissoes)
        {
            usuarios.Add(new Usuario(email,senha,nome,permissoes));
        }

        public bool ExisteUsuario(string email)
        {
            return usuarios.Any(c => c.Email.Equals(email));
        }
    }
}
