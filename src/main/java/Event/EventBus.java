package Event;

public class EventBus {
    private static EventBus instance;
    private EventBus() {
    }
    public static EventBus getInstance() {
        if (instance == null) {
            instance = new EventBus();
        }
        return instance;
    }
    public void publish(IEvent event) {
        System.out.println("EventBus: " + event);
    }
}
