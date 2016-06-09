package br.com.crescer.aula3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

public class MeuReaderUtils {

    public static void lerArquivo(String path) throws FileNotFoundException, IllegalArgumentException, IOException {
        File file = new File(path);

        if (!file.exists()) {
            throw new FileNotFoundException();
        } else if (!path.matches("^.*\\.(txt|TXT)$")) {
            throw new IllegalArgumentException();
        } else {
            final Reader reader = new FileReader(file);
            final BufferedReader bufferedReader = new BufferedReader(reader);
            while (bufferedReader.readLine() != null) {
                System.out.println(bufferedReader.readLine());
            }
        }
    }

    public static void main(String[] args) {
        try {
            MeuReaderUtils mr = new MeuReaderUtils();
            Scanner s = new Scanner(System.in);
            String path = s.nextLine();
            MeuReaderUtils.lerArquivo(path);
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
