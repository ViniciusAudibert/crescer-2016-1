using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LojaNinja.Dominio
{
    public class Pedido
    {
        /// <summary>
        /// Construtor utilizado para montar pedidos novos
        /// </summary>
        public Pedido(DateTime dataEntregaDesejada, string nomeProduto, decimal valor, TipoPagamento tipoPagamento, string nomeCliente, string cidade, string estado)
        {
            DataEntregaDesejada = dataEntregaDesejada;
            NomeProduto = nomeProduto;
            Valor = valor;
            TipoPagamento = tipoPagamento;
            NomeCliente = nomeCliente;
            Cidade = cidade;
            Estado = estado;

            //DateTime.Now contaria as horas, minutos e segundos, isso inviabliziaria algumas validações a seguir
            DataPedido = DateTime.Now;

            var diasRestantesParaConcluirEntrega = (dataEntregaDesejada - DateTime.Today).TotalDays;
            ValidaPossibilidadeEntrega(diasRestantesParaConcluirEntrega);
            DefineUrgenciaDoPedido(diasRestantesParaConcluirEntrega);
        }

        public void AtualizarId(int idGerado)
        {
            this.Id = idGerado;
        }

        /// <summary>
        /// Construtor utilizado para montar pedidos recuperados do repositório
        /// </summary>
        public Pedido(int id, DateTime dataPedido, DateTime dataEntregaDesejada, string nomeProduto, decimal valor, TipoPagamento tipoPagamento, string nomeCliente, string cidade, string estado, bool pedidoUrgente)
        {
            Id = id;
            DataEntregaDesejada = dataEntregaDesejada;
            NomeProduto = nomeProduto;
            Valor = valor;
            TipoPagamento = tipoPagamento;
            NomeCliente = nomeCliente;
            Cidade = cidade;
            Estado = estado;
            DataPedido = dataPedido;
            PedidoUrgente = pedidoUrgente;
        }

        public int Id { get; private set; }
        [DisplayName("Data Pedido")]
        [DisplayFormat(DataFormatString = "{0:dd/MM/yyyy}")]
        public DateTime DataPedido { get; private set; }
        [DisplayName("Data Entrega Desejada")]
        [DisplayFormat(DataFormatString = "{0:dd/MM/yyyy}")]
        public DateTime DataEntregaDesejada { get; private set; }
        [DisplayName("Produto")]
        public string NomeProduto { get; private set; }
        [DisplayFormat(DataFormatString = "R$ {0}")]
        public decimal Valor { get; private set; }
        [DisplayName("Tipo de Pagamento")]
        public TipoPagamento TipoPagamento { get; private set; }
        [DisplayName("Cliente")]
        public string NomeCliente { get; private set; }
        public string Cidade { get; private set; }
        public string Estado { get; private set; }
        [DisplayName("Urgente")]
        public bool PedidoUrgente { get; private set; }

        private void ValidaPossibilidadeEntrega(double diasRestantesParaConcluirEntrega)
        {
            if (diasRestantesParaConcluirEntrega < 1)
                throw new ArgumentException("A data de entrega desejada deve ser no mínimo 1 dia maior do que a data atual.");
        }

        private void DefineUrgenciaDoPedido(double diasRestantesParaConcluirEntrega)
        {
            PedidoUrgente = diasRestantesParaConcluirEntrega < 7;
        }
    }
}
