// project tm 105 TMA 
package project;
import java.util.Scanner;
public class Project {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        
        String num="The number of persons";
        String messege1="The BMI is";
        String category=" BMI category";
        String messege2="The name of the best city which has the maximum percent of people in";
        String messege3="and these people`s percent ratio";
        String messege4="The name of the worst city which has the maximum percent of people in";
        String messege5="The name of the city which has the minimum percent of people in ";
        String normal_weight_name="";    // to save in it the name of city with the maximum percent of persons in normal category
        String obese_weight_name="";   //to save in it the name of city with the maximum percent of persons in obese category
        String underweight_mini_name=""; // to save in it the name of city which has the minimum percent of persons in underweight category
        String msg="kg/m2";// msg of printing the unit of BMI
        
      
        int underweight_all=0;  //counter to calculate the whole number of persons in underweight category in all cities 
        int normal_all=0;       //counter to calculate the whole number of persons in normal category in all cities
        int overweight_all=0;   //counter to calculate the whole number of persons in overweight category in all cities
        int obese_all=0;        //counter to calculate the whole number of persons in obese category in all cities
      
        int counter_peoples_cities=0;     //counter to calculate the number of persons in all cities
        double ratio_normal_all=0;       // to save in it the maximum ratio of persons in each city at normal category
        double ratio_normal;            //calculation of ratio of normal category in each city
        double ratio_obese_all=0;      //to save in it the maximum ratio of persons in each city at obese category
        double ratio_obese;            ////calculation of ratio of obese category in each city
        
        double ratio_all=100;//value of the percent ratio to compare it with every percent ratio in each city and get the minimum as the highst value is 100
        double ratio;           // to calculate the pecent ratio of underweight`s persons in each city 
        
        System.out.println("enter the number of cities");//promot user to enter the number of cities 
        int number_cities=scan.nextInt();//read from user the number of cities (nc) is the number of cities entered by user 
        while (number_cities<6){ // loop to check the number of cities valid or not                       
            System.out.println("please enter at least 6 numbers of cities");//promot user to enter minimum 6 cities  if not ask him again until nc>=6
             number_cities=scan.nextInt();
        }
        for(int c=1;c<=number_cities;c++){   // c is a counter to calculate the number of outer loop iterations
            int underweight=0;    // counter to calculate the number of people in underweight catgory in each city
            int normal=0;        // counter to calculate the number of people in normal catgory in each city
            int overweight=0;    // counter to calculate the number of people in overweight catgory in each city
            int obese=0;         //counter to calculate the number of people in obese catgory in each city
            
            System.out.println("enter the city name");
            String name=scan.next();
            
            System.out.println("enter the number of persons");//promot user to enter the number of persons 
            int number_persons=scan.nextInt();   //read from the user number of persons
            while(number_persons<10){           //loop to check the number of persons in each city is valid or not      
                System.out.println("please enter  at least 10 numbers of persons");
                
                 number_persons=scan.nextInt();
            }
            
            for(int i=1;i<=number_persons;i++){ // i is counter to calculate inner loop iterations
         
                System.out.println("enter the mass in kg");
                double mass=scan.nextDouble();
                System.out.println("enter the height in meter");
                double height=scan.nextDouble();
               while(height<=0){
                   System.out.println("enter a height bigger than 0");// to promot user to enter a height bigger than 0
                   height=scan.nextDouble();
               }
                double BMI=mass/Math.pow(height, 2);
                
                System.out.printf("%s %.1f %s \n",messege1 ,BMI,msg);//printing the computing of BMI
                if(BMI<18.5){// condition to check underweight category
                    System.out.printf("%s %.1f %s  at underweight %s\n",messege1,BMI,msg,category);
                    underweight++;
                    underweight_all++;
                    counter_peoples_cities++;
                    
                  
                } else if(BMI>=18.5&&BMI<25){// condition to check normal category
                    System.out.printf("%s %.1f %s at  normal %s\n",messege1,BMI,msg,category);
                    normal++;
                    normal_all++;
                    counter_peoples_cities++;
                    
                   
                }else if(BMI>=25&&BMI<30){// condition to check overweight category
                    System.out.printf("%s %.1f %s at  overweight %s\n",messege1,BMI,msg,category);
                    overweight++; 
                    overweight_all++;
                    counter_peoples_cities++;
                } else if(BMI>=30){// condition to check obese category
                    System.out.printf("%s %.1f %s at  obese %s\n",messege1,BMI,msg,category);
                    obese++; 
                    obese_all++;
                    counter_peoples_cities++;
                } 
                       
            } //end of inner loop 
            
            ratio=(double)underweight/number_persons*100;  // to calculate the city which has the minimum percent ratio of persons in underweight
             if(ratio<ratio_all){//start if
                 ratio_all=ratio;
                 underweight_mini_name=name;   
             }//end if 
            ratio_normal=(double)normal/number_persons*100;  //to calculate which city has the maximum percent ratio of pesons in normal category
             if(ratio_normal>ratio_normal_all){//start if
                ratio_normal_all=ratio_normal; 
                 normal_weight_name=name;
             }//end if
             
             ratio_obese=(double)obese/number_persons*100;  //to calculate which city has the maximum percent ratio of pesons in obese category
             if( ratio_obese>ratio_obese_all){//start if
               ratio_obese_all=ratio_obese;
               obese_weight_name=name;
             }//end if
             
           System.out.println("----------");
           System.out.printf("%s in underweight category:  (%d) with ratio %.1f%% \n",num, underweight,(double) underweight/number_persons*100);
           System.out.printf("%s in normal category:  (%d) with ratio %.1f%% \n",num, normal,(double)normal/number_persons*100);
           System.out.printf("%s in overweight category:  (%d) with ratio %.1f%% \n",num,overweight,(double)overweight/number_persons*100);
           System.out.printf("%s in obese category: (%d) with ratio %.1f%% \n",num, obese,(double)obese/number_persons*100);
               
           
        }//end of outer loop
        
        
        System.out.println("------------------");
        System.out.println("The final  summary report is  ");
        System.out.println("");
        System.out.println("The number of cities : " + (number_cities));
        System.out.println("The number of people in all cities" +counter_peoples_cities);//total number of persons in all cities
        System.out.println("For all cities :");
        System.out.println("");
        System.out.printf("In underweight category:%s:(%d) with ratio %.2f%% \n",num,underweight_all,(double)underweight_all/counter_peoples_cities*100);
        System.out.printf("In normal category:%s:(%d) with ratio %.2f%% \n",num,normal_all,(double)normal_all/counter_peoples_cities*100);
        System.out.printf("In overweight category:%s:(%d) with ratio %.2f%% \n",num,overweight_all,(double)overweight_all/counter_peoples_cities*100);
        System.out.printf("In obese category:%s:(%d) with ratio %.2f%% \n",num,obese_all,(double)obese_all/counter_peoples_cities*100);
        System.out.println("---------------");
        
        
   System.out.printf("%s normal weight BMI category is %s %s is %.1f%% \n",messege2,normal_weight_name,messege3,ratio_normal_all);
   System.out.printf("%s obese weight BMI category is %s %s is %.1f%% \n",messege4,obese_weight_name,messege3,ratio_obese_all); 
   System.out.printf("%s underweight BMI category is %s %s is %.1f%% \n ",messege5,underweight_mini_name,messege3,ratio_all);
       
    }//end main method block  
    
}//end class block
