package quizgame;

public class Leaderboard {
    static User[] users;
    public Leaderboard() {
        reloadUsers();
    }

    public static void reloadUsers() {
        users = LoginManager.loadAllUsers();
    }

    public static void calculateIndividualScore(Game game) {
        
    }

    public static void calculateScores(User user) {
        user.lifetimeScore = new Score();   // Reset lifetime score
        for (Game g: user.pastGames) {
            g.score = new Score();          // Reset this games' score
            // Calc score for each game
            for (Question q: g.questions) {
                if (q.answerIndex == q.userAnswer) {
                    // correct answer given
                    g.score.score++;
                    switch (q.topic) {
                        case DISCRETE_MATHS:
                            g.score.scoreMaths++;
                            break;
                        case COMP_ORG:
                            g.score.scoreCompOrg++;
                            break;
                        case COMPUTER_SCIENCE:
                            g.score.scoreCompSci++;
                            break;
                    }
                    switch (q.difficulty) {
                        case EASY:
                            g.score.scoreEasy++;
                            break;
                        case MEDIUM:
                            g.score.scoreMedium++;
                            break;
                        case HARD:
                            g.score.scoreHard++;
                            break;
                    }
                }
            }
            // Calc lifetime score
            user.lifetimeScore.score += g.score.score;
            user.lifetimeScore.scoreMaths += g.score.scoreMaths;
            user.lifetimeScore.scoreCompOrg += g.score.scoreCompOrg;
            user.lifetimeScore.scoreCompSci += g.score.scoreCompSci;
            user.lifetimeScore.scoreEasy += g.score.scoreEasy;
            user.lifetimeScore.scoreMedium += g.score.scoreMedium;
            user.lifetimeScore.scoreHard += g.score.scoreHard;
        }
        // Accommodate for number of games played
        user.lifetimeScore.score /= user.pastGames.size();
        user.lifetimeScore.scoreMaths /= user.pastGames.size();
        user.lifetimeScore.scoreCompOrg /= user.pastGames.size();
        user.lifetimeScore.scoreCompSci /= user.pastGames.size();
        user.lifetimeScore.scoreEasy /= user.pastGames.size();
        user.lifetimeScore.scoreMedium /= user.pastGames.size();
        user.lifetimeScore.scoreHard /= user.pastGames.size();
    }

    public static User[] getTopThree() {
        // Clone users, sort them with bubblesort according 
        // to their lifetime score and return the top three
        User[] topUsers = users.clone();

        User swap;
        for (int i = 0; i < topUsers.length - 1; i++) {
            for (int j = 0; j < topUsers.length - 1 - i; j++) {
                if (topUsers[i].lifetimeScore.score < topUsers[i + 1].lifetimeScore.score) {
                    swap = topUsers[i];
                    topUsers[i] = topUsers[i + 1];
                    topUsers[i + 1] = swap;
                }
            }
        }

        // TODO: handle check if theres less than 3 registered users
        return new User[]{topUsers[0], topUsers[1], topUsers[2]};
    }

    public void calc() {
        for (User u: users) {
            System.out.println("\t" + u.username);
            for (Question q: u.pastGames.get(u.pastGames.size() - 1).questions) {
                System.out.print(q.question + "\t");
                System.out.println(q.answerIndex == q.userAnswer);
            }
        }
    }

    public static void main(String[] args) {

        System.out.println("===================================");
        User a = LoginManager.loadUser("test");

        System.out.println("Number of past games: " + a.pastGames.size());

        for (Game g: a.pastGames) {
            System.out.println("Game");
            if (g == null) {System.out.println("Game is null");}
            if (g.questions == null) {System.out.println("Quesitons are null");}
            if (g.questions[0] == null) {System.out.println("First question is null");}
            if (g.questions[0].question == null) {System.out.println("First questions \"question\" data is null");}
            for (Question q: g.questions) {
                System.out.println("\t" + q.question);
            }
        }

        System.out.println("First question: " + a.pastGames.get(0).questions[1].question);
        // calculateScores(a);

        System.out.println("===================================");

        reloadUsers();


        for (User u: users) {
            calculateScores(u);
            System.out.println("user: " + u.username);
            System.out.println(" - gamesplayed: " + u.pastGames.size());
        }
        User[] topThreeUsers = getTopThree();
        System.out.println(topThreeUsers[2].username);

        for (User u: topThreeUsers) {
            System.out.println("1st: " + u.username);
        }
    }
}
