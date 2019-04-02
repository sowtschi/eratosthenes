package tools;

import java.util.ArrayList;

public class PrimeCalculator {
	
	private final static double NUMBEROFNUMBERS=100000;
	
	private static ArrayList<Double> numbers = new ArrayList<Double>();

	public static void main(String[] args) {
		fillNumbers(NUMBEROFNUMBERS);
		calcPrimeNumbers();
		writeNumbers();

	}

	private static void calcPrimeNumbers() {
		double multiple=0;
		
		for (int i=0; numbers.size()>i;i++) {
			double currentNumber = numbers.get(i);
			if (currentNumber >= Math.sqrt(NUMBEROFNUMBERS)) {
				break;
			}
			
			for (int j=2; j+1*currentNumber<NUMBEROFNUMBERS; j++ ) {
				multiple = j*currentNumber;
				for (int k=0; numbers.size()>k; k++) {
					if (numbers.get(k)==multiple) {
						numbers.remove(k);
					}
				}
			}
			multiple=0;
		}
	}

	private static void fillNumbers(double numberOfValues) {
		for (double i=2; i<=numberOfValues; i++) {
			numbers.add(i);
		}
	}
	
	private static void writeNumbers() {
		for (int i=0; i<numbers.size(); i++) {
			System.out.print(numbers.get(i));
			if (i != numbers.size()-1) {
				System.out.print(", ");
			}
			if (i != 0 && i%5==0) {
				System.out.println();
			}
		}
	}

}
