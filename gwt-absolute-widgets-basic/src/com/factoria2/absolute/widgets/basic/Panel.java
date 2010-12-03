package com.factoria2.absolute.widgets.basic;

import com.factoria2.absolute.widgets.AbsWidget;
import com.factoria2.absolute.widgets.geom.Insets;
import com.factoria2.absolute.widgets.geom.Rectangle;
import com.factoria2.absolute.widgets.geom.Size;

public class Panel<T extends AbsWidget> extends AbsWidget {

	private T widget;
	private Insets insets = Insets.NONE;

	public Panel() {
	}

	public Panel(final T widget) {
		setWidget(widget);
	}

	public Insets getInsets() {
		return insets;
	}

	@Override
	public Size getPreferredSize() {
		if (widget != null) {
			Size size = widget.getPreferredSize();
			size = size.growBy(insets.getAggregatedSize());
			if (getBorder() != null) {
				size = size.growBy(getBorder().getWidth().getAggregatedSize());
			}
			return size;
		} else {
			return Size.EMPTYNESS;
		}
	}

	public T getWidget() {
		return widget;
	}

	public void setInsets(final Insets insets) {
		this.insets = insets;
		relayout();
	}

	public void setWidget(final T widget) {
		if (this.widget != null) {
			this.widget.removeFromParent();
		}
		this.widget = widget;
		if (this.widget != null) {
			addChild(this.widget);
		}
	}

	@Override
	protected void layoutChildren(final Rectangle clientBounds) {
		if (widget != null) {
			widget.setBounds(clientBounds.shrinkBy(insets));
		}
	}
}
