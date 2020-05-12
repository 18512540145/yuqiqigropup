package com.yuqiqi.growup.utils;

public class MessageVO {
    private int no;
    private String uuid;
    private String messgae;

    public MessageVO(int no, String uuid, String messgae) {
        this.no = no;
        this.uuid = uuid;
        this.messgae = messgae;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getMessgae() {
        return messgae;
    }

    public void setMessgae(String messgae) {
        this.messgae = messgae;
    }

    @Override
    public String toString() {
        return "MessageVO{" +
                       "no=" + no +
                       ", uuid='" + uuid + '\'' +
                       ", messgae='" + messgae + '\'' +
                       '}';
    }
}