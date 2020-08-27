package defaultsystem.impl;

public interface IdefaultSystem extends java.io.Serializable {
    void setContext(Object myContext);

    defaultrepository.IExperimentManager getPortProvided_IExperimentManager();
}
