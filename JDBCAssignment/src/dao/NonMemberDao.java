package dao;

import bean.NonMember;

public interface NonMemberDao {
	public void addNonMember(NonMember nonMember);
	public NonMember getNonMember(int SSN);
	public int update(NonMember nonMember);
	public int delete(NonMember nonMember);
}
