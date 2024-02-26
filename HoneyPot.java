public class HoneyPot implements Eatable {
    private int honeyLevel;

    public HoneyPot() {
        this.honeyLevel = 100;
    }

    @Override
    public void eat() {
        if (honeyLevel > 0) {
            System.out.println("Винни-Пух ест мед.");
            honeyLevel -= 10;
        } else {
            System.out.println("Горшочек с медом пуст.");
        }
    }

    public int getHoneyLevel() {
        return honeyLevel;
    }
}
