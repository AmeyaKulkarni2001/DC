import java.util.*;

public class LamportLogicalClock {
	public static void main(String args[]) {

		int p;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the number of processes");
		p = s.nextInt();

		int e[] = new int[p];
		System.out.println("Enter the number of events in each process");
		for (int i = 0; i < p; i++) {
			e[i] = s.nextInt();
		}

		int highest;
		System.out.println("Enter the highest number of events");
		highest = s.nextInt();

		System.out.println("Enter the number of relationships");
		int r;
		r = s.nextInt();

		int originp[] = new int[r];
		int origine[] = new int[r];
		int terminatorp[] = new int[r];
		int terminatore[] = new int[r];

		System.out.println("Enter the relationships in order,eg;1 2 , 3 1");
		for (int i = 0; i < r; i++) {
			System.out.println("Enter the process ");
			originp[i] = s.nextInt();
			System.out.println("Enter the event ");
			origine[i] = s.nextInt();
			System.out.println("is related to");
			System.out.println("Enter the process ");
			terminatorp[i] = s.nextInt();
			System.out.println("Enter the event ");
			terminatore[i] = s.nextInt();
		}

		int timestamp[][] = new int[p][];
		for (int i = 0; i < p; i++) {
			timestamp[i] = new int[e[i]];

		}

		for (int i = 0; i < p; i++) {
			for (int j = 0; j < e[i]; j++) {
				timestamp[i][j]++;
			}
		}

		for (int g = 0; g < p * highest; g++) {
			for (int i = 0; i < r; i++) {
				if (timestamp[originp[i] - 1][origine[i] - 1] >= timestamp[terminatorp[i] - 1][terminatore[i] - 1]) {
					timestamp[terminatorp[i] - 1][terminatore[i] - 1] = timestamp[originp[i] - 1][origine[i] - 1] + 1;
				}
			}

			for (int i = 0; i < p; i++) {
				for (int j = 0; j < e[i]; j++) {
					if (j != e[i] - 1) {
						if (timestamp[i][j] >= timestamp[i][j + 1]) {
							timestamp[i][j + 1] = timestamp[i][j] + 1;
						}
					} else if (timestamp[i][j] <= timestamp[i][j - 1]) {
						timestamp[i][j] = timestamp[i][j - 1] + 1;
					}
				}
			}
		}
		
		for (int i = 0; i < p; i++) {
			System.out.println("PROCESS : " + (i + 1));
			for (int j = 0; j < e[i]; j++) {
				System.out.print("\t" + timestamp[i][j]);
			}
			System.out.println();
		}
		s.close();
	}
}
