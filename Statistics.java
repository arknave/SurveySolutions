import java.util.*;
import java.io.*;

public class Statistics {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		for (int a = 0; a < cases; a++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int minSurvey = Integer.parseInt(st.nextToken());
			int numPeople = Integer.parseInt(st.nextToken());
			int edges = Integer.parseInt(st.nextToken());

			HashMap<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();
			for (int b = 0; b < numPeople; b++) {
				graph.put(b, new ArrayList<Integer>());
			}

			for (int b = 0; b < edges; b++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int finish = Integer.parseInt(st.nextToken());
				graph.get(start).add(finish);
				graph.get(finish).add(start);
			}

			HashSet<Integer> visited = new HashSet<Integer>();
			TreeMap<Integer, Integer> possible = new TreeMap<Integer, Integer>(new ReverseComparator());

			for (Integer node : graph.keySet()) {
				if (visited.contains(node))
					continue;

				int numInComponent = 0;

				Queue<Integer> toVisit = new LinkedList<Integer>();
				toVisit.add(node);

				while (!toVisit.isEmpty()) {
					int thisTime = toVisit.remove();
					if (visited.contains(thisTime))
						continue;
					numInComponent++;

					visited.add(thisTime);

					ArrayList<Integer> connections = graph.get(thisTime);
					for (Integer connection : connections) {
						toVisit.add(connection);
					}
				}
				if (!possible.containsKey(numInComponent)) {
					possible.put(numInComponent, 1);
				} else {
					possible.put(numInComponent, possible.get(numInComponent) + 1);
				}
			}

			int taken = 0;
			int required = 0;
			boolean done = false;

			Iterator<Map.Entry<Integer, Integer>> it = possible.entrySet().iterator();
			while (it.hasNext() && taken < minSurvey) {
				Map.Entry<Integer, Integer> current = it.next();
				for (int b = 0; b < current.getValue() && taken < minSurvey; b++) {
					required++;
					taken += current.getKey();
				}
			}

			if (taken < minSurvey) {
				System.out.println("IMPOSSIBLE");
			} else {
				System.out.println(required);
			}

		}
	}

	private static class ReverseComparator implements Comparator<Integer> {
		public int compare(Integer one, Integer two) {
			return two - one;
		}
	}
}
