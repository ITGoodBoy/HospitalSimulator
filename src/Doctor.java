
public class Doctor extends Human {
    //time waiting in room
    private final long DOCTOR_WAITING;
    //max count doctors in room
    private static final int DOCTOR_MAX_COUNT = 1;
    //current count doctors in room
    public static int doctor_count = 0;
    public String name = "";

    private Doctor(long timeWaitingInRoom) {
        this.DOCTOR_WAITING = timeWaitingInRoom;
    }

    @Override
    public void run() {
        waitingInRoom(DOCTOR_WAITING);
    }

    //random generate and entrance of the doctor if there is no visitor(chance 1 = 100%, 2 = 50%, 4 = 25%, 5 = 20% etc.)
    public static Doctor randomInstance(int chance, long timeWaitingInRoom) {
        if (doctor_count >= DOCTOR_MAX_COUNT) return null;
        int random = (int) (Math.random() * chance);
        if (random == 0) {
            return new Doctor(timeWaitingInRoom);
        }
        return null;
    }

    @Override
    public String toString() {
        return "Доктор " + name;
    }
}
