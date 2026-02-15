package objects;



public class Director {

    public void makeEnglishCourse(CourseBuilder builder) {
        builder.reset();
        builder.setTimeFrame(8);
        builder.setExam(true);
        builder.setAssessment(true);
        builder.setDistant(false);
        builder.setHoursPerWeek(6);
        Course c = builder.getResult();
        c.setTitle("Английский язык");
    }

    public void makePortugueseCourse(CourseBuilder builder) {
        builder.reset();
        builder.setTimeFrame(12);
        builder.setExam(true);
        builder.setAssessment(true);
        builder.setDistant(false);
        builder.setHoursPerWeek(8);
        Course c = builder.getResult();
        c.setTitle("Португальский язык");
        System.out.println("Создан курс: " + c.getTitle() + ". Обучение(час): " + c.getHoursPerWeek() + ". Экзамен: " + c.hasExam() + ". Оценка: " + c.hasAssessment() + ". Дистант: " + c.isDistant() + ". Количество часов в неделю: " + c.getTimeFrameWeeks());
    }

    public void makeDrivingCourse(CourseBuilder builder) {
        builder.reset();
        builder.setTimeFrame(4);
        builder.setExam(false);
        builder.setAssessment(true);
        builder.setDistant(true);
        builder.setHoursPerWeek(3);
        Course c = builder.getResult();
        c.setTitle("Вождение автомобиля"); // чисто для примера работы builder паттерна
    }
}