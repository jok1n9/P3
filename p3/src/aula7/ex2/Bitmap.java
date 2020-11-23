package aula7.ex2;

import java.io.*;

public class Bitmap {
	BitmapFileHeader bitmapFileHeader;
	BitmapInfoHeader bitmapInfoHeader;
	byte[] rgbQuad; // color pallete – opcional (ver abaixo)
	byte[] data; // pixel data
	
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
		int xPelsPerMeter= Integer.reverseBytes(fich.readInt());  // the horizontal resolution of the image (pixel per meter)
		int yPelsPerMeter= Integer.reverseBytes(fich.readInt());  // the vertical resolution of the image (pixel per meter)
		int clrUsed= Integer.reverseBytes(fich.readInt());  // the number of colors in the color palette,
		 // or 0 to default to 2n
		int clrImportant= Integer.reverseBytes(fich.readInt());  // the number of important colors used,
		this.bitmapInfoHeader = new BitmapInfoHeader(sizeHead, width, height, planes, bitCount, compression, sizeImage, 
				xPelsPerMeter, yPelsPerMeter, clrUsed, clrImportant);
		
		int datalength= Math.abs(bitmapInfoHeader.getBitCount() / 8 * bitmapInfoHeader.getHeight() * bitmapInfoHeader.getWidth());
		byte[] pixeldata= new byte[datalength];
		fich.read(pixeldata, 0, datalength);
		this.data= pixeldata;
		this.rgbQuad= new byte[0];
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
	

}
