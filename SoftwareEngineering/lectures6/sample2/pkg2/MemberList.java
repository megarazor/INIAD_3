package sample2.pkg2;

import java.util.Map;
import java.util.HashMap;
import sample2.pkg1.Member;

public class MemberList {
    private final Map<String, Member> members;

    public MemberList() {
        members = new HashMap<String, Member>();
    }

    public void add(Member member) {
        members.put(member.getId(), member);
    }

    public Member get(String id) {
        return members.get(id);
    }

    public void remove(String id) {
        members.remove(id);
    }

    public int count() {
        return members.size();
    }
}