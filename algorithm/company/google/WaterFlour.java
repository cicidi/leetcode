public class WaterFlour {

  public static void main(String[] args) {
    int[] arr = new int[] {2, 4, 5, 1, 2};
    System.out.println(cal(arr, 6));
  }

  public static int cal(int[] input, int cap) {
    int count = 0;
    int wl = cap; // water left
    int cur = 0; // current index

    while (cur < input.length) {
      if (input[cur] > cap) {
        return -1;
      }
      if (wl >= input[cur]) {
        wl -= input[cur];
        cur++;
        count++;
      } else {
        count += cur * 2;
        wl = cap;
      }
    }
    return count;
  }
}
