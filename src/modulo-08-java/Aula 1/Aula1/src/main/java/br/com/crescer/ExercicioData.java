package br.com.crescer;

import java.text.SimpleDateFormat;
import java.util.*;

public class ExercicioData {
    public static void main(String[] args){
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/YYYY hh:mm:ss");
                
        System.out.println("Data: " + date.format(new Date()));
    }
}
