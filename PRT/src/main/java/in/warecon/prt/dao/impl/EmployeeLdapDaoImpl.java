package in.warecon.prt.dao.impl;

import java.util.List;

import javax.naming.directory.Attributes;

import org.springframework.ldap.NamingException;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.LdapTemplate;

import in.warecon.prt.dao.EmployeeLdapDao;
import in.warecon.prt.entity.Employee;

public class EmployeeLdapDaoImpl implements EmployeeLdapDao {
	private LdapTemplate ldapTemplate;
	
	
	public void setLdapTemplate(LdapTemplate ldapTemplate) {
        this.ldapTemplate = ldapTemplate;
    }

	
	@Override
	public List getAllEmployees() {
		return ldapTemplate.search("", "(objectclass=inetOrgPerson)",
                new AttributesMapper() {
                    public Object mapFromAttributes(Attributes attrs)
                            throws NamingException, javax.naming.NamingException {
                        return attrs.get("cn").get();
                    }
                });
    
	}

	@Override
	public boolean insertEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteEmployee(Employee employee) {
		// TODO Auto-generated method stub

	}

}
