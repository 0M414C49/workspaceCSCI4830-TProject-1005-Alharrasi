package datamodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @since J2SE-1.8 CREATE TABLE employee ( id INT NOT NULL AUTO_INCREMENT, name
 *        VARCHAR(30) NOT NULL, age INT NOT NULL, PRIMARY KEY (id));
 */
@Entity
@Table(name = "MyTable1014Alharrasi")
public class MyEmployeeAlharrasi {

	@Id // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id") // specify the column name. Without it, it will use method name
	private Integer id;

	@Column(name = "FIRST_NAME")
	private String FIRST_NAME;

	@Column(name = "LAST_NAME")
	private String LAST_NAME;
	
	@Column(name = "PASSWORD")
	private String PASSWORD;

	@Column(name = "PHONE")
	private String PHONE;

	@Column(name = "EMAIL")
	private String EMAIL;
	
	@Column(name = "AGE")
	private int AGE;
	
	@Column(name = "DATE")
	private String DATE;
	
	@Column(name = "SALARY")
	private String SALARY;

	public MyEmployeeAlharrasi() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MyEmployeeAlharrasi(Integer id, String fIRST_NAME, String lAST_NAME, String pASSWORD, String pHONE,
			String eMAIL, int aGE, String dATE, String sALARY) {
		super();
		this.id = id;
		FIRST_NAME = fIRST_NAME;
		LAST_NAME = lAST_NAME;
		PASSWORD = pASSWORD;
		PHONE = pHONE;
		EMAIL = eMAIL;
		AGE = aGE;
		DATE = dATE;
		SALARY = sALARY;
	}

	public MyEmployeeAlharrasi(String fIRST_NAME, String lAST_NAME, String pASSWORD, String pHONE, String eMAIL,
			int aGE, String dATE, String sALARY) {
		super();
		FIRST_NAME = fIRST_NAME;
		LAST_NAME = lAST_NAME;
		PASSWORD = pASSWORD;
		PHONE = pHONE;
		EMAIL = eMAIL;
		AGE = aGE;
		DATE = dATE;
		SALARY = sALARY;
	}

	@Override
	public String toString() {
		return "MyEmployeeAlharrasi [id=" + id + ", FIRST_NAME=" + FIRST_NAME + ", LAST_NAME=" + LAST_NAME
				+ ", PASSWORD=" + PASSWORD + ", PHONE=" + PHONE + ", EMAIL=" + EMAIL + ", AGE=" + AGE + ", DATE=" + DATE
				+ ", SALARY=" + SALARY + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFIRST_NAME() {
		return FIRST_NAME;
	}

	public void setFIRST_NAME(String fIRST_NAME) {
		FIRST_NAME = fIRST_NAME;
	}

	public String getLAST_NAME() {
		return LAST_NAME;
	}

	public void setLAST_NAME(String lAST_NAME) {
		LAST_NAME = lAST_NAME;
	}

	public String getPASSWORD() {
		return PASSWORD;
	}

	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}

	public String getPHONE() {
		return PHONE;
	}

	public void setPHONE(String pHONE) {
		PHONE = pHONE;
	}

	public String getEMAIL() {
		return EMAIL;
	}

	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}

	public int getAGE() {
		return AGE;
	}

	public void setAGE(int aGE) {
		AGE = aGE;
	}

	public String getDATE() {
		return DATE;
	}

	public void setDATE(String dATE) {
		DATE = dATE;
	}

	public String getSALARY() {
		return SALARY;
	}

	public void setSALARY(String sALARY) {
		SALARY = sALARY;
	}

	
	
}