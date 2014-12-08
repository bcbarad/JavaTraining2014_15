import com.vl;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
class Indentation {
    public static void main(String[] args)throws IOException {
        Indentation i = new Indentation();
            i.unIndentToIndent();
    }
    public static void unIndentToIndent() {
        FileReader in = null;
        FileWriter out = null;
        boolean space = false;
        try {
            in = new FileReader("Source.java");
            out = new FileWriter("dest.java");
            int a, depth = 0;
            char ch;
            while ((a = in.read()) != -1) {
                ch = (char) a;
                if (ch == '{') {
                    depth = depth + 4;
                    out.write(ch);
                }
                else if (ch == '}') {
                    depth = depth - 4;
                    out.write('\n');
                    indent(depth, out);
                    out.write(ch);
                }
                else if (ch == ' ') {
                    if (!space) {
                        out.write(ch);
                    }
                }
                else {
                    if(ch == '\n') {
                        out.write(ch);
                        for(int index = 0; index < depth; index++) {
                            out.write(' ');
                            space = true;
                        }
                    } else {
                        out.write(ch);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                in.close();
                out.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void indent(int depth, FileWriter out)throws IOException {
        for (int index = 0; index < depth; index++) {
            out.write(' ');
        }
    }
}
