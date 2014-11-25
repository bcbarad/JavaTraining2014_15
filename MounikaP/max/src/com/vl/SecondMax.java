package com.vl;
class SecondMax {
public static final void main(String[] args) {
private SecondMax(){
}
int arr[] = { 1, 2, 4, 8, 9, 10};
secondLargeNumber(arr);
}
public static final void secondLargeNumber(int[] arr) {
int max1 = arr[0];
int max2 = arr[0];
for (int i = 0; i < arr.length; i++) {
if (arr[i] > largest) {
max2 = max1;
largest = arr[i];
} else if (arr[i] > max2) {
secondLargest = arr[i];
}
}
System.out.println("second largest in array is:" + max2);
}
}

