public class DataTerceiraEra {
  private int dia;
  private int mes;
  private int ano;
  
  public DataTerceiraEra(int dia, int mes, int ano){
    this.dia = dia;
    this.mes = mes;
    this.ano = ano;
  }
  
  public boolean ehBissexto(){
    return dia == 366;
  }
  
  public int getDia(){
    return this.dia;
  }
  
  public int getMes(){
    return this.mes;
  }
  
  public int getAno(){
    return this.ano;
  }
}
