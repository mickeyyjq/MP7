import java.util.Scanner;
public class BallVolumeCalculator {
	public static void main (String args[]) {

		Scanner reader = new Scanner(System.in);

		System.out.println("Enter a number of dimensions(integer): ");
		int n = reader.nextInt();

		System.out.println("Enter a number of points to generate(integer): ");
		double points = (double) reader.nextInt();

		while (points < 1) {
			System.out.println("ERROR: Invalid input for points.");
			System.out.println("Enter a number of points to generate(integer): ");
			points = (double) reader.nextInt();
		}
		System.out.println("Enter a density if mass is wanted, otherwise enter 0: ");
		double density = reader.nextDouble();

		while (density < 0) {
			System.out.println("ERROR: Invalid input for density.");
			System.out.println("Enter a density if mass is wanted, otherwise enter 0: ");
			density = reader.nextDouble();
		}
		reader.close();

		if (n < 1) {
			System.out.println("The volume of a ball with " + n + " dimensions does not exist.");
		} else if (n == 1) {
			System.out.println("The ball exists as a point with no volume.");
		} else if (n == 2) {
			System.out.println("The ball has an area of: " + Calculator(n,points,density) + " m^2");
		} else {
			System.out.println("The volume of the " + n + "th dimensional ball is : " + Calculator(n,points,density)
			+ " m^" + n);
			if (Calculator(n,points,density) == 0.0) {
				System.out.println("The dimension is too high for a unit volume to exist.");
			}
			if (density > 0 ) {
				System.out.println("The mass of the " + n + "th dimensional ball with density " + density
						+ " is: " + Calculator(n,points,density) * density);
			} else {
				System.out.println("The mass was not calculated.");
			}
		}
	}

	public static double Calculator(final int n,final double points,final double density) {
		double cubeVolume = Math.pow(2, n);
		double insideCount = 0;
		double calculatedVolume;

		for (int i = 0; i < points; i++) {
			double squared_sum = 0.0;
			double[] myArray = new double[n];
			for (int j = 0; j < n; j++) {
				myArray[j] = 2 * (double)(Math.random() - 0.5);
				squared_sum = squared_sum + Math.pow(myArray[j], 2);
			}

			if (squared_sum < 1) {
				insideCount++;
			}
		}

		calculatedVolume = (double) (cubeVolume * (double)(insideCount / points));	
		return calculatedVolume;

	}
}

