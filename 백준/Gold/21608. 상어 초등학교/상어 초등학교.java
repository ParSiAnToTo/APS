import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static LinkedHashMap<Integer, ArrayList<Integer>> satisfactionMap;
    static int[][] classroom;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    static class Seat implements Comparable<Seat> {
        int r;
        int c;
        int nullCount;
        int satisfactionCount;

        public Seat(int r, int c, int nullCount, int satisfactionCount) {
            this.r = r;
            this.c = c;
            this.nullCount = nullCount;
            this.satisfactionCount = satisfactionCount;
        }

        @Override
        public int compareTo(Seat seat) {
            if (this.satisfactionCount != seat.satisfactionCount) {
                return seat.satisfactionCount - this.satisfactionCount;
            }
            if (this.nullCount != seat.nullCount) {
                return seat.nullCount - this.nullCount;
            }
            if (this.r != seat.r) {
                return this.r - seat.r;
            }
            return this.c - seat.c;
        }
    }

    static void seatPosition() {
        for (Integer studentNumber : satisfactionMap.keySet()) {
            ArrayList<Integer> friend = satisfactionMap.get(studentNumber);
            PriorityQueue<Seat> pq = new PriorityQueue<>();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (classroom[i][j] == 0) {
                        int nCount = 0;
                        int fCount = 0;
                        for (int k = 0; k < 4; k++) {
                            int nr = i + dr[k];
                            int nc = j + dc[k];
                            if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                                if (classroom[nr][nc] == 0) {
                                    nCount++;
                                } else {
                                    int neighborNum = classroom[nr][nc];
                                    if (friend.contains(neighborNum)) {
                                        fCount++;
                                    }
                                }
                            }
                        }
                        pq.add(new Seat(i, j, nCount, fCount));
                    }
                }
            }

            Seat bestPosition = pq.poll();
            classroom[bestPosition.r][bestPosition.c] = studentNumber;
        }
    }

    static int surveySatisfaction() {
        int sumOfSatisfaction = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int student = classroom[i][j];
                ArrayList<Integer> friendList = satisfactionMap.get(student);

                int mySatisfaction = 0;
                for (int k = 0; k < 4; k++) {
                    int nr = i + dr[k];
                    int nc = j + dc[k];
                    if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                        int neighborNum = classroom[nr][nc];
                        if (friendList.contains(neighborNum)) {
                            mySatisfaction++;
                        }
                    }
                }
                if (mySatisfaction > 0) {
                    sumOfSatisfaction += (int) Math.pow(10, mySatisfaction - 1);
                }

            }
        }

        return sumOfSatisfaction;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        classroom = new int[N][N];
        satisfactionMap = new LinkedHashMap<>(N * N);

        for (int i = 0; i < N * N; i++) {
            st = new StringTokenizer(br.readLine());
            int studentNum = Integer.parseInt(st.nextToken());
            ArrayList<Integer> friendList = new ArrayList<>();
            for (int j = 0; j < 4; j++) {
                friendList.add(Integer.parseInt(st.nextToken()));
            }
            satisfactionMap.put(studentNum, friendList);
        }

        seatPosition();
        int sum = surveySatisfaction();
        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }
}