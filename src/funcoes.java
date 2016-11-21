
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 08971562692
 */
public class funcoes {
  static void cadastrarNovoHotel(Hotel hotel[]) {
        Scanner s = new Scanner(System.in);
        int a=0;
        System.out.println("\nCADASTRO DE NOVO HOTEL:");
        hotel[a] = new Hotel();
        System.out.print("Número: ");
        hotel[a].numero = s.nextLine();
        while (hotel[a].verificarNumero() == false) {
            System.out.print("Número: ");
            hotel[a].numero = s.nextLine();
        }

        System.out.print("Nome: ");
        hotel[a].nome = s.nextLine();
        while (hotel[a].verificarNome() == false) {
            System.out.print("Nome: ");
            hotel[a].numero = s.nextLine();
        }

        System.out.print("Número de quartos: ");
        hotel[a].numerodequartos = s.nextLine();
        while (hotel[a].verificarQuarto() == false) {
            System.out.print("Número de quartos: ");
            hotel[a].numerodequartos = s.nextLine();
        }

        System.out.print("Telefone: ");
        hotel[a].telefone = s.nextLine();
        while (hotel[a].telefone.length() < 0 || hotel[a].telefone.length() > 8) {
            System.out.print("Telefone: ");
            hotel[a].telefone = s.nextLine();
        }

        System.out.print("Tarifa por quarto:");
        hotel[a].tarifaporquarto = s.nextDouble();
        while (hotel[a].tarifaporquarto <= 0) {
            System.out.print("Tarifa por quarto:");
            hotel[a].tarifaporquarto = s.nextDouble();
        }
        a++;
    }

    static void listarHoteis(Hotel hotel[]) {
        Scanner s = new Scanner(System.in);
        //ordenação
        System.out.println("Deseja listar por: \n1-Número \n2-Nome");
        int ordenar = s.nextInt();
        System.out.println("\nLISTA DE HOTEIS CADASTRADOS:");
        if (ordenar == 1) {
            ordenaPorNumero(hotel);
        } else {
            ordenaPorNome(hotel);
        }
        for (int i = 0; i < hotel.length; i++) {
            System.out.print(hotel[i].imprimir());

        }
    }
    //conferir pois nao esta rodando
    static void ordenaPorNumero(Hotel hotel[]) {
        int i, j, posMenor;
        for (i = 0; i < hotel.length; i++) {
            posMenor = 0;
            for (j = 0; j < hotel.length - i; j++) {
                if (hotel[j].numero.compareTo(hotel[posMenor].numero) > 0) {
                    posMenor = j;
                }
            }
            Hotel temp = hotel[hotel.length - i - 1];
            hotel[hotel.length - i - 1] = hotel[posMenor];
            hotel[posMenor] = temp;
        }
    }
    //conferir pois nao esta rodando
    static void ordenaPorNome(Hotel hotel[]) {
        for (int i = 0; i < hotel.length; i++) {
            for (int j = 1; j < hotel.length - i; j++) {
                if (hotel[j - 1].nome.compareToIgnoreCase(hotel[j].nome) > 0) {
                    Hotel a = hotel[j - 1];
                    hotel[j - 1] = hotel[j];
                    hotel[j] = a;
                }
            }
        }
    }
    static void buscarHotel(){
        
    }
    
    static void alterarHotel(){
        
    }
    
    static void excluirHotel(){
        
    }
    
    static void salvarArquivos(){
        
    }
    
    static void carregarArquivos(){
        
    }
}

  
