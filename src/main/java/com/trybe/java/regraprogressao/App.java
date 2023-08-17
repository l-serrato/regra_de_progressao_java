package com.trybe.java.regraprogressao;

import java.util.Scanner;

/**
 * App.
 */
public class App {

  /**
   * Metodo main.
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Digite a quantidade de atividades para cadastrar: ");
    int atividades = Integer.parseInt(scanner.nextLine());
    int i = 0;
    int[] somaNotas = new int[atividades];
    int pesos = 0;
    while (i < atividades) {
      System.out.println("Digite o nome da atividade " + (i + 1) + ": ");
      String nome = scanner.nextLine();
      System.out.println("Digite o peso da atividade " + (i + 1) + ": ");
      int peso = Integer.parseInt(scanner.nextLine());
      System.out.println("Digite a nota obtida para " + nome + ": ");
      int nota = Integer.parseInt(scanner.nextLine());
      somaNotas[i] = peso * nota;
      pesos += peso;
      i++;
    }
    float notaTotal = 0;
    for (int j = 0; j < atividades; j++) {
      notaTotal += somaNotas[j];
    }
    if (notaTotal / pesos >= 85) {
      System.out.println("Parabéns! Você alcançou " + notaTotal / pesos
          + "%! E temos o prazer de informar que você obteve aprovação! ");
    } else {
      System.out.println("Lamentamos informar que, "
          + "com base na sua pontuação alcançada neste período, "
          + notaTotal / pesos + "%, você não atingiu a pontuação "
          + "mínima necessária para sua aprovação.");
    }
  }
}
