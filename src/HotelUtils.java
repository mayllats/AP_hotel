
import java.io.FileWriter;
import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 08971562692
 */
public class HotelUtils {

    static void cadastrarNovoHotel(Hotel hotel[], int posNovo) {
        Scanner s = new Scanner(System.in);
        System.out.println("\nCADASTRO DE NOVO HOTEL:");
        hotel[posNovo] = new Hotel();
        System.out.print("Número: ");
        hotel[posNovo].numero = s.nextLine();
        while (hotel[posNovo].verificarNumero() == false) {
            System.out.print("Número: ");
            hotel[posNovo].numero = s.nextLine();
        }

        System.out.print("Nome: ");
        hotel[posNovo].nome = s.nextLine();
        while (hotel[posNovo].verificarNome() == false) {
            System.out.print("Nome: ");
            hotel[posNovo].numero = s.nextLine();
        }

        System.out.print("Número de quartos: ");
        hotel[posNovo].numerodequartos = s.nextLine();
        while (hotel[posNovo].verificarQuarto() == false) {
            System.out.print("Número de quartos: ");
            hotel[posNovo].numerodequartos = s.nextLine();
        }

        System.out.print("Telefone: ");
        hotel[posNovo].telefone = s.nextLine();
        while (hotel[posNovo].telefone.length() != 8) {
            for (int i = 0; i < hotel[posNovo].telefone.length(); i++) {
                //for de 0 até 8 no qual irá verificar se cada caracter (charAt) é >= '0' && <='9'
                if (hotel[posNovo].telefone.charAt(i) >= '0' && hotel[posNovo].telefone.charAt(i) <= '9') {
                    System.out.println("\nDigite apenas números!");
                }
            }
            System.out.print("Telefone: ");
            hotel[posNovo].telefone = s.nextLine();
        }

        System.out.print("Tarifa por quarto:");
        hotel[posNovo].tarifaporquarto = s.nextDouble();
        while (hotel[posNovo].tarifaporquarto <= 0) {
            System.out.print("Tarifa por quarto:");
            hotel[posNovo].tarifaporquarto = s.nextDouble();
        }
    }

    static void listarHoteis(Hotel hotel[], int qtd) {
        Scanner s = new Scanner(System.in);
        //ordenação
        System.out.println("Deseja listar por: \n1-Número \n2-Nome");
        int ordenar = s.nextInt();
        System.out.println("\nLISTA DE HOTEIS CADASTRADOS:");
        if (ordenar == 1) {
            ordenaPorNumero(hotel, qtd);
        } else {
            ordenaPorNome(hotel, qtd);
        }
        for (int i = 0; i < qtd; i++) {
            System.out.print(hotel[i].imprimir());

        }
    }

    //conferir pois nao esta rodando
    static void ordenaPorNumero(Hotel hotel[], int qtd) {
        int i, j, posMenor;
        for (i = 0; i < qtd; i++) {
            posMenor = i;
            for (j = i + 1; j < qtd - i; j++) {
                Integer itemToCompareA = Integer.parseInt(hotel[j].numero);
                Integer itemToCompareB = Integer.parseInt(hotel[posMenor].numero);
                if (itemToCompareB.compareTo(itemToCompareA) > 0) {
                    posMenor = j;
                }
            }
            Hotel temp = hotel[qtd - i - 1];
            hotel[qtd - i - 1] = hotel[posMenor];
            hotel[posMenor] = temp;
        }
    }

    //conferir pois nao esta rodando
    static void ordenaPorNome(Hotel hotel[], int qtd) {
        for (int i = 0; i < qtd; i++) {
            for (int j = 1; j < qtd - i; j++) {
                if (hotel[j - 1].nome.compareToIgnoreCase(hotel[j].nome) > 0) {
                    Hotel a = hotel[j - 1];
                    hotel[j - 1] = hotel[j];
                    hotel[j] = a;
                }
            }
        }
    }

    static int buscarHotelPorNumero(Hotel hotel[], int qtd) {
        Scanner s = new Scanner(System.in);
        System.out.println("Numero do hotel:");
        String chave = s.nextLine();
        int inicio = 0;
        int fim = qtd - 1;
        int meio;
        while (inicio <= fim) {
            meio = (inicio + fim) / 2;
            if (hotel[meio].numero.equalsIgnoreCase(chave)) {
                return meio;
            } else if (hotel[meio].numero.compareToIgnoreCase(chave) > 1) {
                fim = meio - 1;
            } else {
                inicio = meio + 1;
            }
        }
        return -1;
    }

    static int buscarHotelPorNome(Hotel hotel[], int qtd) {
        Scanner s = new Scanner(System.in);
        System.out.println("Nome do hotel:");
        String busca = s.nextLine();
        for (int i = 0; i < qtd; i++) {
            if (hotel[i].nome.equals(busca)) {
                return i;
            }
        }
        return -1;
    }

    static void alterarHotel(Hotel hotel[], int i) {
        Scanner s = new Scanner(System.in);
        System.out.print("Número: ");
        hotel[i].numero = s.nextLine();
        while (hotel[i].verificarNumero() == false) {
            System.out.print("Número: ");
            hotel[i].numero = s.nextLine();
        }

        System.out.print("Nome: ");
        hotel[i].nome = s.nextLine();
        while (hotel[i].verificarNome() == false) {
            System.out.print("Nome: ");
            hotel[i].numero = s.nextLine();
        }

        System.out.print("Número de quartos: ");
        hotel[i].numerodequartos = s.nextLine();
        while (hotel[i].verificarQuarto() == false) {
            System.out.print("Número de quartos: ");
            hotel[i].numerodequartos = s.nextLine();
        }

        System.out.print("Telefone: ");
        hotel[i].telefone = s.nextLine();
        while (hotel[i].telefone.length() < 0 || hotel[i].telefone.length() > 8) {
            System.out.print("Telefone: ");
            hotel[i].telefone = s.nextLine();
        }

        System.out.print("Tarifa por quarto:");
        hotel[i].tarifaporquarto = s.nextDouble();
        while (hotel[i].tarifaporquarto <= 0) {
            System.out.print("Tarifa por quarto:");
            hotel[i].tarifaporquarto = s.nextDouble();
        }
    }

    static void excluirHotel(Hotel hotel[], int pos, int qtd) {
        hotel[pos] = hotel[qtd - 1];
    }

    static void salvarArquivos(Hotel hotel[], int qtd) {
        Scanner s = new Scanner(System.in);
        //ordenação
        System.out.println("Deseja imprimir por: \n1-Número \n2-Nome");
        int ordenar = s.nextInt();
        System.out.println("\nLISTA DE HOTEIS CADASTRADOS:");
        if (ordenar == 1) {
            ordenaPorNumero(hotel, qtd);
        } else {
            ordenaPorNome(hotel, qtd);
        }
        for (int i = 0; i < qtd; i++) {
            System.out.print(hotel[i].imprimirParaArquivo());
            File file = new File("C:\\Hotel.txt");
            FileWriter imp;
            try {
                for (i = 0; i < qtd; i++) {
                    imp = new FileWriter(file, true);
                    imp.write(hotel[i].imprimirParaArquivo() + ";");
                    imp.close();
                }
            } catch (Exception e) {
                System.out.println("Não foi possível escrever no arquivo");
            }
        }

    }

    static void carregarArquivos(Hotel hotel[], int qtd) {
        File f = new File("Hotel.txt");
        FileReader leitura;
        try {
            leitura = new FileReader(f);
            BufferedReader br = new BufferedReader(leitura);
            String linha = "";
            while ((linha = br.readLine()) != null) {
                String partes[] = linha.split(";");
                if (partes.length == 5) {
                    hotel[qtd] = new Hotel();
                    hotel[qtd].numero = partes[0];
                    hotel[qtd].nome = partes[1];
                    hotel[qtd].numerodequartos = partes[2];
                    hotel[qtd].telefone = partes[3];
                    hotel[qtd].tarifaporquarto = Double.parseDouble(partes[4]);
                    qtd++;
                }
            }
            leitura.close();
            br.close();
        } catch (Exception ex) {
            System.out.println("Não foi possível escrever no arquivo");
        }

    }

}
