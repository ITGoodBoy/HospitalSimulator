
public class Main {

    public static void main(String[] args) {
        Room room = new Room();
        Display display = new Display(room);

        while (true) {
            Human doctor = Doctor.randomInstance(4, 5000);
            Human visitor = Visitor.randomInstance(2, 5000);

            room.addHumanToRoom(doctor);
            room.addHumanToRoom(visitor);

            display.print();

            room.removeHumansFromRoom();

            sleep(2000);
        }
    }

    private static void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
