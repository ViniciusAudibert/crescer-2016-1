package br.com.crescer.aula3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.Scanner;

public class MeuFileUtils {

    public static void mk(String path) throws IOException {
        File file = new File(path);

        if (file.getAbsoluteFile().isDirectory()) {
            file.mkdir();
        } else {
            file.createNewFile();
        }
    }

    public static void rm(String path) throws IllegalArgumentException, FileNotFoundException {
        File file = new File(path);

        if (file.isDirectory()) {
            throw new IllegalArgumentException();
        } else if (!file.exists()) {
            throw new FileNotFoundException();
        } else {
            file.delete();
        }
    }

    public static void ls(String path) {
        File file = new File(path);

        System.out.println(file.getAbsoluteFile());

        if (file.isDirectory()) {
            for (String arquivo : file.list()) {
                System.out.println(arquivo);
            }
        }
    }

    public static void mv(String arquivo, String path) throws IllegalArgumentException, IOException, FileNotFoundException {
        File file = new File(arquivo);
        File novoCaminho = new File(path);

        if (file.isDirectory()) {
            throw new IllegalArgumentException();
        } else if (!file.exists()) {
            throw new FileNotFoundException();
        }

        Files.move(file.toPath(), novoCaminho.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

    public static void main(String[] args) {
        String line = "";
        while (!line.equalsIgnoreCase("exit")) {
            Scanner s = new Scanner(System.in);
            
            System.out.print(new Date() + " - ");
            line = s.nextLine();
            System.out.println();
            
            if (line != null && line.length() > 5) {
                String[] lineArray = line.split(" ");
                String comando = lineArray[0];
                String path = lineArray[1];
                if (path.startsWith("${") && path.endsWith("}")) {
                    path = path.substring(2, path.length() - 1);
                    try {
                        switch (comando.toLowerCase()) {
                            case "mk":
                                mk(path);
                                break;
                            case "rm":
                                rm(path);
                                break;
                            case "ls":
                                ls(path);
                                break;
                            case "mv":
                                String novoCaminho = "";
                                novoCaminho = lineArray[2];

                                if (novoCaminho.startsWith(" ${") && novoCaminho.endsWith("}")) {
                                    novoCaminho = novoCaminho.substring(2, novoCaminho.length() - 1);
                                    mv(path, novoCaminho);
                                }
                        }
                    } catch (FileNotFoundException e) {
                        System.err.println("Arquivo nao encontrado");
                    } catch (IllegalArgumentException e) {
                        System.err.println("Informe o local do arquivo");
                    } catch (IOException e) {
                        System.err.println("Erro ao realizar este comando");
                    } catch (Exception e) {
                        System.err.println("Ocorreu um erro: " + e.getMessage());
                    }
                }
            }
        }
    }
}
