package org.precondition.model;

/**
 * .
 * User: jiawei.gao
 * Date: 14-8-5
 * qunar.com
 */
public class UcenterPreconditionObject {
    private String username;

    private String ip;

    private UcenterPreconditionEvent event;

    private UcenterPreconditionType type;

    public UcenterPreconditionObject(){}

    private UcenterPreconditionObject(Builder builder) {
        setType(builder.type);
        setEvent(builder.event);
        setIp(builder.ip);
        setUsername(builder.username);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public UcenterPreconditionEvent getEvent() {
        return event;
    }

    public void setEvent(UcenterPreconditionEvent event) {
        this.event = event;
    }

    public UcenterPreconditionType getType() {
        return type;
    }

    public void setType(UcenterPreconditionType type) {
        this.type = type;
    }

    public static final class Builder {
        private UcenterPreconditionType type;
        private UcenterPreconditionEvent event;
        private String ip;
        private String username;

        private Builder() {
        }

        public Builder type(UcenterPreconditionType type) {
            this.type = type;
            return this;
        }

        public Builder event(UcenterPreconditionEvent event) {
            this.event = event;
            return this;
        }

        public Builder ip(String ip) {
            this.ip = ip;
            return this;
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public UcenterPreconditionObject build() {
            return new UcenterPreconditionObject(this);
        }
    }

    @Override public String toString() {
        return "UcenterPreconditionObject{" +
                "username='" + username + '\'' +
                ", ip='" + ip + '\'' +
                ", event=" + event +
                ", type=" + type +
                '}';
    }
}
