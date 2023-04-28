package finalfantasy.api.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Enemy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    private String name;
    private String origin;
    private String strengths;
    private String weaknesses;
    private String image;

    public Enemy() {
    }

    public Enemy(String name, String origin, String strengths, String weaknesses, String image) {
        this.name = name;
        this.origin = origin;
        this.strengths = strengths;
        this.weaknesses = weaknesses;
        this.image = image;
    }

}
