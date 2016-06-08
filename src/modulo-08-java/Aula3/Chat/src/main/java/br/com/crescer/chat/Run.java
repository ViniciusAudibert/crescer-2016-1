package br.com.crescer.chat;

import br.com.crescer.exerciciostema.MeuStringUtil;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Run {

    public static BufferedReader getReader(String fila) throws FileNotFoundException, IOException {
        File file = new File(fila);
        file.createNewFile();
        return new BufferedReader(new FileReader(file));
    }

    public static BufferedWriter getWriter(String fila) throws IOException {
        return new BufferedWriter(new FileWriter(fila, true));
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                BufferedReader bufferRead = null;
                try {
                    bufferRead = Run.getReader("////10.0.100.102//cwitmp//carloshenrique/crescer.txt");
                    while (true) {
                        String readLine = bufferRead.readLine();
                        if (!MeuStringUtil.isEmpty(readLine)) {
                            System.out.println(readLine);
                        }
                        Thread.sleep(1000l);
                    }
                } catch (Exception e) {
                    //..
                } finally {
                    if (bufferRead != null) {
                        try {
                            bufferRead.close();
                        } catch (IOException ex) {
                            //..
                        }
                    }
                }
            }
        }).start();
        String nickName = "?";
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        while (true) {
            String info = dateFormat.format(new Date()) + " " + nickName + " disse:";
            Scanner s = new Scanner(System.in);
            String nextLine = info + "    " + s.nextLine();
            if (":q!".equals(nextLine)) {
                break;
            }
            BufferedWriter bufferedWriter = null;
            try {
                bufferedWriter = getWriter("////10.0.100.102//cwitmp//carloshenrique/crescer.txt");
                bufferedWriter.write(nextLine);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            } catch (Exception e) {
                //..
            } finally {
                try {
                    if (bufferedWriter != null) {
                        bufferedWriter.close();
                    }
                } catch (Exception e) {
                    //..
                }
            }
        }
    }
}