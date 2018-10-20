import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;

public class Resume {

    private String fileName;
    private File resumeFile;
    private Date date;

    public Resume(String fileName)  throws FileNotFoundException {
        resumeFile = new File(fileName);
        date = new Date();
    }

    public File getResumeFile() {
        return resumeFile;
    }

    public Date getDate() {
        return date;
    }
}
