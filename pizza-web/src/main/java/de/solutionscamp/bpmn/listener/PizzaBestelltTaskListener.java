package de.solutionscamp.bpmn.listener;

import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;

import de.solutionscamp.bpmn.MessageNames;

public class PizzaBestelltTaskListener implements TaskListener {

	@Override
	public void notify(DelegateTask task) {
		task.getProcessEngineServices()
				.getRuntimeService()
				.createMessageCorrelation("pizzaBestelltMessage")
				.setVariable(MessageNames.BESTELL_PROC_INST_ID,
						task.getProcessInstanceId())
				.setVariable(MessageNames.GROESSE,
						task.getVariable(MessageNames.GROESSE))
				.setVariable(MessageNames.ADRESSE,
						task.getVariable(MessageNames.ADRESSE))
				.correlate();
	}

}
