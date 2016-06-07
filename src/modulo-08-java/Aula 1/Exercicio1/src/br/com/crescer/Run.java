/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer;

import java.util.*;

/**
 *
 * @author vinicius.audibert
 */
public class Run {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try (Scanner s = new Scanner(System.in)) {
            while (true) {
                System.out.println("Digite um numero");
                int num = s.nextInt();
                System.out.println(num % 2 == 0 ? "é par" : "é impar");
            }
        } catch (InputMismatchException ime) {
            System.out.println("Caractere invalido");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
