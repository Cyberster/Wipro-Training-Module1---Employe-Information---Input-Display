package com.w3epic.wiprotraining;

import java.util.Arrays;

public class Main {
	public static String[] empAssoc = {"EmpNo", "EmpName", "JoinDate", "DesignationCode", "Department", "Basic", "HRA", "IT"};
	public static String[][] empTable = new String[][] {
		{"1001", "Ashish", "01/04/2009", "e", "R&D", "20000", "8000", "3000"},
		{"1002", "Sushma", "23/08/2012", "c", "PM", "30000", "12000", "9000"},
		{"1003", "Rahul", "12/11/2008", "k", "Acct", "10000", "8000", "1000"},
		{"1004", "Chahat", "29/01/2013", "r", "FrontDesk", "12000", "6000", "2000"},
		{"1005", "Ranjan", "16/07/2005", "m", "Engg", "50000", "20000", "20000"},
		{"1006", "Suman", "1/1/2000", "e", "Manufacturing", "23000", "9000", "4400"},
		{"1007", "Tanmay", "12/06/2006", "c", "PM", "29000", "12000", "10000"}
	};
	
	public static String[] daAssoc = {"DesignationCode", "Designation", "DA"};
	public static String[][] daTable = new String[][] {
		{"e", "Engineer", "20000"},
		{"c", "Consultant", "32000"},
		{"k", "Clerk", "12000"},
		{"r", "Receptionist", "15000"},
		{"m", "Manager", "40000"}
	};
	
	public static void main(String[] args) {
		try {
			// fetching data
			String[] employee = getEmployee(Integer.parseInt(args[0]));
			String DesignationCode = employee[Arrays.asList(empAssoc).indexOf("DesignationCode")];
			String[] da = getDA(DesignationCode);
			String Designation = da[Arrays.asList(daAssoc).indexOf("Designation")];
		
			// salary calculation
			int Basic = Integer.parseInt(employee[Arrays.asList(empAssoc).indexOf("Basic")]);
			int HRA = Integer.parseInt(employee[Arrays.asList(empAssoc).indexOf("HRA")]);
			int IT = Integer.parseInt(employee[Arrays.asList(empAssoc).indexOf("IT")]);
			int DA = Integer.parseInt(da[Arrays.asList(daAssoc).indexOf("DA")]);
			int salary = Basic + HRA + DA - IT;
			
			// showing output
			System.out.printf("%-10s%-10s%-15s%-15s%-10s\n", "Emp No", "Emp Name", "Department", "Designation", "Salary");
			for (int i = 0; i < 80; i++) System.out.print("=");
			System.out.println();
			System.out.printf("%-10s%-10s%-15s%-15s%-10s", employee[0], employee[1], employee[4], Designation, salary);
		} catch (Exception e) {
			System.out.println("There is no employee with empid : " + args[0]);
		}
	}
	
	public static String[] getEmployee(int EmpNo) {
		int rowSize = empTable.length;
		int colSize = empTable[0].length;
		String[] employee = new String[colSize];
		
		for (int i = 0; i < rowSize; i++) {
			if (EmpNo == Integer.parseInt(empTable[i][0])) {
				for (int j = 0; j < colSize; j++) {
					employee[j] = empTable[i][j];
					//System.out.print(empTable[i][j] + ", ");
				}
			}
		}
		
		return employee;
	}
	
	public static String[] getDA(String DesignationCode) {
		int rowSize = daTable.length;
		int colSize = daTable[0].length;
		String[] da = new String[colSize];
		
		for (int i = 0; i < rowSize; i++) {
			if (DesignationCode.equals(daTable[i][0])) {
				for (int j = 0; j < colSize; j++) {
					da[j] = daTable[i][j];
					//System.out.print(empTable[i][j] + ", ");
				}
			}
		}
		
		return da;
	}
}
