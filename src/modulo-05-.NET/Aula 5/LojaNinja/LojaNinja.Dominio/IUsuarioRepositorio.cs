using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LojaNinja.Dominio
{
    public interface IUsuarioRepositorio
    {
        Usuario BuscarUsuarioPorAutenticacao(string email, string senha);
        List<Usuario> ObterUsuarios();
        void CadastrarUsuario(string email, string senha, string nome, string[] permissoes);
        bool ExisteUsuario(string email);
    }
}
