package events;

import objects.WorldObject;

public abstract class Activity implements WorldObject {
    private String activityName;
    private String description;
    private String crew;



    @Override
    public void setName(String activityName) {
        this.activityName = activityName;
    }

    @Override
    public String getName() {
        return activityName;
    }


    public void setDescription(String description) {
        this.description = description;

    }

    public String getDescription() {return description;}

    public void setCrew(String crew) {
        this.crew = crew;
    }

    public String getCrew() {return crew;}
}
