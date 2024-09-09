import java.util.*;
import java.text.DecimalFormat;
class Pig {

    private boolean broken;
    private List<Coin> coins;
    private List<Item> items;
    private int volumeMax;

    public Pig(int volumeMax) {
        this.broken = false;
        this.coins = new ArrayList<Coin>();
        this.items = new ArrayList<Item>();
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

        this.coins.add( coin );
        return true;
    }

    public boolean addItem(Item item) throws Exception {
        if (this.broken) {
            throw new Exception("fail: the pig is broken");
        }

        if (item.getVolume() > this.getVolumeRestante()) {
            throw new Exception("fail: the pig is full");
        }

        this.items.add( item );
        return true;
    }

    public boolean breakPig() throws Exception {
        if (this.broken) {
            throw new Exception("fail: the pig is broken");
        }
        
        this.broken = true;
        return true;
    }

    public ArrayList<String> extractCoins() throws Exception {
        if (!this.broken) {
            throw new Exception("fail: you must break the pig first\n[]");
        }

        ArrayList<String> labels = new ArrayList<String>();

        for (Coin c : this.coins) {
            labels.add( c.toString() );
        }
        
        this.coins.clear();
        return labels;
    }

    public ArrayList<String> extractItems() throws Exception {
        if (!this.broken) {
            throw new Exception("fail: you must break the pig first\n[]");
        }

        ArrayList<String> labels = new ArrayList<String>();

        for (Item i : this.items) {
            labels.add( i.toString() );
        }
        
        this.items.clear();
        return labels;
    }

    @Override
    public String toString() {
        DecimalFormat d = new DecimalFormat("0.00");
        String coinsString = this.coins.isEmpty() ? "[]" : this.coins.toString();
        String itemsString = this.items.isEmpty() ? "[]" : this.items.toString();
    
        return coinsString + " : " + d.format(this.getValue()) + "$ : " + this.getVolume() + "/" + this.getVolumeMax() + " : " + (this.broken ? "broken" : "intact");

        
    }

    public int getVolume() {
        if (this.isBroken()) {
            return 0;
        }
        
        int volume = 0;
        for (Coin c : this.coins) {
            volume += c.getVolume();
        }
        for (Item i : this.items) {
            volume += i.getVolume();
        }
        return volume;
    }

    public double getValue() {
        double value = 0;
        for (Coin c : this.coins) {
            value += c.getValue();
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

