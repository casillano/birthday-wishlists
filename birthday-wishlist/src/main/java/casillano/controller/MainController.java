package casillano.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import casillano.entity.Friend;
import casillano.service.ServiceInterface;

@Controller
@RequestMapping("/friends")
public class MainController {
	
	@Autowired
	private ServiceInterface friendService;
	
	// main page that shows the database entries
	
	@GetMapping("/showAll")
	public String showAllFriends(Model model) {
		
		// get all entries from the database
		List<Friend> friends = friendService.getFriends();
		model.addAttribute("friends", friends);
		model.addAttribute("searchText", null);
		return "show-friends2";
	}
	
	// take the text from the search bar and use it to search
	// through all of the friends
	
	@GetMapping("/search")
	public String searchForFriends(@RequestParam("searchName") String search, Model model) {
		List<Friend> friends = friendService.searchFriends(search);
		model.addAttribute("friends", friends);
		model.addAttribute("searchText", search);
		return "show-friends2";
	}
	
	// used for saving or updating a friend
	
	@PostMapping("/saveFriend")
	public String saveFriend(
			@Valid @ModelAttribute("friend") Friend friend,
			BindingResult bindingResult) {
		
		// check if the form entries are valid
		if (bindingResult.hasErrors()) {
			return "friend-form";
		} else {
			System.out.println("no error found");
			friendService.saveOrUpdateFriend(friend);
			return "redirect:/friends/showAll";
		}
	}
	
	@GetMapping("/showAddForm")
	public String showAddForm(Model model) {
		// add friend object to model so that it can be populated
		// by the form
		Friend friend = new Friend();
		model.addAttribute("friend", friend);
		return "friend-form";
	}
	
	@GetMapping("/showUpdateForm")
	public String showUpdateForm(@RequestParam("friendId") int id, Model model) {
		Friend friend = friendService.getFriend(id);
		model.addAttribute("friend", friend);
		return "friend-form";
	}
	
	@GetMapping("deleteFriend")
	public String deleteFriend(@RequestParam("friendId") int id) {
		friendService.deleteFriend(id);
		return "redirect:/friends/showAll";
	}
	
	
	@InitBinder     
	public void initBinder(WebDataBinder binder){
	     binder.registerCustomEditor(Date.class,
	    		 new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10)); 
	     
	     // trims strings so that all-whitespace strings are treated as null
	     StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
			
			binder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
}
