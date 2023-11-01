package quizgame;

public class Leaderboard {
    static User[] users;
    public Leaderboard() {
        reloadUsers();
    }

    public static void reloadUsers() {
        users = LoginManager.loadAllUsers();
    }

    public static void calculateScores(User user) {
        for (Game g: user.pastGames) {
            g.score = new Score();
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
    }

    public static User[] getTopThree() {
        User[] topThree = new User[]{
            users[0],
            users[1],
            users[2],
        };
        for (User u: Leaderboard.users) {
            for (int i = 0; i < topThree.length; i++) {
                if (u.lifetimeScore.score > topThree[i].lifetimeScore.score) {
                    topThree[i] = u;
                    System.out.println(u.username);
                }
            }
        }
        return topThree;
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
        // Leaderboard lead = new Leaderboard();
        // lead.calc();
        reloadUsers();
        System.out.println(users.length);
        for (User u: users) {
            calculateScores(null);
            System.out.println(u.username);
        }
        User[] topThreeUsers = getTopThree();
        System.out.println(topThreeUsers[2].username);

        for (User u: topThreeUsers) {
            System.out.println(topThreeUsers.length);
            System.out.println("1st" + u.password_hash);
        }
    }
}
