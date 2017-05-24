package dao;

import bean.Member;

public interface MemberDao {
	public void addMember(Member Member);
	public Member getMember(int MNumber);
	public int update(Member member);
	public int delete(Member member);
}
