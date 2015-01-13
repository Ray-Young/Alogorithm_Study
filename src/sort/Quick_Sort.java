package sort;

public class Quick_Sort {
	public static void QuickSort(int low, int high, int num[]) {

		if (low < high) {
			int l = low;
			int h = high;
			int pivot = num[l];
			while (l < h) {
				while (l < h && num[h] >= pivot)
					h--;
				if (l < h) {
					num[l] = num[h];
					// h--;
				}
				while (l < h && num[l] < pivot)
					l++;
				if (l < h) {
					num[h] = num[l];
					// l++;
				}
			}
			num[l] = pivot;
			QuickSort(low, l, num);
			QuickSort(l + 1, high, num);
		}

	}

	public static void main(String[] args) {
		int num[] = { 6, 5, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		QuickSort(0, 10, num);
		for (int i = 0; i < num.length; i++)
			System.out.println(num[i]);
	}

}
