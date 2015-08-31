package laiconglin.solution;

import java.util.ArrayList;

public class Problem_057_Insert_Interval {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
    	ArrayList<Interval> result = new ArrayList<Interval>();
    	Interval cur = new Interval(newInterval.start, newInterval.end);
    	int size = intervals.size();
    	if(size == 0) {
    		result.add(newInterval);
    		return result;
    	}
    	if(cur.end < intervals.get(0).start) {
    		result.add(cur);
    		result.addAll(intervals);
    		return result;
    	} else if(cur.start > intervals.get(size - 1).end) {
    		result.addAll(intervals);
    		result.add(cur);
    		return result;
    	}
    	
    	for(int i = 0; i < size; i++) {
    		if(intervals.get(i).end < newInterval.start) {
    			result.add(intervals.get(i));
    			continue;
    		} else if(intervals.get(i).start > newInterval.end) {
    			if(cur != null) {
    				result.add(cur);
    				cur = null;
    			}
    			result.add(intervals.get(i));
    			continue;
    		} else {
    			cur.start = Math.min(cur.start, intervals.get(i).start);
    			cur.end = Math.max(cur.end, intervals.get(i).end);
    		}
    	}
    	
		if(cur != null) {
			result.add(cur);
			cur = null;
		}
    	return result;
    }
    
    public void showIntervals(ArrayList<Interval> intervals) {
    	for (Interval interval : intervals) {
			System.out.print(interval.toString());
		}
    	System.out.println();
    }
	public static void main(String[] args) {
		ArrayList<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(1, 2));
		intervals.add(new Interval(3, 5));
		intervals.add(new Interval(6, 7));
		intervals.add(new Interval(8, 10));
		intervals.add(new Interval(12, 16));
		Interval newInterval = new Interval(4, 9);
		Problem_057_Insert_Interval solution = new Problem_057_Insert_Interval();
		solution.showIntervals(intervals);
		ArrayList<Interval> res = solution.insert(intervals, newInterval);
		solution.showIntervals(res);
	}

}
