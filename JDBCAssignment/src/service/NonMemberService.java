package service;

import dao.DaoFactory;
import dao.NonMemberDao;
import entity.NonMember;

public class NonMemberService {
	private NonMemberDao nonMemberDao;
	
	public NonMemberService() {
		nonMemberDao = DaoFactory.getInstace().createNonMemberDao();
		System.out.println("nonMemberDao: " + nonMemberDao);
	}
	
	public void regist(NonMember nonMember) {
		if(nonMember == null) {
			System.out.println("Invalid registration!!");
		} else {
			nonMemberDao.addNonMember(nonMember);
		}
	}
	
	public NonMember query(int SSN) {
		NonMember nonMember = nonMemberDao.getNonMember(SSN);
		if(nonMember == null) {
			System.out.println("The query result is empty!!");
		} else {
			System.out.println(nonMember.toString());
		}
		return nonMember;
	}
	
	public void update(NonMember nonMember) {
		if(nonMember.getSSN() <= 0) {
			System.out.println("Invalid information, cannot update!!");
		} else {
			nonMemberDao.update(nonMember);
		}
	}
	
	public void delete(NonMember nonMember) {
		if(nonMember.getSSN() <= 0) {
			System.out.println("Invalid information, cannot delete!!");
		} else {
			nonMemberDao.delete(nonMember);
		}
	}
}
