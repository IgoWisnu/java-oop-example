import java.util.Scanner;

class Main{

  static Scanner scan = new Scanner(System.in);
  static Library library = new Library();

  public static void main(String[] args) {
    initLibraryData();

    String isContinue = "y";

    while (isContinue.equals("y")) {
      showMenu();
      int selectedMenu = chooseMenu();

        switch (selectedMenu) {
            case 1:
                showBooks();
                break;
            case 2:
                showMembers();
                break;
            case 3:
                addMember();
                break;
            case 4:
                borrowBook();
                break;
            case 5:
                returnBook();
                break;
            case 6:
                addBook();
                break;
            default:
                System.out.println("wrong input");
                break;
        }

      System.out.print("continue ? ");
      isContinue = scan.next();
    }
  }

  public static void showMenu() {
    System.out.println("================================");
    System.out.println("1. show books list");
    System.out.println("2. show members list");
    System.out.println("3. add member");
    System.out.println("4. borrow book");
    System.out.println("5. return book");
    System.out.println("6. add book");
    System.out.println("================================");
  }

  public static void initLibraryData() {
    Book book1 = new Book();
    book1.setId("1");
    book1.setTitle("pemrograman java");

    Book book2 = new Book();
    book2.setId("2");
    book2.setTitle("pemrograman OOP");

    Book book3 = new Book();
    book3.setId("3");
    book3.setTitle("pemrograman Android");

    Member member1 = new Member();
    member1.setId("1");
    member1.setName("aka");

    Member member2 = new Member();
    member2.setId("2");
    member2.setName("Budi");

    Member member3 = new Member();
    member3.setId("3");
    member3.setName("Tono");

    library.books.add(book1);
    library.books.add(book2);
    library.books.add(book3);

    library.members.add(member1);
    library.members.add(member2);
    library.members.add(member3);
  }

  public static int chooseMenu() {
    System.out.print("choose menu : ");
    int pilihan = scan.nextInt();
    return pilihan;
  }

  public static void showBooks() {
    for (Book book : library.books) {
      book.display();
    }
  }

  public static void showMembers() {
    for (Member member : library.members) {
      member.display();
    }
  }

  public static void addMember() {
    Member member = new Member();
    do{
        if(library.isMemberIdExist(member.getId()) == true){
            System.out.println("The Id has been taken");
        }
        System.out.print("id : ");
        String id = scan.next();
        member.setId(id);

        System.out.print("name : ");
        String name = scan.next();
        member.setName(name);
    }
    while(library.isMemberIdExist(member.getId()) == true);
    System.out.println("Member succesful added");
    library.addMember(member);
  }
  
  public static void addBook() {
    Book book = new Book();
    do{
        if(library.isBookIdExist(book.getId()) == true){
            System.out.println("The book Id already used");
        }
        System.out.print("id book: ");
        String id = scan.next();
        book.setId(id);

        System.out.print("title : ");
        String title = scan.next();
        book.setTitle(title);
    }
    while(library.isBookIdExist(book.getId()) == true);
    System.out.println("Book Succesfuly added");
    library.addBook(book);
  }

  public static void borrowBook() {
    System.out.print("id member : ");
    String memberId = scan.next();

    System.out.print("id book : ");
    String bookId = scan.next();

    library.giveBook(bookId, memberId);
  }

  public static void returnBook() {
    System.out.print("id member : ");
    String memberId = scan.next();

    System.out.print("id book : ");
    String bookId = scan.next();

    library.receiveBook(bookId, memberId);
  }
}