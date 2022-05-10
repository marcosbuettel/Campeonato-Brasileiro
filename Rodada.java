public class Rodada{
   private Partida[] jogos;
   
   public Rodada(){
      Partida[] jogos = new Partida[3];
   }
   
   public Partida[] getJogos(){
      return this.jogos;
   }
   
   public void setJogos(Partida[] jogos){
      this.jogos = jogos;
   }
}