
public class Visitor extends Human {
    private final long VISITOR_WAITING;
    private static final int VISITOR_MAX_COUNT = 4;

    public static int visitor_count = 0;
    public String name = "";

    private Visitor(long timeWaitingInRoom) {
        this.VISITOR_WAITING = timeWaitingInRoom;
    }

    @Override
    public void run() {
        waitingInRoom(VISITOR_WAITING);
    }

    public static Visitor randomInstance(int chance, long timeWaitingInRoom) {
        if (visitor_count >= VISITOR_MAX_COUNT) return null;
        int random = (int) (Math.random() * chance);
        if (random == 0){
            return new Visitor(timeWaitingInRoom);
        }
        return null;
    }

    @Override
    public String toString() {
        return "Посетитель " + name;
    }
}
