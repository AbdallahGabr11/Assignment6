import java.io.File;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Project {
    public static void main(String[] args){
        String s;
        if (args.length == 0) {
            System.out.println("Please provide the input file as argument");
            return;
        }
        String inputFile = args[0];
        System.out.println("for input file \""+inputFile+"\"");
        if (!inputFile.endsWith(".arxml")) {
            try {
                throw new NotVaildAutosarFileException("NotVaildAutosarFileException: Invalid ARXML file extension");
            } catch (NotVaildAutosarFileException e) {
                System.out.println(e.getMessage());
                return;
            }
        }
        File f=new File(inputFile);
        ArrayList<Arxml> arr = new ArrayList<Arxml>();
        Arxml xml=new Arxml();
        try {
            Scanner input=new Scanner(f);
            if(!input.hasNextLine())
                try {
                    throw new EmptyAutosarFileException("EmptyAutosarFileException: Input ARXML file is empty");
            } catch (EmptyAutosarFileException ex) {
                System.out.println(ex.getMessage());
                return;
            }
            while(input.hasNextLine()){
                s=input.nextLine();
                if (s.startsWith(" <CONTAINER"))
                    xml.setContainer(s.substring(s.indexOf('=')+2,s.indexOf('\"', s.indexOf('\"')+1)));
                else if(s.startsWith(" <SHORT-NAME"))
                    xml.setShortName(s.substring(s.indexOf('>')+1,s.indexOf('<', s.indexOf('>'))));
                else if (s.startsWith(" <LONG-NAME"))
                    xml.setLongName(s.substring(s.indexOf('>')+1,s.indexOf('<', s.indexOf('>'))));
                else if (s.startsWith(" </CONTAINER>")){
                        arr.add(xml);
                        xml=new Arxml();
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File Not Found");
            return;
        }
        Collections.sort(arr);
        s="";
        for(Arxml aa:arr){
            s=s+aa.toString();
        }
        String ss="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +"<AUTOSAR>\n"+s+"</AUTOSAR>";
        try {
            s=inputFile.substring(0,inputFile.indexOf('.'))+"_mod.arxml";
            FileOutputStream file=new FileOutputStream(s);
            file.write(ss.getBytes());
        } catch (FileNotFoundException ex) {
            System.out.println("File Not Found");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("Done modulation");
    }
        


}









class NotVaildAutosarFileException extends Exception {
    public NotVaildAutosarFileException(String message) {
        super(message);
    }
}

class EmptyAutosarFileException extends Exception {
    public EmptyAutosarFileException(String message) {
        super(message);
    }
}

