import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static Node[] tree;
	static StringBuilder sb = new StringBuilder();

	static class Node {
		char root;
		Node left;
		Node right;

		public Node(char root) {
			this.root = root;
			this.left = null;
			this.right = null;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		tree = new Node[N + 1];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			char parent = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);

			if (tree[parent - 'A'] == null) { // value - 'A' 값으로 인덱스 지정
				tree[parent - 'A'] = new Node(parent);
			}

			if (left != '.') {
				tree[left - 'A'] = new Node(left);
				tree[parent - 'A'].left = tree[left - 'A'];
			}
			if (right != '.') {
				tree[right - 'A'] = new Node(right);
				tree[parent - 'A'].right = tree[right - 'A'];
			}


		} // 트리 입력
		preorder(tree[0]);
		sb.append("\n");
		
		inorder(tree[0]);
		sb.append("\n");
		
		postorder(tree[0]);
		
		System.out.println(sb.toString());

	}// end of main

	static void preorder(Node root) {
		if (root == null) {
			return;
		}
		sb.append(root.root);
		preorder(root.left);
		preorder(root.right);

	}

	static void inorder(Node root) {
		if (root == null) {
			return;
		}
		inorder(root.left);
		sb.append(root.root);
		inorder(root.right);

	}

	static void postorder(Node root) {
		if (root == null) {
			return;
		}
		postorder(root.left);
		postorder(root.right);
		sb.append(root.root);
	}
}// end of class