package com.trybe.java.regraprogressao;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    ArrayList<Atividade> atividades = cadastrarAtividades(scanner);
    ArrayList<Nota> notas = inserirNotas(scanner, atividades);
    double percentualAlcancado = calcularResultado(atividades, notas);

    if (percentualAlcancado >= 85) {
      System.out.printf(
          "Parabéns! Você alcançou %.2f%%! Temos o prazer de informar que você obteve aprovação!%n",
          percentualAlcancado);
    } else {
      System.out.printf(
          "Lamentamos informar que, com base na sua pontuação alcançada neste período, %.2f%%, você não atingiu a pontuação mínima necessária para sua aprovação.%n",
          percentualAlcancado);
    }

    scanner.close();
  }

  public static ArrayList<Atividade> cadastrarAtividades(Scanner scanner) {
    System.out.print("Digite a quantidade de atividades para cadastrar:\n");
    int quantidadeAtividades = scanner.nextInt();
    scanner.nextLine(); // Consumir a quebra de linha após o próximo inteiro

    ArrayList<Atividade> atividades = new ArrayList<>();

    for (int i = 0; i < quantidadeAtividades; i++) {
      System.out.printf("Digite o nome da atividade %d:%n", i + 1);
      String nome = scanner.nextLine();

      System.out.printf("Digite o peso da atividade %d:%n", i + 1);
      int peso = scanner.nextInt();
      scanner.nextLine(); // Consumir a quebra de linha após o próximo inteiro

      atividades.add(new Atividade(nome, peso));
    }

    return atividades;
  }

  public static ArrayList<Nota> inserirNotas(Scanner scanner, ArrayList<Atividade> atividades) {
    ArrayList<Nota> notas = new ArrayList<>();

    for (Atividade atividade : atividades) {
      System.out.printf("Digite a nota obtida para %s:%n", atividade.getNome());
      double nota = scanner.nextDouble();
      scanner.nextLine(); // Consumir a quebra de linha após o próximo double

      notas.add(new Nota(atividade, nota));
    }

    return notas;
  }

  public static double calcularResultado(ArrayList<Atividade> atividades, ArrayList<Nota> notas) {
    double totalPontos = 0;
    double totalPesos = 0;

    for (int i = 0; i < atividades.size(); i++) {
      Atividade atividade = atividades.get(i);
      Nota nota = notas.get(i);

      totalPontos += (nota.getPontos() / 100) * atividade.getPeso();
      totalPesos += atividade.getPeso();
    }

    return (totalPontos / totalPesos) * 100;
  }
}

class Atividade {

  private String nome;
  private int peso;

  public Atividade(String nome, int peso) {
    this.nome = nome;
    this.peso = peso;
  }

  public String getNome() {
    return nome;
  }

  public int getPeso() {
    return peso;
  }
}

class Nota {

  private Atividade atividade;
  private double pontos;

  public Nota(Atividade atividade, double pontos) {
    this.atividade = atividade;
    this.pontos = pontos;
  }

  public Atividade getAtividade() {
    return atividade;
  }

  public double getPontos() {
    return pontos;
  }
}

