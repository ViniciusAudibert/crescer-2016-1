package br.com.crescer.aula2;

import java.io.File;
import java.io.IOException;

public class Run {
    public static void main(String[] args){
        File file = new File("aula2.txt");
        try{
            file.createNewFile();
            System.err.println(file.getAbsoluteFile());
        }catch(IOException e){
            System.err.format("IOException: %s", e.getMessage());
        }
        file.delete();
    }
}
