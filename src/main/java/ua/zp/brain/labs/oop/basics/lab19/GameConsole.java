package ua.zp.brain.labs.oop.basics.lab19;

/**
 * Java object  that represents of Game Console with two {@link GamePad}'s
 *
 * @author Pavlo Gedtyaryev
 * @version 1.0
 */
public class GameConsole implements Powered {

    private final Brand brand;
    private final String serial;
    private final String model;
    private GamePad firstGamePad;
    private GamePad secondGamePad;
    private boolean on;
    private Game activeGame;
    private int waitingCounter;

    /**
     * Construct console with specified values
     *
     * @param brand  name of brand
     * @param model  Model of console
     * @param serial Serial number of console
     */
    public GameConsole(Brand brand, String model, String serial) {
        this.brand = brand;
        this.serial = serial;
        this.model = model;
        firstGamePad = new GamePad(this.brand, 1);
        secondGamePad = new GamePad(this.brand, 2);
        firstGamePad.color = Color.COLOR_BLUE;
        secondGamePad.color = Color.COLOR_RED;
    }

    @Override
    public String toString() {
        return "GameConsole{" +
                "brand=" + brand +
                ", serial='" + serial + '\'' +
                ", model='" + model + '\'' +
                ", \nactiveGame=" + activeGame +
                ", \npoweredOn=" + on +
                ", waitingCounter=" + waitingCounter +
                ", \nfirstGamePad=" + firstGamePad +
                ", \nsecondGamePad=" + secondGamePad +
                '}';
    }

    /**
     * if Console is powered on loads the specifies Game
     *
     * @param game load specifies Game
     */
    public void loadGame(Game game) {
        this.activeGame = game;
        if (game != null && isOn()) {
            System.out.printf("Игра \"%s\" загружается...\n", game.getName());
        }
    }

    /**
     * Play the active Game if Console is powered on and powered at least one GamePad.
     * Each time the status of active joysticks is checked.
     * If they are not active for a certain time, the console NoActivityException exception is thrown.
     * <p>
     * Show information about charge of joysticks and discharge the active joystick on certain value
     *
     * @throws NoActivityException
     */
    public void playGame() throws NoActivityException {
        if (activeGame == null) {
            return;
        }
        checkStatus();
        System.out.printf("Играем в \"%s\".", activeGame.getName());
        if (firstGamePad != null && firstGamePad.isOn()) {
            System.out.printf(" Заряд первого джойстика: %.0f%%", firstGamePad.getChargeLevel());
            firstGamePad.beingDischarged();
        }
        if (secondGamePad != null && secondGamePad.isOn()) {
            System.out.printf(" Заряд второго джойстика: %.0f%%", secondGamePad.getChargeLevel());
            secondGamePad.beingDischarged();
        }
        System.out.println();
    }

    /**
     * Check the activity status. If they are not active for a certain time,
     * the console is turned off and an exception is thrown.
     *
     * @throws NoActivityException
     */
    private void checkStatus() throws NoActivityException {
        if ((firstGamePad == null || !firstGamePad.isOn()) && (secondGamePad == null || !secondGamePad.isOn())) {
            waitingCounter++;
            System.out.println("Подключите джойстик");
        } else {
            waitingCounter = 0;
        }
        if (waitingCounter > 5) {
            setOn(false);
            throw new NoActivityException("Приставка завершает работу из-за отсутствия активности");
        }
    }

    /**
     * Check connected end powered joysticks. If only second joystick powered then it connectionNumber set to 1
     */
    private void checkConnections() {
        int port = 1;
        if (firstGamePad != null && firstGamePad.isOn()) {
            firstGamePad.setConnectedNumber(port);
            port++;
        }
        if (secondGamePad != null && secondGamePad.isOn()) {
            secondGamePad.setConnectedNumber(port);
        }
    }

    public Brand getBrand() {
        return brand;
    }

    public String getSerial() {
        return serial;
    }

    public String getModel() {
        return model;
    }

    public GamePad getFirstGamePad() {
        return firstGamePad;
    }

    public void setFirstGamePad(GamePad firstGamePad) {
        this.firstGamePad = firstGamePad;
    }

    public GamePad getSecondGamePad() {
        return secondGamePad;
    }

    public void setSecondGamePad(GamePad secondGamePad) {
        this.secondGamePad = secondGamePad;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
        if (on) {
            checkConnections();
        }
    }

    @Override
    public void powerOn() {
        if (!isOn()) {
            setOn(true);
        }
    }

    @Override
    public void powerOff() {
        if (isOn()) {
            setOn(false);
        }
    }

    enum Brand {
        BRAND_SONY,
        BRAND_MICROSOFT;
    }

    enum Color {
        COLOR_GREEN,
        COLOR_RED,
        COLOR_BLUE;
    }

    /**
     * Object that represents GamePad for {@link GameConsole}
     */
    public class GamePad implements Powered {

        private final Brand brand;
        private final String consoleSerial;
        private int connectedNumber;
        private Float chargeLevel = 50.0f;
        private boolean on;
        private Color color;

        /**
         * Construct GamePad with specified values
         *
         * @param brand           Brand of Console
         * @param connectedNumber connection port number
         */
        private GamePad(Brand brand, int connectedNumber) {
            this.brand = brand;
            this.connectedNumber = connectedNumber;
            this.consoleSerial = serial;
        }

        public Float getChargeLevel() {
            return chargeLevel;
        }

        public void setChargeLevel(Float chargeLevel) {
            this.chargeLevel = chargeLevel;
        }

        /**
         * discharge on 10% and switch off if charge level lower than 0
         */
        public void beingDischarged() {
            chargeLevel -= 10f;
            if (chargeLevel <= 0f) {
                chargeLevel = 0f;
                setOn(false);
            }
        }

        public String getConsoleSerial() {
            return consoleSerial;
        }

        public Brand getBrand() {
            return brand;
        }

        public int getConnectedNumber() {
            return connectedNumber;
        }

        public void setConnectedNumber(int connectedNumber) {
            this.connectedNumber = connectedNumber;
        }

        public Color getColor() {
            return color;
        }

        public boolean isOn() {
            return on;
        }

        /**
         * set pad to powered state or to off. if powered on then turn on gameConsole end set charge level of GamePad to 100%
         *
         * @param on powered or off
         */
        public void setOn(boolean on) {
            this.on = on;
            if (!GameConsole.this.isOn() && on) { // if Console is off and turns GamePad on
                GameConsole.this.setOn(on);
            }
            if (GameConsole.this.isOn()) {
                GameConsole.this.checkConnections();
            }
            if (on) {
                setChargeLevel(100f);
            }
        }

        @Override
        public String toString() {
            return "GamePad{" +
                    "brand=" + brand +
                    ", consoleSerial='" + consoleSerial + '\'' +
                    ", \nconnectedNumber=" + connectedNumber +
                    ", \nchargeLevel=" + chargeLevel +
                    ", \npoweredOn=" + on +
                    ", color=" + color +
                    '}';
        }

        @Override
        public void powerOn() {
            if (!isOn()) {
                setOn(true);
            }
        }

        @Override
        public void powerOff() {
            if (isOn()) {
                setOn(false);
            }
        }
    }
}
