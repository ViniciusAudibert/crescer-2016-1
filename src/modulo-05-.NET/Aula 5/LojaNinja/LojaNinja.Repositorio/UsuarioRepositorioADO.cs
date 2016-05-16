using LojaNinja.Dominio;
using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Transactions;

namespace LojaNinja.Repositorio
{
    public class UsuarioRepositorioADO : IUsuarioRepositorio
    {
        public Usuario BuscarUsuarioPorAutenticacao(string email, string senha)
        {
            string connectionString = ConfigurationManager.ConnectionStrings["ConectionDB"].ConnectionString;

            using (var conexao = new SqlConnection(connectionString))
            {
                string sql = "SELECT * FROM user WHERE email=@p_email and senha=@p_senha";

                var comando = new SqlCommand(sql, conexao);
                comando.Parameters.Add(new SqlParameter("p_email", email));
                comando.Parameters.Add(new SqlParameter("p_senha", senha));

                conexao.Open();

                SqlDataReader leitor = comando.ExecuteReader();

                Usuario user = null;
                if(leitor.Read())
                {
                    var emailUsuario = leitor["Email"].ToString();
                    var senhaUsuario = leitor["Senha"].ToString();
                    var nomeUsuario = leitor["Nome"].ToString();

                    user = new Usuario(emailUsuario, senhaUsuario, nomeUsuario);
                }
                return user; 
            }
        }

        public void CadastrarUsuario(Usuario usuario)
        {
            throw new NotImplementedException();
        }

        public List<Usuario> ObterUsuarios()
        {
            throw new NotImplementedException();
        }
    }
}
