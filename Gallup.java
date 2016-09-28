import java.util.*;

public class Gallup {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		for (int a = 0; a < cases; a++) {
			int questions = sc.nextInt();
			int[] min = new int[questions];
			int[] mod = new int[questions];

			int minCalls = 0;

			for (int b = 0; b < questions; b++) {
				mod[b] = sc.nextInt();
				min[b] = sc.nextInt();
				if (min[b] * mod[b] > minCalls) 
					minCalls = min[b] * mod[b];
			}

			int questionsAsked = 0;

			for (int b = 0; b < questions; b++) {
				questionsAsked += (minCalls / mod[b]);
			}

			System.out.println(questionsAsked);
		}
	}
}
