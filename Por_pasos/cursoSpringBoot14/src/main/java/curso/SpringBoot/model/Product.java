package curso.SpringBoot.model;

//Clase Pojo
public class Product {

    /**Usando tipos de datos referenciales al menos en los productos, ayuda al manejar
     * los valores nulos
     */
    private Integer id;

    private String name;

    private Double price;

    private Integer stock;


    public Product() {
    }

    public Product(Integer id, String name, Double price, Integer stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return name;
    }

    public void setNombre(String nombre) {
        this.name = nombre;
    }

    public Double getPrecio() {
        return price;
    }

    public void setPrecio(Double precio) {
        this.price = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
