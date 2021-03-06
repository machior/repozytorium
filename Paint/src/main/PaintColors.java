package main;

import java.awt.Color;

public enum PaintColors 
{
	CZARNY(0, 0, 0), BIAŁY(255, 255, 255),
	CZERWONY(255, 0, 0), ZIELONY(0, 255, 0), NIEBIESKI(0, 0, 255),
	ŻÓŁTY(255, 255, 0), RÓŻOWY(255, 0, 255), SELEDYNOWY(0, 255, 255);
	
	public final int r;
	public final int g;
	public final int b;
	
	private PaintColors(final int r, final int g, final int b) {
		this.r=r;
		this.g=g;
		this.b=b;
	}
	
	public Color getColor(){
		return new Color(r, g, b);
	}
	
	@Override
	public String toString() {
		return "[" + r + ", " + g + ", " + b + "]";
	}
}
