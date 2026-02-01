package objects;

public class CourseBuilder implements Builder {
    private Course course;

    public CourseBuilder() {
        this.course = new Course();
    }

    @Override
    public void reset() {
        this.course = new Course();
    }

    @Override
    public void setTimeFrame(int weeks) {
        course.setTimeFrameWeeks(weeks);
    }

    @Override
    public void setExam(boolean hasExam) {
        course.setHasExam(hasExam);
    }

    @Override
    public void setAssessment(boolean hasAssessment) {
        course.setHasAssessment(hasAssessment);
    }

    @Override
    public void setDistant(boolean isDistant) {
        course.setDistant(isDistant);
    }

    @Override
    public void setHoursPerWeek(int hours) {
        course.setHoursPerWeek(hours);
    }

    public Course getResult() {
        return course;
    }
}