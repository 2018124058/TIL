
public class Chpt5Hw1 {
	
	public static void main(String[] args) {
		Process051 p0 = new Process051(0);
		Process051 p1 = new Process051(1); 
		Process051 p2 = new Process051(2); 
		
		Service051 service1 = new Service051(3, 0); 
		System.out.println(service1);
		System.out.println(); 
		
		Service051 service2 = new Service051(p1); 
		System.out.println(service2);
		System.out.println(); 
		
		Service051 service3 = new Service051(p0);
		System.out.println(service3);
		System.out.println(); 
		
		Service051 service4 = new Service051(p2); 
		System.out.println(service4);
		System.out.println(); 
		
		Service051 service5 = new Service051(p1); 
		System.out.println(service5);
		System.out.println(); 
		
		Service051 service6 = new Service051(p2); 
		System.out.println(service6);
		System.out.println(); 
		
		Service051 service7 = new Service051(p1); 
		System.out.println(service7);   
		System.out.println(); 
		
		Service051 service8 = new Service051(p0); 
		System.out.println(service8);   
	}

}

class Process051{
	private int id;
	
	//constructor
	public Process051(int id) {
		this.id = id;
	}
	
	//accessor
	public int getId() {
		return id;
	}
	
}

class Service051{
	private static int numProcess;
	private static int numAccess;
	private static int turn;
	private boolean operate;
	private int obId;
	
	// constructor for first setting
	public Service051(int process, int firstTurn) {
		numProcess = process;
		turn = firstTurn;
		numAccess = 0;
	}

	// constructor
	public Service051(Process051 p) {
		numAccess += 1;
		obId = p.getId();
		if (turn == obId) {
			operate = true;
			//turn °ª ¹Ù²ñ
			if (turn == 0)
				turn = 1;
			else if (turn == 1)
				turn = 2;
			else if (turn == 2)
				turn = 0;
		}
		else {
			operate = false;
		}
		
	}
	
	//toString
	public String toString() {
		if (numAccess == 0) {
			return ("[service] numProcess(" + numProcess + 
					") numAccess(" + numAccess + ") turn(" + turn + ")");
		}
		else if (operate == true) {
			return ("process p(" + obId + ") done\n"
					+ "[service] numProcess(" + numProcess + 
					") numAccess(" + numAccess + ") turn(" + turn + ")");	
		}
		else {
			return("invalid turn for process p(" + obId + ")\n"
					+"[service] numProcess(" + numProcess + 
					") numAccess(" + numAccess + ") turn(" + turn + ")" );
		}
	}

}



