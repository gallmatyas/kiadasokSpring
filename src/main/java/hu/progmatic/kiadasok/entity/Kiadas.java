package hu.progmatic.kiadasok.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "kiadasok")
public class Kiadas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "hely")
    private String hely;

    @Column(name = "osszeg")
    private int osszeg;

    @ManyToOne
    @JoinColumn(name = "ember_id")
    private Ember ember;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHely() {
        return hely;
    }

    public void setHely(String hely) {
        this.hely = hely;
    }

    public int getOsszeg() {
        return osszeg;
    }

    public void setOsszeg(int osszeg) {
        this.osszeg = osszeg;
    }

    public Ember getEmber() {
        return ember;
    }

    public void setEmber(Ember ember) {
        this.ember = ember;
    }

    public Kiadas(int id, String hely, int osszeg, Ember ember) {
        this.id = id;
        this.hely = hely;
        this.osszeg = osszeg;
        this.ember = ember;
    }
    public Kiadas() {

    }
}
