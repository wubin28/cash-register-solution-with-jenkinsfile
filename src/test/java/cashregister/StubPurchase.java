package cashregister;

public class StubPurchase extends Purchase {
    private final String asString;

    public StubPurchase(String asString) {
        super(null);
        this.asString = asString;
    }

    @Override
    public String asString() {
        return asString;
    }
}
