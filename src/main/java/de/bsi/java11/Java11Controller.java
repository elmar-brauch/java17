package de.bsi.java11;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/old")
public class Java11Controller {
	
	protected static List<Object> objects = new ArrayList<>();
	
	// TODO Use Text Block
	@GetMapping
	public String showItems() {
		String html = "<html><body>" +   
				"<h1>%d items have been created with following names:</h1>" + 
				"<h1>%s</h1>" + 
				"</body></html>";
		
		List<Java11Item> itemsToShow = getItemList(); 
		
		return String.format(html, itemsToShow.size(), itemsToShow);
	}
	
	// TODO Use Pattern matching instanceof
	private List<Java11Item> getItemList() {
		List<Java11Item> items = new ArrayList<>();
		for (Object object : objects) {
			if (object instanceof Java11Item) {
				Java11Item castedItem = (Java11Item) object;
				if (!castedItem.getName().isBlank())
					items.add(castedItem);
			}
		}
		return items;
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

}
