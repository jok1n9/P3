package aula7.ex1;


import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.LinkedList;
import java.util.List;
import aula3.ex1.Date;
import aula5.ex1.UtilCompare;
import java.io.RandomAccessFile;

public class FlightsList {
	
	private LinkedList<Flight> list;
	private Date day;
	private String airport;
	private LinkedList<Company> companies;
	
	public FlightsList(String path, Date day, String airport) throws IOException {
		this.day = day;
		this.airport = airport;
		this.companies = Company.loadFromFile("src/aula7/ex1/companhias.txt");
		
		
		List<String> lines = Files.readAllLines(Paths.get(path));
		lines.remove(0);
		String[] data;
		this.list = new LinkedList<Flight>();			
		
		for(String flight : lines) {
			
			data = flight.split("\t");
			Hour hour = new Hour(data[0]);
			String name = data[1];
			Company company = Company.getFromList(name,this.companies);
			String origin = data[2];
			Hour delay = new Hour();
			String obs = "";			
			
			if(data.length > 3) {
				delay = new Hour(data[3]);
				Hour sum = Hour.sumHour(hour,delay);
				obs = "Previsto: "+sum.toString();
				Flight f = new Flight(hour,name,company,origin,delay,obs);
				this.list.add(f);
			}
			else {
				Flight f = new Flight(hour,name,company,origin,delay,obs);
				this.list.add(f);
			}			
		}	
	}
	
	public void displayFlights() {
		String format = "%-7.7s%-11.11s%-21.21s%-23.23s%-9.9s%-20.20s";
		System.out.println(String.format(format,"Hora","Voo","Companhia","Origem","Atraso","Obs"));
		for(Flight f : this.list) {			
			System.out.println(f);
		}		
	}
	
	public void saveToFile() throws IOException {
		String format = "%-7.7s%-11.11s%-21.21s%-23.23s%-9.9s%-20.20s\n";
		String header = String.format(format,"Hora","Voo","Companhia","Origem","Atraso","Obs");
		Files.write(Paths.get("src/aula7/ex1/Infopublico.txt"),header.getBytes());
		for(Flight f : this.list) {
			String line = f.toString()+"\n";
			Files.write(Paths.get("src/aula7/ex1/Infopublico.txt"),line.getBytes(), StandardOpenOption.APPEND);
		}
	}	
	
	public AverageCompanyDelay[] getAverageDelays() {
		AverageCompanyDelay[] acd = new AverageCompanyDelay[this.companies.size()];
		
		for(int i = 0; i < this.companies.size(); i++)	{
			int totalMinutes = 0;
			int length = 0;	
			Company c = this.companies.get(i);
			for(Flight f : this.list) {
				if(f.getCompany() != null) {
					if(f.getCompany().equals(c)) {
						totalMinutes+= f.getDelay().getTotalMinutes();
						length++;
					}
				}
			}
			int average = totalMinutes/length;
			acd[i] = new AverageCompanyDelay(c,new Hour(average));
		}
		UtilCompare.sortArray(acd);
		return acd;
	}
	
	public void displayAverageCompanyDelays() {
		AverageCompanyDelay[] acd = getAverageDelays();
		String format = "%-21.21s%s";
		System.out.println(String.format(format, "Companhia","Atraso Médio(Minutos)"));
		for(AverageCompanyDelay a : acd) {
			System.out.println(a);
		}
	}
	
	public void saveCities() throws IOException {
		String format = "%-23.23s%s";
		String header = String.format(format, "Origem","Voos\n");
		String path = "src/aula7/ex1/cidades.txt";
		Files.write(Paths.get(path),header.getBytes());
		
		LinkedList<String> cities = new LinkedList<String>();
		
		for(Flight f : this.list)
		{
			int k = 0;
			
			for(Flight f2 : this.list)
			{
				if(f.getOrigin().equals(f2.getOrigin()) && !cities.contains(f.getOrigin()))				
					k++;				
			}			
			if(!cities.contains(f.getOrigin()))
			{
				cities.add(f.getOrigin());
				String line = String.format(format, f.getOrigin(),k)+ "\n";
				Files.write(Paths.get(path), line.getBytes(), StandardOpenOption.APPEND );
			}
		}		
	}
	
	public void saveFlights() throws IOException {		
		String path = "src/aula7/ex1/Infopublico.bin";				
		RandomAccessFile raf = new RandomAccessFile(path,"rw");		
		String format = "%-7.7s%-11.11s%-21.21s%-23.23s%-9.9s%-20.20s\n";
		String header = String.format(format,"Hora","Voo","Companhia","Origem","Atraso","Obs");
		raf.writeBytes(header);
		for(Flight f : this.list) {
			String line = f.toString()+"\n";
			raf.writeBytes(line);
		}
		raf.close();
	}
	
	public void loadFlights() throws IOException {		
		String path = "src/aula7/ex1/Infopublico.bin";				
		RandomAccessFile raf = new RandomAccessFile(path,"r");		
		String line = raf.readLine();
		while(line != null) {
			System.out.println(line);
			line = raf.readLine();			
		}
		raf.close();			
	}
	
	public Date getDay() {
		return this.day;
	}
	
	public String getAirport() {
		return this.airport;
	}

}
