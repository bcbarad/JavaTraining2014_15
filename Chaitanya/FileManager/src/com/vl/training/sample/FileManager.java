package com.vl.training.sample;
import java.io.File;
class FileManager {
    File f;
    File[] files;
    File getNext(final FileManager fm, final int n, final String dirpath) {
        return files[n];
    }
    int getLength(final FileManager fm, final String dirpath) {
        fm.f = new File(dirpath);
        fm.files = f.listFiles();
        return files.length;
    }
}

