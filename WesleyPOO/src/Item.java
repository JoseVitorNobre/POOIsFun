import java.text.DecimalFormat;

public class Item implements Valuable{

  private String label;
  private int volume;
  private double value;

  public Item(String label, double value, int volume) {
      this.label = label;
      this.value = value;
      this.volume = volume;
  }
  @Override
  public String getLabel() {
      return this.label;
  }
  
  public void setLabel(String label) {
      this.label = label;
  }
  @Override
  public int getVolume() {
      return this.volume;
  }
  @Override
  public double getValue(){
      return this.value;
  }
  
  public void setVolume(int volume) {
      this.volume = volume;
  }

  @Override
  public String toString() {
      DecimalFormat d =  new DecimalFormat("0.00");
      return this.label + ":" + d.format(this.value) + ":" + this.volume;
  }
}