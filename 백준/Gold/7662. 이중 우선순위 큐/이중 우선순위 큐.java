import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            PriorityQueue<Integer> minPq = new PriorityQueue<>();
            PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
            HashMap<Integer, Integer> map = new HashMap<>();

            int testOperCount = Integer.parseInt(br.readLine());
            for (int j = 0; j < testOperCount; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                int value = Integer.parseInt(st.nextToken());

                if (command.equals("I")) {
                    minPq.add(value);
                    maxPq.add(value);
                    map.put(value, map.getOrDefault(value, 0) + 1);

                } else {
                    if (map.isEmpty()) {
                        continue;
                    }

                    if (value == 1) {
                        while (!maxPq.isEmpty()) {
                            int deleteMaxValue = maxPq.peek();
                            if (map.getOrDefault(deleteMaxValue, 0) > 0) {
                                map.put(deleteMaxValue, map.get(deleteMaxValue) - 1);
                                if (map.get(deleteMaxValue) == 0) {
                                    map.remove(deleteMaxValue);
                                }
                                maxPq.poll();
                                break;
                            } else {
                                maxPq.poll();
                            }
                        }
                    } else {
                        while (!minPq.isEmpty()) {
                            int deleteMinValue = minPq.peek();
                            if (map.getOrDefault(deleteMinValue, 0) > 0) {
                                map.put(deleteMinValue, map.get(deleteMinValue) - 1);
                                if (map.get(deleteMinValue) == 0) {
                                    map.remove(deleteMinValue);
                                }
                                minPq.poll();
                                break;
                            } else {
                                minPq.poll();
                            }
                        }
                    }
                }
            } // end of each TestCase

            if (map.isEmpty()) {
                sb.append("EMPTY").append("\n");
                continue;
            } else {
                while (!maxPq.isEmpty()) {
                    int maxValue = maxPq.poll();
                    if (map.containsKey(maxValue)) {
                        sb.append(maxValue).append(" ");
                        break;
                    }
                }
                while (!minPq.isEmpty()) {
                    int minValue = minPq.poll();
                    if (map.containsKey(minValue)) {
                        sb.append(minValue).append("\n");
                        break;
                    }
                }
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    } // end of main

} // end of class