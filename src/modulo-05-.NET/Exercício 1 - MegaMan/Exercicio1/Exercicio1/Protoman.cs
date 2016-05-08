using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExercicioMegaman
{
    public class Protoman : Robo
    {
        private int MortesCont;

        public Protoman() : base()
        {
            this.MortesCont = 0;
            Defesa = 2;
        }

        public override void Atacar(Robo _robo)
        {
            base.Atacar(_robo);
        }

        public override void ReceberAtaque(int _ataque)
        {
            base.ReceberAtaque(_ataque);
            if (Vida <= 0 && MortesCont == 0)
            {
                Vida = 20;
                MortesCont++;
                Ataque = 7;
            }
        }
    }
}
