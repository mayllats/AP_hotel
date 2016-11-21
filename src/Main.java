/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

/**
 *
 * @author 08971562692
 */
public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Hotel hotel[] = new Hotel[1000];
        int menu;
        do {
            System.out.print("\nSISTEMA DE HOTEIS");
            System.out.println("\nDeseja: \n1-Cadastrar \n2-Listar \n3-sair");
            menu = s.nextInt();
            if (menu < 1) {
                while (menu < 1) {
                    System.out.println("\nOpção inválida!\n\nDeseja: \n1-Cadastrar \n2-Listar\n3-sair");
                    menu = s.nextInt();
                }
            } else if (menu == 1) {
                funcoes.cadastrarNovoHotel(hotel);
            } else // precisa verificar se hotel é diferente de nulo 
             if (hotel != null) {
                    funcoes.listarHoteis(hotel);

                } else {
                    System.out.println("Nenhum hotel cadastrado");
                }
        } while (menu != 3);
    }

}