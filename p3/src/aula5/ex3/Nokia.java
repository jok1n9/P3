package aula5.ex3;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import aula3.ex1.Person;
import aula3.ex1.Date;

public class Nokia implements Loadable {

	@Override
	public void saveFile(Person[] a, String name) throws IOException {
		File f = new File(name);
		if(!f.exists()) f.createNewFile();
		PrintWriter pw = new PrintWriter(f);
		pw.println("Nokia");
		for(int i = 0; i < a.length; i++) {
			pw.println(a[i].getName());
			pw.println(a[i].getCC());
			pw.println(a[i].getBirthDate().toString());				
			if(i != a.length-1)
				pw.println();
		}
		
		pw.close();
	}

	@Override
	public Person[] loadFile(File f) throws FileNotFoundException {
		Scanner sf = new Scanner(f);
		sf.nextLine();  //ignore first line
		int size = 0;
		String line;
		while(sf.hasNextLine()) {
			line = sf.nextLine();
			if(line.length() != 0)
				size++;
		}
		sf.close();
		Person[] people = new Person[size/3];
		
		sf = new Scanner(f);
		sf.nextLine();  //ignore first line
		
		for(int i = 0; i < people.length; i++) {
			people[i] = new Person(sf.nextLine(),Integer.parseInt(sf.nextLine()),new Date(sf.nextLine()));
			if(i != people.length-1)
				sf.nextLine();
		}		
		sf.close();
		return people;
	}
	
}
