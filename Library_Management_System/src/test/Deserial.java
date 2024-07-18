package test;

import java.io.Serializable;

import library.LibrarySystem;
import library.data.User;
import library.management.Admin;
import test.util.SerializationUtils;

public class Deserial implements Serializable{

    public static void main(String[] args) {

        // Assuming a common base path
        String basePath = "C:/Users/Αφροδίτη/tp/Library_Management_System/src/test/medialab/";

        LibrarySystem librarySystem = SerializationUtils.deserializeObject(basePath + "librarySystem.ser");
        
        // // For example, printing the details of the deserialized LibrarySystem
        // if (librarySystem != null) {
        //     System.out.println("Deserialized LibrarySystem: " + librarySystem.toString());
        // }
    }
}