package multi.android.permissiontestpro;

public class ActorItem{
    int myImg;
    String name;
    String date;
    String info;

    public ActorItem(int myImg, String name, String date, String info) {
        this.myImg = myImg;
        this.name = name;
        this.date = date;
        this.info = info;
    }

    @Override
    public String toString() {
        return "ActorItem{" +
                "myImg=" + myImg +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}