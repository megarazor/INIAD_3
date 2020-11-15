package sample2.pkg1;

public abstract class Member {
    public static final String DOMAIN= "@iniad.org";
    protected String id;
    protected String name;

    public Member(String id, String name) {
        this.id = id;
        this.name = name;
    }

    abstract public String getEmail();

    public String getProfile() {
        StringBuffer sb = new StringBuffer(); 
        sb.append("ID: ").append(id).append("\n");
        sb.append("Name: ").append(name).append("\n");
        String email = getEmail();
        sb.append("email: ").append(email).append("\n");
        if (canReserveRoom()){
            sb.append("Room: OK\n");
        }
        else {
            sb.append("Room: NG\n");
        }
        return sb.toString();
    }

    abstract public boolean canReserveRoom();

    public String getId(){
        return id;
    }
}
