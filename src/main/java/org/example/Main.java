package org.example;

import java.sql.SQLOutput;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.time.LocalTime;




class Timeduration{
    private long startTime;

    void Timeduration(){
        startTime = System.currentTimeMillis();
    }
    long getStartTime(){
        return startTime;
    }
    long getpenalty(){
        long penalty =startTime-System.currentTimeMillis();
        return penalty;
    }




}

class Book {

    String title;
    String author;
    int totalCopies;
    int availableCopies;
    static int bookd=1;
    int bookId;

    LocalTime start_time;

    Book(String title, String author, int totalCopies) {
        this.title = title;
        this.author = author;
        this.totalCopies = totalCopies;
        this.availableCopies = totalCopies;
        this.bookId = bookd;
        bookd++;

    }
}

class Member {
    String name;
    int age;
    List<Book> borrowedBooks;
    List<Timeduration> Timer;
    int penalty1;
    int penalty2;
    int penalty;

    String phoneNumber;

    Member(String name, int age, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.borrowedBooks = new ArrayList<>();
        this.Timer = new ArrayList<>();
        this.penalty = 0;
    }
   /* int getpenalty(){
        int[] time = new int[2];
        int i=0;
        for(Book book:borrowedBooks){
            Duration diff = Duration.between(book.start_time,

        }

    }*/


}

class Library {
    static List<Book> Allbooks;
    static List<Member> members;

    Library() {
        this.Allbooks = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    void Add_Book( String title, String author, int totalCopies) {
        Book book;
        int i=0;
        while(i<totalCopies){
            book = new Book( title,author, totalCopies);
            Allbooks.add(book);
            i++;
        }
        System.out.println("BOOK ADDED SUCCESSFULLY");
    }

    void removeBook(int bookId) {
        Book findbook = null;
        String  book_name;

        for (Book book : Allbooks) {
            int number;
            if (book.bookId == bookId) {
                findbook= book;
                break;
            }
        }
        if (findbook == null) {
            System.out.println("BOOK NOT FOUND.");
        } else {
            book_name = findbook.title;
            Allbooks.remove(findbook);
            System.out.println(book_name+"BOOK REMOVED SUCCESSULLY");
        }
    }

    void registerMember(String name, int age, String phoneNumber) {
        Member member = new Member(name, age, phoneNumber);
        members.add(member);
        System.out.println("MEMBER ADDED SUCCESSFULLY");
        //System.out.println(" DETAILS ARE:-\n  " +name+"\n"+" age ="+age+"\n"+" Phone NO ="+phoneNumber+"\n" );
    }
    void removeMember(String phoneNumber) {
        Member findmember = null;
        for (Member member : members) {
            if (Objects.equals(member.phoneNumber,phoneNumber)) {
                findmember = member;
                break;
            }
        }
        if (findmember == null) {
            System.out.println("MEMBER NOT FOUND.");

        } else {
            String name= findmember.name;
            members.remove(findmember);
            System.out.println(findmember.name+" REMOVED SUCCESSFULLY");
        }


    }
    static Member LOGIN(String name,String Ph_NO){

        Member findmember=null;
        for (Member member : members) {
            if (Objects.equals(member.phoneNumber,Ph_NO)) {
                findmember = member;
                break;
            }
        }
        if (findmember == null) {
            System.out.println("Member with Name:"+name+"and Phone No:"+ Ph_NO +"doesn't exist.");
        }
        else{
            System.out.println("LOGIN SUCCESSFULLY\n");
            System.out.println("Welcome "+name+ "  Member ID:"+ Ph_NO);

        }
        return findmember;
    }

    static void list_books(){
        System.out.println("TOTAL " +Allbooks.size()+" BOOKS"+" ARE :-");
        System.out.println("S.NO     BOOK_ID   BOOKNAME   ");
        int number =1;
        for (Book book : Allbooks) {
            System.out.println(number+".       "+book.bookId+"      "+book.title);
            number++;

        }
        System.out.println("...........END OF THE LIST...........\n");
    }
    static void my_books(Member XYZ){
        System.out.println("TOTAL " +XYZ.borrowedBooks.size()+" BOOKS"+" ARE :-");
        System.out.println("S.NO     BOOK_ID   BOOKNAME   ");
        int number =1;
        for (Book book : XYZ.borrowedBooks ) {
            System.out.println(number+".       "+book.bookId+"      "+book.title);
            number++;

        }
        System.out.println("...........END OF THE LIST...........\n");
    }
    static  void  retrn(Member USER) {
        System.out.println("Enter Book ID:");
        Scanner newinput = new Scanner(System.in);
        int bookid = newinput.nextInt();
        int fine = 0;
        Duration duration;
        LocalTime currentTime = LocalTime.now();
        Book findbook = null;
        Book b = null;
        for (Book book : USER.borrowedBooks) {
            if (book.bookId == bookid) {
                duration = Duration.between(book.start_time, currentTime);
                fine = (int) duration.getSeconds();
                b = book;
                break;
            }
        }
        if (b == null) {
            System.out.println("Book not found");
        } else {
            Allbooks.add(b);
            USER.borrowedBooks.remove(b);
            if (fine > 10) {
                int fine2 = (fine - 10) * 3;
                int days = fine - 10;
                USER.penalty += fine2;
                System.out.println("Book returned successuly and the fine for " + days + " days is " + fine2 + " Rs");
            } else {
                System.out.println("Book returned successfully");
            }


        }
    }
    void List_member(){
        System.out.println("TOTAL " +members.size()+" MEMBERS"+" ARE :-");
        int number=1;
        System.out.println("S.NO    MEMBER_NAME      ISSUED_BOOK1(ID)        ISSUED_BOOK2(ID)        TOTAL FINE");
        for (Member member : members) {
            if(member.borrowedBooks.size()==0){
                System.out.println(number+".     "+member.name+"             "+ "-------------           -----------                "+ member.penalty);


            }
            else if (member.borrowedBooks.size()==1){
                System.out.println(number+".          "+member.name+"                    "+member.borrowedBooks.get(0).bookId+"              -----------              "+ member.penalty);


            }
            else{
                System.out.println(number+".          "+member.name+"             "+member.borrowedBooks.get(0).bookId+"                     " +member.borrowedBooks.get(1).bookId+"                    "+ member.penalty);
            }
            number++;
        }
        System.out.println("...........END OF THE LIST...........\n");
    }
    // Add other methods for issuing, returning, listing, calculating fines, etc.
    static void ISSUE(Member USER){
        if(USER.borrowedBooks.size()<2){
            if(USER.penalty==0 ) {
                list_books();
                System.out.println("ENTER BOOK_ID");
                Scanner newinput =new Scanner(System.in);
                int bookid = newinput.nextInt();
                Book findbook=null;
                for (Book book : Allbooks) {
                    int number;
                    if (book.bookId==bookid) {
                        findbook= book;
                        break;
                    }
                }
                if(findbook!=null){
                    if(findbook.availableCopies>0){
                        USER.borrowedBooks.add(findbook);
                        findbook.availableCopies--;
                        Allbooks.remove(findbook);
                        USER.borrowedBooks.get(0).start_time=LocalTime.now();
                        System.out.println("BOOK ISSUED SUCCESSFULLY");}
                    else{
                        System.out.println("NO COPIES ARE LEFT ALL ISSUED");
                    }}
                else{
                    System.out.println("INVALID INPUT PLEASE ENTRY CAREFULLY");
                }


            }
            else{
                System.out.println("PLEASE CLEAR YOUR RECENT PENALTIES....");
            }}
        else{
            System.out.println("YOU CAN HOLD ATMOST 2 BOOKS ONLY");
        }


    }}





public class Main {
    public static void main(String[] args) {
        System.out.println("Library Portal Initialized….....");
        Library library = new Library();
        while(true){
            System.out.println("1. Enter as a Librarian\n2. Enter as a Member\n3. EXIT");
            Scanner input = new Scanner(System.in);
            String entered =input.nextLine();
            if(Objects.equals(entered,"1")){
                System.out.println("1. Register a member \n2. Remove a member \n3. Add a book\n4. Remove a book\n5. View all members along with their books and fines to be paid\n6. View all books\n7. Back"
                );
                while(true){
                    Scanner input1 = new Scanner(System.in);
                    String entered1 =input1.nextLine();
                    if(Objects.equals(entered1,"1")){
                        System.out.println("Enter Member Details :-");
                        System.out.print("Enter Name =  ");
                        Scanner inputT = new Scanner(System.in);
                        String name =inputT.nextLine();
                        System.out.print("Enter age =  ");
                        Scanner inputage = new Scanner(System.in);
                        int age =inputage.nextInt();
                        System.out.print("Enter Ph NO =  ");
                        Scanner inputph= new Scanner(System.in);
                        String Phone =inputph.nextLine();
                        library.registerMember(name,age,Phone);
                    }
                    else if(Objects.equals(entered1,"2")){
                        System.out.println("ENTER PHONE NUMBER..");
                        Scanner phone =new Scanner(System.in);
                        String  phonenumber =phone.nextLine();
                        library.removeMember(phonenumber);
                    }
                    else if(Objects.equals(entered1,"3")){
                        Scanner scanner = new Scanner(System.in);

                        System.out.print("Enter book title: ");
                        String title = scanner.nextLine();

                        System.out.print("Enter author: ");
                        String author = scanner.nextLine();

                        System.out.print("Enter quantity: ");
                        int quantity = scanner.nextInt();
                        scanner.nextLine();



                        library.Add_Book(title,author,quantity);
                    }
                    else if(Objects.equals(entered1,"4")){
                        Scanner scanner = new Scanner(System.in);

                        System.out.print("ENTER BOOKID ");
                        int BOOKID = scanner.nextInt();


                        library.removeBook(BOOKID);
                    }
                    else if (Objects.equals(entered1,"5")){
                        library.List_member();
                    }
                    else if (Objects.equals(entered1,"6")){
                        Library.list_books();}
                    else if (Objects.equals(entered1,"7")){
                        break;

                    }
                    else{
                        System.out.println("INVALID INPUT PLEASE TRY AGAIN");
                    }}

            }
            else if(Objects.equals(entered,"2")){
                Scanner input1 = new Scanner(System.in);
                System.out.print("ENTER NAME= ");
                String name =input1.nextLine();
                System.out.print("Ph NO = ");
                String  phone = input1.nextLine();
                Member USER =Library.LOGIN(name,phone);
                if(USER!=null){
                    System.out.println("1. List Available Books \n" +
                            "2. List My Books\n" +
                            "3. Issue book\n" +
                            "4. Return book\n" +
                            "5. Pay Fine\n" +
                            "6. Back\n");
                    while(true){

                        Scanner inpuut = new Scanner(System.in);
                        String entered1 =inpuut.nextLine();
                        if(Objects.equals(entered1,"1")){
                            Library.list_books();
                        }
                        else if (Objects.equals(entered1,"2")){
                            Library.my_books(USER);
                        }
                        else if (Objects.equals(entered1,"3")){
                            Library.ISSUE(USER);
                        }
                        else if (Objects.equals(entered1,"4")){
                            Library.retrn(USER);
                        }
                        else if (Objects.equals(entered1,"5")){
                            int penalty=USER.penalty;
                            USER.penalty=0;
                            System.out.print("You had a total fine of Rs."+penalty+". It has been paid successfully!\n");
                        }
                        else if(Objects.equals(entered1,"6")){
                            break;
                        }
                        else{
                            System.out.println("INVALID INPUT PLEASE TRY AGAIN");
                        }

                    }

                }










            }
            else if(Objects.equals(entered,"3")){
                System.out.println("-------------Terminating the application-----------\n           -------Thanks for visitng-------");
                break;

            }
            else{

                System.out.println("INVALID INPUT PLEASE TRY AGAIN");
            }
        }}}