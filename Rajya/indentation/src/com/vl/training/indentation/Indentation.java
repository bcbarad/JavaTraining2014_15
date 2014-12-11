package com.vl.training.indentation;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

public final class Indentation {
    private Indentation() {
    }
    public static void main(final String []args) throws IOException {
        FileInputStream fin = null;
        FileOutputStream fout = null;
        try {
            if (args.length == 2) {
                fin = new FileInputStream(args[0]);
                fout = new FileOutputStream(args[1]);
                Indentation.checkIndentation(fin, fout);
            } else {
                System.out.println("Please provide 2 arguments");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw e;
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (fin != null) {
                fin.close();
            }
            if (fout != null) {
                fout.close();
            }
        }
    }

    static void printSpace(final int depth, final FileOutputStream fout) throws IOException {
        for (int j = 0; j < depth; j++) {
            fout.write(' ');
        }
    }

    static void checkIndentation(final FileInputStream fin, final FileOutputStream fout) throws IOException {
        int depth = 0, value = 0;
        char text;
        boolean checkNewLine = false, checkSpace = false;
        while ((value = fin.read()) != -1) {
            text = (char) value;
            if (text == '{') {
                depth += 4;
                fout.write(text);
            } else if (text == '}') {
                depth -= 4;
                printSpace(depth, fout);
                fout.write(text);
            } else if (text == ' ') {
                if (!checkSpace) {
                    fout.write(' ');
                }
            } else if (text == '\n') {
                fout.write(text);
                checkSpace = true;
            } else {
                if (checkSpace) {
                    printSpace(depth, fout);
                    checkSpace = false;
                }
                fout.write(text);
            }
            if (text == '/' && (char) fin.read() == '/') {
                fout.write(text);
                text = (char) fin.read();
                while (text != '\n') {
                    fout.write(text);
                    text = (char) fin.read();
                }
                if (text == '\n') {
                    fout.write(text);
                    printSpace(depth, fout);
                    checkSpace = false;
                }
            }
            if (text == '/') {
                fout.write(text);
                char previous = (char) fin.read();
                char current = (char) fin.read();
                while (previous != '*' && current != '/') {
                    fout.write(previous);
                    previous = current;
                    current = (char) fin.read();
                }
                fout.write(previous);
                fout.write(current);
            }
            if (text == '\'') {
                text = (char) fin.read();
                while (text != '\'') {
                    fout.write(text);
                    text = (char) fin.read();
                }
                fout.write(text);
            }
            if (text == '"') {
                text = (char) fin.read();
                while (text != '"') {
                    fout.write(text);
                    text = (char) fin.read();
                }
                fout.write(text);
            }
        }
    }
}

