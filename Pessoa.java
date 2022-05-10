import java.util.Date;
import java.util.Calendar;
import java.text.Format;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.sql.Timestamp;
import java.text.ParseException;
import java.lang.Integer;
import java.lang.Number;

public class Pessoa{
   private String nome;
   private int cpf;
   private Date nascimento;
   private double peso;
   private double altura;
   
   public Pessoa(){
   }
   
   public Pessoa(String nome, String dataRecebida, double peso, double altura){
      this.nome = nome;
      this.peso = peso;
      this.altura = altura;
      
      try{
         SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
         Date date = formatador.parse(dataRecebida);
         String dataFormatada = formatador.format(new Date());
         this.nascimento = date;
      }
      catch (ParseException e){
         
      }
      
   }
   
   public String getNome(){
      return this.nome;
   }
   
   public void setNome(String nome){
      this.nome = nome;
   }
   
   public int getCpf(){
      return this.cpf;
   }
   
   public void setCpf(int cpf){
      this.cpf = cpf;
   }
   
   public Date getNascimento(){ 
          
      return this.nascimento;
   }
   
   public void setNascimento(Date nascimento){
      this.nascimento = nascimento;
   }
   
   public double getPeso(){
      return this.peso;
   }
   
   public void setPeso(double peso){
      this.peso = peso;
   }
   
   public double getAltura(){
      return this.altura;
   }
   
   public void setAltura(double altura){
      this.altura = altura;
   }
   
   
   public int calculaIdade(){
      int idade = 0;
      int anoNascimento = 0;
      int anoAtual = 0;
      
      SimpleDateFormat formatador = new SimpleDateFormat("yyyy");
      
      String dataFormatada = formatador.format(getNascimento());    
     
      anoAtual = Integer.valueOf(formatador.format(new Date()));
      
      anoNascimento = Integer.parseInt(dataFormatada);       
      
      idade = anoAtual - anoNascimento;
      
      return idade;
   }  
   
   public double calculaIMC(){
      double alturaRecebida = getAltura();
      double pesoRecebida = getPeso();
      double imc;
      
      imc = pesoRecebida/(alturaRecebida*alturaRecebida);
      
      return imc;
   }
   
}