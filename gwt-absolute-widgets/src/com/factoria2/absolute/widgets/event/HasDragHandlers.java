package com.factoria2.absolute.widgets.event;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;

public interface HasDragHandlers extends HasHandlers {
	HandlerRegistration addDragHandler(DragHandler handler);
}
