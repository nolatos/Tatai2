package tatai.math;

/**
 * Created by olive on 6/12/2017.
 */
public abstract class Question {

    private int answer;

    public Question(int answer) {
        this.answer = answer;
    }

    public int getAnswer() {
        return answer;
    }
}
