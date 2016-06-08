package br.com.crescer.exerciciostema;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Parcelator {

    public static String getParcelas(double valor, int taxa, int parcelas, Date data) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        Calendar vencimento = Calendar.getInstance();
        vencimento.setTime(data);

        double valorParcela = valor / parcelas;
        valorParcela += (valorParcela * taxa) / 100;

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < parcelas; i++) {
            stringBuilder.append(String.format("%d. %s - R$ %.2f\n", 
                    (i + 1),
                    dateFormat.format(vencimento.getTime()),
                    valorParcela));

            vencimento.add(Calendar.MONTH, 1);
        }

        return stringBuilder.toString();
    }
}
