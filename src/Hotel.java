/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 08971562692
 */
class Hotel {

    String numero;
    String nome;
    String numerodequartos;
    String telefone;
    double tarifaporquarto;

    boolean verificarNumero() {
        int i;
        boolean x = true;
        for (i = 0; i < numero.length(); i++) {
            if (numero.charAt(i) < '0' || numero.charAt(i) > '9') {
                x = false;
            }
        }
        return x;
    }
    
    boolean verificarNome() {
        boolean y = true;
        if (nome.length() > 20) {
            y = false;
        }
        return y;
    }

    boolean verificarNumeroDeQuartos() {
        int i;
        boolean x = true;
        for (i = 0; i < numerodequartos.length(); i++) {
            if (numerodequartos.charAt(i) < '0' || numerodequartos.charAt(i) > '9') {
                x = false;
            }
        }
        return x;
    }

    boolean verificarQuarto() {
        int n01 = Integer.parseInt(numerodequartos);
        boolean y = true;
        if (n01 <= 0 || n01 > 1000) {
            y = false;
        }
        return y;
    }

    String formatarTelefone() {
        return telefone.substring(0, 4) + "-" + telefone.substring(4, telefone.length());
    }

    String faturamentoMaximo() {
        int n01 = Integer.parseInt(numerodequartos);
        int x = (int) (n01 * tarifaporquarto);
        String fatMax;
        fatMax = String.valueOf(x);
        return fatMax;
    }

    String imprimir() {
        return "\nNúmero: 00" + numero + "\nNome: " + nome + "\nNº Quartos:" + numerodequartos + "\nNº de Telefone: " + formatarTelefone() + "\nTarifa: R$" + tarifaporquarto + "\nFaturamento Máximo: R$" + faturamentoMaximo() + ".00\n";
    }
    
    String imprimirParaArquivo() {
        return "\nNúmero: 00" + numero + "\nNome: " + nome + "\nNº Quartos:" + numerodequartos + "\nNº de Telefone: " + formatarTelefone() + "\nTarifa: R$" + tarifaporquarto + "\n";
    }

}
