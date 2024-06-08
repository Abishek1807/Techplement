package quizGenerator;

public class QuestionAndAnswer {
    String question;
    String[] options;
    int crtIndex;

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCrtIndex() {
        return crtIndex;
    }

    public boolean isCorrectAnswer(int userAnswerIndex) {
        return userAnswerIndex == crtIndex;
    }

    public QuestionAndAnswer(String question, String[] options, int crtIndex) {
        this.question = question;
        this.options = options;
        this.crtIndex = crtIndex;
    }
}
