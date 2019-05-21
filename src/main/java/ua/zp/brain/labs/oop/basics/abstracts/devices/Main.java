package ua.zp.brain.labs.oop.basics.abstracts.devices;

/**
 * The class of the Abstract device, which is intended to build a typical household appliance tree.
 *
 * @author Pavlo Degtyaryev
 * @version 1.0
 */
public class Main {
    private static Mobile mobile1;
    private static Mobile mobile2;
    private static Oven oven1;
    private static Oven oven2;
    private static MultiCooker multiCooker1;
    private static MultiCooker multiCooker2;
    private static SmartPhone smartPhone1;
    private static SmartPhone smartPhone2;
    private static DialPhone dialPhone1;
    private static DialPhone dialPhone2;

    public static void main(String[] args) {

        testMobile();

        testDialPhone();

        testSmartPhone();

        testMultiCooker();

        testOven();

        testPowerOffAll(mobile1, mobile2, dialPhone1, dialPhone2, smartPhone1,
                smartPhone2, multiCooker1, multiCooker2, oven1, oven2);
    }

    /**
     * Call powerOff method on all not null devices
     *
     * @param device {@link AbstractMultiCooker}
     */
    private static void testPowerOffAll(AbstractDevice... device) {
        System.out.println("\n========== Switch off all given devices ==========");
        for (AbstractDevice d : device) {
            if (d != null) {
                System.out.print("Try switch off object of "+ d.getClass().getName()+": \""+d.getName()+"\"- ");
                d.powerOff();
            }
        }
    }

    public static void testOven() {
        System.out.println("\n========== Create instances of Oven ==========");
        oven1 = new Oven("ТМ ASEL", "ACE-9823489080234");
        oven2 = new Oven("ТМ ASEL", "ACE-9823489080234");

        System.out.println("\n++++++++++ Print info about Device object by calling toString() method.");
        System.out.println(oven1);

        System.out.println("\n++++++++++ PowerOn Device");
        oven1.powerOn();

        System.out.println("\n++++++++++ PowerOff Device");
        oven1.powerOff();

        System.out.println("\n++++++++++ SwitchPower Device");
        oven1.switchPower();

        System.out.println("\n++++++++++ Make switch initTimer() by Device");
        oven1.initTimer();

        System.out.println("\n++++++++++ Make cook() by Device");
        oven1.cook();

        System.out.println("\n++++++++++ Compare two Devices");
        System.out.println(oven1.equals(oven2));
    }

    public static void testMultiCooker() {
        System.out.println("\n========== Create instances of MultiCooker ==========");
        multiCooker1 = new MultiCooker("REDMOND RMC-M90", "RE1231-123123");
        multiCooker2 = new MultiCooker("REDMOND RMC-M90", "RE1231-123123");

        System.out.println("\n++++++++++ Print info about Device object by calling toString() method.");
        System.out.println(multiCooker1);

        System.out.println("\n++++++++++ PowerOn Device");
        multiCooker1.powerOn();

        System.out.println("\n++++++++++ PowerOff Device");
        multiCooker1.powerOff();

        System.out.println("\n++++++++++ SwitchPower Device");
        multiCooker1.switchPower();

        System.out.println("\n++++++++++ Make switch Program() by Device");
        multiCooker1.switchProgram();

        System.out.println("\n++++++++++ Make cook() by Device");
        multiCooker1.cook();

        System.out.println("\n++++++++++ Compare two Devices");
        System.out.println(multiCooker1.equals(multiCooker2));
    }

    public static void testSmartPhone() {
        System.out.println("\n========== Create instances of SmartPhone ==========");
        smartPhone1 = new SmartPhone("Xiaomi Remi Note 3 Pro", "XI2342348", 2, "1769*1028", "Android 8");
        smartPhone2 = new SmartPhone("Xiaomi Remi Note 3 Pro", "XI2342348", 2, "1769*1028", "Android 8");

        System.out.println("\n++++++++++ Print info about Device object by calling toString() method.");
        System.out.println(smartPhone1);

        System.out.println("\n++++++++++ PowerOn Device");
        smartPhone1.powerOn();

        System.out.println("\n++++++++++ PowerOff Device");
        smartPhone1.powerOff();

        System.out.println("\n++++++++++ SwitchPower Device");
        smartPhone1.switchPower();

        System.out.println("\n++++++++++ Make Call by Device");
        smartPhone1.call();

        System.out.println("\n++++++++++ Make runApp() by Device");
        smartPhone1.runApp();

        System.out.println("\n++++++++++ Compare two Devices");
        System.out.println(smartPhone1.equals(smartPhone2));
    }

    public static void testDialPhone() {
        System.out.println("\n========== Create instances of DialPhone ==========");
        dialPhone1 = new DialPhone("Panasonic KX-232", "PX082345034", true);
        dialPhone2 = new DialPhone("Panasonic KX-232", "PX082345034", true);

        System.out.println("\n++++++++++ Print info about Device object by calling toString() method.");
        System.out.println(dialPhone1);

        System.out.println("\n++++++++++ PowerOn Device");
        dialPhone1.powerOn();

        System.out.println("\n++++++++++ PowerOff Device");
        dialPhone1.powerOff();

        System.out.println("\n++++++++++ SwitchPower Device");
        dialPhone1.switchPower();

        System.out.println("\n++++++++++ Make Call by Device");
        dialPhone1.call();

        System.out.println("\n++++++++++ Make autoAnswer() by Device");
        dialPhone1.autoAnswer();

        System.out.println("\n++++++++++ Compare two Devices");
        System.out.println(dialPhone1.equals(dialPhone2));
    }

    public static void testMobile() {
        System.out.println("\n========== Create instances of Mobile ==========");
        mobile1 = new Mobile("Samsung", "QWE891293787", 1, "6*15");
        mobile2 = new Mobile("Samsung", "QWE891293787", 1, "6*15");

        System.out.println("\n++++++++++ Print info about Mobile object by calling toString() method.");
        System.out.println(mobile1);

        System.out.println("\n++++++++++ PowerOn Device");
        mobile1.powerOn();

        System.out.println("\n++++++++++ PowerOff Device");
        mobile1.powerOff();

        System.out.println("\n++++++++++ SwitchPower Device");
        mobile1.switchPower();

        System.out.println("\n++++++++++ Make Call by Device");
        mobile1.call();

        System.out.println("\n++++++++++ Compare two Devices");
        System.out.println(mobile1.equals(mobile2));
    }
}
