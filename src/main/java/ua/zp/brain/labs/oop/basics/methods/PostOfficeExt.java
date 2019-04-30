package ua.zp.brain.labs.oop.basics.methods;

import ua.zp.brain.labs.oop.basics.classes.PostOffice;

/**
 * Extended book
 *
 * @author Pavlo Degtyaryev
 * @version 1.0
 */
public class PostOfficeExt extends PostOffice {

    /**
     * Calulate Volumetric Weight of parcel
     *
     * @param height in cm
     * @param width in cm
     * @param dept in cm
     * @param weight in gramm
     * @return Volumetric Weight of parcel
     */
    public static int CalculateVolumetricWeight(int height, int width, int dept, int weight) {
        int volumetricWeight = height * width * dept;
        return volumetricWeight > weight ? volumetricWeight : weight;
    }

    /**
     * Calulate Volumetric Weight of cylindrical parcel
     *
     * @param height mm
     * @param diametr mm
     * @param weight gramm
     * @return Volumetric Weight of parcel
     */
    public static int CalculateVolumetricWeight(int height, int diametr, int weight) {
        int volumetricWeight = height * diametr;
        return volumetricWeight > weight ? volumetricWeight : weight;
    }
}
