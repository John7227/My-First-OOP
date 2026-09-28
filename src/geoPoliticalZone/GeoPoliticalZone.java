package geoPoliticalZone;

public enum GeoPoliticalZone {

    BENUE("NORTH CENTRAL"),
    FCT("NORTH CENTRAL"),
    KOGI("NORTH CENTRAL"),
    KWARA("NORTH CENTRAL"),
    NASARAWA("NORTH CENTRAL"),
    NIGER("NORTH CENTRAL"),
    PLATEAU("NORTH CENTRAL"),

    ADAMAWA("NORTH EAST"),
    BAUCHI("NORTH EAST"),
    BORNO("NORTH EAST"),
    GOMBE("NORTH EAST"),
    TARABA("NORTH EAST"),
    YOBE("NORTH EAST"),

    KATSINA("NORTH WEST"),
    KANO("NORTH WEST"),
    KEBBI("NORTH WEST"),
    SOKOTO("NORTH WEST"),
    JIGAWA("NORTH WEST"),
    ZAMFARA("NORTH WEST"),

    ABIA("SOUTH EAST"),
    ANAMBRA("SOUTH EAST"),
    EBONYI("SOUTH EAST"),
    ENUGU("SOUTH EAST"),
    IMO("SOUTH EAST"),

    AKWA_IBOM("SOUTH-SOUTH"),
    BAYELSA("SOUTH-SOUTH"),
    CROSS_RIVER("SOUTH-SOUTH"),
    DELTA("SOUTH-SOUTH"),
    EDO("SOUTH-SOUTH"),
    RIVERS("SOUTH-SOUTH"),

    EKITI("SOUTH WEST"),
    LAGOS("SOUTH WEST"),
    OSUN("SOUTH WEST"),
    ONDO("SOUTH WEST"),
    OGUN("SOUTH WEST"),
    OYO("SOUTH WEST");

    private final String zone;

    GeoPoliticalZone(String zone) {
        this.zone = zone;
    }

    public String getZone() {
        return zone;
    }
}
