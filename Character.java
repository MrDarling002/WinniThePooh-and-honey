public abstract class Character {
    protected String name;
    protected Situation situation;

    public Character(String name) {
        this.name = name;
        this.situation = Situation.STUCK;
    }

    public abstract void move();

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Character character = (Character) obj;
        return this.name.equals(character.name);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    @Override
    public String toString() {
        return "Характеристики}{" +
                "имя='" + name + '\'' +
                ", действие=" + situation +
                '}';
    }
}
