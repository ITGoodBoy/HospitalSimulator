import java.util.ArrayList;
import java.util.Collections;


public class Room {

    //variables for names
    private int visitorNumber = 1;
    private int doctorNumber = 1;
    //Check those who are in the room
    private boolean doctorInRoom = false;
    private boolean visitorInRoom = false;

    private static final ArrayList<Human> humansList = new ArrayList<>();
    static {
        Collections.synchronizedList(humansList);
    }

    public ArrayList<Human> getHumansList() {
            return humansList;
    }

    public void addHumanToRoom(Human human) {
            if (human == null) return;

            if (human instanceof Doctor && !visitorInRoom) {
                ((Doctor) human).name = "#" + doctorNumber++;
                doctorInRoom = true;
                Doctor.doctor_count++;
                addRunDisplay(human);
            }

            if (human instanceof Visitor && !doctorInRoom) {
                ((Visitor) human).name = "#" + visitorNumber++;
                Visitor.visitor_count++;
                visitorInRoom = true;
                addRunDisplay(human);
            }
    }

    private  void addRunDisplay(Human human) {
            humansList.add(human);
            human.start();
            Display.printIn(human);
    }

    public void removeHumansFromRoom() {
        doctorInRoom = false;
        visitorInRoom = false;

        for (int i = 0; i < humansList.size(); i++) {
            if (humansList.get(i).isTimeLeft()) {
                if (humansList.get(i) instanceof  Doctor)
                    Doctor.doctor_count--;
                if (humansList.get(i) instanceof  Visitor)
                    Visitor.visitor_count--;
                Display.printOut(humansList.get(i));
                humansList.remove(i);
            }
        }

        for (int i = 0; i < humansList.size(); i++) {
            if (humansList.get(i) instanceof Doctor) doctorInRoom = true;
            if (humansList.get(i) instanceof Visitor) visitorInRoom = true;
        }
    }

}