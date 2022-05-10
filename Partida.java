public class Partida{
   private Time mandante;
   private Time visitante;
   private Jogador[] titularA;
   private Jogador[] titularB;
   private int golsA;
   private int golsB;
   
   public Partida(){
   }
   
   public Partida(Time mandante, Time visitante, int golsA, int golsB){
      this.setMandante(mandante);
      this.setGolsA(golsA);
      
      this.setVisitante(visitante);
      this.setGolsB(golsB);
   }
   
   public Time getMandante(){
      return this.mandante;
   }
   
   public void setMandante(Time mandante){
      this.mandante = mandante;
   }
   
   public Time getVisitante(){
      return this.visitante;
   }
   
   public void setVisitante(Time visitante){
      this.visitante = visitante;
   }
   
   public Jogador[] getTitularA(){
      return this.titularA;
   }
   
   public void setTitularA(Jogador[] titularA){
      this.titularA = titularA;
   }
   
   public Jogador[] getTitularB(){
      return this.titularB;
   }
   
   public void setTitularB(Jogador[] titularB){
      this.titularB = titularB;
   }
   
   public int getGolsA(){
      return this.golsA;
   }
   
   public void setGolsA(int golsA){
      this.golsA = golsA;
   }
   
   public int getGolsB(){
      return this.golsB;
   }
   
   public void setGolsB(int golsB){
      this.golsB = golsB;
   }
   
   public String getCidadeJogo(){
      return mandante.getCidade();
   }
   
   public int getResultado(){
      if(getGolsA() > getGolsB()){
         return 1;
      }
      else if(getGolsA() < getGolsB()){
         return -1;
      }
      else{
         return 0;
      }
   }
   
   public int printResultadoRegistrado(){
      System.out.println(mandante.getNome() + " " + getGolsA() + " x " + getGolsB() + " " + visitante.getNome());
      return getResultado();
   }
   
}