package backend;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Customer {
    public static final int WATER_BRANDS = 5;
    public static final double credit[] = { 10.0, 25.0, 50.0, 50.0, 50.0 };
    public String name;
    public String phoneNumber;
    public double water[] = new double[WATER_BRANDS];

    public boolean hasLastBought = false;
    public Date lastBought;
    public double lastWater[] = new double[WATER_BRANDS];
    // FilterFresh, ReverseOsmosis, InstantOcean, Brackish, RedSea

    // CONSTRUCTORS
    public Customer(String fromString) {
        String[] parts = fromString.split(CIO.FILE_DELIMETERS[1]);

        importData(parts[0]);
        try {
            importLastData(parts[1]);
        } catch (Exception e) {
            applyPurchase(new Purchase());
        }
    }

    private void importData(String data) {
        String[] parts = data.split(CIO.FILE_DELIMETERS[0]);

        name = parts[0].trim();
        phoneNumber = parts[1].trim();
        for (int i = 0; i < water.length; i++) {
            water[i] = Double.parseDouble(parts[i + 2]);
        }
    }

    @Deprecated
    private void importLastData(String data) {
        hasLastBought = true;
        String[] parts = data.split(CIO.FILE_DELIMETERS[0]);
        try {
            lastBought = new Date(parts[0]);
        } catch (Exception e) {
        }
        for (int i = 0; i < water.length; i++) {
            lastWater[i] = Double.parseDouble(parts[i + 1]);
        }
    }

    // ADD/SUBTRACT
    public void addWater(int index, double gal) {
        water[index] += gal;
    }

    public void removeWater(int index, double gal) {
        water[index] -= gal;
    }

    public void applyPurchase(Purchase p) {
        hasLastBought = true;
        lastBought = p.purchaseDate;
        lastWater = p.water;

        for (int i = 0; i < water.length; i++) {
            addWater(i, p.water[i]);
        }
    }

    public boolean redeem(int index, double numGal) throws IllegalArgumentException {
        if (numGal > amountRedeemable(index)) {
            throw new IllegalArgumentException();
        }
        water[index] -= numGal * 5;
        return true;
    }

    public double amountRedeemable(int index) { // returns amount of water that can be redeemed of type index.
        return (water[index] < credit[index]) ? 0 : Math.round(water[index] / 5);
    }
    // OVERRIDES/MISC

    @Override
    public String toString() {
        String delim = CIO.FILE_DELIMETERS[0];

        String out = name + delim + phoneNumber;
        for (int i = 0; i < water.length; i++) {
            out += delim + water[i];
        }

        out += CIO.FILE_DELIMETERS[1];

        if (lastBought == null) // if they dont have data for the last time they bought stuff.
            return out;
        out += lastBought.toString();
        for (int i = 0; i < water.length; i++) {
            out += delim + lastWater[i];
        }

        return out;
    }
}