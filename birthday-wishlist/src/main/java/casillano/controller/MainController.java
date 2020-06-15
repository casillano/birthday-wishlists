package casillano.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping("/showAll")
	public String showAllFriends(Model model) {
		List<Friend> friends = friendService.getFriends();
		model.addAttribute("friends", friends);
		model.addAttribute("searchText", null);
		return "show-friends";
	}
	
	@GetMapping("/search")
	public String searchForFriends(@RequestParam("searchName") String search, Model model) {
		List<Friend> friends = friendService.searchFriends(search);
		model.addAttribute("friends", friends);
		model.addAttribute("searchText", search);
		return "show-friends";
	}
	
	@PostMapping("/saveFriend")
	public String saveFriend(@ModelAttribute("friend") Friend friend) {
		friendService.saveOrUpdateFriend(friend);
		return "redirect:/friends/showAll";
	}
	
	@GetMapping("/showAddForm")
	public String showAddForm(Model model) {
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
		return "redirect:/friend/showAll";
	}
}
