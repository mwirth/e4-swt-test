package e4.test;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;

public class ComboControl {
	
	@Inject
	EPartService partService;

	@PostConstruct
	public void createGui(final Composite parent) {
		Combo combo = new Combo(parent, SWT.READ_ONLY);
		combo.add("One");
		combo.add("Two");
		combo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				super.widgetSelected(e);
				Object source = e.getSource();
				if (((Combo) e.widget).getText().equalsIgnoreCase("one")) {
					partService.switchPerspective("e4.test.perspective.perspectiveone");
				} else if (((Combo) e.widget).getText().equalsIgnoreCase("two")) {
					partService.switchPerspective("e4.test.perspective.perspectivetwo");
				}

			}
		});
	}

}