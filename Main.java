
//add imports
import java.util.*;
import java.io.*;

class Main {//start class
  public static void main(String[] args) {//start main
    try {//start try statement 
      // File myFile = new File("acid.csv");//test case 2
      // File myFile = new File("acidBlank.csv");//test case 3
      
      File myFile = new File("acidity.csv"); // input the filename 
      Scanner myFileReader = new Scanner(myFile); //need scanner in order to read this file

      System.out.println("File name: " + myFile.getName()+" is now open"); // shows that the file exists
      System.out.println("File size in bytes " + myFile.length()); //  how big is the file
      
    if (myFileReader.hasNext() == true) { // if there is data in the file
        System.out.println("There is data to read in this file\n");
      } 
    else {
        System.out.println("Error: File is empty");//if the file exist but empty
      }
      //while loop will run untill there are no more lines to read
      while (myFileReader.hasNextLine()) {//start while loop
         String comma = myFileReader.nextLine();
         String [] data = comma.split(",");
         if(data.length==4){//makes sure 4 pieces of data are given
            String timestamp = data[0];
            double oceanCO2 = Double.parseDouble(data[1]);//must change to parse double because []data is a string
            double oceanPH = Double.parseDouble(data[2]);
            double atmosphericCO2= Double.parseDouble(data[3]);
            AcidityRecord recordAcid = new AcidityRecord(timestamp, oceanCO2,oceanPH,atmosphericCO2);//puts those variables into a constructer
           if(AcidityRecord.getCount()==1){//when count is at one will print the element there for test case 5
             System.out.println(recordAcid);
           }
          }
        }//end while loop
      
    System.out.println(AcidityRecord.getCount()+" record(s) have been read in this file"); 
    System.out.printf("%n%7s%13s%11s%11s","Date","Ocean CO2", "Ocean PH", "Atmos CO2");//prints the header
    System.out.println("\n---------------------------------------------------------");
    for(AcidityRecord Record:AcidityRecord.getAcid()){//for each record in the record array, it will print the record
      System.out.println(Record);
    } 
      System.out.println("******************************************");
      System.out.println("\n***Ocean CO2 Stats***\n");
      System.out.println("Average(First 10):"+AcidityRecord.averageOceanCO2First());
      System.out.println("Average(Last 10):"+AcidityRecord.averageOceanCO2Last());
      System.out.println("\n***Ocean PH Stats***\n");
      System.out.println("Average(First 10):"+AcidityRecord.averageOceanPHFirst());
      System.out.println("Average(Last 10):"+AcidityRecord.averageOceanPHLast());
      System.out.println("\n***Atmospheric CO2 Stats***\n");
      System.out.println("Average(First 10):"+AcidityRecord.averageAtmosphericCO2First());
      System.out.println("Average(Last 10):"+AcidityRecord.averageAtmosphericCO2Last());
      System.out.println("\n******************************************\n");
    System.out.println("Acidity.csv is now closed");
    
    }//end try statement
    
    catch (FileNotFoundException e) {
      System.out.println("in the catch");
      System.out.println("Error:");
       System.out.println("Your file does not exist");
    } // end catch
    
  }//end main
}//end class

