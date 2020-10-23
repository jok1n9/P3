package aula2;
import java.util.*;
import java.io.*;

public class ex2 {	

	public static void main(String[] args) throws IOException{
		String filename;
		Scanner sc = new Scanner(System.in);
		System.out.print("Insira o nome do ficheiro: ");
		filename = sc.nextLine();
		sc.close();
		LettersSoup sp = new LettersSoup(filename);
		LinkedList<SoupWord> result = new LinkedList<SoupWord>();
		
		
		for(int i = 0; i < sp.getWords().size(); i++) {
			SoupWord r = find(sp.getWords().get(i),sp.getMatrix(),sp.getWidth());
			result.add(r);			
		}		
		for(int j = 0; j < result.size(); j++) {
			System.out.print(result.get(j).toString());
		}
		
	}
	
	public static SoupWord find(String word, char[][] a, int w)
	{
		word = word.toUpperCase();
		
	    for(int i=0; i<w; i++)
	    {
	        for(int j=0; j<w; j++)
	        {//percorre array 
	            
	            if(a[i][j]== word.charAt(0))//palavras tem de ter mais que uma letra 
	            {//encontra algo igual a primeira letra de uma palavra
	            	
	                int x=i+1;
	                int y=j+1;
	                if(word.length()<w-j-1) 
	                {
		                if(a[i][j+1]== word.charAt(1))
		                {
		                		
		                		int l=j+2;              
		                        for(int k= 2  ; k<word.length(); k++)
		                        {
		               
		                            if(word.charAt(k) != a[i][l])
		                            {
		                                k=word.length();
		                            }
		                            if(word.length()-1==k)
		                            {	                            	
		                                return new SoupWord(word,x, y, "right");
	
		                            }
		                            
		                            l++;
		                        }
		                }
	                }

	                if(word.length()<w-j+1 && i>word.length()-2) 
	                {
		                if(a[i-1][j+1]== word.charAt(1))
		                {
		                        
		                        int m=i-2;
		                        int l=j+2;
		                        for(int k= 2  ; k<word.length(); k++)
		                        {
		                            
		                            if(word.charAt(k) != a[m][l])
		                            {
		                                k=word.length();
		                            }
		                            if(word.length()-1==k)
		                            {
		                                return new SoupWord(word,x, y, "upright");
	
		                            }
		                            m--;
		                            l++;
		                        }
		                }
	                }
	                if(word.length()<w-j+1 && word.length()<w-i+1)
	                {
		                if(a[i+1][j+1]== word.charAt(1)) 
		                {
		                        int m=i+2;
		                        int l=j+2;
		                        for(int k= 2  ; k<word.length(); k++)
		                        {
		                            
		                            if(word.charAt(k)!= a[m][l])
		                            {
		                                k=word.length();
		                            }
		                            if(word.length()-1==k)
		                            {
		                                return new SoupWord(word,x, y, "downright");
	
		                            }
		                            m++;
		                            l++;
		                        }
		                }
	            	}
	                if(j>word.length()-2&&i>word.length()-2) 
	                {
		                if(a[i-1][j-1]== word.charAt(1)) 
		                {		
		                        int m=i-2;
		                        int l=j-2;
		                        for(int k= 2  ; k<word.length(); k++)
		                        {
		                            
		                            if(word.charAt(k)!= a[m][l])
		                            {
		                                k=word.length();
		                            }
		                            if(word.length()-1==k)
		                            {
		                                return new SoupWord(word,x, y, "upleft");
	
		                            }
		                            m--;
		                            l--;
		                        }
		                }
	                }
	                if(j>word.length()-2 && word.length()<w-i+1) 
	                {
			                if(a[i+1][j-1]== word.charAt(1)) 
			                {		
			                        int m=i+2;
			                        int l=j-2;
			                        for(int k= 2  ; k<word.length(); k++)
			                        {
			                            
			                            if(word.charAt(k)!= a[m][l])
			                            {
			                                k=word.length();
			                            }
			                            if(word.length()-1==k)
			                            {
			                                return new SoupWord(word,x, y, "downleft");
		
			                            }
			                            m++;
			                            l--;
			                        }
			                }
	                }
	                if(j>word.length()-2) 
	                {
		                if(a[i][j-1]== word.charAt(1)) 
		                {        
		                        int l=j-2;
		                        for(int k= 2  ; k<word.length(); k++)
		                        {
		                            
		                            if(word.charAt(k)!= a[i][l])
		                            {
		                                k=word.length();
		                            }
		                            if(word.length()-1==k)
		                            {
		                                return new SoupWord(word,x, y, "left");
	
		                            }
		                            l--;
		                        }
		                }
	                }
	                if(i<w-word.length()+1) 
	                {
		                if(a[i+1][j]== word.charAt(1))
		                {		
		                        int m=i+2;
		                    
		                        for(int k= 2  ; k<word.length(); k++)
		                        {
		                            
		                            if(word.charAt(k)!= a[m][j])
		                            {
		                                k=word.length();
		                            }
		                            if(word.length()-1==k)
		                            {
		                                return new SoupWord(word,x, y, "down");
	
		                            }
		                            m++;
		                            
		                        }
		                }
	                }
	                if( i>word.length()-2) 
	                {
		                if(a[i-1][j]== word.charAt(1)) 
		                {		
		                        int m=i-2;
		                        
		                        for(int k= 2  ; k<word.length(); k++)
		                        {
		                            
		                            if(word.charAt(k)!= a[m][j])
		                            {
		                                k=word.length();
		                            }
		                            if(word.length()-1==k)
		                            {
		                                return new SoupWord(word,x, y, "up");
	
		                            }
		                            m--;
		                           
		                        }
		                }
	                }
	            }
	                            
	        } 
	    }
	    return null; //sould never happen
	}

}