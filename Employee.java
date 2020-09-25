public class Employee {
	
	public static final int IS_PART_TIME = 1;
	public static final int IS_FULL_TIME = 2;

	private final String company;
	private final int empRate;
	private final int numOfDays;
	private final int maxHrs;
	
	public Employee(String company, int empRate, int numOfDays, int maxHrs ){

		this.company = company;
		this.empRate = empRate;
		this.numOfDays = numOfDays;
		this.maxHrs = maxHrs;

	}	

	public void CalcEmployeeWageForCompany(){

	//Variables
		
		int empHrs = 0;
		int empWage = 0;
		int totalEmpWage = 0;
		//Computation
		
		for(int i =0;i<numOfDays ;i++){

			double empCheck = Math.floor(Math.random()*10)%3;
			switch((int)empCheck){
			case IS_FULL_TIME :
				empHrs += 8;
				break;
			
			case IS_PART_TIME :
				empHrs += 4;
				break;

			default :
				empHrs += 0;
				break;

			
			}
			if(empHrs >= maxHrs){
				System.out.println("Reqd hrs of work done!!!!");
				break;	
				}
			empWage = empHrs*empRate;
			totalEmpWage += empWage;
					
					
			
		}
		
			
		
		System.out.println("Total Emp Wage for Company: " + company +" "+ totalEmpWage);



	}

	public static void main(String[] args){

		Employee dMart = new Employee("DMart",8,20,100);
		dMart.CalcEmployeeWageForCompany();



	}
		
}