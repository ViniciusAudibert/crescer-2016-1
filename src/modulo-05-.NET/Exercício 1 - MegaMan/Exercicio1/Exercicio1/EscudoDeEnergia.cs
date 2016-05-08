using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExercicioMegaman
{
    public class EscudoDeEnergia : IUpgrade
    {
        public EscudoDeEnergia()
        {
            UpgradeAtaque = 0;
            UpgradeDefesa = 2;
        }

        public int UpgradeAtaque { get; }

        public int UpgradeDefesa { get; }
    }
}
