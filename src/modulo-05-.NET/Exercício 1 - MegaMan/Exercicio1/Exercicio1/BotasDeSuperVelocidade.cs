using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExercicioMegaman
{
    public class BotasDeSuperVelocidade : IUpgrade
    {
        public BotasDeSuperVelocidade()
        {
            UpgradeAtaque = 1;
            UpgradeDefesa = 1;
        }

        public int UpgradeAtaque { get; }

        public int UpgradeDefesa { get; }
    }
}
