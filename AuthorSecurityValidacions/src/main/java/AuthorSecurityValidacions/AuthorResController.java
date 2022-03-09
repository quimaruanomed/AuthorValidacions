package AuthorSecurityValidacions;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//url:localhost:8080/api/authors
@RestController
@RequestMapping("api")
public class AuthorResController {

	@Autowired
	AuthorService authorservice;



	//here we are creating our endpoint rest api
	@GetMapping("authors")
	public Iterable<Author> getAllAuthor() {
		//to-do
		return authorservice.queryAuthorFromArray();
	}

	@PostMapping(path = "/addAuthor", consumes = "application/json" )
	public Author createAuthor(@Valid @RequestBody Author author) {


		//LocalDate localDate = LocalDate.now();
	   // author.setCreatedat(localDate);

		System.out.println("This is the object that gets from client/postman in java class author: " +  author);

		Author authorSaved = authorservice.addAuthorToArray(author);

		return authorSaved;


	}
	@DeleteMapping ("deleteAuthor/{id}")
	public String deleteAuthor  (@PathVariable int id ) {



		String responsedelete = "Author delete by Id";
		int indexAuthor = authorservice.findAuthorById (id);

		if ( indexAuthor != -1 )
			{
			//bookservice.deleteBookFromArray(title);
			authorservice.deleteAuthorFromArray(indexAuthor);
			System.out.println("Author found in " + indexAuthor + " and deleted");
			responsedelete = responsedelete + "author: " + id  + " - deleted #succes";
			}
		else
			{
			System.out.println("Author not found, not deleted");
			responsedelete = responsedelete + "Author: " + id + " - not deleted book not found #fail";
			}
		return responsedelete;
	}

	@PostMapping("/replaceAuthor/{id}")

	public int updateAuthor (@PathVariable int id, @RequestBody Author authorFromRest ) {

		int responseUpdateId =id;
		String responseUpdate ="";

		int indexAuthor = authorservice. deleteAuthorFromArrayID (id);

		if ( indexAuthor == -1 )
		{
			responseUpdate=  "Author not found " ;

		} else {

			Author authorToUpdate = authorservice.getAuthorByIndex(indexAuthor);

			//we are going to compare both authors:
			//bookFromRest vs AuthorToUpdate
			//we need to compare each field of our object
			responseUpdate += "author found";

			if  (authorFromRest.getName() != null) {
				responseUpdate += " - author name value updated: " + authorFromRest.getName() +  "( old value: " + authorToUpdate.getName() + ")" ;
				authorToUpdate.setName( authorFromRest.getName() );
			}
			if  (authorFromRest.getCountry() != null) authorToUpdate.setCountry(  authorFromRest.getCountry());
			//if  (authorFromRest.getDob() != 0) authorToUpdate.setdob( DobFromRest.getDob());





			 authorservice.replaceAuthor(indexAuthor, authorToUpdate);

		}


		return responseUpdateId;





	}


}


