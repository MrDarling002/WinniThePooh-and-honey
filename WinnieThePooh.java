import java.util.Random;

public class WinnieThePooh extends Character {
    private int stuckLevel;

    public WinnieThePooh() {
        super("Винни пух");
        this.stuckLevel = 0;
    }

    @Override
    public void move() {
        // Локальный класс для обработки ситуации, когда Винни-Пух пытается выбраться из норы
        class StuckHandler {
            void handleStuckSituation() {
                System.out.println("Винни-Пух пытается выбраться из норы.");
                if (new Random().nextInt(10) > stuckLevel) {
                    situation = Situation.HUNGRY;
                }
            }
        }

        if (situation == Situation.STUCK) {
            StuckHandler stuckHandler = new StuckHandler();
            stuckHandler.handleStuckSituation();
        } else if (situation == Situation.HUNGRY) {
            System.out.println("Винни-Пух хочет кушать.");
        } else if (situation == Situation.CLIMBING) {
            System.out.println("Винни-Пух взбирается на дерево.");
            if (stuckLevel >= 40) {
                throw new WinnieThePoohIsTooStuckException();
            }
            System.out.println("Винни-Пух слишком толстый чтобы забраться на дерево, и падает!");
            situation = Situation.STUCK;
        } else {
            if (new Random().nextInt(40) < stuckLevel) {
                System.out.println("Винни-Пух взбирается по дереву и съедает весь мед");
                situation = Situation.HUNGRY;
            }
        }
    }

    public void eat(HoneyPot honeyPot) throws HoneyPotIsEmptyException {
        if (honeyPot.getHoneyLevel() <= 0) {
            throw new HoneyPotIsEmptyException();
        }
        honeyPot.eat();
        stuckLevel += new Random().nextInt(12);
        situation = Situation.HUNGRY;

        // Анонимный класс для обработки съедания меда
        Eatable eatable = new Eatable() {
            @Override
            public void eat() {
                System.out.println("Винни-Пух ест мед.");
            }
        };

        eatable.eat();
    }

    public void climb(Climbable climbable) {
        // Вложенный нестатический класс для работы с взбиранием
        class ClimbHelper {
            void climbTree() {
                System.out.println("Винни-Пух взбирается на дерево.");
            }
        }

        if (climbable instanceof Tree) {
            ClimbHelper climbHelper = new ClimbHelper();
            climbHelper.climbTree();
            situation = Situation.CLIMBING;
        }
    }

    public void askForHelp(Friend friend) {
        friend.help(this);
    }

    public int getStuckLevel() {
        return stuckLevel;
    }
}
