package com.botafogo.rh.model;

import java.util.Locale;

/**
 * Representa um atleta do elenco, tratado como um funcionario dentro da
 * estrutura de RH do clube. A classe e imutavel: uma vez cadastrado, os
 * dados do atleta nao mudam durante a execucao das buscas.
 */
public final class Atleta {

    private final String nome;
    private final String posicao;
    private final double salario;
    private final int potencial;

    public Atleta(String nome, String posicao, double salario, int potencial) {
        this.nome = nome;
        this.posicao = posicao;
        this.salario = salario;
        this.potencial = potencial;
    }

    public String getNome() {
        return nome;
    }

    public String getPosicao() {
        return posicao;
    }

    public double getSalario() {
        return salario;
    }

    public int getPotencial() {
        return potencial;
    }

    @Override
    public String toString() {
        return String.format(
                new Locale("pt", "BR"),
                "%s | %s | Salario: R$%.2f | POT: %d",
                nome, posicao, salario, potencial);
    }
}
