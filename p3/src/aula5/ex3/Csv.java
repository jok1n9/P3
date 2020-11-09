package aula5.ex3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import aula3.ex1.Date;
import aula3.ex1.Person;

public class Csv implements Loadable{

	@Override
	public void saveFile(Person[] a, String name) throws FileNotFoundException, IOException {
		File f = new File(name);
		if(!f.exists()) f.createNewFile();
		PrintWriter pw = new PrintWriter(f);
		pw.println("CSV");
		// "\t" not working, using double space instead
		for(int i = 0; i < a.length; i++) {			
			if(i != a.length-1)				
				pw.println(a[i].getName()+"  "+a[i].getCC()+"  "+a[i].getBirthDate().toString());
			else
				pw.print(a[i].getName()+"  "+a[i].getCC()+"  "+a[i].getBirthDate().toString());
		}
		pw.close();		
	}

	@Override
	public Person[] loadFile(File f) throws FileNotFoundException {
		Scanner sf = new Scanner(f);
		sf.nextLine();  //ignore first line
		int size = 0;		
		while(sf.hasNextLine()) {
			String line = sf.nextLine();
			System.out.println(line.length());
			if(line.length()!= 0)
				size++;			
		}
		sf.close();
		Person[] people = new Person[size];
		
		sf = new Scanner(f);
		sf.nextLine();  //ignore first line
		
		for(int i = 0; i < people.length; i++) {
			String line = sf.nextLine();			
			String data[] = line.split("  ");	
			//String data[] = line.split("\t"); not working, using double space instead
			people[i] = new Person(data[0],Integer.parseInt(data[1]),new Date(data[2]));
		}		
		sf.close();		
		return people;
	}
	
}
