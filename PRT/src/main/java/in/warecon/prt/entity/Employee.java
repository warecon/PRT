package in.warecon.prt.entity;

import java.util.List;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

public class Employee {

	private String username;
	private String password;
	@OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
	private List<SecurityQuestion> securityQuestions;

}
