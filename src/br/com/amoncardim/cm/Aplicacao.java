package br.com.amoncardim.cm;

import br.com.amoncardim.cm.modelo.Tabuleiro;
import br.com.amoncardim.cm.visao.TabuleiroConsole;

public class Aplicacao {

    public static void main(String[] args) {

        Tabuleiro tabuleiro = new Tabuleiro(6, 6, 3);
        new TabuleiroConsole(tabuleiro);

    }
}
