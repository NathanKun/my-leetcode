// https://leetcode.com/problems/task-scheduler/
class Solution1 { // 241 ms
	public int leastInterval(final char[] tasks, final int n) {
		final int[][] array = new int[26][2]; // [task id 0-25][0 => tasks left,
												// 1 => cold town]

		for (final int c : tasks) {
			array[c - 65][0]++; // char to ascii int, A=>65, Z=>90
		}

		Arrays.sort(array, (a, b) -> Integer.compare(b[0], a[0]));
		final ArrayList<int[]> list = new ArrayList();

		final int iMax = 0;
		for (int i = 0; i < 26; i++) {
			if (array[i][0] == 0) {
				break;
			}
			list.add(array[i]);
		}

		int time = 0;
		while (list.size() != 0) {
			boolean found = false;
			for (int iTask = 0; iTask < list.size(); iTask++) {
				final int[] task = list.get(iTask);
				if (task[1] == 0) {
					found = true;
					task[0]--;
					task[1] = n + 1; // it will -1 at the end of this interval,
										// so + 1
					time++;

					if (task[0] == 0) {
						list.remove(iTask);
					}
					break;
				}
			}

			if (!found) {
				// idle
				time++;
			}

			// cold down
			for (final int[] task : list) {
				if (task[1] != 0) {
					task[1]--;
				}
			}

			list.sort((a, b) -> Integer.compare(b[0], a[0]));
		}

		return time;
	}
}

class Solution2 { // 110 ms
	public int leastInterval(final char[] tasks, final int n) {
		final int[][] array = new int[26][2]; // [task id 0-25][0 => tasks left,
												// 1 => cold town]

		for (final int c : tasks) {
			array[c - 65][0]++; // char to ascii int, A=>65, Z=>90
		}

		Arrays.sort(array, (a, b) -> Integer.compare(b[0], a[0]));
		final ArrayList<int[]> list = new ArrayList();

		final int iMax = 0;
		for (int i = 0; i < 26; i++) {
			if (array[i][0] == 0) {
				break;
			}
			list.add(array[i]);
		}

		int time = 0;
		while (list.size() != 0) {
			boolean found = false;
			for (int iTask = 0; iTask < list.size(); iTask++) {
				final int[] task = list.get(iTask);
				if (task[1] == 0) {
					found = true;
					task[0]--;
					task[1] = n + 1; // it will -1 at the end of this interval,
										// so + 1
					time++;

					if (task[0] == 0) {
						list.remove(iTask);
					}
					break;
				}
			}

			if (!found) {
				// idle
				time++;
			}

			// cold down
			for (final int[] task : list) {
				if (task[1] != 0) {
					task[1]--;
				}
			}


			if (time % (n + 1) == 0) {
				list.sort((a, b) -> Integer.compare(b[0], a[0]));
			}
		}

		return time;
	}
}
