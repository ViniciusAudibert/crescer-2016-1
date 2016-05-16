using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace LojaNinja.MVC.Models.Login
{
    public class CadastroUsuarioModel
    {
        public CadastroUsuarioModel(string email,string senha,string nome)
        {
            this.Email = email;
            this.Senha = senha;
            this.Nome = nome;
            this.Permissoes = new string[]{ "DEFAULT" };
        }

        [Required]
        [DisplayName("E-mail")]
        [StringLength(100)]
        [EmailAddress]
        public string Email { get; private set; }
        [Required]
        [StringLength(8)]
        [PasswordPropertyText]
        public string Senha { get; private set; }
        [Required]
        [StringLength(100)]
        public string Nome { get; private set; }
        public string[] Permissoes { get; private set; }
    }
}