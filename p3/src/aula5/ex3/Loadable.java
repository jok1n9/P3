package aula5.ex3;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import aula3.ex1.Person;

public interface Loadable {
	
	void saveFile(Person[] a, String f) throws FileNotFoundException, IOException;	
	Person[] loadFile(File f) throws FileNotFoundException;
}
