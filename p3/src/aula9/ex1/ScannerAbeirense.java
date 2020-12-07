package aula9.ex1;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import java.util.Scanner;
public class ScannerAbeirense implements Iterator<String>, Closeable
{
	private Scanner scan;
	public ScannerAbeirense(File F) throws IOException
	{
		this.scan=new Scanner(F);
		
	}
	public ScannerAbeirense(InputStream input) 
	{
		this.scan= new Scanner(input);
	}
	public void close() throws IOException
	{
		scan.close();
	}
	public boolean hasNext() 
	{
		return scan.hasNext();
	}
	public String next() 
	{
		return scan.next().replaceAll("v", "b").replaceAll("V", "B");
		
	}
	public String nextLine() 
	{
		return scan.nextLine().replaceAll("v", "b").replaceAll("V", "B");
	}
}
