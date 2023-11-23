package quizgame.question;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class QuestionGetter {

    public static Question[] questions;

    public static void loadQuestions() {
        loadQuestions("data/questions.csv");
    }

    public static void loadQuestions(String fileName) {
        Scanner file;
        // Bad code that attempts to find which file we are editing
        try {
            file = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            try {
                file = new Scanner(new File("data/questions.csv"));
            } catch (FileNotFoundException e1) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                e1.printStackTrace();
                return;
            }
        }
        file.useDelimiter(",");
        /*
         * I have spent seven days trying to make this work but no matter what i do, csv
         * has decidede i should go fuck myself
         * please explain why scanner is unable to split at both line ends and
         * semicolons
         */
        for (int i = 0; i < 8; i++) {
            file.next(); // Remove file header
        }
        List<Question> data = new ArrayList<Question>();

        while (file.hasNext()) {
            // This disgusting line converts each line in the csv file into question classes
            data.add(new Question(
                    file.next().substring(1),
                    new String[] {
                            file.next(),
                            file.next(),
                            file.next(),
                            file.next()
                    },
                    Integer.parseInt(file.next()),
                    Topic.values()[Integer.parseInt(file.next())],
                    Difficulty.values()[Integer.parseInt(file.next())]));
        }
        questions = data.toArray(new Question[data.size()]);
    }

    /**
     * Retrieve an array of all available questions
     * 
     * @return Question array of all loaded questions
     */
    public static Question[] getAllQuestions() {
        return questions;
    }

    /**
     * Retrieve all questions that match the given filters
     * 
     * @param filters Parse all questions that match filters such as Difficuly and
     *                Topic Enums
     * @return All questions that match given filters
     */
    public static Question[] getAllQuestionsByFilter(Filter... filters) {
        // This seems very inefficient
        // Go through every question, if one of the filters doesn't match the question,
        // remove the question
        List<Question> filteredQuestions = new ArrayList<Question>(Arrays.asList(questions));
        // Dont iterate over filteredQuestions as we will be modifing it
        for (Question q : questions) {
            for (Filter filter : filters) {
                if (!((q.topic == filter) || (q.difficulty == filter))) {
                    filteredQuestions.remove(q);
                }
            }
        }
        // Convert ArrayList to Array
        Question[] filteredQuestionsArray = filteredQuestions.toArray(new Question[filteredQuestions.size()]);
        return filteredQuestionsArray;
    }

    /**
     * Get single random question from the entire question bank
     * 
     * @return Single random question
     */
    public static Question getRandomQuestion() {
        return questions[(int) (Math.random() * questions.length)];
    }

    /**
     * Get single random question that matches given filters from the entire
     * question bank
     * 
     * @param filters Parse all questions that match filters such as Difficuly and
     *                Topic Enums
     * @return Single random Question that match all given filters
     */
    public static Question getRandomQuestionByFilter(Filter... filters) {
        Question[] filterQuestions = getAllQuestionsByFilter(filters);
        return filterQuestions[(int) (Math.random() * (filterQuestions.length))];
    }

    // This main function should never be run in production
    // It is for debug purposes only
    public static void main(String[] args) {
        // specific_subject_random_game(Topic.COMPUTER_SCIENCE);
        // getRandomQuestion();

        // Question q = new Question("How many legs does a dog have?", new
        // String[]{"2","4","7","5"}, 1, Topic.COMP_ORG, Difficulty.EASY);
        // q.print();

        // Question[] qs = getAllQuestionsByFilter(Topic.COMPUTER_SCIENCE);
        // System.out.println(java.util.Arrays.toString(qs));
        // System.out.println(qs.length);
        loadQuestions();
        // for (Question q: questions) {
        // q.print();
        // }
        Filter f = Difficulty.EASY;
        Filter f1 = Topic.COMPUTER_SCIENCE;
        Question[] qs = getAllQuestionsByFilter(f, f1);
        for (Question q : qs) {
            System.out.println(q.question.substring(0, 10) + "...\t" + q.topic + "\t" + q.difficulty);
        }

    }

}
