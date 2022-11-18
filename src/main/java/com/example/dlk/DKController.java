package com.example.dlk;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

import java.io.*;

public class DKController {
    @FXML
    private TextArea text_in_add;
    @FXML
    private TextArea text_in_del;
    @FXML
    private Text text_out;
    String[] tasks = new String[100];
    private int num_task = 0;
    String filename = "I:\\desktop\\DLK\\src\\main\\java\\com\\example\\dlk\\tasks.txt";

    public void initialize() throws IOException {
        read_ddl();
        show_ddl();
        System.out.println("目前DDL数量：" + num_task);
    }

    public void upload_add() throws IOException {
        String new_task = text_in_add.getText();
        add_ddl(new_task);
        show_ddl();
        System.out.println("添加DDL: " + new_task);
    }

    public void upload_del() throws IOException {
        String del_task = text_in_del.getText();
        del_ddl(Integer.parseInt(del_task));
        show_ddl();
        System.out.println("删除DDL： " + del_task);
    }

    public void read_ddl() throws IOException {
        num_task = 0;
        File f = new File(filename);
        if (!f.exists())
            f.mkdirs();
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        String tmp = null;
        while ((tmp = br.readLine()) != null) {
            tasks[num_task] = tmp;
            num_task++;
        }
        br.close();
        fr.close();
    }

    public void write_ddl() throws IOException {
        FileWriter fw = new FileWriter(filename);
        for (int i = 0; i < num_task; i++) {
            fw.write(tasks[i]);
            if (i != num_task - 1)
                fw.write("\n");
        }
        fw.close();
    }

    public void show_ddl() {
        String toshow = "";
        if (num_task == 0) {
            toshow += "好耶，没有DDL！";
        } else
            for (int i = 0; i < num_task; i++) {
                toshow += i + 1 + ": ";
                toshow += tasks[i];
                if (i != num_task - 1)
                    toshow += "\n";
            }
        text_out.setText(toshow);
    }

    public void add_ddl(String task) throws IOException {
        tasks[num_task] = task;
        num_task++;
        write_ddl();
    }

    public void del_ddl(int num) throws IOException {
        for (int i = num; i < num_task; i++) {
            tasks[i - 1] = tasks[i];
        }
        num_task--;
        write_ddl();
    }
}
