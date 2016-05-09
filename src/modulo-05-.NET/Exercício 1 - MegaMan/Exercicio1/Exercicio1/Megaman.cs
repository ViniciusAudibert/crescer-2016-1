using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExercicioMegaman
{
    public class Megaman : Robo
    {
        public Megaman() : this(Chip.Nivel2)
        {
        }
        public Megaman(Chip nivel) : base(nivel)
        {
            Ataque++;
        }

        public override void Atacar(Robo robo)
        {
            if(Vida < 30)
            {
                robo.ReceberAtaque(Ataque + 3);
            }
            else
            {
                base.Atacar(robo);
            }
        }
    }
}
