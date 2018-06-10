enum Discipline {
    JAVA,
    C_PLUS_PLUS,
    PYTHON,
    SCALA,
    C_SHARP;

    public boolean isIntMarked()
    {
        switch (this)
        {
            case JAVA:
            case SCALA:
                return true;
            default:
                return false;
        }
    }

}
