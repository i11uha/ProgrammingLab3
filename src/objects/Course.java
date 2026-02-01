package objects;


public class Course {
    private String title;
    private int timeFrameWeeks;
    private boolean hasExam;
    private boolean hasAssessment;
    private boolean isDistant;
    private int hoursPerWeek;


    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public int getTimeFrameWeeks() { return timeFrameWeeks; }
    public void setTimeFrameWeeks(int weeks) { this.timeFrameWeeks = weeks; }
    public boolean hasExam() { return hasExam; }
    public void setHasExam(boolean hasExam) { this.hasExam = hasExam; }
    public boolean hasAssessment() { return hasAssessment; }
    public void setHasAssessment(boolean hasAssessment) { this.hasAssessment = hasAssessment; }
    public boolean isDistant() { return isDistant; }
    public void setDistant(boolean distant) { isDistant = distant; }
    public int getHoursPerWeek() { return hoursPerWeek; }
    public void setHoursPerWeek(int hours) { this.hoursPerWeek = hours; }

    @Override
    public String toString() {
        return "Course{" +
                "title='" + title + '\'' +
                ", weeks=" + timeFrameWeeks +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course c)) return false;
        return timeFrameWeeks == c.timeFrameWeeks &&
                hasExam == c.hasExam &&
                hasAssessment == c.hasAssessment &&
                isDistant == c.isDistant &&
                hoursPerWeek == c.hoursPerWeek &&
                java.util.Objects.equals(title, c.title);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(title, timeFrameWeeks, hasExam, hasAssessment, isDistant, hoursPerWeek);
    }
}