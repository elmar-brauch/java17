package de.bsi.java17;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.random.RandomGenerator;
import java.util.stream.BaseStream;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/new")
public class Java17Controller {
	
	protected static List<Object> objects = new ArrayList<>();
	
	// JEP 378: Text Blocks
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
	
	// JEP 361: Switch Expressions
	@PostMapping
	public void addItem(@RequestParam int format, @RequestBody Java17Item item) {
		Object toBeAdded = switch (format) {
		case 1, 2:
			yield new Java17Item(item.name().toUpperCase(), generateRandomNumber());
		case 3, 4:
			yield new Java17Item(item.name().toLowerCase(), generateRandomNumber());
		default:
			yield "Unknown format";
		};
		objects.add(toBeAdded);
	}

	// JEP 394: Pattern Matching for instanceof
	private List<Java17Item> getItemList() {
		var items = new ArrayList<Java17Item>();
		for (Object object : objects)
			if (object instanceof Java17Item item && !item.name().isBlank())
				items.add(item);
		return items;
	}

	// JEP 356: Enhanced Pseudo-Random Number Generators
	private int generateRandomNumber() {
		var random = RandomGenerator.JumpableGenerator.of("Xoroshiro128PlusPlus");
		printStream(
				random.ints(5,1,100)
		);
		random.jump();
		printStream(
				random.doubles(5)
		);
		return random.nextInt();
	}

	@SuppressWarnings("preview")
	// JEP 406: Pattern Matching for switch (Preview)
	private void printStream(BaseStream stream) {
		switch (stream) {
			case null -> System.out.println("null is now a possible case.");
			case IntStream is && is.isParallel() -> System.out.println("Expression in case.");
			case IntStream is -> is.forEach(i -> System.out.println("Random Int: " + i));
			case DoubleStream ds -> ds.forEach(d -> System.out.println("Random Double: " + d));
			default -> throw new IllegalStateException("Unexpected value: " + stream);
		}
	}
}
