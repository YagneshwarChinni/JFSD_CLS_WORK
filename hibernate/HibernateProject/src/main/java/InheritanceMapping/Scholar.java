package InheritanceMapping;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
//@Table(name="scholar_table")


//@DiscriminatorValue("SCHOLAR")

public class Scholar extends Person{
	
	@Column(name="sdepartment",length=50)
	private String department;
	@Column(name="sprogram",length=50)
	private String program;
	@Column(name="syear")
	private int year;
	@Column(name="scgpa")
	private double cgpa;
	@Column(name="sbacklogs")
	private int backlogs;
	@Column(name="scounsellor",length = 40)
	private String counsellor;
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getProgram() {
		return program;
	}
	public void setProgram(String program) {
		this.program = program;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public double getCgpa() {
		return cgpa;
	}
	public void setCgpa(double cgpa) {
		this.cgpa = cgpa;
	}
	public int getBacklogs() {
		return backlogs;
	}
	public void setBacklogs(int backlogs) {
		this.backlogs = backlogs;
	}
	public String getCounsellor() {
		return counsellor;
	}
	public void setCounsellor(String counsellor) {
		this.counsellor = counsellor;
	}

	
	
}
