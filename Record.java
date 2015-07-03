/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//http://www.mballem.com/post/manipulando-arquivo-txt-com-java/
//http://www.guj.com.br/articles/13

import javax.swing.*;
import java.io.*;

/**
 *
 * @author gilberto
 */
public class Record {
    
    private File file_ = new File("record.txt");
    private int record_;
    
    Record(){
            try{
            file_.createNewFile();
            }catch(IOException ex){
                
            }
    }
    
    public int getRecord(){
        readRecord();
        
        return record_; 
    }
    
    public void setRecord(int score){
        record_ = score;
        
        writeRecord();
    }
    
    //https://www.youtube.com/watch?v=qqeOwdPZDvk
    
    private void writeRecord(){
        
        try{
            FileWriter fileWriter = new FileWriter(file_, false);
            
            try (PrintWriter printWriter = new PrintWriter(fileWriter)) {
                printWriter.println(record_);
                
                printWriter.flush();
            }
        }catch(IOException ex){
            
        }
        
        
        
    }
    
    private void readRecord(){
        
        try{
            FileReader fileReader = new FileReader(file_);
            
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            String linha;
            
            linha = bufferedReader.readLine();  
            
            record_ = Integer.parseInt(linha);
        }catch(IOException ex){
            
        }
    }
    
    public static void main(String[] argv){
        
        Record record = new Record();
        
        int score = 30;
        
        record.setRecord(score);
        
        System.out.println(record.getRecord());

}
}


