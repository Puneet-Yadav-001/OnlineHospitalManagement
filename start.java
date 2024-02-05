package OnlineHospitalManagement;

public class start
{
    public static void main(String[] args)
    {
        try{
            conn c = new conn();
            String m1 = "CREATE TABLE IF NOT EXISTS login(userid int, username varchar(30), password varchar(30), type varchar(10), active varchar(5))";
            String m2 = "CREATE TABLE IF NOT EXISTS patienthistory( patientid int NOT NULL AUTO_INCREMENT PRIMARY KEY, username varchar(50), fathername varchar(50), gender varchar(6), email varchar(20), phone bigint(10), password varchar(30), dob varchar(12), state varchar(30), dieasestype varchar(50), active varchar(5), joinDate varchar(12))";
            String m3 = "CREATE TABLE IF NOT EXISTS doctorhistory( doctorid int NOT NULL AUTO_INCREMENT PRIMARY KEY, username varchar(50), fathername varchar(50), gender varchar(6), email varchar(20), phone bigint(10), password varchar(30), dob varchar(12), state varchar(30), expertise varchar(50), education varchar(10), university varchar(50), experience varchar(15), active varchar(5), joinDate varchar(12))";
            String m4 = "CREATE TABLE IF NOT EXISTS workerhistory( workerid int NOT NULL AUTO_INCREMENT PRIMARY KEY, username varchar(50), fathername varchar(50), gender varchar(6), email varchar(20), phone bigint(10), password varchar(30), dob varchar(12), state varchar(30), work varchar(50), active varchar(5), joinDate varchar(12))";
            c.s.execute(m1);
            c.s.execute(m2);
            c.s.execute(m3);
            c.s.execute(m4);
        } catch (Exception e) {
            e.printStackTrace();
        }
        new basePage();
    }
}