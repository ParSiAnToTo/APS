import java.io.*;
import java.util.*;

public class Main {

    static class Book implements Comparable<Book> {
        String name;
        int count;

        public Book(String name, int count) {
            this.name = name;
            this.count = count;
        }

        @Override
        public int compareTo(Book o) {
            if (this.count != o.count) {
                return o.count - this.count;
            } else {
                return this.name.compareTo(o.name);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>(N);

        for (int i = 0; i < N; i++) {
            String bookName = br.readLine();
            map.put(bookName, map.getOrDefault(bookName, 0) + 1);

        }

        ArrayList<Book> list = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            list.add(new Book(entry.getKey(), entry.getValue()));
        }

        Collections.sort(list);

        sb.append(list.get(0).name);


        bw.write(sb.toString());
        bw.flush();
        bw.close();

    } // end of main

} // end of class