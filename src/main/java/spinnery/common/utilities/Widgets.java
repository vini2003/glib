package spinnery.common.utilities;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import net.minecraft.util.Identifier;
import spinnery.widget.implementation.*;

public class Widgets {
	private static final BiMap<Identifier, Class<? extends WAbstractWidget>> widgetMap = HashBiMap.create();

	public static Class<? extends WAbstractWidget> get(String className) {
		for (Class<? extends WAbstractWidget> widgetClass : widgetMap.values()) {
			if (widgetClass.getName().equals(className)) {
				return widgetClass;
			}
		}
		return null;
	}

	public static Class<? extends WAbstractWidget> get(Identifier id) {
		return widgetMap.get(id);
	}

	public static Identifier getId(Class<? extends WAbstractWidget> wClass) {
		return widgetMap.inverse().get(wClass);
	}

	public static void initialize() {
		register(new Identifier("spinnery", "widget"), WAbstractWidget.class);
		register(new Identifier("spinnery", "button"), WButton.class);
		register(new Identifier("spinnery", "horizontal_slider"), WHorizontalSlider.class);
		register(new Identifier("spinnery", "panel"), WPanel.class);
		register(new Identifier("spinnery", "slot"), WSlot.class);
		register(new Identifier("spinnery", "static_image"), WTexture.class);
		register(new Identifier("spinnery", "static_text"), WText.class);
		register(new Identifier("spinnery", "toggle"), WToggle.class);
		register(new Identifier("spinnery", "vertical_slider"), WVerticalSlider.class);
		register(new Identifier("spinnery", "vertical_bar"), WVerticalBar.class);
		register(new Identifier("spinnery", "horizontal_bar"), WHorizontalBar.class);
		register(new Identifier("spinnery", "vertical_scrollbar"), WVerticalScrollbar.class);
		register(new Identifier("spinnery", "vertical_scrollable_container"), WVerticalList.class);
		register(new Identifier("spinnery", "text_area"), WTextEditor.class);
		register(new Identifier("spinnery", "text_field"), WTextField.class);
		register(new Identifier("spinnery", "item"), WItem.class);
		register(new Identifier("spinnery", "vertical_arrow_up"), WVerticalArrowUp.class);
		register(new Identifier("spinnery", "vertical_arrow_down"), WVerticalArrowDown.class);
		register(new Identifier("spinnery", "sprite"), WSprite.class);
		register(new Identifier("spinnery", "status_bar"), WStatusBar.class);
	}

	public static void register(Identifier id, Class<? extends WAbstractWidget> wClass) {
		widgetMap.put(id, wClass);
	}
}