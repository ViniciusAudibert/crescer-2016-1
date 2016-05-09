using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExercicioMegaman
{
    public abstract class Robo
    {
        public Robo()
        {
            Vida = 100;
            Ataque = 5;
            Defesa = 0;
            Upgrade = 3;
        }

        public int Vida { get; protected set; }

        protected virtual int Ataque { get; set; }

        protected virtual int Defesa { get; set; }

        protected int Upgrade { get; set; }

        public virtual void Atacar(Robo robo)
        {
            robo.ReceberAtaque(Ataque);
        }

        public virtual void ReceberAtaque(int _ataque)
        {
            int _dano = _ataque - Defesa;
            if (_dano > 0)
            {
                Vida -= _dano;
            }
            if(Vida < 0)
            {
                Vida = 0;
            }
        }
        public override String ToString()
        {
            return "Nome: Vida: " + Vida + ", Ataque: " + Ataque + ", Defesa: " + Defesa;
        }
        public void EquiparUpgrade(IUpgrade upgrade)
        {
            if(Upgrade >= 0)
            {
                Ataque += upgrade.UpgradeAtaque;
                Defesa += upgrade.UpgradeDefesa;
            }
        }
    }
}
