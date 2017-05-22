package dao;

import entity.Member;

public interface MemberDao {
	public void addMember(Member Member);
	public Member getCustomemr(int MNumber);
	public int update(Member member);
	public int delete(Member member);
}
