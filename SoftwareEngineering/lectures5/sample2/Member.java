package sample2;

abstract class Member {
    static final String DOMAIN= "@iniad.org";
    protected String id;
    protected String name;

    Member(String id, String name) {
        this.id = id;
        this.name = name;
    }

    abstract public String getEmail();

    String getProfile() {
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
}
