import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int budget = Integer.parseInt(st.nextToken());
        int jhBudget = budget;
        int jhStock = 0;
        int smBudget = budget;
        int smStock = 0;

        int[] stockGraph = new int[14];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 14; i++) {
            stockGraph[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < 14; i++) {
            if (jhBudget >= stockGraph[i]) {
                int buyStock = jhBudget / stockGraph[i];
                jhStock += buyStock;
                jhBudget -= buyStock * stockGraph[i];
            }
        }


        for (int i = 3; i < 14; i++) {
            if (stockGraph[i - 3] < stockGraph[i - 2] && stockGraph[i - 2] < stockGraph[i - 1] && stockGraph[i - 1] < stockGraph[i]) {
                smBudget += smStock * stockGraph[i];
                smStock = 0;
            } else if (stockGraph[i - 3] > stockGraph[i - 2] && stockGraph[i - 2] > stockGraph[i - 1] && stockGraph[i - 1] > stockGraph[i]) {
                if (smBudget >= stockGraph[i]) {
                    int buyStock = smBudget / stockGraph[i];
                    smStock += buyStock;
                    smBudget -= buyStock * stockGraph[i];
                }
            }
        }

        int jhTotal = jhBudget + (jhStock * stockGraph[13]);
        int smTotal = smBudget + (smStock * stockGraph[13]);

        if (jhTotal > smTotal) {
            sb.append("BNP");
        } else if (jhTotal < smTotal) {
            sb.append("TIMING");
        } else {
            sb.append("SAMESAME");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
