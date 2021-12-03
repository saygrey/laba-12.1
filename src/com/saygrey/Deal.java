package com.saygrey;

public class Deal {
    private Boss boss;
    private Carrier carrier;
    private Driver driver;
    private CracksMan cracksMan;
    private PoliceAgent policeAgent;
    private boolean policeFlag;

    public Deal(boolean policeFlag) {
        this.policeFlag = policeFlag;
        prepareForDeal();
    }

    private void prepareForDeal() {
        boss = new Boss();
        driver = new Driver();
        cracksMan = new CracksMan();
        if (policeFlag) {
            policeAgent = new PoliceAgent();
            boss.addPropertyChangeListener(policeAgent);
            policeAgent.addPropertyChangeListener(boss);
            policeAgent.addPropertyChangeListener(driver);
            policeAgent.addPropertyChangeListener(cracksMan);
        } else {
            carrier = new Carrier();
            boss.addPropertyChangeListener(carrier);
        }
        boss.addPropertyChangeListener(driver);
        boss.addPropertyChangeListener(cracksMan);
    }

    public void startDeal() {
        boss.goRobbery();
    }
}
