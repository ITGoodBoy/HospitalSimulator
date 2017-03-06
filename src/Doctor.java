
public class Doctor extends Human {
    private final long DOCTOR_WAITING;
    private static final int DOCTOR_MAX_COUNT = 1;

    public static int doctor_count = 0;
    public String name = "";

    private Doctor(long timeWaitingInRoom) {
        this.DOCTOR_WAITING = timeWaitingInRoom;
    }

    @Override
    public void run() {
        waitingInRoom(DOCTOR_WAITING);
    }

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
