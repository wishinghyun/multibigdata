package multi.android.network.tcp;

public class ChatMessage {
    String nickname;
    String msg;

    public ChatMessage() {
    }

    public ChatMessage(String nickname, String msg) {
        this.nickname = nickname;
        this.msg = msg;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "ChatMessage{" +
                "nickname='" + nickname + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
