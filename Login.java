public class Login {

    public static boolean candidateLogin(long ID, String password) {
        Candidate candidate = JRSSystem.getInstance().getCandidate(ID);
        if(candidate==null) return false;
        return candidate.getPassword().equals(password);
    }

    public static boolean HRlogin(long ID, String password) {
        HR hr = JRSSystem.getInstance().getHR(ID);
        if(hr==null) return  false;
        return hr.getPassword().equals(password);
    }

    public static boolean AdminLogin(long ID, String password){
        return Admin.getInstance().getID()==ID && Admin.getInstance().getPassword().equals(password);
    }

}
