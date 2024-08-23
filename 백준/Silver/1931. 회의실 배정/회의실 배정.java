import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<MeetingTime> meetingTimeList;

    static class MeetingTime implements Comparable<MeetingTime> {
        int startTime;
        int endTime;

        public MeetingTime(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(MeetingTime o) {
            if (this.startTime != o.startTime) {
                return this.startTime - o.startTime;
            } else {
                return this.endTime - o.endTime;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        meetingTimeList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            MeetingTime newMeeting = new MeetingTime(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            meetingTimeList.add(newMeeting);
        }

        Collections.sort(meetingTimeList);

        int maxMeetingCount = 1;
        int nextEndTime = Integer.MAX_VALUE;
        for (MeetingTime t : meetingTimeList) {
            if (t.endTime < nextEndTime) {
                nextEndTime = t.endTime;
            } else if (t.startTime >= nextEndTime) {
                maxMeetingCount++;
                nextEndTime = t.endTime;

            }
        }
        sb.append(maxMeetingCount);
        bw.write(sb.toString());
        bw.flush();
        bw.close();

    } // end of main

} // end of class