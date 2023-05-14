import java.util.ArrayList;

class Member extends LibraryUser{
  public ArrayList<Book> borrowedBooks = new ArrayList<Book>();
  
  //Method
  public void receiveBook(Book book) {
    this.borrowedBooks.add(book);
  }
  
  public void giveBook(Book book) {
    this.borrowedBooks.remove(book);
  }

  public Book getBookById(String id) {
  for (int i = 0; i < this.borrowedBooks.size(); i++) {
    Book book = this.borrowedBooks.get(i);
    if (book.getId().equals(id)) {
      return book;
      }
    }
  return null;
  }
  
  @Override
  void display(){
      System.out.println(getId()+" "+getName());
  }
}
