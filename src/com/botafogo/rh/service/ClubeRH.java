package com.botafogo.rh.service;

import com.botafogo.rh.model.Atleta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Nucleo de RH do clube. Guarda o elenco em memoria e expoe operacoes de
 * filtragem baseadas na API de Streams do Java, a mesma abordagem usada em
 * backends para varrer colecoes por multiplos criterios encadeados.
 */
public class ClubeRH {

    private final List<Atleta> elenco = new ArrayList<>();

    public void adicionarAtleta(Atleta atleta) {
        elenco.add(atleta);
    }

    /**
     * Retorna o elenco completo em modo somente leitura, evitando que quem
     * consome a lista altere o estado interno do clube.
     */
    public List<Atleta> getElenco() {
        return Collections.unmodifiableList(elenco);
    }

    /**
     * Filtra atletas por posicao, teto salarial e potencial minimo.
     *
     * @return lista de atletas que atendem simultaneamente aos tres criterios.
     */
    public List<Atleta> buscarPorFiltro(String posicao, double salarioMax, int potencialMin) {
        return elenco.stream()
                .filter(a -> a.getPosicao().equalsIgnoreCase(posicao))
                .filter(a -> a.getSalario() <= salarioMax)
                .filter(a -> a.getPotencial() >= potencialMin)
                .collect(Collectors.toList());
    }

    /**
     * Soma o salario de todos os atletas do elenco (folha salarial total).
     */
    public double calcularFolhaSalarial() {
        return elenco.stream()
                .mapToDouble(Atleta::getSalario)
                .sum();
    }
}
