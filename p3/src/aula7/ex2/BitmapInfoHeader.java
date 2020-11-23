package aula7.ex2;

public class BitmapInfoHeader {
		private int size; // the size of this header (40 bytes)
		private int width; // the bitmap width in pixels
		private int height; // the bitmap height in pixels
		private short planes; // the number of color planes being used. Must be set to 1
		private short bitCount; // the number of bits per pixel (color depth) - 1, 4, 8, 16, 24, 32
		private int compression; // the compression method being used
		private int sizeImage; // the image size. This is the size of the raw bitmap data
		private int xPelsPerMeter; // the horizontal resolution of the image (pixel per meter)
		private int yPelsPerMeter; // the vertical resolution of the image (pixel per meter)
		private int clrUsed; // the number of colors in the color palette,
		// or 0 to default to 2n
		private int clrImportant; // the number of important colors used,
				 // or 0 when every color is important 
	    public BitmapInfoHeader(int size, int width, int height, short planes, short bitCount, int compression,
				int sizeImage, int xPelsPerMeter, int yPelsPerMeter, int clrUsed, int clrImportant) 
	    {
			
			this.size = size;
			this.width = width;
			this.height = height;
			this.planes = planes;
			this.bitCount = bitCount;
			this.compression = compression;
			this.sizeImage = sizeImage;
			this.xPelsPerMeter = xPelsPerMeter;
			this.yPelsPerMeter = yPelsPerMeter;
			this.clrUsed = clrUsed;
			this.clrImportant = clrImportant;
		}
				
		public int getSize() {
			return size;
		}
		public int getWidth() {
			return width;
		}
		public int getHeight() {
			return height;
		}
		public short getPlanes() {
			return planes;
		}
		public short getBitCount() {
			return bitCount;
		}
		public int getCompression() {
			return compression;
		}
		public int getSizeImage() {
			return sizeImage;
		}
		public int getxPelsPerMeter() {
			return xPelsPerMeter;
		}
		public int getyPelsPerMeter() {
			return yPelsPerMeter;
		}
		public int getClrUsed() {
			return clrUsed;
		}
		public int getClrImportant() {
			return clrImportant;
		}
		
}
