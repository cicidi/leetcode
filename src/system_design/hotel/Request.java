package system_design.hotel;

public class Request {
    int clientId;
    int totalPeople;
    String roomType;
    boolean canWait;
    int roomId;

    public Request(int clientId, String roomType, boolean canWait) {
        this.clientId = clientId;
        this.roomType = roomType;
    }

    public Request(int i, String aDouble) {
    }
}
