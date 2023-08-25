package empmvc;

public class Employee {
	int empno ,dept;
	String job,name;
	double sal;
	public Employee(int empno, int dept, String job, String name, double sal) {
		
		this.empno = empno;
		this.dept = dept;
		this.job = job;
		this.name = name;
		this.sal = sal;
	}
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public int getDept() {
		return dept;
	}
	public void setDept(int dept) {
		this.dept = dept;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	
}
