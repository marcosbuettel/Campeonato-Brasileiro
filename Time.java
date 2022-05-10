public class Time{
   private String nome;
   private String cidade;
   private Jogador[] elenco;
   private int pontos;
   
   public Time(){      
   }
   
   public Time(String nome, String cidade){
      elenco = new Jogador[20];
      this.nome = nome;
      this.cidade = cidade;
   }
   
   public String getNome(){
      return this.nome;
   }
   
   public void setNome(String nome){
      this.nome = nome;
   }
   
   public String getCidade(){
      return this.cidade;
   }
   
   public void setCidade(String cidade){
      this.cidade = cidade;
   }
   
   public Jogador[] getElenco(){
      return this.elenco;
   }
   
   public void setElenco(Jogador[] elenco){
      this.elenco = elenco;
   }
   
   public int getPontos(){
      return this.pontos;
   }
   
   public void setPontos(int pontos){
      this.pontos = pontos;
   }
   
   public void contrataJogador(Jogador comprado, double salario){
      comprado.setTimeAtual(this.getNome());
      for(int i = 0; i<elenco.length;i++){
         if(elenco[i] == null){
            elenco[i] = comprado;
            break;
         }
      }
      comprado.setSalario(salario);
   }
   
   //fiz esse método para retirar o jogador do time atual
   //para fazer a transferência para o novo time
   public void vendeJogador(String nomeJogador){
      for(int i = 0; i<elenco.length;i++){
         if(elenco[i] != null && elenco[i].getNome() == nomeJogador){
            elenco[i] = null;
            break;
         }
      }
   }
   
   public void printElenco(){
      System.out.println("Elenco do: " + getNome());
      for(int i = 0; i < elenco.length;i++){
         if(elenco[i] != null){
            System.out.println(elenco[i].getNome());
         }
      }
   }
}