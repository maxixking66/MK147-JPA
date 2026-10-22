package ir.maktabsharif.jpa.entities.enums;

public enum Grade implements Test {
    VERY_GOOD(100) {
        public Integer getNumericLevel() {
            return 10;
        }
    },
    VERY_BAD(-100) {
        public Integer getNumericLevel() {
            return -10;
        }
    },
    BAD(0) {
        public Integer getNumericLevel() {
            return 5;
        }
    },
    GOOD(50) {
    };

    private final int level;

    Grade(int level) {
        this.level = level;
    }

    public Integer getNumericLevel() {
        return this.level;
    }

}

interface Test {
    Integer getNumericLevel();
}
