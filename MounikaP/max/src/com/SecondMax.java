class SecondMax {
public static void main(String[] args) {
   int arr[] = { 1, 23, 47, 81, 92, 88, 52, 48, 56, 66, 65, 76, 71, 85};
   secondLargeNumber(arr);
   }
public static void secondLargeNumber(int[] arr) {
  int largest = arr[0];
  int secondLargest = arr[0];
  for (int i = 0; i < arr.length; i++) {
  if (arr[i] > largest) {
  secondLargest = largest;
  largest = arr[i];
  } else if (arr[i] > secondLargest) {
  secondLargest = arr[i];
 }
}
System.out.println("second largest in array is:" + secondLargest);
}
}

