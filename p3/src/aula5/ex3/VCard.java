package aula5.ex3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import aula3.ex1.Person;
import aula3.ex1.Date;

public class VCard implements Loadable{

	@Override
	public void saveFile(Person[] a, String name) throws FileNotFoundException, IOException {
		File f = new File(name);
		if(!f.exists()) f.createNewFile();
		PrintWriter pw = new PrintWriter(f);
		pw.println("vCard");
		for(int i = 0; i < a.length; i++) {
			if(i != a.length-1)
				pw.println("#"+a[i].getName()+"#"+a[i].getCC()+"#"+a[i].getBirthDate().toString());
			else
				pw.print("#"+a[i].getName()+"#"+a[i].getCC()+"#"+a[i].getBirthDate().toString());
		}
		pw.close();		
	}

	@Override
	public Person[] loadFile(File f) throws FileNotFoundException {
		Scanner sf = new Scanner(f);
		sf.nextLine();  //ignore first line
		int size = 0;		
		while(sf.hasNextLine()) {
			size++;
			sf.nextLine();
		}
		sf.close();
		Person[] people = new Person[size];
		
		sf = new Scanner(f);
		sf.nextLine();  //ignore first line
		
		for(int i = 0; i < people.length; i++) {			
			String data[] = sf.nextLine().split("#");
			people[i] = new Person(data[1],Integer.parseInt(data[2]),new Date(data[3]));
		}		
		sf.close();		
		return people;
	}
	
}
