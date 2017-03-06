
public abstract class Human extends Thread {


    private boolean timeLeft = false;

    public boolean isTimeLeft() {
        return timeLeft;
    }

    public void waitingInRoom(long time) {
        try {
            Thread.sleep(time);
            timeLeft = true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
