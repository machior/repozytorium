package main;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public enum PaintOptions {
	
	FreeFormSelect(ImageIO.read(new File("icons/Free-Form Select.bmp"))),
	Select(ImageIO.read(new File("icons/Select.bmp")));
	
	private PaintOptions(BufferedImage image) {
		
	}
}
