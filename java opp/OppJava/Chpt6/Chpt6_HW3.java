
public class Chpt6_HW3 {
	public static void main(String[] args) {
		int score1[][] = {{3, 2, 1, 5}, {2, 3, 0, 4}, {4, 0, 0, 5}}; 
		int score2[][] = {{4, 4, 4, 5}, {0, 0, 1, 2}, {3, 3, 2, 4}}; 
		int score3[][] = {{1, 2, 3, 4}, {0, 4, 2, 3}, {3, 5, 4, 1}}; 
		
		Rating rating = new Rating(3, 3);  // 3 evaluators, 3 products 
		
		// set all scores into rating
		for (int i = 0; i < 3; i++) {
				rating.setScore(0,  i,  score1[i][0], score1[i][1], score1[i][2], score1[i][3]); 
				rating.setScore(1,  i,  score2[i][0], score2[i][1], score2[i][2], score2[i][3]);
				rating.setScore(2,  i,  score3[i][0], score3[i][1], score3[i][2], score3[i][3]);
		}
		
		int answer = rating.averageScore();
		System.out.println("Average score of all evaluators for all products in all categories = " + answer);
		
		for (int i = 0; i < 3; i++) {
			answer = rating.averageScore(i);
			System.out.println("Average of all evaluators for product " + i + " = " + answer);
		}
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				answer = rating.averageScore(i, j); 
				System.out.println("Average of evaluator " + i + " for product " + j + " = " + answer); 
			}
		}
		
		String criteriaName[] = {"QUALITY", "DESIGN", "PRICE", "CONVENIENCE"};
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 4; j++) {
				answer = rating.averageScore(i, criteriaName[j]);
				System.out.println("Average of product " + i + " for criteria " + criteriaName [j] + " = " + answer); 
			}
		}
	}
}

class Rating {
    public int[] evaluator;
    public int[] product;
    public String[] criteriaName = new String[4]; 
    public String[] category = new String[4];
    public int[][][] allScore;
    
    //constructor
    public Rating(int evaluatorNumber, int productNumber) {
    	evaluator = new int[evaluatorNumber];
    	product = new int[productNumber];
    	allScore = new int[evaluatorNumber][productNumber][4];
    	}
  
    public void setScore(int evaluatorOrder, int productOrder, 
    		int c0, int c1, int c2, int c3) {
    	
    	//[evaluator][product][이부분에 값 넣기]
    	allScore[evaluatorOrder][productOrder][0] = c0;
    	allScore[evaluatorOrder][productOrder][1] = c1;
    	allScore[evaluatorOrder][productOrder][2] = c2;
    	allScore[evaluatorOrder][productOrder][3] = c3;
    }
    
    // 1. 모든 점수에 대한 평균
    public int averageScore() {
    	double sum = 0; 
    	double scoreNumber = evaluator.length * product.length * criteriaName.length;
    	
    	for (int i=0; i<allScore.length; i++)
    		for(int j=0; j<allScore[i].length; j++)
    			for(int x=0; x<allScore[i][j].length; x++)
    				sum += allScore[i][j][x];
    				
    	return ((int)Math.round(sum/scoreNumber));
    	
    }
    
    // 2. 특정 product에 대한 모든 evaluators의 점수 평균
    public int averageScore(int product) {
    	double sum = 0;
    	double scoreNumber = evaluator.length * criteriaName.length;
    	for (int i=0; i<allScore.length; i++) {
    		for(int x=0; x<allScore[i][product].length; x++)
    			sum += allScore[i][product][x];
    	}
    	return ((int)Math.round(sum/scoreNumber));
    	 //반올림이 작동을 안함

    }
    
    // 3. 특정 product에 대한 특정 evaluator의 점수 평균
    public int averageScore(int evaluator, int product) {
    	double sum = 0;
    	double scoreNumber = criteriaName.length;
    	for (int x=0; x<4; x++)
    		sum += allScore[evaluator][product][x];
    	return ((int)Math.round(sum/scoreNumber));
    }
    
    // 4. 특정 product의 특정 category의 점수 평균
    public int averageScore(int product, String category) {
    	double sum = 0;
    	double scoreNumber = evaluator.length;
    	int index = 0;
    	String[] criteriaName = {"QUALITY", "DESIGN", "PRICE", "CONVENIENCE"};
    	//main class의 criteriaName 값을 가져오는 방법..?
    	
    	
    	for (int x=0; x<criteriaName.length; x++)
    		if (criteriaName[x].equals(category))
    			index = x;
    	
    	
    	for (int i=0; i<evaluator.length; i++)
    			sum += allScore[i][product][index];
    	
    	return ((int)Math.round(sum/scoreNumber));
    	
    }
 }
