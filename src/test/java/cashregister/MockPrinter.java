package cashregister;

import cashregister.Printer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MockPrinter extends Printer {
    private boolean printWasCalled = false;
    private String printWasCalledWith = null;

    @Override
    public void print(String printThis) {
        printWasCalledWith = printThis;
        printWasCalled = true;
    }

    public void verifyThatPrintWasCalled() {
        assertTrue("expected print to be called at least once, print was not called", printWasCalled);
    }

    public void verifyThatPrintWasCalledWith(String printThis) {
        verifyThatPrintWasCalled();
        assertEquals("expected print to be called with '" + printThis + "', but was called with '" + printWasCalledWith + "'",
                printThis, printWasCalledWith);
    }
}
