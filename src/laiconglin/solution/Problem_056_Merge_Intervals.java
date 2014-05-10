package laiconglin.solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Problem_056_Merge_Intervals {
	class IntervalComparable implements Comparator<Interval> {
		@Override
		public int compare(Interval o1, Interval o2) {
			if(o1.start < o2.start) {
				return -1;
			} else if(o1.start == o2.start) {
				return 0;
			} else {
				return 1;
			}
		}
	}
	
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
    	ArrayList<Interval> res = new ArrayList<Interval>();
    	if(intervals.size() == 0) {
    		return res;
    	}
		Collections.sort(intervals, new IntervalComparable());
		int size = intervals.size();
		Interval cur = null;
		for(int i = 0; i < size; i++) {
			if(cur == null) {
				cur = intervals.get(i);
			} else {
				if(cur.end >= intervals.get(i).start) {
					cur.end = Math.max(cur.end, intervals.get(i).end);
				} else {
					res.add(cur);
					cur = intervals.get(i);
				}
			}
		}
		if(cur != null) {
			res.add(cur);
		}
		
    	return res;
    }
    public void showIntervals(ArrayList<Interval> intervals) {
    	for (Interval interval : intervals) {
			System.out.print(interval.toString());
		}
    	System.out.println();
    }
    
	public static void main(String[] args) {
		Problem_056_Merge_Intervals solution = new Problem_056_Merge_Intervals();
		ArrayList<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(1, 3));
		intervals.add(new Interval(2, 6));
		intervals.add(new Interval(8, 10));
		intervals.add(new Interval(15, 18));
		intervals.add(new Interval(5, 14));
		solution.showIntervals(intervals);
		ArrayList<Interval> res = solution.merge(intervals);
		solution.showIntervals(intervals);
		solution.showIntervals(res);
	}

}
