package employeeWageBuilder;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import employeeWageBuilder.Employee.CompanyEmpWage;

public class Employee implements InterfaceClass{
	
	public static final int IS_PART_TIME = 1;
	public static final int IS_FULL_TIME = 2;
	
	
	public class CompanyEmpWage{


	public final String company;
	public final int empRate;
	public final int numOfDays;
	public final int maxHrs;
	public int totalEmpWage;
	public LinkedList<Integer> companyEmpDailyWageList;
	
	public CompanyEmpWage(String company, int empRate, int numOfDays, int maxHrs ){
		companyEmpDailyWageList = new LinkedList<>();
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
	private Map<String,CompanyEmpWage> companyToEmpWageMap;
	
	public Employee() {

		companyEmpWageList = new LinkedList<>();
		companyToEmpWageMap = new HashMap<>();
	}



	public void addCompanyEmpWage(String company,int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth){

		CompanyEmpWage companyEmpWage = new CompanyEmpWage(company,empRatePerHour,numOfWorkingDays,maxHoursPerMonth);
		companyEmpWageList.add(companyEmpWage);
		companyToEmpWageMap.put(company, companyEmpWage);
		
	}
	


	public void computeEmpWage(){
	
		for (int i = 0;i<companyEmpWageList.size(); i++){
			CompanyEmpWage companyEmpWage = companyEmpWageList.get(i);
			companyEmpWage.setTotalEmpWage(this.CalcEmployeeWageForCompany(companyEmpWage));
			System.out.println(companyEmpWage);
		}


	}
	
	public  int getTotalWage(String company) {
		
		return companyToEmpWageMap.get(company).totalEmpWage;
		
	}
	
	public LinkedList<Integer> getCompanyDailyWAge(String company) {
		
		System.out.println("Printing Daily Wage For Company : "+ company);
		return companyToEmpWageMap.get(company).companyEmpDailyWageList;
		
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
			//System.out.println("Day#: " + i +"Emp Hr: "+empHrs + "Employee WAge for that day" + empWage);		
			a.companyEmpDailyWageList.add(empWage);	
			
		}
		
			
		
		System.out.println("Total Emp Wage for Company: " + a.company +" "+ totalEmpWage);

		return totalEmpWage;

	}

	public static void main(String[] args){

		Employee empWageBuilder = new Employee();
		//private void addCompanyEmpWage(String company,int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth)
		empWageBuilder.addCompanyEmpWage("DMart", 20, 10, 80);
		empWageBuilder.addCompanyEmpWage("Reliance", 10,7, 70);
		empWageBuilder.computeEmpWage();
		System.out.println("Total Wage for DMart Company: " + empWageBuilder.getTotalWage("DMart"));
		
		LinkedList<Integer> k = empWageBuilder.getCompanyDailyWAge("DMart");
		System.out.println(k);
	}
		
}


