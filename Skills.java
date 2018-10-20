public enum Skills {
    PUBLIC_SPEAKING("Public Speaking"), PROGRAMMING("Programming"), MICROSOFT_OFFICE("Microsoft Office"),
    MARKETING("Marketing");

    private String string;

    Skills(String skillString) {
        string = skillString;
    }

    public String toString() {
        return string;
    }
}
