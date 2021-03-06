import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


public class TechFX extends Application {
    //Class property;
    private TextField inputText = new TextField();
    private Button ranButton = new Button ("Start");
    private Button ranButton1 = new Button ("End");
    
        
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
       // Create UI
        GridPane path = new GridPane();
        
        path.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        path.setHgap(5.5);
        path.setVgap(5.5);
        
        Label lbl3 = new Label("\t\t\t\t\t\t\t\t\tNumber(s) of Trial remaining: 12 ");
        Label label1 = new Label("\t\t\t\t\tTechForKids Project");
          label1.setContentDisplay(ContentDisplay.CENTER);
          label1.setTextFill(Color.BLACK);
          label1.setFont(Font.font("Courier", FontWeight.BOLD,FontPosture.ITALIC, 20));
        Label lbl2 = new Label("                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\tEnter Value:");
        //Label lbl3 = new Label("                           \t\t\t\t\t\t\t\t",txt3);
                
        Text txt1 = new Text("\t\tTechForKids is a Tech firm that teaches children how to code. The criteria \n\t\tfor accepting an applicant is to detect all numbers in a list of three random \n\t\tnumbers generated by a software in no more than 12 attempts. ");
            txt1.setFont(Font.font("Courier", FontWeight.LIGHT,FontPosture.ITALIC, 15));
        Text txt2 = new Text("Instructions ");
              txt2.setUnderline(true);
        Text txt3= new Text("Applicant are to suggests three\nnumbers. e.g 345\nNote, Your guess number should \nonly consist of three digit.");
        
        path.add(label1,0,0);
        path.add(txt3,0,3);
        path.add(txt2,0,2);
        path.add(lbl2, 0, 3);
        path.add(ranButton,1,4);
        path.add(txt1,0,1);
        path.add(inputText,1,3);
        path.add(new Text("                     Designed by Menim"),0,12);
        path.add(ranButton1,1,5);
        path.add(lbl3,0,3);
       
        
        
         Rannumber tech = new Rannumber();
        tech.random1();
        
        ranButton.setOnAction(new EventHandler<ActionEvent>() {
            int count=1;
            @Override // Override the handle method
            public void handle(ActionEvent e) {
                 solution(tech,count,inputText,txt2,txt3,lbl2,ranButton,lbl3);
                 
                 count++;
           }
           });
        ranButton1.setOnAction(e ->Exitvalue() );
      
        Scene scene = new Scene(path, 700, 300);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    
    public void solution ( Rannumber tech,int count,TextField inputText,Text txt2,Text txt3,Label lbl2,Button ranButton,Label lbl3) {
        
        //Alert alert6 = new Alert(AlertType.INFORMATION);
                   //  alert6.setTitle("Information");
                   //  alert6.setHeaderText("hello coder");
                   //  alert6.setContentText(""+count);
                    // alert6.showAndWait();
        lbl3.setText("\t\t\t\t\t\t\t\t\tNumber(s) of Trial remaining: " + (12-count) );
        if (count==12){
               txt2.setVisible(false);
               txt3.setVisible(false);
               lbl2.setVisible(false);
               inputText.setVisible(false);
               ranButton.setVisible(false);
               lbl3.setText("\n\t\t\t\t\t\t\tNO ADMISSION\n\t\t\t\t\t\t\tTRY NEXT YEAR");
               lbl3.setContentDisplay(ContentDisplay.CENTER);
               lbl3.setTextFill(Color.BLACK);
               lbl3.setFont(Font.font("Courier", FontWeight.BOLD,FontPosture.ITALIC, 15));
           
         }
        
        int [] valueTech = new int [3];
        
        int deadValue=0;
        int injuredValue = 0;
        
        
        //Conversion
        String value="";
        int valueInt;
        valueInt=Integer.parseInt(inputText.getText());
       
        
        boolean sub = CheckValue(valueInt);
        if (sub==false){
            Alert alert5 = new Alert(AlertType.INFORMATION);
                     alert5.setTitle("Information");
                     alert5.setHeaderText("\t\t\tWRONG INPUT");
                     alert5.setContentText("\t\t\tDigits is not equal to 3");
                     alert5.showAndWait();
                     
        }
        
        value+=valueInt;
        char value1 = value.charAt(0);
        char value2 = value.charAt(1);
        char value3 = value.charAt(2);

        int valueInt1=TechFX.Convert(value1);
        int valueInt2=TechFX.Convert(value2);
        int valueInt3=TechFX.Convert(value3);

        valueTech[0]= valueInt1;
        valueTech[1]= valueInt2;
        valueTech[2]= valueInt3;
        
        
            
        deadValue = tech.dead(valueTech);
        injuredValue = tech.injured(valueTech);
        String word ="";
       
        for(int e : tech.getRand()){
            word+=e;
            
        }
        
        //boolean result 
        if(sub ==true){
            boolean val=condition(deadValue,injuredValue, word,count);
            if(val==true){
               //TextField inputText,Text txt2,Text txt3,Label lbl2
               txt2.setVisible(false);
               txt3.setVisible(false);
               lbl2.setVisible(false);
               inputText.setVisible(false);
               ranButton.setVisible(false);
               lbl3.setText("\n\t\t\t\t\t\t\tCONGRATULATION \n\t\t\t\tYou are now admitted into the TechForKids Institute");
               lbl3.setContentDisplay(ContentDisplay.CENTER);
               lbl3.setTextFill(Color.BLACK);
               lbl3.setFont(Font.font("Courier", FontWeight.BOLD,FontPosture.ITALIC, 15));
                //Exitvalue() ;
            }
        }
        inputText.setText("");
    }
    
     public static int Convert(char value){
            String value1="" +value;
            int value3 = Integer.parseInt(value1);
            return value3;
        }
     public  boolean CheckValue(int valueInt){
         
                boolean result=false;
                String value = "" + valueInt;
                                
                if (value.length()==3){
                     result = true;
                }                   
               return result;
            
    }
    
    public boolean condition(int deadValue,int injuredValue,String word,int count){
        
        if(deadValue==3 && injuredValue==0){
           
             Alert alert3 = new Alert(AlertType.INFORMATION);
               alert3.setTitle("Information");
               alert3.setHeaderText("\t\t\tCONGRATULATION");
               alert3.setContentText("You are have been given admission" + "\n number of dead: " +deadValue +"\t\tnumber of injured: " + injuredValue );
                alert3.showAndWait();
            return true;
         }
        
        else {
           
            Alert alert4 = new Alert(AlertType.INFORMATION);
              alert4.setTitle("Information");
              alert4.setHeaderText("\t\t\tTRY AGAIN");
              alert4.setContentText( "\n number of dead: "+deadValue +"\t\t\t number of injured: " + injuredValue + "\n\t\tYou still have " +(12-count) +" chances");
              alert4.showAndWait();
            return false;
            
        }
        
    }
    public int increase(int count){
       
       return count++;
    }
   
     public  void Exitvalue(){
        System.exit(0);
        
     }
    
}
