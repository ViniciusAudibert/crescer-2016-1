using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExercicioMegaman
{
    public class Rush : Robo,IUpgrade
    {
        private int upgradeDefesa;
        public Rush() : this(Chip.Nivel2)
        {
        }
        public Rush(Chip nivel) : base(nivel)
        {
            Ataque--;
            Defesa += 3;
            upgradeDefesa = Defesa;
            Upgrade--;
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
                return upgradeDefesa;
            }
        }
    }
}
