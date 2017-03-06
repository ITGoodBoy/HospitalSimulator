


public class Display {

    private Room room;

    public Display(Room room) {
        this.room = room;
    }

    //Displays people in the room
    public void print() {
        for (Human human : room.getHumansList()) {
            System.out.println("в комнате находится " + human);
        }
    }
    //display human who entered the room
    public static void printIn(Human human) {
        System.out.println("в комнату зашёл " + human);
    }
    //display human leaving the room
    public static void printOut(Human human) {
        System.out.println("с комнаты вышёл " + human);
        System.out.println();
        System.out.println();
    }
}
