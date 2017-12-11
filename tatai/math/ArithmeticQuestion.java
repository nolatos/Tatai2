package tatai.math;

/**
 * Created by olive on 6/12/2017.
 */
public class ArithmeticQuestion extends Question {

    private String expression;

    public ArithmeticQuestion(String expression, int answer) {
        super(answer);
        this.expression = expression;

    }

    public String getExpression() {
        return expression;
    }
}
