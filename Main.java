package org.example;

import org.example.entity.*;
import org.example.service.BookServiceImpl;
import org.example.service.UserServiceImpl;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static Scanner cin=new Scanner(System.in);
    static void userRole(){
        System.out.println("Welcome!First you need to register");
        System.out.println("Enter your rollNo:");
        int roll=cin.nextInt();
        System.out.println("Enter name:");
        String nm= cin.next();
        System.out.println("Enter contact no:");
        String contact= cin.next();
        System.out.println("Enter email:");
        String mail= cin.next();
        System.out.println("Enter password:");
        String password= cin.next();
        UserServiceImpl obj=new UserServiceImpl();
        User s1=obj.addUser(new User(roll,nm,contact,mail,password,"student"));
        System.out.println("user created successfully");
        System.out.println("user detail\n"+s1.toString());

        System.out.println("want to update your details?[y/n]");
        String choice=cin.next();
        if(choice.equalsIgnoreCase("y"))
        {
            //System.out.println("The current details are "+);
            System.out.println("You can update following details:\n1.Contact Number\n2.Email\n3.password\nEnter option to change:");
            int fl=cin.nextInt();
            System.out.println("Enter new value");
            String val=cin.next();
            System.out.println(obj.updateUser(roll,val,fl));
        }

        // list all books
        //  - search a specific book based on
        //    book title (or) author (or) publisher
        //  - borrow a book
        //  - return a book
        //  - Raise a request for new book
        String flag;
        do {
            System.out.println("Welcome select the option:\n1.list all books\n" +
                    "  2.search a specific book based on\n" +
                    "  3.borrow a book\n" +
                    "  4.return a book\n");
            BookServiceImpl bookObj=new BookServiceImpl();
            int userChoice = cin.nextInt();
            switch (userChoice){
                case 1:
                    bookObj.showBook();
                    break;
                case 2:
                    System.out.println("Search based on\n1.title\n2.author\n3.publisher\n");
                    int searchOpt=cin.nextInt();
                    System.out.println("Enter value to be search");
                    String val=cin.next();
                    Book b1=bookObj.searchBook(searchOpt,val);
                    System.out.println(b1);
                    break;
                case 3:
                    System.out.println("Enetr book id yu which to borrow");
                    int bookId= cin.nextInt();
                    System.out.println(bookObj.borrowBook(bookId));
                    break;
                case 4:
                    System.out.println("Enetr book id yu which to return");
                    int bookId1= cin.nextInt();
                    bookObj.returnBook(bookId1);
                    break;
            }
            System.out.println("Do you want to continue?[y/n]");
            flag=cin.next();
        }while(flag.equalsIgnoreCase("y"));



    }
    static void adminRole(){
     // can add, delete, list, update books info to/from library
        //  - can add, delete,update & list users
        System.out.println("Welcome admin");
        BookServiceImpl bookObj=new BookServiceImpl();
        UserServiceImpl userObj=new UserServiceImpl();
        String fl1;
        do{
            System.out.println("1.Book related operation\n2.User related operation");
            int choice=cin.nextInt();
            switch (choice){
                case 1:
                    System.out.println("1.add book\n2.delete book\n3.update book\n4.show book");
                    int ch=cin.nextInt();
                    switch(ch){
                        case 1:
                            System.out.println("Enter book id:");
                            int bookId=cin.nextInt();
                            System.out.println("enter title");
                            String title=cin.next();
                            System.out.println("enter description");
                            String desc=cin.nextLine();
                            cin.nextLine();
                            System.out.println("enter author");
                            String author=cin.next();
                            System.out.println("Enter price:");
                            double amt=cin.nextInt();
                            System.out.println("Enter publication:");
                            String publisher=cin.next();
                            System.out.println("enter quantity:");
                            int quant=cin.nextInt();
                            bookObj.addBook(new Book(bookId,title,desc,amt,author,publisher,quant));
                            break;
                        case 2:
                            System.out.println("Enter book id:");
                            int bookId1=cin.nextInt();
                            bookObj.deleteBook(bookId1);
                            break;
                        case 3:
                            System.out.println("Enter book id:");
                            int bookId2=cin.nextInt();
                            //title, price quantity
                            System.out.println("The update field are:\n1.title\n2.price\n3.quantity");
                            int ch1=cin.nextInt();
                            System.out.println("Enter new value");
                            String val=cin.next();
                            bookObj.updateBook(bookId2,val,ch1);
                            break;
                        case 4:
                            bookObj.showBook();
                            break;
                    }
                    break;
                case 2:
                    System.out.println("1.add user\n2.delete user\n3.update user\n4.show user");
                    int ch3=cin.nextInt();
                    switch (ch3)
                    {
                        case 1:
                            System.out.println("Enter id");
                            int id=cin.nextInt();
                            System.out.println("enter user");
                            String user=cin.next();
                            System.out.println("enter contact no");
                            String pno=cin.next();
                            System.out.println("enter email");
                            String mail=cin.next();
                            System.out.println("enter role");
                            String role=cin.next();
                            userObj.addUser(new User(id,user,pno,mail,"",role));
                            break;
                        case 2:
                            System.out.println("enter id");
                            int id1=cin.nextInt();
                            userObj.deleteUser(id1);
                            break;
                        case 3:
                            System.out.println("You can update following details:\n1.Contact Number\n2.Email\n3.password\nEnter option to change:");
                            int fl=cin.nextInt();
                            System.out.println("enter id");
                            int id2=cin.nextInt();
                            System.out.println("Enter new value");
                            String val=cin.next();
                            System.out.println(userObj.updateUser(id2,val,fl));
                            break;
                        case 4:
                            userObj.showUser();
                            break;
                    }
                    break;
            }
            System.out.println("do you want to continue>[y/n]");
            fl1=cin.next();
        }while(fl1.equalsIgnoreCase("y"));
    }
    static void managerRole(){
       //can add, update, or delete  books and loan records.
        //  - order new books.
        //  - update title, price, quantity of books
        //  - view loan records
       BookServiceImpl bookObj=new BookServiceImpl();
                System.out.println("1.add book\n2.delete book\n3.update book\n4.show book");
                int ch=cin.nextInt();
                switch(ch){
                    case 1:
                        System.out.println("Enter book id:");
                        int bookId=cin.nextInt();
                        System.out.println("enter title");
                        String title=cin.next();
                        System.out.println("enter description");
                        String desc=cin.nextLine();
                        cin.nextLine();
                        System.out.println("enter author");
                        String author=cin.next();
                        System.out.println("Enter price:");
                        double amt=cin.nextInt();
                        System.out.println("Enter publication:");
                        String publisher=cin.next();
                        System.out.println("enter quantity:");
                        int quant=cin.nextInt();
                        bookObj.addBook(new Book(bookId,title,desc,amt,author,publisher,quant));
                        break;
                    case 2:
                        System.out.println("Enter book id:");
                        int bookId1=cin.nextInt();
                        bookObj.deleteBook(bookId1);
                        break;
                    case 3:
                        System.out.println("Enter book id:");
                        int bookId2=cin.nextInt();
                        //title, price quantity
                        System.out.println("The update field are:\n1.title\n2.price\n3.quantity");
                        int ch1=cin.nextInt();
                        System.out.println("Enter new value");
                        String val=cin.next();
                        bookObj.updateBook(bookId2,val,ch1);
                        break;
                    case 4:
                        bookObj.showBook();
                        break;
                }


    }
    public static void main(String[] args) {
//main -> call service --> servic call repository
        //entity -> class template
        // manual add user
        //admin
        UserServiceImpl userObj=new UserServiceImpl();
        User admin=userObj.addUser(new User(1,"shiva","9600433156","shiva@gmail.com","shiva@123","admin"));
        //manager
        User manager=userObj.addUser(new User(2,"sam","9789567890","sam@gmail.com","sam@123","manager"));
        System.out.println(admin);
        System.out.println(manager);

        //manually add book
        BookServiceImpl bookObj=new BookServiceImpl();
        bookObj.addBook(new Book(100,"datastructure","learn how to store data in programs",500,"carol","MVN",5));
        bookObj.addBook(new Book(101,"cloud computing","learn cloud like azure",250,"Schiller","MVN",3));
        bookObj.addBook(new Book(102,"python","learn basic python features",700,"reema","oracle",4));
        bookObj.addBook(new Book(103,"fullstack","learn how to develop backand frontend",800,"kevin","MVN",7));
        bookObj.addBook(new Book(104,"Tntro to java","learn java",600,"David","oracle",9));



        //Scanner cin=new Scanner(System.in);
        System.out.println("You can login as :\n1.Student2.admin3.manager\nEnter your choice");
        int choice=cin.nextInt();
        switch(choice){
            case 1:
                userRole();
                break;
            case 2:
                adminRole();
                break;
            case 3:
                managerRole();
                break;
            default:
                System.out.println("wrong option");
        }

        }
    }