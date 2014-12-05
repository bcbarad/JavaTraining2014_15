//package com.vl.training.sample;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
public final class FileIndent {
    private FileIndent() {
    }
    public static void main(final String[] args) throws IOException {
        File f = new File("/home/chaitanya/workdir/JavaTraining2014_15"
                 + "/Chaitanya/fileindentation/src/com/vl/training"
                 + "/sample/Cname.txt");
        FileWriter f1 = new FileWriter("/home/chaitanya/workdir"
                       + "/JavaTraining2014_15/Chaitanya/fileindentation/src"
                       + "/com/vl/training/sample/Indent.txt", true);
        BufferedReader br = new BufferedReader(new FileReader(f));
        String line = null;
        int noofopens = 0;
        int count = 4, indent = 4;
        while ((line = br.readLine()) != null) {
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == '{') {
                    f1.write(line.charAt(i) + "\n");
                    noofopens++;
                    for (int k = 0; k < indent * noofopens; k++) {
                        f1.write(' ');
                    }
                }
                else if ((line.charAt(i) == '/') && (line.charAt( i + 1) == '*')) {
                    int len = 2, temp = i;
                    boolean check = false;
                    for ( int j = i + 2; j < line.length(); j++) {
                        len++;
                        if ((line.charAt(j) == '*') && (line.charAt( j + 1) == '/')){
                            i = j - 1;
                            check = true;
                            break;
                        }
                    }
                    if (check) {
                        for (; temp <  len - 1; temp++) {
                            f1.write(line.charAt(temp));
                        }
                    }
                }
                else { 
                    if (line.charAt(i) == '}') {
                        f1.write("\n");
                        for (int k = 0; k < (indent * (noofopens - 1)); k++) {
                            f1.write(' ');
                        }
                        noofopens--;
                        f1.write(line.charAt(i));
                    } else {
                        f1.write(line.charAt(i));
                    }
                }
            }
            if (noofopens == 0) {
                f1.write('\n');
            }
        }
        f1.close();
    }
}
