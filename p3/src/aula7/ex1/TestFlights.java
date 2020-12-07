package aula7.ex1;
import java.io.IOException;

import aula3.ex1.Date;

public class TestFlights {

	public static void main(String[] args) throws IOException {
		
		FlightsList fl = new FlightsList("voos.txt",new Date("24/5/2000"),"Porto");
		
		fl.displayFlights();
		
		fl.saveToFile();
		
		fl.displayAverageCompanyDelays(); 		
		
		fl.saveCities();
		
		fl.saveFlights();
		
		fl.loadFlights();
	}

}
