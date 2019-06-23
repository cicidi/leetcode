package system_design.hotel;

public class Room {
    int id;
    int clientId;
    String status;
    String type;

    public Room(int id, String status, String type) {
        this.id = id;
        this.status = status;
        this.type = type;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Room{");
        sb.append("id=").append(id);
        sb.append(", clientId=").append(clientId);
        sb.append(", status='").append(status).append('\'');
        sb.append(", type='").append(type).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
