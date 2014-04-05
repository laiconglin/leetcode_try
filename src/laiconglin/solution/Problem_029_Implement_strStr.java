package laiconglin.solution;

public class Problem_029_Implement_strStr {
    public String strStr(String haystack, String needle) {
        if(haystack == null) {
        		return null;
        }
        int pos = haystack.indexOf(needle);
        if(pos == -1) {
        		return null;
        } else {
        		return haystack.substring(pos);
        }        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
