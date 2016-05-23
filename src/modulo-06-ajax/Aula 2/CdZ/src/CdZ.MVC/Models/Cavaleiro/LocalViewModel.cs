namespace CdZ.MVC.Models.Cavaleiro
{
    public class LocalViewModel
    {
        public int? Id { get; set; }
        public string Texto { get; set; }

        public LocalViewModel() { }

        public LocalViewModel(int id, string texto)
        {
            this.Id = id;
            this.Texto = texto;
        }

        public Dominio.Local ToModel()
        {
            if (Id.HasValue)
                return new Dominio.Local((int)Id, Texto);
            else
                return new Dominio.Local(Texto);
        }
    }
}