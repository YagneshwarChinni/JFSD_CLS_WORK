package InheritanceMapping;


import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
//@Table(name="teacher_table")

//@DiscriminatorValue("TEACHER") 
public class Teacher extends Person{
	
	@Column(name="tqualification",length=50)
	private String qualification;
	@Column(name="tdepartment",length=50)
	private String department;
	@Column(name="tdesignation",length=50)
	private String designation;
	@Column(name="tsalary")
	private double salary;
	@Column(name="texperience")
	private double experience;
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public double getExperience() {
		return experience;
	}
	public void setExperience(double experience) {
		this.experience = experience;
	}
	
	


}
