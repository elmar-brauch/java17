package de.bsi.java17;

import org.springframework.web.bind.annotation.*;

import de.bsi.java11.Java11Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// This class is used for presentations
@RestController
@RequestMapping("/jdk17")
public class JavaController {
	
	protected static List<Object> objects = new ArrayList<>();
	
	// TODO Use Text Block
	@GetMapping
	public String showItems() {
		String html = "<html><body>" +   
				"<h1>%d items have been created with following names:</h1>" + 
				"<h1>%s</h1>" + 
				"</body></html>";
		
		var itemsToShow = getItemList(); 
		
		return String.format(html, itemsToShow.size(), itemsToShow);
	}
	
	// TODO Use new switch
	@PostMapping
	public void addItem(@RequestParam int format, @RequestBody Java11Item item) {
		Object toBeAdded = null;
		switch (format) {
		case 1:
			item.setName(item.getName().toUpperCase());
			toBeAdded = item;
			break;
		case 2:
			item.setName(item.getName().toUpperCase());
			toBeAdded = item;
			break;
		case 3:
		case 4:
			item.setName(item.getName().toLowerCase());
			toBeAdded = item;
			break;
		default:
			toBeAdded = "Unknown format";
		}
		objects.add(toBeAdded);
	}
	
	// TODO Use Pattern matching instanceof
	private List<Java11Item> getItemList() {
		var items = new ArrayList<Java11Item>();
		for (Object object : objects) {
			if (object instanceof Java11Item) {
				Java11Item castedItem = (Java11Item) object;
				if (!castedItem.getName().isBlank())
					items.add(castedItem);
			}
		}
		return items;
	}

	// TODO Use new Enhanced Pseudo-Random Number Generators
	// TODO Use Pattern Matching for switch
	private int generateRandomNumbers() {
		var random = new Random();
		random.ints(5, 1, 100)
				.forEach(i -> System.out.println("Random Int: " + i));
		random.doubles(5)
				.forEach(d -> System.out.println("Random Double: " + d));
		return random.nextInt();
	}
}
