package employeeWageBuilder;

import java.util.LinkedList;

import employeeWageBuilder.Employee.CompanyEmpWage;

interface InterfaceClass {

	public void addCompanyEmpWage(String company,int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth);
	public void computeEmpWage();
	public  int getTotalWage(String company) ;
	public LinkedList<Integer> getCompanyDailyWAge(String company);
	public int CalcEmployeeWageForCompany(CompanyEmpWage a);
}
