import java.io.*;
import java.util.*;

public class Main {
    static int N,M,a,b;
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int TestCase = 0; TestCase < T; TestCase++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // number of nation
            M = Integer.parseInt(st.nextToken()); // type of airplane

            list = new ArrayList[N+1];
            for (int i = 0; i < N+1; i++) { // list init
                list[i] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++) { // list data add
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                list[a].add(b);
                list[b].add(a);
            }
            bw.write(bfs(list) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static int bfs(ArrayList<Integer>[] ls){
        Queue<Integer> q = new LinkedList<>();
        visited = new boolean[N+1];
        int count = 0;
        q.offer(1);
        visited[1]=true;
        while(!q.isEmpty()){
            int point = q.poll();
            for (int i = 0; i < ls[point].size(); i++) {
                int next = ls[point].get(i);
                if(!visited[next]){
                    visited[next]=true;
                    q.offer(next);
                    count++;
                }
            }
        } // end of while
        return count;
    } // end of bfs
}