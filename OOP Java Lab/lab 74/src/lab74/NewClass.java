/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab74;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Admin
 */
public class NewClass {

    public static void main(String[] args) throws IOException {
       // File file = new File("");
        FileWriter fw = new FileWriter("con.so.le.txt");
        try (BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write("hello");
        }
    }
}
