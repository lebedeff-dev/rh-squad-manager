# 02 - RH Squad Manager

Aplicacao de terminal em Java que gerencia o elenco de um clube de futebol
(Botafogo como massa de dados) usando estruturas de RH. Filtra atletas por
posicao, teto salarial e potencial minimo com a API de Streams, alem de
calcular a folha salarial total.

## Estrutura

```
src/com/botafogo/rh/
├── Main.java                  # ponto de entrada
├── model/Atleta.java          # entidade (imutavel)
└── service/ClubeRH.java       # nucleo de RH e filtros via Streams
```

## Como compilar e executar

A partir da pasta do projeto:

```bash
javac -d out $(find src -name "*.java")
java -cp out com.botafogo.rh.Main
```

No Windows (PowerShell):

```powershell
javac -d out (Get-ChildItem -Recurse -Filter *.java src | ForEach-Object FullName)
java -cp out com.botafogo.rh.Main
```
