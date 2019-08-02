
package Main;

import java.util.*;

public class LLM {
	
	public LLM() {
		LL.LL_LINK();
	}
	
	// ===============================================
	// AVERAGE HANDLER!
	/**
	 * Average for INTEGER [USING ARRAY]
	 * 
	 * @param i
	 *            Array of Ints
	 */
	int averageInt(int[] i) {
		int ret = 0;
		for (int h : i) {
			ret = ret + h;
		}
		ret = (ret / i.length);
		return ret;
	}
	
	/**
	 * Average for INTEGER [USING ARRAYLIST]
	 * 
	 * @param i
	 *            Array of Ints
	 */
	int averageInt(ArrayList<Integer> i) {
		int ret = 0;
		for (int h : i) {
			ret = ret + h;
		}
		ret = (ret / i.size());
		return ret;
	}
	
	/**
	 * Average for LONG [USING ARRAYLIST]
	 * 
	 * @param i
	 *            ArrayList of Ints
	 */
	long averageLong(ArrayList<Long> i) {
		long ret = 0;
		for (long h : i) {
			ret = ret + h;
		}
		ret = (ret / i.size());
		return ret;
	}
	
	/**
	 * Average for LONG [USING ARRAY]
	 * 
	 * @param i
	 *            Array of Ints
	 */
	long averageLong(long[] i) {
		long ret = 0;
		for (long h : i) {
			ret = ret + h;
		}
		ret = (ret / i.length);
		return ret;
	}
	
	/**
	 * 
	 * */
	float averageFloat(float[] f) {
		float ret = 0.0f;
		for (float t : f) {
			ret = ret + t;
		}
		ret = (ret / f.length);
		ret = (Math.round(ret * 1000f)) / 1000f;
		return ret;
	}
	
	/**
	 * 
	 * */
	float averageFloat(ArrayList<Float> f) {
		float ret = 0.0f;
		for (float t : f) {
			ret = ret + t;
		}
		ret = (ret / f.size());
		ret = (Math.round(ret * 1000f)) / 1000f;
		return ret;
	}
	
	double averageDouble(double[] f) {
		double ret = 0.0D;
		for (double t : f) {
			ret = ret + t;
		}
		ret = (ret / f.length);
		ret = (Math.round(ret * 1000D)) / 1000D;
		return ret;
	}
	
	/**
	 * 
	 * */
	double averageDouble(ArrayList<Double> f) {
		double ret = 0.0D;
		for (double t : f) {
			ret = ret + t;
		}
		ret = (ret / f.size());
		ret = (Math.round(ret * 1000D)) / 1000D;
		return ret;
	}
	
	// ===============================================
	// Find Largest Value from array
	int findLargestValueINT(int[] i) {
		int ret = 0;
		for (int t : i) {
			if (t > ret) {
				ret = t;
			}
		}
		return ret;
	}
	
	int findLargestValueINT(ArrayList<Integer> i) {
		int ret = 0;
		for (int t : i) {
			if (t > ret) {
				ret = t;
			}
		}
		return ret;
	}
	
	long findLargestValueLONG(long[] i) {
		long ret = 0;
		for (long t : i) {
			if (t > ret) {
				ret = t;
			}
		}
		return ret;
	}
	
	long findLargestValueLONG(ArrayList<Long> i) {
		long ret = 0;
		for (long t : i) {
			if (t > ret) {
				ret = t;
			}
		}
		return ret;
	}
	
	float findLargestValueFLOAT(float[] i) {
		float ret = 0;
		for (float t : i) {
			if (t > ret) {
				ret = t;
			}
		}
		return ret;
	}
	
	float findLargestValueFLOAT(ArrayList<Float> i) {
		float ret = 0;
		for (float t : i) {
			if (t > ret) {
				ret = t;
			}
		}
		return ret;
	}
	
	double findLargestValueDOUBLE(double[] i) {
		double ret = 0;
		for (double t : i) {
			if (t > ret) {
				ret = t;
			}
		}
		return ret;
	}
	
	double findLargestValueDOUBLE(ArrayList<Double> i) {
		double ret = 0;
		for (double t : i) {
			if (t > ret) {
				ret = t;
			}
		}
		return ret;
	}
	
	// ====================================================
	boolean isOdd(int value) {
		boolean ret = false;
		int end = value;
		
		while (end != 2 || end != -2) {
			if (end == 1 || end == -1) {
				break;
			}
			end = (end / 2);
			LL.console(end);
		}
		
		if (end == 2 || end == -2) {
			ret = true;
		}
		
		return ret;
	}
	
}
