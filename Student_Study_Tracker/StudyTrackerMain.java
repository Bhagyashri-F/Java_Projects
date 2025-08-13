import java.util.*;
import java.time.LocalDate;
import java.io.*;

//DONE
class StudyLog
{
    public LocalDate Date;
    public String Subject;
    public double Duration;
    public String Description;

    public StudyLog(LocalDate A, String B, double C, String D)
    {
        this.Date = A;
        this.Subject = B;
        this.Duration = C;
        this.Description = D;
    }

    @Override
    public String toString()
    {
        return Date + " | " + Subject + " | " + Duration + " | " + Description;
    }

    //Getter method
    public LocalDate getDate()
    {
        return Date;
    }

    public String getSubject()
    {
        return Subject;
    }

    public double getDuration()
    {
        return Duration;
    }

    public String getDescription()
    {
        return Description;
    }
}

class StudyTracker
{
    //Data structure used to hold the data about study
    private ArrayList <StudyLog> Database = new ArrayList <StudyLog>();

    public void InsertLog()
    {
        Scanner ScannerObj = new Scanner(System.in);

        System.out.println("--------------------------------------------------------------");
        System.out.println("---------Please enter the valid details of your study---------");
        System.out.println("--------------------------------------------------------------");

        LocalDate DateObj = LocalDate.now();

        System.out.println("Please provide the name of subject like C/C++/Java/OS/DS");
        String sub = ScannerObj.nextLine();

        System.out.println("Enter the time period of your in hours");
        double dur = ScannerObj.nextDouble();
        ScannerObj.nextLine();  //It is used as flush

        System.out.println("Please provide the description about the study for future refernce");
        String desc = ScannerObj.nextLine();

        StudyLog StudyObj = new StudyLog(DateObj, sub, dur, desc);

        Database.add(StudyObj);

        System.out.println("Study Log gets stored successfully");
        System.out.println("--------------------------------------------------------------");
    }

    public void DisplayLog()
    {
        System.out.println("--------------------------------------------------------------");
        if(Database.isEmpty())
        {
            System.out.println("Nothing to display as database is empty");
            System.out.println("--------------------------------------------------------------");
            return;
        }

        System.out.println("--------------------------------------------------------------");
        System.out.println("-----------Log Report from Marvellous Study Tracker-----------");
        System.out.println("--------------------------------------------------------------");

        for(StudyLog sobj : Database)
        {
            System.out.println(sobj);
        }
        System.out.println("--------------------------------------------------------------");
    }

    public void ExportCSV()
    {
        if(Database.isEmpty())
        {
            System.out.println("Nothing to Export as database is empty");
            System.out.println("--------------------------------------------------------------");
            return;
        }

        String FileName = "MarvellousStudy.csv";

        // this line means deallocate all resorces allocated for this line
        try(FileWriter fwobj = new FileWriter(FileName))  
        {
            //Write CSV header
            fwobj.write("Date, Subject, Duration, Description\n");

            //Travel Database
            for(StudyLog sobj : Database)
            {
                //Write each record in CSV
                fwobj.write(sobj.getDate() + "," +
                    sobj.getSubject().replace(","," ") + "," + 
                    sobj.getDuration() + "," +
                    sobj.getDescription().replace(","," ") + "\n"
                );
            }

            System.out.println("Log Created Successfully");
        }
        catch(Exception eobj)
        {
            System.out.println("Exception Occured while creating the CSV.");
            System.out.println("Report this issue to Marvellous Infosystems");
        }
    }

    public void SummaryByDate()
    {
        System.out.println("--------------------------------------------------------------");
        if(Database.isEmpty())
        {
            System.out.println("Nothing to display as database is empty");
            System.out.println("--------------------------------------------------------------");
            return;
        }

        System.out.println("--------------------------------------------------------------");
        System.out.println("---------Summary By Date From Marvellous Study Tracker---------");
        System.out.println("--------------------------------------------------------------");

        TreeMap <LocalDate, Double> tobj = new TreeMap <LocalDate, Double> ();

        LocalDate lobj = null;
        double d, old;

        for(StudyLog sobj : Database)
        {
            lobj = sobj.getDate();
            d = sobj.getDuration();

            if(tobj.containsKey(lobj))
            {
                old = tobj.get(lobj);
                tobj.put(lobj, d + old);
            }
            else
            {
                tobj.put(lobj, d);
            }
        }

        //Display the details as per date

        for(LocalDate ldobj : tobj.keySet())
        {
            System.out.println("Date : " + ldobj + " Total Study " + tobj.get(ldobj));
        }

        System.out.println("--------------------------------------------------------------");
    }

    public void SummaryBySubject()
    {
        System.out.println("--------------------------------------------------------------");
        if(Database.isEmpty())
        {
            System.out.println("Nothing to display as database is empty");
            System.out.println("--------------------------------------------------------------");
            return;
        }

        System.out.println("--------------------------------------------------------------");
        System.out.println("---------Summary By Subject From Marvellous Study Tracker---------");
        System.out.println("--------------------------------------------------------------");

        TreeMap <String, Double> tobj = new TreeMap <String, Double> ();

        double d, old;
        String s;

        for(StudyLog sobj : Database)
        {
            s = sobj.getSubject();
            d = sobj.getDuration();

            if(tobj.containsKey(s))
            {
                old = tobj.get(s);
                tobj.put(s, d + old);
            }
            else
            {
                tobj.put(s, d);
            }
        }

        //Display the details as per subject

        for(String str : tobj.keySet())
        {
            System.out.println("Subject : " + str + " Total Study " + tobj.get(str));
        }

        System.out.println("--------------------------------------------------------------");
    }
}

class StudyTrackerMain  //StudyTrackerStarter
{
    public static void main(String A[])
    {
        StudyTracker stobj = new StudyTracker();

        Scanner ScannerObj = new Scanner(System.in);

        int iChoice = 0;

        System.out.println("--------------------------------------------------------------");
        System.out.println("-------Welcome To Marvellous Study Tracker Application--------");
        System.out.println("--------------------------------------------------------------");

        do
        {
            System.out.println("Please select the appropriate option");
            System.out.println("1 : Insert New Study Log in Databese");
            System.out.println("2 : View All Study Logs");
            System.out.println("3 : Summary of Study Log by Date");
            System.out.println("4 : Summary of Study Log by Subject");
            System.out.println("5 : Export Study Log to CSV file");
            System.out.println("6 : Exit the Application");

            iChoice = ScannerObj.nextInt();

            switch(iChoice)
            {
                case 1:         //Insert New Study Log in Databese
                    stobj.InsertLog();
                    break;
                
                case 2:         //View All Study Logs
                    stobj.DisplayLog();
                    break;

                case 3:         //Summary of Study Log by Date
                    stobj.SummaryByDate();
                    break;

                case 4:         //Summary of Study Log by Subject
                    stobj.SummaryBySubject();
                    break;

                case 5:         //Export Study Log to CSV file
                    stobj.ExportCSV();
                    break;

                case 6:         //Exit the Application
                    System.out.println("--------------------------------------------------------------");
                    System.out.println("Thank You for using Marvellous Study Log Application");
                    System.out.println("--------------------------------------------------------------");
                    break;

                default:
                    System.out.println("Please enter the valid option");
            }
        }while(iChoice != 6);
    }
}