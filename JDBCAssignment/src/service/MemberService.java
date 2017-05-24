package service;

import bean.Member;
import dao.DaoFactory;
import dao.MemberDao;

public class MemberService {
	private MemberDao memberDao;
	
	public MemberService() {
		memberDao = DaoFactory.getInstace().createMemberDao();
		System.out.println("memberDao: " + memberDao);
	}
	
	public void regist(Member member) {
		if(member == null) {
			System.out.println("Invalid registration!!");
		} else {
			memberDao.addMember(member);
		}
	}
	
	public Member query(int memNumber) {
		Member member = memberDao.getMember(memNumber);
		if(member == null) {
			System.out.println("The query result is empty!!");
		} else {
			System.out.println(member.toString());
		}
		return member;
	}
	
	public void update(Member member) {
		if(member.getMemNumber() <= 0) {
			System.out.println("Invalid information, cannot update!!");
		} else {
			memberDao.update(member);
		}
	}
	
	public void delete(Member member) {
		if(member.getMemNumber() <= 0) {
			System.out.println("Invalid information, cannot delete!!");
		} else {
			memberDao.delete(member);
		}
	}
}
