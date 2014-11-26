package com.vl;
import java.io.*;
import java.util.*;
public final class Mode {
private Mode() {
}
static int occur(final int[] arr) {
int mode = arr[0] , mode1 = arr[0] , temp = 0 , modefreq = 1;
for (int i = 1; i <arr.length; i++) {
if (mode1 == arr[i]) {
if (mode == mode1) {
modefreq++;
} else {
temp++;
}
} else {
mode1 = arr[i];
temp = 1;
}
if (temp >= modefreq) {
mode = mode1;
modefreq = temp;
temp = 0;
}
}
return mode;
}
public static void main(final String[] args) {
int[] arr = {1,1,2,2,3,3,3};
int mode = Mode.occur(arr);
System.out.println(" mode: " + mode);
}
}
      
      
    
