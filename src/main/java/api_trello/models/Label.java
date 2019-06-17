package api_trello.models;

public class Label {
    public String id;
    public String color;
    public String name;

    @Override
    public String toString() {
        return "Label{" +
                "id='" + id + '\'' +
                ", color='" + color + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

