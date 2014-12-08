import com.vl;
import java.io.*;
class Indentation {
    public static void main(String[] args)throws IOException {
        FileReader source = null;
        FileWriter dest = null;
        boolean space = false;
        try {
        source = new FileReader("Source.java");
        dest = new FileWriter("dest.java");
        int a = 0;
        char ch;
        int depth = 0;
        while ((a = source.read()) != -1) {
            ch = (char) a;
            if (ch == '{') {
                depth = depth + 4;
                dest.write(ch);
            }
            else if (ch == '}') {
                depth = depth - 4;
                dest.write('\n');
                for(int index = 0; index < depth; index++) {
                    dest.write(' ');
                }
                dest.write(ch);
            }
            else if (ch == ' ') {
                if (!space) {
                    dest.write(ch);
                }
            }
            else {
                if(ch == '\n') {
                    dest.write(ch);
                    for(int index = 0; index < depth; index++) {
                        dest.write(' ');
                        space = true;
                    }
                } else {
                    dest.write(ch);
                }
            }
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            source.close();
            dest.close();
        }
    }
}
