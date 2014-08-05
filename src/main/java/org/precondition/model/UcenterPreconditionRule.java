package org.precondition.model;

/**
 * .
 * User: jiawei.gao
 * Date: 14-8-5
 * qunar.com
 */
public class UcenterPreconditionRule {
    public UcenterPreconditionEvent event;

    public String rule;

    public String name;

    public int salience;

    public UcenterPreconditionEvent getEvent() {
        return event;
    }

    public void setEvent(UcenterPreconditionEvent event) {
        this.event = event;
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

    public int getSalience() {
        return salience;
    }

    public void setSalience(int salience) {
        this.salience = salience;
    }
}
