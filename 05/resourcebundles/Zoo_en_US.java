package resourcebundles;

import java.util.*;

public class Zoo_en_US extends ListResourceBundle {
	protected Object[][] getContents() {
		return new Object[][] {
			{"zoo", "New York Java Zoo"},
			{"open", "Java Zoo is open"},
			{"tax", new Double(0.15)}

		};
	}
}
