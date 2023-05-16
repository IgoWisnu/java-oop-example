import java.util.ArrayList;

class Library{
  public ArrayList<Book> books = new ArrayList<Book>();
  public ArrayList<Member> members = new ArrayList<Member>();

  public void addMember(Member member) {
    this.members.add(member);
  }
   public void addBook(Book book) {
    this.books.add(book);
  }

  public Boolean isMemberIdExist(String id) {
    Boolean isExist = false;
    for (Member member : this.members) {
      if (member.getId().equals(id)) {
        isExist = true;
      }  
    }
    return isExist;
  }
  
  public Boolean isBookIdExist(String id) {
    Boolean isExist = false;
    for (Book books : this.books) {
      if (books.getId().equals(id)) {
        isExist = true;
      }
    }
    return isExist;
  }

  public void giveBook(String bookId, String memberId) {
    Book book = this.getBookById(bookId);

    Member member = this.getMemberById(memberId);
    int memberIndex = this.getMemberIndex(member);
    if (NullIndexHandle(book, member) == true) {
        return;
    }
    
    this.books.remove(book);
    this.members.get(memberIndex).borrowedBooks.add(book);
  }
  
  public void receiveBook(String bookId, String memberId) {
    Member member = this.getMemberById(memberId);
    int memberIndex = this.getMemberIndex(member);

    try {
        Book book = this.members.get(memberIndex).getBookById(bookId);
        if (book == null) {
            System.out.println("Book with ID " + bookId + " not found in member's borrowed books.");
            return;
        }
        book.setId(bookId);
        this.books.add(book);
        this.members.get(memberIndex).borrowedBooks.remove(book);
    } catch (IndexOutOfBoundsException e) {
        System.out.println("Member Id not found");
    }
  }

  private int getMemberIndex(Member member) {
    return this.members.indexOf(member);
  }

  private Member getMemberById(String id) {
    for (Member member : this.members) {
      if (member.getId().equals(id)) {
        return member;
      }
    }
    return null;
  }

  public Book getBookById(String id) {
  for (int i = 0; i < this.books.size(); i++) {
    Book book = this.books.get(i);
    if (book.getId().equals(id)) {
      return book;
      }
    }
    return null;
    }
  
  private boolean NullIndexHandle(Book bookIndex, Member memberIndex){
      boolean Nullindicator = false; 
      if(memberIndex == null){
          Nullindicator = true;
          System.out.println("Member ID not found");
      }
      if(bookIndex == null){
          Nullindicator = true;
          System.out.println("Book ID not found");
      }
      
      return Nullindicator;
  }
}
