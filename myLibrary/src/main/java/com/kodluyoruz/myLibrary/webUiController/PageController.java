package com.kodluyoruz.myLibrary.webUiController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kodluyoruz.myLibrary.dao.entity.*;
import com.kodluyoruz.myLibrary.service.*;


@Controller
@RequestMapping("/thyme")
public class PageController {
	
	@Autowired
	private BookService bookService;
	@Autowired
	private AuthorService authorService;
	@Autowired
	private CategoryService categoryService;
	
	
	@RequestMapping(value="/book/list",method=RequestMethod.GET)
	public String getBookList(Model model) {
		model.addAttribute("books",bookService.getBookList());
		return "pages/thyme_book_list";
	}
	
	@RequestMapping(value="/book/add",method=RequestMethod.GET)
	public String getAddBookPage(Book book) {
		return "pages/thyme_book_add";
	}
	
	@RequestMapping(value="/book/add",method=RequestMethod.POST)
	public String add(Model model , Book book) {
		book.setBookNo(bookService.findMaxNo()+1L);
		this.bookService.save(book);
		model.addAttribute("books",bookService.getBookList());
		return "pages/thyme_book_list";
	}
	@RequestMapping(value="/author/add/{bookNo}",method=RequestMethod.GET)
	public String getAddAuthorPage(@PathVariable(value="bookNo") Long bookNo, Model model) {
		model.addAttribute("authors",authorService.getAuthorList());
		model.addAttribute("book", bookService.getBookByNo(bookNo));
		return "pages/thyme_author_add";
	}
	@RequestMapping(value="/author/add/{bookNo}",method=RequestMethod.POST)
	public String addAuthor(@PathVariable(value="bookNo") Long bookNo,@RequestParam Long authorNo, Model model) {
		Author author = authorService.getAuthorByNo(authorNo);
		Book book = bookService.getBookByNo(bookNo);
		if(book != null) {
			if(!book.hasAuthor(author)) {
				book.getAuthors().add(author);
			}
			bookService.save(book);
			model.addAttribute("book",bookService.getBookByNo(bookNo));
			model.addAttribute("authors",authorService.getAuthorList());
			model.addAttribute("books", bookService.getBookList());
			return "pages/thyme_book_list";
		}
		model.addAttribute("books", bookService.getBookList());
		return "pages/thyme_book_list";
	}
	@RequestMapping(value="/category/add/{bookNo}",method=RequestMethod.GET)
	public String getAddCategoryPage(@PathVariable(value="bookNo") Long bookNo, Model model) {
		model.addAttribute("categories",categoryService.getCategoryList());
		model.addAttribute("book", bookService.getBookByNo(bookNo));
		return "pages/thyme_category_add";
	}
	@RequestMapping(value="/category/add/{bookNo}",method=RequestMethod.POST)
	public String addCategory(@PathVariable(value="bookNo") Long bookNo,@RequestParam Long categoryNo, Model model) {
		Category category = categoryService.getCategoryByNo(categoryNo);
		Book book = bookService.getBookByNo(bookNo);
		if(book != null) {
			if(!book.hasCategory(category)) {
				book.getCategories().add(category);
			}
			bookService.save(book);
			model.addAttribute("book",bookService.getBookByNo(bookNo));
			model.addAttribute("categories",categoryService.getCategoryList());
			model.addAttribute("books", bookService.getBookList());
			return "pages/thyme_book_list";
		}
		model.addAttribute("books", bookService.getBookList());
		return "pages/thyme_book_list";
	}

}