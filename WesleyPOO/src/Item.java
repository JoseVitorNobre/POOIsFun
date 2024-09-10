
public class Item implements Valuable{

  private String label;
  private int volume;

  public Item(String label, int volume) {
      this.label = label;
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
    return 0.00;
  }
  public void setVolume(int volume) {
      this.volume = volume;
  }

  @Override
  public String toString() {
      return this.label + ":" + this.volume;
  }
}