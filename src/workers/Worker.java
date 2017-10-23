package workers;

public abstract class Worker {
    private String name;
    private String surName;
    public String getName ( ) {
        return name;
    }
    public Worker(String name, String surname) {
        this.name = name;
        this.surName = surname;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public String getSurName ( ) {
        return surName;
    }

    public void setSurName ( String surName ) {
        this.surName = surName;
    }
    public String getWorkerInfo() {
        return this.getSurName () + ": " + calcWage();
    }

    public abstract double calcWage();
}
