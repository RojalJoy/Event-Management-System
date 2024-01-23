
package event_management_system;

import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    
public class Date_Time {   
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd"); 
  public static void main(String[] args) { 
      Date_Time d = new Date_Time(); 
    
     
//   System.out.println(d.dtf.format(now));  
  }    
  public String getdate(){
      LocalDateTime now = LocalDateTime.now();
      return dtf.format(now);
  }
}