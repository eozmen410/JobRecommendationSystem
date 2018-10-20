import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {

    public static Map<Long, Candidate> readCandidateMap(String fileName) throws FileNotFoundException {
        File input = new File(fileName);
        Scanner reader = new Scanner(input);
        Map<Long, Candidate> map = new Map<>();
        while(reader.hasNext()) {
            Candidate candidate = readCandidate(reader);
            map.put(candidate.getID(), candidate);
        }
        return map;
    }

    private static Candidate readCandidate(Scanner reader) {
        long id = -1;
        String name = "";
        String identifier = reader.next();
        if(identifier.equals("ID")) {
            id = Long.parseLong(reader.next());
        }
        identifier = reader.next();
        if(identifier.equals("Name")) {
            name = reader.next();
        }
        identifier = reader.next();
        ArrayList<Skills> skills = new ArrayList<>();
        if(identifier.equals("KeySkills")) {
            while(!reader.next().equals("Area")){
                skills.add(Skills.valueOf(reader.next()));
            }
        }
        identifier = reader.next();
        Area area = null;
        if(identifier.equals("Area")){
            area = Area.valueOf(reader.next());
        }
        identifier = reader.next();
        String password = "";
        if(identifier.equals("Password")) {
            password = reader.next();
        }
        return null; //new Candidate(id, name, skills, area, interviewQueue, appQueue, password);
    }

    //private static Interview readInterview(Scanner reader, Candidate candidate) {

//    }//




}
