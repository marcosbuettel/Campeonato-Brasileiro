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

public class Jogador extends Pessoa{
   private String timeAtual;
   private double salario;
   
   public Jogador(){
   }
   
   public Jogador(String nome, int cpf, String dataRecebida){
      setNome(nome);
      setCpf(cpf);
      
      try{
         SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
         Date date = formatador.parse(dataRecebida);
         String dataFormatada = formatador.format(new Date());     
      
         setNascimento(date);
      }
      catch (ParseException e){
         
      }
   }
   
   public String getTimeAtual(){
      return this.timeAtual;
   }
   
   public void setTimeAtual(String timeAtual){
      this.timeAtual = timeAtual;
   }
   
   public double getSalario(){
      return this.salario;
   }
   
   public void setSalario(double salario){
      this.salario = salario;
   }
}