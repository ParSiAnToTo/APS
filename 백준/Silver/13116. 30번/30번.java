import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int[] depthArr;

    static int depthFind(int target) {
        int depth = 0;
        for (int i = 0; i < 11; i++) {
            if (target < depthArr[i]) {
                depth = i;
                break;
            }
        }
        return depth;
    }

    static int findLCA(int a, int b) {
        int depthA = depthFind(a); // call depth finder
        int depthB = depthFind(b); // call depth finder

        while (depthA > depthB) { // depth matching
            a /= 2;
            depthA--;
        }
        while (depthB > depthA) { // depth matching
            b /= 2;
            depthB--;
        }

        while (a != b) { // find LCA
            a /= 2;
            b /= 2;
        }

        return a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[1024]; // perfect binary tree array
        depthArr = new int[11]; // depth range array
        for (int i = 0; i < 1024; i++) { // tree array init
            arr[i] = i + 1;
        }
        for (int i = 0; i < 11; i++) { // depth array init
            depthArr[i] = (int) Math.pow(2, i);
        }

        int T = Integer.parseInt(br.readLine()); // testCase <= 50,000
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int LCA = findLCA(A, B);
            sb.append(LCA * 10).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}