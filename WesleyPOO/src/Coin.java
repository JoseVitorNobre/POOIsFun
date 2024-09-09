import java.text.DecimalFormat;

enum Coin {
  C10( 0.10, 1, "C10"  ),
  C25( 0.25, 2, "C25"  ),
  C50( 0.50, 3, "C50"  ),
  C100( 1.00, 4, "C100" );

  private double value;
  private int volume;
  private String label;
  
  private Coin( double value, int volume, String label ) {
      this.value = value;
      this.volume = volume;
      this.label = label;
  }
  
  public double getValue() {
      return this.value;
  }
  public int getVolume() {
      return this.volume;
  }
  public String getLabel() {
      return this.label;
  }
  
  @Override
  public String toString() {
      DecimalFormat d = new DecimalFormat("0.00");
      return  d.format(this.value) + ":" + this.volume;
  }
}