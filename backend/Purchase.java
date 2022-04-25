package backend;

import java.util.Date;

public class Purchase {
    public Date purchaseDate;
    public double water[] = new double[Customer.WATER_BRANDS];

    public Purchase(double filterFresh, double reverseOsmosis, double instantOcean, double brackish, double redSea) {
        purchaseDate = new Date();

        water[0] = filterFresh;
        water[1] = reverseOsmosis;
        water[2] = instantOcean;
        water[3] = brackish;
        water[4] = redSea;
    }

    public Purchase(String encoded) throws NumberFormatException {
        purchaseDate = new Date();
        String parts[] = encoded.split(CIO.FILE_DELIMETERS[0]);
        for (int i = 0; i < Customer.WATER_BRANDS; i++) {
            water[i] = Double.parseDouble(parts[i]);
            if (water[i] < 0)
                throw new NumberFormatException();
        }
    }

    public Purchase() throws NumberFormatException {
        purchaseDate = new Date();
        for (int i = 0; i < Customer.WATER_BRANDS; i++) {
            water[i] = 0;
        }
    }
}
