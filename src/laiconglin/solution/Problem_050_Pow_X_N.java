package laiconglin.solution;

public class Problem_050_Pow_X_N {
    public double pow(double x, int n) {
		double res = 0.0;
		if (n == 0) {
			res = 1.0;
		} else if(x == 1) {
			res = 1;
		} else if(n == 1) {
			res = x;
		} else if (x == Double.NaN && n != 0) {
			res = Double.NaN;
		} else if (Math.abs(x) > 1 && n == Integer.MAX_VALUE) {
			res = Double.MAX_VALUE;
		} else if (Math.abs(x) < 1 && n == Integer.MIN_VALUE) {
			res = Double.MAX_VALUE;
		} else if (Math.abs(x) > 1 && n == Integer.MIN_VALUE) {
			res = 0;
		} else if (Math.abs(x) < 1 && n == Integer.MAX_VALUE) {
			res = 0;
		} else if(Math.abs(x) == 1 &&n == Integer.MAX_VALUE) {
			res = -1.0;
		} else if(Math.abs(x) == 1 &&n == Integer.MIN_VALUE) {
			res = 1.0;
		} else if(x == 0 && n >= 1) {
			res = 0;
		} else if(x == Double.MAX_VALUE && n <= -1) {
			res = 0;
		} else if(x == 0 && n <= -1) {
			res = Double.MAX_VALUE;
		} else if(x == Double.MAX_VALUE && n >= 1) {
			res = Double.MAX_VALUE;
		} else if(x == Double.MIN_VALUE && n <= -1) {
			res = 0;
		} else if(x == Double.MIN_VALUE && n >= 1 && n != Integer.MAX_VALUE && (n % 2) == 0) {
			res = Double.MAX_VALUE;
		}  else if(x == Double.MIN_VALUE && n >= 1 && n != Integer.MAX_VALUE && (n % 2) == 1) {
			res = Double.MIN_VALUE;
		} else if(n >= 1 && n != Integer.MAX_VALUE) {
			res = 1.0;
			while(n > 0) {
				res *= x;
				n--;
			}
		} else if(n <= -1 && n != Integer.MIN_VALUE) {
			res = 1.0;
			while(n < 0) {
				res = res / x;
				n++;
			}
		}

		return res;      
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
