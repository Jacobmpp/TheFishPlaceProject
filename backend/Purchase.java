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
}
