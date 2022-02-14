package com.brianfair.interviewalgos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;


@Controller
//@RequestMapping("/prodCat")
public class MainController 
{
//	
//	@Autowired
//	private QuestionService questionService;
//	@Autowired
//	private AnswerService answerService;
//	@Autowired
//	private TagService tagService;
	
	
//	@GetMapping("/")
//	public String main(Model model)
//	{
////		List<Question> questions = questionService.getAllQuestions();
////		List<Tag> tags = tagService.getAllTags();
////		model.addAttribute("questions", questionService.getAllQuestions());
//		return "main.jsp";
//	}	

	
//	@GetMapping("/add/question")
//	public String addQuestion(Model model)
//	{
//		return "addquestion.jsp";
//	}
	


}
//#################################################################################################################################
//################################################################################################################################

//@GetMapping("/add/question")
//public String addQuestion(@ModelAttribute("newQuestion") NewQuestion newQuestion) {
////	model.addAttribute("products", this.productService.getAllProducts());
//    return "addquestion.jsp";
//}
//
//@RequestMapping(value="/adding/question", method=RequestMethod.POST)
//public String addingQuestion(@Valid @ModelAttribute("newQuestion") NewQuestion newQuestion, BindingResult result)
//{
//    if (result.hasErrors()) {
//        return "addquestion.jsp";
//    } else {
//        this.questionService.createQuestion(newQuestion);
//        return "redirect:/";
//    }
//}
//    
//@RequestMapping("/answer/{id}")
//public String answer(@PathVariable("id") Long id,
//					@ModelAttribute("answer") Answer answer,
//					HttpSession session,
//					Model model)
//{
//	session.setAttribute("id", id);
//	Question this_question = this.questionService.getOneQuestion(id);
//	model.addAttribute("question", this_question);
//   	return "answers.jsp";
//	}
//
//@RequestMapping(value="/adding/answer", method=RequestMethod.POST)
//public String createProduct(@Valid @ModelAttribute("answer") Answer answer,
//							BindingResult result,
//							HttpSession session,
//							Model model)
//{
//	long id = (long) session.getAttribute("id");
//	Question this_question = this.questionService.getOneQuestion(id);
//	model.addAttribute("question", this_question);
//	if (result.hasErrors())
//	{
//		return "answers.jsp";
//	} 
//	else
//	{
//		Answer newAnswer = answerService.save(answer);
//		return "redirect:/answer/"+newAnswer.getQuestion().getId();
//	}
//}
//
//
//
//
//@RequestMapping("/product/add")
//public String newProduct(@ModelAttribute("product") Product product, Model model) {
//	model.addAttribute("categories", this.categoryService.getAllCategories());
//    return "productAdd.jsp";
//}
//
//@RequestMapping(value="/adding/product", method=RequestMethod.POST)
//public String createProduct(@Valid @ModelAttribute("product") Product product,
//							BindingResult result)
//{
//    if (result.hasErrors()) {
//        return "productAdd.jsp";
//    } else{
//    	productService.save(product);
//        return "redirect:/prodCat/main";
//    }
//}
//
//
//@GetMapping("/product/details/{id}")
//public String dojoDetails(@PathVariable("id") Long id, Model model)
//{
//	Product this_product = this.productService.getOneProduct(id);
//	model.addAttribute("product", this_product);
//	model.addAttribute("categories", this.categoryService.getAllCategoriesNotOfProduct(this_product));
//	return "productDetails.jsp";
//	}
//
////   /addProductToCategory/${product.id}
//
/////assignToCategory/${category.id}
//@GetMapping("/assignCategoryToProduct/{product_id}/{category_id}")
//public String assignCategoryToProduct(@PathVariable("product_id") Long product_id,
//		@PathVariable("category_id") Long category_id,
//		Model model)
//{
//	Product this_product = this.productService.getOneProduct(product_id);
//	Category this_category = this.categoryService.getOneCategory(category_id);
//	categoryService.appendProductToCategory(this_product, this_category);
//
//	 return "redirect:/category/details/{category_id}";
//	}
//
//
//@GetMapping("/addProductToCategory/{product_id}/{category_id}")
//public String addProductToCategory(@PathVariable("product_id") Long product_id,
//		@PathVariable("category_id") Long category_id,
//		Model model)
//{
//	Product this_product = this.productService.getOneProduct(product_id);
//	Category this_category = this.categoryService.getOneCategory(category_id);
//	categoryService.appendProductToCategory(this_product, this_category);
//	 	return "redirect:/category/details/{category_id}";
//	}
//
//
//@DeleteMapping("/delete/{id}")
//public String delete(@PathVariable("id") Long id)
//{
//	this.dojoService.delete(id);
//	return "redirect:/main2";
//}
//
//








//##################################################
//	
//	@GetMapping("/languageEdit/{id}")
//	public String edit(@PathVariable("id") Long id, Model model)
//	{
//		Language language = langService.getOneLanguage(id);
//		model.addAttribute("language", language);
//		return "languageEdit.jsp";
//	}
//	
//	@PostMapping("/languageEditing/{id}")
//	public String languageEditing(@PathVariable("id") Long id, 
//						@RequestParam("name") String name,
//						@RequestParam("firstName") String firstName,
//						@RequestParam("lastName") String lastName,
//						@RequestParam("version") String version)
//	{
////		if (result.hasErrors())
////		{
////			return "languageEdit.jsp";
////		}
//		Language language = langService.getOneLanguage(id);
//		language.setName(name);
//		language.setFirstName(firstName);
//		language.setLastName(lastName);
//		language.setVersion(version);
////		Language language = new Language(name, firstName, lastName, version);
//		this.langService.save(language);
//		return "redirect:/main";
//	}
//
//	
//	@GetMapping("/languageCreate")
//	public String create()
//	{
//		return "languageCreate.jsp";
//	<div class="containter">
//		<h2>Add New Languages</h2>
//		<a class="btn btn-dark" href="/main">Main</a>
//		<hr>
//		<form class="form-control border border-dark" action="/languageCreating" method="POST">
//			<p>Language: </p>
//			<input class="border border-dark mb-4" name="name" type="text">
//			<p>First Name: </p>
//			<input class="border border-dark mb-4" name="firstName" type="text">
//			<p>Last Name: </p>
//			<input class="border border-dark mb-4"  name="lastName" type="text">
//			<p>Version: </p>
//			<input class="border border-dark mb-4" name="version" type="text">
//			<input type="submit" value="Submit">
//		</form>
//	</div>
//		
//	}
	
//	@PostMapping("/languageCreating")
//	public String creating(@RequestParam("name") String name,
//						@RequestParam("firstName") String firstName,
//						@RequestParam("lastName") String lastName,
//						@RequestParam("version") String version)
//	{
//		Language language = new Language(name, firstName, lastName, version);
//		this.langService.save(language);
//		return "redirect:/main";
//	}

//	@GetMapping("/languageView/{id}")
//	public String view(@PathVariable("id") Long id, Model model)
//	{
//		Language language = langService.getOneLanguage(id);
//		model.addAttribute("language", language);
//		return "languageView.jsp";
//	}
//	
//	@DeleteMapping("/delete/{id}")
//	public String delete(@PathVariable("id") Long id)
//	{
//		this.langService.delete(id);
//		return "redirect:/main";
//	}
//	
//	@RequestMapping("/languageCreate")
//	public String create(@ModelAttribute("language") Language language)
//	{
//		return "languageCreate.jsp";
//	}
//	
//	
//	@RequestMapping(value="/languageCreate", method=RequestMethod.POST)
//	public String addNew(@Valid @ModelAttribute("language") Language language, BindingResult result)
//	{
//		if (result.hasErrors())
//		{
//			return "languageCreate.jsp";
//		}
//		this.langService.save(language);
//		return "redirect:/main";
//	}
	
	
	
	
	
//	<div>
//	<form:form action="/languageCreate" method="POST" modelAttribute="language">
//		<p>
//			<form:label path="name">Name</form:label>
//			<form:errors path="name"/>
//			<form:input type="text" path="name"/>
//		</p>	
//		<p>
//			<form:label path="firstName">First Name</form:label>
//			<form:errors path="firstName"/>
//			<form:input type="text" path="firstName"/>
//		</p>	
//		<p>
//			<form:label path="lastName">Last Name</form:label>
//			<form:errors path="lastName"/>
//			<form:input type="text" path="lastName"/>			
//		</p>	
//		<p>
//			<form:label path="version">Version</form:label>
//			<form:errors path="version"/>
//			<form:input type="text" path="version"/>
//		</p>
//		<input type="submit" value="Submit"/>
//	</form:form>
//</div>

//}
	
	


	
//	@PostMapping("/htmlLanguageCreating")
//	public String htmlCreating(@RequestParam("name") String name,
//						@RequestParam("firstName") String firstName,
//						@RequestParam("lastName") String lastName,
//						@RequestParam("version") String version)
//	{
//		Language language = new Language(name, firstName, lastName, version);
//		this.langService.createNewLanguage(language);
//		return "redirect:/main";
//	}
//	



//@GetMapping("/{dt}")
//public String dateTime(@PathVariable("dt") String dt, Model model)
//{
//	if (dt.equals("time"))
//	{	
//		LocalTime time = LocalTime.now();
//		DateTimeFormatter fTimeObj = DateTimeFormatter.ofPattern("h:mm a");
//		String fTime = time.format(fTimeObj);
//		model.addAttribute("time", fTime);
//		return "datetime.jsp";
//	}
//	else
//	{
//		LocalDate date = LocalDate.now();
//		DateTimeFormatter fDateObj = DateTimeFormatter.ofPattern("E, MMM dd, yyyy");
//		String fDate = date.format(fDateObj);
//		model.addAttribute("date", fDate);
//		return "datetime.jsp";
//	}
//}
//
	
	
	
//	@GetMapping("/")
//	public String welcome
//		(
//			@RequestParam(value="name", required=false, defaultValue="human") String name,
//			@RequestParam(value="times", required=false, defaultValue= "1") int times,
//			Model model
//		)
//	{
//		model.addAttribute("name",name);
//		model.addAttribute("times", times);
//		return "home.jsp";
//	}
//}

////	@RequestMapping("/")
//	@GetMapping("/")
//	public String home(Model model)
//	{
//      ArrayList<String> dojos = new ArrayList<String>();
//      dojos.add("Burbank");
//      dojos.add("Chicago");
//      dojos.add("Bellevue");
//      model.addAttribute("dojos", dojos);
//		return "home.jsp";
//	}
//	
//	
////	@RequestMapping("/result")	
////	@RequestMapping(path="/result", method=RequestMethod.POST)	
//	@PostMapping("/result")
//	public String result
//			(
//			@RequestParam("firstName") String firstName,
//			@RequestParam("email") String email,
//			@RequestParam("program") String program,
//			Model model,
//			HttpSession mySession
//			)
//	{
//		model.addAttribute("firstName", firstName);
//		model.addAttribute("email", email);
//		model.addAttribute("program", program);
//		mySession.setAttribute("firstName", firstName);
//		return "result.jsp";
//	}	
//	
//	
//	@GetMapping("/info")
//	public String info()
//	{
//		return "info.jsp";
//	}
//	
//	
//	
//	
//	
//	@RequestMapping("/first")	
//	public String first(Model model)
//	{
//		model.addAttribute("firstName","B");
//		model.addAttribute("stack","Fair");
//		return "index.jsp";
//	}
//	
//
//	
//	@RequestMapping("/java")	
//	public String java()
//	{
//		return "java is cooler than python";
//	}
//	
//	
//	
//	@RequestMapping("/welcome")	
//	public String welcome(@RequestParam(value="n") String name)
//	{
//		return String.format("Welcome to coding dojo %s", name);
//	}

//
//@GetMapping("/time")
//public String time(Model model)
//{
//	LocalTime time = LocalTime.now();
//	DateTimeFormatter fTimeObj = DateTimeFormatter.ofPattern("h:mm a");
//	String fTime = time.format(fTimeObj);
//	model.addAttribute("time", fTime);
//	return "time.jsp";
//}
//
//@GetMapping("/date")
//public String date(Model model)
//{
//	LocalDate date = LocalDate.now();
//	DateTimeFormatter fDateObj = DateTimeFormatter.ofPattern("E, MMM dd, yyyy");
//	String fDate = date.format(fDateObj);
//	model.addAttribute("date", fDate);
//	return "date.jsp";
//}
//
