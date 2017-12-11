package tatai.game;

import tatai.Difficulty;
import tatai.math.ArithmeticQuestion;
import tatai.math.ArithmeticQuestionFactory;
import tatai.math.Question;

import java.util.ArrayList;

/**
 * Created by olive on 6/12/2017.
 */
public class ArithmeticGame extends Game{

    private ArithmeticQuestionFactory arithmeticQuestionFactory;

    public ArithmeticGame(Difficulty difficulty, GameController controller) {
        super(difficulty, controller);

        arithmeticQuestionFactory = new ArithmeticQuestionFactory(difficulty);

        //Setting up the lists
        questionList = new ArrayList<Question>();
        for (int i = 0; i < 10; i++) {
            questionList.add(arithmeticQuestionFactory.generateQuestion());
        }



        nextQuestion();
    }

    @Override
    void nextQuestion() {
        ArithmeticQuestion arithmeticQuestion = (ArithmeticQuestion) questionList.get(progress);
//        System.out.println(arithmeticQuestion.getExpression());
        controller.displayQuestion(arithmeticQuestion.getExpression());
    }
}
