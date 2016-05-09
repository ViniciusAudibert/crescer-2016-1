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
