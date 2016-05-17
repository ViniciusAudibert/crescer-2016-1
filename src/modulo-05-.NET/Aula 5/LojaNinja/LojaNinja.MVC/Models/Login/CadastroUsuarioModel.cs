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
        public CadastroUsuarioModel()
        {
            this.Permissoes = new string[] { "DEFAULT" };
        }

        [Required]
        [DisplayName("E-mail")]
        [StringLength(100)]
        [EmailAddress]
        public string Email { get; set; }
        [Required]
        [StringLength(8)]
        [PasswordPropertyText]
        public string Senha { get; set; }
        [Required]
        [StringLength(100)]
        public string Nome { get; set; }
        public string[] Permissoes { get; private set; }
    }
}