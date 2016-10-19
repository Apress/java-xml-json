public class Book
{
   private String title;
   private String[] authors;
   private String isbn10;
   private String isbn13;

   public Book(String title, String[] authors, String isbn10, String isbn13)
   {
      this.title = title;
      this.authors = authors;
      this.isbn10 = isbn10;
      this.isbn13 = isbn13;
   }

   public String getTitle()
   {
      return title;
   }
   
   public String[] getAuthors()
   {
      return authors;
   }

   public String getIsbn10()
   {
      return isbn10;
   }

   public String getIsbn13()
   {
      return isbn13;
   }
}