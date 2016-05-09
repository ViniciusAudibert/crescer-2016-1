using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using ExercicioMegaman;

namespace MegamanTest
{
    [TestClass]
    public class UnitTest1
    {
        [TestMethod]
        public void MegamanToString()
        {
            Robo Bot = new Megaman();
            Assert.AreEqual(Bot.ToString(), "Nome: Vida: 100, Ataque: 6, Defesa: 0");
        }
        [TestMethod]
        public void MegamanAtacaMegamanUmaVez()
        {
            Robo Bot = new Megaman();
            Robo Bot2 = new Megaman();
            Bot.Atacar(Bot2);
            Assert.AreEqual(Bot.ToString(), "Nome: Vida: 100, Ataque: 6, Defesa: 0");
            Assert.AreEqual(Bot2.ToString(), "Nome: Vida: 94, Ataque: 6, Defesa: 0");
        }
        [TestMethod]
        public void MegamanAtacaMegamanSeisVezes()
        {
            Robo Bot = new Megaman();
            Robo Bot2 = new Megaman();
            for (int i = 0; i < 6; i++)
            {
                Bot.Atacar(Bot2);
            }         
            Assert.AreEqual(Bot.ToString(), "Nome: Vida: 100, Ataque: 6, Defesa: 0");
            Assert.AreEqual(Bot2.ToString(), "Nome: Vida: 64, Ataque: 6, Defesa: 0");
        }
        [TestMethod]
        public void MegamanAtacaMegamanAteMatar()
        {
            Robo Bot = new Megaman();
            Robo Bot2 = new Megaman();
            for (int i = 0; i < 100; i++)
            {
                Bot.Atacar(Bot2);
            }
            Assert.AreEqual(Bot.ToString(), "Nome: Vida: 100, Ataque: 6, Defesa: 0");
            Assert.AreEqual(Bot2.ToString(), "Nome: Vida: 0, Ataque: 6, Defesa: 0");
        }
        [TestMethod]
        public void MegamanAtacaProtomanUmaVez()
        {
            Robo Bot = new Megaman();
            Robo Bot2 = new Protoman();
            Bot.Atacar(Bot2);
            Assert.AreEqual(Bot.ToString(), "Nome: Vida: 100, Ataque: 6, Defesa: 0");
            Assert.AreEqual(Bot2.ToString(), "Nome: Vida: 96, Ataque: 5, Defesa: 2");
        }
        [TestMethod]
        public void MegamanAtacaProtomanSeisVezes()
        {
            Robo Bot = new Megaman();
            Robo Bot2 = new Protoman();
            for (int i = 0; i < 6; i++)
            {
                Bot.Atacar(Bot2);
            }
            Assert.AreEqual(Bot.ToString(), "Nome: Vida: 100, Ataque: 6, Defesa: 0");
            Assert.AreEqual(Bot2.ToString(), "Nome: Vida: 76, Ataque: 5, Defesa: 2");
        }
        [TestMethod]
        public void MegamanAtacaProtomanAteMatar()
        {
            Robo Bot = new Megaman();
            Robo Bot2 = new Protoman();
            for (int i = 0; i < 100; i++)
            {
                Bot.Atacar(Bot2);
            }
            Assert.AreEqual(Bot.ToString(), "Nome: Vida: 100, Ataque: 6, Defesa: 0");
            Assert.AreEqual(Bot2.ToString(), "Nome: Vida: 0, Ataque: 7, Defesa: 2");
        }
        [TestMethod]
        public void ProtomanToString()
        {
            Robo Bot = new Protoman();
            Assert.AreEqual(Bot.ToString(), "Nome: Vida: 100, Ataque: 5, Defesa: 2");
        }
        [TestMethod]
        public void ProtomanAtacaProtomanUmaVez()
        {
            Robo Bot = new Protoman();
            Robo Bot2 = new Protoman();
            Bot.Atacar(Bot2);
            Assert.AreEqual(Bot.ToString(), "Nome: Vida: 100, Ataque: 5, Defesa: 2");
            Assert.AreEqual(Bot2.ToString(), "Nome: Vida: 97, Ataque: 5, Defesa: 2");
        }
        [TestMethod]
        public void ProtomanAtacaProtomanSeisVezes()
        {
            Robo Bot = new Protoman();
            Robo Bot2 = new Protoman();
            for (int i = 0; i < 6; i++)
            {
                Bot.Atacar(Bot2);
            }
            Assert.AreEqual(Bot.ToString(), "Nome: Vida: 100, Ataque: 5, Defesa: 2");
            Assert.AreEqual(Bot2.ToString(), "Nome: Vida: 82, Ataque: 5, Defesa: 2");
        }
        [TestMethod]
        public void ProtomanAtacaProtomanAteMatar()
        {
            Robo Bot = new Protoman();
            Robo Bot2 = new Protoman();
            for (int i = 0; i < 100; i++)
            {
                Bot.Atacar(Bot2);
            }
            Assert.AreEqual(Bot.ToString(), "Nome: Vida: 100, Ataque: 5, Defesa: 2");
            Assert.AreEqual(Bot2.ToString(), "Nome: Vida: 0, Ataque: 7, Defesa: 2");
        }
        [TestMethod]
        public void ProtomanAtacaMegamanUmaVez()
        {
            Robo Bot = new Protoman();
            Robo Bot2 = new Megaman();
            Bot.Atacar(Bot2);
            Assert.AreEqual(Bot.ToString(), "Nome: Vida: 100, Ataque: 5, Defesa: 2");
            Assert.AreEqual(Bot2.ToString(), "Nome: Vida: 95, Ataque: 6, Defesa: 0");
        }
        [TestMethod]
        public void ProtomanAtacaMegamanSeisVezes()
        {
            Robo Bot = new Protoman();
            Robo Bot2 = new Megaman();
            for (int i = 0; i < 6; i++)
            {
                Bot.Atacar(Bot2);
            }
            Assert.AreEqual(Bot.ToString(), "Nome: Vida: 100, Ataque: 5, Defesa: 2");
            Assert.AreEqual(Bot2.ToString(), "Nome: Vida: 70, Ataque: 6, Defesa: 0");
        }
        [TestMethod]
        public void ProtomanAtacaMegamanAteMatar()
        {
            Robo Bot = new Protoman();
            Robo Bot2 = new Megaman();
            for (int i = 0; i < 100; i++)
            {
                Bot.Atacar(Bot2);
            }
            Assert.AreEqual(Bot.ToString(), "Nome: Vida: 100, Ataque: 5, Defesa: 2");
            Assert.AreEqual(Bot2.ToString(), "Nome: Vida: 0, Ataque: 6, Defesa: 0");
        }
        [TestMethod]
        public void ProtomanReviveDepoisDeMorto()
        {
            Robo Bot = new Megaman();
            Robo Bot2 = new Protoman();
            for (int i = 0; i < 25; i++)
            {
                Bot.Atacar(Bot2);
            }
            Assert.AreEqual(Bot.ToString(), "Nome: Vida: 100, Ataque: 6, Defesa: 0");
            Assert.AreEqual(Bot2.ToString(), "Nome: Vida: 20, Ataque: 7, Defesa: 2");
        }
        [TestMethod]
        public void UpgradeCanhaoDePlasma()
        {
            Robo Bot = new Megaman();
            Bot.EquiparUpgrade(new CanhaoDePlasma());
            Assert.AreEqual(Bot.ToString(), "Nome: Vida: 100, Ataque: 8, Defesa: 0");
        }
        [TestMethod]
        public void UpgradeEscudoDeEnergia()
        {
            Robo Bot = new Megaman();
            Bot.EquiparUpgrade(new EscudoDeEnergia());
            Assert.AreEqual(Bot.ToString(), "Nome: Vida: 100, Ataque: 6, Defesa: 2");
        }
        [TestMethod]
        public void UpgradeBotasDeSuperVelocidade()
        {
            Robo Bot = new Megaman();
            Bot.EquiparUpgrade(new BotasDeSuperVelocidade());
            Assert.AreEqual(Bot.ToString(), "Nome: Vida: 100, Ataque: 7, Defesa: 1");
        }
        [TestMethod]
        public void EquipaTresUpgrades()
        {
            Robo Bot = new Megaman();
            Bot.EquiparUpgrade(new CanhaoDePlasma());
            Bot.EquiparUpgrade(new BotasDeSuperVelocidade());
            Bot.EquiparUpgrade(new Rush());
            Assert.AreEqual(Bot.ToString(), "Nome: Vida: 100, Ataque: 13, Defesa: 4");
        }
        [TestMethod]
        public void UpgradeRush()
        {
            Robo Bot = new Megaman();
            Bot.EquiparUpgrade(new Rush());
            Assert.AreEqual(Bot.ToString(), "Nome: Vida: 100, Ataque: 10, Defesa: 3");
        }
        [TestMethod]
        public void UpgradeRushComUpgrades()
        {
            Robo Bot = new Megaman();
            IUpgrade Rush = new Rush();
            ((Robo)Rush).EquiparUpgrade(new CanhaoDePlasma());
            ((Robo)Rush).EquiparUpgrade(new EscudoDeEnergia());
            Bot.EquiparUpgrade(Rush);
            Assert.AreEqual(Bot.ToString(), "Nome: Vida: 100, Ataque: 12, Defesa: 3");
        }
        [TestMethod]
        public void MegamenAtaqueComBonus()
        {
            Robo Bot = new Megaman();
            Robo Bot2 = new Megaman();
            for (int i = 0; i < 12; i++)
            {
                Bot.Atacar(Bot2);
            }
            Bot2.Atacar(Bot);
            Bot2.Atacar(Bot);
            Assert.AreEqual(Bot.ToString(), "Nome: Vida: 82, Ataque: 6, Defesa: 0");
            Assert.AreEqual(Bot2.ToString(), "Nome: Vida: 28, Ataque: 6, Defesa: 0");
        }
        [TestMethod]
        public void ChipNivel1Megaman()
        {
            Robo Bot = new Megaman(Chip.Nivel1);
            Assert.AreEqual(Bot.ToString(), "Nome: Vida: 100, Ataque: 5, Defesa: 0");
        }
        public void ChipNivel3Megaman()
        {
            Robo Bot = new Megaman(Chip.Nivel3);
            Assert.AreEqual(Bot.ToString(), "Nome: Vida: 100, Ataque: 8, Defesa: 1");
        }
        [TestMethod]
        public void ChipNivel1Protoman()
        {
            Robo Bot = new Protoman(Chip.Nivel1);
            Assert.AreEqual(Bot.ToString(), "Nome: Vida: 100, Ataque: 4, Defesa: 2");
        }
        public void ChipNivel3Protoman()
        {
            Robo Bot = new Protoman(Chip.Nivel3);
            Assert.AreEqual(Bot.ToString(), "Nome: Vida: 100, Ataque: 7, Defesa: 3");
        }
        [TestMethod]
        public void ChipNivel1Rush()
        {
            Robo Bot = new Rush(Chip.Nivel1);
            Assert.AreEqual(Bot.ToString(), "Nome: Vida: 100, Ataque: 3, Defesa: 3");
        }
        public void ChipNivel3Rush()
        {
            Robo Bot = new Rush(Chip.Nivel3);
            Assert.AreEqual(Bot.ToString(), "Nome: Vida: 100, Ataque: 5, Defesa: 4");
        }
        [TestMethod]
        public void RushAtacaMegaman()
        {
            Robo Bot = new Rush();
            Robo Bot2 = new Megaman();
            Bot.Atacar(Bot2);
            Assert.AreEqual(Bot2.ToString(), "Nome: Vida: 100, Ataque: 6, Defesa: 0");
        }
        [TestMethod]
        public void RushAtacaProtoman()
        {
            Robo Bot = new Rush();
            Robo Bot2 = new Protoman();
            Bot.Atacar(Bot2);
            Assert.AreEqual(Bot2.ToString(), "Nome: Vida: 98, Ataque: 5, Defesa: 2");
        }
    }
}
