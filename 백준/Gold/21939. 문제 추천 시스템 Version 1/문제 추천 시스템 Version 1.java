import java.io.*;
import java.util.*;

public class Main {

    static class Problem {
        int index;
        int difficulty;

        public Problem(int index, int difficulty) {
            this.index = index;
            this.difficulty = difficulty;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());

        // 최대 힙: 난이도 내림차순, 동일 난이도에서는 index 내림차순
        PriorityQueue<Problem> maxHeap = new PriorityQueue<>((p1, p2) -> {
            if (p1.difficulty != p2.difficulty) {
                return Integer.compare(p2.difficulty, p1.difficulty);
            }
            return Integer.compare(p2.index, p1.index);
        });

        // 최소 힙: 난이도 오름차순, 동일 난이도에서는 index 오름차순
        PriorityQueue<Problem> minHeap = new PriorityQueue<>((p1, p2) -> {
            if (p1.difficulty != p2.difficulty) {
                return Integer.compare(p1.difficulty, p2.difficulty);
            }
            return Integer.compare(p1.index, p2.index);
        });

        // 문제를 빠르게 찾기 위한 HashMap
        Map<Integer, Problem> problemMap = new HashMap<>();

        // 초기 데이터 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int pIdx = Integer.parseInt(st.nextToken());
            int difficulty = Integer.parseInt(st.nextToken());
            Problem problem = new Problem(pIdx, difficulty);
            problemMap.put(pIdx, problem);
            maxHeap.offer(problem);
            minHeap.offer(problem);
        }

        int M = Integer.parseInt(br.readLine());

        // 명령 처리
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("add")) {
                int pIdx = Integer.parseInt(st.nextToken());
                int difficulty = Integer.parseInt(st.nextToken());

                // 기존 데이터 삭제
                if (problemMap.containsKey(pIdx)) {
                    Problem oldProblem = problemMap.get(pIdx);
                    maxHeap.remove(oldProblem);
                    minHeap.remove(oldProblem);
                }

                // 새 데이터 추가
                Problem newProblem = new Problem(pIdx, difficulty);
                problemMap.put(pIdx, newProblem);
                maxHeap.offer(newProblem);
                minHeap.offer(newProblem);

            } else if (command.equals("recommend")) {
                int direction = Integer.parseInt(st.nextToken());

                if (direction == 1) {
                    // maxHeap에서 유효한 문제를 찾을 때까지 반복
                    while (!maxHeap.isEmpty() && !problemMap.containsKey(maxHeap.peek().index)) {
                        maxHeap.poll();
                    }
                    sb.append(maxHeap.peek().index).append('\n');
                } else {
                    // minHeap에서 유효한 문제를 찾을 때까지 반복
                    while (!minHeap.isEmpty() && !problemMap.containsKey(minHeap.peek().index)) {
                        minHeap.poll();
                    }
                    sb.append(minHeap.peek().index).append('\n');
                }

            } else if (command.equals("solved")) {
                int solveIndex = Integer.parseInt(st.nextToken());

                if (problemMap.containsKey(solveIndex)) {
                    Problem solvedProblem = problemMap.get(solveIndex);
                    problemMap.remove(solveIndex);
                    maxHeap.remove(solvedProblem);
                    minHeap.remove(solvedProblem);
                }
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
