import java.util.Scanner;

public class Campeonato{
   private Time[] serieA;
   private int ano;
   private Tabela tabela;
   private Rodada[] rodadas;
   private int numTimesAdicionados;
   private int numTimes;
   
   public Campeonato(int ano){
      this.ano = ano;
      numTimesAdicionados = 0;
      numTimes = 6;
      int numRodadas = (numTimes-1)*2;
      serieA = new Time[numTimes];
      rodadas =  new Rodada[numRodadas];
      tabela = new Tabela();
   }
   
   //--------------------------------------------------------------
   //M�todo para adicionar o time ao campeonato
   //--------------------------------------------------------------
   public void addTime(Time novo){
      for(int i = 0; i<6;i++){
         if(serieA[i] == null){
            serieA[i] = novo;
            break;
         }
      }
   }
   
   //--------------------------------------------------------------
   //M�todo mostrar os times do campeonato
   //--------------------------------------------------------------
   public void printTimes(){
      for(int i = 0; i<6;i++){
         if(serieA[i] != null){
            System.out.println(i + " - " + serieA[i].getNome());
         }
      }
   }
   
   //--------------------------------------------------------------
   //M�todo para adicionar uma nova rodada
   //--------------------------------------------------------------
   public void novaRodada(int novaRodada){
      System.out.println("Selecione a partida que deseja editar, digite 0 para cancelar: ");
      System.out.println("Partidas");
      
      Scanner ler = new Scanner(System.in);
      
      int opcao = 4;
      int opcMandante;
      int opcVisitante;
      int golsM = 0;
      int golsV = 0;
      
      String mandante;
      String visitante;
     
      Partida partida1 = new Partida();
      Partida partida2 = new Partida();
      Partida partida3 = new Partida();
      
      while(opcao != 0){
      
         System.out.print("1 - ");
         if(partida1.getMandante() != null){ //nesses ifs estou verificando se o mandante est� vazio, caso n�o esteja, 
                                             //ele vai preencher com os nomes dos times
            partida1.printResultadoRegistrado();
         }
         else{
            System.out.println(" ");
         }
         
         System.out.print("2 - ");
         if(partida2.getMandante() != null){
            partida2.printResultadoRegistrado();
         }
         else{
            System.out.println(" ");
         }
         
         System.out.print("3 - ");
         if(partida3.getMandante() != null){
            partida3.printResultadoRegistrado();
         }
         else{
            System.out.println(" ");
         }
         
         opcao = ler.nextInt();
         
         if(opcao == 0){
            return;
         }
         
         while(opcao != 1 && opcao != 2 && opcao != 3 && opcao != 0){
            System.out.println("Escolha uma op��o v�lida!");
            opcao = ler.nextInt();
         }         
         
         System.out.println("Partida " + opcao + " selecionada");
         System.out.println("Quem � o mandante?");
         
         System.out.println(" ");
         printTimes();
         System.out.println(" ");
         
         opcMandante = ler.nextInt(); 
         
         if(opcao == 1){            
            while(verificaTimeRepetido(serieA[opcMandante].getNome(), partida2, partida3) == true){
               //estou chamando a fun��o verificaTimeRepetido para verificar se o time n�o est�
               //cadastrado em outra partida da mesma rodada
               System.out.println("Esse time j� est� registrado em outra partida, escolha outro!");
              
               System.out.println(" ");
               printTimes();
               System.out.println(" ");
              
               opcMandante = ler.nextInt(); 
            }            
         }
         else if(opcao == 2){
            while(verificaTimeRepetido(serieA[opcMandante].getNome(), partida1, partida3) == true){
               System.out.println("Esse time j� est� registrado em outra partida, escolha outro!");
              
               System.out.println(" ");
               printTimes();
               System.out.println(" ");
               
               opcMandante = ler.nextInt(); 
            }
         }
         else if(opcao == 3){
            while(verificaTimeRepetido(serieA[opcMandante].getNome(), partida1, partida2) == true){
               System.out.println("Esse time j� est� registrado em outra partida, escolha outro!");
              
               System.out.println(" ");
               printTimes();
               System.out.println(" ");
               
               opcMandante = ler.nextInt(); 
            }
         }                
        
         System.out.println("Quem � o visitante?");
         
         System.out.println(" ");
         printTimes();
         System.out.println(" ");
         
         opcVisitante = ler.nextInt();
         
         while(serieA[opcMandante].getNome() == serieA[opcVisitante].getNome()){
            //estou verificando se o time escolhido para o visitante n�o � o mesmo
            //escolhido para o mandante
            System.out.println("O visitante deve ser diferente do mandante!");
            System.out.println(" ");
            printTimes();
            System.out.println(" ");
            
            opcVisitante = ler.nextInt();         
         }
         
         if(opcao == 1){            
            while(verificaTimeRepetido(serieA[opcVisitante].getNome(), partida2, partida3) == true){
               System.out.println("Esse time j� est� registrado em outra partida, escolha outro!");
              
               System.out.println(" ");
               printTimes();
               System.out.println(" ");
              
               opcVisitante = ler.nextInt(); 
            }            
         }
         else if(opcao == 2){
            while(verificaTimeRepetido(serieA[opcVisitante].getNome(), partida1, partida3) == true){
               System.out.println("Esse time j� est� registrado em outra partida, escolha outro!");
              
               System.out.println(" ");
               printTimes();
               System.out.println(" ");
               
               opcVisitante = ler.nextInt(); 
            }
         }
         else if(opcao == 3){
            while(verificaTimeRepetido(serieA[opcVisitante].getNome(), partida1, partida2) == true){
               System.out.println("Esse time j� est� registrado em outra partida, escolha outro!");
              
               System.out.println(" ");
               printTimes();
               System.out.println(" ");
               
               opcVisitante = ler.nextInt(); 
            }
         }        
         
         System.out.println(" ");  
         System.out.println("Quantos gols do " + serieA[opcMandante].getNome());
         golsM = ler.nextInt();
         
         System.out.println(" ");  
         System.out.println("Quantos gols do " + serieA[opcVisitante].getNome());
         golsV = ler.nextInt();         
    
         if(opcao == 1){//aqui estou verificando qual partida foi escolhida la no in�cio para salvar os dados na partida escolhida 
            partida1.setMandante(serieA[opcMandante]); 
            partida1.setVisitante(serieA[opcVisitante]); 
            partida1.setGolsA(golsM);
            partida1.setGolsB(golsV);
            
            escolherPartida(partida1, opcMandante, opcVisitante);
            
         }
         else if(opcao == 2){         
            partida2.setMandante(serieA[opcMandante]); 
            partida2.setVisitante(serieA[opcVisitante]); 
            partida2.setGolsA(golsM);
            partida2.setGolsB(golsV);
            
            escolherPartida(partida2, opcMandante, opcVisitante);
         }       
         else if(opcao == 3){
            partida3.setMandante(serieA[opcMandante]); 
            partida3.setVisitante(serieA[opcVisitante]); 
            partida3.setGolsA(golsM);
            partida3.setGolsB(golsV);
            
            escolherPartida(partida3, opcMandante, opcVisitante);
         }               
      }          
   } 
   
   //--------------------------------------------------------------
   //M�todo para verificar em qual partida est�,
   //para ent�o adicionar os pontos para o vencedor da partida
   //--------------------------------------------------------------
   private void escolherPartida(Partida partida, int opcMandante, int opcVisitante){
      
      if(partida.getResultado() == 1){         
         serieA[opcMandante].setPontos(serieA[opcMandante].getPontos() + 3);
      }
      else if(partida.getResultado() == -1){
         serieA[opcVisitante].setPontos(serieA[opcVisitante].getPontos() + 3);
      }
      else{
         serieA[opcMandante].setPontos(serieA[opcMandante].getPontos() + 1);
         serieA[opcVisitante].setPontos(serieA[opcVisitante].getPontos() + 1);
      }   
   }
   
   //--------------------------------------------------------------
   //M�todo para verificar se o time a ser adicionado j� n�o
   //foi adicionado anteriormente
   //--------------------------------------------------------------
   public boolean verificaTimeRepetido(String timeAtual, Partida partidaA, Partida partidaB){
      //primeiro eu verifico se a partida em quest�o n�o est� vazia
      //para depois comparar os times
      if(partidaA.getMandante() != null){
         if(timeAtual == partidaA.getMandante().getNome() || timeAtual == partidaA.getVisitante().getNome()){
            return true;
         }
      }
      if(partidaB.getMandante() != null){
         if(timeAtual == partidaB.getMandante().getNome() || timeAtual == partidaB.getVisitante().getNome()){
            return true;
         }      
      }
      
      return false;
   }    
   
   //--------------------------------------------------------------
   //M�todo para checar cpf repetido
   //--------------------------------------------------------------   
   public void checaFraudes(){
      System.out.println(" ");
      System.out.println("Checando fraudes:");
      System.out.println(" ");
      
      for(int i = 0; i < serieA.length;i++){ //Nesse for eu caminho pelos times
         for(int j = 0; j < serieA.length; j++){ //Nesse for eu come�o analisar pelo primeiro jogador do elenco
            for(int k = j+1; k < serieA[i].getElenco().length; k++){ //Nesse for eu come�o do pr�ximo jogador do elenco e vou comparando
               if(serieA[i].getElenco()[j] != null && serieA[i].getElenco()[k] != null){
                  if(serieA[i].getElenco()[j].getCpf() == serieA[i].getElenco()[k].getCpf()){
                    System.out.println(serieA[i].getElenco()[j].getNome() + " e " + serieA[i].getElenco()[k].getNome() + " tem cpf's iguais!");
                  }
               }
            }            
         }
      }
      
      System.out.println(" ");
   }
   
   //--------------------------------------------------------------
   //M�todo para transferir um jogador de um time
   //para o outro
   //--------------------------------------------------------------
   public void transferencia(){
      
      Scanner ler = new Scanner(System.in);      
      int novoTime;
      int verificaElenco = 0;
      int timeEscolhido;
      int jogadorEscolhido;
      double salario;
      
      System.out.println("De qual time o jogador a ser transferido pertence?");
      
      System.out.println(" ");
      printTimes();
      System.out.println(" ");
      
      timeEscolhido = ler.nextInt();
      
      for(int i = 0; i < serieA[timeEscolhido].getElenco().length;i++){
         if(serieA[timeEscolhido].getElenco()[i] != null){
            verificaElenco = 1;
         }
      }
      
      while(verificaElenco != 1){ //verificando se o elenco do time selecionado est� vazio
         System.out.println("Time escolhido n�o possui elenco, escolha outro: ");
         timeEscolhido = ler.nextInt();
         
         for(int i = 0; i < serieA[timeEscolhido].getElenco().length;i++){
            if(serieA[timeEscolhido].getElenco()[i] != null){
               verificaElenco = 1;
            }
         }
      }
      
      System.out.println("Escolha o jogador: ");
      
      for(int i = 0;i < serieA[timeEscolhido].getElenco().length;i++){
         if(serieA[timeEscolhido].getElenco()[i] != null){
            System.out.println(i + " " + serieA[timeEscolhido].getElenco()[i].getNome());
         }
      }
      
      jogadorEscolhido = ler.nextInt();
      
      System.out.println(serieA[timeEscolhido]); 
      
      System.out.println("Para qual time " + serieA[timeEscolhido].getElenco()[jogadorEscolhido].getNome() + " ser� transferido?");
      
      System.out.println(" ");
      printTimes();
      System.out.println(" ");
      
      novoTime = ler.nextInt(); 
      
      while(serieA[novoTime].getNome() == serieA[timeEscolhido].getElenco()[jogadorEscolhido].getTimeAtual()){
         System.out.println("Esse � o time atual do jogador, escolha outro: ");
         
         System.out.println(" ");
         printTimes();
         System.out.println(" ");
      
         novoTime = ler.nextInt(); 
      }
      
      System.out.println("Qual o sal�rio?");
      
      salario = ler.nextInt(); 
      
      serieA[novoTime].contrataJogador(serieA[timeEscolhido].getElenco()[jogadorEscolhido], salario);    
     
      System.out.println("Time Escolhido: " + serieA[timeEscolhido].getNome());
      System.out.println("Time Atual: " + serieA[timeEscolhido].getElenco()[jogadorEscolhido].getTimeAtual());     
         
      serieA[timeEscolhido].vendeJogador(serieA[timeEscolhido].getElenco()[jogadorEscolhido].getNome());    
      
   }
   
   //--------------------------------------------------------------
   //M�todo para printar as cidades dos times
   //--------------------------------------------------------------
   public void listaCidades(){
         
      String[] cidades = new String[serieA.length];
      
      //n�o consegui pensar em uma maneira melhor de fazer essa parte 
      //para n�o exibir as cidades que aparecem mais de uma vez
      //ent�o salvei todas as cidades registradas em um vetor separado
      //depois eu percorri esse vetor verificando quais as cidades
      //apareciam mais de uma vez, se caso ela aparecesse de novo
      //o novo vetor ia preencer com vazio na posi��o da cidade repetida
      
      for(int i = 0; i < serieA.length;i++){
         cidades[i] = serieA[i].getCidade();
      }
      
      for(int i = 0; i < serieA.length;i++){
         for(int j = i + 1; j < serieA.length;j++){
            if(cidades[i] == serieA[j].getCidade()){
               cidades[j] = null;            
            }         
         }       
      }
      
      for(int i = 0; i < serieA.length;i++){
         if(cidades[i] != null){
            System.out.println(cidades[i]);  
         }
      }
   }
   
   //--------------------------------------------------------------
   //M�todo para mostrar a classifica��o atual do campeonato
   //--------------------------------------------------------------
   public void classificacao(){
      
      System.out.println(" ");
      System.out.println("Classifica��o do campeonato:");
      System.out.println(" ");
      
      for(int i = 0; i < serieA.length;i++){
         System.out.println(serieA[i].getNome() + " Pontos: " + serieA[i].getPontos());
      }
   }   
}