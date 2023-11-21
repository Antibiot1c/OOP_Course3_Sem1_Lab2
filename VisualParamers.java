import java.math.BigDecimal;

public class VisualParameters {
    private String color;
    private BigDecimal transparency;
    private int facets;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public BigDecimal getTransparency() {
        return transparency;
    }

    public void setTransparency(BigDecimal transparency) {
        this.transparency = transparency;
    }

    public int getFacets() {
        return facets;
    }

    public void setFacets(int facets) {
        this.facets = facets;
    }
}
