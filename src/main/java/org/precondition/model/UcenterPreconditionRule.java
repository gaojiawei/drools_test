package org.precondition.model;

/**
 * .
 * User: jiawei.gao
 * Date: 14-8-5
 * qunar.com
 */
public class UcenterPreconditionRule {
    public UcenterPreconditionType type;

    public String rule;

    public String name;

    public UcenterPreconditionType getType() {
        return type;
    }

    public void setType(UcenterPreconditionType type) {
        this.type = type;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
