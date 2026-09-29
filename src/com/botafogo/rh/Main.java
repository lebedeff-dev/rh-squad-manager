package com.botafogo.rh;

import com.botafogo.rh.model.Atleta;
import com.botafogo.rh.service.ClubeRH;

import java.util.List;
import java.util.Locale;

/**
 * Ponto de entrada da aplicacao de terminal. Monta o elenco do Botafogo como
 * massa de dados e executa uma busca de olheiro (custo x beneficio), alem de
 * exibir a folha salarial total do clube.
 */
public class Main {

    public static void main(String[] args) {
        ClubeRH botafogo = new ClubeRH();
        botafogo.adicionarAtleta(new Atleta("Luiz Henrique", "Atacante", 150000.0, 90));
        botafogo.adicionarAtleta(new Atleta("Matheus Martins", "Atacante", 70000.0, 85));
        botafogo.adicionarAtleta(new Atleta("John", "Goleiro", 80000.0, 81));

        System.out.println("--- Sistema de RH: Busca de Atacantes (Custo x Beneficio) ---");
        List<Atleta> encontrados = botafogo.buscarPorFiltro("Atacante", 100000.0, 80);

        if (encontrados.isEmpty()) {
            System.out.println("Nenhum atleta atende aos criterios do olheiro.");
        } else {
            encontrados.forEach(System.out::println);
        }

        System.out.printf(
                new Locale("pt", "BR"),
                "%nFolha salarial total do elenco: R$%.2f%n",
                botafogo.calcularFolhaSalarial());
    }
}
