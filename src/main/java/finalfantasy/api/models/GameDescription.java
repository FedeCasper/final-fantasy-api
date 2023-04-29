package finalfantasy.api.models;

import javax.persistence.*;

@Entity
public class GameDescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    public static final String FF7 = "Final Fantasy VII follows the story of mercenary Cloud Strife, who is hired by the eco-terrorist group AVALANCHE—led by Barret Wallace—to help fight the mega-corporation Shinra Electric Power Company, who attempts to drain the planet's lifeblood as an energy source to further their profits. Apathetic to the cause, Cloud initially fights for personal gain, and for the promise he made to childhood friend Tifa Lockhart. Cloud eventually joins forces with many others to save the planet, which is threatened by Shinra and Cloud's nemesis Sephiroth, and discovers a reason to fight for a cause other than his own.";
    public static final String FF8 = "The story of Final Fantasy VIII follows Squall Leonhart, a cadet in a military academy called Balamb Garden. Squall strives to become a SeeD, a mercenary who can wield magic with the aid of magical beings known as Guardian Forces. Balamb Garden is the only institution in the world to allow the use of the beings, and their use mimics the power of a sorceress, women who can use magic naturally who are both feared and revered. Though initially a loner, Squall's quest has him befriend various people and he learns to depend on them as the SeeDs get involved in a mission of protecting the world.";


}
