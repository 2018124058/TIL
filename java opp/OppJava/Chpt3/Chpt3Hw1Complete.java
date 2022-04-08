import java.util.Scanner;
public class Chpt3Hw1Complete {

	public static void main(String[] args) {
		
		Scanner commandKeyboard = new Scanner(System.in);
		String command;
		
		int x1 = 0;
		int y1 = 0;
		int x2 = 5;
		int y2 = 5;
		//String vertexPoints = ("("+ x1 + "," + y1 + ") (" + x2 + "," + y2 + ")");
		System.out.println("("+ x1 + "," + y1 + ") (" + x2 + "," + y2 + ")");
		
		while (true) {
			command = commandKeyboard.next();
			
			
			if (command.equals("area")) {
				int base, height;
				if (x1>x2)
					base = x1-x2;
				else
					base = x2-x1;
				if (y1>y2)
					height = y1-y2;
				else
					height = y2-y1;
				
				int area = base * height;
				System.out.println("area = " + area);
				}
			
			else if (command.equals("center")) {
				
				double widthCenter, heightCenter;
				if (x1>x2)
					widthCenter = x2 + ((double)(x1-x2) / 2);
				else
					widthCenter = x1 + ((double)(x2-x1) / 2);
				
				if (y1>y2)
					heightCenter = y2 + ((double)(y1-y2) / 2);
				else
					heightCenter = y1 + ((double)(y2-y1) / 2);
				
				System.out.println("center = (" + widthCenter + "," + heightCenter + ")");
			}
			
			else if ((command.substring(0,2)).equals("x1")) {
				x1 = commandKeyboard.nextInt();
			}
			
			else if ((command.substring(0,2)).equals("x2")) {
				x2 = commandKeyboard.nextInt();
			}
			
			else if ((command.substring(0,2)).equals("y1")) {
				y1 = commandKeyboard.nextInt();
			}
			
			else if ((command.substring(0,2)).equals("y2")) {
				y2 = commandKeyboard.nextInt();
			}
			
			
			else if (command.equals("exit")) {
				System.out.println("bye");
				System.exit(0);}
			
			System.out.println("("+ x1 + "," + y1 + ") (" + x2 + "," + y2 + ")");
			
			
		
		}
	}

}
