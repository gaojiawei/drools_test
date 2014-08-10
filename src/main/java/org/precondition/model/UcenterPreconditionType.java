package org.precondition.model;

/**
 * .
 * User: jiawei.gao
 * Date: 14-8-5
 * qunar.com
 */
public enum UcenterPreconditionType {
    LOGIN("login"),REGISTER("register"),FIND_PASSWORD("find_password"),SEND_MOBILE("send_mobile");

    UcenterPreconditionType(String name) {
        this.name = name;
    }

    private String name;

    @Override public String toString() {
        return name;
    }
}
