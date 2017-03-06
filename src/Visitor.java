
public class Visitor extends Human {
    //time waiting in room
    private final long VISITOR_WAITING;
    //max count doctors in room
    private static final int VISITOR_MAX_COUNT = 4;
    //current count visitors in room
    public static int visitor_count = 0;
    public String name = "";

    private Visitor(long timeWaitingInRoom) {
        this.VISITOR_WAITING = timeWaitingInRoom;
    }

    @Override
    public void run() {
        waitingInRoom(VISITOR_WAITING);
    }

    //random generate and entrance of the visitor if there is no doctor(chance 1 = 100%, 2 = 50%, 4 = 25%, 5 = 20% etc.)
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
