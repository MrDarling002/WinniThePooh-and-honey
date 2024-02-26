public abstract class Friend {
    protected String name;

    public Friend(String name) {
        this.name = name;
    }

    public abstract void help(WinnieThePooh winnieThePooh);

    @Override
    public String toString() {
        return "Friend{" +
                "name='" + name + '\'' +
                '}';
    }
}
