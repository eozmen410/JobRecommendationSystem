public class InterviewResponse {

    private Interview interview;
    private Candidate candidate;
    private boolean accepted;

    public InterviewResponse(Interview interview, Candidate candidate, boolean accepted) {
        this.interview = interview;
        this.candidate = candidate;
        this.accepted = accepted;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public Interview getInterview() {
        return interview;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public String toString() {
        String message = candidate.toString();
        if (accepted) {
            message = message + " accepted the interview request.";
        } else {
            message = message + " rejected the interview request.";
        }
        return message;
    }
}
