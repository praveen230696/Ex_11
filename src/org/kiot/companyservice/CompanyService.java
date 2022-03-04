package org.kiot.companyservice;

import java.util.HashMap;
import java.util.Map;
import org.kiot.companyservice.icompanyserviceprovider.ICompanyServiceProvider;
import org.kiot.employee.Employee;

public class CompanyService implements ICompanyServiceProvider {

	private int companyID;
	private String address;
	Employee employee;
	private Map <Integer, Employee> employeeMap = new HashMap<Integer, Employee>();
	public CompanyService() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CompanyService(int companyID, String address, Employee employee) {
		super();
		this.companyID = companyID;
		this.address = address;
		this.employee = employee;
	}
	
	@Override
	public boolean createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		if (employee != null) {						
			employeeMap.put(employee.getId(),employee);
			return true;
		}
		
		return false;
	}
	
	@Override
	public boolean searchEmployee(int id) {
		if(employeeMap.containsKey(id)) {
			//productmap.get(id);
			return true;
		}
		return false;
	}
	
	@Override
	public boolean updateSalary(Employee employee) {
		// TODO Auto-generated method stub
		if(employeeMap.containsKey(employee.getId())) {
			if (employee.getSalary() >= 0)
				employeeMap.get(employee.getId()).setName(employee.getName());
		}
		return false;
	}		
	
	@Override
	public boolean deleteEmployee(int id) {
		// TODO Auto-generated method stub
		if(employeeMap.containsKey(id)) {
			employeeMap.remove(id);
			return true;
		}

		return false;
	}
}
