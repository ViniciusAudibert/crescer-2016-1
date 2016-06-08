package br.com.crescer.exerciciostema;

import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import org.joda.time.DateTime;

public class MeuCalendarioUtil {

    public static String getDiaDaSemana(int dia, int mes, int ano) {
        String[] dias = {"Sexta-feira", "Sábado", "Domingo", "Segunda-feira", "Terça-feira", "Quarta-feira", "Quinta-feira"};

        Calendar day = new GregorianCalendar(ano, mes, dia);

        return dias[day.get(Calendar.DAY_OF_WEEK) - 1];
    }

    public static String getTempoDecorrido(Date date) {
        Calendar intervalo = Calendar.getInstance();
        long diff = new Date().getTime() - date.getTime();
        
        intervalo.setTime(new Date(diff));
        return String.format("%d ano(s), %d mes(es) e %d dia(s)", intervalo.get(Calendar.YEAR) - 1970, intervalo.get(Calendar.MONTH), intervalo.get(Calendar.DAY_OF_MONTH));
    }

    public static void main(String[] args) {
        System.out.println("Metodos disponiveis na classe MeuCalendarioUtil\n");

        for (Method name : MeuCalendarioUtil.class.getMethods()) {
            System.out.println(name.getName());
        }
    }
}
