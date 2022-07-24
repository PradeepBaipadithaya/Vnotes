package com.vnotesvtu.vnotes;

public class sem {
    int sem;
    String sem_name;

    public sem(int sem, String sem_name) {
        this.sem = sem;
        this.sem_name = sem_name;
    }

    public int getSem() {
        return sem;
    }

    public void setSem(int sem) {
        this.sem = sem;
    }

    public String getSem_name() {
        return sem_name;
    }

    public void setSem_name(String sem_name) {
        this.sem_name = sem_name;
    }
}
