package com.factoria2.absolute.widgets.core.aspect;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.factoria2.absolute.widgets.core.aspect.value.Color;

//TODO: support multiple browsers with GWT.Create
public class Shadow implements HasCssProperties {

	public static final Shadow STANDARD_BLACK = new Shadow(Color.BLACK, 3, 3, 10);
	public static final Shadow STANDARD_WHITE = new Shadow(Color.WHITE, 3, 3, 10);

	private int vertical;
	private int horizontal;
	private int smoothness;
	private Color color;
	private Map<String, String> cssProps = new HashMap<String, String>();

	public Shadow(final Color color, final int width) {
		this(color, width, width, 2 * width);
	}

	public Shadow(final Color color, final int vertical, final int horizontal, final int smoothness) {
		this.color = color;
		this.vertical = vertical;
		this.horizontal = horizontal;
		this.smoothness = smoothness;

		cssProps.put("webkitBoxShadow", color.getCssValue() + " " + horizontal + "px " + vertical + "px " + smoothness + "px");
		cssProps.put("MozBoxShadow", color.getCssValue() + " " + horizontal + "px " + vertical + "px " + smoothness + "px");
		cssProps = Collections.unmodifiableMap(cssProps);
	}

	public Color getColor() {
		return color;
	}

	@Override
	public Map<String, String> getCssProperties() {
		return cssProps;
	}

	public int getHorizontal() {
		return horizontal;
	}

	public int getSmoothness() {
		return smoothness;
	}

	public int getVertical() {
		return vertical;
	}

}
