package entity;



import javax.persistence.*;

@Entity
@Table (name = "price_product")
public class PriceList {
    @Id
    @Column (name = "id")
    private int id;
    @Column (name = "provider")
    private String provider;
    @Column (name = "code_product")
    private int codeProduct;
    @Column (name = "name_product")
    private String nameProduct;
    @Column (name = "unit")
    private String unit;
    @Column (name = "price")
    private double price;
    @Column (name = "date_update_price")
    private String dateUpdatePrice;

    public PriceList() {
    }

    public PriceList(String provider, int codeProduct, String nameProduct, String unit, float price, String dateUpdatePrice) {
        this.provider = provider;
        this.codeProduct = codeProduct;
        this.nameProduct = nameProduct;
        this.unit = unit;
        this.price = price;
        this.dateUpdatePrice = dateUpdatePrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public int getCodeProduct() {
        return codeProduct;
    }

    public void setCodeProduct(int codeProduct) {
        this.codeProduct = codeProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDateUpdatePrice() {
        return dateUpdatePrice;
    }

    public void setDateUpdatePrice(String dateUpdatePrice) {
        this.dateUpdatePrice = dateUpdatePrice;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", Постащик: '" + provider + '\'' +
                ", Код товара: " + codeProduct +
                ", Наименование товара: '" + nameProduct + '\'' +
                ", Еденица измерения: '" + unit + '\'' +
                ", Цена: " + price +
                ", Дата обновления цены: '" + dateUpdatePrice + '\'' +
                "\n";
    }
}
