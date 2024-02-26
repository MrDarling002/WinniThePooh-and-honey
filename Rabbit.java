public class Rabbit extends Friend {
    public Rabbit() {
        super("Кролик");
    }

    @Override
    public void help(WinnieThePooh winnieThePooh) {
        System.out.println("Кролик помогает Винни-Пуху выбраться из норы.");
        winnieThePooh.situation = Situation.HUNGRY;
    }
}
