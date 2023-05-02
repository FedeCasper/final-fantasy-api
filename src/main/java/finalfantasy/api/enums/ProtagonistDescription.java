package finalfantasy.api.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ProtagonistDescription {

        // FINAL FANTASY 7
        CLOUD("is the main protagonist, introducing himself as a former member of SOLDIER who now operates as a mercenary. Cloud is caught up in the actions of eco-terrorist group AVALANCHE, and although initially uncaring toward their mission, he has a change of heart when he begins to discover his shrouded past."),
        TIFA("Tifa grew up with Cloud in Nibelheim, but lost contact with him years ago. When she meets him again, she convinces him to join Avalanche to fight the Shinra Electric Power Company, whom she bears hatred for due to the destruction of their hometown. She supports Cloud as his comrade and helps him and his allies fight Sephiroth. Tifa is reserved, moral, and empathic, acting as a motherly figure towards her allies when providing encouragement and emotional support. She also serves as the voice of reason grounding them to think things through and do the right thing."),
        BARRET("Barret Wallace is a major recurring character in the Final Fantasy VII series. He is a playable character in Final Fantasy VII and Final Fantasy VII Remake, and has supporting roles in other titles. He is the leader of a cell of the eco-terrorist group Avalanche, trying to prevent Shinra Electric Power Company from using mako, the life source of the planet,"),

        // FINAL FANTASY 8
        SQUALL("The taciturn and reluctant hero. A lone wolf, he is known as a fearsome warrior in training, specializing in the rare gunblade. Though aloof and seemingly detached, he grows to appreciate his friends and love Rinoa, evolving into a model leader for his peers. His tagline is: Whatever."),
        RINOA("A beautiful and spirited young woman who abandoned a privileged lifestyle to join a resistance movement. Owns a faithful pet dog, Angelo."),
        ZELL("A Balamb Garden student with unsurpassed martial arts skill who has a passion for hot dogs. In spite of his loud-mouthed attitude, Zell strives to be a model cadet."),
        IRVINE("An expert gunman and consummate ladies' man. Despite his facade, Irvine is determined, caring, and sensitive, and the only one who knows the hidden connection between all the members of the group."),
        SELPHIE("A spunky young woman with a carefree spirit. Transferred from Trabia Garden, she tends to overcompensate her sad past with a happy disposition."),
        QUISTIS("A top-notch member of SeeD who serves as Squall's instructor. Though beautiful and popular, she is insecure. She overcomes this through her caring for Squall and her friends."),
        SEIFER("Squall's rival in Garden and a fellow gunblade-wielder. His dream is to become a sorceress's knight as per fabled legends."),
        EDEA("Edea Kramer, also known as Sorceress Edea, or Matron (ママ先生, Mama-Sensei?), is an antagonist and a temporary-playable character from Final Fantasy VIII. She is a mysterious woman appointed as ambassador of Galbadia. She is a sorceress with mystical powers."),
        LAGUNA("A passionate man whose pen is truly mightier than the sword. Despite disliking violence, he takes up arms in the face of injustice or when his loved ones are in peril."),
        KIROS("A Galbadian soldier who wields katals in battle. An intellectual and cool person, he is Laguna's best friend and the voice of reason within the group of friends."),
        WARD("A Galbadian soldier who wields a harpoon. Though intimidating at first glance, he is a caring individual and a most loyal friend to Laguna."),
        ADEL("Sorceress Adel is a minor antagonist in Final Fantasy VIII. She is a powerful sorceress who once ruled Esthar and was feared the world over. The Sorceress War was fought against Adel and her nation."),
        ULTIMECIA("Ultimecia is the main antagonist in Final Fantasy VIII. A powerful sorceress, her ultimate goal is to compress all time and space, in essence making herself one with existence as a whole to become \"a living god\". She knows some of the most powerful magic witnessed, able to manipulate others to make them bend to her will, and to manifest and give life to subconscious thoughts and inanimate objects.");

        private String description;

        ProtagonistDescription(String description){
                this.description = description;
        }

        @JsonValue
        public String getDescription() {
                return description;
        }

}
