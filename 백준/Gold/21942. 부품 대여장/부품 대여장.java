import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static int[] monthList = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    static class Overdue implements Comparable<Overdue> {
        String name;
        Long delayMinute;

        public Overdue(String name, Long delayMinute) {
            this.name = name;
            this.delayMinute = delayMinute;
        }

        @Override
        public int compareTo(Overdue o) {
            return name.compareTo(o.name);
        }
    }

    static int minuteCalculator(String rentDate, String returnDate) {
        int rentMonth = Integer.parseInt(rentDate.split("-")[1]);
        int rentDay = Integer.parseInt(rentDate.split("-")[2].split("_")[0]);
        int rentHour = Integer.parseInt(rentDate.split("_")[1].split(":")[0]);
        int rentMinute = Integer.parseInt(rentDate.split("_")[1].split(":")[1]);

        int returnMonth = Integer.parseInt(returnDate.split("-")[1]);
        int returnDay = Integer.parseInt(returnDate.split("-")[2].split("_")[0]);
        int returnHour = Integer.parseInt(returnDate.split("_")[1].split(":")[0]);
        int returnMinute = Integer.parseInt(returnDate.split("_")[1].split(":")[1]);

        int rentCumulateMinutes = (getDays(rentMonth) + rentDay) * 1440 + rentHour * 60 + rentMinute;
        int returnCumulateMinutes = (getDays(returnMonth) + returnDay) * 1440 + returnHour * 60 + returnMinute;

        return returnCumulateMinutes - rentCumulateMinutes;
    }

    static int getDays(int month) {
        int days = 0;
        for (int i = 0; i < month - 1; i++) {
            days += monthList[i];
        }
        return days;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder result = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        String L = st.nextToken();
        int F = Integer.parseInt(st.nextToken());

        int rentableDay = Integer.parseInt(L.split("/")[0]);
        int rentableHour = Integer.parseInt(L.split("/")[1].split(":")[0]);
        int rentableMinute = Integer.parseInt(L.split("/")[1].split(":")[1]);

        int maxRentableMinute = rentableDay * 24 * 60 + rentableHour * 60 + rentableMinute;

        HashMap<String, String> rentMap = new HashMap<>();
        HashMap<String, Long> overdueMap = new HashMap<>();
        ArrayList<Overdue> overdueList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String checkDate = st.nextToken();
            String checkTime = st.nextToken();
            String part = st.nextToken();
            String name = st.nextToken();

            String inputCode = part + "_" + name;
            String inputDate = checkDate + "_" + checkTime;

            if (rentMap.containsKey(inputCode)) {
                int rentMinutes = minuteCalculator(rentMap.get(inputCode), inputDate);
                int overdueMinutes = rentMinutes - maxRentableMinute;
                if (overdueMinutes > 0) {
                    if (overdueMap.containsKey(name)) {
                        overdueMap.compute(name, (k, v) -> v + (long) overdueMinutes * F);
                    } else {
                        overdueMap.put(name, (long) overdueMinutes * F);
                    }
                }
                rentMap.remove(inputCode);
            } else {
                rentMap.put(inputCode, inputDate);
            }
        }


        if (overdueMap.isEmpty()) {
            bw.write("-1");
        } else {
            for (Map.Entry<String, Long> violator : overdueMap.entrySet()) {
                overdueList.add(new Overdue(violator.getKey(), violator.getValue()));
            }

            overdueList.sort(Overdue::compareTo);

            for (Overdue overdue : overdueList) {
                result.append(overdue.name).append(' ').append(overdue.delayMinute).append('\n');
            }

            bw.write(result.toString());
        }

        bw.flush();
        bw.close();
    }
}