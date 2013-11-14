import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class Main {

	public static void main(String[] args) throws Exception {

		long startTime = System.nanoTime();
		problem3();
		long endTime = System.nanoTime();

		long duration = endTime - startTime;
		double timeins = duration;
		timeins /= 1000000000;

		System.out.println("time needed: " + timeins + "s");
	}

	private static void problem1() {
		int result = 0;
		for (int i = 3; i < 1000; i++) {
			if (i % 3 == 0)
				result += i;
			else if (i % 5 == 0)
				result += i;

		}
		System.out.println(result);
	}

	private static void problem2() {

		long result = 2;
		int a = 1;
		int b = 2;
		int c = 3;
		int tmp;

		while (c < 4000000) {
			tmp = b;

			b = c;
			a = tmp;
			c = a + b;
			if (c % 2 == 0) {
				result += c;
			}

		}
		System.out.println(result);
	}

	private static void problem3() {
		long number = 600851475143L;
		for (long l = number / 2; l > 3; l--) {
			if (number % l == 0) {
				if (checkPrime(l)) {
					System.out.println(l);
					break;
				}
			}
		}
	}

	private static boolean checkPrime(long l) {
		for (long k = 2; k <= l / 2; k++) {
			if (l % k == 0)
				return false;
		}
		return true;
	}

	private static void problem4() {
		int a;
		int b;
		long result;
		long max = 0;

		for (a = 999; a >= 111; a--) {
			for (b = 999; b >= 111; b--) {
				result = a * b;
				if (result < max)
					break;
				if (checkResult(result)) {
					if (max < result)
						max = result;
				}

			}
		}
		System.out.println(max);
	}

	private static boolean checkResult(long result) {
		// checking for palindromeness
		long revResult = 0;
		long tmp = result;
		while (tmp != 0) {
			revResult = revResult * 10 + tmp % 10;
			tmp /= 10;
		}
		if (revResult == result)
			return true;
		return false;
	}

	private static void problem5() {
		boolean found = false;
		int i = 2520;
		while (!found) {
			i++;
			for (int j = 1; j <= 20; j++) {
				if (i % j != 0) // kommt nicht in frage
					break;
				else if (j == 20)
					found = true;
			}
		}
		System.out.println(i);
	}

	private static void problem6() {
		long ressingle = 0;
		long resall = 0;
		for (int i = 1; i <= 100; i++) {
			ressingle += Math.pow(i, 2);
			resall += i;
		}
		resall = (long) Math.pow(resall, 2); // resall =
		// (long) Math.pow((50.5 * 100),2);

		System.out.println(resall + " " + ressingle + " "
				+ (resall - ressingle));
	}

	private static void problem7() {
		long lastPrime = 0;
		long iterator = 1;
		int counter = 0;

		while (iterator != -1) {
			if (checkPrime(++iterator)) {
				lastPrime = iterator;
				counter++;
			}
			if (counter == 10001)
				iterator = -1;
		}

		System.out.println(lastPrime);
	}

	private static void problem8() {
		String sNumber = new String(
				"7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450");
		int numbers[] = new int[5];

		long max = 0;
		long tmp = 0;

		for (int i = 0; i < sNumber.length() - 4; i++) {
			for (int j = 0; j < 5; j++) {
				numbers[j] = Integer.parseInt(sNumber.substring(i + j, i + j
						+ 1));
			}
			tmp = numbers[0] * numbers[1] * numbers[2] * numbers[3]
					* numbers[4];
			if (tmp > max) {
				max = tmp;
			}
		}

		System.out.println(max);

	}

	private static void problem9() {
		double c;

		for (int a = 1; a < 1000; a++) {
			for (int b = 1; b < 1000; b++) {
				c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
				if ((c % 1 == 0) && (a + b + c == 1000))
					System.out.println(a + " " + b + " " + c + " "
							+ (a * b * c));
			}
		}
	}

	private static void problem10() {
		long sum = 0;
		for (long l = 2; l < 10; l++) {
			if (checkPrime(l)) {
				sum += l;
				// System.out.println(l + " " + sum);

			}
			if (l % 20000 == 0)
				System.out.println(l / 20000 + "%");
		}
		System.out.println(sum);
	}

	private static void problem11() {
		int field[][] = {
				{ 8, 02, 22, 97, 38, 15, 00, 40, 00, 75, 04, 05, 07, 78, 52,
						12, 50, 77, 91, 8 },
				{ 49, 49, 99, 40, 17, 81, 18, 57, 60, 87, 17, 40, 98, 43, 69,
						48, 04, 56, 62, 00 },
				{ 81, 49, 31, 73, 55, 79, 14, 29, 93, 71, 40, 67, 53, 88, 30,
						03, 49, 13, 36, 65 },
				{ 52, 70, 95, 23, 04, 60, 11, 42, 69, 24, 68, 56, 01, 32, 56,
						71, 37, 02, 36, 91 },
				{ 22, 31, 16, 71, 51, 67, 63, 89, 41, 92, 36, 54, 22, 40, 40,
						28, 66, 33, 13, 80 },
				{ 24, 47, 32, 60, 99, 03, 45, 02, 44, 75, 33, 53, 78, 36, 84,
						20, 35, 17, 12, 50 },
				{ 32, 98, 81, 28, 64, 23, 67, 10, 26, 38, 40, 67, 59, 54, 70,
						66, 18, 38, 64, 70 },
				{ 67, 26, 20, 68, 02, 62, 12, 20, 95, 63, 94, 39, 63, 8, 40,
						91, 66, 49, 94, 21 },
				{ 24, 55, 58, 05, 66, 73, 99, 26, 97, 17, 78, 78, 96, 83, 14,
						88, 34, 89, 63, 72 },
				{ 21, 36, 23, 9, 75, 00, 76, 44, 20, 45, 35, 14, 00, 61, 33,
						97, 34, 31, 33, 95 },
				{ 78, 17, 53, 28, 22, 75, 31, 67, 15, 94, 03, 80, 04, 62, 16,
						14, 9, 53, 56, 92 },
				{ 16, 39, 05, 42, 96, 35, 31, 47, 55, 58, 88, 24, 00, 17, 54,
						24, 36, 29, 85, 57 },
				{ 86, 56, 00, 48, 35, 71, 89, 07, 05, 44, 44, 37, 44, 60, 21,
						58, 51, 54, 17, 58 },
				{ 19, 80, 81, 68, 05, 94, 47, 69, 28, 73, 92, 13, 86, 52, 17,
						77, 04, 89, 55, 40 },
				{ 04, 52, 8, 83, 97, 35, 99, 16, 07, 97, 57, 32, 16, 26, 26,
						79, 33, 27, 98, 66 },
				{ 88, 36, 68, 87, 57, 62, 20, 72, 03, 46, 33, 67, 46, 55, 12,
						32, 63, 93, 53, 69 },
				{ 04, 42, 16, 73, 38, 25, 39, 11, 24, 94, 72, 18, 8, 46, 29,
						32, 40, 62, 76, 36 },
				{ 20, 69, 36, 41, 72, 30, 23, 88, 34, 62, 99, 69, 82, 67, 59,
						85, 74, 04, 36, 16 },
				{ 20, 73, 35, 29, 78, 31, 90, 01, 74, 31, 49, 71, 48, 86, 81,
						16, 23, 57, 05, 54 },
				{ 01, 70, 54, 71, 83, 51, 54, 69, 16, 92, 33, 48, 61, 43, 52,
						01, 89, 19, 67, 48 }, };

		int max = 0;
		int tmp = 0;
		int vX = 0;
		int vY = 0;
		String dir = new String();

		for (int y = 0; y < field.length; y++) {
			for (int x = 0; x < field[0].length; x++) {
				// von gerade nach unten gegen den uhrzeigersinn
				// boundary checking sehr wichtig ;)

				// links unten
				if (y < field.length - 4 && x >= 3) {
					tmp = field[y][x] * field[y + 1][x - 1]
							* field[y + 2][x - 2] * field[y + 3][x - 3];
					if (tmp > max) {
						max = tmp;
						vX = x;
						vY = y;
						dir = "links unten";
					}
					tmp = x;
				}

				// gerade nach unten
				if (y < field.length - 4) {
					tmp = field[y][x] * field[y + 1][x] * field[y + 2][x]
							* field[y + 3][x];
					if (tmp > max) {
						max = tmp;
						vX = x;
						vY = y;
						dir = "unten";
					}
				}

				// rechts unten
				if (y < field.length - 4 && x < field[0].length - 4) {
					tmp = field[y][x] * field[y + 1][x + 1]
							* field[y + 2][x + 2] * field[y + 3][x + 3];
					if (tmp > max) {
						max = tmp;
						vX = x;
						vY = y;
						dir = "rechts unten";
					}
					tmp = x;
				}

				// rechts
				if (x < field[0].length - 4) {
					tmp = field[y][x] * field[y][x + 1] * field[y][x + 2]
							* field[y][x + 3];
					if (tmp > max) {
						max = tmp;
						vX = x;
						vY = y;
						dir = "rechts";
					}
				}

			}
		}

		System.out.println(max + " at " + vX + "," + vY + " in " + dir);
	}

	private static void problem12() {
		boolean found = false;
		long iterator = 1;
		long value = 0;
		while (!found) {
			value = nthTriangleNumber(iterator);
			if (factoramount(value) > 500)
				found = true;
		}
		System.out.println(value);
	}

	private static int factoramount(long input) {
		int resValue = 1; // da die zahl selbst sonst nicht mitgez�hlt wird

		for (long l = 1; l <= input / 2; l++) {
			if (input % l == 0)
				resValue++;
		}

		return resValue;
	}

	private static long nthTriangleNumber(long input) {
		return ((input * (input + 1)) / 2);
	}

	private static void problem13() throws FileNotFoundException {
		Vector<String> lines = parseFile("problem13.txt");

		long sum = 0;

		for (String myStr : lines) {
			sum += Long.valueOf(myStr.substring(0, 14));
		}

		System.out.println(String.valueOf(sum).substring(0, 10));
	}

	private static Vector<String> parseFile(String filename)
			throws FileNotFoundException {
		File file = new File(filename);
		Scanner input = new Scanner(file);
		Vector<String> myLines = new Vector<String>();

		while (input.hasNext()) {
			// or to process line by line
			String nextLine = input.nextLine();
			myLines.add(nextLine);
		}

		input.close();
		return myLines;
	}

	private static void problem14() {
		int max = 0;
		int tmp = 0;
		long value = 0;

		for (long i = 1; i < 1000000; i++) {
			tmp = getCollatzLength(i);
			if (tmp > max) {
				max = tmp;
				value = i;
			}
		}
		System.out.println(max + " " + value);
	}

	private static int getCollatzLength(long input) {
		int length = 1;
		while (input != 1) {
			if (input % 2 == 0)
				input /= 2;
			else
				input = 3 * input + 1;
			length++;
		}
		return length;
	}

	/*
	 * public List<Output> processInputs(List<Input> inputs) throws
	 * InterruptedException, ExecutionException {
	 * 
	 * int threads = Runtime.getRuntime().availableProcessors(); ExecutorService
	 * service = Executors.newFixedThreadPool(threads);
	 * 
	 * List<Future<Output>> futures = new ArrayList<Future<Output>>(); for
	 * (final Input input : inputs) { Callable<Output> callable = new
	 * Callable<Output>() { public Output call() throws Exception { Output
	 * output = new Output(); // process your input here and compute the output
	 * return output; } }; futures.add(service.submit(callable)); }
	 * 
	 * service.shutdown();
	 * 
	 * List<Output> outputs = new ArrayList<Output>(); for (Future<Output>
	 * future : futures) { outputs.add(future.get()); } return outputs; }
	 */

	private static void problem15() {

	}

}