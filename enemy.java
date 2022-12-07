public class enemy {

    private String type;
    private int hp;
    private int keyPiece;

    public enemy(String name, int hp, int keyPiece) {
        this.type = name;
        this.hp = hp;
        this.keyPiece = keyPiece;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getKeyPiece() {
        return keyPiece;
    }

    public void setKeyPiece(int keyPiece) {
        this.keyPiece = keyPiece;
    }

}
