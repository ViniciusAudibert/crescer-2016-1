using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExercicioMegaman
{
    public class Rush : Robo,IUpgrade
    {
        public Rush() : base()
        {
            Ataque = 4;
            Defesa = 3;
            Upgrade = 2;
        }

        public int UpgradeAtaque
        {
            get
            {
                return Ataque;
            }
        }

        public int UpgradeDefesa
        {
            get
            {
                return Defesa;
            }
        }
    }
}
