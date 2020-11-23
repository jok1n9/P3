package aula7.ex2;

public class Pixel {
	final byte r;
	final byte g;
	final byte b;
	
	Pixel(byte b, byte  g,byte r){
		this.b= b;
		this.g= g;
		this.r= r;
	}
	@Override
	public String toString() 
	{
		return "RGB("+(r & 0xff)+","+(g & 0xff)+","+(b & 0xff)+")";
	}
}
