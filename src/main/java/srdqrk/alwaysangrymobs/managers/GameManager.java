package srdqrk.alwaysangrymobs.managers;

public class GameManager {
    public boolean angryPigman;
    public boolean angryGolem;
    public boolean angryWolf;
    public boolean allAngry;
    public static GameManager instace;
    public boolean angryBee;
    public boolean angryDolphin;
    public boolean angryPolarBear;
    public boolean angryPanda;

    public boolean isAllAngry() {
        return allAngry;
    }

    /**
     * NOTE FOR ME: REMEMBER CHANGE THE CONSTRUCTOR TO FALSE PLS, IS TRUE TO WITHERING SOULS
     * @param allAngry
     */

    public void setAllAngry(boolean allAngry) {
        this.allAngry = allAngry;
    }

    public boolean isAngryBee() {
        return angryBee;
    }

    public void setAngryBee(boolean angryBee) {
        this.angryBee = angryBee;
    }

    public boolean isAngryDolphin() {
        return angryDolphin;
    }

    public void setAngryDolphin(boolean angryDolphin) {
        this.angryDolphin = angryDolphin;
    }

    public boolean isAngryPolarBear() {
        return angryPolarBear;
    }

    public void setAngryPolarBear(boolean angryPolarBear) {
        this.angryPolarBear = angryPolarBear;
    }

    public boolean isAngryPanda() {
        return angryPanda;
    }

    public void setAngryPanda(boolean angryPanda) {
        this.angryPanda = angryPanda;
    }

    public GameManager() {
        this.angryPigman = true;
        this.angryGolem = true;
        this.angryWolf = true;
        this.allAngry = true;
        this.angryBee = true;
        this.angryDolphin = true;
        this.angryPanda = true;
        this.angryPolarBear = true;
    }

    public boolean isAngryPigman() {
        return angryPigman;
    }

    public void setAngryPigman(boolean angryPigman) {
        this.angryPigman = angryPigman;
    }

    public boolean isAngryGolem() {
        return angryGolem;
    }

    public void setAngryGolem(boolean angryGolem) {
        this.angryGolem = angryGolem;
    }

    public boolean isAngryWolf() {
        return angryWolf;
    }

    public void setAngryWolf(boolean angryWolf) {
        this.angryWolf = angryWolf;
    }

    public static GameManager getInstance(){
        if (instace == null){
            instace = new GameManager();
        }
        return instace;
    }
}
