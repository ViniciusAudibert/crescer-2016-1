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
            ChipNivel = Chip.Nivel2;
        }
        public Robo(Chip nivel) : this()
        {
            ChipNivel = nivel;
            Nivel();
            
        }

        public Chip ChipNivel { get; }

        public int Vida { get; protected set; }

        protected virtual int Ataque { get; set; }

        protected virtual int Defesa { get; set; }

        protected int Upgrade { get; set; }

        public virtual void Atacar(Robo robo)
        {
            robo.ReceberAtaque(Ataque);
        }

        public virtual void ReceberAtaque(int ataque)
        {
            int dano = ataque - Defesa;
            if (dano > 0)
            {
                Vida -= dano;
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

        private void Nivel()
        {
            if(ChipNivel.Equals(Chip.Nivel1))
            {
                Ataque--;
            }
            if (ChipNivel.Equals(Chip.Nivel3))
            {
                Defesa++;
                Ataque += 2;
            }
        }
    }
}
