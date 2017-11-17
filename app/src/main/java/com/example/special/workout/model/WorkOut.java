package com.example.special.workout.model;

/**
 * Created by Special on 2017/11/16.
 */

public class WorkOut {
    private String name;
    private String descripition;
    public static final WorkOut[] workOuts = {
            new WorkOut("The Limb Loosener",
                    "5 Handstand push-ups\n10 1-legged squats\n15 Pull-ups"),
            new WorkOut("Core Agony",
                    "100 Pull-ups\n100 Push-ups\n100 Sit-ups\n100 Squats"),
            new WorkOut("The Wimp Special",
                    "5 Pull-ups\n10 Push-ups\n15 Squats"),
            new WorkOut("Strength and Length",
                    "500 meter run\n21 x 1.5 pood kettleball swing\n21 x pull-ups")
    };

    private WorkOut(String name, String descripition){
        this.name = name;
        this.descripition = descripition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescripition() {
        return descripition;
    }

    public void setDescripition(String descripition) {
        this.descripition = descripition;
    }
}
