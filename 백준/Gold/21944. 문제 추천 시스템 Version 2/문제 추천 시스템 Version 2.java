import java.io.*;
import java.util.HashMap;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    static class Problem implements Comparable<Problem> {
        int id;
        int difficulty;
        int category;

        public Problem(int id, int difficulty, int category) {
            this.id = id;
            this.difficulty = difficulty;
            this.category = category;
        }

        @Override
        public int compareTo(Problem o) {
            if (this.difficulty != o.difficulty) {
                return this.difficulty - o.difficulty;
            }
            return this.id - o.id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Problem problem = (Problem) o;
            return id == problem.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }

    static TreeSet<Problem> superSet = new TreeSet<>();
    static HashMap<Integer, TreeSet<Problem>> categories = new HashMap<>();
    static HashMap<Integer, Problem> problems = new HashMap<>();

    private static void addProblem(int p, int l, int g) {
        Problem problem = new Problem(p, l, g);
        superSet.add(problem);
        problems.put(p, problem);
        categories.putIfAbsent(g, new TreeSet<>());
        categories.get(g).add(problem);
    }

    private static void deleteProblem(int p) {
        Problem solved = problems.get(p);
        if (solved == null) {
            return;
        }
        superSet.remove(solved);
        problems.remove(p);
        if (categories.containsKey(solved.category)) {
            categories.get(solved.category).remove(solved);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            addProblem(p, l, g);
        }

        int M = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("add")) {
                int p = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken());
                int g = Integer.parseInt(st.nextToken());
                addProblem(p, l, g);
            } else if (command.equals("solved")) {
                int p = Integer.parseInt(st.nextToken());
                deleteProblem(p);
            } else if (command.equals("recommend")) {
                int g = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                TreeSet<Problem> gSet = categories.get(g);
                Problem recommend = x == 1 ? gSet.last() : gSet.first();
                result.append(recommend.id).append("\n");
            } else if (command.equals("recommend2")) {
                int x = Integer.parseInt(st.nextToken());
                Problem recommend = x == 1 ? superSet.last() : superSet.first();
                result.append(recommend.id).append("\n");
            } else if (command.equals("recommend3")) {
                int x = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken());
                Problem thresholdDummy = new Problem(0, l, 0);
                Problem recommend = null;
                if (x == 1) {
                    recommend = superSet.ceiling(thresholdDummy);
                } else if (x == -1) {
                    recommend = superSet.lower(thresholdDummy);
                }
                result.append(recommend == null ? -1 : recommend.id).append("\n");
            }
        }

        bw.write(result.toString());
        bw.flush();
        bw.close();
    }
}