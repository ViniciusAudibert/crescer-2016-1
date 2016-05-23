namespace CdZ.MVC.Models.Cavaleiro
{
    public class GolpeViewModel
    {
        public int Id { get; set; }
        public string Nome { get; set; }

        public Dominio.Golpe ToModel()
        {
            return new Dominio.Golpe(Id, Nome);
        }

        public GolpeViewModel() { }

        public GolpeViewModel(int id, string nome)
        {
            this.Id = id;
            this.Nome = nome;
        }
    }
}