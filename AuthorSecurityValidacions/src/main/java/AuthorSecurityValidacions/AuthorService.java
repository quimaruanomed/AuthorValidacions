package AuthorSecurityValidacions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class AuthorService {


		//constructor: int id, String name, String country, int dob, int qtyBooks, Boolean alive
		static List<Author>  authors = new ArrayList<>();
		static {

			Author author1 = new Author (1, "Paulo Coelho","Rio de Janeiro",1947,023, false);
			Author author2 = new Author (2, "Isabel Allende", "Lima", 1942, 143, false);
			Author author3 = new Author (3, "Stephen King","Portland", 1947, 204, false);

			authors.add(author1);
			authors.add(author2);
			authors.add(author3);
		}

		public List<Author> queryAuthorFromArray() {
			System.out.println("Authors" + authors);
			return authors;
		}

		public Author addAuthorToArray(Author author) {

			authors.add(author);

			return author;
		}

		public int deleteAuthorFromArrayID (int  id) {

			int index = findAuthorById(id);
			String msg= "Author deleted by id";
			authors.remove(index);

			return id ;

		}

		public String deleteAuthorFromArray(int index ) {

			authors.remove(index);

			return "Author deleted by index";
		}
		public int findAuthorById(int id) {

			int index = -1;
			for ( Author authorTemporal  : authors) {

				if ( authorTemporal.getId() == id ) {
					index = authors.indexOf(authorTemporal);
				}
			}
			return index;
		}
		public Author replaceAuthor(int indexAuthor, Author author) {

			authors.set(indexAuthor, author);


			return author;

		}
		public Author getAuthorByIndex1 (int index) {

			Author author = authors.get(index);

			return author;
		}
     public Author getAuthorByIndex (int index) {

			Author author = authors.get(index);

			return author;
		}


	}


