

import java.util.LinkedList;

//import employeeWageBuilder.Employee.CompanyEmpWage;

public class Employee {
	
	public static final int IS_PART_TIME = 1;
	public static final int IS_FULL_TIME = 2;

	public class CompanyEmpWage{


	public final String company;
	public final int empRate;
	public final int numOfDays;
	public final int maxHrs;
	public int totalEmpWage;
	
	public CompanyEmpWage(String company, int empRate, int numOfDays, int maxHrs ){

		this.company = company;
		this.empRate = empRate;
		this.numOfDays = numOfDays;
		this.maxHrs = maxHrs;

	}	
	
	public void setTotalEmpWage(int totalEmpWage){
	
		this.totalEmpWage = totalEmpWage;

	}



}
	

	private int numOfCompany = 0;	
	private LinkedList<CompanyEmpWage> companyEmpWageList;

	public Employee() {

		companyEmpWageList = new LinkedList<>();
	}



	private void addCompanyEmpWage(String company,int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth){

		CompanyEmpWage companyEmpWage = new CompanyEmpWage(company,empRatePerHour,numOfWorkingDays,maxHoursPerMonth);
		companyEmpWageList.add(companyEmpWage);
	}

	private void computeEmpWage(){
	
		for (int i = 0;i<companyEmpWageList.size(); i++){
			CompanyEmpWage companyEmpWage = companyEmpWageList.get(i);
			companyEmpWage.setTotalEmpWage(this.CalcEmployeeWageForCompany(companyEmpWage));
			System.out.println(companyEmpWage);
		}


	}


	public int CalcEmployeeWageForCompany(CompanyEmpWage a){

	//Variables
		
		int empHrs = 0;
		int empWage = 0;
		int totalEmpWage = 0;
		//Computation
		
		for(int i =0;i<a.numOfDays ;i++){

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
			if(empHrs >= a.maxHrs){
				System.out.println("Reqd hrs of work done!!!!");
				break;	
				}
			empWage = empHrs*a.empRate;
			totalEmpWage += empWage;
			//System.out.println("Day#: " + i +"Emp Hr: "+empHrs);		
					
			
		}
		
			
		
		System.out.println("Total Emp Wage for Company: " + a.company +" "+ totalEmpWage);

		return totalEmpWage;

	}

	public static void main(String[] args){

		Employee empWageBuilder = new Employee();
		empWageBuilder.addCompanyEmpWage("DMart", 20, 2, 10);
		empWageBuilder.addCompanyEmpWage("Reliance", 10, 4, 20);
		empWageBuilder.computeEmpWage();

	}
		
}


