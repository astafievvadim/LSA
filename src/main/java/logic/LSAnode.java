package logic;

public class LSAnode {

    private String type; //It could be X, Y, Up, Down, or W;

    private int specialAddress; //check only if type == up or type == down or actually type x===
    private String contents; // contents, only if type == x or type == y

    public LSAnode(String t, int adr, String cont){
        type = t;
        specialAddress = adr;
        contents = cont;
    }
    public String getType() {
        return type;
    }

    public int getSpecialAddress() {
        return specialAddress;
    }

    public String getContents() {
        return contents;
    }
}
