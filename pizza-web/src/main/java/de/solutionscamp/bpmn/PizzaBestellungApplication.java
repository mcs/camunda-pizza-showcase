package de.solutionscamp.bpmn;

import org.camunda.bpm.application.ProcessApplication;
import org.camunda.bpm.application.impl.ServletProcessApplication;

@ProcessApplication("Pizza-Bestellprozess")
public class PizzaBestellungApplication extends ServletProcessApplication {

}
