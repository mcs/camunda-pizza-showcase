package de.solutionscamp.bpmn.listener;

import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;

import de.solutionscamp.bpmn.MessageNames;

public class PizzaGeliefertTaskListener implements TaskListener {

	@Override
	public void notify(DelegateTask task) {
		String parentProcessInstanceId = (String) task
				.getVariable(MessageNames.BESTELL_PROC_INST_ID);
		task.getProcessEngineServices()
				.getRuntimeService()
				.createMessageCorrelation("pizzaGeliefertMessage")
				.processInstanceId(parentProcessInstanceId)
				.correlate();
	}

}
