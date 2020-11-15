package sample2.pkg2;

import sample2.pkg1.Member;
import java.util.List;
import java.util.ArrayList;


public class MemberList {
    private List<Member> lst;

    public MemberList(){
        lst= new ArrayList<Member>();
    }    

    public void add(Member member){
        lst.add(member);
    }

    public Member get(String id){
        for (Member m : lst){
            if (m.getId() == id){
                return m;
            }
        }
        return null;
    }

    public void remove(String id){
        for (Member m : lst){
            if (m.getId() == id){
                int i= lst.indexOf(m);
                lst.remove(i);
            }
        }
    }

    public int count(){
        return lst.size();
    }
}
