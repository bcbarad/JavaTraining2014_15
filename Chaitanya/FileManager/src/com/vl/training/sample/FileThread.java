package com.vl.training.sample;
import java.io.File;
import java.util.Map;
class FileThread extends Thread {
    private File f;
    FileRead fr;
    private Map m;
    FileThread(final File f, final FileRead fr, final Map m) {
        this.f = f;
        this.fr = fr;
        this.m = m;
    }
    public void run() {
        fr.accountDetails(f, m);
    }
}
