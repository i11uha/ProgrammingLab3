package objects;

// Builder.java
public interface Builder {
    void reset();
    void setTimeFrame(int weeks);
    void setExam(boolean hasExam);
    void setAssessment(boolean hasAssessment);
    void setDistant(boolean isDistant);
    void setHoursPerWeek(int hours);
}