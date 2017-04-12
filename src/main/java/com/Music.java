package com;

public class Music {
    private String title;
    private Status status;

    public Music() {

    }

    public Music(String title){
        this.title = title;
    }

    public Music(String title, Status status) {
        this.title = title;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Music music = (Music) o;

        if (title != null ? !title.equals(music.title) : music.title != null)
            return false;
        return status == music.status;

    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "com.Music{" +
                "title='" + title + '\'' +
                ", status=" + status +
                '}';
    }
}
