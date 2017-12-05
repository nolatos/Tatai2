package tatai.math;

import tatai.Difficulty;

/**
 * Created by olive on 6/12/2017.
 */
public class ArithmeticQuestionFactory implements QuestionFactory {

    private final static String MULTIPLICATION_SYMBOL = "�";
    private final static String DIVISION_SYMBOL = "�";
    private final static String ADDITION_SYMBOL = "+";
    private final static String SUBTRACTION_SYMBOL = "-";

    private Difficulty difficulty;

    @Override
    /**
     * Generates a Question based on the difficulty
     */
    public Question generateQuestion() {
        int answer = (int) (99 * Math.random());
        answer = filterAnswer(answer);
        String str;
        double probability = Math.random();
        switch (difficulty) {
            case EASY:
                if (probability < 0.5) {
                    //Addition
                    int number1 = (int)(answer * Math.random());
                    int number2 = answer - number1;
                    str =  "" + number1 + " " + ADDITION_SYMBOL + " " + number2;
                }
                else  {
                    //Subtraction
                    int number1 = (int) (150 * Math.random());
                    int number2 = number1 + answer;
                    str = "" + number2 + " " + SUBTRACTION_SYMBOL + " " + number1;
                }
            case MEDIUM:
                if (probability < 0.25) {
                    //Addition
                    int number1 = (int)(answer * Math.random());
                    int number2 = answer - number1;
                    str =  "" + number1 + " " + ADDITION_SYMBOL + " " + number2;
                }
                else if (probability < 0.5) {
                    //Subtraction
                    int number1 = (int) (150 * Math.random());
                    int number2 = number1 + answer;
                    str = "" + number2 + " " + SUBTRACTION_SYMBOL + " " + number1;
                }
                else if (probability < 0.75) {
                    //Multiplication
                    int number1 = (int) (20 * Math.random());

                    //Making sure we don't divide by zero
                    if (number1 <= 0) {
                        number1 = 1;
                    }

                    int number2 = (int) ((99 / number1 - 1) * Math.random());

                    if (number2 <= 0) {
                        number2 = 1;
                    }

                    answer = number1 * number2;
                    str = "" + number1 + " " + MULTIPLICATION_SYMBOL + " " + number2;
                }
                else {

                    //Division
                    int number1 = (int) ((300 / answer) * Math.random());

                    //Make sure we don't divide by zero
                    if (number1 == 0) {
                        number1 = 1;
                    }
                    int number2 = number1 * answer;
                    str = "" + number2 + " " + DIVISION_SYMBOL + " " + number1;
                }
            default:
                answer = 3;
                str = "hi";
        }
        ArithmeticQuestion question = new ArithmeticQuestion(str, answer);
        return question;
    }

    /**
     * Constructor takes in  adifficultys
     * @param difficulty
     */
    public ArithmeticQuestionFactory(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    /**
     * Filters the answer so it is between 1 and 99 inclusive
     */
    private int filterAnswer(int answer) {
        if (answer <= 0) {
            answer = 1;
        }

        if (answer >= 100) {
            answer = 99;
        }

        return answer;
    }
}
