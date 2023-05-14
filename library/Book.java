abstract class LibraryItems{
    private String id;
    private String title;
    
    void setId(String id){
      this.id = id;
    }
    void setTitle(String title){
        this.title = title;
    }
    String getId(){
        return id;
    }
    String getTitle(){
        return title;
    }
    abstract void display();
}

class Book extends LibraryItems{
    @Override
    void display(){
        System.out.println(getId()+" "+getTitle());
    }
}
