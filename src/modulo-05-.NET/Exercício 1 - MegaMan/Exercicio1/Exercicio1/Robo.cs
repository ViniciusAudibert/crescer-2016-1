using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Exercicio1
{
    public abstract class Robo
    {
        public abstract String Nome { get; }
        public int Vida { get; private set; }
        protected int Ataque;
        protected int Defesa;

        public Robo()
        {
            Vida = 100;
            Ataque = 5;
            Defesa = 0;
        }
        public void Atacar(Robo robo)
        {
            robo.Vida -= Ataque - Defesa;
        }
    }
}
