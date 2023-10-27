package quizgame;

/** Indicator for the difficulty of a question */
public enum Difficulty {
    EASY,
    MEDIUM,
    HARD;

    /**
     * Example: myDifficulty = myDifficulty.increaseDifficulty();
     * // Increase the difficulty of the enum, does not exceed HARD.
     * @return New Difficulty Enum
     */
    public Difficulty increaseDifficulty() {
        switch (this) {
            case EASY:
                return MEDIUM;
            case MEDIUM:
                return HARD;
            case HARD:
                return HARD;
            default:
                throw new IllegalStateException();
        }
    }
    /**
     * Example: myDifficulty = myDifficulty.decreaseDifficulty();
     * // Decrease the difficulty of the enum, does not go below EASY.
     * @return New Difficulty Enum
     */
    public Difficulty decreaseDifficulty() {
        switch (this) {
            case EASY:
                return EASY;
            case MEDIUM:
                return EASY;
            case HARD:
                return MEDIUM;
            default:
                throw new IllegalStateException();
        }
    }
}
