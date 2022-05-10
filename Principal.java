/*
Unifaminas
Curso: Análise e Desenvolvimento de Sistemas
Disciplina: Paradigmas de Linguagem de Programação
Professor: Flávio Motta
Data de entrega: A definir
*/

import java.util.Scanner;

public class Principal{
   public static Time America;
   public static Time AtleticoMG;
   public static Time AthleticoPR;
   public static Time AtleticoGO;
   public static Time Bahia;
   public static Time Bragantino;
   
   public static Jogador Joao;
   public static Jogador Pedro;
   public static Jogador Victor;
   public static Jogador Pablo;
   public static Jogador Neymar;
   public static Jogador Messi;
   
   public static Jogador Alberto;
   public static Jogador Cesar;
   
   public static Campeonato br2021;
      
   public static void primeiraExecucao(){
      Time America = new Time("América-MG", "Belo Horizonte");
      Time AtleticoMG = new Time("Atlético-MG", "Belo Horizonte");
      Time AthleticoPR = new Time("Athletico-PR", "Curitiba");
      Time AtleticoGO = new Time("Atlético-GO", "Goiânia");
      Time Bahia = new Time("Bahia", "Bahia");
      Time Bragantino = new Time("Red Bull Bragantino", "Bragança Paulista");
      
      try{
         Joao = new Jogador("João", 115544, "01/01/2000");
         Pedro = new Jogador("Pedro", 223344, "21/11/2001");
         Victor = new Jogador("Victor", 555544, "04/03/1999");
         Pablo = new Jogador("Pablo", 125544, "08/05/1998");
         Neymar = new Jogador("Neymar", 115544, "15/10/2005");
         Messi = new Jogador("Messi", 515544, "28/02/2004");
      }catch(Exception e){
         System.out.println("Erro no formato de data");
      }
      
      br2021 = new Campeonato(2021);
      
      br2021.addTime(America);
      br2021.addTime(AtleticoMG);
      br2021.addTime(AthleticoPR);
      br2021.addTime(AtleticoGO);
      br2021.addTime(Bahia);
      br2021.addTime(Bragantino);
      
      America.contrataJogador(Joao, 1400);
      AtleticoMG.contrataJogador(Pedro, 18000);
      AthleticoPR.contrataJogador(Victor, 3500);
      AtleticoGO.contrataJogador(Pablo,38000);
      Bahia.contrataJogador(Neymar,9999999);
      Bragantino.contrataJogador(Messi,10);
   }
      
   public static void main(String[] args){
      primeiraExecucao();
      System.out.println("Este é o programa para controle do campeonato brasileiro");
      Scanner ler = new Scanner(System.in);
      int rodada = 1;
      int opcao = 0;
      while(rodada < 12){
         System.out.println("Atualmente estamos na rodada " + rodada + ", o que deseja fazer?");         
         System.out.println("1 - Registrar nova rodada");
         System.out.println("2 - Registrar transferência de jogador");
         System.out.println("3 - Checar por fraudes em CPF");
         System.out.println("4 - Listar cidades dos times");
         System.out.println("5 - Checar classificação atual");
         opcao = ler.nextInt();
         
         switch(opcao){
            case 1://Caso seja selecionado registrar nova rodada
               br2021.novaRodada(rodada);
               rodada++;
               break;
            case 2://Caso seja selecionado registrar transferencia de jogador
               br2021.transferencia();               
               break;
            case 3://Caso seja selecionado para checar fraudes
               br2021.checaFraudes();               
               break;
            case 4://Caso seja selecionado listagem das cidades
               br2021.listaCidades();               
               break;
            case 5://Caso seja selecionado classificacao atual
               br2021.classificacao();               
               break;
            default:
               break;
         }
      }
   }
}