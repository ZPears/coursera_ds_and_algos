import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class tree_height {
    class FastScanner {
		StringTokenizer tok = new StringTokenizer("");
		BufferedReader in;

		FastScanner() {
			in = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() throws IOException {
			while (!tok.hasMoreElements())
				tok = new StringTokenizer(in.readLine());
			return tok.nextToken();
		}
		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
	}

	public class Node {
		int parentIdx;
		Queue<Node> children = new LinkedList<Node>();

		void addChild(Node n) {
			children.add(n);
		}

		Node(int pi) {
			parentIdx = pi;
		}
	}

	public class TreeHeight {
		int n;
		Node nodes[];
		
		void read() throws IOException {
			FastScanner in = new FastScanner();
/*			n = 5;
			nodes = new Node[n];
			int[] nodeVals = new int[]{4, -1, 4, 1, 1};
			for (int i = 0; i < nodeVals.length; i++) {
				nodes[i] = new Node(nodeVals[i]);
			}*/
			n = in.nextInt();
			nodes = new Node[n];
			for (int i = 0; i < n; i++) {
				nodes[i] = new Node(in.nextInt());
			}
		}

		Node[] AssignSomeNodes(Node[] nodes) {
			for (int i = 0; i < n; i++) {
				int parIdx = nodes[i].parentIdx;
				if (parIdx != -1) {
					nodes[parIdx].addChild(nodes[i]);
				}
			}
			return nodes;
		}

		int computeHeight() {
			Node assignedNodes[];
			assignedNodes = AssignSomeNodes(nodes);

			Node rootNode = Arrays.asList(assignedNodes).stream().filter(n -> n.parentIdx == -1).findFirst().get();

			Queue<Node> queue1 = new LinkedList<Node>();
			Queue<Node> queue2 = new LinkedList<Node>();

			queue1.add(rootNode);

			int maxHeight = 0;
			while (queue1.peek() != null || queue2.peek() != null) {
				if (queue1.peek() != null) {
					while (queue1.peek() != null) {
						Queue<Node> kids = queue1.poll().children;
						while (kids.peek() != null) {
							queue2.add(kids.poll());
						}
					}
					maxHeight++;
				}
				else if (queue2.peek() != null) {
					while (queue2.peek() != null) {
						Queue<Node> kids = queue2.poll().children;
						while (kids.peek() != null) {
							queue1.add(kids.poll());
						}
					}
					maxHeight++;
				}
				else { return maxHeight; }
			}
			return maxHeight;
		}
	}

	static public void main(String[] args) throws IOException {
            new Thread(null, new Runnable() {
                    public void run() {
                        try {
                            new tree_height().run();
                        } catch (IOException e) {
                        }
                    }
                }, "1", 1 << 26).start();
	}

	public void run() throws IOException {
		TreeHeight tree = new TreeHeight();
		tree.read();
		System.out.println(tree.computeHeight());
	}
}