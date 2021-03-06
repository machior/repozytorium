package pl.patrykkobielak;

import java.util.Random;

import javax.swing.JLabel;

public class NeuronTest 
{
	public static void main(String[] args) 
	{
		NeuralCell cell = new NeuralCell()
		{
			@Override
			public double finalizeData(double membranePotential) 
			{
				if(membranePotential<0)	return -1;
				if(membranePotential>0)	return 1;
				return 0;
			}
		};
		
		cell.addInput(2);
		
		Random random = new Random();
		double rx = random.nextDouble();
		double ry = random.nextDouble();
		cell.setInputWeight(0, rx);
		cell.setInputWeight(1, ry);
		
		JLabel x_weight = new JLabel(Double.toString(rx));
		JLabel y_weight = new JLabel(Double.toString(ry));
	}
}
