public class MVC {
    public static void main(String[] args) {
        JRSVC vc = new JRSVC();
        JRSSystem system = JRSSystem.getInstance();
        Candidate c = new Candidate( "Joe", null, Area.TECHNOLOGY, "joe98" );
        system.saveCandidate(c);
        vc.setVisible(true);
        vc.run();
    }
}
