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
}
