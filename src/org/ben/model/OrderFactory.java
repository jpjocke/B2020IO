package org.ben.model;

public class OrderFactory {
    private static final String DELIMITER = ",";
    /**
     * Creates an order from a line in an order log.
     * @param line One line from an order log.
     * @return An Order object
     */
    public static Order fromFileString(String line) {
        // Optimize if working with larger files, split is sub-pair.
        String[] split = line.split(DELIMITER);
        return new Order(split[0], split[1], split[2], Integer.parseInt(split[3]), split[4]);
    }
}
