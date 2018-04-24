package adaptor;

import mediator.ModelManager;

public interface Adaptor {
	public ModelManager getModel();
	public void setModel(ModelManager model);

}
