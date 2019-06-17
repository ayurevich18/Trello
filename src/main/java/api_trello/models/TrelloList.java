package api_trello.models;

public class TrelloList {
    public String id;
    public String name;
    public Boolean closed;
    public String idBoard;

    @Override
    public String toString() {
        return "TrelloList{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", closed=" + closed +
                ", idBoard='" + idBoard + '\'' +
                '}';
    }
}
