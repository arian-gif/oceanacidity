//get import
import java.util.*;

public class AcidityRecord{//start class
  //create the instance variables
  private String timestamp;
  private double oceanCO2;
  private double oceanPH;
  private double atmosphericCO2;
  //get a static counter
  private static int acidCount;
  //create arraylist
  private static ArrayList<AcidityRecord> Acid = new ArrayList<AcidityRecord>();
  
  public AcidityRecord(String time, double CO2Ocean,double phOcean,double CO2Atmospheric){//get constructer
    this.timestamp = time;
    this.oceanCO2 = CO2Ocean;
    this.oceanPH = phOcean;
    this.atmosphericCO2 = CO2Atmospheric;
    acidCount++;
    Acid.add(this);    
  }
  public String getTimestamp(){
    return this.timestamp;//gets the timestamp
  }
  public double getOceanCO2(){
    return this.oceanCO2;//gets ocean CO2
  }
  public double getOceanPH(){
    return this.oceanPH;//gets Ocean PH
  }
  public double getAtmosphericCO2(){
    return this.atmosphericCO2;//get atmospheric CO2
  }
  public static int getCount(){
    return acidCount;//gets the object count, need this since it's private
  }
  public static ArrayList<AcidityRecord> getAcid(){
    return Acid;//private arraylist so need to access it with this
  }
  public static double averageOceanCO2First(){
    //first 10 elements added
    double totalOceanCO2=0;
      for(int i=0;i<10;i++){
        totalOceanCO2 += Acid.get(i).getOceanCO2();//acid at the index of i is added to total 
      }
    return totalOceanCO2/10;//must divide by 10 because we are getting an average
  }
  public static double averageOceanPHFirst(){
    double totalOceanPH=0;
      for(int i=0;i<10;i++){
        totalOceanPH += Acid.get(i).getOceanPH();//acid at the index of i is added to total 
      }
    return totalOceanPH/10;
  }
   public static double averageAtmosphericCO2First(){
    double totalAtmosphericCO2=0;
      for(int i=0;i<10;i++){
        totalAtmosphericCO2+= Acid.get(i).getAtmosphericCO2();//acid at the index of i is added to total 
      }
    return totalAtmosphericCO2/10;
  }
   public static double averageOceanCO2Last(){
    double finalOceanCO2=0;
    int initialSize = Acid.size();//wouldn't create an inifinite loop but used for good practice
      for(int i=initialSize-10;i<initialSize;i++){//starts 10 less than the initial size of array goes untill the size of array
        finalOceanCO2 += Acid.get(i).getOceanCO2();//adds the last ten because of i's placement
      }
    return finalOceanCO2/10;
  }
  public static double averageOceanPHLast(){
    double finalOceanPH=0;
    int initialSize = Acid.size();
      for(int i=initialSize-10;i<initialSize;i++){//starts 10 less than the initial size of array goes untill the size of array
        finalOceanPH += Acid.get(i).getOceanPH();
      }
    return finalOceanPH/10;
  }
  public static double averageAtmosphericCO2Last(){
   double finalAtmosphericCO2=0;
    int initialSize = Acid.size();
      for(int i=initialSize-10;i<initialSize;i++){//starts 10 less than the initial size of array goes untill the size of array
        finalAtmosphericCO2 += Acid.get(i).getAtmosphericCO2();
      }
    return finalAtmosphericCO2/10;
  }
  //prints the object
  public String toString(){//start toString
    // return(timestamp+","+ oceanCO2+ ","+oceanPH+"," +atmosphericCO2);
    return String.format("%s    %.1f    %.4f    %.2f",timestamp,oceanCO2,oceanPH,atmosphericCO2);   
  }//end toString
  
}//end class 