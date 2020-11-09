package aula5.ex3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import aula3.ex1.Date;
import aula3.ex1.Person;

public class PersonManager {
	
	static Person[] people = new Person[0];
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException {		
		
		int option;
		do {
			System.out.println("\nMenu:");
			System.out.println("1 - Add Person");
			System.out.println("2 - Remove Person");
			System.out.println("3 - Display List");
			System.out.println("4 - Sort People by Name");
			System.out.println("5 - Sort People by CC");
			System.out.println("6 - Load from file");
			System.out.println("7 - Save to file");
			System.out.println("8 - Exit");
			System.out.print("Option -> ");			
			option = sc.nextInt();
			sc.nextLine();
			
			switch(option) {
				case 1:
					addPerson();
					break;
				case 2:
					removePerson();
					break;
				case 3:
					displayList();
					break;
				case 4:
					sortByName();
					break;
				case 5:
					sortByCC();
					break;
				case 6:
					loadFile();
					break;
				case 7:
					saveFile();
					break;
				default:
					break;
			}
			
		}while(option != 8);
		System.out.println("Program terminated");		
	}
	
	private static void addPerson() {
		String nome, date;
		int cc;		
		System.out.print("Name: ");
		nome = sc.nextLine();
		System.out.print("CC: ");
		cc = Integer.parseInt(sc.nextLine());
		System.out.println("Date of Birth: ");
		date = sc.nextLine();		
		if(indexOf(cc) == -1) {
			Person[] arr = new Person[people.length+1];		
			System.arraycopy(people, 0, arr, 0, people.length);
			people = new Person[people.length+1];
			Person p = new Person(nome,cc,new Date(date));
			arr[arr.length-1] = p;		
			System.arraycopy(arr, 0, people, 0, arr.length);
			System.out.println("Person added to List");
		}
		else
			System.out.println("The person with this CC is already in the List");		
	}
	
	private static void removePerson() {		
		System.out.print("Incert the CC of the person to be removed: ");
		int cc = Integer.parseInt(sc.nextLine());		
		int index = indexOf(cc);
		if(index != -1) {
			Person[] copy = new Person[people.length];
			System.arraycopy(people, 0, copy, 0, people.length);
			people = new Person[people.length-1];	
			System.arraycopy(copy, 0, people, 0, index);
			System.arraycopy(copy, index+1, people, index , copy.length-index-1);
			System.out.println("Person removed from List");
		}
		else
			System.out.println("The person with this CC is not in the List");		
	}
	
	private static void displayList() {		
		for(int i = 0; i < people.length; i++) 
			System.out.println(people[i].toString());		
	}
	
	private static void sortByName() {
		int cc;
		String nome;
		Date date;
		boolean trade = true;
		while(trade) {
			trade = false;
			for(int i = 0; i<people.length-1; i++) {
				if(people[i].getName().compareToIgnoreCase(people[i+1].getName()) > 0) {					
					nome = people[i].getName();
					cc = people[i].getCC();
					date = people[i].getBirthDate();					
					people[i].setName(people[i+1].getName());
					people[i].setCC(people[i+1].getCC());
					people[i].setBirthDate(people[i+1].getBirthDate());					
					people[i+1].setName(nome);
					people[i+1].setCC(cc);
					people[i+1].setBirthDate(date);
					trade = true;
				}
			}
		}
	}
	
	private static void sortByCC() {
		int cc;
		String nome;
		Date date;
		boolean trade = true;
		while(trade) {
			trade = false;
			for(int i = 0; i<people.length-1; i++) {
				if(people[i].getCC() > people[i+1].getCC()) {					
					nome = people[i].getName();
					cc = people[i].getCC();
					date = people[i].getBirthDate();					
					people[i].setName(people[i+1].getName());
					people[i].setCC(people[i+1].getCC());
					people[i].setBirthDate(people[i+1].getBirthDate());					
					people[i+1].setName(nome);
					people[i+1].setCC(cc);
					people[i+1].setBirthDate(date);
					trade = true;
				}
			}
		}
	}
	
	private static void loadFile() throws FileNotFoundException {		
		System.out.print("File name: ");
		String fname = sc.nextLine();
		File f = new File(fname);		
		Scanner fr = new Scanner(f);
		String format = fr.nextLine();
		fr.close();
		
		Loadable ld = null;
		
		switch(format) {
			case "Nokia":
				ld = new Nokia();
				break;
			case "vCard":
				ld = new VCard();
				break;
			case "CSV":
				ld = new Csv();
				break;
			default:
				System.out.println("Invalid format");
				break;				
		}
		Person[] load = ld.loadFile(f);
		people = new Person[load.length];
		System.arraycopy(load, 0, people, 0, load.length);			
	}
	
	private static void saveFile() throws IOException {		
		System.out.print("File name: ");
		String fname = sc.nextLine();
		System.out.print("Format: ");
		String format = sc.nextLine();		
		
		Loadable ld = null;
		
		switch(format) {
		case "Nokia":
			ld = new Nokia();
			break;
		case "vCard":
			ld = new VCard();
			break;
		case "CSV":
			ld = new Csv();
			break;
		default:
			System.out.println("Invalid format");
			break;
		}
		ld.saveFile(people, fname);		
	}
	
	private static int indexOf(int cc) {		
		for(int i = 0; i < people.length; i++) {
			if(people[i].getCC() == cc) 
				return i;
		}
		return -1;
	}

}
