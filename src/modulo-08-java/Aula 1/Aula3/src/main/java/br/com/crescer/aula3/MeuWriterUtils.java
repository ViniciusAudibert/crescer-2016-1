package br.com.crescer.aula3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MeuWriterUtils {

    public static void escreverLinhas(String path) throws FileNotFoundException, IllegalArgumentException, IOException {
        File file = new File(path);
        if (!file.exists()) {
            throw new FileNotFoundException();
        } else if (!path.matches("^.*\\.(txt|TXT)$")) {
            throw new IllegalArgumentException();
        } else {
            final FileWriter fileWriter = new FileWriter(file);
            final BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            ArrayList<String> arquivoLinhas = new ArrayList<>();

            System.out.println("Escreva no arquivo, para sair digite $exit");

            Scanner s = new Scanner(System.in);
            String line = "";

            while (line.equalsIgnoreCase("$exit")) {
                line = s.nextLine();
                arquivoLinhas.add(line);
            }

            for (int i = 0; i < arquivoLinhas.size(); i++) {
                bufferedWriter.newLine();
                bufferedWriter.write(arquivoLinhas.get(i));
                bufferedWriter.flush();
            }
        }
    }

    public static void main(String[] args) {
        try {
            Scanner s = new Scanner(System.in);
            String path = s.nextLine();
            MeuWriterUtils.escreverLinhas(path);
        } catch (FileNotFoundException e) {
            System.err.println("O arquivo não existe");
        } catch (IllegalArgumentException e) {
            System.err.println("O arquivo solicitado é incompatível, somente txt sao permitidos");
        } catch (IOException e) {
            System.err.println("Erro ao realizar este comando");
        } catch (Exception e) {
            System.err.println("Ocorreu um erro: " + e.getMessage());
        }
    }
}
