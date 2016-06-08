package br.com.crescer.exerciciostema;

import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class MeuCalendarioUtil {

    public static String getDiaDaSemana(int dia, int mes, int ano) {
        String[] dias = {"Sexta-feira", "Sábado", "Domingo", "Segunda-feira", "Terça-feira", "Quarta-feira", "Quinta-feira"};

        Calendar day = new GregorianCalendar(ano, mes, dia);

        return dias[day.get(Calendar.DAY_OF_WEEK) - 1];
    }

    public static String getTempoDecorrido(Date data) {
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(data);

        Calendar now = Calendar.getInstance();

        int anos = now.get(Calendar.YEAR) - calendario.get(Calendar.YEAR);
        int meses;
        int dias;

        if (now.get(Calendar.MONTH) >= calendario.get(Calendar.MONTH)) {
            meses = now.get(Calendar.MONTH) - calendario.get(Calendar.MONTH);
        } else {
            meses = (now.get(Calendar.MONTH) + 12) - calendario.get(Calendar.MONTH);
            anos--;
        }

        if (now.get(Calendar.DAY_OF_MONTH) >= calendario.get(Calendar.DAY_OF_MONTH)) {
            dias = now.get(Calendar.DAY_OF_MONTH) - calendario.get(Calendar.DAY_OF_MONTH);
        } else {
            dias = (now.get(Calendar.DAY_OF_MONTH) + 30) - calendario.get(Calendar.DAY_OF_MONTH);
            meses--;
        }

        return String.format("%d ano(s), %d mes(es) e %d dia(s)", anos, meses, dias);
    }
    
    public static void main(String[] args) {
        System.out.println("Metodos disponiveis na classe MeuCalendarioUtil\n");

        for (Method name : MeuCalendarioUtil.class.getMethods()) {
            System.out.println(name.getName());
        }
    }
}
