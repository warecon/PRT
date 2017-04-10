package in.warecon.prt.controller;

import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import in.warecon.prt.dao.EmployeeLdapDao;
import in.warecon.prt.dao.impl.EmployeeLdapDaoImpl;

@RestController
@RequestMapping("/login")
public class LoginController {
	@RequestMapping(value = "/authenticate/{username}/{password}", method = RequestMethod.GET)
	public boolean authenticateUser(@PathVariable String username, @PathVariable String password) {
		return true;
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public void test() {
		try {
			Resource resource = new ClassPathResource("spring-ldap.xml");
			BeanFactory factory = new XmlBeanFactory(resource);
			EmployeeLdapDao ldapContact = (EmployeeLdapDaoImpl) factory.getBean("ldapContact");
			List contactList = ldapContact.getAllEmployees();
			for (int i = 0; i < contactList.size(); i++) {
				System.out.println("Contact Name " + contactList.get(i));
			}
		} catch (DataAccessException e) {
			System.out.println("Error occured " + e.getCause());
		}
	}

	@RequestMapping(value = "/authorize/{username}", method = RequestMethod.GET)
	public boolean authorizeUser(@PathVariable String username) {
		return true;
	}

}
