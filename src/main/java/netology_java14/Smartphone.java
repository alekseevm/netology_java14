package netology_java14;;
public class Smartphone extends Product {
    private String name;
    private String supplierName;

    public Smartphone(String name, String supplierName, int id, int price) {
        super(id,name, price);
        this.name = name;
        this.supplierName = supplierName;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }


}
