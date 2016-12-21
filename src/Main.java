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
        int qtd = 0;
        int menu;
        do {
            System.out.print("\nSISTEMA DE HOTEIS");
            System.out.println("\nDeseja: \n1-Cadastrar \n2-Listar \n3-Buscar \n4-Carregar \n5-Salvar \n6-Sair");
            menu = s.nextInt();
            if (menu < 1) {
                while (menu < 1) {
                    System.out.println("\nOpção inválida!\n\nDeseja: \n1-Cadastrar \n2-Listar\n6-sair");
                    menu = s.nextInt();
                }
            } else if (menu == 1) {
                HotelUtils.cadastrarNovoHotel(hotel, qtd);
                qtd++;
            } else if (menu == 2) {// precisa verificar se hotel é diferente de nulo 

                if (hotel != null) {
                    HotelUtils.listarHoteis(hotel, qtd);

                } else {
                    System.out.println("Nenhum hotel cadastrado");
                }
            } else if (menu == 3) {
                System.out.println("\nDeseja buscar por \n1-Nome \n2-Número");
                String escolherBusca = s.nextLine();
                s.nextLine();
                while (!escolherBusca.equalsIgnoreCase("1") && !escolherBusca.equalsIgnoreCase("2")) {
                    System.out.println("\nOpção não disponivel! \nDeseja buscar por: \n1-Nome \n2-Número");
                    escolherBusca = s.nextLine();
                }
                int pos;
                if (escolherBusca.equals("1")) {
                    //HotelUtils.buscarHotelPorNome(hotel, qtd);
                    pos = HotelUtils.buscarHotelPorNome(hotel, qtd);
                    // imprima os dados
                    System.out.println("Encontrado!");
                    System.out.println(hotel[pos].imprimir());
                } else {
                    //HotelUtils.buscarHotelPorNumero(hotel, qtd);
                    pos = HotelUtils.buscarHotelPorNumero(hotel, qtd);
                    // imprima os dados
                    System.out.println("Encontrado!");
                    System.out.println(hotel[pos].imprimir());
                }
                System.out.println("\nO que deseja fazer? \n1-Editar \n2-Excluir");
                String escolha = s.nextLine();
                while (!escolha.equals("1") && !escolha.equals("2")) {
                    System.out.println("Opção não disponivel!\nPor favor escolha uma opção: \n1-Editar \n2-Excluir");
                    escolha = s.nextLine();
                }
                if (escolha.equals("1")) {
                    HotelUtils.alterarHotel(hotel, pos);
                } else {
                    HotelUtils.excluirHotel(hotel, pos, qtd);
                    qtd--;
                }
            } else if (menu == 4) {
                HotelUtils.carregarArquivos(hotel, qtd);
            } else if (menu == 5) {
               HotelUtils.salvarArquivos(hotel, qtd);
            }
        } while (menu != 6);
    }
}
