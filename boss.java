public class boss {

    private String type;
    private int hp;
    private boolean keyDrop;

    public boss(String type, int hp, boolean keyDrop) {
        this.type = type;
        this.hp = hp;
        this.keyDrop = keyDrop;
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

    public boolean isKeyDrop() {
        return keyDrop;
    }

    public void setKeyDrop(boolean keyDrop) {
        this.keyDrop = keyDrop;
    }

}
