public class Myclass {
    public static void main(String args[]) {
      int[][] data1 = {{1},{2,2},{3,3,3}};
      int[][] data2 = doubleData(data1);
      showData(data2);
    }
    
    static int[][] doubleData(int[][] data){
        int[][] newData = new int[data.length][];
        for (int i = 0; i<data.length; i++){
            newData[i] = new int[data[i].length];
            for (int j = 0; j < data[i].length; j++){
                newData[i][j] = 2*data[i][j];
            }
        }
        return newData;
        
    }
    
    static void showData(int[][] a){
        int row, column;
        for (row = 0; row<a.length; row++){
            for(column = 0; column<a[row].length; column++)
                System.out.print(a[row][column] + " ");
                System.out.println();
        }
    }
}