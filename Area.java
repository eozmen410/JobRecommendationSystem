public enum Area {

    TECHNOLOGY("Technology"), FINANCE("Finance"), HEALTH("Health"), MARKETING("Marketing");

    private String string;

    Area(String name) {
        string = name;
    }

    public String toString() {
        return string;
    }
}
