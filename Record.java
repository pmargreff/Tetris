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
        
    }
    
    //https://www.youtube.com/watch?v=qqeOwdPZDvk
    
    private void writeRecord(){
        
        
        
        
        
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
}
