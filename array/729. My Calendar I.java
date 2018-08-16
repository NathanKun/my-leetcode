// https://leetcode.com/problems/my-calendar-i/
class MyCalendar {

	public static List<int[]> booked;

	public MyCalendar() {
		booked = new ArrayList();
	}

	public boolean book(final int start, final int end) {
		if (booked.size() == 0) {
			booked.add(new int[]{start, end});
			return true;
		}

		for (int i = 0; i < booked.size(); i++) {
			final int[] b = booked.get(i);
			int[] bNext = null;

			if ((b[1] > start && b[0] <= start)
					|| (b[1] >= end && b[0] < end)) {
				return false;
			}

			if (i + 1 < booked.size()) {
				bNext = booked.get(i + 1);
			} else { // last one
				if (b[1] <= start) {
					booked.add(new int[]{start, end});
					return true;
				} else if (booked.get(0)[0] >= end) {
					booked.add(0, new int[]{start, end});
					return true;
				} else {
					return false;
				}
			}

			if (start >= b[1] && end <= bNext[0]) {
				booked.add(i + 1, new int[]{start, end});
				return true;
			}
		}

		return false;
	}
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
