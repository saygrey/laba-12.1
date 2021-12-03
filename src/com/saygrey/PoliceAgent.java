package com.saygrey;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class PoliceAgent extends Carrier {
    private String message;
    private PropertyChangeSupport supp;

    public PoliceAgent() {
        supp = new PropertyChangeSupport(this);
    }

    public void addPropertyChangeListener(PropertyChangeListener member) {
        supp.addPropertyChangeListener(member);
    }

    public void setMessage(String message) {
        System.out.printf("\nPoliceAgent - %s\n", message);
        supp.firePropertyChange("PoliceMessage", this.message, message);
        this.message = message;

    }

    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("BossMessage")) {
            if (evt.getNewValue().equals("Идем грабить банк")) {
                arrestGang();
            }
        }
    }

    public void arrestGang() {
        setMessage("Полиция!Вы арестованы");
    }
}
