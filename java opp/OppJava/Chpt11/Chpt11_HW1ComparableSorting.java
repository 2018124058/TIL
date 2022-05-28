public class Chpt11_HW1ComparableSorting {

	public static void main(String[] args) {
		
		Comparable[] array = { new English131(30, 70), new English131(40, 80), new English131(40, 70), new English131(60, 60), 
											    new Math131(70, 48), new Math131(50, 50), new Math131(40, 90)}; 
		
		GeneralizedSelectionSort131.sort(array, array.length);
		
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		
	}

}

class GeneralizedSelectionSort131
{

    public static void sort(Comparable[] a, int numberUsed)
    {
        int index, indexOfNextSmallest;
        for (index = 0; index < numberUsed - 1; index++)
        {//Place the correct value in a[index]:
            indexOfNextSmallest = indexOfSmallest(index, a, numberUsed);
            interchange(index,indexOfNextSmallest, a);
             //a[0], a[1],..., a[index] are correctly ordered and these are 
             //the smallest of the original array elements. The remaining
             //positions contain the rest of the original array elements.
        }
    }

    private static int indexOfSmallest(int startIndex,
                                        Comparable[] a, int numberUsed)
    {
        Comparable min = a[startIndex];
        int indexOfMin = startIndex;
        int index;
        for (index = startIndex + 1; index < numberUsed; index++)
            if (a[index].compareTo(min) < 0)//if a[index] is less than min
            {
                min = a[index];
                indexOfMin = index;
                //min is smallest of a[startIndex] through a[index]
            }
        return indexOfMin;
    }
    
    private static void interchange(int i, int j, Comparable[] a)
    {
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp; //original value of a[i]
    }
    
}

// your code here for class English131 and class Math131
class English131 implements Comparable {
	int midScore, finalScore, total;
	
	public English131(int midScore, int finalScore) {
		this.midScore = midScore;
		this.finalScore = finalScore;
		double result = (midScore*0.3)+(finalScore*0.7);
		total = (int)Math.round(result);
	}
	
	public int compareTo(Object other) {
		if (!(other instanceof English131)) {
			Math131 otherMath = (Math131)other;
			
			if (this.total < otherMath.total)
				return -1; 
			else if (this.total > otherMath.total)
				return 1;
			else
				return 0;
		}
		else {
			English131 otherEnglish = (English131)other;
			
			if (this.total < otherEnglish.total)
				return -1; 
			else if (this.total > otherEnglish.total)
				return 1;
			else
				return 0;
		
		}
		
	}
	
	public String toString() {
		return "[ENG] mid(" + midScore + ") final("
				+ finalScore + ") total(" + total + ")";
	}
	
}

class Math131 implements Comparable{
	int midScore, finalScore, total;  
	
	public Math131(int midScore, int finalScore) {
		this.midScore = midScore;
		this.finalScore = finalScore;
		double result = (midScore*0.5)+(finalScore*0.5);
		total = (int)Math.round(result);
	}
	
	public int compareTo(Object other) {
		if (!(other instanceof English131)) {
			Math131 otherMath = (Math131)other;
			
			if (this.total < otherMath.total)
				return -1; 
			else if (this.total > otherMath.total)
				return 1;
			else
				return 0;
		}
		else {
			English131 otherEnglish = (English131)other;
			
			if (this.total < otherEnglish.total)
				return -1; 
			else if (this.total > otherEnglish.total)
				return 1;
			else
				return 0;
		
		}		
	}
	
	public String toString() {
		return "[MAT] mid(" + midScore + ") final("
				+ finalScore + ") total(" + total + ")";
	}
}
