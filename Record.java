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
 * Class use to get or save the record
 */
public class Record {

    private File file_ = new File("record.txt");
    private int record_;

    /**
     * Try open the record file
     */
    Record() {
        try {
            file_.createNewFile();
        } catch (IOException ex) {

        }
    }

    /**
     * Get the record
     *
     * @return Return the record
     */
    public int getRecord() {
        readRecord();

        return record_;
    }

    /**
     * Set the new record and save in file
     *
     * @param score The score that will be save
     */
    public void setRecord(int score) {
        record_ = score;

        writeRecord();
    }

    //https://www.youtube.com/watch?v=qqeOwdPZDvk
    /**
     * Write the record in the file
     */
    private void writeRecord() {

        try {
            FileWriter fileWriter = new FileWriter(file_, false);

            try (PrintWriter printWriter = new PrintWriter(fileWriter)) {
                printWriter.println(record_);

                printWriter.flush();
            }
        } catch (IOException ex) {

        }

    }

    private void readRecord() {

        try {
            FileReader fileReader = new FileReader(file_);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String linha;

            linha = bufferedReader.readLine();

            record_ = Integer.parseInt(linha);
        } catch (IOException ex) {

        }
    }
}
