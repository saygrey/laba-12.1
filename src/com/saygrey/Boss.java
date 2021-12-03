package com.saygrey;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Boss extends GangMember {
    private String message;
    private PropertyChangeSupport supp;

    public Boss() {
        super("Boss");
        supp = new PropertyChangeSupport(this);
    }

    public void addPropertyChangeListener(PropertyChangeListener member) {
        supp.addPropertyChangeListener(member);
    }

    public void setMessage(String message) {
        System.out.printf("\nBoss - %s\n", message);
        supp.firePropertyChange("BossMessage", this.message, message);
        this.message = message;

    }

    public void propertyChange(PropertyChangeEvent evt) {

        if (evt.getPropertyName() == "PoliceMessage") {
            if (evt.getNewValue().equals("Полиция!Вы арестованы")) {
                iAmArrested();
            }
        }
    }

    public void goRobbery() {
        setMessage("Идем грабить банк");
        if (!arrestFlag) {
            robbery();
            robberyFinal();
        }
    }

    public void robbery() {
        setMessage("Ограбление в процессе");
    }

    public void robberyFinal() {
        setMessage("Ограбление завершено");
    }

    public void iAmArrested() {
        arrestFlag = true;
        setMessage("Ограбление отменяется");
    }
}
