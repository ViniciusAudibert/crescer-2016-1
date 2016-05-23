using CdZ.Dominio;
using CdZ.MVC.Models.Cavaleiro;
using System.Collections.Generic;
using System.Linq;

namespace CdZ.MVC.Extensions
{
    public static class CavaleiroExtensions
    {
        /// <summary>
        /// Este método visa fazer o mapeamento dos objetos que estão no banco para aqueles que são enviados ou recebidos pelos AJAX.
        /// Colocamos este método de extensão aqui para não "corromper" a "camada" (sic) do domínio.
        /// </summary>
        public static CavaleiroViewModel FromModel(this Cavaleiro cavaleiro)
        {
           string urlThumb = cavaleiro.Imagens.Where(_ => _.IsThumb).Select(_ => _.Url).FirstOrDefault();

           return new CavaleiroViewModel
            {
                Id = cavaleiro.Id,
                Nome = cavaleiro.Nome,
                AlturaCm = cavaleiro.AlturaCm,
                DataNascimento = cavaleiro.DataNascimento,
                Golpes = cavaleiro.Golpes.FromModel(),
                UrlThumb = urlThumb != null ? urlThumb : "https://gamurs.com/images/48322143-e971-4f32-9f13-e5d7aba6d516.png",
                LocalNascimento = cavaleiro.LocalNascimento != null ? cavaleiro.LocalNascimento.FromModel() : null,
                LocalTreinamento = cavaleiro.LocalTreinamento != null ? cavaleiro.LocalTreinamento.FromModel() : null,
                PesoLb = cavaleiro.PesoLb,
                Signo = cavaleiro.Signo,
                TipoSanguineo = cavaleiro.TipoSanguineo
            };
        }

        /// <summary>
        /// Este método visa fazer o mapeamento dos objetos que estão no banco para aqueles que são enviados ou recebidos pelos AJAX.
        /// Colocamos este método de extensão aqui para não "corromper" a "camada" (sic) do domínio.
        /// O objetivo é igual ao método de cima, mas para este método fazemos o mapeamento de uma lista de cavaleiros vindos da tabela do banco para a lista retornada por JSON.
        /// </summary>
        public static IEnumerable<CavaleiroViewModel> FromModel(this IEnumerable<Cavaleiro> cavaleiros)
        {
            var cavaleirosViewModels = new List<CavaleiroViewModel>();

            foreach (var cava in cavaleiros)
            {
                cavaleirosViewModels.Add(cava.FromModel());
            }

            return cavaleirosViewModels;
        }
    }
}