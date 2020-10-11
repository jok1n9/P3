package aula1.ex2;

public class Data {
	private int dia;
	private int mes;
	private int ano;
	
	public Data(int dia, int mes, int ano) 
	{
	    this.dia = dia;
	    this.mes = mes;
	    this.ano = ano;
	}
	
	public Data(String a)
	{
		int c=Integer.parseInt(a.split("/")[0]);
		int d=Integer.parseInt(a.split("/")[1]);
		int e=Integer.parseInt(a.split("/")[2]);
		
		assert(isValidData(c,d,e)):"Data não Válida";
		
		this.dia= c;
		this.mes=d;
		this.ano=e;
		
	}
	
	public int getDia()
	{
		return this.dia;
	}
	
	public int getMes()
	{
		return this.mes;
	}
	
	public int getAno()
	{
		return this.ano;
	}

	public String toString()
	{
		return this.dia + "/" + this.mes + "/" + this.ano;
	}
	
	private boolean isValidData(int dia, int mes,int ano) 
	
	{
		boolean val= true;
		boolean bissexto= (ano % 400 == 0) || ((ano % 4 == 0) && !(ano % 100 == 0));
		int[] mesbissexto= {31,29,31,30,31,30,31,31,30,31,30,31};
		int[] mesnbissexto= {31,28,31,30,31,30,31,31,30,31,30,31};
		
		if(mes <0 && mes > 12) val= false;
		
		if(ano<1903) val= false;//ano de nascimento da pessoa mais velha do mundo
		
		if(bissexto)
		{
			if(dia>mesbissexto[mes]) val= false;
		}
		else {
			if(dia>mesnbissexto[mes]) val= false;
		}
		
		
		return val;
	} 
}
