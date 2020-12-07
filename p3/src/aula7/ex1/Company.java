package aula7.ex1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import java.util.LinkedList;

public class Company {
	
	private String init;
	private String name;
	
	public Company(String initials,String n) {
		this.init = initials;
		this.name = n;
	}

	public Company(Company c) {
		this.init = c.getInitials();
		this.name = c.getName();
	}

	public String getInitials() {
		return init;
	}

	public void setInitials(String init) {
		this.init = init;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public boolean equals(Company c) {
		return this.getName().equals(c.getName());		
	}
	
	public static LinkedList<Company> loadFromFile(String path) throws IOException {
		List<String> lines = Files.readAllLines(Paths.get(path));
		lines.remove(0);
		LinkedList<Company> companies = new LinkedList<Company>();
		String[] data;
		for(String line : lines) {
			data = line.split("\t");
			companies.add(new Company(data[0], data[1]));
		}
		return companies;
	}
	
	public static Company getFromList(String name, LinkedList<Company> companies) {
		for(Company c : companies) {			
			if(name.indexOf(c.getInitials()) != -1)				
				return c;
		}
		return null;
	}
	
	
	
	@Override
	public String toString() {
		return this.name;
	}
	
	
	
	

}
