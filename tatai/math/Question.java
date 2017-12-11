package tatai.math;

/**
 * Created by olive on 6/12/2017.
 */
public abstract class Question {

    private int answer;
    private int recognised; //The number which the user inputted

    public Question(int answer) {
        this.answer = answer;
    }

    /**
     * Returns the answer
     * @return
     */
    public int getAnswer() {
        return answer;
    }

    public void setRecognised(int recognised) {
        this.recognised = recognised;
    }

    public boolean checkCorrect() {
        return answer == recognised;
    }
}
