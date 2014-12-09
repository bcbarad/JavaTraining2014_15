import java.io.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class IndentationMaking {
    static int depth;
    public static void main(String args[]) throws IOException {
        FileReader input = null;
        FileWriter output = null;
        try {
            input = new FileReader("/home/sravani/JavaTraining2014_15/Sravani/Indentation/Example.java");
            output = new FileWriter("/home/sravani/JavaTraining2014_15/Sravani/Indentation/Exampleout.java");
            int c;
            boolean checkspace = false;
            while((c = input.read()) != -1) {
                char ch = (char)c;
                if(ch == '/' || ch == '"' || ch == '\'') {
                    IndentationMaking.checkComments(input , output , ch);
                }
                if (ch == '{')  {
                    depth += 4;
                    output.write(ch);
                } else if (ch == '}') {
                    depth -= 4;
                    for (int i=0; i < depth; i++) {
                        output.write(" ");
                    }
                    output.write(ch);
                } else if(ch == '\n') {
                    output.write('\n');
                    checkspace = true;
                }
                else {
                    if(checkspace) {
                        for(int i=0; i<depth;i++) {
                            output.write(' ');
                        }
                        checkspace = false;
                    }
                    output.write(ch);
                }
            }
        } finally {
            if(input != null) {
                input.close();
            }
            if(output != null) {
                output.close();
            }
        }
    }
    public static void checkComments(FileReader input , FileWriter output , char ch){
        try {
            output.write(ch);
            ch = (char) input.read();
            if(ch == '/') {
                while( ch != '\n') {
                    output.write(ch);
                    ch = (char) input.read();
                }
            } else if(ch == '*') {
                output.write(ch);
                ch = (char) input.read();
                char nextch = (char) input.read();
                while(ch != '*' || nextch != '/') {
                    output.write(ch);
                    ch = nextch;
                    nextch = (char) input.read();
                }
                output.write(ch);
                output.write(nextch);
                ch = (char) input.read();
            }
            else {
                //output.write(ch);
                ch = (char) input.read();
            while(ch != '\'' || ch != '"') {
                    output.write(ch);
                    ch = (char) input.read();
                }
                output.write(ch);
                ch = (char) input.read();
            }
        }
        catch (Exception e) {
            System.out.println("exception is : " + e);
        }
    }
}
