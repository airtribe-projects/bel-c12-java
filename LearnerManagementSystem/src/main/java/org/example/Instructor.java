package org.example;

public class Instructor {
    private String instructorId;
    private String instructorName;
    private String instructorEmail;
    private String instructorPhone;
    private String instructorAddress;

    public Instructor(String instructorId, String instructorName, String instructorEmail, String instructorPhone, String instructorAddress) {
        this.instructorId = instructorId;
        this.instructorName = instructorName;
        this.instructorEmail = instructorEmail;
        this.instructorPhone = instructorPhone;
        this.instructorAddress = instructorAddress;
    }

    public void displayInstructorDetails() {
        System.out.println("Instructor Id: " + instructorId);
        System.out.println("Instructor Name: " + instructorName);
        System.out.println("Instructor Email: " + instructorEmail);
        System.out.println("Instructor Phone: " + instructorPhone);
        System.out.println("Instructor Address: " + instructorAddress);
    }
}
