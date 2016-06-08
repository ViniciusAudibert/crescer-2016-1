package br.com.crescer.exerciciostema;

import java.lang.reflect.Method;

public class MeuStringUtil {

    public static boolean isEmpty(String string) {
        return string == null ? true : string.trim().length() > 0 ? false : true;
    }

    public static int numVogais(String string) {
        if (isEmpty(string)) {
            return 0;
        }

        int count = 0;

        for (char letra : string.toCharArray()) {
            if ("a e i o u".contains(Character.toString(letra).toLowerCase())) {
                count++;
            }
        }
        return count;
    }

    public static String inverter(String string) {
        if (isEmpty(string)) {
            return null;
        }

        StringBuilder inverter = new StringBuilder();

        for (int i = string.length() - 1; i >= 0; i--) {
            inverter.append(string.charAt(i));
        }

        return inverter.toString();
    }

    public static boolean isPalindromo(String string) {
        if (isEmpty(string)) {
            return false;
        }

        String invertida = inverter(string);

        return string.equals(invertida);
    }

    private static boolean isNull(String string) {
        return string == null;
    }

    public static void main(String[] args) {
        System.out.println("Metodos disponiveis na classe MeuStringUtil\n");

        for (Method name : MeuStringUtil.class.getMethods()) {
            System.out.println(name.getName());
        }
    }
}
