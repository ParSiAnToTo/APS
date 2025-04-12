import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write("    8888888888  888    88888");
        bw.newLine();
        bw.write("   88     88   88 88   88  88");
        bw.newLine();
        bw.write("    8888  88  88   88  88888");
        bw.newLine();
        bw.write("       88 88 888888888 88   88");
        bw.newLine();
        bw.write("88888888  88 88     88 88    888888");
        bw.newLine();
        bw.newLine();
        bw.write("88  88  88   888    88888    888888");
        bw.newLine();
        bw.write("88  88  88  88 88   88  88  88");
        bw.newLine();
        bw.write("88 8888 88 88   88  88888    8888");
        bw.newLine();
        bw.write(" 888  888 888888888 88  88      88");
        bw.newLine();
        bw.write("  88  88  88     88 88   88888888");
        bw.flush();
        bw.close();
    }
}