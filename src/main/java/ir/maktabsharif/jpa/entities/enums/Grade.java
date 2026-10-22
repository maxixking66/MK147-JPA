package ir.maktabsharif.jpa.entities.enums;

public enum Grade {
    VERY_GOOD, VERY_BAD, BAD, GOOD;

    public Integer getNumericLevel() {
        return switch (this) {
            case VERY_GOOD -> 10;
            case VERY_BAD -> 0;
            case BAD -> 3;
            case GOOD -> 7;
        };
    }
}
