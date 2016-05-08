using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExercicioMegaman
{
    public class CanhaoDePlasma : IUpgrade
    {
        public CanhaoDePlasma()
        {
            UpgradeAtaque = 2;
            UpgradeDefesa = 0;
        }

        public int UpgradeAtaque { get; }

        public int UpgradeDefesa { get; }
    }
}
