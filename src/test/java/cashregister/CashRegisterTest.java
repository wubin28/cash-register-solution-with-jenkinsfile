package cashregister;

import org.junit.Test;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

public class CashRegisterTest {
    @Test
    public void processShouldPrintTheRealPurchase() throws Exception {
        Item items[] = new Item[] {
                new Item("Item 10", 50),
                new Item("Item 2", 60)
        };
        Purchase purchase = new Purchase(items);
        MockPrinter printer = new MockPrinter();
        CashRegister cashRegister = new CashRegister(printer);

        bbb();

        cashRegister.process(purchase);

        printer.verifyThatPrintWasCalledWith(purchase.asString());
    }

    @Test
    public void processShouldPrintTheStubPurchase() throws Exception {
        StubPurchase purchase = new StubPurchase("purchase as string");
        MockPrinter printer = new MockPrinter();

        CashRegister cashRegister = new CashRegister(printer);

        cashRegister.process(purchase);

        printer.verifyThatPrintWasCalledWith("purchase as string");
    }

    @Test
    public void processShouldPrintThePurchaseUsingMockito() throws Exception {
        Purchase purchase = mock(Purchase.class);
        when(purchase.asString()).thenReturn("purchase as string");
        Printer printer = mock(Printer.class);

        CashRegister cashRegister = new CashRegister(printer);

        cashRegister.process(purchase);

        verify(printer, times(1)).print("purchase as string");
    }

    @Test
    public void processShouldPrintThePurchaseUsingMockitoBdd() throws Exception {
        Purchase purchase = mock(Purchase.class);
        given(purchase.asString()).willReturn("purchase as string");
        Printer printer = mock(Printer.class);

        CashRegister cashRegister = new CashRegister(printer);

        cashRegister.process(purchase);

        then(printer).should(times(1)).print("purchase as string");
    }
}
