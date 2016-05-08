using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExercicioMegaman
{
    public class Megaman : Robo
    {
        public Megaman() : base()
        {
            Ataque = 6;
        }

        public override void Atacar(Robo _robo)
        {
            if(Vida < 30)
            {
                _robo.ReceberAtaque(Ataque + 3);
            }
            base.Atacar(_robo);
        }
    }
}
