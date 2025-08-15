import java.io.*;
import java.util.*;

public class Main {

    static class Result {
        int nation;
        int studentNum;
        int point;

        public Result(int nation, int studentNum, int point) {
            this.nation = nation;
            this.studentNum = studentNum;
            this.point = point;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        ArrayList<Result> results = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int nation = Integer.parseInt(st.nextToken());
            int studentNum = Integer.parseInt(st.nextToken());
            int point = Integer.parseInt(st.nextToken());
            results.add(new Result(nation, studentNum, point));
        }

        results.sort((a, b) -> b.point - a.point);

        HashMap<Integer, Integer> nationFilter = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int count = 0;

        for (Result r : results) {
            int chk = nationFilter.getOrDefault(r.nation, 0);
            if (chk < 2) {
                sb.append(r.nation).append(" ").append(r.studentNum).append("\n");
                nationFilter.put(r.nation, chk + 1);
                count++;
            }
            if (count == 3) break;
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}