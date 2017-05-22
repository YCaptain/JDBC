package dao;

import entity.NonMember;

public interface NonMemberDao {
	public void addMember(NonMember nonMember);
	public NonMember getCustomemr(int SSN);
	public int update(NonMember nonMember);
	public int delete(NonMember nonMember);
}
