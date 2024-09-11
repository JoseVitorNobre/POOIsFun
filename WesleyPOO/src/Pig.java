import java.util.*;
import java.text.DecimalFormat;

class Pig {

    private boolean broken;
    private List<Valuable> valuables;
    private int volumeMax;

    public Pig(int volumeMax) {
        this.broken = false;
        this.valuables = new ArrayList<>();
        this.volumeMax = volumeMax;
    }

    public Coin createCoin(String valor) {
        switch (valor) {
            case "10":
                return Coin.C10;
            case "25":
                return Coin.C25;
            case "50":
                return Coin.C50;
            case "100":
                return Coin.C100;
            default:
                return null;
        }
    }

    public boolean addCoin(Coin coin) throws Exception {
        if (this.broken) {
            throw new Exception("fail: the pig is broken");
        }

        if (coin.getVolume() > this.getVolumeRestante()) {
            throw new Exception("fail: the pig is full");
        }

        this.valuables.add(coin);
        return true;
    }

    public boolean addItem(Item item) throws Exception {
        if (this.broken) {
            throw new Exception("fail: the pig is broken");
        }

        if (item.getVolume() > this.getVolumeRestante()) {
            throw new Exception("fail: the pig is full");
        }

        this.valuables.add(item);
        return true;
    }

    public boolean breakPig() throws Exception {
        if (this.broken) {
            throw new Exception("fail: the pig is already broken");
        }

        this.broken = true;
        return true;
    }

    public ArrayList<String> extractItems() throws Exception {
        if (!this.broken) {
            throw new Exception("fail: you must break the pig first");
        }

        ArrayList<String> items = new ArrayList<>();
        Iterator<Valuable> iterator = this.valuables.iterator();
        while (iterator.hasNext()) {
            Valuable v = iterator.next();
            if (v instanceof Item) {
                items.add(v.toString());
                iterator.remove(); 
            }
        }

        return items;
    }

    public ArrayList<String> extractCoins() throws Exception {
        if (!this.broken) {
            throw new Exception("fail: you must break the pig first");
        }

        ArrayList<String> coins = new ArrayList<>();
        Iterator<Valuable> iterator = this.valuables.iterator();
        while (iterator.hasNext()) {
            Valuable v = iterator.next();
            if (v instanceof Coin) {
                coins.add(v.toString());
                iterator.remove(); 
            }
        }

        return coins;
    }

    @Override
    public String toString() {
        DecimalFormat d = new DecimalFormat("0.00");
        String valuablesString = this.valuables.isEmpty() ? "[]" : this.valuables.toString();
        
        return valuablesString + " : " + d.format(this.getValue()) + "$ : " + this.getVolume() + "/" + this.getVolumeMax() + " : " + (this.broken ? "broken" : "intact");
    }

    public int getVolume() {
        if (this.isBroken()) {
            return 0;
        }

        int volume = 0;
        for (Valuable v : this.valuables) {
            volume += v.getVolume();
        }
        return volume;
    }

    public double getValue() {
        double value = 0;
        for (Valuable v : this.valuables) {
            value += v.getValue();
        }
        return value;
    }

    public int getVolumeMax() {
        return this.volumeMax;
    }

    public int getVolumeRestante() {
        return this.getVolumeMax() - this.getVolume();
    }

    public boolean isBroken() {
        return this.broken;
    }
}
