import java.util.Arrays;

public class inversions {

static int merge(Integer[] array, int start, int end) {
  if (start == end) return 0;
  System.out.println("start=" + start + " end=" + end);
  int mid = (start + end)/2;
  int inversion = 0;
  int i = start;
  int j = mid;
  int pos = 0;
  Integer[] tmp = new Integer[end-start+1];
  while(i < mid && j < end) {
    if (array[i] > array[j]) {
      tmp[pos++] = array[j++];
      inversion += (mid-i);
    } else {
      tmp[pos++] = array[i++];
    }
  }
  while (i < mid) { tmp[pos++] = array[i++]; }
  while (j < end) { tmp[pos++] = array[j++]; }
  System.out.println(Arrays.toString(array));
  for (i=start; i<end; i++) { array[i] = tmp[i-start]; }
  System.out.println(Arrays.toString(array));
  System.out.println();
  return inversion;
}

static int findInversion(Integer[] array, int start, int end) {
  if (end-start > 1) {
    int mid = (start + end)/2;
    int left = findInversion(array, start, mid);
    int right = findInversion(array, mid, end);
    int inversion = merge(array, start, end);
    System.out.println("left=" + left + " right=" + right + " LR=" + inversion);
    return left + right + inversion;
  }
  return 0;
}

public static void main(String[] s) {
  Integer[] array = {2, 4, 1, 3, 5};
  int inversion = findInversion(array, 0, array.length);
  System.out.println("I=" + inversion);
}

}
