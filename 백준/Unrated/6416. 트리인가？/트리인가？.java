import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int testCase = 1;
        while (true) {
            HashMap<Integer, ArrayList<Integer>> caseList = new HashMap<>();
            HashSet<Integer> nodeSet = new HashSet<>();
            HashSet<Integer> endSet = new HashSet<>();

            while (true) {
                String input = br.readLine();

                if (input == null || input.isEmpty()) {
                    continue;
                }

                StringTokenizer st = new StringTokenizer(input);
                boolean escape = false;

                while (st.hasMoreTokens()) {
                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());

                    if (a == 0 && b == 0) {
                        escape = true;
                        break;
                    }

                    if (a == -1 && b == -1) {
                        bw.write(sb.toString());
                        bw.flush();
                        bw.close();
                        return;
                    }

                    caseList.putIfAbsent(a, new ArrayList<>());
                    caseList.get(a).add(b);
                    nodeSet.add(a);
                    nodeSet.add(b);
                    endSet.add(b);
                }

                if (escape) {
                    break;
                }
            }

            if (caseList.isEmpty()) {
                sb.append("Case ").append(testCase).append(" is a tree.").append("\n");
                testCase++;
                continue;
            }

            ArrayList<Integer> rootList = new ArrayList<>();
            for (Integer i : nodeSet) {
                if (!endSet.contains(i)) {
                    rootList.add(i);
                }
            }

            if (rootList.size() != 1) {
                sb.append("Case ").append(testCase).append(" is not a tree.").append("\n");
            } else {
                HashSet<Integer> visited = new HashSet<>();
                Queue<Integer> queue = new LinkedList<>();

                int root = rootList.get(0);
                queue.add(root);
                visited.add(root);
                boolean chk = true;

                while (!queue.isEmpty()) {
                    int cur = queue.poll();

                    for (int next : caseList.getOrDefault(cur, new ArrayList<>())) {
                        if (!visited.contains(next)) {
                            visited.add(next);
                            queue.add(next);
                        } else {
                            chk = false;
                            break;
                        }
                    }
                }

                if (chk && visited.size() == nodeSet.size()) {
                    sb.append("Case ").append(testCase).append(" is a tree.").append("\n");
                } else {
                    sb.append("Case ").append(testCase).append(" is not a tree.").append("\n");
                }
            }

            testCase++;
        }
    }
}
