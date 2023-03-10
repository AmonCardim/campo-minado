package br.com.amoncardim.cm.visao;

import br.com.amoncardim.cm.excecao.ExplosaoException;
import br.com.amoncardim.cm.excecao.SairException;
import br.com.amoncardim.cm.modelo.Tabuleiro;

import java.util.Scanner;

public class TabuleiroConsole {

    private Tabuleiro tabuleiro;
    private Scanner sc = new Scanner(System.in);

    public TabuleiroConsole(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;

        executarJogo();
    }

    private void executarJogo() {
        try {
            boolean continuar = true;

            while (continuar) {
                cicloDoJogo();

                System.out.println("Outra partida? (S/n) ");
                String resposta = sc.nextLine();

                if ("n".equalsIgnoreCase(resposta)) {
                    continuar = false;
                } else {
                    tabuleiro.reiniciar();
                }
            }
        } catch (SairException e) {
            System.out.println("Tchau :)");
        } finally {
            sc.close();
        }
    }

    private void cicloDoJogo() {
        try {

            while (!tabuleiro.objetivoAlcancado()) {
                System.out.println(tabuleiro);

                String digitado = capturarValorDigitado("Digite (x, y): ");
            }

            System.out.println("Você ganhou :)");
        } catch (ExplosaoException e) {
            System.out.println("Você perdeu :(");
        }
    }

    private String capturarValorDigitado(String texto) {
        System.out.print(texto);
        String digitado = sc.nextLine();

        if ("sair".equalsIgnoreCase(digitado)) {
            throw new SairException();
        }
        return digitado;
    }
}
