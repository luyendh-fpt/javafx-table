package netcafe.entity;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Member {

    private String username;
    private String password;
    private String fullName;
    private String avatar;
    private long remainTime;
    private String stringRemainTime;
    private ImageView avatarImage;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public long getRemainTime() {
        return remainTime;
    }

    public void setRemainTime(long remainTime) {
        this.remainTime = remainTime;
    }

    public String getStringRemainTime() {
        // thời gian ở dạng milisecond, biến từ mls sang giờ, phút, giây.
        return String.valueOf(this.remainTime);
    }

    public void setStringRemainTime(String stringRemainTime) {
        this.stringRemainTime = stringRemainTime;
    }

    public ImageView getAvatarImage() {
        if (avatarImage == null) {
            Image image = new Image(this.avatar, true);
            this.avatarImage = new ImageView(image);
            this.avatarImage.setFitHeight(100);
            this.avatarImage.setFitWidth(100);
        }
        return avatarImage;
    }

    public void setAvatarImage(ImageView avatarImage) {
        this.avatarImage = avatarImage;
    }
}
