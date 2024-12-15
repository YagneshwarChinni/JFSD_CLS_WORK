package InheritanceMapping;


import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
//@Table(name="person_table")

//single table strategy
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name ="type",discriminatorType =DiscriminatorType.STRING ,length =30)
//@DiscriminatorValue("PERSON")

//Table per class strategy
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

//Joined table strategy
@Inheritance(strategy = InheritanceType.JOINED)

public class Person {
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	@Column(name="pid")
	private int id;
	@Column(name="pname",length = 50)
	private String name;
	@Column(name="pgender",length = 20)
	private String gender;
	@Column(name="page")
	private double age;
	@Column(name="pcontactno",length=20)
	private String contactno;
	@Column(name="plocation",length=50)
	private String location;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public double getAge() {
		return age;
	}
	public void setAge(double age) {
		this.age = age;
	}
	public String getContactno() {
		return contactno;
	}
	public void setContactno(String contactno) {
		this.contactno = contactno;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	

}
