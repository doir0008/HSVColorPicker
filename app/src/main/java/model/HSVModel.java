/**
 *  HSV Color Picker App - adjustable hue, saturation, value/lightness channels with
 *  a select range of color quick buttons.
 *  @author Ryan Doiron (doir0008@algonquinlive.com)
 *  */
package model;

import java.util.Observable;

public class HSVModel extends Observable {

    // CLASS VARIABLES
    public static final Float MAX_H = 360.0f;
    public static final Float MAX_S = 1.f;
    public static final Float MAX_V = 1.f;
    public static final Float MIN_H = 0f;
    public static final Float MIN_S = 0f;
    public static final Float MIN_V = 0f;

    // INSTANCE VARIABLES
    private Float hue;
    private Float saturation;
    private Float value;

    /**
     * No argument constructor.
     *
     * Instantiate a new instance of this class, and
     * initialize hue, saturation and value/lightness to max values.
     */
    public HSVModel() {
        this( MIN_H, MIN_S, MIN_V );
    }

    /**
     * Convenience constructor.
     *
     * @param hue - starting hue value
     * @param saturation - starting saturation value
     * @param value - starting value/lightness value
     */
    public HSVModel(Float hue, Float saturation, Float value) {
        super();
        this.hue = hue;
        this.saturation  = saturation;
        this.value = value;
    }

    // convenience color keyword swatch setters
    public void asBlack()   { this.setHSV( 0.0f, 0.0f, 0.0f ); }
    public void asRed()    { this.setHSV( 0.0f, 1.0f, 1.0f ); }
    public void asLime()    { this.setHSV( 120.0f, 1.0f, 1.0f ); }
    public void asBlue()   { this.setHSV( 240.0f, 1.0f, 1.0f ); }
    public void asYellow() { this.setHSV( 60.0f, 1.0f, 1.0f ); }
    public void asCyan()     { this.setHSV( 180.0f, 1.0f, 1.0f ); }
    public void asMagenta()   { this.setHSV( 300.0f, 1.0f, 1.0f ); }
    public void asSilver()  { this.setHSV( 0.0f, 0.0f, 0.75f ); }
    public void asGray()  { this.setHSV( 0.0f, 0.0f, 0.5f ); }
    public void asMaroon()  { this.setHSV( 0.0f, 1.0f, 0.5f ); }
    public void asOlive()  { this.setHSV( 60.0f, 1.0f, 0.5f ); }
    public void asGreen()  { this.setHSV( 120.0f, 1.0f, 0.5f ); }
    public void asPurple()  { this.setHSV( 300.0f, 1.0f, 0.5f ); }
    public void asTeal()  { this.setHSV( 180.0f, 1.0f, 0.5f ); }
    public void asNavy()  { this.setHSV( 240.0f, 1.0f, 0.5f ); }

    // GETTERS
    public Float getHue() { return hue; }
    public Float getSaturation() { return saturation; }
    public Float getValue() { return value; }

    // SETTERS
    public void setHue(Float hue) {
        this.hue = hue;
        this.updateObservers();
    }

    public void setSaturation(Float saturation) {
        this.saturation = saturation;
        this.updateObservers();
    }

    public void setValue(Float value) {
        this.value = value;
        this.updateObservers();
    }

    // Convenient setter: set H, S, V
    public void setHSV(Float hue, Float saturation, Float value) {
        this.hue = hue;
        this.saturation = saturation;
        this.value = value;
        this.updateObservers();
    }

    // the model has changed!
    // broadcast the update method to all registered observers
    private void updateObservers() {
        this.setChanged();
        this.notifyObservers();
    }
}
