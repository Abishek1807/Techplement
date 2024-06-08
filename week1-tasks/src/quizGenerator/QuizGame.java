package quizGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuizGame {
    public static void main(String[] args) {
        quizGame();
    }

    public static void quizGame(){
        Scanner in = new Scanner(System.in);

        // Adding QuestionAndAnswers object to the List for generating questions to the user and validate answers
        List<QuestionAndAnswer> qes = new ArrayList<>();
        qes.add(new QuestionAndAnswer("What is the capital of France?", new String[]{"1. Berlin", "2. Paris", "3. Madrid", "4. Rome"}, 1));
        qes.add(new QuestionAndAnswer("Which language is primarily used for web development?",new String[]{"1. Python", "2. Java", "3. JavaScript", "4. C++"}, 2));
        qes.add(new QuestionAndAnswer("Which planet is known as the Red Planet?", new String[]{"1. Earth", "2. Mars", "3. Jupiter", "4. Venus"}, 1));
        qes.add(new QuestionAndAnswer("Who wrote the play 'Romeo and Juliet'?", new String[]{"1. Mark Twain", "2. William Shakespeare", "3. Charles Dickens", "4. J.K. Rowling"}, 1));
        qes.add(new QuestionAndAnswer("What is the largest ocean on Earth?", new String[]{"1. Atlantic Ocean", "2. Indian Ocean", "3. Arctic Ocean", "4. Pacific Ocean"}, 3));
        qes.add(new QuestionAndAnswer("What is the capital of Japan?", new String[]{"1. Seoul", "2. Beijing", "3. Tokyo", "4. Bangkok"}, 2));
        qes.add(new QuestionAndAnswer("Which planet is known as the Red Planet?", new String[]{"1. Earth", "2. Mars", "3. Jupiter", "4. Venus"}, 1));
        qes.add(new QuestionAndAnswer("Who wrote the play 'Romeo and Juliet'?", new String[]{"1. Mark Twain", "2. William Shakespeare", "3. Charles Dickens", "4. J.K. Rowling"}, 1));
        qes.add(new QuestionAndAnswer("What is the largest ocean on Earth?", new String[]{"1. Atlantic Ocean", "2. Indian Ocean", "3. Arctic Ocean", "4. Pacific Ocean"}, 3));
        qes.add(new QuestionAndAnswer("What is the chemical symbol for gold?", new String[]{"1. Au", "2. Ag", "3. Gd", "4. Go"}, 0));

        // Initially score is set to Zero, with every correct answer score is increased by 1
        int score = 0;
        System.out.println("Do you want to add question or take Quiz?");
        System.out.print("To add question press 1 and to take Quiz press 2: ");
        int userAction = in.nextInt();
        if (userAction != 1 && userAction != 2){
            System.out.println("You can only choose between 1 or 2, you chose " + userAction);
        }
        switch (userAction) {
            case 1 -> {
                // New QuestionAndAnswer object have been created using addUserQuestion method and added to the master list
                QuestionAndAnswer newQnA = addUserQuestion();
                System.out.println();

                qes.add(newQnA);
                System.out.println("Your question have been added successfully!");
            }
            case 2 -> {
                System.out.println("You have chosen to take quiz! Its time to test your GK");
                System.out.println();
                System.out.println("You will be asked max 10 questions, if your answer is correct your score will increase by 1");
                System.out.println("You are just required to select the option number, anything else will not be considered!");
                System.out.println();
                System.out.println("You can quit at any time by entering 'Quit'");
                System.out.println();

                // Iterating through the QuestionAndAnswer object to fetch questions, options and correct answers
                for (QuestionAndAnswer qa : qes){
                    // Printing the Question
                    System.out.println(qa.getQuestion());
                    // Printing the options
                    for (String option : qa.getOptions()){
                        System.out.println(option);
                    }

                    System.out.println();
                    System.out.print("Select your option: ");
                    // Getting user answer option
                    int opt = in.nextInt();
                    // Validation correctness of the question
                    if (qa.isCorrectAnswer((opt-1))){
                        score++;
                        System.out.println("You are correct!");
                        System.out.println();
                    }  else {
                        // Printing a message to indicate the selected answer iis incorrect and displaying the correct answer
                        System.out.println("Sorry! You are incorrect! Correct answer is "+ qa.getOptions()[qa.getCrtIndex()] + ".");
                    }
                    // Check if user want to continue the game or quit
                    if (!wannaContinueTheQuiz()){
                        // If wanted to quit, Breaking the loop here
                        break;
                    }
                    System.out.println();
                }
                // When user decides to Quit the game / at the end of 10 questions - A thanks message and their score is printed
                System.out.println("Thanks for playing. Your score: " + score);
            }
        }
    }
    public static boolean wannaContinueTheQuiz(){
        System.out.println();
        Scanner in = new Scanner(System.in);
        System.out.print("'Yes' to continue and 'Quit' to close and view score: ");
        String cont = in.next();
        return !cont.equals("quit") && !cont.equals("Quit") && !cont.equals("QUIT");
    }
    public static QuestionAndAnswer addUserQuestion(){
        Scanner in = new Scanner(System.in);
        System.out.println("You have chosen to add a question!");
        System.out.println("You are required to give us a question, 4 options and the correct answer among the options");
        System.out.println();
        System.out.print("Please type your question here: ");
        String userQuestion = in.nextLine();
        System.out.println();
        System.out.print("Give your option 1 here: ");
        String userOption1 = in.nextLine();
        System.out.println();
        System.out.print("Give your option 1 here: ");
        String userOption2 = in.nextLine();
        System.out.println();
        System.out.print("Give your option 1 here: ");
        String userOption3 = in.nextLine();
        System.out.println();
        System.out.print("Give your option 1 here: ");
        String userOption4 = in.nextLine();
        System.out.println();
        System.out.print("What is the correct answer: ");
        int userCrtAnswer = in.nextInt();
        System.out.println();

        return new QuestionAndAnswer(userQuestion, new String[] {"1."+userOption1,"2. "+userOption2,"3. "+userOption3,"4. "+userOption4}, userCrtAnswer);
    }

}
