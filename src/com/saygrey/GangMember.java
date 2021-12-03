package com.saygrey;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public abstract class GangMember implements PropertyChangeListener {
    private String role;
    protected boolean arrestFlag = false;

    public GangMember(String role) {
        this.role = role;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("BossMessage")) {
            if (evt.getNewValue().equals("Идем грабить банк") && !arrestFlag) {
                readyForRobbery();
            }
            if (evt.getNewValue().equals("Ограбление в процессе") && !arrestFlag) {
                robbery();
            }
            if (evt.getNewValue().equals("Ограбление завершено") && !arrestFlag) {
                robberyFinal();
            }
        }
        if (evt.getPropertyName() == "PoliceMessage") {
            if (evt.getNewValue().equals("Полиция!Вы арестованы")) {
                iAmArrested();
            }
        }
    }

    public void readyForRobbery() {
        System.out.printf("%s - Готов к ограблению\n", role);
    }

    public void robbery() {
        System.out.printf("%s - Занимаюсь ограблением\n", role);
    }

    public void robberyFinal() {
        System.out.printf("%s - Прячусь\n", role);
    }

    public void iAmArrested() {
        arrestFlag = true;
        System.out.printf("%s - Я арестован\n", role);
    }

}
