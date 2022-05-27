package classes;

public class Address {

    private Orientation orientation;
    private String orientationId;
    private String locationId;
    private String blockName;
    private String cityName;

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public String getOrientationId() {
        return orientationId;
    }

    public void setOrientationId(String orientationId) {
        this.orientationId = orientationId;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getBlockName() {
        return blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Address(Orientation orientation, String orientationId, String locationId, String blockName, String cityName) {
        this.orientation = orientation;
        this.orientationId = orientationId;
        this.locationId = locationId;
        this.blockName = blockName;
        this.cityName = cityName;
    }

    public String getAddress(){
        return this.getOrientation().toString()+" "+this.getOrientationId()+" "+this.getLocationId()+
                " "+this.getBlockName()+""+this.getCityName();
    }

}
