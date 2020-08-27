package defaultrepository.impl;

import de.uka.ipd.sdq.simucomframework.variables.StackContext;
import defaultrepository.ITransaction;
import org.apache.log4j.Logger;

public class TransactionThread extends Thread implements Runnable {

    private static final Logger LOGGER = Logger.getLogger(TransactionThread.class);

    // for Transaction
    private StackContext ctx;
    private ITransaction iTransaction;


    public TransactionThread(String threadName, StackContext ctx, ITransaction iTransaction) {
        super(threadName);

        this.ctx = ctx;
        this.iTransaction = iTransaction;
    }

    public void run() {
        LOGGER.debug(this.getName() + "executeTransaction()");
        this.iTransaction.executeTransaction0(this.ctx);
    }

}
