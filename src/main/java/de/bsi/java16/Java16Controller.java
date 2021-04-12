package de.bsi.java16;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/new")
public class Java16Controller {
	
	protected static List<Object> objects = new ArrayList<>();
	
	// Text Block used.
	@GetMapping
	public String showItems() {
		String html = """
				<html>
					<body>
						<h1>%d items have been created with following names:</h1>
						<h1>%s</h1>
					</body>
				</html>
				""";
		
		var itemsToShow = getItemList(); 
		
		return html.formatted(itemsToShow.size(), itemsToShow);
	}
	
	// New switch
	@PostMapping
	public void addItem(@RequestParam int format, @RequestBody Java16Item item) {
		Object toBeAdded = switch (format) {
		case 1, 2:
			yield new Java16Item(item.name().toUpperCase(), item.id());
		case 3, 4:
			yield new Java16Item(item.name().toLowerCase(), item.id());
		default:
			yield "Unknown format";
		};
		objects.add(toBeAdded);
	}

	// Pattern matching instanceof
	private List<Java16Item> getItemList() {
		var items = new ArrayList<Java16Item>();
		for (Object object : objects)
			if (object instanceof Java16Item item && !item.name().isBlank())
				items.add(item);
		return items;
	}
}
