import java.util.Random;

public class Main {
    public static void main(String[] args) {
        WinnieThePooh winnieThePooh = new WinnieThePooh();
        HoneyPot honeyPot = new HoneyPot();
        Tree tree = new Tree();
        Rabbit rabbit = new Rabbit();

        System.out.println("Однажды Винни-Пух отправился на поиски меда в гости к Кролику. Но по пути он застрял в норе!");
        System.out.println("\nВинни-Пух обнаружил в норе горшочек меда и не смог устоять. Он съел почти весь мед, надеясь, что это поможет ему выбраться.");
        for (int i = 0; i < 10; i += new Random().nextInt(5)) {
            try {
                winnieThePooh.eat(honeyPot);
            } catch (HoneyPotIsEmptyException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\nНо к сожалению, Винни-Пух только сильнее застрял. Он позвал на помощь Кролика.");
        winnieThePooh.move();
        winnieThePooh.askForHelp(rabbit);

        System.out.println("\nКролику с трудом, но удалось вытащить Винни-Пуха из норы. Теперь Винни хотел только одного - залезть на дерево и съесть пчелиный");
        winnieThePooh.move();
        winnieThePooh.climb(tree);

        System.out.println("\nНаконец, Винни-Пух забрался на дерево чтобы полакомиться свежим медом.");
        winnieThePooh.move();
    }
}
