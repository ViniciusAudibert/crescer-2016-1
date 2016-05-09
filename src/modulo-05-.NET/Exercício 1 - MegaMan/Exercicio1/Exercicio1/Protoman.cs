using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExercicioMegaman
{
    public class Protoman : Robo
    {
        private int mortesCont;

        public Protoman() : base()
        {
            Defesa = 2;
        }

        public override void Atacar(Robo robo)
        {
            base.Atacar(robo);
        }

        public override void ReceberAtaque(int _ataque)
        {
            base.ReceberAtaque(_ataque);
            if (Vida <= 0 && mortesCont == 0)
            {
                Vida = 20;
                mortesCont++;
                Ataque = 7;
            }
        }
    }
}
