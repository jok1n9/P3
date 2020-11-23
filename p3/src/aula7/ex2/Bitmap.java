package aula7.ex2;

import java.io.*;

public class Bitmap {
	BitmapFileHeader bitmapFileHeader;
	BitmapInfoHeader bitmapInfoHeader;
	byte[] rgbQuad; // color pallete – opcional (ver abaixo)
	byte[] data; // pixel data
	private Pixel[][] pixelArray;
	
	public Bitmap(String path) throws IOException{
		RandomAccessFile fich= new RandomAccessFile(path, "r");
		//bitmapfileheader
		short type= Short.reverseBytes(fich.readShort()); // must be 'BM' to declare a bmp-file
		int size= Integer.reverseBytes(fich.readInt()); // specifies the size of the file in bytes
		fich.readShort(); // must always be set to zero
		fich.readShort(); // must always be set to zero
		int offBits= Integer.reverseBytes(fich.readInt());; 
		this.bitmapFileHeader = new BitmapFileHeader(type, size, offBits);
	
	
		//bitmapinfoheader
		int sizeHead= Integer.reverseBytes(fich.readInt());  // the size of this header (40 bytes)
		int width= Integer.reverseBytes(fich.readInt());  // the bitmap width in pixels
		int height= Integer.reverseBytes(fich.readInt());  // the bitmap height in pixels
		short planes=Short.reverseBytes(fich.readShort()); ; // the number of color planes being used. Must be set to 1
		short bitCount=Short.reverseBytes(fich.readShort());  // the number of bits per pixel (color depth) - 1, 4, 8, 16, 24, 32
		int compression= Integer.reverseBytes(fich.readInt()); // the compression method being used
		int sizeImage= Integer.reverseBytes(fich.readInt());  // the image size. This is the size of the raw bitmap data
		int xPixelsPerMeter= Integer.reverseBytes(fich.readInt());  // the horizontal resolution of the image (pixel per meter)
		int yPixelsPerMeter= Integer.reverseBytes(fich.readInt());  // the vertical resolution of the image (pixel per meter)
		int clrUsed= Integer.reverseBytes(fich.readInt());  // the number of colors in the color palette,
		 // or 0 to default to 2n
		int clrImportant= Integer.reverseBytes(fich.readInt());  // the number of important colors used,
		this.bitmapInfoHeader = new BitmapInfoHeader(sizeHead, width, height, planes, bitCount, compression, sizeImage, 
				xPixelsPerMeter, yPixelsPerMeter, clrUsed, clrImportant);
		//problem here, search for solution
		int datalength= Math.abs(bitmapInfoHeader.getBitCount() / 8 * bitmapInfoHeader.getHeight() * bitmapInfoHeader.getWidth());
		byte[] pixeldata= new byte[datalength];
		fich.read(pixeldata, 0, datalength);
		this.data= pixeldata;
		this.rgbQuad= new byte[0];
		fich.close();
	}
	
	public BitmapFileHeader getBitmapFileHeader() {
		return bitmapFileHeader;
	}
	public BitmapInfoHeader getBitmapInfoHeader() {
		return bitmapInfoHeader;
	}
	public byte[] getRgbQuad() {
		return rgbQuad;
	}
	public byte[] getData() {
		return data;
	}
	public Pixel[][] getPixelArray(){
		return pixelArray;
	}
	public static byte[] pixelToByteArray(Pixel[][] pixelArray) 
	{
		byte[] byteArray = new byte[pixelArray.length * pixelArray[0].length * 3];
		
		int i = 0;
		for(int y = 0; y < pixelArray.length; y++) 
		{
			for(int x = 0; x < pixelArray[0].length; x++) 
			{
				byteArray[i++] = pixelArray[y][x].b;
				byteArray[i++] = pixelArray[y][x].g;
				byteArray[i++] = pixelArray[y][x].r;
			}
		}
		return byteArray;
	}

	public Pixel[][] byteToPixelArray(int width, int height)
	{		
		Pixel[][] pixels = new Pixel[height][width];
		
		int k = 0;
		
		for(int y = 0; y < pixels.length; y++) 
		{
			for(int x = 0; x < pixels[0].length; x++) 
			{
				pixels[y][x] = new Pixel(this.data[k++],this.data[k++],this.data[k++]);
			}
		}
		
		return pixels;
	}
	
	public void resize()
	{
		this.getBitmapInfoHeader().setWidth((int) Math.round(this.getBitmapInfoHeader().getWidth() * 0.5));
		this.getBitmapInfoHeader().setHeight((int) Math.round(this.getBitmapInfoHeader().getHeight() * 0.5));
		
		
		Pixel[][] newPixelArray = new Pixel[this.pixelArray.length/2][pixelArray[0].length/2];
		
		int pixelsX = 0;
        int pixelsY = 0;
        
		for(int y = 0; y < pixelArray.length/2; y++) 
		{
			for(int x = 0; x < pixelArray[0].length/2; x++) 
			{
				newPixelArray[y][x] = pixelArray[pixelsY][pixelsX];
				pixelsX += 2;
			}
			pixelsX = 0;
			pixelsY += 2;
		}
		
		this.pixelArray = newPixelArray;
	}
	
	public Pixel[][] flipVertical()
	{
		Pixel[][] a = this.getPixelArray();
		Pixel[][] verticalFlippedPixelArray = new Pixel[this.getPixelArray().length][];
		int k = 0;
	    for (int i = a.length - 1; i >= 0; i--) 
	    {
	    	verticalFlippedPixelArray[k] = a[i];
	    	k++;
	    }
		
		return verticalFlippedPixelArray;
	}
	
	public Pixel[][] flipHorizontal()
	{
		Pixel[][] horizontalFlippedPixelArray = this.getPixelArray();
		
		for(int j = 0; j < horizontalFlippedPixelArray.length; j++)
		{
		    for(int i = 0; i < horizontalFlippedPixelArray[j].length / 2; i++) 
		    {
		        Pixel temp = horizontalFlippedPixelArray[j][i];
		        horizontalFlippedPixelArray[j][i] = horizontalFlippedPixelArray[j][horizontalFlippedPixelArray[j].length - i - 1];
		        horizontalFlippedPixelArray[j][horizontalFlippedPixelArray[j].length - i - 1] = temp;
		    }
		}
		return horizontalFlippedPixelArray;
	}
	
	public void setData(byte[] byteArray)
	{
		this.data = byteArray;
		this.pixelArray = this.byteToPixelArray(this.getBitmapInfoHeader().getWidth(), this.getBitmapInfoHeader().getHeight());
	}
	
	
	public void saveToRaw(String path) throws IOException
	{			
		if(!new File(path).exists()) new File(path).createNewFile();
		RandomAccessFile rawFile = new RandomAccessFile(path, "rw");
		rawFile.write(pixelToByteArray(this.pixelArray));
		rawFile.close();
	}
	
	public void saveToBmp(String path, Pixel[][] pixelArray) throws IOException
	{
		if(!new File(path).exists()) new File(path).createNewFile();
		RandomAccessFile bmpFile = new RandomAccessFile(path, "rw");
		
		//File Header
		bmpFile.writeShort(Short.reverseBytes(this.getBitmapFileHeader().getType()));
		bmpFile.writeInt(Integer.reverseBytes(this.getBitmapFileHeader().getSize()));
		bmpFile.writeShort(0);
		bmpFile.writeShort(0);
		bmpFile.writeInt(Integer.reverseBytes(this.getBitmapFileHeader().getOffBits()));
	
		//Info header
		bmpFile.writeInt(Integer.reverseBytes(this.getBitmapInfoHeader().getSize()));
		bmpFile.writeInt(Integer.reverseBytes(this.getBitmapInfoHeader().getWidth()));
		bmpFile.writeInt(Integer.reverseBytes(this.getBitmapInfoHeader().getHeight()));
		bmpFile.writeShort(Short.reverseBytes(this.getBitmapInfoHeader().getPlanes()));
		bmpFile.writeShort(Short.reverseBytes(this.getBitmapInfoHeader().getBitCount()));
		bmpFile.writeInt(Integer.reverseBytes(this.getBitmapInfoHeader().getCompression()));
		bmpFile.writeInt(Integer.reverseBytes(this.getBitmapInfoHeader().getSizeImage()));
		bmpFile.writeInt(Integer.reverseBytes(this.getBitmapInfoHeader().getxPelsPerMeter()));
		bmpFile.writeInt(Integer.reverseBytes(this.getBitmapInfoHeader().getyPelsPerMeter()));
		bmpFile.writeInt(Integer.reverseBytes(this.getBitmapInfoHeader().getClrUsed()));
		bmpFile.writeInt(Integer.reverseBytes(this.getBitmapInfoHeader().getClrImportant()));

		bmpFile.write(pixelToByteArray(pixelArray));
		bmpFile.close();
		
	}
}